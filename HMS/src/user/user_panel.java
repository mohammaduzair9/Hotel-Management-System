/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import AppPackage.AnimationClass;
import admin.DatabaseManager;
import admin.Login;
import admin.login2;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import sun.security.jgss.GSSCaller;
import sun.security.jgss.GSSUtil;

/**
 *
 * @author pc
 */
public class user_panel extends javax.swing.JFrame {
    AnimationClass ac= new AnimationClass();
    DefaultListModel dm = new DefaultListModel();
    Date date;
    SpinnerDateModel sm;
    int timerun =0;
    ResultSet rs =null;
    PreparedStatement pst=null;
    Connection con =null;
    int food_bill=0;
    String  username;
    String guest_id;
    int rate;
    int trans_bill;
    boolean on_off=true;
   
    //methods
     private void fillCombo(String c,JComboBox j){
    try{
        
    String sql="select * from foods";
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
     //2
     private boolean checkboolean(int c){
    if(c==0)
      return false;
    else
      return true;   
    }
     //3
         private String gettime(JSpinner s){
        
     JSpinner.DateEditor de = new JSpinner.DateEditor(s, "hh:mm a");
       
       s.setEditor(de);
        
       String time=de.getFormat().format(s.getValue());
       
        
    return time; 
    }
    
    public user_panel() {
        initComponents();
         
       Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
       this.setSize(d.width, d.height);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       bg_image.setSize(d.width,d.height);
       body_panel.setSize(d.width,d.height);
       username=login2.user;
       guest_id=login2.guest_id;
       user_label.setText(username);
       user_tab.removeAll();
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

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body_panel = new javax.swing.JPanel();
        side_panel = new javax.swing.JPanel();
        side_btn = new javax.swing.JPanel();
        book_transport = new javax.swing.JLabel();
        view_inbox = new javax.swing.JLabel();
        order_foods = new javax.swing.JLabel();
        propose_event = new javax.swing.JLabel();
        header_panel = new javax.swing.JPanel();
        admin_label = new javax.swing.JLabel();
        user_label = new javax.swing.JLabel();
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
        up_label1 = new javax.swing.JLabel();
        center_outer = new javax.swing.JPanel();
        center_inner = new javax.swing.JPanel();
        user_tab = new javax.swing.JTabbedPane();
        of_tab = new javax.swing.JPanel();
        of_label1 = new javax.swing.JLabel();
        of_form = new javax.swing.JPanel();
        of_label2 = new javax.swing.JLabel();
        of_removeBtn = new javax.swing.JLabel();
        of_addBtn = new javax.swing.JLabel();
        of_submitBtn = new javax.swing.JLabel();
        of_msg = new javax.swing.JLabel();
        of_fooditem_pane = new javax.swing.JScrollPane();
        of_fooditem_list = new javax.swing.JList();
        of_foodtype_cbox = new javax.swing.JComboBox();
        of_label4 = new javax.swing.JLabel();
        of_label7 = new javax.swing.JLabel();
        of_orderitem_pane = new javax.swing.JScrollPane();
        of_orderitem_list = new javax.swing.JList();
        of_label8 = new javax.swing.JLabel();
        of_panel = new javax.swing.JPanel();
        of_image_label = new javax.swing.JLabel();
        of_fooditem_label = new javax.swing.JLabel();
        of_label6 = new javax.swing.JLabel();
        of_price_label = new javax.swing.JLabel();
        of_label3 = new javax.swing.JLabel();
        of_label5 = new javax.swing.JLabel();
        of_totalbill_label = new javax.swing.JLabel();
        of_closeBtn = new javax.swing.JLabel();
        of_refreshBtn = new javax.swing.JLabel();
        of_bgImg = new javax.swing.JLabel();
        bt_tab = new javax.swing.JPanel();
        bt_closeBtn = new javax.swing.JLabel();
        bt_form_panel = new javax.swing.JPanel();
        bt_label4 = new javax.swing.JLabel();
        bt_transport_cbox = new javax.swing.JComboBox();
        bt_label2 = new javax.swing.JLabel();
        bt_label3 = new javax.swing.JLabel();
        bt_submitBtn = new javax.swing.JLabel();
        bt_condition_cbox = new javax.swing.JComboBox();
        bt_km_spin = new javax.swing.JSpinner();
        bt_label5 = new javax.swing.JLabel();
        bt_totalBill_label = new javax.swing.JLabel();
        bt_checkBtn = new javax.swing.JLabel();
        bt_driveTo_txt = new javax.swing.JTextField();
        bt_txtlabel = new javax.swing.JLabel();
        bt_label6 = new javax.swing.JLabel();
        bt_msg = new javax.swing.JLabel();
        bt_label1 = new javax.swing.JLabel();
        bt_panel = new javax.swing.JPanel();
        bt_image_label = new javax.swing.JLabel();
        bt_maker_label = new javax.swing.JLabel();
        bt_label7 = new javax.swing.JLabel();
        bt_label8 = new javax.swing.JLabel();
        bt_model_no = new javax.swing.JLabel();
        bt_rate_label = new javax.swing.JLabel();
        bt_bgImg = new javax.swing.JLabel();
        pe_tab = new javax.swing.JPanel();
        pe_label1 = new javax.swing.JLabel();
        pe_closeBtn = new javax.swing.JLabel();
        pe_shedule_panel = new javax.swing.JPanel();
        pe_label6 = new javax.swing.JLabel();
        pe_start_date = new com.toedter.calendar.JDateChooser();
        pe_label7 = new javax.swing.JLabel();
        pe_end_date = new com.toedter.calendar.JDateChooser();
        pe_label8 = new javax.swing.JLabel();
        pe_label9 = new javax.swing.JLabel();
        date = new Date();
        sm = new SpinnerDateModel(date,null,null,Calendar.HOUR);
        pe_Etime_spin = new javax.swing.JSpinner(sm);
        date = new Date();
        sm = new SpinnerDateModel(date,null,null,Calendar.HOUR);
        pe_Stime_spin = new javax.swing.JSpinner(sm);
        pe_label10 = new javax.swing.JLabel();
        pe_ename_txt = new javax.swing.JTextField();
        pe_txtLabel = new javax.swing.JLabel();
        pe_label3 = new javax.swing.JLabel();
        pe_label2 = new javax.swing.JLabel();
        pe_eType_cbox = new javax.swing.JComboBox();
        pe_label4 = new javax.swing.JLabel();
        pe_cap_spin = new javax.swing.JSpinner();
        pe_label5 = new javax.swing.JLabel();
        pe_cat_cbox = new javax.swing.JComboBox();
        pe_submitBtn = new javax.swing.JLabel();
        pe_msg = new javax.swing.JLabel();
        pe_bgImage = new javax.swing.JLabel();
        vm_tab = new javax.swing.JPanel();
        vm_msgdisplay_panel = new javax.swing.JPanel();
        vm_subject_txt = new javax.swing.JTextField();
        vm_subject_label = new javax.swing.JLabel();
        vm_txtPane = new javax.swing.JScrollPane();
        vm_txt_area = new javax.swing.JTextArea();
        vm_txtarea_label = new javax.swing.JLabel();
        msg_label = new javax.swing.JLabel();
        vm_tablet_Btn = new javax.swing.JLabel();
        vm_tablet_label = new javax.swing.JLabel();
        vm_closeBtn = new javax.swing.JLabel();
        vm_bgImg = new javax.swing.JLabel();
        bg_logo = new javax.swing.JLabel();
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

        book_transport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bt_label1.jpg"))); // NOI18N
        book_transport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        book_transport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                book_transportMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                book_transportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                book_transportMouseExited(evt);
            }
        });

