/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;
import sun.util.calendar.BaseCalendar;


/**
 *
 * @author fawad
 */
public class reservation extends javax.swing.JFrame {
    //variables
    int guest_id;
  
    boolean al_on_off=true;
    boolean dl_on_off=true;
    int timerun =0;
    ResultSet rs =null;
    PreparedStatement pst=null;
    Connection con =null;
    String a="";
    
    
    
    //methods
    //1
    private String getdate(String date){
    String d= date;
    String Date=d.substring(0,12);
    return Date;
    
    }
    //2
    private String getcheckbox(JCheckBox c){
    String a=null;
    if(c.isSelected()==true)
    
     a=c.getText();
    return a;
    }
    //3
    private void setColumn(JTable tabel){
        if(tabel.getRowCount()>0){
            tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (int column = 0; column < tabel.getColumnCount(); column++)
        {
        TableColumn tableColumn = tabel.getColumnModel().getColumn(column);
        int preferredWidth = tableColumn.getMinWidth();
        int maxWidth = tableColumn.getMaxWidth();
 
         for (int row = 0; row < tabel.getRowCount(); row++)
    {   
        TableCellRenderer cellRenderer = tabel.getCellRenderer(row, column);
        Component c = tabel.prepareRenderer(cellRenderer, row, column);
        int width = c.getPreferredSize().width + tabel.getIntercellSpacing().width;
        preferredWidth = Math.max(preferredWidth, width);
 
    }
 
    tableColumn.setPreferredWidth( preferredWidth+30);
}
        }
        else{
            tabel.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        }
    }
    //4
    private void fillCombo(String c,JComboBox j){
    try{
        
    String sql="select * from rooms";
    pst=con.prepareStatement(sql);
    rs=pst.executeQuery();
    
    DefaultComboBoxModel model = new DefaultComboBoxModel();
    while(rs.next())
    {
    String add = rs.getString(c);
    if(model.getIndexOf(add)==-1)
    {
    model.addElement(add);
    }
    j.setModel(model);
    }
    
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    
    }
    //5
    private boolean checkboolean(int c){
    if(c==0)
      return false;
    else
      return true;   
    }
    //6
    private long datediff(String a,String b){
    SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
    String inputString1 = a;
    String inputString2 = b;
    long days=0;
try {
          java.util.Date date1 = myFormat.parse(inputString1);
          java.util.Date date2 = myFormat.parse(inputString2);
    long diff = date2.getTime() - date1.getTime();
      days =TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
     
} catch (ParseException e) {
    e.printStackTrace();
}
    
    return days;
    
    }
   //6
    
   private boolean  checkDatefield (JDateChooser j,String s){
      String b="";
      b =((JTextField)j.getDateEditor().getUiComponent()).getText();
     
      if("".equals(b))
      {
      JOptionPane.showMessageDialog(null,"Please Select  "+s+" !","Guide",JOptionPane.WARNING_MESSAGE);
      
      return false;
      } 
      else{
      
     
      return true;
      }
   }
   
   //7
   private boolean checkcBox(JComboBox c){
   if(c.getSelectedIndex()==-1)
   {
 JOptionPane.showMessageDialog(null,"Please Select Room Type !","Guide",JOptionPane.WARNING_MESSAGE);

   return false;
   }
   else{
   return true;
   }
   }
 
    
    public reservation() {
        initComponents();
       Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
       this.setSize(d.width, d.height);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       bg_image.setSize(d.width,d.height);
       
       res_jtab.removeAll();
       
        con=DatabaseManager.getconnect();
        
        new Thread()
        {
            
            @Override
                public void run()
                {
                    
                    while (timerun == 0)
                    {  
                        
                        
                    Calendar cal= new GregorianCalendar();
                    
                    int _day=cal.get(Calendar.DAY_OF_MONTH);
                    int _month=cal.get(Calendar.MONTH);
                    int _year=cal.get(Calendar.YEAR);
                    int hour=cal.get(Calendar.HOUR);
                    int min =cal.get(Calendar.MINUTE);
                    int sec = cal.get(Calendar.SECOND);
                    int am_pm= cal.get(Calendar.AM_PM);
        
                    String day_night= "";
        
                    if(am_pm==1)
            
                    day_night="PM";
                    
                    else
        
                    day_night="AM";
                        
                    
                    String time = hour+":"+min+":"+sec;
                    String time2= ""+day_night;
                    month.setText(Integer.toString(_month+1));
                    day.setText(Integer.toString(_day));
                    year.setText(Integer.toString(_year));

 
                    
                    clock.setText(time);
                    clock2.setText(time2);
        
                    }
                }
        
        }.start();

        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body_panel = new javax.swing.JPanel();
        side_panel = new javax.swing.JPanel();
        side_btn = new javax.swing.JPanel();
        room_managment = new javax.swing.JLabel();
        check_availability = new javax.swing.JLabel();
        arrival_list = new javax.swing.JLabel();
        departure_list = new javax.swing.JLabel();
        reservation = new javax.swing.JLabel();
        header_panel = new javax.swing.JPanel();
        admin_label = new javax.swing.JLabel();
        adm_label = new javax.swing.JLabel();
        btn_panel = new javax.swing.JPanel();
        close_label = new javax.swing.JLabel();
        mini_label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        time_panel = new javax.swing.JPanel();
        month = new javax.swing.JLabel();
        day = new javax.swing.JLabel();
        year = new javax.swing.JLabel();
        clock = new javax.swing.JLabel();
        clock2 = new javax.swing.JLabel();
        time_label = new javax.swing.JLabel();
        back_label = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        center_outer = new javax.swing.JPanel();
        center_inner = new javax.swing.JPanel();
        res_jtab = new javax.swing.JTabbedPane();
        rm_tab = new javax.swing.JPanel();
        rm_label1 = new javax.swing.JLabel();
        rm_form = new javax.swing.JPanel();
        rm_label3 = new javax.swing.JLabel();
        rm_label4 = new javax.swing.JLabel();
        rm_label5 = new javax.swing.JLabel();
        rm_label6 = new javax.swing.JLabel();
        rm_roomNo = new javax.swing.JTextField();
        rm_roomType = new javax.swing.JTextField();
        rm_bedType = new javax.swing.JComboBox();
        rm_label8 = new javax.swing.JLabel();
        rm_rate = new javax.swing.JTextField();
        rm_roomTypeL = new javax.swing.JLabel();
        rm_rateL = new javax.swing.JLabel();
        rm_roomNoL = new javax.swing.JLabel();
        rm_persons = new javax.swing.JSpinner();
        rm_label7 = new javax.swing.JLabel();
        rm_bar = new javax.swing.JCheckBox();
        rm_led = new javax.swing.JCheckBox();
        rm_window = new javax.swing.JCheckBox();
        rm_fridge = new javax.swing.JCheckBox();
        rm_ac = new javax.swing.JCheckBox();
        rm_wifi = new javax.swing.JCheckBox();
        rm_tea = new javax.swing.JCheckBox();
        rm_tele = new javax.swing.JCheckBox();
        rm_save = new javax.swing.JLabel();
        rm_reset = new javax.swing.JLabel();
        rm_msg = new javax.swing.JLabel();
        rm_error1 = new javax.swing.JLabel();
        rm_error2 = new javax.swing.JLabel();
        rm_error3 = new javax.swing.JLabel();
        rm_error4 = new javax.swing.JLabel();
        rm_closeBtn = new javax.swing.JLabel();
        rm_tablePanel = new javax.swing.JPanel();
        rm_tableScrolPane = new javax.swing.JScrollPane();
        rm_tabel = new javax.swing.JTable();
        rm_deleteBtn = new javax.swing.JLabel();
        rm_label2 = new javax.swing.JLabel();
        rm_refreshBtn = new javax.swing.JLabel();
        rm_bgImg = new javax.swing.JLabel();
        ca_tab = new javax.swing.JPanel();
        ca_closeBtn = new javax.swing.JLabel();
        ca_formPanel = new javax.swing.JPanel();
        ca_label5 = new javax.swing.JLabel();
        ca_dDate = new com.toedter.calendar.JDateChooser();
        ca_roomType = new javax.swing.JComboBox();
        ca_label3 = new javax.swing.JLabel();
        ca_label4 = new javax.swing.JLabel();
        ca_aDate = new com.toedter.calendar.JDateChooser();
        ca_searchBtn = new javax.swing.JLabel();
        ca_label1 = new javax.swing.JLabel();
        ca_tablePanel = new javax.swing.JPanel();
        ca_tablePane = new javax.swing.JScrollPane();
        ca_table = new javax.swing.JTable();
        ca_label2 = new javax.swing.JLabel();
        ca_refershBtn = new javax.swing.JLabel();
        ca_bgImg = new javax.swing.JLabel();
        ar_tab = new javax.swing.JPanel();
        ar_formPanel = new javax.swing.JPanel();
        ar_sep3 = new javax.swing.JSeparator();
        ar_label2 = new javax.swing.JLabel();
        ar_label3 = new javax.swing.JLabel();
        ar_label4 = new javax.swing.JLabel();
        ar_label7 = new javax.swing.JLabel();
        ar_label8 = new javax.swing.JLabel();
        ar_label6 = new javax.swing.JLabel();
        ar_label15 = new javax.swing.JLabel();
        ar_roomNo = new javax.swing.JComboBox();
        ar_dep_date = new com.toedter.calendar.JDateChooser();
        ar_nic_txt = new javax.swing.JTextField();
        ar_gender_cbox = new javax.swing.JComboBox();
        ar_label10 = new javax.swing.JLabel();
        ar_sep1 = new javax.swing.JSeparator();
        ar_label12 = new javax.swing.JLabel();
        ar_label13 = new javax.swing.JLabel();
        ar_label16 = new javax.swing.JLabel();
        ar_label17 = new javax.swing.JLabel();
        ar_arrival_date = new com.toedter.calendar.JDateChooser();
        ar_firstName_txt = new javax.swing.JTextField();
        ar_lastName_txt = new javax.swing.JTextField();
        ar_contact_txt = new javax.swing.JTextField();
        ar_sep2 = new javax.swing.JSeparator();
        ar_saveBtn = new javax.swing.JLabel();
        ar_resetBtn = new javax.swing.JLabel();
        ar_txtLabel9 = new javax.swing.JLabel();
        ar_txtLabel5 = new javax.swing.JLabel();
        ar_txtLabel6 = new javax.swing.JLabel();
        ar_txtLabel10 = new javax.swing.JLabel();
        ar_label5 = new javax.swing.JLabel();
        ar_user_txt = new javax.swing.JTextField();
        ar_txtLabel3 = new javax.swing.JLabel();
        ar_label9 = new javax.swing.JLabel();
        ar_password_txt = new javax.swing.JTextField();
        ar_txtLabel2 = new javax.swing.JLabel();
        ar_scrollPane = new javax.swing.JScrollPane();
        ar_add_txt = new javax.swing.JTextArea();
        ar_label19 = new javax.swing.JLabel();
        ar_roomType = new javax.swing.JComboBox();
        ar_label14 = new javax.swing.JLabel();
        ar_nat_txt = new javax.swing.JTextField();
        ar_txtLabel7 = new javax.swing.JLabel();
        ar_pickup_cbox = new javax.swing.JComboBox();
        ar_label18 = new javax.swing.JLabel();
        ar_label11 = new javax.swing.JLabel();
        ar_guestId = new javax.swing.JTextField();
        ar_txtLabel4 = new javax.swing.JLabel();
        ar_persons_spin = new javax.swing.JSpinner();
        ar_checkRooms_label = new javax.swing.JLabel();
        ar_booking_date = new javax.swing.JTextField();
        ar_txtLabel1 = new javax.swing.JLabel();
        ar_label1 = new javax.swing.JLabel();
        ar_closeBtn = new javax.swing.JLabel();
        ar_rate_panel = new javax.swing.JPanel();
        ar_label20 = new javax.swing.JLabel();
        ar_label23 = new javax.swing.JLabel();
        ar_rate_txt = new javax.swing.JTextField();
        ar_label21 = new javax.swing.JLabel();
        ar_total_txt = new javax.swing.JTextField();
        ar_rec_amount = new javax.swing.JTextField();
        ar_label24 = new javax.swing.JLabel();
        ar_balance_txt = new javax.swing.JTextField();
        ar_label25 = new javax.swing.JLabel();
        ar_refersh = new javax.swing.JLabel();
        ar_msg_label = new javax.swing.JLabel();
        ar_bgImage = new javax.swing.JLabel();
        al_tab = new javax.swing.JPanel();
        al_label1 = new javax.swing.JLabel();
        al_roomType = new javax.swing.JComboBox();
        al_label3 = new javax.swing.JLabel();
        al_fromDate = new com.toedter.calendar.JDateChooser();
        al_label4 = new javax.swing.JLabel();
        al_label5 = new javax.swing.JLabel();
        al_toDate = new com.toedter.calendar.JDateChooser();
        al_searchBtn = new javax.swing.JLabel();
        al_closeBtn = new javax.swing.JLabel();
        al_todayBtn = new javax.swing.JLabel();
        al_tablepane = new javax.swing.JScrollPane();
        al_table = new javax.swing.JTable();
        al_label6 = new javax.swing.JLabel();
        al_postponeBtn = new javax.swing.JLabel();
        al_cancelBtn = new javax.swing.JLabel();
        ar_refersh1 = new javax.swing.JLabel();
        al_checkInBtn = new javax.swing.JLabel();
        al_bgImg = new javax.swing.JLabel();
        dl_tab = new javax.swing.JPanel();
        dl_label1 = new javax.swing.JLabel();
        dl_roomType = new javax.swing.JComboBox();
        dl_label3 = new javax.swing.JLabel();
        dl_fromDate = new com.toedter.calendar.JDateChooser();
        dl_label4 = new javax.swing.JLabel();
        dl_label5 = new javax.swing.JLabel();
        dl_toDate = new com.toedter.calendar.JDateChooser();
        dl_searchBtn = new javax.swing.JLabel();
        dl_closeBtn = new javax.swing.JLabel();
        dl_todayBtn = new javax.swing.JLabel();
        dl_tablepane = new javax.swing.JScrollPane();
        dl_table = new javax.swing.JTable();
        dl_label6 = new javax.swing.JLabel();
        dl_postponeBtn = new javax.swing.JLabel();
        ar_refersh2 = new javax.swing.JLabel();
        dl_checkoutBtn = new javax.swing.JLabel();
        al_bgImg1 = new javax.swing.JLabel();
        footer_panel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        bg_image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        body_panel.setOpaque(false);
        body_panel.setLayout(new java.awt.BorderLayout());

        side_panel.setOpaque(false);

        side_btn.setOpaque(false);

        room_managment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/room1.jpg"))); // NOI18N
        room_managment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        room_managment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                room_managmentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                room_managmentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                room_managmentMouseExited(evt);
            }
        });

        check_availability.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/check1.jpg"))); // NOI18N
        check_availability.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        check_availability.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_availabilityMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                check_availabilityMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                check_availabilityMouseExited(evt);
            }
        });

        arrival_list.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/arrival1.jpg"))); // NOI18N
        arrival_list.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        arrival_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arrival_listMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                arrival_listMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                arrival_listMouseExited(evt);
            }
        });

        departure_list.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/departure1.jpg"))); // NOI18N
        departure_list.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        departure_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                departure_listMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                departure_listMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                departure_listMouseExited(evt);
            }
        });

        reservation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/add_res1.jpg"))); // NOI18N
        reservation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reservation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reservationMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reservationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reservationMouseExited(evt);
            }
        });

        javax.swing.GroupLayout side_btnLayout = new javax.swing.GroupLayout(side_btn);
        side_btn.setLayout(side_btnLayout);
        side_btnLayout.setHorizontalGroup(
            side_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(room_managment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(check_availability, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(arrival_list, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(reservation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
            .addComponent(departure_list, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );
        side_btnLayout.setVerticalGroup(
            side_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_btnLayout.createSequentialGroup()
                .addComponent(reservation)
                .addGap(18, 18, 18)
                .addComponent(room_managment)
                .addGap(18, 18, 18)
                .addComponent(check_availability)
                .addGap(18, 18, 18)
                .addComponent(arrival_list)
                .addGap(18, 18, 18)
                .addComponent(departure_list)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout side_panelLayout = new javax.swing.GroupLayout(side_panel);
        side_panel.setLayout(side_panelLayout);
        side_panelLayout.setHorizontalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(side_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        side_panelLayout.setVerticalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(side_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        body_panel.add(side_panel, java.awt.BorderLayout.LINE_START);

        header_panel.setMaximumSize(new java.awt.Dimension(1024, 165));
        header_panel.setMinimumSize(new java.awt.Dimension(1024, 165));
        header_panel.setOpaque(false);

        admin_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/admin.png"))); // NOI18N

        adm_label.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        adm_label.setText("Admin");

        btn_panel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_panel.setOpaque(false);
        btn_panel.setPreferredSize(new java.awt.Dimension(80, 80));
        btn_panel.setLayout(null);

        close_label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close_labelMouseClicked(evt);
            }
        });
        btn_panel.add(close_label);
        close_label.setBounds(135, 2, 30, 35);

        mini_label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mini_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mini_labelMouseClicked(evt);
            }
        });
        btn_panel.add(mini_label);
        mini_label.setBounds(80, 0, 35, 35);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/custom_frame2.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_panel.add(jLabel1);
        jLabel1.setBounds(10, 0, 180, 40);

        time_panel.setLayout(null);

        month.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N
        month.setForeground(new java.awt.Color(3, 201, 169));
        month.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        month.setText("15");
        time_panel.add(month);
        month.setBounds(80, 70, 40, 30);

        day.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N
        day.setForeground(new java.awt.Color(3, 201, 169));
        day.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        day.setText("25");
        time_panel.add(day);
        day.setBounds(10, 70, 40, 30);

        year.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N
        year.setForeground(new java.awt.Color(3, 201, 169));
        year.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        year.setText("2014");
        time_panel.add(year);
        year.setBounds(143, 70, 60, 30);

        clock.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        clock.setForeground(new java.awt.Color(3, 201, 169));
        clock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clock.setText("7:25:47");
        time_panel.add(clock);
        clock.setBounds(10, 10, 120, 40);

        clock2.setFont(new java.awt.Font("DS-Digital", 0, 48)); // NOI18N
        clock2.setForeground(new java.awt.Color(3, 201, 169));
        clock2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clock2.setText("aM");
        time_panel.add(clock2);
        clock2.setBounds(124, 4, 70, 50);

        time_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/time1.jpg"))); // NOI18N
        time_label.setText("asdad");
        time_panel.add(time_label);
        time_label.setBounds(0, 0, 200, 110);

        back_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/back_label.png"))); // NOI18N
        back_label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_labelMouseClicked(evt);
            }
        });

        logout.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/logout.png"))); // NOI18N
        logout.setText("logout");
        logout.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout header_panelLayout = new javax.swing.GroupLayout(header_panel);
        header_panel.setLayout(header_panelLayout);
        header_panelLayout.setHorizontalGroup(
            header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_panelLayout.createSequentialGroup()
                .addGroup(header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(header_panelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(back_label))
                    .addGroup(header_panelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(admin_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adm_label, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(392, 392, 392)
                .addComponent(time_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 341, Short.MAX_VALUE)
                .addGroup(header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header_panelLayout.createSequentialGroup()
                        .addComponent(logout)
                        .addContainerGap())))
        );
        header_panelLayout.setVerticalGroup(
            header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header_panelLayout.createSequentialGroup()
                        .addComponent(admin_label)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header_panelLayout.createSequentialGroup()
                        .addComponent(adm_label, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
            .addGroup(header_panelLayout.createSequentialGroup()
                .addGroup(header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(header_panelLayout.createSequentialGroup()
                        .addComponent(btn_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(logout))
                    .addComponent(time_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        body_panel.add(header_panel, java.awt.BorderLayout.PAGE_START);

        center_outer.setOpaque(false);

        center_inner.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        center_inner.setAutoscrolls(true);
        center_inner.setMaximumSize(new java.awt.Dimension(950, 730));
        center_inner.setMinimumSize(new java.awt.Dimension(950, 730));
        center_inner.setOpaque(false);

        res_jtab.setPreferredSize(new java.awt.Dimension(945, 600));

        rm_tab.setLayout(null);

        rm_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        rm_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rm_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/ar_header.png"))); // NOI18N
        rm_tab.add(rm_label1);
        rm_label1.setBounds(0, 20, 210, 40);

        rm_form.setOpaque(false);
        rm_form.setLayout(null);

        rm_label3.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        rm_label3.setText("Room No ");
        rm_form.add(rm_label3);
        rm_label3.setBounds(20, 10, 100, 40);

        rm_label4.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        rm_label4.setText("Room Type");
        rm_form.add(rm_label4);
        rm_label4.setBounds(20, 60, 110, 40);

        rm_label5.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        rm_label5.setText("Rate ");
        rm_form.add(rm_label5);
        rm_label5.setBounds(20, 110, 90, 40);

        rm_label6.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        rm_label6.setText("Bed Type ");
        rm_form.add(rm_label6);
        rm_label6.setBounds(20, 160, 90, 40);

        rm_roomNo.setBackground(new java.awt.Color(123, 211, 172));
        rm_roomNo.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        rm_roomNo.setBorder(null);
        rm_roomNo.setOpaque(false);
        rm_roomNo.setSelectionColor(new java.awt.Color(3, 201, 169));
        rm_form.add(rm_roomNo);
        rm_roomNo.setBounds(140, 20, 130, 23);

        rm_roomType.setBackground(new java.awt.Color(123, 211, 172));
        rm_roomType.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        rm_roomType.setBorder(null);
        rm_roomType.setOpaque(false);
        rm_roomType.setSelectionColor(new java.awt.Color(3, 201, 169));
        rm_form.add(rm_roomType);
        rm_roomType.setBounds(140, 70, 130, 23);

        rm_bedType.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        rm_bedType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single", "Double", "Triple", "Quad", "Twin", "King", "Queen" }));
        rm_form.add(rm_bedType);
        rm_bedType.setBounds(140, 170, 130, 25);

        rm_label8.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        rm_label8.setText("Facilities");
        rm_form.add(rm_label8);
        rm_label8.setBounds(20, 270, 90, 40);

        rm_rate.setBackground(new java.awt.Color(123, 211, 172));
        rm_rate.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        rm_rate.setBorder(null);
        rm_rate.setSelectionColor(new java.awt.Color(3, 201, 169));
        rm_form.add(rm_rate);
        rm_rate.setBounds(140, 120, 130, 23);

        rm_roomTypeL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        rm_form.add(rm_roomTypeL);
        rm_roomTypeL.setBounds(130, 60, 150, 40);

        rm_rateL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        rm_form.add(rm_rateL);
        rm_rateL.setBounds(130, 110, 150, 40);

        rm_roomNoL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        rm_form.add(rm_roomNoL);
        rm_roomNoL.setBounds(130, 10, 150, 40);

        rm_persons.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        rm_persons.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        rm_persons.setAutoscrolls(true);
        rm_persons.setEditor(new JSpinner.DefaultEditor(rm_persons));
        rm_form.add(rm_persons);
        rm_persons.setBounds(140, 220, 130, 25);

        rm_label7.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        rm_label7.setText("Persons");
        rm_form.add(rm_label7);
        rm_label7.setBounds(20, 210, 90, 40);

        rm_bar.setFont(new java.awt.Font("Kalinga", 0, 12)); // NOI18N
        rm_bar.setText("Minibar");
        rm_bar.setOpaque(false);
        rm_form.add(rm_bar);
        rm_bar.setBounds(240, 360, 70, 29);

        rm_led.setFont(new java.awt.Font("Kalinga", 0, 12)); // NOI18N
        rm_led.setText("LED T.V ");
        rm_led.setOpaque(false);
        rm_form.add(rm_led);
        rm_led.setBounds(120, 270, 80, 29);

        rm_window.setFont(new java.awt.Font("Kalinga", 0, 12)); // NOI18N
        rm_window.setText("Window Open");
        rm_window.setOpaque(false);
        rm_window.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rm_windowActionPerformed(evt);
            }
        });
        rm_form.add(rm_window);
        rm_window.setBounds(120, 300, 105, 29);

        rm_fridge.setFont(new java.awt.Font("Kalinga", 0, 12)); // NOI18N
        rm_fridge.setText("Fridge");
        rm_fridge.setOpaque(false);
        rm_form.add(rm_fridge);
        rm_fridge.setBounds(120, 330, 61, 29);

        rm_ac.setFont(new java.awt.Font("Kalinga", 0, 12)); // NOI18N
        rm_ac.setText("A.C");
        rm_ac.setOpaque(false);
        rm_form.add(rm_ac);
        rm_ac.setBounds(120, 360, 45, 29);

        rm_wifi.setFont(new java.awt.Font("Kalinga", 0, 12)); // NOI18N
        rm_wifi.setText("Personal Wifi");
        rm_wifi.setOpaque(false);
        rm_form.add(rm_wifi);
        rm_wifi.setBounds(240, 270, 110, 29);

        rm_tea.setFont(new java.awt.Font("Kalinga", 0, 12)); // NOI18N
        rm_tea.setText("Coffee/tea Maker");
        rm_tea.setOpaque(false);
        rm_form.add(rm_tea);
        rm_tea.setBounds(240, 300, 130, 29);

        rm_tele.setFont(new java.awt.Font("Kalinga", 0, 12)); // NOI18N
        rm_tele.setText("Telephone");
        rm_tele.setOpaque(false);
        rm_form.add(rm_tele);
        rm_tele.setBounds(240, 330, 90, 29);

        rm_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save1.png"))); // NOI18N
        rm_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rm_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rm_saveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rm_saveMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rm_saveMousePressed(evt);
            }
        });
        rm_form.add(rm_save);
        rm_save.setBounds(20, 420, 150, 65);

        rm_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/reset_1.png"))); // NOI18N
        rm_reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rm_reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rm_resetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rm_resetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rm_resetMouseExited(evt);
            }
        });
        rm_form.add(rm_reset);
        rm_reset.setBounds(190, 420, 150, 65);
        rm_form.add(rm_msg);
        rm_msg.setBounds(30, 510, 250, 70);
        rm_form.add(rm_error1);
        rm_error1.setBounds(280, 10, 40, 40);
        rm_form.add(rm_error2);
        rm_error2.setBounds(280, 60, 40, 40);
        rm_form.add(rm_error3);
        rm_error3.setBounds(280, 110, 40, 40);
        rm_form.add(rm_error4);
        rm_error4.setBounds(280, 210, 40, 40);

        rm_tab.add(rm_form);
        rm_form.setBounds(0, 80, 370, 610);

        rm_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        rm_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rm_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rm_closeBtnMouseClicked(evt);
            }
        });
        rm_tab.add(rm_closeBtn);
        rm_closeBtn.setBounds(900, 0, 34, 31);

        rm_tablePanel.setBackground(new java.awt.Color(123, 211, 172));
        rm_tablePanel.setOpaque(false);
        rm_tablePanel.setLayout(null);

        rm_tableScrolPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        rm_tabel.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        rm_tabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        rm_tabel.setOpaque(false);
        rm_tabel.setRowHeight(30);
        rm_tabel.setSelectionBackground(new java.awt.Color(3, 201, 169));
        rm_tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rm_tabelMouseClicked(evt);
            }
        });
        rm_tableScrolPane.setViewportView(rm_tabel);

        rm_tablePanel.add(rm_tableScrolPane);
        rm_tableScrolPane.setBounds(0, 0, 570, 600);

        rm_tab.add(rm_tablePanel);
        rm_tablePanel.setBounds(370, 90, 570, 600);

        rm_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_1.png"))); // NOI18N
        rm_deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rm_deleteBtn.setEnabled(false);
        rm_deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rm_deleteBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rm_deleteBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rm_deleteBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rm_deleteBtnMousePressed(evt);
            }
        });
        rm_tab.add(rm_deleteBtn);
        rm_deleteBtn.setBounds(640, 30, 100, 50);

        rm_label2.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        rm_label2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/rc_header.png"))); // NOI18N
        rm_tab.add(rm_label2);
        rm_label2.setBounds(370, 50, 130, 40);

        rm_refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/refresh1.png"))); // NOI18N
        rm_refreshBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rm_refreshBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rm_refreshBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rm_refreshBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rm_refreshBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rm_refreshBtnMousePressed(evt);
            }
        });
        rm_tab.add(rm_refreshBtn);
        rm_refreshBtn.setBounds(520, 30, 100, 50);

        rm_bgImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        rm_tab.add(rm_bgImg);
        rm_bgImg.setBounds(0, 0, 940, 690);

        res_jtab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/room_manage.jpg")), rm_tab); // NOI18N

        ca_tab.setLayout(null);

        ca_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        ca_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ca_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ca_closeBtnMouseClicked(evt);
            }
        });
        ca_tab.add(ca_closeBtn);
        ca_closeBtn.setBounds(903, 0, 30, 30);

        ca_formPanel.setOpaque(false);
        ca_formPanel.setLayout(null);

        ca_label5.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ca_label5.setText("To");
        ca_formPanel.add(ca_label5);
        ca_label5.setBounds(30, 120, 50, 30);

        ca_dDate.setDateFormatString("yyyy-MM-dd");
        ca_formPanel.add(ca_dDate);
        ca_dDate.setBounds(170, 120, 130, 30);

        ca_roomType.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ca_formPanel.add(ca_roomType);
        ca_roomType.setBounds(170, 20, 130, 30);

        ca_label3.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ca_label3.setText("Room Type");
        ca_formPanel.add(ca_label3);
        ca_label3.setBounds(30, 20, 90, 30);

        ca_label4.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ca_label4.setText("From ");
        ca_formPanel.add(ca_label4);
        ca_label4.setBounds(30, 70, 60, 30);

        ca_aDate.setDateFormatString("yyyy-MM-dd");
        ca_formPanel.add(ca_aDate);
        ca_aDate.setBounds(170, 70, 130, 30);

        ca_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search.png"))); // NOI18N
        ca_searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ca_searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ca_searchBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ca_searchBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ca_searchBtnMousePressed(evt);
            }
        });
        ca_formPanel.add(ca_searchBtn);
        ca_searchBtn.setBounds(90, 210, 150, 65);

        ca_tab.add(ca_formPanel);
        ca_formPanel.setBounds(0, 80, 350, 610);

        ca_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        ca_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/sb_header.png"))); // NOI18N
        ca_label1.setText("Search By");
        ca_tab.add(ca_label1);
        ca_label1.setBounds(0, 20, 160, 40);

        ca_tablePanel.setLayout(null);

        ca_tablePane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        ca_table.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        ca_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        ca_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        ca_table.setRowHeight(30);
        ca_table.setSelectionBackground(new java.awt.Color(3, 201, 169));
        ca_tablePane.setViewportView(ca_table);

        ca_tablePanel.add(ca_tablePane);
        ca_tablePane.setBounds(0, 0, 590, 590);

        ca_tab.add(ca_tablePanel);
        ca_tablePanel.setBounds(350, 100, 590, 590);

        ca_label2.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        ca_label2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/rc_header.png"))); // NOI18N
        ca_tab.add(ca_label2);
        ca_label2.setBounds(350, 60, 110, 40);

        ca_refershBtn.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ca_refershBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ca_refershBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/reload.png"))); // NOI18N
        ca_refershBtn.setText("Refersh");
        ca_refershBtn.setToolTipText("");
        ca_refershBtn.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        ca_refershBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ca_refershBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ca_refershBtnMousePressed(evt);
            }
        });
        ca_tab.add(ca_refershBtn);
        ca_refershBtn.setBounds(800, 0, 90, 32);

        ca_bgImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        ca_tab.add(ca_bgImg);
        ca_bgImg.setBounds(0, 0, 940, 690);

        res_jtab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/check.jpg")), ca_tab); // NOI18N

        ar_tab.setMaximumSize(new java.awt.Dimension(900, 600));
        ar_tab.setOpaque(false);
        ar_tab.setPreferredSize(new java.awt.Dimension(900, 600));
        ar_tab.setLayout(null);

        ar_formPanel.setOpaque(false);
        ar_formPanel.setLayout(null);
        ar_formPanel.add(ar_sep3);
        ar_sep3.setBounds(0, 200, 620, 10);

        ar_label2.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_label2.setText("Room No");
        ar_formPanel.add(ar_label2);
        ar_label2.setBounds(20, 20, 120, 30);

        ar_label3.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_label3.setText("Room Type");
        ar_formPanel.add(ar_label3);
        ar_label3.setBounds(20, 60, 110, 40);

        ar_label4.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_label4.setText("Arrival Date");
        ar_formPanel.add(ar_label4);
        ar_label4.setBounds(20, 110, 100, 30);

        ar_label7.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_label7.setText("No of Persons");
        ar_formPanel.add(ar_label7);
        ar_label7.setBounds(310, 60, 120, 40);

        ar_label8.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_label8.setText("Departure Date");
        ar_formPanel.add(ar_label8);
        ar_label8.setBounds(310, 110, 130, 30);

        ar_label6.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_label6.setText("Booking Date");
        ar_formPanel.add(ar_label6);
        ar_label6.setBounds(310, 20, 160, 30);

        ar_label15.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_label15.setText("N.I.C No");
        ar_formPanel.add(ar_label15);
        ar_label15.setBounds(20, 490, 90, 40);

        ar_roomNo.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_roomNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ar_roomNoMouseClicked(evt);
            }
        });
        ar_formPanel.add(ar_roomNo);
        ar_roomNo.setBounds(140, 20, 80, 30);

        ar_dep_date.setDateFormatString("yyyy-MM-dd");
        ar_formPanel.add(ar_dep_date);
        ar_dep_date.setBounds(470, 110, 130, 30);

        ar_nic_txt.setBackground(new java.awt.Color(123, 211, 172));
        ar_nic_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_nic_txt.setBorder(null);
        ar_nic_txt.setOpaque(false);
        ar_nic_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        ar_nic_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ar_nic_txtKeyTyped(evt);
            }
        });
        ar_formPanel.add(ar_nic_txt);
        ar_nic_txt.setBounds(140, 500, 130, 23);

        ar_gender_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_gender_cbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        ar_formPanel.add(ar_gender_cbox);
        ar_gender_cbox.setBounds(470, 340, 130, 25);

        ar_label10.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        ar_label10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ar_label10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/gd_header.png"))); // NOI18N
        ar_formPanel.add(ar_label10);
        ar_label10.setBounds(0, 210, 210, 40);
        ar_formPanel.add(ar_sep1);
        ar_sep1.setBounds(0, 0, 620, 10);

        ar_label12.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_label12.setText("First Name");
        ar_formPanel.add(ar_label12);
        ar_label12.setBounds(20, 340, 90, 40);

        ar_label13.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_label13.setText("Last Name");
        ar_formPanel.add(ar_label13);
        ar_label13.setBounds(20, 390, 82, 40);

        ar_label16.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_label16.setText("Contact No");
        ar_formPanel.add(ar_label16);
        ar_label16.setBounds(310, 290, 100, 40);

        ar_label17.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_label17.setText("Gender");
        ar_formPanel.add(ar_label17);
        ar_label17.setBounds(310, 340, 57, 30);

        ar_arrival_date.setDateFormatString("yyyy-MM-dd");
        ar_formPanel.add(ar_arrival_date);
        ar_arrival_date.setBounds(140, 110, 130, 30);

        ar_firstName_txt.setBackground(new java.awt.Color(123, 211, 172));
        ar_firstName_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_firstName_txt.setBorder(null);
        ar_firstName_txt.setOpaque(false);
        ar_firstName_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        ar_formPanel.add(ar_firstName_txt);
        ar_firstName_txt.setBounds(140, 350, 130, 23);

        ar_lastName_txt.setBackground(new java.awt.Color(123, 211, 172));
        ar_lastName_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_lastName_txt.setBorder(null);
        ar_lastName_txt.setOpaque(false);
        ar_lastName_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        ar_formPanel.add(ar_lastName_txt);
        ar_lastName_txt.setBounds(140, 400, 130, 23);

        ar_contact_txt.setBackground(new java.awt.Color(123, 211, 172));
        ar_contact_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_contact_txt.setBorder(null);
        ar_contact_txt.setOpaque(false);
        ar_contact_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        ar_contact_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ar_contact_txtKeyTyped(evt);
            }
        });
        ar_formPanel.add(ar_contact_txt);
        ar_contact_txt.setBounds(470, 300, 130, 23);
        ar_formPanel.add(ar_sep2);
        ar_sep2.setBounds(0, 260, 620, 10);

        ar_saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save1.png"))); // NOI18N
        ar_saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ar_saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ar_saveBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ar_saveBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ar_saveBtnMousePressed(evt);
            }
        });
        ar_formPanel.add(ar_saveBtn);
        ar_saveBtn.setBounds(140, 550, 150, 70);

        ar_resetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/reset_1.png"))); // NOI18N
        ar_resetBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ar_resetBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ar_resetBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ar_resetBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ar_resetBtnMouseExited(evt);
            }
        });
        ar_formPanel.add(ar_resetBtn);
        ar_resetBtn.setBounds(320, 550, 160, 70);

        ar_txtLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        ar_formPanel.add(ar_txtLabel9);
        ar_txtLabel9.setBounds(130, 490, 150, 40);

        ar_txtLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        ar_formPanel.add(ar_txtLabel5);
        ar_txtLabel5.setBounds(130, 340, 150, 40);

        ar_txtLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        ar_formPanel.add(ar_txtLabel6);
        ar_txtLabel6.setBounds(130, 390, 150, 40);

        ar_txtLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        ar_formPanel.add(ar_txtLabel10);
        ar_txtLabel10.setBounds(460, 290, 150, 40);

        ar_label5.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_label5.setText("User Name");
        ar_formPanel.add(ar_label5);
        ar_label5.setBounds(20, 150, 100, 40);

        ar_user_txt.setBackground(new java.awt.Color(123, 211, 172));
        ar_user_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_user_txt.setBorder(null);
        ar_user_txt.setOpaque(false);
        ar_user_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        ar_formPanel.add(ar_user_txt);
        ar_user_txt.setBounds(140, 160, 130, 23);

        ar_txtLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        ar_formPanel.add(ar_txtLabel3);
        ar_txtLabel3.setBounds(130, 150, 150, 40);

        ar_label9.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_label9.setText("Password");
        ar_formPanel.add(ar_label9);
        ar_label9.setBounds(310, 150, 90, 40);

        ar_password_txt.setBackground(new java.awt.Color(123, 211, 172));
        ar_password_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_password_txt.setBorder(null);
        ar_password_txt.setOpaque(false);
        ar_password_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        ar_formPanel.add(ar_password_txt);
        ar_password_txt.setBounds(470, 160, 130, 23);

        ar_txtLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        ar_formPanel.add(ar_txtLabel2);
        ar_txtLabel2.setBounds(460, 150, 150, 40);

        ar_add_txt.setColumns(20);
        ar_add_txt.setFont(new java.awt.Font("GardensC", 0, 14)); // NOI18N
        ar_add_txt.setRows(5);
        ar_scrollPane.setViewportView(ar_add_txt);

        ar_formPanel.add(ar_scrollPane);
        ar_scrollPane.setBounds(390, 440, 230, 90);

        ar_label19.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_label19.setText("Address");
        ar_formPanel.add(ar_label19);
        ar_label19.setBounds(310, 440, 60, 40);

        ar_roomType.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_formPanel.add(ar_roomType);
        ar_roomType.setBounds(140, 70, 130, 25);

        ar_label14.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_label14.setText("Nationality");
        ar_formPanel.add(ar_label14);
        ar_label14.setBounds(20, 440, 90, 40);

        ar_nat_txt.setBackground(new java.awt.Color(123, 211, 172));
        ar_nat_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_nat_txt.setBorder(null);
        ar_nat_txt.setOpaque(false);
        ar_nat_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        ar_formPanel.add(ar_nat_txt);
        ar_nat_txt.setBounds(140, 450, 130, 23);

        ar_txtLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        ar_formPanel.add(ar_txtLabel7);
        ar_txtLabel7.setBounds(130, 440, 150, 40);

        ar_pickup_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_pickup_cbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));
        ar_formPanel.add(ar_pickup_cbox);
        ar_pickup_cbox.setBounds(470, 390, 130, 25);

        ar_label18.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_label18.setText("Pick Up Service");
        ar_formPanel.add(ar_label18);
        ar_label18.setBounds(310, 390, 120, 30);

        ar_label11.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_label11.setText("Guest ID");
        ar_formPanel.add(ar_label11);
        ar_label11.setBounds(20, 290, 90, 40);

        ar_guestId.setBackground(new java.awt.Color(123, 211, 172));
        ar_guestId.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_guestId.setBorder(null);
        ar_guestId.setOpaque(false);
        ar_guestId.setSelectionColor(new java.awt.Color(3, 201, 169));
        ar_guestId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ar_guestIdKeyTyped(evt);
            }
        });
        ar_formPanel.add(ar_guestId);
        ar_guestId.setBounds(140, 300, 130, 23);

        ar_txtLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        ar_formPanel.add(ar_txtLabel4);
        ar_txtLabel4.setBounds(130, 290, 150, 40);
        ar_formPanel.add(ar_persons_spin);
        ar_persons_spin.setBounds(470, 70, 130, 25);

        ar_checkRooms_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/find.png"))); // NOI18N
        ar_checkRooms_label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ar_checkRooms_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ar_checkRooms_labelMousePressed(evt);
            }
        });
        ar_formPanel.add(ar_checkRooms_label);
        ar_checkRooms_label.setBounds(230, 20, 32, 32);

        ar_booking_date.setEditable(false);
        ar_booking_date.setBackground(new java.awt.Color(123, 211, 172));
        ar_booking_date.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_booking_date.setBorder(null);
        ar_booking_date.setOpaque(false);
        ar_booking_date.setSelectionColor(new java.awt.Color(3, 201, 169));
        ar_formPanel.add(ar_booking_date);
        ar_booking_date.setBounds(470, 30, 130, 23);

        ar_txtLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        ar_formPanel.add(ar_txtLabel1);
        ar_txtLabel1.setBounds(460, 20, 150, 40);

        ar_tab.add(ar_formPanel);
        ar_formPanel.setBounds(0, 60, 630, 630);

        ar_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        ar_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ar_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/rd_header.png"))); // NOI18N
        ar_tab.add(ar_label1);
        ar_label1.setBounds(0, 10, 210, 40);

        ar_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        ar_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ar_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ar_closeBtnMouseClicked(evt);
            }
        });
        ar_tab.add(ar_closeBtn);
        ar_closeBtn.setBounds(903, 0, 24, 31);

        ar_rate_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ar_rate_panel.setOpaque(false);
        ar_rate_panel.setLayout(null);

        ar_label20.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        ar_label20.setText("Amount Details");
        ar_rate_panel.add(ar_label20);
        ar_label20.setBounds(50, 20, 170, 30);

        ar_label23.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_label23.setText("Total Amount");
        ar_rate_panel.add(ar_label23);
        ar_label23.setBounds(20, 120, 120, 20);

        ar_rate_txt.setEditable(false);
        ar_rate_panel.add(ar_rate_txt);
        ar_rate_txt.setBounds(169, 70, 70, 30);

        ar_label21.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_label21.setText("Rate");
        ar_rate_panel.add(ar_label21);
        ar_label21.setBounds(20, 80, 120, 20);

        ar_total_txt.setEditable(false);
        ar_rate_panel.add(ar_total_txt);
        ar_total_txt.setBounds(169, 110, 70, 30);

        ar_rec_amount.setBackground(new java.awt.Color(123, 211, 172));
        ar_rec_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ar_rec_amountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ar_rec_amountKeyTyped(evt);
            }
        });
        ar_rate_panel.add(ar_rec_amount);
        ar_rec_amount.setBounds(169, 150, 70, 30);

        ar_label24.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_label24.setText("Received Amount");
        ar_rate_panel.add(ar_label24);
        ar_label24.setBounds(20, 160, 140, 20);

        ar_balance_txt.setEditable(false);
        ar_rate_panel.add(ar_balance_txt);
        ar_balance_txt.setBounds(169, 190, 70, 30);

        ar_label25.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ar_label25.setText("Total Balance");
        ar_rate_panel.add(ar_label25);
        ar_label25.setBounds(20, 200, 120, 20);

        ar_tab.add(ar_rate_panel);
        ar_rate_panel.setBounds(640, 60, 260, 250);

        ar_refersh.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ar_refersh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ar_refersh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/reload.png"))); // NOI18N
        ar_refersh.setText("Refersh");
        ar_refersh.setToolTipText("");
        ar_refersh.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        ar_refersh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ar_refersh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ar_refershMousePressed(evt);
            }
        });
        ar_tab.add(ar_refersh);
        ar_refersh.setBounds(800, 0, 90, 32);
        ar_tab.add(ar_msg_label);
        ar_msg_label.setBounds(640, 370, 260, 90);

        ar_bgImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        ar_bgImage.setText("jLabel19");
        ar_tab.add(ar_bgImage);
        ar_bgImage.setBounds(0, 0, 940, 690);

        res_jtab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/add_res.jpg")), ar_tab); // NOI18N

        al_tab.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        al_tab.setLayout(null);

        al_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        al_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/sb_header.png"))); // NOI18N
        al_label1.setToolTipText("");
        al_tab.add(al_label1);
        al_label1.setBounds(0, 10, 140, 60);

        al_roomType.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        al_tab.add(al_roomType);
        al_roomType.setBounds(140, 150, 130, 25);

        al_label3.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        al_label3.setText("Room Type");
        al_tab.add(al_label3);
        al_label3.setBounds(20, 150, 100, 30);

        al_fromDate.setDateFormatString("yyyy-MM-dd");
        al_tab.add(al_fromDate);
        al_fromDate.setBounds(140, 190, 130, 30);

        al_label4.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        al_label4.setText("From");
        al_tab.add(al_label4);
        al_label4.setBounds(20, 190, 50, 30);

        al_label5.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        al_label5.setText("To");
        al_tab.add(al_label5);
        al_label5.setBounds(20, 230, 40, 30);

        al_toDate.setDateFormatString("yyyy-MM-dd");
        al_tab.add(al_toDate);
        al_toDate.setBounds(140, 230, 130, 30);

        al_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search.png"))); // NOI18N
        al_searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        al_searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                al_searchBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                al_searchBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                al_searchBtnMousePressed(evt);
            }
        });
        al_tab.add(al_searchBtn);
        al_searchBtn.setBounds(80, 330, 150, 65);

        al_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        al_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        al_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                al_closeBtnMouseClicked(evt);
            }
        });
        al_tab.add(al_closeBtn);
        al_closeBtn.setBounds(903, 0, 34, 31);

        al_todayBtn.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        al_todayBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/radio_btn1.png"))); // NOI18N
        al_todayBtn.setText("Today");
        al_todayBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        al_todayBtn.setIconTextGap(10);
        al_todayBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                al_todayBtnMouseClicked(evt);
            }
        });
        al_tab.add(al_todayBtn);
        al_todayBtn.setBounds(20, 80, 90, 40);

        al_tablepane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        al_table.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        al_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        al_table.setRowHeight(30);
        al_table.setSelectionBackground(new java.awt.Color(3, 201, 169));
        al_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                al_tableMouseClicked(evt);
            }
        });
        al_tablepane.setViewportView(al_table);

        al_tab.add(al_tablepane);
        al_tablepane.setBounds(352, 140, 590, 550);

        al_label6.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        al_label6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/rc_header.png"))); // NOI18N
        al_tab.add(al_label6);
        al_label6.setBounds(350, 100, 130, 40);

        al_postponeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/postpone1.png"))); // NOI18N
        al_postponeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        al_postponeBtn.setEnabled(false);
        al_postponeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                al_postponeBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                al_postponeBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                al_postponeBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                al_postponeBtnMousePressed(evt);
            }
        });
        al_tab.add(al_postponeBtn);
        al_postponeBtn.setBounds(630, 90, 100, 50);

        al_cancelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/cancel1.png"))); // NOI18N
        al_cancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        al_cancelBtn.setEnabled(false);
        al_cancelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                al_cancelBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                al_cancelBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                al_cancelBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                al_cancelBtnMousePressed(evt);
            }
        });
        al_tab.add(al_cancelBtn);
        al_cancelBtn.setBounds(740, 90, 100, 50);

        ar_refersh1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ar_refersh1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ar_refersh1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/reload.png"))); // NOI18N
        ar_refersh1.setText("Refersh");
        ar_refersh1.setToolTipText("");
        ar_refersh1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        ar_refersh1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ar_refersh1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ar_refersh1MousePressed(evt);
            }
        });
        al_tab.add(ar_refersh1);
        ar_refersh1.setBounds(800, 0, 90, 40);

        al_checkInBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/checkBtn_1.png"))); // NOI18N
        al_checkInBtn.setEnabled(false);
        al_checkInBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                al_checkInBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                al_checkInBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                al_checkInBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                al_checkInBtnMouseReleased(evt);
            }
        });
        al_tab.add(al_checkInBtn);
        al_checkInBtn.setBounds(520, 90, 100, 50);

        al_bgImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        al_tab.add(al_bgImg);
        al_bgImg.setBounds(0, 0, 937, 692);

        res_jtab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/arrival_list.jpg")), al_tab, ""); // NOI18N

        dl_tab.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        dl_tab.setLayout(null);

        dl_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        dl_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/sb_header.png"))); // NOI18N
        dl_label1.setToolTipText("");
        dl_tab.add(dl_label1);
        dl_label1.setBounds(0, 10, 150, 60);

        dl_roomType.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        dl_tab.add(dl_roomType);
        dl_roomType.setBounds(140, 150, 130, 25);

        dl_label3.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        dl_label3.setText("Room Type");
        dl_tab.add(dl_label3);
        dl_label3.setBounds(20, 150, 100, 30);

        dl_fromDate.setDateFormatString("yyyy-MM-dd");
        dl_tab.add(dl_fromDate);
        dl_fromDate.setBounds(140, 190, 130, 30);

        dl_label4.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        dl_label4.setText("From");
        dl_tab.add(dl_label4);
        dl_label4.setBounds(20, 190, 50, 30);

        dl_label5.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        dl_label5.setText("To");
        dl_tab.add(dl_label5);
        dl_label5.setBounds(20, 230, 40, 30);

        dl_toDate.setDateFormatString("yyyy-MM-dd");
        dl_tab.add(dl_toDate);
        dl_toDate.setBounds(140, 230, 130, 30);

        dl_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search.png"))); // NOI18N
        dl_searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dl_searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dl_searchBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dl_searchBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dl_searchBtnMousePressed(evt);
            }
        });
        dl_tab.add(dl_searchBtn);
        dl_searchBtn.setBounds(80, 330, 150, 65);

        dl_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        dl_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dl_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dl_closeBtnMouseClicked(evt);
            }
        });
        dl_tab.add(dl_closeBtn);
        dl_closeBtn.setBounds(903, 0, 34, 31);

        dl_todayBtn.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        dl_todayBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/radio_btn1.png"))); // NOI18N
        dl_todayBtn.setText("Today");
        dl_todayBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dl_todayBtn.setIconTextGap(10);
        dl_todayBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dl_todayBtnMouseClicked(evt);
            }
        });
        dl_tab.add(dl_todayBtn);
        dl_todayBtn.setBounds(20, 90, 80, 20);

        dl_tablepane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        dl_table.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        dl_table.setRowHeight(30);
        dl_table.setSelectionBackground(new java.awt.Color(3, 201, 169));
        dl_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dl_tableMouseClicked(evt);
            }
        });
        dl_tablepane.setViewportView(dl_table);

        dl_tab.add(dl_tablepane);
        dl_tablepane.setBounds(352, 140, 590, 550);

        dl_label6.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        dl_label6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/rc_header.png"))); // NOI18N
        dl_tab.add(dl_label6);
        dl_label6.setBounds(350, 100, 120, 40);

        dl_postponeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/postpone1.png"))); // NOI18N
        dl_postponeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dl_postponeBtn.setEnabled(false);
        dl_postponeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dl_postponeBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dl_postponeBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dl_postponeBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dl_postponeBtnMousePressed(evt);
            }
        });
        dl_tab.add(dl_postponeBtn);
        dl_postponeBtn.setBounds(650, 90, 100, 50);

        ar_refersh2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ar_refersh2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ar_refersh2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/reload.png"))); // NOI18N
        ar_refersh2.setText("Refersh");
        ar_refersh2.setToolTipText("");
        ar_refersh2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        ar_refersh2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ar_refersh2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ar_refersh2MousePressed(evt);
            }
        });
        dl_tab.add(ar_refersh2);
        ar_refersh2.setBounds(800, 0, 90, 40);

        dl_checkoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/co_btn1.png"))); // NOI18N
        dl_checkoutBtn.setEnabled(false);
        dl_checkoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dl_checkoutBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dl_checkoutBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dl_checkoutBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                dl_checkoutBtnMouseReleased(evt);
            }
        });
        dl_tab.add(dl_checkoutBtn);
        dl_checkoutBtn.setBounds(540, 90, 100, 50);

        al_bgImg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        dl_tab.add(al_bgImg1);
        al_bgImg1.setBounds(0, 0, 937, 692);

        res_jtab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/dep_list.jpg")), dl_tab, ""); // NOI18N

        javax.swing.GroupLayout center_innerLayout = new javax.swing.GroupLayout(center_inner);
        center_inner.setLayout(center_innerLayout);
        center_innerLayout.setHorizontalGroup(
            center_innerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(res_jtab, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
        );
        center_innerLayout.setVerticalGroup(
            center_innerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(res_jtab, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout center_outerLayout = new javax.swing.GroupLayout(center_outer);
        center_outer.setLayout(center_outerLayout);
        center_outerLayout.setHorizontalGroup(
            center_outerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 987, Short.MAX_VALUE)
            .addGroup(center_outerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(center_outerLayout.createSequentialGroup()
                    .addComponent(center_inner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 37, Short.MAX_VALUE)))
        );
        center_outerLayout.setVerticalGroup(
            center_outerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
            .addGroup(center_outerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(center_inner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        body_panel.add(center_outer, java.awt.BorderLayout.CENTER);

        footer_panel.setOpaque(false);
        footer_panel.setLayout(new java.awt.BorderLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/logo1.png"))); // NOI18N
        footer_panel.add(logo, java.awt.BorderLayout.EAST);

        body_panel.add(footer_panel, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(body_panel);
        body_panel.setBounds(0, 0, 1280, 1030);

        bg_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/hm_bg.jpg"))); // NOI18N
        getContentPane().add(bg_image);
        bg_image.setBounds(0, 0, 400, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reservationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reservationMouseClicked
        res_jtab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/add_res.jpg")), ar_tab);
        res_jtab.setSelectedComponent(ar_tab);
    }//GEN-LAST:event_reservationMouseClicked

    private void reservationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reservationMouseEntered
        reservation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/add_res2.jpg")));
        reservation.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_reservationMouseEntered

    private void reservationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reservationMouseExited
        reservation.setBorder(null);
        reservation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/add_res1.jpg")));
        
    }//GEN-LAST:event_reservationMouseExited

    private void room_managmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_room_managmentMouseClicked
        res_jtab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/room_manage.jpg")), rm_tab);
        res_jtab.setSelectedComponent(rm_tab);
    }//GEN-LAST:event_room_managmentMouseClicked

    private void room_managmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_room_managmentMouseEntered
        room_managment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/room2.jpg")));
        room_managment.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_room_managmentMouseEntered

    private void room_managmentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_room_managmentMouseExited
        room_managment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/room1.jpg")));
        room_managment.setBorder(null);
    }//GEN-LAST:event_room_managmentMouseExited

    private void check_availabilityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_availabilityMouseClicked
        res_jtab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/check.jpg")),ca_tab);
        res_jtab.setSelectedComponent(ca_tab);
    }//GEN-LAST:event_check_availabilityMouseClicked

    private void check_availabilityMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_availabilityMouseEntered
        check_availability.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/check2.jpg")));
        check_availability.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_check_availabilityMouseEntered

    private void check_availabilityMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_availabilityMouseExited
        check_availability.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/check1.jpg")));
        check_availability.setBorder(null);
    }//GEN-LAST:event_check_availabilityMouseExited

    private void arrival_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arrival_listMouseClicked
        res_jtab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/arrival_list.jpg")),al_tab);
        res_jtab.setSelectedComponent(al_tab);
    }//GEN-LAST:event_arrival_listMouseClicked

    private void arrival_listMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arrival_listMouseEntered
        arrival_list.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/arrival2.jpg")));
        arrival_list.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_arrival_listMouseEntered

    private void arrival_listMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arrival_listMouseExited
        arrival_list.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/arrival1.jpg")));
        arrival_list.setBorder(null);
    }//GEN-LAST:event_arrival_listMouseExited

    private void close_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_labelMouseClicked
        System.exit(0);
    }//GEN-LAST:event_close_labelMouseClicked

    private void mini_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mini_labelMouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_mini_labelMouseClicked

    private void back_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_labelMouseClicked
        index i = new index();
        i.setVisible(true);
        timerun=1;
        this.dispose();
    }//GEN-LAST:event_back_labelMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void rm_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rm_closeBtnMouseClicked
        res_jtab.remove(rm_tab);
    }//GEN-LAST:event_rm_closeBtnMouseClicked

    private void ca_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ca_closeBtnMouseClicked
        res_jtab.remove(ca_tab);
    }//GEN-LAST:event_ca_closeBtnMouseClicked

    private void ca_searchBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ca_searchBtnMouseEntered
        ca_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search1.png")));
    }//GEN-LAST:event_ca_searchBtnMouseEntered

    private void ca_searchBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ca_searchBtnMouseExited
        ca_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search.png")));
    }//GEN-LAST:event_ca_searchBtnMouseExited

    private void ar_saveBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ar_saveBtnMouseEntered
        ar_saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save2.png")));
    }//GEN-LAST:event_ar_saveBtnMouseEntered

    private void ar_saveBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ar_saveBtnMouseExited
        ar_saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save1.png")));
    }//GEN-LAST:event_ar_saveBtnMouseExited

    private void ar_resetBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ar_resetBtnMouseClicked
        ar_roomNo.removeAllItems();
        ar_roomType.removeAllItems();
        ar_booking_date.setText("");
        ar_persons_spin.setValue(0);
        ar_arrival_date.setCalendar(null);
        ar_dep_date.setCalendar(null);
        ar_user_txt.setText("");
        ar_password_txt.setText("");
        ar_guestId.setText("");
        ar_firstName_txt.setText("");
        ar_lastName_txt.setText("");
        ar_nat_txt.setText("");
        ar_nic_txt.setText("");
        ar_contact_txt.setText("");
        ar_gender_cbox.setSelectedIndex(0);
        ar_pickup_cbox.setSelectedIndex(0);
        ar_add_txt.setText("");
        ar_rate_txt.setText("");
        ar_total_txt.setText("");
        ar_rec_amount.setText("");
        ar_balance_txt.setText("");


    }//GEN-LAST:event_ar_resetBtnMouseClicked

    private void ar_resetBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ar_resetBtnMouseEntered
        ar_resetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/reset_2.png")));
    }//GEN-LAST:event_ar_resetBtnMouseEntered

    private void ar_resetBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ar_resetBtnMouseExited
        ar_resetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/reset_1.png")));
    }//GEN-LAST:event_ar_resetBtnMouseExited

    private void ar_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ar_closeBtnMouseClicked
        res_jtab.remove(ar_tab);
    }//GEN-LAST:event_ar_closeBtnMouseClicked

    private void al_searchBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_al_searchBtnMouseEntered
        al_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search1.png")));
    }//GEN-LAST:event_al_searchBtnMouseEntered

    private void al_searchBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_al_searchBtnMouseExited
        al_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search.png")));
    }//GEN-LAST:event_al_searchBtnMouseExited

    private void al_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_al_closeBtnMouseClicked
        res_jtab.remove(al_tab);
    }//GEN-LAST:event_al_closeBtnMouseClicked

    private void departure_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_departure_listMouseClicked
        res_jtab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/dep_list.jpg")),dl_tab);
        res_jtab.setSelectedComponent(dl_tab);
        
    }//GEN-LAST:event_departure_listMouseClicked

    private void departure_listMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_departure_listMouseEntered
        departure_list.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/departure2.jpg")));
        departure_list.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_departure_listMouseEntered

    private void departure_listMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_departure_listMouseExited
        departure_list.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/departure1.jpg")));
        departure_list.setBorder(null);
    }//GEN-LAST:event_departure_listMouseExited

    private void rm_windowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rm_windowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rm_windowActionPerformed

    private void rm_saveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rm_saveMouseEntered
       rm_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save2.png")));
    }//GEN-LAST:event_rm_saveMouseEntered

    private void rm_saveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rm_saveMouseExited
       rm_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save1.png")));

    }//GEN-LAST:event_rm_saveMouseExited

    private void rm_resetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rm_resetMouseEntered
        rm_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/reset_2.png")));


    }//GEN-LAST:event_rm_resetMouseEntered

    private void rm_resetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rm_resetMouseExited
  
        rm_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/reset_1.png")));

    }//GEN-LAST:event_rm_resetMouseExited

    private void rm_resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rm_resetMouseClicked
        
        rm_roomNo.setText("");
        rm_roomType.setText("");
        rm_rate.setText("");
        rm_bedType.setSelectedIndex(0);
        rm_persons.getModel().setValue(0);
        rm_bar.setSelected(false);
        rm_led.setSelected(false);
        rm_window.setSelected(false);
        rm_fridge.setSelected(false);
        rm_ac.setSelected(false);
        rm_wifi.setSelected(false);
        rm_tea.setSelected(false);
        rm_tele.setSelected(false);
        rm_error1.setIcon(null);
        rm_error2.setIcon(null);
        rm_error3.setIcon(null);
        rm_error4.setIcon(null);
        rm_msg.setIcon(null);
        

        
        
    }//GEN-LAST:event_rm_resetMouseClicked

    private void rm_deleteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rm_deleteBtnMouseEntered

     rm_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_2.png")));

    }//GEN-LAST:event_rm_deleteBtnMouseEntered

    private void rm_deleteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rm_deleteBtnMouseExited
     rm_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_1.png")));

    }//GEN-LAST:event_rm_deleteBtnMouseExited

    private void rm_deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rm_deleteBtnMouseClicked
     rm_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_3.png")));


    }//GEN-LAST:event_rm_deleteBtnMouseClicked

    private void rm_refreshBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rm_refreshBtnMouseEntered

     rm_refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/refresh2.png")));

    }//GEN-LAST:event_rm_refreshBtnMouseEntered

    private void rm_refreshBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rm_refreshBtnMouseExited

     rm_refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/refresh1.png")));

        
    }//GEN-LAST:event_rm_refreshBtnMouseExited

    private void rm_refreshBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rm_refreshBtnMouseClicked

     rm_refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/refresh3.png")));
     
    }//GEN-LAST:event_rm_refreshBtnMouseClicked

    private void al_postponeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_al_postponeBtnMouseEntered
      
    al_postponeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/postpone2.png")));

        
    }//GEN-LAST:event_al_postponeBtnMouseEntered

    private void al_postponeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_al_postponeBtnMouseExited
    al_postponeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/postpone1.png")));

    }//GEN-LAST:event_al_postponeBtnMouseExited

    private void al_postponeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_al_postponeBtnMouseClicked
    
    al_postponeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/postpone3.png")));

    }//GEN-LAST:event_al_postponeBtnMouseClicked

    private void al_cancelBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_al_cancelBtnMouseClicked
    al_cancelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/cancel3.png")));

    }//GEN-LAST:event_al_cancelBtnMouseClicked

    private void al_cancelBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_al_cancelBtnMouseEntered
    al_cancelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/cancel2.png")));

    }//GEN-LAST:event_al_cancelBtnMouseEntered

    private void al_cancelBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_al_cancelBtnMouseExited
    al_cancelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/cancel1.png")));

    }//GEN-LAST:event_al_cancelBtnMouseExited

    private void dl_searchBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dl_searchBtnMouseEntered
     dl_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search1.png")));

    }//GEN-LAST:event_dl_searchBtnMouseEntered

    private void dl_searchBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dl_searchBtnMouseExited
     dl_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search.png")));

    }//GEN-LAST:event_dl_searchBtnMouseExited

    private void dl_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dl_closeBtnMouseClicked
    res_jtab.remove(dl_tab);
        
    }//GEN-LAST:event_dl_closeBtnMouseClicked

    private void dl_todayBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dl_todayBtnMouseClicked
     if(dl_on_off==true){
        
        dl_todayBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/radio_btn2.png")));
        
        
      
       
        dl_roomType.setEnabled(false);
        dl_fromDate.setEnabled(false);
        dl_toDate.setEnabled(false);
        
        dl_on_off=false;
        }
        else 
        {
        dl_todayBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/radio_btn1.png")));
        
        
      
        dl_roomType.setEnabled(true);
        dl_fromDate.setEnabled(true);
        dl_toDate.setEnabled(true);
        
        dl_on_off=true;
        }  
        
    }//GEN-LAST:event_dl_todayBtnMouseClicked

    private void dl_postponeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dl_postponeBtnMouseClicked
    dl_postponeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/postpone3.png")));

    }//GEN-LAST:event_dl_postponeBtnMouseClicked

    private void dl_postponeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dl_postponeBtnMouseEntered
    dl_postponeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/postpone2.png")));

    }//GEN-LAST:event_dl_postponeBtnMouseEntered

    private void dl_postponeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dl_postponeBtnMouseExited
    dl_postponeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/postpone1.png")));

    }//GEN-LAST:event_dl_postponeBtnMouseExited

    private void rm_saveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rm_saveMousePressed
        rm_error1.setIcon(null);
        rm_error2.setIcon(null);
        rm_error3.setIcon(null);
        rm_error4.setIcon(null);
        
       
        if("".equals(rm_roomNo.getText()))
        {
        rm_error1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/errorIcon.png")));
        rm_msg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/error_msg.png"))); 
        Toolkit.getDefaultToolkit().beep();
        
        }
        
        else  if("".equals(rm_roomType.getText()))
        {
        rm_error2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/errorIcon.png")));
        rm_msg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/error_msg.png")));
        Toolkit.getDefaultToolkit().beep();

        }
        else  if("".equals(rm_rate.getText()))
        {
        rm_error3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/errorIcon.png")));
        rm_msg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/error_msg.png")));   
        Toolkit.getDefaultToolkit().beep();

        }
        else  if(0==(Integer)rm_persons.getValue()) 
        {
        rm_error4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/errorIcon.png")));
        rm_msg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/error_msg.png")));
        Toolkit.getDefaultToolkit().beep();

        }
        else {
        rm_error1.setIcon(null);
        rm_error2.setIcon(null);
        rm_error3.setIcon(null);
        rm_error4.setIcon(null);
        
        
        
        
        try{ 
           
       String sql="Insert into rooms (room_no,room_type,rate,bed_type,persons,facilities)"
               + "values (?,?,?,?,?,?)";

       pst=con.prepareStatement(sql);
       pst.setInt(1, Integer.parseInt(rm_roomNo.getText()));
       pst.setString(2, rm_roomType.getText());
       pst.setInt(3,Integer.parseInt(rm_rate.getText()));
       pst.setString(4, rm_bedType.getSelectedItem().toString());
       pst.setString(5, rm_persons.getValue().toString());
       
       //all check box in arraylist 
       ArrayList list=new ArrayList();
       list.add(getcheckbox(rm_ac));
       list.add(getcheckbox(rm_bar));
       list.add(getcheckbox(rm_fridge));
       list.add(getcheckbox(rm_led));
       list.add(getcheckbox(rm_tea));
       list.add(getcheckbox(rm_tele));
       list.add(getcheckbox(rm_wifi));
       list.add(getcheckbox(rm_window));
       
       String cb= "";
       //to check if array contains null value
       for (int i = list.size() - 1; i >= 0; i--) 
       {
       if (list.get(i)== null) 
       {
        list.remove(i);
       }
       }
       //all elements in one variable
       cb=cb+list.get(0);
       for(int i=1;i<list.size();i++){
       cb=cb+" ,"+list.get(i).toString();
       } 
       
       pst.setString(6, cb);
       pst.execute();
       rm_msg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save_msg.png")));
       
    }
       catch(Exception e){
              JOptionPane.showMessageDialog(this,e,"Error Message",JOptionPane.ERROR_MESSAGE);
              e.printStackTrace();
              
              }
        
        }
    }//GEN-LAST:event_rm_saveMousePressed

    private void rm_refreshBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rm_refreshBtnMousePressed
       try{
       String sql= "select * from rooms";
       pst=con.prepareStatement(sql);
       rs=pst.executeQuery();
       rm_tabel.setModel(DbUtils.resultSetToTableModel(rs));
       setColumn(rm_tabel);
               
       
       }
       catch(Exception e){
       e.printStackTrace();
       }
        
    }//GEN-LAST:event_rm_refreshBtnMousePressed

    private void rm_tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rm_tabelMouseClicked
      int row =rm_tabel.getSelectedRow();
        
       if(rm_tabel.isRowSelected(row)==true)
       {
       
       rm_deleteBtn.setEnabled(true);
       }
        else
        {
       
       rm_deleteBtn.setEnabled(false);
        }
    }//GEN-LAST:event_rm_tabelMouseClicked

    private void rm_deleteBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rm_deleteBtnMousePressed
        
        
       int row = rm_tabel.getSelectedRow();
       int room_no= (int) rm_tabel.getModel().getValueAt(row, 0);
       String sql= "Delete from rooms where room_no='"+room_no+"'";
       int option=JOptionPane.showConfirmDialog(null,"Are You Sure You want to delete data");
       if(option==JOptionPane.YES_OPTION){
       try{
       pst=con.prepareStatement(sql);
       
       pst.execute();
       
       JOptionPane.showMessageDialog(null,"Deleted Succesfully","Message",JOptionPane.INFORMATION_MESSAGE);
       
       
           
       }catch(Exception e){
       e.printStackTrace();
       }
       }
    }//GEN-LAST:event_rm_deleteBtnMousePressed

    private void ca_searchBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ca_searchBtnMousePressed
        String type="";
        String from="";
        String to="";
        
        if(checkcBox(ca_roomType)==true && checkDatefield(ca_aDate,"From Date")==true && checkDatefield(ca_dDate,"To Date"))
        {type=ca_roomType.getSelectedItem().toString();
        from =((JTextField)ca_aDate.getDateEditor().getUiComponent()).getText();
        to=((JTextField)ca_dDate.getDateEditor().getUiComponent()).getText();
         
        try{
       
        String sql="Select * from rooms where not exists (select booking.room_no from booking where rooms.room_no=booking.room_no and ? between arrival_date and dep_date)" +
        "and not exists (select booking.room_no from booking where rooms.room_no=booking.room_no and ? between arrival_date and dep_date) and rooms.room_type= ? " ;   
       
        pst=con.prepareStatement(sql);
       
        pst.setString(1,from);
        pst.setString(2, to);
        pst.setString(3, type);
        rs=pst.executeQuery();
        ca_table.setModel(DbUtils.resultSetToTableModel(rs));
        setColumn(ca_table);
        if(ca_table.getRowCount()==0){
        
        JOptionPane.showMessageDialog(this,"Sorry No Record Found..!","Info",JOptionPane.INFORMATION_MESSAGE);
        }
            
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(this, e);}
        }
        
        
        
    }//GEN-LAST:event_ca_searchBtnMousePressed

    private void ar_saveBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ar_saveBtnMousePressed
        //set cuurent date
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        ar_booking_date.setText(format.format(date));
        //getData
        
        int roomNo=Integer.parseInt(ar_roomNo.getSelectedItem().toString());
        String roomType=ar_roomType.getSelectedItem().toString();
       
        
        String per =ar_persons_spin.getValue().toString();
        String user =ar_user_txt.getText();
        String pass=ar_password_txt.getText();
        int guest_id =Integer.parseInt(ar_guestId.getText());
        String  fname=ar_firstName_txt.getText();
        String lname=ar_lastName_txt.getText();
        String nat=ar_nat_txt.getText();
        String nid=ar_nic_txt.getText();
        String cnt =ar_contact_txt.getText();
        String gndr=ar_gender_cbox.getSelectedItem().toString();
        int p=ar_pickup_cbox.getSelectedIndex();
        boolean pickup=checkboolean(p);
        String add=ar_add_txt.getText();
        int rbill= Integer.parseInt(ar_total_txt.getText());
        int rec=Integer.parseInt(ar_rec_amount.getText());
        
        
        try{
       
        String sql1="Insert into guests (guest_id,first_name,last_name,nationality,nat_id,contact,gender,address)"
                + "values (?,?,?,?,?,?,?,?)";
        pst=con.prepareStatement(sql1);
        pst.setInt(1, guest_id);
        pst.setString(2, fname);
        pst.setString(3, lname);
        pst.setString(4, nat);
        pst.setString(5, nid);
        pst.setString(6, cnt);
        pst.setString(7, gndr);
        pst.setString(8, add);
        pst.execute();
        
        //getting date , Converting it to util.date to sql.date
        String a_date=((JTextField)ar_arrival_date.getDateEditor().getUiComponent()).getText();
        java.sql.Date adate = new java.sql.Date(format.parse(a_date).getTime());
        
        String d_date=((JTextField)ar_dep_date.getDateEditor().getUiComponent()).getText();
        java.sql.Date ddate = new java.sql.Date(format.parse(d_date).getTime());
        
        String b_date=ar_booking_date.getText();
        java.sql.Date bdate = new java.sql.Date(format.parse(b_date).getTime());
        
        
       
        String sql2="Insert into booking (room_no,guest_id,persons,booking_date,arrival_date,dep_date,amount_rec)"
            +"values((select room_no from rooms where room_no='"+roomNo+"'),(select guest_id from guests where guest_id='"+guest_id+"'),?,?,?,?,?)";
        pst=con.prepareStatement(sql2);
        pst.setString(1, per);
        pst.setDate(2,bdate);
        pst.setDate(3, adate);
        pst.setDate(4, ddate);
        pst.setInt(5,rec);
        
        pst.execute();
        
        String sql3="Insert into login (guest_id,user_name,password) values((select guest_id from guests where guest_id='"+guest_id+"'),?,?)";
        pst=con.prepareStatement(sql3);
        pst.setString(1, user);
        pst.setString(2, pass);
        pst.execute();
        
        
        String sql4="Insert into t_pickup (guest_id,pick_up) values ((select guest_id from guests where guest_id='"+guest_id+"'),?)";
        pst=con.prepareStatement(sql4);
        pst.setBoolean(1, pickup);
        pst.execute();
        
        ar_msg_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save_msg.png")));
       
        
       
        }
        catch(SQLException | ParseException | NullPointerException e){
           
        JOptionPane.showMessageDialog(this,e,"Error Message",JOptionPane.ERROR_MESSAGE);    
        
        ar_msg_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/error_msg.png")));
        }
                
        
        
    }//GEN-LAST:event_ar_saveBtnMousePressed

    private void ar_roomNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ar_roomNoMouseClicked
     int rn=Integer.parseInt(( ar_roomNo.getSelectedItem().toString()));
        
        try
        {
        String sql="Select * from rooms where room_no='"+rn+"'";
        int max=0;
        int rate=0;
        pst=con.prepareStatement(sql);
        rs=pst.executeQuery();
        while(rs.next()){
        max=Integer.parseInt(rs.getString("persons"));
        rate=rs.getInt("rate");
        }
        
        SpinnerNumberModel  sm = new SpinnerNumberModel();
        sm.setMaximum(max);
        sm.setMinimum(0);
        ar_persons_spin.setModel(sm);
        
        ar_rate_txt.setText(Integer.toString(rate));
        
        }
        catch(Exception e){e.printStackTrace();}        
    }//GEN-LAST:event_ar_roomNoMouseClicked

    private void ar_rec_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ar_rec_amountKeyReleased
        if(checkDatefield(ar_dep_date,"Departure Date")==true)
        {
            
        int rate= Integer.parseInt(ar_rate_txt.getText());
        String a_date=((JTextField)ar_arrival_date.getDateEditor().getUiComponent()).getText();
        String d_date=((JTextField)ar_dep_date.getDateEditor().getUiComponent()).getText();
        long days=datediff(a_date, d_date);
        int total = (int) (days * rate);
        ar_total_txt.setText(Integer.toString((int) total)); 
       
       int rec=Integer.parseInt(ar_rec_amount.getText());
       if(rec > total){
       JOptionPane.showMessageDialog(this,"The Received Amount is Greater than the total Bill","Error",JOptionPane.WARNING_MESSAGE);
       ar_rec_amount.setText("");
       ar_balance_txt.setText("");
       }
       else{
       int bal=total-rec;
       ar_balance_txt.setText(Integer.toString(bal));
       }
        
       }
        else{ar_rec_amount.setText("");} 
    }//GEN-LAST:event_ar_rec_amountKeyReleased

    private void ar_refershMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ar_refershMousePressed
        
        fillCombo("room_type",ar_roomType);
        
        
    }//GEN-LAST:event_ar_refershMousePressed

    private void ar_checkRooms_labelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ar_checkRooms_labelMousePressed
       if(checkcBox(ar_roomType)==true && checkDatefield(ar_arrival_date,"Arrival Date")==true && checkDatefield(ar_dep_date,"Departure Date"))
       {
        try
       {
       
       ar_roomNo.removeAllItems();
       String date1=((JTextField)ar_arrival_date.getDateEditor().getUiComponent()).getText();
       String date2=((JTextField)ar_dep_date.getDateEditor().getUiComponent()).getText();
       String type=ar_roomType.getSelectedItem().toString();
       String no="";
       
        String sql="Select * from rooms where not exists (select booking.room_no from booking where rooms.room_no=booking.room_no and ? between arrival_date and dep_date)" +
        "and not exists (select booking.room_no from booking where rooms.room_no=booking.room_no and ? between arrival_date and dep_date) and rooms.room_type= ? " ;   
       
       pst=con.prepareStatement(sql);
       pst.setString(1,date1 );
       pst.setString(2,date2 );
       pst.setString(3, type);
       rs=pst.executeQuery();
       while(rs.next()){
        no=Integer.toString(rs.getInt("room_no"));
       ar_roomNo.addItem(no);
       
       }
       if(ar_roomNo.getItemCount()==0){
       
       JOptionPane.showMessageDialog(null, "Sorry No rooms are availabel !","Info", JOptionPane.INFORMATION_MESSAGE);
           
       }
           
       }
       catch(Exception e){
       e.printStackTrace();
       }
       }
        
    }//GEN-LAST:event_ar_checkRooms_labelMousePressed

    private void ar_guestIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ar_guestIdKeyTyped
     char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE ))
        {
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_ar_guestIdKeyTyped

    private void ar_contact_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ar_contact_txtKeyTyped
       char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE ))
        {
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_ar_contact_txtKeyTyped

    private void ar_nic_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ar_nic_txtKeyTyped
       char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE ))
        {
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_ar_nic_txtKeyTyped

    private void ar_rec_amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ar_rec_amountKeyTyped
     char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE ))
        {
        getToolkit().beep();
        evt.consume();
        }
        
    }//GEN-LAST:event_ar_rec_amountKeyTyped

    private void ca_refershBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ca_refershBtnMousePressed
       fillCombo("room_type",ca_roomType);
    }//GEN-LAST:event_ca_refershBtnMousePressed

    private void al_searchBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_al_searchBtnMousePressed
    if(al_on_off==false)
    {
    try{
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String d=format.format(date);    
        
        
        String sql="Select guests.guest_id,rooms.room_no,rooms.room_type,guests.first_name,guests.last_name," +
                    "guests.contact,guests.address,booking.persons,booking.pick_up,booking.arrival_date,booking.check_in from booking " +
                    "inner join " +
                    "guests " +
                    "on guests.guest_id=booking.guest_id " +
                    "inner join " +
                    "rooms " +
                    "on rooms.room_no=booking.room_no " +
                    "where arrival_date = '"+d+"' order by arrival_date";
    pst=con.prepareStatement(sql);
    
    rs=pst.executeQuery();
    al_table.setModel(DbUtils.resultSetToTableModel(rs));
        setColumn(al_table);
     if(al_table.getRowCount()==0){
        
        JOptionPane.showMessageDialog(this,"Sorry No Record Found..!","Info",JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(this, e); }
    
    
    }
    else if (al_on_off==true)
    {
        
    
    if(checkcBox(al_roomType) &&checkDatefield(al_fromDate,"From Date")==true && checkDatefield(al_toDate,"To Date"))
    {    
    try
    {
        
       String type=al_roomType.getSelectedItem().toString();
       String from =((JTextField)al_fromDate.getDateEditor().getUiComponent()).getText();
       String  to=((JTextField)al_toDate.getDateEditor().getUiComponent()).getText();  
        
        
    String sql2="Select guests.guest_id,rooms.room_no,rooms.room_type,guests.first_name,guests.last_name," +
                "guests.contact,guests.address,booking.persons,booking.pick_up,booking.arrival_date,booking.check_in from booking  " +
                "inner join " +
                "guests " +
                "on guests.guest_id=booking.guest_id " +
                "inner join " +
                "rooms " +
                "on rooms.room_no=booking.room_no " +
                "where booking.arrival_date between ? and ? and rooms.room_type = ? " +
                "order by arrival_date";
      
    
      pst=con.prepareStatement(sql2);
      pst.setString(1, from);
      pst.setString(2, to);
      pst.setString(3, type);
      rs=pst.executeQuery();
      al_table.setModel(DbUtils.resultSetToTableModel(rs));
        setColumn(al_table);
        if(al_table.getRowCount()==0){
        
        JOptionPane.showMessageDialog(this,"Sorry No Record Found..!","Info",JOptionPane.INFORMATION_MESSAGE);
        }
              
    
    }catch(Exception e){e.printStackTrace();}
    
    
    }
    }
        
        
    }//GEN-LAST:event_al_searchBtnMousePressed

    private void ar_refersh1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ar_refersh1MousePressed
        fillCombo("room_type",al_roomType);        
    }//GEN-LAST:event_ar_refersh1MousePressed

    private void al_todayBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_al_todayBtnMouseClicked
        if(al_on_off==true){
        
        al_todayBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/radio_btn2.png")));
        al_roomType.setEnabled(false);
        al_fromDate.setEnabled(false);
        al_toDate.setEnabled(false);
        
       
        
        al_on_off=false;
        }
        else 
        {
        al_todayBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/radio_btn1.png")));
        al_roomType.setEnabled(true);
        al_fromDate.setEnabled(true);
        al_toDate.setEnabled(true);
        
        
        al_on_off=true;
        }  
    }//GEN-LAST:event_al_todayBtnMouseClicked

    private void al_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_al_tableMouseClicked
         int row =al_table.getSelectedRow();
        
       
       
        if(al_table.isRowSelected(row)==true)
       {
       al_checkInBtn.setEnabled(true);
       al_postponeBtn.setEnabled(true);
       al_cancelBtn.setEnabled(true);
       }
        else
        {
      al_checkInBtn.setEnabled(false);
       al_postponeBtn.setEnabled(false);
       al_cancelBtn.setEnabled(false);
        }
    }//GEN-LAST:event_al_tableMouseClicked

    private void al_checkInBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_al_checkInBtnMousePressed
         
        if(al_checkInBtn.isEnabled())
       {    
       al_checkInBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/checkBtn_3.png"))); // NOI18N

       int row = al_table.getSelectedRow();
       guest_id= (int) al_table.getModel().getValueAt(row, 0);
       
       
       try
       {
       
      String query="update booking  set check_in=1 where guest_id= '"+guest_id+"'";
      pst=con.prepareStatement(query);
      
        
      pst.execute();
     JOptionPane.showMessageDialog(this, "Guest No:"+guest_id+" is now Check In ", "Message",JOptionPane.INFORMATION_MESSAGE );
       
       
      
      
       
       
     
       }
       catch(Exception e){
       e.printStackTrace();
       }

       
       }    
        
        
        
    }//GEN-LAST:event_al_checkInBtnMousePressed

    private void al_cancelBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_al_cancelBtnMousePressed
        
       if(al_cancelBtn.isEnabled())
       {    
       int row = al_table.getSelectedRow();
       guest_id= (int) al_table.getModel().getValueAt(row, 0);
       
       String sql= "Delete from guests where guest_id='"+guest_id+"'";
       int option=JOptionPane.showConfirmDialog(null,"Are You Sure You want to Cancel the Reservation","Confirmation",JOptionPane.YES_NO_OPTION);
       if(option==JOptionPane.YES_OPTION){
       try{
       pst=con.prepareStatement(sql);
       
       pst.execute();
       
       JOptionPane.showMessageDialog(null,"Canceled Succesfully","Message",JOptionPane.INFORMATION_MESSAGE);
         
       }
       catch(Exception e){
       e.printStackTrace();
       }

       
       }     
       }
        
    }//GEN-LAST:event_al_cancelBtnMousePressed

    private void al_postponeBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_al_postponeBtnMousePressed

  if(al_postponeBtn.isEnabled()){      
  JDateChooser date= new JDateChooser();
  date.setDateFormatString("yyyy-MM-dd");
  String message = "Select  New Arrival Date";  
  Object[] params = {message, date};  
  JOptionPane.showMessageDialog(null, params, "Arrival Date", JOptionPane.QUESTION_MESSAGE);
  
  String date1=((JTextField)date.getDateEditor().getUiComponent()).getText();
  
 
  int room=0;
  int row = al_table.getSelectedRow();
  guest_id= (int)al_table.getModel().getValueAt(row, 0);
  int room_id=(int) al_table.getModel().getValueAt(row, 1);
  System.out.println("Date :"+date1+ "room id "+room_id+" guest id "+guest_id);
  try
  {
  
  String sql="Select room_no from rooms where not exists "
          + "(select booking.room_no from booking where rooms.room_no=booking.room_no and '"+date1+"' between arrival_date and dep_date "
          + "and guest_id != "+guest_id+" ) "
          + "and rooms.room_no = "+room_id+"";
  
  pst=con.prepareStatement(sql);
  rs=pst.executeQuery();
  
  if(rs.next()==true && date1 !="" && JOptionPane.CANCEL_OPTION !=-1)
  {
  room = rs.getInt("room_no");
  String sql2 ="Update booking set arrival_date='"+date1+"' where room_no="+room+" ";
  pst=con.prepareStatement(sql2);
  pst.execute();
  JOptionPane.showMessageDialog(this, "Succesfully Updated", "Message",JOptionPane.INFORMATION_MESSAGE );
  
  }
  
  else 
  {
  JOptionPane.showMessageDialog(this,"Sorry The Room No: "+room_id+" is Already Booked in "+date1+"");
  
  }
  
  } 
  
  
  catch(Exception e)
  {JOptionPane.showMessageDialog(this, e,"Error",JOptionPane.ERROR_MESSAGE);}
  }
        
        
    }//GEN-LAST:event_al_postponeBtnMousePressed

    private void ar_refersh2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ar_refersh2MousePressed
       fillCombo("room_type",dl_roomType);   
    }//GEN-LAST:event_ar_refersh2MousePressed

    private void dl_searchBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dl_searchBtnMousePressed
     if(dl_on_off==false)
    {
    try{
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String d=format.format(date);    
        
        
        String sql="Select guests.guest_id,rooms.room_no,rooms.room_type,guests.first_name,guests.last_name," +
                    "guests.contact,guests.address,booking.persons,booking.pick_up,booking.dep_date,booking.check_out from booking " +
                    "inner join " +
                    "guests " +
                    "on guests.guest_id=booking.guest_id " +
                    "inner join " +
                    "rooms " +
                    "on rooms.room_no=booking.room_no " +
                    "where dep_date = '"+d+"' order by dep_date";
    pst=con.prepareStatement(sql);
    
    rs=pst.executeQuery();
    dl_table.setModel(DbUtils.resultSetToTableModel(rs));
        setColumn(dl_table);
     if(dl_table.getRowCount()==0){
        
        JOptionPane.showMessageDialog(this,"Sorry No Record Found..!","Info",JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(this, e); }
    
    
    }
    else if (dl_on_off==true)
    {
        
    
    if(checkcBox(dl_roomType) &&checkDatefield(dl_fromDate,"From Date")==true && checkDatefield(dl_toDate,"To Date"))
    {    
    try
    {
        
       String type=dl_roomType.getSelectedItem().toString();
       String from =((JTextField)dl_fromDate.getDateEditor().getUiComponent()).getText();
       String  to=((JTextField)dl_toDate.getDateEditor().getUiComponent()).getText();  
        
        
    String sql2="Select guests.guest_id,rooms.room_no,rooms.room_type,guests.first_name,guests.last_name," +
                "guests.contact,guests.address,booking.persons,booking.pick_up,booking.dep_date,booking.check_out from booking  " +
                "inner join " +
                "guests " +
                "on guests.guest_id=booking.guest_id " +
                "inner join " +
                "rooms " +
                "on rooms.room_no=booking.room_no " +
                "where booking.dep_date between ? and ? and rooms.room_type = ? " +
                "order by dep_date";
      
    
      pst=con.prepareStatement(sql2);
      pst.setString(1, from);
      pst.setString(2, to);
      pst.setString(3, type);
      rs=pst.executeQuery();
      dl_table.setModel(DbUtils.resultSetToTableModel(rs));
        setColumn(dl_table);
        if(dl_table.getRowCount()==0){
        
        JOptionPane.showMessageDialog(this,"Sorry No Record Found..!","Info",JOptionPane.INFORMATION_MESSAGE);
        }
              
    
    }catch(Exception e){e.printStackTrace();}
    
    
    }
    }
      
        
        
    }//GEN-LAST:event_dl_searchBtnMousePressed

    private void dl_checkoutBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dl_checkoutBtnMousePressed
          if(dl_checkoutBtn.isEnabled())
       {    
       dl_checkoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/co_btn3.png"))); // NOI18N

       int row = dl_table.getSelectedRow();
       guest_id= (int) dl_table.getModel().getValueAt(row, 0);
       
       
       try
       {
       
      String query="update booking  set check_out=1 where guest_id= '"+guest_id+"'";
      pst=con.prepareStatement(query);
      
        
      pst.execute();
     JOptionPane.showMessageDialog(this, "Guest No:"+guest_id+" is now Check Out ", "Message",JOptionPane.INFORMATION_MESSAGE );
       
       
      
      
       
       
     
       }
       catch(Exception e){
       e.printStackTrace();
       }

       
       }    
        
        
        
        
    }//GEN-LAST:event_dl_checkoutBtnMousePressed

    private void dl_postponeBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dl_postponeBtnMousePressed
    if(dl_postponeBtn.isEnabled()){      
  JDateChooser date= new JDateChooser();
  date.setDateFormatString("yyyy-MM-dd");
  String message = "Select  New Departure Date";  
  Object[] params = {message, date};  
  JOptionPane.showMessageDialog(null, params, "Departure Date", JOptionPane.QUESTION_MESSAGE);
  
  String date1=((JTextField)date.getDateEditor().getUiComponent()).getText();
  
 
  int room=0;
  int row = dl_table.getSelectedRow();
  guest_id= (int)dl_table.getModel().getValueAt(row, 0);
  int room_id=(int) dl_table.getModel().getValueAt(row, 1);
 
  try
  {
  
  String sql="Select room_no from rooms where not exists "
          + "(select booking.room_no from booking where rooms.room_no=booking.room_no and '"+date1+"' between arrival_date and dep_date "
          + "and guest_id != "+guest_id+" ) "
          + "and rooms.room_no = "+room_id+"";
  
  pst=con.prepareStatement(sql);
  rs=pst.executeQuery();
  
  if(rs.next()==true && date1 !="" && JOptionPane.CANCEL_OPTION !=-1)
  {
  room = rs.getInt("room_no");
  String sql2 ="Update booking set dep_date='"+date1+"' where room_no="+room+" ";
  pst=con.prepareStatement(sql2);
  pst.execute();
  JOptionPane.showMessageDialog(this, "Succesfully Updated", "Message",JOptionPane.INFORMATION_MESSAGE );
  
  }
  
  else 
  {
  JOptionPane.showMessageDialog(this,"Sorry The Room No: "+room_id+" is Already Booked in "+date1+"");
  
  }
  
  } 
  
  
  catch(Exception e)
  {JOptionPane.showMessageDialog(this, e,"Error",JOptionPane.ERROR_MESSAGE);}
  }


    }//GEN-LAST:event_dl_postponeBtnMousePressed

    private void al_checkInBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_al_checkInBtnMouseEntered
