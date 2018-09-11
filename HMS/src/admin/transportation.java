
package admin;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import net.proteanit.sql.DbUtils;


public class transportation extends javax.swing.JFrame {
    int timerun =0;
    ResultSet rs =null;
    PreparedStatement pst=null;
    Connection con =null;
    String at_path;
    String mt_path;
    boolean on_off=true; 
    int t_id;
    int rate;
    int bill;
    String table;
    
    //methods
      private void updateTable(int id,JTable tabel){
     try
     {   
    String sql="Select * from transport where transport_id='"+id+"'";
    pst=con.prepareStatement(sql);
    rs=pst.executeQuery();
    tabel.setModel(DbUtils.resultSetToTableModel(rs));
     }
     catch(Exception e)
     {
     e.printStackTrace();
     }
    
    }
   //2
     private String checkService(int s){
        String table;
      
        if(s==0){
        table="t_pickup";
        }
        else 
        {
        table="t_dropoff";
        
        }
        return table;
     
     } 
     //3
     private String checkDateCol(String t){
     String coloumn="";
     if(t.equals("t_pickup")){
     
     coloumn="arrival_date";
     }
     else if(t.equals("t_dropoff")){
     
     coloumn="dep_date";
     }        
     return coloumn;
     }
     //4
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
   //5 
      private  void  check_trans_not(){
      try{
       int total=0;
       String sql="Select * from t_pickup where pick_up=1 and status=0";
       pst=con.prepareStatement(sql);
       rs=pst.executeQuery();
       while(rs.next()){
       total++;
       
       }
       
       
       String sql2="Select * from t_dropoff where drop_off=1 and status=0";
       pst=con.prepareStatement(sql2);
       rs=pst.executeQuery();
        while(rs.next()){
         total++;
         
        }
       
        if(total > 0){
        trans_not_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/not_label.png")));
        trans_notNum_label.setText(Integer.toString(total));
        }
        else if(total<=0){
        
        trans_notNum_label.setText("");
        trans_not_label.setIcon(null);
        
        
        }
       
       
       
      
      }catch(Exception e){
          
      e.printStackTrace();
      
      }
      
      
      }
      //6
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
 
