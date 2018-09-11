
package admin;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import net.proteanit.sql.DbUtils;


public class event extends javax.swing.JFrame {

    Date date;
    SpinnerDateModel sm;
    int timerun =0;
    String ename;
    boolean on_off=true;
    ResultSet rs =null;
    PreparedStatement pst=null;
    Connection con =null;
    

    //methods
    //1
     private boolean checkboolean(int c){
    if(c==0)
      return false;
    else
      return true;   
    }
    //2
    private String getdate(String date){
    String d= date;
    String Date=d.substring(0,12);
    return Date;
    
    }
    //3
    private String gettime(JSpinner s){
        
     JSpinner.DateEditor de = new JSpinner.DateEditor(s, "hh:mm a");
       
       s.setEditor(de);
        
       String time=de.getFormat().format(s.getValue());
       
        
    return time; 
    }
    //4
    private void updateTable(String e_name,JTable tabel){
     try
     {   
    String sql="Select * from events where event_name='"+e_name+"'";
    pst=con.prepareStatement(sql);
    rs=pst.executeQuery();
    tabel.setModel(DbUtils.resultSetToTableModel(rs));
     }
     catch(Exception e)
     {
     e.printStackTrace();
     }
    
    }
    //5
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
   //6
      private void check_event_not(){
      int total=0;
      try{
      String sql="Select * from events where status=0";
      pst=con.prepareStatement(sql);
      rs=pst.executeQuery();
      while(rs.next()){
      
      total++;
      
      }
        if(total > 0){
        event_not_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/not_label.png")));
        event_notNum_label.setText(Integer.toString(total));
        }
        else if(total<=0){
        
        event_notNum_label.setText("");
        event_not_label.setIcon(null);      
        }
      
      }
      catch(Exception e){e.printStackTrace();}
      }
    //7
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
    
    
    public event() {
        initComponents();
         Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
         this.setSize(d.width, d.height);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         event_tab.removeAll();
         bg_image.setSize(d.width,d.height);
         con=DatabaseManager.getconnect();
         check_event_not();
         
         

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

        body_panel = new javax.swing.JPanel();
        side_panel = new javax.swing.JPanel();
        side_btn = new javax.swing.JPanel();
        organise_event = new javax.swing.JLabel();
        modify_event = new javax.swing.JLabel();
        event_notNum_label = new javax.swing.JLabel();
        event_not_label = new javax.swing.JLabel();
        event_proposal = new javax.swing.JLabel();
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
        ar_refersh2 = new javax.swing.JLabel();
        footer_panel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        center_outer = new javax.swing.JPanel();
        center_inner = new javax.swing.JPanel();
        event_tab = new javax.swing.JTabbedPane();
        me_tab = new javax.swing.JPanel();
        me_label1 = new javax.swing.JLabel();
        me_closeBtn = new javax.swing.JLabel();
        me_shedule_panel = new javax.swing.JPanel();
        me_label6 = new javax.swing.JLabel();
        me_label7 = new javax.swing.JLabel();
        me_label8 = new javax.swing.JLabel();
        me_label9 = new javax.swing.JLabel();
        me_label5 = new javax.swing.JLabel();
        me_sdate_txt = new javax.swing.JTextField();
        me_txtlabel4 = new javax.swing.JLabel();
        me_edate_txt = new javax.swing.JTextField();
        me_txtlabel5 = new javax.swing.JLabel();
        me_etime_txt = new javax.swing.JTextField();
        me_txtlabel7 = new javax.swing.JLabel();
        me_stime_txt = new javax.swing.JTextField();
        me_txtlabel6 = new javax.swing.JLabel();
        me_deleteBtn = new javax.swing.JLabel();
        me_updateBtn = new javax.swing.JLabel();
        me_refreshBtn = new javax.swing.JLabel();
        me_table_pane = new javax.swing.JScrollPane();
        me_table = new javax.swing.JTable();
        me_label14 = new javax.swing.JLabel();
        me_guest_cbox = new javax.swing.JComboBox();
        me_checkBtn = new javax.swing.JLabel();
        me_label15 = new javax.swing.JLabel();
        me_cap_spin = new javax.swing.JSpinner();
        me_label16 = new javax.swing.JLabel();
        me_cat_cbox = new javax.swing.JComboBox();
        me_label18 = new javax.swing.JLabel();
        me_orgBy_cbox = new javax.swing.JComboBox();
        me_label19 = new javax.swing.JLabel();
        me_etype_cbox = new javax.swing.JComboBox();
        me_label20 = new javax.swing.JLabel();
        me_ename_txt = new javax.swing.JTextField();
        me_txtlabel1 = new javax.swing.JLabel();
        me_label21 = new javax.swing.JLabel();
        me_bgImg = new javax.swing.JLabel();
        ep_tab = new javax.swing.JPanel();
        ep_closeBtn = new javax.swing.JLabel();
        ep_form = new javax.swing.JPanel();
        ep_todayBtn = new javax.swing.JLabel();
        ep_label3 = new javax.swing.JLabel();
        ep_From_date = new com.toedter.calendar.JDateChooser();
        ep_label4 = new javax.swing.JLabel();
        ep_To_date = new com.toedter.calendar.JDateChooser();
        ep_searchBtn = new javax.swing.JLabel();
        ep_tablePane = new javax.swing.JScrollPane();
        ep_table = new javax.swing.JTable();
        ep_label1 = new javax.swing.JLabel();
        ep_label2 = new javax.swing.JLabel();
        ep_editBtn = new javax.swing.JLabel();
        ep_deleteBtn = new javax.swing.JLabel();
        ep_confirmBtn = new javax.swing.JLabel();
        ep_bgImg = new javax.swing.JLabel();
        oe_tab = new javax.swing.JPanel();
        oe_panel = new javax.swing.JPanel();
        oe_label4 = new javax.swing.JLabel();
        oe_label3 = new javax.swing.JLabel();
        oe_cat_cbox = new javax.swing.JComboBox();
        oe_saveBtn = new javax.swing.JLabel();
        oe_label6 = new javax.swing.JLabel();
        oe_cap_spin = new javax.swing.JSpinner();
        oe_label5 = new javax.swing.JLabel();
        oe_guest_cbox = new javax.swing.JComboBox();
        oe_label2 = new javax.swing.JLabel();
        oe_time_panel = new javax.swing.JPanel();
        oe_label8 = new javax.swing.JLabel();
        oe_sdate_date = new com.toedter.calendar.JDateChooser();
        oe_label9 = new javax.swing.JLabel();
        oe_edate_date = new com.toedter.calendar.JDateChooser();
        oe_label10 = new javax.swing.JLabel();
        oe_label11 = new javax.swing.JLabel();
        date = new Date();
        sm = new SpinnerDateModel(date,null,null,Calendar.HOUR);
        oe_Etime_spin = new javax.swing.JSpinner(sm);
        date = new Date();
        sm = new SpinnerDateModel(date,null,null,Calendar.HOUR);
        oe_Stime_spin = new javax.swing.JSpinner(sm);
        oe_label12 = new javax.swing.JLabel();
        oe_etype_cbox = new javax.swing.JComboBox();
        oe_label13 = new javax.swing.JLabel();
        oe_ename_txt = new javax.swing.JTextField();
        oe_txtlabel4 = new javax.swing.JLabel();
        oe_orgBy_cbox = new javax.swing.JComboBox();
        oe_checkBtn = new javax.swing.JLabel();
        oe_label1 = new javax.swing.JLabel();
        oe_closeBtn = new javax.swing.JLabel();
        oe_bgimg = new javax.swing.JLabel();
        bg_image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        body_panel.setOpaque(false);
        body_panel.setLayout(new java.awt.BorderLayout());

        side_panel.setOpaque(false);

        side_btn.setOpaque(false);
        side_btn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        organise_event.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/oe_label1.jpg"))); // NOI18N
        organise_event.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        organise_event.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                organise_eventMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                organise_eventMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                organise_eventMouseExited(evt);
            }
        });
        side_btn.add(organise_event, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 293, -1));

        modify_event.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/me_label1.jpg"))); // NOI18N
        modify_event.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modify_event.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modify_eventMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                modify_eventMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                modify_eventMouseExited(evt);
            }
        });
        side_btn.add(modify_event, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 161, 293, -1));

        event_notNum_label.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        event_notNum_label.setForeground(new java.awt.Color(255, 255, 255));
        event_notNum_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        event_notNum_label.setToolTipText("");
        side_btn.add(event_notNum_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 50, 50));
        side_btn.add(event_not_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, -1, -1));

        event_proposal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/ep_label1.jpg"))); // NOI18N
        event_proposal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        event_proposal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                event_proposalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                event_proposalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                event_proposalMouseExited(evt);
            }
        });
        side_btn.add(event_proposal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 322, 293, -1));

        javax.swing.GroupLayout side_panelLayout = new javax.swing.GroupLayout(side_panel);
        side_panel.setLayout(side_panelLayout);
        side_panelLayout.setHorizontalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(side_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        side_panelLayout.setVerticalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(side_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(221, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 312, Short.MAX_VALUE)
                .addGroup(header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(header_panelLayout.createSequentialGroup()
                        .addComponent(ar_refersh2)
                        .addGap(18, 18, 18)
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

        event_tab.setPreferredSize(new java.awt.Dimension(945, 600));

        me_tab.setLayout(null);

        me_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        me_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        me_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/mev_h.png"))); // NOI18N
        me_tab.add(me_label1);
        me_label1.setBounds(0, 40, 200, 40);

        me_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        me_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        me_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                me_closeBtnMouseClicked(evt);
            }
        });
        me_tab.add(me_closeBtn);
        me_closeBtn.setBounds(904, 0, 30, 31);

        me_shedule_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        me_shedule_panel.setOpaque(false);
        me_shedule_panel.setLayout(null);

        me_label6.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_label6.setText("Start Date");
        me_shedule_panel.add(me_label6);
        me_label6.setBounds(20, 50, 110, 30);

        me_label7.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_label7.setText("End Date");
        me_shedule_panel.add(me_label7);
        me_label7.setBounds(20, 100, 110, 30);

        me_label8.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_label8.setText("Start Time");
        me_shedule_panel.add(me_label8);
        me_label8.setBounds(20, 150, 110, 30);

        me_label9.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_label9.setText("End Time");
        me_shedule_panel.add(me_label9);
        me_label9.setBounds(20, 200, 90, 30);

        me_label5.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        me_label5.setText("Schedule");
        me_shedule_panel.add(me_label5);
        me_label5.setBounds(106, 13, 110, 30);

        me_sdate_txt.setBackground(new java.awt.Color(123, 211, 172));
        me_sdate_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_sdate_txt.setBorder(null);
        me_sdate_txt.setOpaque(false);
        me_sdate_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        me_shedule_panel.add(me_sdate_txt);
        me_sdate_txt.setBounds(140, 60, 130, 23);

        me_txtlabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        me_shedule_panel.add(me_txtlabel4);
        me_txtlabel4.setBounds(130, 50, 150, 40);

        me_edate_txt.setBackground(new java.awt.Color(123, 211, 172));
        me_edate_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_edate_txt.setBorder(null);
        me_edate_txt.setOpaque(false);
        me_edate_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        me_shedule_panel.add(me_edate_txt);
        me_edate_txt.setBounds(140, 110, 130, 23);

        me_txtlabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        me_shedule_panel.add(me_txtlabel5);
        me_txtlabel5.setBounds(130, 100, 150, 40);

        me_etime_txt.setBackground(new java.awt.Color(123, 211, 172));
        me_etime_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_etime_txt.setBorder(null);
        me_etime_txt.setOpaque(false);
        me_etime_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        me_shedule_panel.add(me_etime_txt);
        me_etime_txt.setBounds(140, 210, 130, 23);

        me_txtlabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        me_shedule_panel.add(me_txtlabel7);
        me_txtlabel7.setBounds(130, 200, 150, 40);

        me_stime_txt.setBackground(new java.awt.Color(123, 211, 172));
        me_stime_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_stime_txt.setBorder(null);
        me_stime_txt.setOpaque(false);
        me_stime_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        me_shedule_panel.add(me_stime_txt);
        me_stime_txt.setBounds(140, 160, 130, 23);

        me_txtlabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        me_shedule_panel.add(me_txtlabel6);
        me_txtlabel6.setBounds(130, 150, 150, 40);

        me_tab.add(me_shedule_panel);
        me_shedule_panel.setBounds(590, 70, 290, 270);

        me_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_1.png"))); // NOI18N
        me_deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                me_deleteBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                me_deleteBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                me_deleteBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                me_deleteBtnMousePressed(evt);
            }
        });
        me_tab.add(me_deleteBtn);
        me_deleteBtn.setBounds(420, 340, 100, 50);

        me_updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/update1.png"))); // NOI18N
        me_updateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                me_updateBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                me_updateBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                me_updateBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                me_updateBtnMousePressed(evt);
            }
        });
        me_tab.add(me_updateBtn);
        me_updateBtn.setBounds(310, 340, 100, 50);

        me_refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/refresh1.png"))); // NOI18N
        me_refreshBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                me_refreshBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                me_refreshBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                me_refreshBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                me_refreshBtnMouseReleased(evt);
            }
        });
        me_tab.add(me_refreshBtn);
        me_refreshBtn.setBounds(200, 340, 100, 50);

        me_table_pane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        me_table.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        me_table.setRowHeight(30);
        me_table.setSelectionBackground(new java.awt.Color(3, 201, 169));
        me_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                me_tableMouseClicked(evt);
            }
        });
        me_table_pane.setViewportView(me_table);

        me_tab.add(me_table_pane);
        me_table_pane.setBounds(0, 390, 940, 300);

        me_label14.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_label14.setText("Guest ID");
        me_tab.add(me_label14);
        me_label14.setBounds(30, 120, 110, 30);

        me_guest_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_tab.add(me_guest_cbox);
        me_guest_cbox.setBounds(150, 120, 80, 30);

        me_checkBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/find.png"))); // NOI18N
        me_checkBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        me_checkBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                me_checkBtnMousePressed(evt);
            }
        });
        me_tab.add(me_checkBtn);
        me_checkBtn.setBounds(240, 120, 32, 30);

        me_label15.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_label15.setText("Capacity");
        me_tab.add(me_label15);
        me_label15.setBounds(30, 180, 110, 40);

        me_cap_spin.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        me_cap_spin.setModel(new javax.swing.SpinnerNumberModel(0, 0, 1000, 1));
        me_tab.add(me_cap_spin);
        me_cap_spin.setBounds(150, 180, 130, 30);

        me_label16.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_label16.setText("Catering ");
        me_tab.add(me_label16);
        me_label16.setBounds(30, 240, 110, 30);

        me_cat_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_cat_cbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));
        me_tab.add(me_cat_cbox);
        me_cat_cbox.setBounds(150, 240, 130, 30);

        me_label18.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_label18.setText("Organise By");
        me_tab.add(me_label18);
        me_label18.setBounds(310, 240, 110, 30);

        me_orgBy_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_orgBy_cbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hotel", "Guest" }));
        me_tab.add(me_orgBy_cbox);
        me_orgBy_cbox.setBounds(430, 240, 130, 30);

        me_label19.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_label19.setText("Event Type ");
        me_tab.add(me_label19);
        me_label19.setBounds(310, 180, 100, 40);

        me_etype_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_etype_cbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Party", "Meeting", "Social", "Fundraising", "Exhibition", "Seminars", "Other" }));
        me_tab.add(me_etype_cbox);
        me_etype_cbox.setBounds(430, 180, 130, 30);

        me_label20.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_label20.setText("Event Name ");
        me_tab.add(me_label20);
        me_label20.setBounds(310, 120, 120, 40);

        me_ename_txt.setBackground(new java.awt.Color(123, 211, 172));
        me_ename_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_ename_txt.setBorder(null);
        me_ename_txt.setOpaque(false);
        me_ename_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        me_tab.add(me_ename_txt);
        me_ename_txt.setBounds(430, 130, 130, 23);

        me_txtlabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        me_tab.add(me_txtlabel1);
        me_txtlabel1.setBounds(420, 120, 150, 40);

        me_label21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/rc_header.png"))); // NOI18N
        me_tab.add(me_label21);
        me_label21.setBounds(0, 350, 130, 40);

        me_bgImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        me_bgImg.setText("Data");
        me_tab.add(me_bgImg);
        me_bgImg.setBounds(0, 0, 940, 690);

        event_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/me_tab.jpg")), me_tab); // NOI18N

        ep_tab.setLayout(null);

        ep_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        ep_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ep_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ep_closeBtnMouseClicked(evt);
            }
        });
        ep_tab.add(ep_closeBtn);
        ep_closeBtn.setBounds(903, 0, 30, 30);

        ep_form.setOpaque(false);
        ep_form.setLayout(null);

        ep_todayBtn.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ep_todayBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/radio_btn1.png"))); // NOI18N
        ep_todayBtn.setText("Today");
        ep_todayBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ep_todayBtn.setIconTextGap(10);
        ep_todayBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ep_todayBtnMouseClicked(evt);
            }
        });
        ep_form.add(ep_todayBtn);
        ep_todayBtn.setBounds(20, 20, 90, 40);

        ep_label3.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ep_label3.setText("Date From");
        ep_form.add(ep_label3);
        ep_label3.setBounds(20, 100, 100, 30);

        ep_From_date.setDateFormatString("yyyy-MM-dd");
        ep_form.add(ep_From_date);
        ep_From_date.setBounds(140, 100, 130, 30);

        ep_label4.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ep_label4.setText("Date To");
        ep_form.add(ep_label4);
        ep_label4.setBounds(20, 150, 65, 30);

        ep_To_date.setDateFormatString("yyyy-MM-dd");
        ep_form.add(ep_To_date);
        ep_To_date.setBounds(140, 150, 130, 30);

        ep_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search.png"))); // NOI18N
        ep_searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ep_searchBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ep_searchBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ep_searchBtnMousePressed(evt);
            }
        });
        ep_form.add(ep_searchBtn);
        ep_searchBtn.setBounds(90, 220, 150, 65);

        ep_tab.add(ep_form);
        ep_form.setBounds(0, 90, 400, 600);

        ep_tablePane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        ep_table.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        ep_table.setRowHeight(30);
        ep_table.setSelectionBackground(new java.awt.Color(3, 201, 169));
        ep_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ep_tableMouseClicked(evt);
            }
        });
        ep_tablePane.setViewportView(ep_table);

        ep_tab.add(ep_tablePane);
        ep_tablePane.setBounds(400, 110, 540, 580);

        ep_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        ep_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/ep_h.png"))); // NOI18N
        ep_tab.add(ep_label1);
        ep_label1.setBounds(0, 40, 170, 50);

        ep_label2.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        ep_label2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/rc_header.png"))); // NOI18N
        ep_tab.add(ep_label2);
        ep_label2.setBounds(400, 70, 110, 40);

        ep_editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/edit1.png"))); // NOI18N
        ep_editBtn.setEnabled(false);
        ep_editBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ep_editBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ep_editBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ep_editBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ep_editBtnMouseReleased(evt);
            }
        });
        ep_tab.add(ep_editBtn);
        ep_editBtn.setBounds(530, 60, 100, 50);

        ep_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_1.png"))); // NOI18N
        ep_deleteBtn.setEnabled(false);
        ep_deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ep_deleteBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ep_deleteBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ep_deleteBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ep_deleteBtnMouseReleased(evt);
            }
        });
        ep_tab.add(ep_deleteBtn);
        ep_deleteBtn.setBounds(770, 60, 100, 50);

        ep_confirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/confirm1.png"))); // NOI18N
        ep_confirmBtn.setEnabled(false);
        ep_confirmBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ep_confirmBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ep_confirmBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ep_confirmBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ep_confirmBtnMouseReleased(evt);
            }
        });
        ep_tab.add(ep_confirmBtn);
        ep_confirmBtn.setBounds(650, 60, 100, 50);

        ep_bgImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        ep_tab.add(ep_bgImg);
        ep_bgImg.setBounds(0, 0, 940, 690);

        event_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/ep_tab.jpg")), ep_tab); // NOI18N

        oe_tab.setMaximumSize(new java.awt.Dimension(900, 600));
        oe_tab.setOpaque(false);
        oe_tab.setPreferredSize(new java.awt.Dimension(900, 600));
        oe_tab.setLayout(null);

        oe_panel.setOpaque(false);
        oe_panel.setLayout(null);

        oe_label4.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        oe_label4.setText("Organise By");
        oe_panel.add(oe_label4);
        oe_label4.setBounds(320, 240, 110, 30);

        oe_label3.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        oe_label3.setText("Event Type ");
        oe_panel.add(oe_label3);
        oe_label3.setBounds(320, 180, 100, 40);

        oe_cat_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        oe_cat_cbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));
        oe_panel.add(oe_cat_cbox);
        oe_cat_cbox.setBounds(160, 240, 130, 30);

        oe_saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save1.png"))); // NOI18N
        oe_saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        oe_saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                oe_saveBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                oe_saveBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                oe_saveBtnMousePressed(evt);
            }
        });
        oe_panel.add(oe_saveBtn);
        oe_saveBtn.setBounds(250, 320, 150, 70);

        oe_label6.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        oe_label6.setText("Catering ");
        oe_panel.add(oe_label6);
        oe_label6.setBounds(40, 240, 110, 30);

        oe_cap_spin.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        oe_cap_spin.setModel(new javax.swing.SpinnerNumberModel(0, 0, 1000, 1));
        oe_panel.add(oe_cap_spin);
        oe_cap_spin.setBounds(160, 185, 130, 30);

        oe_label5.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        oe_label5.setText("Capacity");
        oe_panel.add(oe_label5);
        oe_label5.setBounds(40, 180, 110, 40);

        oe_guest_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        oe_panel.add(oe_guest_cbox);
        oe_guest_cbox.setBounds(160, 120, 80, 30);

        oe_label2.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        oe_label2.setText("Guest ID");
        oe_panel.add(oe_label2);
        oe_label2.setBounds(40, 120, 110, 30);

        oe_time_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        oe_time_panel.setOpaque(false);

        oe_label8.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        oe_label8.setText("Start Date");

        oe_sdate_date.setDateFormatString("yyyy-MM-dd");

        oe_label9.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        oe_label9.setText("End Date");

        oe_edate_date.setDateFormatString("yyyy-MM-dd");

        oe_label10.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        oe_label10.setText("Start Time");

        oe_label11.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        oe_label11.setText("End Time");

        JSpinner.DateEditor de = new JSpinner.DateEditor(oe_Etime_spin,"h:mm:a");
        oe_Etime_spin.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N
        oe_Etime_spin.setEditor(de);

        JSpinner.DateEditor de1 = new JSpinner.DateEditor(oe_Stime_spin,"h:mm:a");
        oe_Stime_spin.setEditor(de1);
        oe_Stime_spin.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N

        oe_label12.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        oe_label12.setText("Schedule");

        javax.swing.GroupLayout oe_time_panelLayout = new javax.swing.GroupLayout(oe_time_panel);
        oe_time_panel.setLayout(oe_time_panelLayout);
        oe_time_panelLayout.setHorizontalGroup(
            oe_time_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oe_time_panelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(oe_time_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oe_time_panelLayout.createSequentialGroup()
                        .addComponent(oe_label10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(oe_Stime_spin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(oe_time_panelLayout.createSequentialGroup()
                        .addComponent(oe_label11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(oe_Etime_spin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(oe_time_panelLayout.createSequentialGroup()
                        .addGroup(oe_time_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(oe_label9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(oe_label8, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(oe_time_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oe_sdate_date, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(oe_edate_date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, oe_time_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(oe_label12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        oe_time_panelLayout.setVerticalGroup(
            oe_time_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oe_time_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(oe_label12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(oe_time_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(oe_label8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oe_sdate_date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(oe_time_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(oe_edate_date, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(oe_label9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(oe_time_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oe_time_panelLayout.createSequentialGroup()
                        .addComponent(oe_label10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(oe_label11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(oe_time_panelLayout.createSequentialGroup()
                        .addComponent(oe_Stime_spin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(oe_Etime_spin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        oe_panel.add(oe_time_panel);
        oe_time_panel.setBounds(610, 120, 290, 250);

        oe_etype_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        oe_etype_cbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Party", "Meeting", "Social", "Fundraising", "Exhibition", "Seminars", "Other" }));
        oe_panel.add(oe_etype_cbox);
        oe_etype_cbox.setBounds(440, 185, 130, 30);

        oe_label13.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        oe_label13.setText("Event Name ");
        oe_panel.add(oe_label13);
        oe_label13.setBounds(320, 120, 120, 40);

        oe_ename_txt.setBackground(new java.awt.Color(123, 211, 172));
        oe_ename_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        oe_ename_txt.setBorder(null);
        oe_ename_txt.setOpaque(false);
        oe_ename_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        oe_panel.add(oe_ename_txt);
        oe_ename_txt.setBounds(440, 130, 130, 23);

        oe_txtlabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        oe_panel.add(oe_txtlabel4);
        oe_txtlabel4.setBounds(430, 120, 150, 40);

        oe_orgBy_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        oe_orgBy_cbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hotel", "Guest" }));
        oe_panel.add(oe_orgBy_cbox);
        oe_orgBy_cbox.setBounds(440, 240, 130, 30);

        oe_checkBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/find.png"))); // NOI18N
        oe_checkBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        oe_checkBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                oe_checkBtnMousePressed(evt);
            }
        });
        oe_panel.add(oe_checkBtn);
        oe_checkBtn.setBounds(250, 120, 32, 30);

        oe_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        oe_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oe_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/oe_h.png"))); // NOI18N
        oe_panel.add(oe_label1);
        oe_label1.setBounds(0, 10, 210, 50);

        oe_tab.add(oe_panel);
        oe_panel.setBounds(0, 30, 940, 660);

        oe_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        oe_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        oe_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oe_closeBtnMouseClicked(evt);
            }
        });
        oe_tab.add(oe_closeBtn);
        oe_closeBtn.setBounds(903, 0, 34, 31);

        oe_bgimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        oe_bgimg.setText("jLabel19");
        oe_tab.add(oe_bgimg);
        oe_bgimg.setBounds(0, 0, 940, 690);

        event_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/oe_tab.jpg")), oe_tab); // NOI18N

        javax.swing.GroupLayout center_innerLayout = new javax.swing.GroupLayout(center_inner);
        center_inner.setLayout(center_innerLayout);
        center_innerLayout.setHorizontalGroup(
            center_innerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(event_tab, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
        );
        center_innerLayout.setVerticalGroup(
            center_innerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(event_tab, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
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
                .addComponent(center_inner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        body_panel.add(center_outer, java.awt.BorderLayout.CENTER);

        getContentPane().add(body_panel);
        body_panel.setBounds(0, 0, 1280, 1030);

        bg_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/hm_bg.jpg"))); // NOI18N
        getContentPane().add(bg_image);
        bg_image.setBounds(0, 0, 1280, 1030);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void organise_eventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_organise_eventMouseClicked
        event_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/oe_tab.jpg")), oe_tab);
        event_tab.setSelectedComponent(oe_tab);
    }//GEN-LAST:event_organise_eventMouseClicked

    private void organise_eventMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_organise_eventMouseEntered
        organise_event.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/oe_label2.jpg")));
        organise_event.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_organise_eventMouseEntered

    private void organise_eventMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_organise_eventMouseExited
        organise_event.setBorder(null);
        organise_event.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/oe_label1.jpg")));
    }//GEN-LAST:event_organise_eventMouseExited

    private void modify_eventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modify_eventMouseClicked
        event_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/me_tab.jpg")), me_tab);
        event_tab.setSelectedComponent(me_tab);
    }//GEN-LAST:event_modify_eventMouseClicked

    private void modify_eventMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modify_eventMouseEntered
        modify_event.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/me_label2.jpg")));
        modify_event.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_modify_eventMouseEntered

    private void modify_eventMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modify_eventMouseExited
        modify_event.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/me_label1.jpg")));
        modify_event.setBorder(null);
    }//GEN-LAST:event_modify_eventMouseExited

    private void event_proposalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_event_proposalMouseClicked
        event_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/ep_tab.jpg")),ep_tab);
        event_tab.setSelectedComponent(ep_tab);
    }//GEN-LAST:event_event_proposalMouseClicked

    private void event_proposalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_event_proposalMouseEntered
        event_proposal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/ep_label2.jpg")));
        event_proposal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_event_proposalMouseEntered

    private void event_proposalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_event_proposalMouseExited
        event_proposal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/ep_label1.jpg")));
        event_proposal.setBorder(null);
    }//GEN-LAST:event_event_proposalMouseExited

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

    private void me_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_closeBtnMouseClicked
        event_tab.remove(me_tab);
    }//GEN-LAST:event_me_closeBtnMouseClicked

    private void me_deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_deleteBtnMouseClicked
        me_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_3.png")));
    }//GEN-LAST:event_me_deleteBtnMouseClicked

    private void me_deleteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_deleteBtnMouseEntered
        me_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_2.png")));
    }//GEN-LAST:event_me_deleteBtnMouseEntered

    private void me_deleteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_deleteBtnMouseExited
        me_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_1.png")));
    }//GEN-LAST:event_me_deleteBtnMouseExited

    private void me_updateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_updateBtnMouseClicked
        me_updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/update3.png")));
    }//GEN-LAST:event_me_updateBtnMouseClicked

    private void me_updateBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_updateBtnMouseEntered
        me_updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/update2.png")));
    }//GEN-LAST:event_me_updateBtnMouseEntered

    private void me_updateBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_updateBtnMouseExited
        me_updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/update1.png")));
    }//GEN-LAST:event_me_updateBtnMouseExited

    private void ep_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ep_closeBtnMouseClicked
        event_tab.remove(ep_tab);
    }//GEN-LAST:event_ep_closeBtnMouseClicked

    private void oe_saveBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oe_saveBtnMouseEntered
        oe_saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save2.png")));
    }//GEN-LAST:event_oe_saveBtnMouseEntered

    private void oe_saveBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oe_saveBtnMouseExited
        oe_saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save1.png")));
    }//GEN-LAST:event_oe_saveBtnMouseExited

    private void oe_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oe_closeBtnMouseClicked
        event_tab.remove(oe_tab);
    }//GEN-LAST:event_oe_closeBtnMouseClicked

    private void oe_saveBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oe_saveBtnMousePressed
        
      
      
      
        
        int c= oe_cat_cbox.getSelectedIndex();
        boolean cat=checkboolean(c);
        String sdate=((JTextField)oe_sdate_date.getDateEditor().getUiComponent()).getText();
        String edate=((JTextField)oe_edate_date.getDateEditor().getUiComponent()).getText();
        String stime=gettime(oe_Stime_spin);
        String etime=gettime(oe_Etime_spin);
        
        try{
        if(oe_orgBy_cbox.getSelectedIndex()==1){
        String sql="Insert into events (event_name,guest_id,event_type,organise_by,capacity,catering,start_date,start_time,end_date,end_time) "
                + "values (?,?,?,?,?,?,?,?,?,?)";
        
        pst=con.prepareStatement(sql);
        pst.setString(1,oe_ename_txt.getText() );
        pst.setInt(2, (int) oe_guest_cbox.getSelectedItem());
        pst.setString(3, oe_etype_cbox.getSelectedItem().toString());
        pst.setString(4,oe_orgBy_cbox.getSelectedItem().toString());
        pst.setInt(5,(int)oe_cap_spin.getValue());
        pst.setBoolean(6, cat);
        pst.setString(7, sdate);
        pst.setString(8, stime);
        pst.setString(9, edate);
        pst.setString(10, etime);
        
        
        pst.execute();
        JOptionPane.showMessageDialog(this, "Data saved");
        }
        else{
            
             String sql="Insert into events (event_name,event_type,organise_by,capacity,catering,start_date,start_time,end_date,end_time) "
                + "values (?,?,?,?,?,?,?,?,?)";
        
        pst=con.prepareStatement(sql);
        pst.setString(1,oe_ename_txt.getText() );
      
        pst.setString(2, oe_etype_cbox.getSelectedItem().toString());
        pst.setString(3,oe_orgBy_cbox.getSelectedItem().toString());
        pst.setInt(4,(int)oe_cap_spin.getValue());
        pst.setBoolean(5, cat);
        pst.setString(6, sdate);
        pst.setString(7, stime);
        pst.setString(8, edate);
        pst.setString(9, etime);
        
        
        pst.execute();
        JOptionPane.showMessageDialog(this, "Data saved");    
  
        }
        
        
        
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e);
        
        
        }
        
        
        
        
    }//GEN-LAST:event_oe_saveBtnMousePressed

    private void me_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_tableMouseClicked

       int row = me_table.getSelectedRow();
       ename=  me_table.getModel().getValueAt(row, 0).toString();
       me_guest_cbox.removeAllItems();
       
       try
       {
       
       String query="Select * from events where event_name='"+ename+"'";
       pst=con.prepareStatement(query);
       rs=pst.executeQuery();
       
       while(rs.next())
       {
       
       me_ename_txt.setText(rs.getString("event_name"));
       me_guest_cbox.addItem(rs.getInt("guest_id"));
       me_etype_cbox.setSelectedItem(rs.getString("event_type"));
       me_orgBy_cbox.setSelectedItem(rs.getString("organise_by"));
       me_cap_spin.setValue(rs.getInt("capacity"));
       
       boolean check = rs.getBoolean("catering");
       if(check == true){
       me_cat_cbox.setSelectedIndex(1);
       }
       else{
       me_cat_cbox.setSelectedIndex(0);
       }
      me_sdate_txt.setText(rs.getString("start_date"));
      me_edate_txt.setText(rs.getString("end_date"));
      me_stime_txt.setText(rs.getString("start_time"));
      me_etime_txt.setText(rs.getString("end_time"));
     

       }
       
       }
       catch(Exception e){
       JOptionPane.showMessageDialog(this, e);
       e.printStackTrace();
       }


    }//GEN-LAST:event_me_tableMouseClicked

    private void me_refreshBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_refreshBtnMousePressed
me_refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/refresh3.png"))); 

        try{
        
        String sql="Select * from events order by start_date";
        pst=con.prepareStatement(sql);
        rs=pst.executeQuery();
        
        me_table.setModel(DbUtils.resultSetToTableModel(rs));
        setColumn(me_table);
        if(me_table.getRowCount()==0){JOptionPane.showMessageDialog(this,"Sorry No Record Found !");}
        
        
        }
        catch(Exception e){ e.printStackTrace();}
        
        
        
    }//GEN-LAST:event_me_refreshBtnMousePressed

    private void me_updateBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_updateBtnMousePressed
      try{  
      int c= me_cat_cbox.getSelectedIndex();
      boolean cat=checkboolean(c); 
          
      if(me_guest_cbox.getItemCount()==0)
      {    
      String sql="Update events set event_name= ? ,event_type= ? , organise_by=?, capacity= ? ,catering=? , "
              + "start_date=? ,start_time=?,end_date=?,end_time=? where event_name = '"+ename+"' ";
     
     pst=con.prepareStatement(sql);
     pst.setString(1, me_ename_txt.getText());
     pst.setString(2, me_etype_cbox.getSelectedItem().toString());
     pst.setString(3, me_orgBy_cbox.getSelectedItem().toString());
     pst.setInt(4, (int)me_cap_spin.getValue());
     pst.setBoolean(5,cat );
     pst.setString(6, me_sdate_txt.getText());
     pst.setString(7, me_stime_txt.getText());
     pst.setString(8, me_edate_txt.getText());
     pst.setString(9, me_etime_txt.getText());
 
     
     pst.execute();
     JOptionPane.showMessageDialog(this, "Succesfully Updated", "Message",JOptionPane.INFORMATION_MESSAGE );
     updateTable(me_ename_txt.getText(), me_table);  
      }
      else{
       String sql1="Update events set event_name= ? ,guest_id= ? ,event_type= ? , organise_by=?, capacity= ? ,catering=? , "
              + "start_date=? ,start_time=?,end_date=?,end_time=? where event_name = '"+ename+"' ";
     
     pst=con.prepareStatement(sql1);
     pst.setString(1, me_ename_txt.getText());
     pst.setInt(2, (int) me_guest_cbox.getSelectedItem());
     pst.setString(3, me_etype_cbox.getSelectedItem().toString());
     pst.setString(4, me_orgBy_cbox.getSelectedItem().toString());
     pst.setInt(5, (int)me_cap_spin.getValue());
     pst.setBoolean(6,cat );
     pst.setString(7, me_sdate_txt.getText());
     pst.setString(8, me_stime_txt.getText());
     pst.setString(9, me_edate_txt.getText());
     pst.setString(10, me_etime_txt.getText());
 
     
     pst.execute();
     JOptionPane.showMessageDialog(this, "Succesfully Updated", "Message",JOptionPane.INFORMATION_MESSAGE );
     updateTable(me_ename_txt.getText(), me_table);    
      
      
      
      
      }
      }
      catch(Exception e){JOptionPane.showMessageDialog(this,e);}
        
    }//GEN-LAST:event_me_updateBtnMousePressed

    private void me_deleteBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_deleteBtnMousePressed
       int row = me_table.getSelectedRow();
        if(row ==-1){
        JOptionPane.showMessageDialog(this,"Please Select the Record you want to delete !");
        }
        else{
       String ename=  me_table.getModel().getValueAt(row, 0).toString();
       String sql= "Delete from events where event_name='"+ename+"'";
       int option=JOptionPane.showConfirmDialog(null,"Are You Sure You want to delete data");
       if(option==JOptionPane.YES_OPTION)
       {
       
       try{
       pst=con.prepareStatement(sql);
       
       pst.execute();
       
       JOptionPane.showMessageDialog(null,"Deleted Succesfully","Message",JOptionPane.INFORMATION_MESSAGE);
 
       
           
       }
       catch(Exception e){
       e.printStackTrace();
       }
       }
       }
        
        
        
    }//GEN-LAST:event_me_deleteBtnMousePressed

    private void oe_checkBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oe_checkBtnMousePressed
        if(oe_orgBy_cbox.getSelectedIndex()==1){
        try{
        oe_guest_cbox.removeAllItems();
        String sql="Select guest_id from guests";
        pst=con.prepareStatement(sql);
        rs=pst.executeQuery();
        
        while(rs.next()){
            
        int id =rs.getInt("guest_id");
        
        oe_guest_cbox.addItem(id);
   
        }
       if(oe_guest_cbox.getItemCount()==0){
       
       JOptionPane.showMessageDialog(null, "Sorry No Guests are availabel !","Info", JOptionPane.INFORMATION_MESSAGE);
           
       }   
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
        else{
        JOptionPane.showMessageDialog(this,"Please Choose Guests First in the field ! ");
        
        }
    }//GEN-LAST:event_oe_checkBtnMousePressed

    private void me_checkBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_checkBtnMousePressed
  if(me_orgBy_cbox.getSelectedIndex()==1){
        try{
        me_guest_cbox.removeAllItems();
        String sql="Select guest_id from guests";
        pst=con.prepareStatement(sql);
        rs=pst.executeQuery();
        
        while(rs.next()){
            
        int id =rs.getInt("guest_id");
        
        me_guest_cbox.addItem(id);
   
        }
       if(me_guest_cbox.getItemCount()==0){
       
       JOptionPane.showMessageDialog(null, "Sorry No Guests are availabel !","Info", JOptionPane.INFORMATION_MESSAGE);
           
       }   
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
        else{
        JOptionPane.showMessageDialog(this,"Please Choose Guests First in the field ! ");
        
        }
        
    }//GEN-LAST:event_me_checkBtnMousePressed

    private void ep_todayBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ep_todayBtnMouseClicked

        if(on_off==true){

            ep_todayBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/radio_btn2.png")));

            ep_From_date.setEnabled(false);
            ep_To_date.setEnabled(false);

            on_off=false;
        }
        else
        {
            ep_todayBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/radio_btn1.png")));
            ep_From_date.setEnabled(true);
            ep_To_date.setEnabled(true);

            on_off=true;
        }
    }//GEN-LAST:event_ep_todayBtnMouseClicked

    private void ep_searchBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ep_searchBtnMouseEntered
        ep_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search1.png")));
    }//GEN-LAST:event_ep_searchBtnMouseEntered

    private void ep_searchBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ep_searchBtnMouseExited
        ep_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search.png")));
    }//GEN-LAST:event_ep_searchBtnMouseExited

    private void ep_searchBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ep_searchBtnMousePressed

        if(on_off==false)
        {
            try{
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                String d=format.format(date);

                

                String sql="Select * from events  where  start_date = '"+d+"' ";
                pst=con.prepareStatement(sql);

                rs=pst.executeQuery();
                ep_table.setModel(DbUtils.resultSetToTableModel(rs));
                setColumn(ep_table);
                if(ep_table.getRowCount()==0){

                    JOptionPane.showMessageDialog(this,"Sorry No Record Found..!","Info",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            catch(Exception e){JOptionPane.showMessageDialog(this, e);
                e.printStackTrace();}

        }
        else if(on_off==true)
        {
            if(checkDatefield(ep_From_date, "From Date") && checkDatefield(ep_To_date, "To Date"))
            {
                try
                {
                   
                    String from =((JTextField)ep_From_date.getDateEditor().getUiComponent()).getText();
                    String  to=((JTextField)ep_To_date.getDateEditor().getUiComponent()).getText();

                    String sql2="Select * from events  where start_date between ? and ? ";
                    pst=con.prepareStatement(sql2);

                    pst.setString(1, from);
                    pst.setString(2, to);
                    rs=pst.executeQuery();
                    ep_table.setModel(DbUtils.resultSetToTableModel(rs));
                    setColumn(ep_table);

                    if(ep_table.getRowCount()==0)
                    {

                        JOptionPane.showMessageDialog(this,"Sorry No Record Found..!","Info",JOptionPane.INFORMATION_MESSAGE);
                    }

                }
                catch(Exception e){JOptionPane.showMessageDialog(this, e);}

            }

        }

    }//GEN-LAST:event_ep_searchBtnMousePressed

    private void ep_confirmBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ep_confirmBtnMousePressed
        if(ep_confirmBtn.isEnabled()){
        ep_confirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/confirm3.png"))); 

        int row = ep_table.getSelectedRow();
        String ename=  ep_table.getModel().getValueAt(row, 0).toString();
        int input=Integer.parseInt(JOptionPane.showInputDialog(this, "Enter bill Amount"));
        if(input >0){    
        try{
        String sql="update events set total_bill = ? , status=1 where event_name= '"+ename+"'";
        pst=con.prepareStatement(sql);
        pst.setInt(1, input);
        pst.execute();
        
        JOptionPane.showMessageDialog(this, "Authorised Succesful !");
        check_event_not();
        }
        
        catch(Exception e){
         JOptionPane.showMessageDialog(this, e);
        }
        }
        }
    }//GEN-LAST:event_ep_confirmBtnMousePressed

    private void ep_editBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ep_editBtnMousePressed
       if(ep_editBtn.isEnabled()) {
       ep_editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/edit3.png"))); 
       int row = ep_table.getSelectedRow();
       ename=  ep_table.getModel().getValueAt(row, 0).toString();
        
        try
       {
       
       String query="Select * from events where event_name='"+ename+"'";
       pst=con.prepareStatement(query);
       rs=pst.executeQuery();      
       me_table.setModel(DbUtils.resultSetToTableModel(rs));
       setColumn(me_table);
       event_tab.setSelectedComponent(me_tab);
       
       }
       catch(Exception e){
       e.printStackTrace();
       }
       }
    }//GEN-LAST:event_ep_editBtnMousePressed

    private void ar_refersh2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ar_refersh2MousePressed
        check_event_not();
    }//GEN-LAST:event_ar_refersh2MousePressed

    private void me_refreshBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_refreshBtnMouseReleased