        view_inbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/vm_label1.jpg"))); // NOI18N
        view_inbox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        view_inbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view_inboxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                view_inboxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                view_inboxMouseExited(evt);
            }
        });

        order_foods.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/of_label1.jpg"))); // NOI18N
        order_foods.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        order_foods.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                order_foodsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                order_foodsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                order_foodsMouseExited(evt);
            }
        });

        propose_event.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/pe_label1.jpg"))); // NOI18N
        propose_event.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        propose_event.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                propose_eventMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                propose_eventMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                propose_eventMouseExited(evt);
            }
        });

        javax.swing.GroupLayout side_btnLayout = new javax.swing.GroupLayout(side_btn);
        side_btn.setLayout(side_btnLayout);
        side_btnLayout.setHorizontalGroup(
            side_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(book_transport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(view_inbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(order_foods, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
            .addComponent(propose_event, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        side_btnLayout.setVerticalGroup(
            side_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_btnLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(order_foods)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(book_transport)
                .addGap(26, 26, 26)
                .addComponent(propose_event)
                .addGap(27, 27, 27)
                .addComponent(view_inbox)
                .addGap(23, 23, 23))
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
                .addContainerGap(107, Short.MAX_VALUE))
        );

        body_panel.add(side_panel, java.awt.BorderLayout.LINE_START);

        header_panel.setMaximumSize(new java.awt.Dimension(1024, 165));
        header_panel.setMinimumSize(new java.awt.Dimension(1024, 165));
        header_panel.setOpaque(false);

        admin_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/admin.png"))); // NOI18N

        user_label.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N

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

        up_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        up_label1.setText("Welcome");

        javax.swing.GroupLayout header_panelLayout = new javax.swing.GroupLayout(header_panel);
        header_panel.setLayout(header_panelLayout);
        header_panelLayout.setHorizontalGroup(
            header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(header_panelLayout.createSequentialGroup()
                .addGap(546, 546, 546)
                .addComponent(time_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 351, Short.MAX_VALUE)
                .addGroup(header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header_panelLayout.createSequentialGroup()
                        .addComponent(logout)
                        .addContainerGap())))
            .addGroup(header_panelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(admin_label)
                .addGap(18, 18, 18)
                .addComponent(up_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_label, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        header_panelLayout.setVerticalGroup(
            header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_panelLayout.createSequentialGroup()
                .addGroup(header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(header_panelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(admin_label))
                    .addGroup(header_panelLayout.createSequentialGroup()
                        .addGroup(header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(header_panelLayout.createSequentialGroup()
                                .addComponent(btn_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(logout))
                            .addComponent(time_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(up_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(user_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 19, Short.MAX_VALUE)))
                .addContainerGap())
        );

        body_panel.add(header_panel, java.awt.BorderLayout.PAGE_START);

        center_outer.setOpaque(false);

        center_inner.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        center_inner.setAutoscrolls(true);
        center_inner.setMaximumSize(new java.awt.Dimension(950, 730));
        center_inner.setMinimumSize(new java.awt.Dimension(950, 730));
        center_inner.setOpaque(false);

        user_tab.setPreferredSize(new java.awt.Dimension(945, 600));

        of_tab.setLayout(null);

        of_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        of_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        of_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/of_h.png"))); // NOI18N
        of_tab.add(of_label1);
        of_label1.setBounds(0, 30, 210, 40);

        of_form.setOpaque(false);
        of_form.setLayout(null);

        of_label2.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        of_label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        of_label2.setText("Food Type");
        of_form.add(of_label2);
        of_label2.setBounds(250, 0, 130, 40);

        of_removeBtn.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        of_removeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/remove_btn1.png"))); // NOI18N
        of_removeBtn.setToolTipText("");
        of_removeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                of_removeBtnMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                of_removeBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                of_removeBtnMouseReleased(evt);
            }
        });
        of_form.add(of_removeBtn);
        of_removeBtn.setBounds(420, 470, 130, 70);

        of_addBtn.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        of_addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/ato_btn1.png"))); // NOI18N
        of_addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                of_addBtnMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                of_addBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                of_addBtnMouseReleased(evt);
            }
        });
        of_form.add(of_addBtn);
        of_addBtn.setBounds(80, 470, 130, 70);

        of_submitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/submit_1.png"))); // NOI18N
        of_submitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        of_submitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                of_submitBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                of_submitBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                of_submitBtnMousePressed(evt);
            }
        });
        of_form.add(of_submitBtn);
        of_submitBtn.setBounds(240, 550, 150, 65);

        of_msg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/submit_msg.png"))); // NOI18N
        of_form.add(of_msg);
        of_msg.setBounds(420, 680, 250, 70);

        of_fooditem_list.setBackground(new java.awt.Color(123, 211, 172));
        of_fooditem_list.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        of_fooditem_list.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        of_fooditem_list.setOpaque(false);
        of_fooditem_list.setSelectionBackground(new java.awt.Color(0, 204, 153));
        of_fooditem_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                of_fooditem_listMouseClicked(evt);
            }
        });
        of_fooditem_pane.setViewportView(of_fooditem_list);

        of_form.add(of_fooditem_pane);
        of_fooditem_pane.setBounds(30, 140, 240, 310);

        of_foodtype_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        of_foodtype_cbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                of_foodtype_cboxMousePressed(evt);
            }
        });
        of_form.add(of_foodtype_cbox);
        of_foodtype_cbox.setBounds(250, 50, 130, 30);

        of_label4.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        of_label4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        of_label4.setText("Your Order");
        of_form.add(of_label4);
        of_label4.setBounds(360, 80, 240, 40);

        of_label7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/list_bg.png"))); // NOI18N
        of_form.add(of_label7);
        of_label7.setBounds(0, 100, 300, 390);

        of_orderitem_list.setBackground(new java.awt.Color(123, 211, 172));
        of_orderitem_list.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        of_orderitem_list.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        of_orderitem_list.setOpaque(false);
        of_orderitem_list.setSelectionBackground(new java.awt.Color(0, 204, 153));
        of_orderitem_pane.setViewportView(of_orderitem_list);

        of_form.add(of_orderitem_pane);
        of_orderitem_pane.setBounds(360, 140, 240, 310);

        of_label8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/list_bg.png"))); // NOI18N
        of_form.add(of_label8);
        of_label8.setBounds(330, 100, 300, 390);

        of_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        of_panel.setOpaque(false);
        of_panel.setLayout(null);

        of_image_label.setFont(new java.awt.Font("GardensC", 0, 48)); // NOI18N
        of_image_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        of_image_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/food_image.png"))); // NOI18N
        of_image_label.setMaximumSize(new java.awt.Dimension(215, 215));
        of_panel.add(of_image_label);
        of_image_label.setBounds(15, 70, 230, 215);

        of_fooditem_label.setFont(new java.awt.Font("GardensC", 0, 36)); // NOI18N
        of_fooditem_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        of_fooditem_label.setText("Food Item");
        of_panel.add(of_fooditem_label);
        of_fooditem_label.setBounds(0, 10, 260, 50);

        of_label6.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        of_label6.setText("Price ");
        of_panel.add(of_label6);
        of_label6.setBounds(30, 310, 70, 50);

        of_price_label.setFont(new java.awt.Font("Verdana", 0, 48)); // NOI18N
        of_panel.add(of_price_label);
        of_price_label.setBounds(110, 290, 140, 80);

        of_form.add(of_panel);
        of_panel.setBounds(660, 90, 260, 380);

        of_label3.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        of_label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        of_label3.setText("Food Items");
        of_form.add(of_label3);
        of_label3.setBounds(30, 80, 240, 40);

        of_label5.setFont(new java.awt.Font("GardensC", 0, 36)); // NOI18N
        of_label5.setText("Total Amount");
        of_form.add(of_label5);
        of_label5.setBounds(690, 490, 220, 50);

        of_totalbill_label.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        of_totalbill_label.setForeground(new java.awt.Color(0, 204, 153));
        of_totalbill_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        of_totalbill_label.setText("0");
        of_form.add(of_totalbill_label);
        of_totalbill_label.setBounds(690, 550, 210, 50);

        of_tab.add(of_form);
        of_form.setBounds(0, 50, 940, 640);

        of_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        of_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        of_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                of_closeBtnMouseClicked(evt);
            }
        });
        of_tab.add(of_closeBtn);
        of_closeBtn.setBounds(900, 0, 34, 31);

        of_refreshBtn.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        of_refreshBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        of_refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/reload.png"))); // NOI18N
        of_refreshBtn.setText("Refersh");
        of_refreshBtn.setToolTipText("");
        of_refreshBtn.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        of_refreshBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        of_refreshBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                of_refreshBtnMousePressed(evt);
            }
        });
        of_tab.add(of_refreshBtn);
        of_refreshBtn.setBounds(800, 0, 90, 32);

        of_bgImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        of_tab.add(of_bgImg);
        of_bgImg.setBounds(0, 0, 940, 690);

        user_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/of_tab_label.jpg")), of_tab); // NOI18N
        of_tab.getAccessibleContext().setAccessibleParent(user_tab);

        bt_tab.setLayout(null);

        bt_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        bt_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_closeBtnMouseClicked(evt);
            }
        });
        bt_tab.add(bt_closeBtn);
        bt_closeBtn.setBounds(903, 0, 30, 30);

        bt_form_panel.setOpaque(false);
        bt_form_panel.setLayout(null);

        bt_label4.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        bt_label4.setText("Drive To");
        bt_form_panel.add(bt_label4);
        bt_label4.setBounds(150, 200, 130, 40);

        bt_transport_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        bt_transport_cbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bt_transport_cboxMousePressed(evt);
            }
        });
        bt_form_panel.add(bt_transport_cbox);
        bt_transport_cbox.setBounds(330, 100, 130, 30);

        bt_label2.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        bt_label2.setText("Condition");
        bt_form_panel.add(bt_label2);
        bt_label2.setBounds(150, 50, 110, 30);

        bt_label3.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        bt_label3.setText("Transport");
        bt_form_panel.add(bt_label3);
        bt_label3.setBounds(150, 100, 100, 30);

        bt_submitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/submit_1.png"))); // NOI18N
        bt_submitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_submitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_submitBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_submitBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bt_submitBtnMousePressed(evt);
            }
        });
        bt_form_panel.add(bt_submitBtn);
        bt_submitBtn.setBounds(230, 390, 150, 65);

        bt_condition_cbox.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        bt_condition_cbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Excellent", "Good", "Average" }));
        bt_form_panel.add(bt_condition_cbox);
        bt_condition_cbox.setBounds(330, 50, 130, 30);

        bt_km_spin.setModel(new javax.swing.SpinnerNumberModel(0, 0, 1000, 1));
        bt_km_spin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_km_spinMouseClicked(evt);
            }
        });
        bt_km_spin.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                bt_km_spinStateChanged(evt);
            }
        });
        bt_form_panel.add(bt_km_spin);
        bt_km_spin.setBounds(330, 150, 130, 30);

        bt_label5.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        bt_label5.setText("Total Amount");
        bt_form_panel.add(bt_label5);
        bt_label5.setBounds(150, 260, 150, 40);

        bt_totalBill_label.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        bt_totalBill_label.setForeground(new java.awt.Color(0, 204, 153));
        bt_totalBill_label.setText("0");
        bt_form_panel.add(bt_totalBill_label);
        bt_totalBill_label.setBounds(330, 250, 170, 50);

        bt_checkBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/find.png"))); // NOI18N
        bt_checkBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_checkBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bt_checkBtnMousePressed(evt);
            }
        });
        bt_form_panel.add(bt_checkBtn);
        bt_checkBtn.setBounds(470, 100, 32, 32);

        bt_driveTo_txt.setBackground(new java.awt.Color(123, 211, 172));
        bt_driveTo_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        bt_driveTo_txt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bt_driveTo_txt.setBorder(null);
        bt_driveTo_txt.setOpaque(false);
        bt_driveTo_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        bt_form_panel.add(bt_driveTo_txt);
        bt_driveTo_txt.setBounds(330, 210, 130, 23);

        bt_txtlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        bt_form_panel.add(bt_txtlabel);
        bt_txtlabel.setBounds(320, 200, 150, 40);

        bt_label6.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        bt_label6.setText("Drive in Km");
        bt_form_panel.add(bt_label6);
        bt_label6.setBounds(150, 150, 130, 40);

        bt_msg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/submit_msg.png"))); // NOI18N
        bt_form_panel.add(bt_msg);
        bt_msg.setBounds(180, 650, 250, 70);

        bt_tab.add(bt_form_panel);
        bt_form_panel.setBounds(0, 80, 580, 610);

        bt_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        bt_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bt_h.png"))); // NOI18N
        bt_label1.setToolTipText("");
        bt_tab.add(bt_label1);
        bt_label1.setBounds(0, 30, 170, 40);

        bt_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        bt_panel.setOpaque(false);
        bt_panel.setLayout(null);

        bt_image_label.setFont(new java.awt.Font("GardensC", 0, 48)); // NOI18N
        bt_image_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bt_image_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_car.png"))); // NOI18N
        bt_image_label.setMaximumSize(new java.awt.Dimension(215, 215));
        bt_panel.add(bt_image_label);
        bt_image_label.setBounds(25, 70, 260, 215);

        bt_maker_label.setFont(new java.awt.Font("GardensC", 0, 36)); // NOI18N
        bt_maker_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bt_maker_label.setText("Transport");
        bt_panel.add(bt_maker_label);
        bt_maker_label.setBounds(0, 20, 310, 40);

        bt_label7.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        bt_label7.setText("Model No");
        bt_panel.add(bt_label7);
        bt_label7.setBounds(20, 300, 120, 50);

        bt_label8.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        bt_label8.setText("Rate");
        bt_panel.add(bt_label8);
        bt_label8.setBounds(20, 360, 70, 50);

        bt_model_no.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        bt_panel.add(bt_model_no);
        bt_model_no.setBounds(150, 300, 130, 50);

        bt_rate_label.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        bt_panel.add(bt_rate_label);
        bt_rate_label.setBounds(150, 360, 140, 50);

        bt_tab.add(bt_panel);
        bt_panel.setBounds(600, 110, 310, 430);

        bt_bgImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        bt_tab.add(bt_bgImg);
        bt_bgImg.setBounds(0, 0, 940, 690);

        user_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bt_tab_label.jpg")), bt_tab); // NOI18N
        bt_tab.getAccessibleContext().setAccessibleParent(user_tab);

        pe_tab.setMaximumSize(new java.awt.Dimension(900, 600));
        pe_tab.setOpaque(false);
        pe_tab.setPreferredSize(new java.awt.Dimension(900, 600));
        pe_tab.setLayout(null);

        pe_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        pe_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pe_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/pe_h.png"))); // NOI18N
        pe_tab.add(pe_label1);
        pe_label1.setBounds(0, 20, 210, 40);

        pe_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        pe_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pe_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pe_closeBtnMouseClicked(evt);
            }
        });
        pe_tab.add(pe_closeBtn);
        pe_closeBtn.setBounds(903, 0, 34, 31);

        pe_shedule_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pe_shedule_panel.setOpaque(false);

        pe_label6.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        pe_label6.setText("Start Date");

        pe_start_date.setDateFormatString("yyyy-MM-dd");

        pe_label7.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        pe_label7.setText("End Date");

        pe_end_date.setDateFormatString("yyyy-MM-dd");

        pe_label8.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        pe_label8.setText("Start Time");

        pe_label9.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        pe_label9.setText("End Time");

        JSpinner.DateEditor de = new JSpinner.DateEditor(pe_Etime_spin,"h:mm:a");
        pe_Etime_spin.setEditor(de);
        pe_Etime_spin.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N

        JSpinner.DateEditor de1 = new JSpinner.DateEditor(pe_Stime_spin,"h:mm:a");
        pe_Stime_spin.setEditor(de1);
        pe_Stime_spin.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N

        pe_label10.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        pe_label10.setText("Schedule");

        javax.swing.GroupLayout pe_shedule_panelLayout = new javax.swing.GroupLayout(pe_shedule_panel);
        pe_shedule_panel.setLayout(pe_shedule_panelLayout);
        pe_shedule_panelLayout.setHorizontalGroup(
            pe_shedule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pe_shedule_panelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pe_shedule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pe_shedule_panelLayout.createSequentialGroup()
                        .addComponent(pe_label8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(pe_Stime_spin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pe_shedule_panelLayout.createSequentialGroup()
                        .addComponent(pe_label9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(pe_Etime_spin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pe_shedule_panelLayout.createSequentialGroup()
                        .addComponent(pe_label6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(pe_start_date, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pe_shedule_panelLayout.createSequentialGroup()
                        .addComponent(pe_label7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(pe_end_date, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pe_shedule_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pe_label10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        pe_shedule_panelLayout.setVerticalGroup(
            pe_shedule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pe_shedule_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pe_label10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pe_shedule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pe_label6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pe_start_date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pe_shedule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pe_label7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pe_end_date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pe_shedule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pe_shedule_panelLayout.createSequentialGroup()
                        .addComponent(pe_label8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pe_label9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pe_shedule_panelLayout.createSequentialGroup()
                        .addComponent(pe_Stime_spin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(pe_Etime_spin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pe_tab.add(pe_shedule_panel);
        pe_shedule_panel.setBounds(540, 140, 290, 250);

        pe_ename_txt.setBackground(new java.awt.Color(123, 211, 172));
        pe_ename_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        pe_ename_txt.setBorder(null);
        pe_ename_txt.setOpaque(false);
        pe_ename_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        pe_tab.add(pe_ename_txt);
        pe_ename_txt.setBounds(330, 220, 130, 23);

        pe_txtLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        pe_tab.add(pe_txtLabel);
        pe_txtLabel.setBounds(320, 210, 150, 40);

        pe_label3.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        pe_label3.setText("Event Name ");
        pe_tab.add(pe_label3);
        pe_label3.setBounds(190, 210, 120, 40);

        pe_label2.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        pe_label2.setText("Event Type ");
        pe_tab.add(pe_label2);
        pe_label2.setBounds(190, 160, 100, 30);

        pe_eType_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        pe_eType_cbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Party", "Meeting", "Social", "Fundraising", "Exhibition", "Seminars", "Other" }));
        pe_tab.add(pe_eType_cbox);
        pe_eType_cbox.setBounds(330, 160, 130, 30);

        pe_label4.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        pe_label4.setText("Capacity");
        pe_tab.add(pe_label4);
        pe_label4.setBounds(190, 280, 110, 30);

        pe_cap_spin.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        pe_cap_spin.setModel(new javax.swing.SpinnerNumberModel(0, 0, 1000, 1));
        pe_tab.add(pe_cap_spin);
        pe_cap_spin.setBounds(330, 280, 130, 30);

        pe_label5.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        pe_label5.setText("Catering ");
        pe_tab.add(pe_label5);
        pe_label5.setBounds(190, 340, 110, 30);

        pe_cat_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        pe_cat_cbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));
        pe_tab.add(pe_cat_cbox);
        pe_cat_cbox.setBounds(330, 340, 130, 30);

        pe_submitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/submit_1.png"))); // NOI18N
        pe_submitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pe_submitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pe_submitBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pe_submitBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pe_submitBtnMousePressed(evt);
            }
        });
        pe_tab.add(pe_submitBtn);
        pe_submitBtn.setBounds(250, 440, 150, 70);

        pe_msg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/submit_msg.png"))); // NOI18N
        pe_tab.add(pe_msg);
        pe_msg.setBounds(210, 700, 260, 80);

        pe_bgImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        pe_bgImage.setText("jLabel19");
        pe_tab.add(pe_bgImage);
        pe_bgImage.setBounds(0, 0, 940, 690);

        user_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/pe_tab.jpg")), pe_tab); // NOI18N
        pe_tab.getAccessibleContext().setAccessibleParent(user_tab);

        vm_tab.setLayout(null);

        vm_msgdisplay_panel.setBackground(new java.awt.Color(255, 255, 255));
        vm_msgdisplay_panel.setOpaque(false);
        vm_msgdisplay_panel.setLayout(null);

        vm_subject_txt.setEditable(false);
        vm_subject_txt.setBackground(new java.awt.Color(53, 67, 67));
        vm_subject_txt.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        vm_subject_txt.setForeground(new java.awt.Color(0, 204, 153));
        vm_subject_txt.setBorder(null);
        vm_subject_txt.setOpaque(false);
        vm_msgdisplay_panel.add(vm_subject_txt);
        vm_subject_txt.setBounds(-400, 80, 320, 30);

        vm_subject_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/subject_header.png"))); // NOI18N
        vm_msgdisplay_panel.add(vm_subject_label);
        vm_subject_label.setBounds(-410, 60, 400, 70);

        vm_txtPane.setBackground(new java.awt.Color(53, 67, 67));
        vm_txtPane.setBorder(null);
        vm_txtPane.setOpaque(false);

        vm_txt_area.setEditable(false);
        vm_txt_area.setBackground(new java.awt.Color(53, 67, 67));
        vm_txt_area.setColumns(20);
        vm_txt_area.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        vm_txt_area.setForeground(new java.awt.Color(0, 204, 153));
        vm_txt_area.setLineWrap(true);
        vm_txt_area.setRows(5);
        vm_txt_area.setBorder(null);
        vm_txt_area.setOpaque(false);
        vm_txtPane.setViewportView(vm_txt_area);

        vm_msgdisplay_panel.add(vm_txtPane);
        vm_txtPane.setBounds(-460, 170, 450, 160);

        vm_txtarea_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/body_header.png"))); // NOI18N
        vm_msgdisplay_panel.add(vm_txtarea_label);
        vm_txtarea_label.setBounds(-520, 140, 500, 220);

        msg_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/message_label.jpg"))); // NOI18N
        vm_msgdisplay_panel.add(msg_label);
        msg_label.setBounds(220, -100, 110, 30);

        vm_tab.add(vm_msgdisplay_panel);
        vm_msgdisplay_panel.setBounds(150, 160, 570, 380);

        vm_tablet_Btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vm_tablet_Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vm_tablet_BtnMouseClicked(evt);
            }
        });
        vm_tab.add(vm_tablet_Btn);
        vm_tablet_Btn.setBounds(740, 310, 70, 70);

        vm_tablet_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vm_tablet_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/tablet.png"))); // NOI18N
        vm_tablet_label.setToolTipText("");
        vm_tablet_label.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        vm_tab.add(vm_tablet_label);
        vm_tablet_label.setBounds(60, 90, 790, 530);

        vm_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        vm_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vm_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vm_closeBtnMouseClicked(evt);
            }
        });
        vm_tab.add(vm_closeBtn);
        vm_closeBtn.setBounds(903, 0, 34, 31);

        vm_bgImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        vm_tab.add(vm_bgImg);
        vm_bgImg.setBounds(0, 0, 940, 690);

        user_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/vm_tab_label.png")), vm_tab); // NOI18N
        vm_tab.getAccessibleContext().setAccessibleParent(user_tab);

        bg_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/logo.png"))); // NOI18N
        bg_logo.setText("jLabel2");
        bg_logo.setPreferredSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout center_innerLayout = new javax.swing.GroupLayout(center_inner);
        center_inner.setLayout(center_innerLayout);
        center_innerLayout.setHorizontalGroup(
            center_innerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(user_tab, javax.swing.GroupLayout.PREFERRED_SIZE, 942, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(center_innerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(center_innerLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(bg_logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        center_innerLayout.setVerticalGroup(
            center_innerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(user_tab, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
            .addGroup(center_innerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(center_innerLayout.createSequentialGroup()
                    .addGap(0, 116, Short.MAX_VALUE)
                    .addComponent(bg_logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 116, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout center_outerLayout = new javax.swing.GroupLayout(center_outer);
        center_outer.setLayout(center_outerLayout);
        center_outerLayout.setHorizontalGroup(
            center_outerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(center_outerLayout.createSequentialGroup()
                .addComponent(center_inner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 37, Short.MAX_VALUE))
        );
        center_outerLayout.setVerticalGroup(
            center_outerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(center_inner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void book_transportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_transportMouseClicked
        user_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bt_tab_label.jpg")),bt_tab);
        user_tab.setSelectedComponent(bt_tab);
    }//GEN-LAST:event_book_transportMouseClicked

    private void book_transportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_transportMouseEntered
        book_transport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bt_label2.jpg")));
        book_transport.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_book_transportMouseEntered

    private void book_transportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_transportMouseExited
        book_transport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bt_label1.jpg")));
        book_transport.setBorder(null);
    }//GEN-LAST:event_book_transportMouseExited

    private void view_inboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_inboxMouseClicked
       user_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/vm_tab_label.png")), vm_tab);
        user_tab.setSelectedComponent(vm_tab);
    
    }//GEN-LAST:event_view_inboxMouseClicked

    private void view_inboxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_inboxMouseEntered
        view_inbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/vm_label2.jpg")));
        view_inbox.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_view_inboxMouseEntered

    private void view_inboxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_inboxMouseExited
        view_inbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/vm_label1.jpg")));
        view_inbox.setBorder(null);
    }//GEN-LAST:event_view_inboxMouseExited

    private void order_foodsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_order_foodsMouseClicked
        user_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/of_tab_label.jpg")), of_tab);
        user_tab.setSelectedComponent(of_tab);
    }//GEN-LAST:event_order_foodsMouseClicked

    private void order_foodsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_order_foodsMouseEntered
        order_foods.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/of_label2.jpg")));
        order_foods.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_order_foodsMouseEntered

    private void order_foodsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_order_foodsMouseExited
        order_foods.setBorder(null);
        order_foods.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/of_label1.jpg")));

    }//GEN-LAST:event_order_foodsMouseExited

    private void close_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_labelMouseClicked
        System.exit(0);
    }//GEN-LAST:event_close_labelMouseClicked

    private void mini_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mini_labelMouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_mini_labelMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        Login l = new Login();
        l.setVisible(true);
        timerun=1;
        this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void pe_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pe_closeBtnMouseClicked
        user_tab.remove(pe_tab);
    }//GEN-LAST:event_pe_closeBtnMouseClicked

    private void bt_submitBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_submitBtnMouseExited
        bt_submitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/submit_1.png")));
    }//GEN-LAST:event_bt_submitBtnMouseExited

    private void bt_submitBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_submitBtnMouseEntered
        bt_submitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/submit_2.png")));
    }//GEN-LAST:event_bt_submitBtnMouseEntered

    private void bt_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_closeBtnMouseClicked
        user_tab.remove(bt_tab);
    }//GEN-LAST:event_bt_closeBtnMouseClicked

    private void of_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_of_closeBtnMouseClicked
        
        of_foodtype_cbox.removeAllItems();
       
       
        of_fooditem_list.setModel(dm);
        dm.removeAllElements();
     
        of_orderitem_list.setModel(dm);
        dm.removeAllElements();
        of_price_label.setText("");
        of_totalbill_label.setText("0");
        of_fooditem_label.setText("Food Item");
        of_image_label.setText("");
        of_image_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/food_image.png")));

        
        user_tab.remove(of_tab);
    }//GEN-LAST:event_of_closeBtnMouseClicked

    private void of_submitBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_of_submitBtnMouseExited
        of_submitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/submit_1.png")));
    }//GEN-LAST:event_of_submitBtnMouseExited

    private void of_submitBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_of_submitBtnMouseEntered
        of_submitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/submit_2.png")));
    }//GEN-LAST:event_of_submitBtnMouseEntered

    private void of_addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_of_addBtnMouseClicked
        
        
        dm.addElement(of_fooditem_list.getSelectedValue());
        of_orderitem_list.setModel(dm);
        String food=of_fooditem_list.getSelectedValue().toString();
        
        try{
        String sql="Select rate from foods where food_name='"+food+"'";
        pst=con.prepareStatement(sql);
        rs=pst.executeQuery();
        rs.next();
        int rate=rs.getInt("rate");
        food_bill=food_bill+rate;
        
        of_totalbill_label.setText(Integer.toString(food_bill));
        
        
        }
        catch(Exception e){JOptionPane.showMessageDialog(this,e);}
        
        
    }//GEN-LAST:event_of_addBtnMouseClicked

    private void of_removeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_of_removeBtnMouseClicked
        
        String food=of_orderitem_list.getSelectedValue().toString();
        
        try{
        String sql="Select rate from foods where food_name='"+food+"'";
        pst=con.prepareStatement(sql);
        rs=pst.executeQuery();
        rs.next();
        int rate=rs.getInt("rate");
       
        food_bill=food_bill-rate;
        
        of_totalbill_label.setText(Integer.toString(food_bill));
        
        
        }
        catch(Exception e){JOptionPane.showMessageDialog(this,e);}
        dm.removeElement(of_orderitem_list.getSelectedValue());
        of_orderitem_list.setModel(dm);
    }//GEN-LAST:event_of_removeBtnMouseClicked

    private void of_refreshBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_of_refreshBtnMousePressed

        fillCombo("food_type",of_foodtype_cbox);

    }//GEN-LAST:event_of_refreshBtnMousePressed

    private void of_foodtype_cboxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_of_foodtype_cboxMousePressed
        DefaultListModel model = new DefaultListModel();
        String type=of_foodtype_cbox.getSelectedItem().toString();
        try{
        
        String sql="Select * from foods where food_type='"+type+"' ";
        pst=con.prepareStatement(sql);
        rs=pst.executeQuery();
        while(rs.next()){
        
            
        String add=rs.getString("food_name");
        if(model.indexOf(add)==-1){
        
        model.addElement(add);
        }
        
        of_fooditem_list.setModel(model);
        }
        
        }
        catch(Exception e){JOptionPane.showMessageDialog(this, e);}
        
        
        
    }//GEN-LAST:event_of_foodtype_cboxMousePressed

    private void of_fooditem_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_of_fooditem_listMouseClicked
        String food = of_fooditem_list.getSelectedValue().toString();
        try{
        String sql="Select * from foods where food_name='"+food+"'";
        pst=con.prepareStatement(sql);
        rs=pst.executeQuery();
        rs.next();
        String price=rs.getString("rate");
        String image_url= rs.getString("food_image");
        if(image_url == null){
        of_image_label.setIcon(null);
        of_image_label.setText("No Image");}
        else{
        ImageIcon image = new ImageIcon(image_url);
        of_image_label.setIcon(image);}
        of_fooditem_label.setText(food);
        of_price_label.setText(price);
        
        
        }
        catch(Exception e){JOptionPane.showMessageDialog(this, e);}
        
        
    }//GEN-LAST:event_of_fooditem_listMouseClicked

    private void of_submitBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_of_submitBtnMousePressed
        
        int size=of_orderitem_list.getModel().getSize();
        String items=of_orderitem_list.getModel().getElementAt(0).toString();
        int i=1;
        for( ;i<size;i++){
        
        String add=of_orderitem_list.getModel().getElementAt(i).toString();
        items=items+","+add;
        }
       
        try{
        String sql="Insert into food_orders (guest_id,room_no,orders,orders_item,food_bill) values "
                + "('"+guest_id+"',(Select room_no from booking where guest_id='"+guest_id+"'),?,?,?)";
        
        pst=con.prepareStatement(sql);
        pst.setString(1, items);
        pst.setInt(2, i);
        pst.setInt(3, food_bill);
        pst.execute();
        new Thread(){
         public void run(){  
        try{     
        ac.jLabelYUp(680, 550, 4, 2, of_msg);
        Thread.sleep(3000);
        ac.jLabelYDown(550, 680, 4 , 2, of_msg);
        }
        catch(Exception e){e.printStackTrace();} 
         }
        }.start();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e);
            e.printStackTrace();
        }
        
        
    }//GEN-LAST:event_of_submitBtnMousePressed

    private void of_addBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_of_addBtnMousePressed
       of_addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/ato_btn2.png")));
        
    }//GEN-LAST:event_of_addBtnMousePressed

    private void of_addBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_of_addBtnMouseReleased
        of_addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/ato_btn1.png")));
    }//GEN-LAST:event_of_addBtnMouseReleased

    private void of_removeBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_of_removeBtnMousePressed
        of_removeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/remove_btn2.png")));
    }//GEN-LAST:event_of_removeBtnMousePressed

    private void of_removeBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_of_removeBtnMouseReleased
     of_removeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/remove_btn1.png")));

    }//GEN-LAST:event_of_removeBtnMouseReleased

    private void bt_checkBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_checkBtnMousePressed
      
      String select=bt_condition_cbox.getSelectedItem().toString();
      
      
       if(select.equals(""))
         {
          JOptionPane.showMessageDialog(this, "Please Select Any one Condition First ! ","Warning",JOptionPane.WARNING_MESSAGE);
       }
         else{
        try{
          bt_transport_cbox.removeAllItems();
          String sql="Select transport_id from transport where condition='"+select+"'";
          pst=con.prepareStatement(sql);
          rs=pst.executeQuery();
          while(rs.next()){
          int id=rs.getInt("transport_id");
          bt_transport_cbox.addItem(id);
   
          }
         if(bt_transport_cbox.getItemCount()==0){
       
       JOptionPane.showMessageDialog(null, "Sorry No transports are availabel !","Info", JOptionPane.INFORMATION_MESSAGE);
           
       }   
            
           }
       catch(Exception e)
       {JOptionPane.showMessageDialog(this, e);
       e.printStackTrace();
       }
         
         }
        
    }//GEN-LAST:event_bt_checkBtnMousePressed

    private void bt_transport_cboxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_transport_cboxMousePressed
      int Select = (int) bt_transport_cbox.getSelectedItem();
      try{
      String sql="Select * from transport where transport_id='"+Select+"'";
      pst=con.prepareStatement(sql);
      rs=pst.executeQuery();
      rs.next();
      String maker=rs.getString("maker");
      String model=rs.getString("model_no");
       rate = rs.getInt("rate");
      String image_url= rs.getString("trans_image");
        if(image_url == null){
        bt_image_label.setIcon(null);
        bt_image_label.setText("No Image");}
        else{
        ImageIcon image = new ImageIcon(image_url);
        bt_image_label.setIcon(image);}
        bt_maker_label.setText(maker);
        bt_model_no.setText(model);
        bt_rate_label.setText(Integer.toString(rate));
      
      }
      catch(Exception e){JOptionPane.showMessageDialog(this,e);}
    }//GEN-LAST:event_bt_transport_cboxMousePressed

    private void bt_km_spinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_km_spinMouseClicked
        
        
        

    }//GEN-LAST:event_bt_km_spinMouseClicked

    private void bt_km_spinStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_bt_km_spinStateChanged
        int value =(int) bt_km_spin.getValue();
        trans_bill= rate * value;
        bt_totalBill_label.setText(Integer.toString(trans_bill));

    }//GEN-LAST:event_bt_km_spinStateChanged

    private void bt_submitBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_submitBtnMousePressed
        try{
        
            String sql="insert into t_dropoff (transport_id,guest_id,drop_off,drive_to,drive_from,km,bill) "
                    + "values (?,?,?,?,?,?,?) ";
            pst=con.prepareStatement(sql);
            pst.setInt(1,Integer.parseInt(bt_transport_cbox.getSelectedItem().toString()));
            pst.setInt(2, Integer.parseInt(guest_id));
            pst.setBoolean(3,true);
            pst.setString(4,bt_driveTo_txt.getText());
            pst.setString(5, "Hotel");
            pst.setInt(6, (int) bt_km_spin.getValue());
            pst.setInt(7,Integer.parseInt(bt_totalBill_label.getText()));
            
            pst.execute();
            
            new Thread(){
            
            public void run(){
             try{   
            ac.jLabelYUp(650, 500, 4, 2, bt_msg);
            Thread.sleep(3000);
            ac.jLabelYDown(550, 500 , 4 , 2, bt_msg);
             }
             catch(Exception e){e.printStackTrace();}
            
            }
            
            }.start();
           
            
           
            
            
        
        }
        catch(Exception e ){
        JOptionPane.showMessageDialog(this, e);
        
        }
        
    }//GEN-LAST:event_bt_submitBtnMousePressed

    private void pe_submitBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pe_submitBtnMousePressed
        
        try{
        int c=pe_cat_cbox.getSelectedIndex();
        String sdate=((JTextField)pe_start_date.getDateEditor().getUiComponent()).getText();
        String edate=((JTextField)pe_end_date.getDateEditor().getUiComponent()).getText();
        String stime=gettime(pe_Stime_spin);
        String etime=gettime(pe_Etime_spin);
        boolean cat=checkboolean(c);
        String sql="Insert into events (event_name,guest_id,event_type,organise_by,capacity,catering,start_date,start_time,end_date,end_time) "
                + "values (?,?,?,?,?,?,?,?,?,?)";
        pst=con.prepareStatement(sql);
        pst.setString(1, pe_ename_txt.getText());
        pst.setInt(2, Integer.parseInt(guest_id));
        pst.setString(3, pe_eType_cbox.getSelectedItem().toString());
        pst.setString(4, "Guest");
        pst.setInt(5, (int) pe_cap_spin.getValue());
        pst.setBoolean(6, cat);
        pst.setString(7, sdate);
        pst.setString(8, stime);
        pst.setString(9, edate);
        pst.setString(10, etime);
        
        pst.execute();
       
        new Thread(){
            
            public void run(){
             try{   
            ac.jLabelYUp(700, 550, 4, 2, pe_msg);
            Thread.sleep(3000);
            ac.jLabelYDown(550, 700 , 4 , 2, pe_msg);
             }
             catch(Exception e){e.printStackTrace();}
            
            }
            
            }.start();
        
        
        
        
        }
        catch(Exception e){JOptionPane.showMessageDialog(this,e);
        e.printStackTrace();}
        
        
        
    }//GEN-LAST:event_pe_submitBtnMousePressed

    private void propose_eventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_propose_eventMouseClicked
        user_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/pe_tab.jpg")), pe_tab);
        user_tab.setSelectedComponent(pe_tab);
    }//GEN-LAST:event_propose_eventMouseClicked

    private void propose_eventMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_propose_eventMouseEntered
        propose_event.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/pe_label2.jpg")));
        propose_event.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));      
    }//GEN-LAST:event_propose_eventMouseEntered

    private void propose_eventMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_propose_eventMouseExited
     propose_event.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/pe_label1.jpg")));
        propose_event.setBorder(null);
    }//GEN-LAST:event_propose_eventMouseExited

    private void vm_tablet_BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vm_tablet_BtnMouseClicked
      if(on_off== true)
      {
          vm_tablet_Btn.setIcon(new ImageIcon(getClass().getResource("/admin/Icons/tablet_button.png")));
        try{
        String sql="Select * from messages";
        pst=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs=pst.executeQuery();
        if(rs.last()){
        vm_subject_txt.setText(rs.getString("msg_subject"));
        vm_txt_area.setText(rs.getString("msg_body"));
        
        }
        }
        catch(Exception e){e.printStackTrace();}
       //thread 1
          new Thread()
          {
           public void run()
           {  
            try{
                
              
            ac.jLabelYDown(-100, 0, 2, 2, msg_label);
            Thread.sleep(500);
            ac.jLabelXRight(-410, 0, 2, 5, vm_subject_label);
            Thread.sleep(100);
            ac.jLabelXRight(-520, 0, 4, 4, vm_txtarea_label);
            Thread.sleep(1000);
            ac.jTextFieldXRight(-400, 10, 2, 5, vm_subject_txt);
            ac.jTextAreaXRight(-460, 10, 4, 4, vm_txtPane);
            }
            catch(Exception e){e.printStackTrace();}
           }   
          }.start();
    
        
           
        
        on_off=false;
      }
      else 
      {
          vm_tablet_Btn.setIcon(null);
          
          new Thread(){
           public void run(){
          try{     
     
       ac.jTextFieldXLeft(10,-400, 2, 2, vm_subject_txt);
       ac.jTextAreaXLeft(10,-460, 4, 2, vm_txtPane);
       Thread.sleep(1000);
       ac.jLabelXLeft(0, -410 , 2, 5, vm_subject_label);
       Thread.sleep(100);
       ac.jLabelXLeft(0, -520, 4, 4, vm_txtarea_label);
       Thread.sleep(500);
       ac.jLabelYUp(0 , -100, 2, 2, msg_label);   
          }
          catch(Exception e){e.printStackTrace();}
           }
       }.start();
          
      on_off=true;
      
      }
      
    }//GEN-LAST:event_vm_tablet_BtnMouseClicked

    private void vm_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vm_closeBtnMouseClicked

        user_tab.remove(vm_tab);
    }//GEN-LAST:event_vm_closeBtnMouseClicked

    private void pe_submitBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pe_submitBtnMouseEntered
        pe_submitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/submit_2.png")));

    }//GEN-LAST:event_pe_submitBtnMouseEntered

    private void pe_submitBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pe_submitBtnMouseExited
        pe_submitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/submit_1.png")));

    }//GEN-LAST:event_pe_submitBtnMouseExited
        
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admin_label;
    private javax.swing.JLabel bg_image;
    private javax.swing.JLabel bg_logo;
    private javax.swing.JPanel body_panel;
    private javax.swing.JLabel book_transport;
    private javax.swing.JLabel bt_bgImg;
    private javax.swing.JLabel bt_checkBtn;
    private javax.swing.JLabel bt_closeBtn;
    private javax.swing.JComboBox bt_condition_cbox;
    private javax.swing.JTextField bt_driveTo_txt;
    private javax.swing.JPanel bt_form_panel;
    private javax.swing.JLabel bt_image_label;
    private javax.swing.JSpinner bt_km_spin;
    private javax.swing.JLabel bt_label1;
    private javax.swing.JLabel bt_label2;
    private javax.swing.JLabel bt_label3;
    private javax.swing.JLabel bt_label4;
    private javax.swing.JLabel bt_label5;
    private javax.swing.JLabel bt_label6;
    private javax.swing.JLabel bt_label7;
    private javax.swing.JLabel bt_label8;
    private javax.swing.JLabel bt_maker_label;
    private javax.swing.JLabel bt_model_no;
    private javax.swing.JLabel bt_msg;
    private javax.swing.JPanel bt_panel;
    private javax.swing.JLabel bt_rate_label;
    private javax.swing.JLabel bt_submitBtn;
    private javax.swing.JPanel bt_tab;
    private javax.swing.JLabel bt_totalBill_label;
    private javax.swing.JComboBox bt_transport_cbox;
    private javax.swing.JLabel bt_txtlabel;
    private javax.swing.JPanel btn_panel;
    private javax.swing.JPanel center_inner;
    private javax.swing.JPanel center_outer;
    private javax.swing.JLabel clock;
    private javax.swing.JLabel clock2;
    private javax.swing.JLabel close_label;
    private javax.swing.JLabel day;
    private javax.swing.JPanel footer_panel;
    private javax.swing.JPanel header_panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel mini_label;
    private javax.swing.JLabel month;
    private javax.swing.JLabel msg_label;
    private javax.swing.JLabel of_addBtn;
    private javax.swing.JLabel of_bgImg;
    private javax.swing.JLabel of_closeBtn;
    private javax.swing.JLabel of_fooditem_label;
    private javax.swing.JList of_fooditem_list;
    private javax.swing.JScrollPane of_fooditem_pane;
    private javax.swing.JComboBox of_foodtype_cbox;
    private javax.swing.JPanel of_form;
    private javax.swing.JLabel of_image_label;
    private javax.swing.JLabel of_label1;
    private javax.swing.JLabel of_label2;
    private javax.swing.JLabel of_label3;
    private javax.swing.JLabel of_label4;
    private javax.swing.JLabel of_label5;
    private javax.swing.JLabel of_label6;
    private javax.swing.JLabel of_label7;
    private javax.swing.JLabel of_label8;
    private javax.swing.JLabel of_msg;
    private javax.swing.JList of_orderitem_list;
    private javax.swing.JScrollPane of_orderitem_pane;
    private javax.swing.JPanel of_panel;
    private javax.swing.JLabel of_price_label;
    private javax.swing.JLabel of_refreshBtn;
    private javax.swing.JLabel of_removeBtn;
    private javax.swing.JLabel of_submitBtn;
    private javax.swing.JPanel of_tab;
    private javax.swing.JLabel of_totalbill_label;
    private javax.swing.JLabel order_foods;
    private javax.swing.JSpinner pe_Etime_spin;
    private javax.swing.JSpinner pe_Stime_spin;
    private javax.swing.JLabel pe_bgImage;
    private javax.swing.JSpinner pe_cap_spin;
    private javax.swing.JComboBox pe_cat_cbox;
    private javax.swing.JLabel pe_closeBtn;
    private javax.swing.JComboBox pe_eType_cbox;
    private javax.swing.JTextField pe_ename_txt;
    private com.toedter.calendar.JDateChooser pe_end_date;
    private javax.swing.JLabel pe_label1;
    private javax.swing.JLabel pe_label10;
    private javax.swing.JLabel pe_label2;
    private javax.swing.JLabel pe_label3;
    private javax.swing.JLabel pe_label4;
    private javax.swing.JLabel pe_label5;
    private javax.swing.JLabel pe_label6;
    private javax.swing.JLabel pe_label7;
    private javax.swing.JLabel pe_label8;
    private javax.swing.JLabel pe_label9;
    private javax.swing.JLabel pe_msg;
    private javax.swing.JPanel pe_shedule_panel;
    private com.toedter.calendar.JDateChooser pe_start_date;
    private javax.swing.JLabel pe_submitBtn;
    private javax.swing.JPanel pe_tab;
    private javax.swing.JLabel pe_txtLabel;
    private javax.swing.JLabel propose_event;
    private javax.swing.JPanel side_btn;
    private javax.swing.JPanel side_panel;
    private javax.swing.JLabel time_label;
    private javax.swing.JPanel time_panel;
    private javax.swing.JLabel up_label1;
    private javax.swing.JLabel user_label;
    private javax.swing.JTabbedPane user_tab;
    private javax.swing.JLabel view_inbox;
    private javax.swing.JLabel vm_bgImg;
    private javax.swing.JLabel vm_closeBtn;
    private javax.swing.JPanel vm_msgdisplay_panel;
    private javax.swing.JLabel vm_subject_label;
    private javax.swing.JTextField vm_subject_txt;
    private javax.swing.JPanel vm_tab;
    private javax.swing.JLabel vm_tablet_Btn;
    private javax.swing.JLabel vm_tablet_label;
    private javax.swing.JScrollPane vm_txtPane;
    private javax.swing.JTextArea vm_txt_area;
    private javax.swing.JLabel vm_txtarea_label;
    private javax.swing.JLabel year;
    // End of variables declaration//GEN-END:variables
}