    tableColumn.setPreferredWidth( preferredWidth+40);
}
        }
        else{
            tabel.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        }
    }
    

    public transportation() 
    {
        initComponents();
       Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
       this.setSize(d.width, d.height);
       bg_image.setSize(d.width,d.height);
       body_panel.setSize(d.width,d.height);
       con=DatabaseManager.getconnect();
       transport_tab.removeAll();
       check_trans_not();
       
        
        
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

    
    
    
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        body_panel = new javax.swing.JPanel();
        side_panel = new javax.swing.JPanel();
        side_btn = new javax.swing.JPanel();
        add_transport = new javax.swing.JLabel();
        modify_transport = new javax.swing.JLabel();
        set_destination = new javax.swing.JLabel();
        trans_notNum_label = new javax.swing.JLabel();
        trans_not_label = new javax.swing.JLabel();
        view_booking = new javax.swing.JLabel();
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
        logout = new javax.swing.JLabel();
        ar_refersh2 = new javax.swing.JLabel();
        back_label = new javax.swing.JLabel();
        footer_panel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        center_outer = new javax.swing.JPanel();
        center_inner = new javax.swing.JPanel();
        transport_tab = new javax.swing.JTabbedPane();
        mt_tab = new javax.swing.JPanel();
        mt_form = new javax.swing.JPanel();
        mt_label3 = new javax.swing.JLabel();
        mt_label4 = new javax.swing.JLabel();
        mt_label6 = new javax.swing.JLabel();
        mt_label5 = new javax.swing.JLabel();
        mt_modelNo_txt = new javax.swing.JTextField();
        mt_maker_txt = new javax.swing.JTextField();
        mt_cnd_comboBox = new javax.swing.JComboBox();
        mt_rate_txt = new javax.swing.JTextField();
        mt_txtLabel2 = new javax.swing.JLabel();
        mt_txtLabel3 = new javax.swing.JLabel();
        mt_txtLabel1 = new javax.swing.JLabel();
        mt_imageFrame = new javax.swing.JPanel();
        mt_selectImg = new javax.swing.JLabel();
        mt_selectImg_Btn = new javax.swing.JLabel();
        mt_closeBtn = new javax.swing.JLabel();
        mt_deleteBtn = new javax.swing.JLabel();
        mt_updateBtn = new javax.swing.JLabel();
        mt_searchBtn = new javax.swing.JLabel();
        mt_pane = new javax.swing.JScrollPane();
        mt_table = new javax.swing.JTable();
        mt_label2 = new javax.swing.JLabel();
        mt_label1 = new javax.swing.JLabel();
        mt_bgImg = new javax.swing.JLabel();
        sd_tab = new javax.swing.JPanel();
        sd_closeBtn = new javax.swing.JLabel();
        sd_label1 = new javax.swing.JLabel();
        sd_label5 = new javax.swing.JLabel();
        sd_trspt_jcb = new javax.swing.JComboBox();
        sd_label6 = new javax.swing.JLabel();
        sd_km_spin = new javax.swing.JSpinner();
        sd_label7 = new javax.swing.JLabel();
        sd_driveTo_txt = new javax.swing.JTextField();
        sd_txtLabel1 = new javax.swing.JLabel();
        sd_label8 = new javax.swing.JLabel();
        sd_driveFrom_txt = new javax.swing.JTextField();
        sd_txtlabel2 = new javax.swing.JLabel();
        sd_label9 = new javax.swing.JLabel();
        sd_tbill_txt = new javax.swing.JTextField();
        sd_txtLabel3 = new javax.swing.JLabel();
        sd_saveBtn = new javax.swing.JLabel();
        sd_label10 = new javax.swing.JLabel();
        sd_cond_cbox = new javax.swing.JComboBox();
        sd_checkBtn = new javax.swing.JLabel();
        sd_label11 = new javax.swing.JLabel();
        sd_guest_cbox = new javax.swing.JComboBox();
        sd_bgImg = new javax.swing.JLabel();
        at_tab = new javax.swing.JPanel();
        at_form = new javax.swing.JPanel();
        at_label2 = new javax.swing.JLabel();
        at_label3 = new javax.swing.JLabel();
        at_label4 = new javax.swing.JLabel();
        at_label5 = new javax.swing.JLabel();
        at_modelNo_txt = new javax.swing.JTextField();
        at_maker_txt = new javax.swing.JTextField();
        at_condition_jcb = new javax.swing.JComboBox();
        at_saveBtn = new javax.swing.JLabel();
        at_resetBtn = new javax.swing.JLabel();
        at_txtlabel2 = new javax.swing.JLabel();
        at_txtlabel1 = new javax.swing.JLabel();
        at_rate_txt = new javax.swing.JTextField();
        at_txtLabel3 = new javax.swing.JLabel();
        at_selectImg_btn = new javax.swing.JLabel();
        at_imageFrame = new javax.swing.JPanel();
        at_select_image = new javax.swing.JLabel();
        at_error2 = new javax.swing.JLabel();
        at_msg = new javax.swing.JLabel();
        at_error1 = new javax.swing.JLabel();
        at_error3 = new javax.swing.JLabel();
        at_label1 = new javax.swing.JLabel();
        at_closeBtn = new javax.swing.JLabel();
        at_bgImg = new javax.swing.JLabel();
        vb_tab = new javax.swing.JPanel();
        vb_label1 = new javax.swing.JLabel();
        vb_service_cb = new javax.swing.JComboBox();
        vb_label2 = new javax.swing.JLabel();
        vb_From_date = new com.toedter.calendar.JDateChooser();
        vb_label3 = new javax.swing.JLabel();
        vb_label4 = new javax.swing.JLabel();
        vb_To_date = new com.toedter.calendar.JDateChooser();
        vb_searchBtn = new javax.swing.JLabel();
        vb_closeBtn = new javax.swing.JLabel();
        vb_todayBtn = new javax.swing.JLabel();
        vb_tablePane = new javax.swing.JScrollPane();
        vb_tabel = new javax.swing.JTable();
        vb_label5 = new javax.swing.JLabel();
        vb_confirmBtn = new javax.swing.JLabel();
        vb_updateBtn = new javax.swing.JLabel();
        vb_deleteBtn = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        vb_bgImg = new javax.swing.JLabel();
        bg_image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        body_panel.setOpaque(false);
        body_panel.setLayout(new java.awt.BorderLayout());

        side_panel.setOpaque(false);

        side_btn.setOpaque(false);
        side_btn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add_transport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/add_transport1.jpg"))); // NOI18N
        add_transport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add_transport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_transportMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add_transportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                add_transportMouseExited(evt);
            }
        });
        side_btn.add(add_transport, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 293, -1));

        modify_transport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/modify_transport1.jpg"))); // NOI18N
        modify_transport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modify_transport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modify_transportMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                modify_transportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                modify_transportMouseExited(evt);
            }
        });
        side_btn.add(modify_transport, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 128, 293, -1));

        set_destination.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/set_destination1.jpg"))); // NOI18N
        set_destination.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        set_destination.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                set_destinationMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                set_destinationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                set_destinationMouseExited(evt);
            }
        });
        side_btn.add(set_destination, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 256, 293, -1));

        trans_notNum_label.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        trans_notNum_label.setForeground(new java.awt.Color(255, 255, 255));
        trans_notNum_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        side_btn.add(trans_notNum_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 378, 50, 50));

        trans_not_label.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        side_btn.add(trans_not_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, -1, -1));

        view_booking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/view_booking1.jpg"))); // NOI18N
        view_booking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        view_booking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view_bookingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                view_bookingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                view_bookingMouseExited(evt);
            }
        });
        side_btn.add(view_booking, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 384, 293, -1));

        javax.swing.GroupLayout side_panelLayout = new javax.swing.GroupLayout(side_panel);
        side_panel.setLayout(side_panelLayout);
        side_panelLayout.setHorizontalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(side_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        side_panelLayout.setVerticalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(side_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
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

        ar_refersh2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ar_refersh2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ar_refersh2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/reload.png"))); // NOI18N
        ar_refersh2.setText("Refresh");
        ar_refersh2.setToolTipText("");
        ar_refersh2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        ar_refersh2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ar_refersh2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ar_refersh2MousePressed(evt);
            }
        });

        back_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/back_label.png"))); // NOI18N
        back_label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_labelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout header_panelLayout = new javax.swing.GroupLayout(header_panel);
        header_panel.setLayout(header_panelLayout);
        header_panelLayout.setHorizontalGroup(
            header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_panelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(back_label)
                .addGap(374, 374, 374)
                .addComponent(time_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 434, Short.MAX_VALUE)
                .addGroup(header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(header_panelLayout.createSequentialGroup()
                        .addComponent(ar_refersh2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(logout)
                        .addContainerGap())))
            .addGroup(header_panelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(admin_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adm_label, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        header_panelLayout.setVerticalGroup(
            header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
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
                        .addGroup(header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ar_refersh2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(time_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        body_panel.add(header_panel, java.awt.BorderLayout.PAGE_START);

        footer_panel.setOpaque(false);
        footer_panel.setLayout(new java.awt.BorderLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/logo1.png"))); // NOI18N
        footer_panel.add(logo, java.awt.BorderLayout.EAST);

        body_panel.add(footer_panel, java.awt.BorderLayout.PAGE_END);

        center_outer.setOpaque(false);

        center_inner.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        center_inner.setAutoscrolls(true);
        center_inner.setMaximumSize(new java.awt.Dimension(950, 730));
        center_inner.setMinimumSize(new java.awt.Dimension(950, 730));
        center_inner.setOpaque(false);

        transport_tab.setPreferredSize(new java.awt.Dimension(945, 600));

        mt_tab.setLayout(null);

        mt_form.setOpaque(false);
        mt_form.setLayout(null);

        mt_label3.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mt_label3.setText("Model No");
        mt_form.add(mt_label3);
        mt_label3.setBounds(50, 320, 120, 40);

        mt_label4.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mt_label4.setText("Maker");
        mt_form.add(mt_label4);
        mt_label4.setBounds(50, 370, 110, 40);

        mt_label6.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mt_label6.setText("Condition");
        mt_form.add(mt_label6);
        mt_label6.setBounds(50, 480, 80, 30);

        mt_label5.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mt_label5.setText("Rate Per Km");
        mt_form.add(mt_label5);
        mt_label5.setBounds(50, 420, 110, 40);

        mt_modelNo_txt.setBackground(new java.awt.Color(123, 211, 172));
        mt_modelNo_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mt_modelNo_txt.setBorder(null);
        mt_modelNo_txt.setOpaque(false);
        mt_modelNo_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        mt_form.add(mt_modelNo_txt);
        mt_modelNo_txt.setBounds(170, 330, 130, 23);

        mt_maker_txt.setBackground(new java.awt.Color(123, 211, 172));
        mt_maker_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mt_maker_txt.setBorder(null);
        mt_maker_txt.setOpaque(false);
        mt_maker_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        mt_form.add(mt_maker_txt);
        mt_maker_txt.setBounds(170, 380, 130, 23);

        mt_cnd_comboBox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mt_cnd_comboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Excellent", "Good", "Average" }));
        mt_form.add(mt_cnd_comboBox);
        mt_cnd_comboBox.setBounds(170, 480, 130, 25);

        mt_rate_txt.setBackground(new java.awt.Color(123, 211, 172));
        mt_rate_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mt_rate_txt.setBorder(null);
        mt_rate_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        mt_form.add(mt_rate_txt);
        mt_rate_txt.setBounds(170, 430, 130, 23);

        mt_txtLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        mt_form.add(mt_txtLabel2);
        mt_txtLabel2.setBounds(160, 370, 150, 40);

        mt_txtLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        mt_form.add(mt_txtLabel3);
        mt_txtLabel3.setBounds(160, 420, 150, 40);

        mt_txtLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        mt_form.add(mt_txtLabel1);
        mt_txtLabel1.setBounds(160, 320, 150, 40);

        mt_imageFrame.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        mt_imageFrame.setPreferredSize(new java.awt.Dimension(215, 215));

        mt_selectImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_car.png"))); // NOI18N
        mt_selectImg.setMaximumSize(new java.awt.Dimension(215, 215));

        javax.swing.GroupLayout mt_imageFrameLayout = new javax.swing.GroupLayout(mt_imageFrame);
        mt_imageFrame.setLayout(mt_imageFrameLayout);
        mt_imageFrameLayout.setHorizontalGroup(
            mt_imageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mt_selectImg, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );
        mt_imageFrameLayout.setVerticalGroup(
            mt_imageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mt_imageFrameLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mt_selectImg, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mt_form.add(mt_imageFrame);
        mt_imageFrame.setBounds(130, 80, 210, 220);

        mt_selectImg_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_1.png"))); // NOI18N
        mt_selectImg_Btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mt_selectImg_Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mt_selectImg_BtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mt_selectImg_BtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mt_selectImg_BtnMouseExited(evt);
            }
        });
        mt_form.add(mt_selectImg_Btn);
        mt_selectImg_Btn.setBounds(20, 80, 100, 50);

        mt_tab.add(mt_form);
        mt_form.setBounds(0, 90, 390, 550);

        mt_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        mt_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mt_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mt_closeBtnMouseClicked(evt);
            }
        });
        mt_tab.add(mt_closeBtn);
        mt_closeBtn.setBounds(900, 0, 34, 31);

        mt_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_1.png"))); // NOI18N
        mt_deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mt_deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mt_deleteBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mt_deleteBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mt_deleteBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mt_deleteBtnMousePressed(evt);
            }
        });
        mt_tab.add(mt_deleteBtn);
        mt_deleteBtn.setBounds(780, 90, 100, 50);

        mt_updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/update1.png"))); // NOI18N
        mt_updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mt_updateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mt_updateBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mt_updateBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mt_updateBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mt_updateBtnMousePressed(evt);
            }
        });
        mt_tab.add(mt_updateBtn);
        mt_updateBtn.setBounds(660, 90, 100, 50);

        mt_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/s_1.png"))); // NOI18N
        mt_searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mt_searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mt_searchBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mt_searchBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mt_searchBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mt_searchBtnMousePressed(evt);
            }
        });
        mt_tab.add(mt_searchBtn);
        mt_searchBtn.setBounds(550, 90, 100, 50);

        mt_pane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        mt_table.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        mt_table.setRowHeight(30);
        mt_table.setSelectionBackground(new java.awt.Color(3, 201, 169));
        mt_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mt_tableMouseClicked(evt);
            }
        });
        mt_pane.setViewportView(mt_table);

        mt_tab.add(mt_pane);
        mt_pane.setBounds(392, 140, 550, 530);

        mt_label2.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        mt_label2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/rc_header.png"))); // NOI18N
        mt_tab.add(mt_label2);
        mt_label2.setBounds(390, 100, 130, 40);

        mt_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        mt_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mt_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/mt_h.png"))); // NOI18N
        mt_tab.add(mt_label1);
        mt_label1.setBounds(0, 20, 200, 50);

        mt_bgImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        mt_bgImg.setText("Data");
        mt_tab.add(mt_bgImg);
        mt_bgImg.setBounds(0, 0, 940, 690);

        transport_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/mt_tab.jpg")), mt_tab); // NOI18N
        mt_tab.getAccessibleContext().setAccessibleParent(transport_tab);

        sd_tab.setLayout(null);

        sd_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        sd_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sd_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sd_closeBtnMouseClicked(evt);
            }
        });
        sd_tab.add(sd_closeBtn);
        sd_closeBtn.setBounds(903, 0, 30, 30);

        sd_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        sd_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/sd_h.png"))); // NOI18N
        sd_tab.add(sd_label1);
        sd_label1.setBounds(0, 20, 180, 50);

        sd_label5.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        sd_label5.setText("Transport");
        sd_tab.add(sd_label5);
        sd_label5.setBounds(450, 210, 90, 40);

        sd_trspt_jcb.setFont(new java.awt.Font("GardensC", 0, 14)); // NOI18N
        sd_trspt_jcb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sd_trspt_jcbMousePressed(evt);
            }
        });
        sd_tab.add(sd_trspt_jcb);
        sd_trspt_jcb.setBounds(580, 220, 130, 30);

        sd_label6.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        sd_label6.setText("Drive Per Km");
        sd_tab.add(sd_label6);
        sd_label6.setBounds(150, 210, 100, 40);

        sd_km_spin.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        sd_km_spin.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sd_km_spinStateChanged(evt);
            }
        });
        sd_tab.add(sd_km_spin);
        sd_km_spin.setBounds(280, 220, 130, 25);

        sd_label7.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        sd_label7.setText("Drive To");
        sd_tab.add(sd_label7);
        sd_label7.setBounds(150, 270, 90, 40);

        sd_driveTo_txt.setBackground(new java.awt.Color(123, 211, 172));
        sd_driveTo_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        sd_driveTo_txt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sd_driveTo_txt.setBorder(null);
        sd_driveTo_txt.setOpaque(false);
        sd_driveTo_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        sd_tab.add(sd_driveTo_txt);
        sd_driveTo_txt.setBounds(280, 280, 130, 23);

        sd_txtLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        sd_tab.add(sd_txtLabel1);
        sd_txtLabel1.setBounds(270, 270, 150, 40);

        sd_label8.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        sd_label8.setText("Drive From");
        sd_tab.add(sd_label8);
        sd_label8.setBounds(450, 270, 90, 40);

        sd_driveFrom_txt.setBackground(new java.awt.Color(123, 211, 172));
        sd_driveFrom_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        sd_driveFrom_txt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sd_driveFrom_txt.setBorder(null);
        sd_driveFrom_txt.setOpaque(false);
        sd_driveFrom_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        sd_tab.add(sd_driveFrom_txt);
        sd_driveFrom_txt.setBounds(580, 280, 130, 23);

        sd_txtlabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        sd_tab.add(sd_txtlabel2);
        sd_txtlabel2.setBounds(570, 270, 150, 40);

        sd_label9.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        sd_label9.setText("Total Bill");
        sd_tab.add(sd_label9);
        sd_label9.setBounds(150, 340, 90, 40);

        sd_tbill_txt.setEditable(false);
        sd_tbill_txt.setBackground(new java.awt.Color(123, 211, 172));
        sd_tbill_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        sd_tbill_txt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sd_tbill_txt.setBorder(null);
        sd_tbill_txt.setOpaque(false);
        sd_tbill_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        sd_tab.add(sd_tbill_txt);
        sd_tbill_txt.setBounds(280, 350, 130, 23);

        sd_txtLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        sd_tab.add(sd_txtLabel3);
        sd_txtLabel3.setBounds(270, 340, 150, 40);

        sd_saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save1.png"))); // NOI18N
        sd_saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sd_saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sd_saveBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sd_saveBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sd_saveBtnMousePressed(evt);
            }
        });
        sd_tab.add(sd_saveBtn);
        sd_saveBtn.setBounds(570, 340, 150, 65);

        sd_label10.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        sd_label10.setText("Condition");
        sd_tab.add(sd_label10);
        sd_label10.setBounds(450, 160, 90, 40);

        sd_cond_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        sd_cond_cbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Excellent", "Good", "Average" }));
        sd_tab.add(sd_cond_cbox);
        sd_cond_cbox.setBounds(580, 170, 130, 30);

        sd_checkBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/find.png"))); // NOI18N
        sd_checkBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sd_checkBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sd_checkBtnMousePressed(evt);
            }
        });
        sd_tab.add(sd_checkBtn);
        sd_checkBtn.setBounds(720, 220, 32, 32);

        sd_label11.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        sd_label11.setText("Guest ID");
        sd_tab.add(sd_label11);
        sd_label11.setBounds(150, 160, 90, 40);

        sd_guest_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        sd_tab.add(sd_guest_cbox);
        sd_guest_cbox.setBounds(280, 170, 130, 30);

        sd_bgImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        sd_tab.add(sd_bgImg);
        sd_bgImg.setBounds(0, 0, 940, 690);

        transport_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/sd_tab.jpg")), sd_tab); // NOI18N
        sd_tab.getAccessibleContext().setAccessibleParent(transport_tab);

        at_tab.setMaximumSize(new java.awt.Dimension(900, 600));
        at_tab.setOpaque(false);
        at_tab.setPreferredSize(new java.awt.Dimension(900, 600));
        at_tab.setLayout(null);

        at_form.setOpaque(false);
        at_form.setLayout(null);

        at_label2.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        at_label2.setText("Model No");
        at_form.add(at_label2);
        at_label2.setBounds(200, 40, 120, 40);

        at_label3.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        at_label3.setText("Maker");
        at_form.add(at_label3);
        at_label3.setBounds(200, 100, 110, 40);

        at_label4.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        at_label4.setText("Rate Per Km");
        at_form.add(at_label4);
        at_label4.setBounds(200, 170, 110, 30);

        at_label5.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        at_label5.setText("Condition");
        at_form.add(at_label5);
        at_label5.setBounds(200, 220, 80, 40);

        at_modelNo_txt.setBackground(new java.awt.Color(123, 211, 172));
        at_modelNo_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        at_modelNo_txt.setBorder(null);
        at_modelNo_txt.setOpaque(false);
        at_modelNo_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        at_form.add(at_modelNo_txt);
        at_modelNo_txt.setBounds(320, 50, 130, 23);

        at_maker_txt.setBackground(new java.awt.Color(123, 211, 172));
        at_maker_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        at_maker_txt.setBorder(null);
        at_maker_txt.setOpaque(false);
        at_maker_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        at_form.add(at_maker_txt);
        at_maker_txt.setBounds(320, 110, 130, 23);

        at_condition_jcb.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        at_condition_jcb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Excellent", "Good", "Average" }));
        at_form.add(at_condition_jcb);
        at_condition_jcb.setBounds(320, 230, 130, 25);

        at_saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save1.png"))); // NOI18N
        at_saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        at_saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                at_saveBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                at_saveBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                at_saveBtnMousePressed(evt);
            }
        });
        at_form.add(at_saveBtn);
        at_saveBtn.setBounds(310, 380, 150, 70);

        at_resetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/reset_1.png"))); // NOI18N
        at_resetBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        at_resetBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                at_resetBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                at_resetBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                at_resetBtnMouseExited(evt);
            }
        });
        at_form.add(at_resetBtn);
        at_resetBtn.setBounds(490, 380, 160, 70);

        at_txtlabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        at_form.add(at_txtlabel2);
        at_txtlabel2.setBounds(310, 100, 150, 40);

        at_txtlabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        at_form.add(at_txtlabel1);
        at_txtlabel1.setBounds(310, 40, 150, 40);

        at_rate_txt.setBackground(new java.awt.Color(123, 211, 172));
        at_rate_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        at_rate_txt.setBorder(null);
        at_rate_txt.setOpaque(false);
        at_rate_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        at_form.add(at_rate_txt);
        at_rate_txt.setBounds(320, 170, 130, 23);

        at_txtLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        at_form.add(at_txtLabel3);
        at_txtLabel3.setBounds(310, 160, 150, 40);

        at_selectImg_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_1.png"))); // NOI18N
        at_selectImg_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        at_selectImg_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                at_selectImg_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                at_selectImg_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                at_selectImg_btnMouseExited(evt);
            }
        });
        at_form.add(at_selectImg_btn);
        at_selectImg_btn.setBounds(590, 270, 100, 50);

        at_imageFrame.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        at_imageFrame.setPreferredSize(new java.awt.Dimension(215, 215));

        at_select_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_car.png"))); // NOI18N
        at_select_image.setMaximumSize(new java.awt.Dimension(215, 215));

        javax.swing.GroupLayout at_imageFrameLayout = new javax.swing.GroupLayout(at_imageFrame);
        at_imageFrame.setLayout(at_imageFrameLayout);
        at_imageFrameLayout.setHorizontalGroup(
            at_imageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(at_select_image, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );
        at_imageFrameLayout.setVerticalGroup(
            at_imageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(at_select_image, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
        );

        at_form.add(at_imageFrame);
        at_imageFrame.setBounds(540, 30, 210, 220);
        at_form.add(at_error2);
        at_error2.setBounds(470, 100, 40, 40);
        at_form.add(at_msg);
        at_msg.setBounds(200, 280, 250, 70);
        at_form.add(at_error1);
        at_error1.setBounds(470, 40, 40, 40);
        at_form.add(at_error3);
        at_error3.setBounds(470, 160, 40, 40);

        at_tab.add(at_form);
        at_form.setBounds(0, 60, 940, 620);

        at_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        at_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        at_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/at_h.png"))); // NOI18N
        at_tab.add(at_label1);
        at_label1.setBounds(0, 20, 210, 50);

        at_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        at_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        at_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                at_closeBtnMouseClicked(evt);
            }
        });
        at_tab.add(at_closeBtn);
        at_closeBtn.setBounds(903, 0, 34, 31);

        at_bgImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        at_bgImg.setText("jLabel19");
        at_tab.add(at_bgImg);
        at_bgImg.setBounds(-10, 0, 950, 680);

        transport_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/at_tab.jpg")), at_tab); // NOI18N
        at_tab.getAccessibleContext().setAccessibleParent(transport_tab);

        vb_tab.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        vb_tab.setLayout(null);

        vb_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        vb_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/vb_h.png"))); // NOI18N
        vb_label1.setToolTipText("");
        vb_tab.add(vb_label1);
        vb_label1.setBounds(0, 10, 180, 60);

        vb_service_cb.setFont(new java.awt.Font("GardensC", 0, 14)); // NOI18N
        vb_service_cb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pick Up", "Drop Off" }));
        vb_tab.add(vb_service_cb);
        vb_service_cb.setBounds(170, 110, 100, 25);

        vb_label2.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        vb_label2.setText("Service");
        vb_tab.add(vb_label2);
        vb_label2.setBounds(80, 110, 80, 30);

        vb_From_date.setDateFormatString("yyyy-MM-dd");
        vb_tab.add(vb_From_date);
        vb_From_date.setBounds(150, 230, 130, 30);

        vb_label3.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        vb_label3.setText("Date From");
        vb_tab.add(vb_label3);
        vb_label3.setBounds(30, 230, 100, 30);

        vb_label4.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        vb_label4.setText("Date To");
        vb_tab.add(vb_label4);
        vb_label4.setBounds(30, 280, 65, 30);

        vb_To_date.setDateFormatString("yyyy-MM-dd");
        vb_tab.add(vb_To_date);
        vb_To_date.setBounds(150, 280, 130, 30);

        vb_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search.png"))); // NOI18N
        vb_searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vb_searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vb_searchBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vb_searchBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                vb_searchBtnMousePressed(evt);
            }
        });
        vb_tab.add(vb_searchBtn);
        vb_searchBtn.setBounds(100, 350, 150, 65);

        vb_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        vb_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vb_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vb_closeBtnMouseClicked(evt);
            }
        });
        vb_tab.add(vb_closeBtn);
        vb_closeBtn.setBounds(903, 0, 34, 31);

        vb_todayBtn.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        vb_todayBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/radio_btn1.png"))); // NOI18N
        vb_todayBtn.setText("Today");
        vb_todayBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vb_todayBtn.setIconTextGap(10);
        vb_todayBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vb_todayBtnMouseClicked(evt);
            }
        });
        vb_tab.add(vb_todayBtn);
        vb_todayBtn.setBounds(30, 170, 90, 40);

        vb_tablePane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        vb_tabel.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        vb_tabel.setRowHeight(35);
        vb_tabel.setSelectionBackground(new java.awt.Color(3, 201, 169));
        vb_tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vb_tabelMouseClicked(evt);
            }
        });
        vb_tablePane.setViewportView(vb_tabel);

        vb_tab.add(vb_tablePane);
        vb_tablePane.setBounds(360, 110, 580, 580);

        vb_label5.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        vb_label5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/rc_header.png"))); // NOI18N
        vb_tab.add(vb_label5);
        vb_label5.setBounds(360, 70, 130, 40);

        vb_confirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/confirm1.png"))); // NOI18N
        vb_confirmBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vb_confirmBtn.setEnabled(false);
        vb_confirmBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vb_confirmBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vb_confirmBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                vb_confirmBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                vb_confirmBtnMouseReleased(evt);
            }
        });
        vb_tab.add(vb_confirmBtn);
        vb_confirmBtn.setBounds(520, 60, 100, 50);

        vb_updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/update1.png"))); // NOI18N
        vb_updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vb_updateBtn.setEnabled(false);
        vb_updateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vb_updateBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vb_updateBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                vb_updateBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                vb_updateBtnMouseReleased(evt);
            }
        });
        vb_tab.add(vb_updateBtn);
        vb_updateBtn.setBounds(630, 60, 100, 50);

        vb_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_1.png"))); // NOI18N
        vb_deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vb_deleteBtn.setEnabled(false);
        vb_deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vb_deleteBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vb_deleteBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                vb_deleteBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                vb_deleteBtnMouseReleased(evt);
            }
        });
        vb_tab.add(vb_deleteBtn);
        vb_deleteBtn.setBounds(740, 60, 100, 50);
        vb_tab.add(jSeparator1);
        jSeparator1.setBounds(30, 150, 300, 2);

        vb_bgImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        vb_tab.add(vb_bgImg);
        vb_bgImg.setBounds(0, 0, 940, 680);

        transport_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/vb_tab.jpg")), vb_tab, ""); // NOI18N
        vb_tab.getAccessibleContext().setAccessibleParent(transport_tab);

        javax.swing.GroupLayout center_innerLayout = new javax.swing.GroupLayout(center_inner);
        center_inner.setLayout(center_innerLayout);
        center_innerLayout.setHorizontalGroup(
            center_innerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, center_innerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(transport_tab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        center_innerLayout.setVerticalGroup(
            center_innerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(transport_tab, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout center_outerLayout = new javax.swing.GroupLayout(center_outer);
        center_outer.setLayout(center_outerLayout);
        center_outerLayout.setHorizontalGroup(
            center_outerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 987, Short.MAX_VALUE)
            .addGroup(center_outerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(center_outerLayout.createSequentialGroup()
                    .addComponent(center_inner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 34, Short.MAX_VALUE)))
        );
        center_outerLayout.setVerticalGroup(
            center_outerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 734, Short.MAX_VALUE)
            .addGroup(center_outerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(center_outerLayout.createSequentialGroup()
                    .addComponent(center_inner, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 19, Short.MAX_VALUE)))
        );

        body_panel.add(center_outer, java.awt.BorderLayout.CENTER);

        getContentPane().add(body_panel);
        body_panel.setBounds(0, 0, 1280, 1030);

        bg_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/hm_bg.jpg"))); // NOI18N
        getContentPane().add(bg_image);
        bg_image.setBounds(0, 0, 400, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add_transportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_transportMouseClicked
        transport_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/at_tab.jpg")), at_tab);
        transport_tab.setSelectedComponent(at_tab);
    }//GEN-LAST:event_add_transportMouseClicked

    private void add_transportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_transportMouseEntered
        add_transport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/add_transport2.jpg")));
        add_transport.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_add_transportMouseEntered

    private void add_transportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_transportMouseExited
        add_transport.setBorder(null);
        add_transport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/add_transport1.jpg")));
    }//GEN-LAST:event_add_transportMouseExited

    private void modify_transportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modify_transportMouseClicked
        transport_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/mt_tab.jpg")), mt_tab);
        transport_tab.setSelectedComponent(mt_tab);
    }//GEN-LAST:event_modify_transportMouseClicked

    private void modify_transportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modify_transportMouseEntered
        modify_transport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/modify_transport2.jpg")));
        modify_transport.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_modify_transportMouseEntered

    private void modify_transportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modify_transportMouseExited
        modify_transport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/modify_transport1.jpg")));
        modify_transport.setBorder(null);
    }//GEN-LAST:event_modify_transportMouseExited

    private void set_destinationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_set_destinationMouseClicked
        transport_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/sd_tab.jpg")),sd_tab);
        transport_tab.setSelectedComponent(sd_tab);
    }//GEN-LAST:event_set_destinationMouseClicked

    private void set_destinationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_set_destinationMouseEntered
        set_destination.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/set_destination2.jpg")));
        set_destination.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_set_destinationMouseEntered

    private void set_destinationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_set_destinationMouseExited
        set_destination.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/set_destination1.jpg")));
        set_destination.setBorder(null);
    }//GEN-LAST:event_set_destinationMouseExited

    private void view_bookingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_bookingMouseClicked
        transport_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/vb_tab.jpg")),vb_tab);
        transport_tab.setSelectedComponent(vb_tab);
    }//GEN-LAST:event_view_bookingMouseClicked

    private void view_bookingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_bookingMouseEntered
        view_booking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/view_booking2.jpg")));
        view_booking.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_view_bookingMouseEntered

    private void view_bookingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_bookingMouseExited
        view_booking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/view_booking1.jpg")));
        view_booking.setBorder(null);
    }//GEN-LAST:event_view_bookingMouseExited

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
        timerun=1;
        this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void vb_todayBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vb_todayBtnMouseClicked

        if(on_off==true){
        
        vb_todayBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/radio_btn2.png")));
     
        vb_From_date.setEnabled(false);
        vb_To_date.setEnabled(false);
        
       
        
        on_off=false;
        }
        else 
        {
        vb_todayBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/radio_btn1.png")));
        vb_From_date.setEnabled(true);
        vb_To_date.setEnabled(true);
        
        
        on_off=true;
        }  
    }//GEN-LAST:event_vb_todayBtnMouseClicked

    private void vb_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vb_closeBtnMouseClicked
        transport_tab.remove(vb_tab);
    }//GEN-LAST:event_vb_closeBtnMouseClicked

    private void vb_searchBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vb_searchBtnMouseExited
        vb_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search.png")));
    }//GEN-LAST:event_vb_searchBtnMouseExited

    private void vb_searchBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vb_searchBtnMouseEntered
        vb_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search1.png")));
    }//GEN-LAST:event_vb_searchBtnMouseEntered

    private void at_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_at_closeBtnMouseClicked
        transport_tab.remove(at_tab);
    }//GEN-LAST:event_at_closeBtnMouseClicked

    private void at_selectImg_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_at_selectImg_btnMouseExited
        at_selectImg_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_1.png")));
    }//GEN-LAST:event_at_selectImg_btnMouseExited

    private void at_selectImg_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_at_selectImg_btnMouseEntered

        at_selectImg_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_2.png")));
    }//GEN-LAST:event_at_selectImg_btnMouseEntered

    private void at_selectImg_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_at_selectImg_btnMouseClicked

        at_selectImg_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_3.png")));
        int a=jFileChooser1.showOpenDialog(this);
        if(a==JFileChooser.APPROVE_OPTION){
              File f= jFileChooser1.getSelectedFile();
            at_path=f.getPath();
            at_select_image.setIcon(new ImageIcon(""+f));}
    }//GEN-LAST:event_at_selectImg_btnMouseClicked

    private void at_resetBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_at_resetBtnMouseExited
        at_resetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/reset_1.png")));
    }//GEN-LAST:event_at_resetBtnMouseExited

    private void at_resetBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_at_resetBtnMouseEntered
        at_resetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/reset_2.png")));
    }//GEN-LAST:event_at_resetBtnMouseEntered

    private void at_resetBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_at_resetBtnMouseClicked
        at_modelNo_txt.setText("");
        at_maker_txt.setText("");
        at_rate_txt.setText("");
        at_condition_jcb.setSelectedIndex(0);
        at_select_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_car.png")));
        at_error1.setIcon(null);
        at_error2.setIcon(null);
        at_error3.setIcon(null);
        at_msg.setIcon(null);
        
        
    }//GEN-LAST:event_at_resetBtnMouseClicked

    private void at_saveBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_at_saveBtnMouseExited
        at_saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save1.png")));
    }//GEN-LAST:event_at_saveBtnMouseExited

    private void at_saveBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_at_saveBtnMouseEntered
        at_saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save2.png")));
    }//GEN-LAST:event_at_saveBtnMouseEntered

    private void sd_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sd_closeBtnMouseClicked
        transport_tab.remove(sd_tab);
    }//GEN-LAST:event_sd_closeBtnMouseClicked

    private void mt_searchBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mt_searchBtnMouseExited
        mt_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/s_1.png")));
    }//GEN-LAST:event_mt_searchBtnMouseExited

    private void mt_searchBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mt_searchBtnMouseEntered
        mt_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/s_2.png")));
    }//GEN-LAST:event_mt_searchBtnMouseEntered

    private void mt_searchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mt_searchBtnMouseClicked
        mt_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/s_3.png")));
    }//GEN-LAST:event_mt_searchBtnMouseClicked

    private void mt_updateBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mt_updateBtnMouseExited
        mt_updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/update1.png")));
    }//GEN-LAST:event_mt_updateBtnMouseExited

    private void mt_updateBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mt_updateBtnMouseEntered
        mt_updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/update2.png")));
    }//GEN-LAST:event_mt_updateBtnMouseEntered

    private void mt_updateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mt_updateBtnMouseClicked
        mt_updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/update3.png")));
    }//GEN-LAST:event_mt_updateBtnMouseClicked

    private void mt_deleteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mt_deleteBtnMouseExited
        mt_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_1.png")));
    }//GEN-LAST:event_mt_deleteBtnMouseExited

    private void mt_deleteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mt_deleteBtnMouseEntered
        mt_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_2.png")));
    }//GEN-LAST:event_mt_deleteBtnMouseEntered

    private void mt_deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mt_deleteBtnMouseClicked
        mt_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_3.png")));
    }//GEN-LAST:event_mt_deleteBtnMouseClicked

    private void mt_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mt_closeBtnMouseClicked
        transport_tab.remove(mt_tab);
    }//GEN-LAST:event_mt_closeBtnMouseClicked

    private void mt_selectImg_BtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mt_selectImg_BtnMouseExited
        mt_selectImg_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_1.png")));
    }//GEN-LAST:event_mt_selectImg_BtnMouseExited

    private void mt_selectImg_BtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mt_selectImg_BtnMouseEntered
        mt_selectImg_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_2.png")));
    }//GEN-LAST:event_mt_selectImg_BtnMouseEntered

    private void mt_selectImg_BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mt_selectImg_BtnMouseClicked
        mt_selectImg_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_3.png")));
        int a=jFileChooser1.showOpenDialog(this);
        if(a==JFileChooser.APPROVE_OPTION){
        File f= jFileChooser1.getSelectedFile();

        mt_selectImg.setIcon(new ImageIcon(""+f));}
    }//GEN-LAST:event_mt_selectImg_BtnMouseClicked

    private void at_saveBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_at_saveBtnMousePressed
         at_error1.setIcon(null);
         at_error2.setIcon(null);
         at_error3.setIcon(null);
      
        

        if("".equals(at_modelNo_txt.getText()))
        {
        at_error1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/errorIcon.png")));
        at_msg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/error_msg.png"))); 
        Toolkit.getDefaultToolkit().beep();
        
        }
        
        
        else  if("".equals(at_maker_txt.getText()))
        {
        at_error2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/errorIcon.png")));
        at_msg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/error_msg.png")));   
        Toolkit.getDefaultToolkit().beep();

        }
         else  if("".equals(at_rate_txt.getText()))
        {
        at_error3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/errorIcon.png")));
        at_msg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/error_msg.png")));   
        Toolkit.getDefaultToolkit().beep();

        }
     
        
        
        else {
         at_error1.setIcon(null);
         at_error2.setIcon(null);
         at_error3.setIcon(null);
        
        
        
        
      try{
      String sql="Insert into transport (model_no,maker,rate,condition,trans_image) values (?,?,?,?,?)";
      
      pst=con.prepareStatement(sql);
      pst.setString(1,at_modelNo_txt.getText() );
      pst.setString(2, at_maker_txt.getText());
      pst.setInt(3, Integer.parseInt(at_rate_txt.getText()));
      pst.setString(4, at_condition_jcb.getSelectedItem().toString());
      pst.setString(5, at_path);
      
      pst.execute();
      
     at_msg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save_msg.png")));
         
         
     
         
     }
    catch(Exception e){JOptionPane.showMessageDialog(this,e);}
     
    }
        
        
        
    }//GEN-LAST:event_at_saveBtnMousePressed

    private void mt_searchBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mt_searchBtnMousePressed
       
        try{
        
        String sql="Select * from transport";
        pst=con.prepareStatement(sql);
        rs=pst.executeQuery();
        
        mt_table.setModel(DbUtils.resultSetToTableModel(rs));
        setColumn(mt_table);
        if(mt_table.getRowCount()==0){JOptionPane.showMessageDialog(this,"Sorry No Record Found !");}
        
        }
        catch(Exception e){
        
            JOptionPane.showMessageDialog(this,e);
        }
        
    }//GEN-LAST:event_mt_searchBtnMousePressed

    private void mt_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mt_tableMouseClicked
     
       int row = mt_table.getSelectedRow();
       t_id=  (int) mt_table.getModel().getValueAt(row, 0);
       
       try
       {
       
       String query="Select * from transport where transport_id='"+t_id+"'";
       pst=con.prepareStatement(query);
       rs=pst.executeQuery();
       
       while(rs.next())
       {
       String image_url= rs.getString("trans_image");
       ImageIcon image = new ImageIcon(image_url);
       mt_selectImg.setIcon(image);
       mt_modelNo_txt.setText(rs.getString("model_no"));
       mt_maker_txt.setText(rs.getString("maker"));
       mt_rate_txt.setText(rs.getString("rate"));
       mt_cnd_comboBox.setSelectedItem(rs.getString("condition"));
       
       }
       
       }
       catch(Exception e){
       e.printStackTrace();
       }
        
        
        
        
    }//GEN-LAST:event_mt_tableMouseClicked

    private void mt_updateBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mt_updateBtnMousePressed
    int row = mt_table.getSelectedRow();
        if(row ==-1){
        JOptionPane.showMessageDialog(this,"Please Select the Record you want to Update !");
        }
        else{
        try{
     if(mt_path==null){
         
     String sql="Update transport set model_no= ? ,maker= ? , rate= ? ,condition=? where transport_id = '"+t_id+"' ";
     pst=con.prepareStatement(sql);
     pst.setString(1, mt_modelNo_txt.getText());
     pst.setString(2, mt_maker_txt.getText());
     pst.setInt(3, Integer.parseInt(mt_rate_txt.getText()));
     pst.setString(4, mt_cnd_comboBox.getSelectedItem().toString());
     
     pst.execute();
     JOptionPane.showMessageDialog(this, "Succesfully Updated", "Message",JOptionPane.INFORMATION_MESSAGE );
      updateTable(t_id, mt_table);
     }
     else{
     String sql1="Update transport set model_no= ? ,maker= ? , rate= ? ,condition=?,trans_image=? where transport_id = '"+t_id+"' ";
     pst=con.prepareStatement(sql1);
     pst.setString(1, mt_modelNo_txt.getText());
     pst.setString(2, mt_maker_txt.getText());
     pst.setInt(3, Integer.parseInt(mt_rate_txt.getText()));
     pst.setString(4, mt_cnd_comboBox.getSelectedItem().toString());
     pst.setString(5, mt_path);
     
     pst.execute();
     JOptionPane.showMessageDialog(this, "Succesfully Updated", "Message",JOptionPane.INFORMATION_MESSAGE );
     updateTable(t_id, mt_table);
     }
     }
     catch(Exception e){
     JOptionPane.showMessageDialog(this,e );
     
     }
        
        }
        
    }//GEN-LAST:event_mt_updateBtnMousePressed

    private void mt_deleteBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mt_deleteBtnMousePressed
        
        int row = mt_table.getSelectedRow();
        if(row ==-1){
        JOptionPane.showMessageDialog(this,"Please Select the Record you want to delete !");
        }
        else{
       int t_id=  (int) mt_table.getModel().getValueAt(row, 0);
       String sql= "Delete from transport where transport_id='"+t_id+"'";
       int option=JOptionPane.showConfirmDialog(null,"Are You Sure You want to delete data");
       if(option==JOptionPane.YES_OPTION)
       {
       
       try{
       pst=con.prepareStatement(sql);
       
       pst.execute();
       
       JOptionPane.showMessageDialog(null,"Deleted Succesfully","Message",JOptionPane.INFORMATION_MESSAGE);
       updateTable(t_id,mt_table);
       
           
       }
       catch(Exception e){
       e.printStackTrace();
       }
       }
       }



    }//GEN-LAST:event_mt_deleteBtnMousePressed

    private void vb_searchBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vb_searchBtnMousePressed
       
        if(on_off==false)
        {
        try{    
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String d=format.format(date); 
        
        int select = vb_service_cb.getSelectedIndex();
        String table;
        table=checkService(select);
        String col=checkDateCol(table);
      
        
        String sql="Select * from "+table+"  where "+col+" = '"+d+"' ";
        pst=con.prepareStatement(sql);
 
        rs=pst.executeQuery();
        vb_tabel.setModel(DbUtils.resultSetToTableModel(rs));
        setColumn(vb_tabel);
        if(vb_tabel.getRowCount()==0){
        
        JOptionPane.showMessageDialog(this,"Sorry No Record Found..!","Info",JOptionPane.INFORMATION_MESSAGE);
        }
        }
        catch(Exception e){JOptionPane.showMessageDialog(this, e);
        e.printStackTrace();}

        }
        else if(on_off==true)
        {
            if(checkDatefield(vb_From_date, "From Date") && checkDatefield(vb_To_date, "To Date")) 
            {
                try
                {
                    int select = vb_service_cb.getSelectedIndex();
                    String table2=checkService(select);
                    String col=checkDateCol(table2);
                    String from =((JTextField)vb_From_date.getDateEditor().getUiComponent()).getText();
                    String  to=((JTextField)vb_To_date.getDateEditor().getUiComponent()).getText();  
      
                     String sql2="Select * from "+table2+"  where "+col+" between ? and ? ";
                    pst=con.prepareStatement(sql2);
                   
                    
                    pst.setString(1, from);
                    pst.setString(2, to);
                    rs=pst.executeQuery();
                    vb_tabel.setModel(DbUtils.resultSetToTableModel(rs));
                    setColumn(vb_tabel);
                    
                    if(vb_tabel.getRowCount()==0)
                    {
        
                    JOptionPane.showMessageDialog(this,"Sorry No Record Found..!","Info",JOptionPane.INFORMATION_MESSAGE);
                    }
         
         
         
         
                }
                catch(Exception e){JOptionPane.showMessageDialog(this, e);}
           
          
            }
        
        
        
        }
        
    }//GEN-LAST:event_vb_searchBtnMousePressed

    private void vb_updateBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vb_updateBtnMousePressed