me_refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/refresh2.png"))); 

    }//GEN-LAST:event_me_refreshBtnMouseReleased

    private void me_refreshBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_refreshBtnMouseEntered
    me_refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/refresh2.png"))); 

    }//GEN-LAST:event_me_refreshBtnMouseEntered

    private void me_refreshBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_refreshBtnMouseExited
    me_refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/refresh1.png"))); 

    }//GEN-LAST:event_me_refreshBtnMouseExited

    private void ep_editBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ep_editBtnMouseEntered
     ep_editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/edit2.png"))); 

    }//GEN-LAST:event_ep_editBtnMouseEntered

    private void ep_editBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ep_editBtnMouseExited
    ep_editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/edit1.png"))); 

    }//GEN-LAST:event_ep_editBtnMouseExited

    private void ep_editBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ep_editBtnMouseReleased
    ep_editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/edit2.png"))); 

    }//GEN-LAST:event_ep_editBtnMouseReleased

    private void ep_confirmBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ep_confirmBtnMouseExited
    ep_confirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/confirm1.png"))); 

    }//GEN-LAST:event_ep_confirmBtnMouseExited

    private void ep_confirmBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ep_confirmBtnMouseEntered
    ep_confirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/confirm2.png"))); 
    }//GEN-LAST:event_ep_confirmBtnMouseEntered

    private void ep_confirmBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ep_confirmBtnMouseReleased
    ep_confirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/confirm2.png")));

    }//GEN-LAST:event_ep_confirmBtnMouseReleased

    private void ep_deleteBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ep_deleteBtnMousePressed
       if(ep_deleteBtn.isEnabled())
       {
       ep_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_3.png")));

       int row = ep_table.getSelectedRow();
       String ename= ep_table.getModel().getValueAt(row, 0).toString();
       String sql= "Delete from events where event_name='"+ename+"'";
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
       }
        
        
        
    }//GEN-LAST:event_ep_deleteBtnMousePressed

    private void ep_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ep_tableMouseClicked
       
        int row =ep_table.getSelectedRow();
        if(ep_table.isRowSelected(row)==true)
       {
       ep_editBtn.setEnabled(true);
       ep_deleteBtn.setEnabled(true);
       ep_confirmBtn.setEnabled(true);
       }
        else
        {
       ep_editBtn.setEnabled(false);
       ep_deleteBtn.setEnabled(false);
       ep_confirmBtn.setEnabled(false);
        }
        
        
    }//GEN-LAST:event_ep_tableMouseClicked

    private void ep_deleteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ep_deleteBtnMouseEntered
      ep_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_2.png")));        
    }//GEN-LAST:event_ep_deleteBtnMouseEntered

    private void ep_deleteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ep_deleteBtnMouseExited
     ep_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_1.png"))); 

    }//GEN-LAST:event_ep_deleteBtnMouseExited

    private void ep_deleteBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ep_deleteBtnMouseReleased
    ep_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_2.png")));

    }//GEN-LAST:event_ep_deleteBtnMouseReleased

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adm_label;
    private javax.swing.JLabel admin_label;
    private javax.swing.JLabel ar_refersh2;
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
    private com.toedter.calendar.JDateChooser ep_From_date;
    private com.toedter.calendar.JDateChooser ep_To_date;
    private javax.swing.JLabel ep_bgImg;
    private javax.swing.JLabel ep_closeBtn;
    private javax.swing.JLabel ep_confirmBtn;
    private javax.swing.JLabel ep_deleteBtn;
    private javax.swing.JLabel ep_editBtn;
    private javax.swing.JPanel ep_form;
    private javax.swing.JLabel ep_label1;
    private javax.swing.JLabel ep_label2;
    private javax.swing.JLabel ep_label3;
    private javax.swing.JLabel ep_label4;
    private javax.swing.JLabel ep_searchBtn;
    private javax.swing.JPanel ep_tab;
    private javax.swing.JTable ep_table;
    private javax.swing.JScrollPane ep_tablePane;
    private javax.swing.JLabel ep_todayBtn;
    private javax.swing.JLabel event_notNum_label;
    private javax.swing.JLabel event_not_label;
    private javax.swing.JLabel event_proposal;
    private javax.swing.JTabbedPane event_tab;
    private javax.swing.JPanel footer_panel;
    private javax.swing.JPanel header_panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel me_bgImg;
    private javax.swing.JSpinner me_cap_spin;
    private javax.swing.JComboBox me_cat_cbox;
    private javax.swing.JLabel me_checkBtn;
    private javax.swing.JLabel me_closeBtn;
    private javax.swing.JLabel me_deleteBtn;
    private javax.swing.JTextField me_edate_txt;
    private javax.swing.JTextField me_ename_txt;
    private javax.swing.JTextField me_etime_txt;
    private javax.swing.JComboBox me_etype_cbox;
    private javax.swing.JComboBox me_guest_cbox;
    private javax.swing.JLabel me_label1;
    private javax.swing.JLabel me_label14;
    private javax.swing.JLabel me_label15;
    private javax.swing.JLabel me_label16;
    private javax.swing.JLabel me_label18;
    private javax.swing.JLabel me_label19;
    private javax.swing.JLabel me_label20;
    private javax.swing.JLabel me_label21;
    private javax.swing.JLabel me_label5;
    private javax.swing.JLabel me_label6;
    private javax.swing.JLabel me_label7;
    private javax.swing.JLabel me_label8;
    private javax.swing.JLabel me_label9;
    private javax.swing.JComboBox me_orgBy_cbox;
    private javax.swing.JLabel me_refreshBtn;
    private javax.swing.JTextField me_sdate_txt;
    private javax.swing.JPanel me_shedule_panel;
    private javax.swing.JTextField me_stime_txt;
    private javax.swing.JPanel me_tab;
    private javax.swing.JTable me_table;
    private javax.swing.JScrollPane me_table_pane;
    private javax.swing.JLabel me_txtlabel1;
    private javax.swing.JLabel me_txtlabel4;
    private javax.swing.JLabel me_txtlabel5;
    private javax.swing.JLabel me_txtlabel6;
    private javax.swing.JLabel me_txtlabel7;
    private javax.swing.JLabel me_updateBtn;
    private javax.swing.JLabel mini_label;
    private javax.swing.JLabel modify_event;
    private javax.swing.JLabel month;
    private javax.swing.JSpinner oe_Etime_spin;
    private javax.swing.JSpinner oe_Stime_spin;
    private javax.swing.JLabel oe_bgimg;
    private javax.swing.JSpinner oe_cap_spin;
    private javax.swing.JComboBox oe_cat_cbox;
    private javax.swing.JLabel oe_checkBtn;
    private javax.swing.JLabel oe_closeBtn;
    private com.toedter.calendar.JDateChooser oe_edate_date;
    private javax.swing.JTextField oe_ename_txt;
    private javax.swing.JComboBox oe_etype_cbox;
    private javax.swing.JComboBox oe_guest_cbox;
    private javax.swing.JLabel oe_label1;
    private javax.swing.JLabel oe_label10;
    private javax.swing.JLabel oe_label11;
    private javax.swing.JLabel oe_label12;
    private javax.swing.JLabel oe_label13;
    private javax.swing.JLabel oe_label2;
    private javax.swing.JLabel oe_label3;
    private javax.swing.JLabel oe_label4;
    private javax.swing.JLabel oe_label5;
    private javax.swing.JLabel oe_label6;
    private javax.swing.JLabel oe_label8;
    private javax.swing.JLabel oe_label9;
    private javax.swing.JComboBox oe_orgBy_cbox;
    private javax.swing.JPanel oe_panel;
    private javax.swing.JLabel oe_saveBtn;
    private com.toedter.calendar.JDateChooser oe_sdate_date;
    private javax.swing.JPanel oe_tab;
    private javax.swing.JPanel oe_time_panel;
    private javax.swing.JLabel oe_txtlabel4;
    private javax.swing.JLabel organise_event;
    private javax.swing.JPanel side_btn;
    private javax.swing.JPanel side_panel;
    private javax.swing.JLabel time_label;
    private javax.swing.JPanel time_panel;
    private javax.swing.JLabel year;
    // End of variables declaration//GEN-END:variables
}