al_checkInBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/checkBtn_2.png"))); // NOI18N

    }//GEN-LAST:event_al_checkInBtnMouseEntered

    private void al_checkInBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_al_checkInBtnMouseExited
al_checkInBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/checkBtn_1.png"))); // NOI18N

    }//GEN-LAST:event_al_checkInBtnMouseExited

    private void al_checkInBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_al_checkInBtnMouseReleased
al_checkInBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/checkBtn_1.png"))); // NOI18N

    }//GEN-LAST:event_al_checkInBtnMouseReleased

    private void dl_checkoutBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dl_checkoutBtnMouseEntered
dl_checkoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/co_btn2.png"))); // NOI18N

    }//GEN-LAST:event_dl_checkoutBtnMouseEntered

    private void dl_checkoutBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dl_checkoutBtnMouseExited
dl_checkoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/co_btn1.png"))); // NOI18N

    }//GEN-LAST:event_dl_checkoutBtnMouseExited

    private void dl_checkoutBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dl_checkoutBtnMouseReleased
dl_checkoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/co_btn1.png"))); // NOI18N

    }//GEN-LAST:event_dl_checkoutBtnMouseReleased

    private void dl_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dl_tableMouseClicked
     
        int row =dl_table.getSelectedRow();
        
       
       
        if(dl_table.isRowSelected(row)==true)
       {
       dl_checkoutBtn.setEnabled(true);
       dl_postponeBtn.setEnabled(true);
      
       }
        else
        {
        dl_checkoutBtn.setEnabled(false);
        al_postponeBtn.setEnabled(false);
       
        }
    }//GEN-LAST:event_dl_tableMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adm_label;
    private javax.swing.JLabel admin_label;
    private javax.swing.JLabel al_bgImg;
    private javax.swing.JLabel al_bgImg1;
    private javax.swing.JLabel al_cancelBtn;
    private javax.swing.JLabel al_checkInBtn;
    private javax.swing.JLabel al_closeBtn;
    private com.toedter.calendar.JDateChooser al_fromDate;
    private javax.swing.JLabel al_label1;
    private javax.swing.JLabel al_label3;
    private javax.swing.JLabel al_label4;
    private javax.swing.JLabel al_label5;
    private javax.swing.JLabel al_label6;
    private javax.swing.JLabel al_postponeBtn;
    private javax.swing.JComboBox al_roomType;
    private javax.swing.JLabel al_searchBtn;
    private javax.swing.JPanel al_tab;
    private javax.swing.JTable al_table;
    private javax.swing.JScrollPane al_tablepane;
    private com.toedter.calendar.JDateChooser al_toDate;
    private javax.swing.JLabel al_todayBtn;
    private javax.swing.JTextArea ar_add_txt;
    private com.toedter.calendar.JDateChooser ar_arrival_date;
    private javax.swing.JTextField ar_balance_txt;
    private javax.swing.JLabel ar_bgImage;
    private javax.swing.JTextField ar_booking_date;
    private javax.swing.JLabel ar_checkRooms_label;
    private javax.swing.JLabel ar_closeBtn;
    private javax.swing.JTextField ar_contact_txt;
    private com.toedter.calendar.JDateChooser ar_dep_date;
    private javax.swing.JTextField ar_firstName_txt;
    private javax.swing.JPanel ar_formPanel;
    private javax.swing.JComboBox ar_gender_cbox;
    private javax.swing.JTextField ar_guestId;
    private javax.swing.JLabel ar_label1;
    private javax.swing.JLabel ar_label10;
    private javax.swing.JLabel ar_label11;
    private javax.swing.JLabel ar_label12;
    private javax.swing.JLabel ar_label13;
    private javax.swing.JLabel ar_label14;
    private javax.swing.JLabel ar_label15;
    private javax.swing.JLabel ar_label16;
    private javax.swing.JLabel ar_label17;
    private javax.swing.JLabel ar_label18;
    private javax.swing.JLabel ar_label19;
    private javax.swing.JLabel ar_label2;
    private javax.swing.JLabel ar_label20;
    private javax.swing.JLabel ar_label21;
    private javax.swing.JLabel ar_label23;
    private javax.swing.JLabel ar_label24;
    private javax.swing.JLabel ar_label25;
    private javax.swing.JLabel ar_label3;
    private javax.swing.JLabel ar_label4;
    private javax.swing.JLabel ar_label5;
    private javax.swing.JLabel ar_label6;
    private javax.swing.JLabel ar_label7;
    private javax.swing.JLabel ar_label8;
    private javax.swing.JLabel ar_label9;
    private javax.swing.JTextField ar_lastName_txt;
    private javax.swing.JLabel ar_msg_label;
    private javax.swing.JTextField ar_nat_txt;
    private javax.swing.JTextField ar_nic_txt;
    private javax.swing.JTextField ar_password_txt;
    private javax.swing.JSpinner ar_persons_spin;
    private javax.swing.JComboBox ar_pickup_cbox;
    private javax.swing.JPanel ar_rate_panel;
    private javax.swing.JTextField ar_rate_txt;
    private javax.swing.JTextField ar_rec_amount;
    private javax.swing.JLabel ar_refersh;
    private javax.swing.JLabel ar_refersh1;
    private javax.swing.JLabel ar_refersh2;
    private javax.swing.JLabel ar_resetBtn;
    private javax.swing.JComboBox ar_roomNo;
    private javax.swing.JComboBox ar_roomType;
    private javax.swing.JLabel ar_saveBtn;
    private javax.swing.JScrollPane ar_scrollPane;
    private javax.swing.JSeparator ar_sep1;
    private javax.swing.JSeparator ar_sep2;
    private javax.swing.JSeparator ar_sep3;
    private javax.swing.JPanel ar_tab;
    private javax.swing.JTextField ar_total_txt;
    private javax.swing.JLabel ar_txtLabel1;
    private javax.swing.JLabel ar_txtLabel10;
    private javax.swing.JLabel ar_txtLabel2;
    private javax.swing.JLabel ar_txtLabel3;
    private javax.swing.JLabel ar_txtLabel4;
    private javax.swing.JLabel ar_txtLabel5;
    private javax.swing.JLabel ar_txtLabel6;
    private javax.swing.JLabel ar_txtLabel7;
    private javax.swing.JLabel ar_txtLabel9;
    private javax.swing.JTextField ar_user_txt;
    private javax.swing.JLabel arrival_list;
    private javax.swing.JLabel back_label;
    private javax.swing.JLabel bg_image;
    private javax.swing.JPanel body_panel;
    private javax.swing.JPanel btn_panel;
    private com.toedter.calendar.JDateChooser ca_aDate;
    private javax.swing.JLabel ca_bgImg;
    private javax.swing.JLabel ca_closeBtn;
    private com.toedter.calendar.JDateChooser ca_dDate;
    private javax.swing.JPanel ca_formPanel;
    private javax.swing.JLabel ca_label1;
    private javax.swing.JLabel ca_label2;
    private javax.swing.JLabel ca_label3;
    private javax.swing.JLabel ca_label4;
    private javax.swing.JLabel ca_label5;
    private javax.swing.JLabel ca_refershBtn;
    private javax.swing.JComboBox ca_roomType;
    private javax.swing.JLabel ca_searchBtn;
    private javax.swing.JPanel ca_tab;
    private javax.swing.JTable ca_table;
    private javax.swing.JScrollPane ca_tablePane;
    private javax.swing.JPanel ca_tablePanel;
    private javax.swing.JPanel center_inner;
    private javax.swing.JPanel center_outer;
    private javax.swing.JLabel check_availability;
    private javax.swing.JLabel clock;
    private javax.swing.JLabel clock2;
    private javax.swing.JLabel close_label;
    private javax.swing.JLabel day;
    private javax.swing.JLabel departure_list;
    private javax.swing.JLabel dl_checkoutBtn;
    private javax.swing.JLabel dl_closeBtn;
    private com.toedter.calendar.JDateChooser dl_fromDate;
    private javax.swing.JLabel dl_label1;
    private javax.swing.JLabel dl_label3;
    private javax.swing.JLabel dl_label4;
    private javax.swing.JLabel dl_label5;
    private javax.swing.JLabel dl_label6;
    private javax.swing.JLabel dl_postponeBtn;
    private javax.swing.JComboBox dl_roomType;
    private javax.swing.JLabel dl_searchBtn;
    private javax.swing.JPanel dl_tab;
    private javax.swing.JTable dl_table;
    private javax.swing.JScrollPane dl_tablepane;
    private com.toedter.calendar.JDateChooser dl_toDate;
    private javax.swing.JLabel dl_todayBtn;
    private javax.swing.JPanel footer_panel;
    private javax.swing.JPanel header_panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel mini_label;
    private javax.swing.JLabel month;
    private javax.swing.JTabbedPane res_jtab;
    private javax.swing.JLabel reservation;
    private javax.swing.JCheckBox rm_ac;
    private javax.swing.JCheckBox rm_bar;
    private javax.swing.JComboBox rm_bedType;
    private javax.swing.JLabel rm_bgImg;
    private javax.swing.JLabel rm_closeBtn;
    private javax.swing.JLabel rm_deleteBtn;
    private javax.swing.JLabel rm_error1;
    private javax.swing.JLabel rm_error2;
    private javax.swing.JLabel rm_error3;
    private javax.swing.JLabel rm_error4;
    private javax.swing.JPanel rm_form;
    private javax.swing.JCheckBox rm_fridge;
    private javax.swing.JLabel rm_label1;
    private javax.swing.JLabel rm_label2;
    private javax.swing.JLabel rm_label3;
    private javax.swing.JLabel rm_label4;
    private javax.swing.JLabel rm_label5;
    private javax.swing.JLabel rm_label6;
    private javax.swing.JLabel rm_label7;
    private javax.swing.JLabel rm_label8;
    private javax.swing.JCheckBox rm_led;
    private javax.swing.JLabel rm_msg;
    private javax.swing.JSpinner rm_persons;
    private javax.swing.JTextField rm_rate;
    private javax.swing.JLabel rm_rateL;
    private javax.swing.JLabel rm_refreshBtn;
    private javax.swing.JLabel rm_reset;
    private javax.swing.JTextField rm_roomNo;
    private javax.swing.JLabel rm_roomNoL;
    private javax.swing.JTextField rm_roomType;
    private javax.swing.JLabel rm_roomTypeL;
    private javax.swing.JLabel rm_save;
    private javax.swing.JPanel rm_tab;
    private javax.swing.JTable rm_tabel;
    private javax.swing.JPanel rm_tablePanel;
    private javax.swing.JScrollPane rm_tableScrolPane;
    private javax.swing.JCheckBox rm_tea;
    private javax.swing.JCheckBox rm_tele;
    private javax.swing.JCheckBox rm_wifi;
    private javax.swing.JCheckBox rm_window;
    private javax.swing.JLabel room_managment;
    private javax.swing.JPanel side_btn;
    private javax.swing.JPanel side_panel;
    private javax.swing.JLabel time_label;
    private javax.swing.JPanel time_panel;
    private javax.swing.JLabel year;
    // End of variables declaration//GEN-END:variables
}