vb_updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/update3.png"))); // NOI18N

        try
      {
        int select = vb_service_cb.getSelectedIndex();
        
        table=checkService(select);
        
        
      int row=vb_tabel.getSelectedRow();
      int id=(int) vb_tabel.getModel().getValueAt(row, 1);
      
      
      
      String sql="Select * from "+table+" where guest_id='"+id+"'";
      pst=con.prepareStatement(sql);
      rs=pst.executeQuery();
      //remove items before adding to it
      sd_trspt_jcb.removeAllItems();
      sd_guest_cbox.removeAllItems();
      while(rs.next()){
       
      sd_guest_cbox.addItem(id);
      sd_trspt_jcb.addItem(rs.getInt("transport_id"));
      sd_km_spin.setValue(rs.getInt("km"));
      sd_tbill_txt.setText(Integer.toString(rs.getInt("bill")));
      
      if(table.equals("t_pickup")){
      sd_driveTo_txt.setText("Hotel");
      sd_driveTo_txt.setEditable(false);
      
      }
      else{
      sd_driveTo_txt.setText(rs.getString("drive_to"));}
      if(table.equals("t_dropoff")){
          sd_driveFrom_txt.setText("Hotel");
          sd_driveFrom_txt.setEditable(false);
      }
      else{
      sd_driveFrom_txt.setText(rs.getString("drive_from"));}
      
      
      
      }
      
      
      transport_tab.setSelectedComponent(sd_tab);
      
      }
      catch(Exception e){
      e.printStackTrace();
      
      }
        
    }//GEN-LAST:event_vb_updateBtnMousePressed

    private void sd_checkBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sd_checkBtnMousePressed
        
        String select=sd_cond_cbox.getSelectedItem().toString();
        if(sd_checkBtn.isEnabled()){
        if(select.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please Select Any one Condition First ! ","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else{
            try{
                sd_trspt_jcb.removeAllItems();
                String sql="Select transport_id from transport where condition='"+select+"'";
                pst=con.prepareStatement(sql);
                rs=pst.executeQuery();
                while(rs.next()){
                    int id=rs.getInt("transport_id");
                    sd_trspt_jcb.addItem(id);

                }
                if(sd_trspt_jcb.getItemCount()==0){

                    JOptionPane.showMessageDialog(null, "Sorry No transports are availabel !","Info", JOptionPane.INFORMATION_MESSAGE);

                }

            }
            catch(Exception e)
            {JOptionPane.showMessageDialog(this, e);
                e.printStackTrace();
            }

        }
        }
    }//GEN-LAST:event_sd_checkBtnMousePressed

    private void sd_trspt_jcbMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sd_trspt_jcbMousePressed
       int Select = (int) sd_trspt_jcb.getSelectedItem();
      try{
      String sql="Select * from transport where transport_id='"+Select+"'";
      pst=con.prepareStatement(sql);
      rs=pst.executeQuery();
      rs.next();
      
         rate = rs.getInt("rate");
    
        sd_tbill_txt.setText(Integer.toString(rate));
      
      }
      catch(Exception e){JOptionPane.showMessageDialog(this,e);}
    }//GEN-LAST:event_sd_trspt_jcbMousePressed

    private void sd_km_spinStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sd_km_spinStateChanged
       int value =(int) sd_km_spin.getValue();
      
        bill= rate * value;
        sd_tbill_txt.setText(Integer.toString(bill));
    }//GEN-LAST:event_sd_km_spinStateChanged

    private void sd_saveBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sd_saveBtnMousePressed
       try{
           
           String sql="Update "+table+" set transport_id=? , drive_to=? , drive_from=?,km=?,bill=? where guest_id=? ";
           pst=con.prepareStatement(sql);
           pst.setInt(1, (int) sd_trspt_jcb.getSelectedItem());
           pst.setString(2,sd_driveTo_txt.getText() );
           pst.setString(3, sd_driveFrom_txt.getText());
           pst.setInt(4, (int) sd_km_spin.getValue());
           pst.setInt(5, Integer.parseInt(sd_tbill_txt.getText()));
           pst.setInt(6, (int) sd_guest_cbox.getSelectedItem());
           
           
           pst.execute();
           JOptionPane.showMessageDialog(this, "Succesfully Updated", "Message",JOptionPane.INFORMATION_MESSAGE );
       }
       catch(Exception e){JOptionPane.showMessageDialog(this,e);}
        
        
        
    }//GEN-LAST:event_sd_saveBtnMousePressed

    private void vb_confirmBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vb_confirmBtnMousePressed
       vb_confirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/confirm3.png"))); // NOI18N

        int select = vb_service_cb.getSelectedIndex();
        table=checkService(select);
        int row=vb_tabel.getSelectedRow();
        int id=(int) vb_tabel.getModel().getValueAt(row, 1);
       
        int Option=JOptionPane.showConfirmDialog(this,"Are YOu sure you want to confirm booking for Guest ID: "+id+"");
        if(Option==JOptionPane.YES_OPTION)
        {
        try
        {
        String sql="update "+table+" set status=1 where guest_id="+id+" ";
        pst=con.prepareStatement(sql);
        pst.execute();
        JOptionPane.showMessageDialog(this,"Guest ID :"+id+" booking is now Authorised !");
        check_trans_not();
        
        }
        catch(Exception e){JOptionPane.showMessageDialog(this, e);}
        }
        
        
        
    }//GEN-LAST:event_vb_confirmBtnMousePressed

    private void vb_deleteBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vb_deleteBtnMousePressed
        vb_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_3.png"))); // NOI18N

        int select = vb_service_cb.getSelectedIndex();
        table=checkService(select);
        int row=vb_tabel.getSelectedRow();
        int id=(int) vb_tabel.getModel().getValueAt(row, 1);
       
        int Option=JOptionPane.showConfirmDialog(this,"Are YOu sure you want Delete record of  Guest ID: "+id+"");
        if(Option==JOptionPane.YES_OPTION)
        {
        try
        {
        String sql="Delete from  "+table+"  where guest_id="+id+" ";
        pst=con.prepareStatement(sql);
        pst.execute();
        JOptionPane.showMessageDialog(null,"Deleted Succesfully","Message",JOptionPane.INFORMATION_MESSAGE);
        
        }
        catch(Exception e){JOptionPane.showMessageDialog(this, e);}
        }
        
        
    }//GEN-LAST:event_vb_deleteBtnMousePressed

    private void ar_refersh2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ar_refersh2MousePressed
        check_trans_not();
    }//GEN-LAST:event_ar_refersh2MousePressed

    private void sd_saveBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sd_saveBtnMouseEntered
sd_saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save2.png")));

    }//GEN-LAST:event_sd_saveBtnMouseEntered

    private void sd_saveBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sd_saveBtnMouseExited
   sd_saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save1.png"))); 

    }//GEN-LAST:event_sd_saveBtnMouseExited

    private void vb_tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vb_tabelMouseClicked
        int row =vb_tabel.getSelectedRow();
        
       
       
        if(vb_tabel.isRowSelected(row)==true)
       {
       vb_confirmBtn.setEnabled(true);
       vb_updateBtn.setEnabled(true);
       vb_deleteBtn.setEnabled(true);
       }
        else
        {
       vb_deleteBtn.setEnabled(false);
       vb_updateBtn.setEnabled(false);
       vb_confirmBtn.setEnabled(false);
        }
    }//GEN-LAST:event_vb_tabelMouseClicked

    private void vb_confirmBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vb_confirmBtnMouseEntered
    vb_confirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/confirm2.png"))); 

    }//GEN-LAST:event_vb_confirmBtnMouseEntered

    private void vb_confirmBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vb_confirmBtnMouseExited
      vb_confirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/confirm1.png"))); // NOI18N

    }//GEN-LAST:event_vb_confirmBtnMouseExited

    private void vb_confirmBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vb_confirmBtnMouseReleased
  vb_confirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/confirm2.png"))); // NOI18N

    }//GEN-LAST:event_vb_confirmBtnMouseReleased

    private void vb_updateBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vb_updateBtnMouseEntered
vb_updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/update2.png"))); // NOI18N
   
    }//GEN-LAST:event_vb_updateBtnMouseEntered

    private void vb_updateBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vb_updateBtnMouseExited
vb_updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/update1.png"))); // NOI18N

    }//GEN-LAST:event_vb_updateBtnMouseExited

    private void vb_updateBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vb_updateBtnMouseReleased
    vb_updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/update2.png"))); // NOI18N

    }//GEN-LAST:event_vb_updateBtnMouseReleased

    private void vb_deleteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vb_deleteBtnMouseEntered
   vb_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_2.png"))); // NOI18N

    }//GEN-LAST:event_vb_deleteBtnMouseEntered

    private void vb_deleteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vb_deleteBtnMouseExited
   vb_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_1.png"))); // NOI18N

    }//GEN-LAST:event_vb_deleteBtnMouseExited

    private void vb_deleteBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vb_deleteBtnMouseReleased
     vb_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_2.png"))); // NOI18N

    }//GEN-LAST:event_vb_deleteBtnMouseReleased

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel add_transport;
    private javax.swing.JLabel adm_label;
    private javax.swing.JLabel admin_label;
    private javax.swing.JLabel ar_refersh2;
    private javax.swing.JLabel at_bgImg;
    private javax.swing.JLabel at_closeBtn;
    private javax.swing.JComboBox at_condition_jcb;
    private javax.swing.JLabel at_error1;
    private javax.swing.JLabel at_error2;
    private javax.swing.JLabel at_error3;
    private javax.swing.JPanel at_form;
    private javax.swing.JPanel at_imageFrame;
    private javax.swing.JLabel at_label1;
    private javax.swing.JLabel at_label2;
    private javax.swing.JLabel at_label3;
    private javax.swing.JLabel at_label4;
    private javax.swing.JLabel at_label5;
    private javax.swing.JTextField at_maker_txt;
    private javax.swing.JTextField at_modelNo_txt;
    private javax.swing.JLabel at_msg;
    private javax.swing.JTextField at_rate_txt;
    private javax.swing.JLabel at_resetBtn;
    private javax.swing.JLabel at_saveBtn;
    private javax.swing.JLabel at_selectImg_btn;
    private javax.swing.JLabel at_select_image;
    private javax.swing.JPanel at_tab;
    private javax.swing.JLabel at_txtLabel3;
    private javax.swing.JLabel at_txtlabel1;
    private javax.swing.JLabel at_txtlabel2;
    private javax.swing.JLabel back_label;
    private javax.swing.JLabel bg_image;
    private javax.swing.JPanel body_panel;
    private javax.swing.JPanel btn_panel;
    private javax.swing.JPanel center_inner;
    private javax.swing.JPanel center_outer;
    private javax.swing.JLabel clock;
    private javax.swing.JLabel clock2;
    private javax.swing.JLabel close_label;
    private javax.swing.JLabel day;
    private javax.swing.JPanel footer_panel;
    private javax.swing.JPanel header_panel;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel mini_label;
    private javax.swing.JLabel modify_transport;
    private javax.swing.JLabel month;
    private javax.swing.JLabel mt_bgImg;
    private javax.swing.JLabel mt_closeBtn;
    private javax.swing.JComboBox mt_cnd_comboBox;
    private javax.swing.JLabel mt_deleteBtn;
    private javax.swing.JPanel mt_form;
    private javax.swing.JPanel mt_imageFrame;
    private javax.swing.JLabel mt_label1;
    private javax.swing.JLabel mt_label2;
    private javax.swing.JLabel mt_label3;
    private javax.swing.JLabel mt_label4;
    private javax.swing.JLabel mt_label5;
    private javax.swing.JLabel mt_label6;
    private javax.swing.JTextField mt_maker_txt;
    private javax.swing.JTextField mt_modelNo_txt;
    private javax.swing.JScrollPane mt_pane;
    private javax.swing.JTextField mt_rate_txt;
    private javax.swing.JLabel mt_searchBtn;
    private javax.swing.JLabel mt_selectImg;
    private javax.swing.JLabel mt_selectImg_Btn;
    private javax.swing.JPanel mt_tab;
    private javax.swing.JTable mt_table;
    private javax.swing.JLabel mt_txtLabel1;
    private javax.swing.JLabel mt_txtLabel2;
    private javax.swing.JLabel mt_txtLabel3;
    private javax.swing.JLabel mt_updateBtn;
    private javax.swing.JLabel sd_bgImg;
    private javax.swing.JLabel sd_checkBtn;
    private javax.swing.JLabel sd_closeBtn;
    private javax.swing.JComboBox sd_cond_cbox;
    private javax.swing.JTextField sd_driveFrom_txt;
    private javax.swing.JTextField sd_driveTo_txt;
    private javax.swing.JComboBox sd_guest_cbox;
    private javax.swing.JSpinner sd_km_spin;
    private javax.swing.JLabel sd_label1;
    private javax.swing.JLabel sd_label10;
    private javax.swing.JLabel sd_label11;
    private javax.swing.JLabel sd_label5;
    private javax.swing.JLabel sd_label6;
    private javax.swing.JLabel sd_label7;
    private javax.swing.JLabel sd_label8;
    private javax.swing.JLabel sd_label9;
    private javax.swing.JLabel sd_saveBtn;
    private javax.swing.JPanel sd_tab;
    private javax.swing.JTextField sd_tbill_txt;
    private javax.swing.JComboBox sd_trspt_jcb;
    private javax.swing.JLabel sd_txtLabel1;
    private javax.swing.JLabel sd_txtLabel3;
    private javax.swing.JLabel sd_txtlabel2;
    private javax.swing.JLabel set_destination;
    private javax.swing.JPanel side_btn;
    private javax.swing.JPanel side_panel;
    private javax.swing.JLabel time_label;
    private javax.swing.JPanel time_panel;
    private javax.swing.JLabel trans_notNum_label;
    private javax.swing.JLabel trans_not_label;
    private javax.swing.JTabbedPane transport_tab;
    private com.toedter.calendar.JDateChooser vb_From_date;
    private com.toedter.calendar.JDateChooser vb_To_date;
    private javax.swing.JLabel vb_bgImg;
    private javax.swing.JLabel vb_closeBtn;
    private javax.swing.JLabel vb_confirmBtn;
    private javax.swing.JLabel vb_deleteBtn;
    private javax.swing.JLabel vb_label1;
    private javax.swing.JLabel vb_label2;
    private javax.swing.JLabel vb_label3;
    private javax.swing.JLabel vb_label4;
    private javax.swing.JLabel vb_label5;
    private javax.swing.JLabel vb_searchBtn;
    private javax.swing.JComboBox vb_service_cb;
    private javax.swing.JPanel vb_tab;
    private javax.swing.JTable vb_tabel;
    private javax.swing.JScrollPane vb_tablePane;
    private javax.swing.JLabel vb_todayBtn;
    private javax.swing.JLabel vb_updateBtn;
    private javax.swing.JLabel view_booking;
    private javax.swing.JLabel year;
    // End of variables declaration//GEN-END:variables
}
