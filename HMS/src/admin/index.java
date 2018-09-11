/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import AppPackage.AnimationClass;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author fawad
 */
public class index extends javax.swing.JFrame {
     ResultSet rs =null;
     PreparedStatement pst=null;
     Connection con =null;
     Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
     int timerun =0;
     Calendar cal;
     AnimationClass ac = new AnimationClass();
        //methods
     
     private int check_transport(){
        int total=0;
        int value=0;
       
        try{
        
       String sql="Select * from t_pickup where pick_up=1 and status=0";
       pst=con.prepareStatement(sql);
       rs=pst.executeQuery();
       if(rs.next()){
       total++;
       
       }
       
       
       String sql2="Select * from t_dropoff where drop_off=1 and status=0";
       pst=con.prepareStatement(sql2);
       rs=pst.executeQuery();
        if(rs.next()){
         total++;
         
        }
        if(total>0){
        value++;
        }
        
        }
        catch(Exception e){e.printStackTrace();}
        
        
        return value;
        }
     //2
     private int check_event(){
       
      int total=0;
      try{
      String sql="Select * from events where status=0";
      pst=con.prepareStatement(sql);
      rs=pst.executeQuery();
      if(rs.next()){
      
      total++;
      
      }
      

      }
      catch(Exception e){e.printStackTrace();}
      return total;
     }
     //3
     private int check_food(){
     int total=0;
     try
     {
     
     String sql="Select * from food_orders where status=0";
     pst=con.prepareStatement(sql);
     rs=pst.executeQuery();
     if(rs.next()){
     total++;
     }

     }
     catch(Exception e){e.printStackTrace();}
     
     return total;
     
     
     
     }
      
        //2
       private void notification(){
        int total=check_transport()+check_event()+check_food();
        if(total>0){
        red_circle.setIcon(new ImageIcon(getClass().getResource("/admin/Icons/bell_not.png")));
        num_label.setText(Integer.toString(total));
     
        
        new Thread()
       {        
               
         public void run()
            {
             try { 
           
            ac.jLabelYUp(150, 10, 2 , 2, notify_label);
            ac.jLabelYUp(150, 70, 2, 2, not_trans);
            ac.jLabelYUp(150, 70, 2, 2, not_event);
            ac.jLabelYUp(150, 70, 2, 2, not_food);
            
                 Thread.sleep(10000);
             
            ac.jLabelYDown(10, 150, 2, 2, notify_label);
            ac.jLabelYDown(70, 150, 2, 2, not_trans);
            ac.jLabelYDown(70, 150, 2, 2, not_event);
            ac.jLabelYDown(70, 150, 2, 2, not_food);
           
                 
             } catch (InterruptedException ex) {
                 Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
             }
             
            }
       }.start();
        
        //checking if a label contain text or not if not set text 
        //1
        if(check_transport()!=0){
        not_trans.setText("Transport");
        }
        
        //2
        if(check_event()!=0){
         not_event.setText("Event");
 
        }
      
        
        
        
        //3
        if(check_food()!=0)
        {
         not_food.setText("Food");
        }
        
        }
        else{
        red_circle.setIcon(null);
        num_label.setText(null);
        not_trans.setText("");
        not_event.setText("");
        not_food.setText("");
        
        
        }
       
       }
       
    public index() {
        
        initComponents();
        con=DatabaseManager.getconnect();
        notification();
        Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
       this.setSize(d.width, d.height);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       bg_image.setSize(d.width,d.height);
       body_panel.setSize(d.width,d.height);
       header_panel.setSize(d.width,150);
        
        
              new Thread()
        {
            
            @Override
                public void run()
                {
                    while (timerun == 0)
                    {  
                        
                        
                    cal= new GregorianCalendar();
                    
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
        java.awt.GridBagConstraints gridBagConstraints;

        body_panel = new javax.swing.JPanel();
        header_panel = new javax.swing.JPanel();
        admin_label = new javax.swing.JLabel();
        welcome_label = new javax.swing.JLabel();
        btn_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        close_label = new javax.swing.JLabel();
        mini_label = new javax.swing.JLabel();
        time_panel = new javax.swing.JPanel();
        month = new javax.swing.JLabel();
        day = new javax.swing.JLabel();
        year = new javax.swing.JLabel();
        clock = new javax.swing.JLabel();
        clock2 = new javax.swing.JLabel();
        time_label = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        bell_panel = new javax.swing.JPanel();
        num_label = new javax.swing.JLabel();
        red_circle = new javax.swing.JLabel();
        bell = new javax.swing.JLabel();
        center_panel = new javax.swing.JPanel();
        reserve_labl = new javax.swing.JLabel();
        food_labl = new javax.swing.JLabel();
        transport_labl = new javax.swing.JLabel();
        emp_labl = new javax.swing.JLabel();
        reports_label = new javax.swing.JLabel();
        guest_labl = new javax.swing.JLabel();
        msg_label = new javax.swing.JLabel();
        event_label = new javax.swing.JLabel();
        setting_label = new javax.swing.JLabel();
        footer_panel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        not_panel = new javax.swing.JPanel();
        not_food = new javax.swing.JLabel();
        not_trans = new javax.swing.JLabel();
        not_event = new javax.swing.JLabel();
        notify_label = new javax.swing.JLabel();
        bg_image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        body_panel.setOpaque(false);
        body_panel.setLayout(new java.awt.BorderLayout());

        header_panel.setMaximumSize(new java.awt.Dimension(1280, 165));
        header_panel.setMinimumSize(new java.awt.Dimension(1280, 165));
        header_panel.setOpaque(false);
        header_panel.setPreferredSize(new java.awt.Dimension(1280, 165));

        admin_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/admin.png"))); // NOI18N

        welcome_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        welcome_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/welcome.png"))); // NOI18N

        btn_panel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_panel.setOpaque(false);
        btn_panel.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/custom_frame2.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_panel.add(jLabel1);
        jLabel1.setBounds(10, 0, 180, 40);

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
        mini_label.setBounds(80, 2, 35, 35);

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

        bell_panel.setOpaque(false);
        bell_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        num_label.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        num_label.setForeground(new java.awt.Color(255, 255, 255));
        num_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bell_panel.add(num_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 40, -1));
        bell_panel.add(red_circle, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 40, 40));

        bell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bell.png"))); // NOI18N
        bell.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bellMousePressed(evt);
            }
        });
        bell_panel.add(bell, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 80, 60));

        javax.swing.GroupLayout header_panelLayout = new javax.swing.GroupLayout(header_panel);
        header_panel.setLayout(header_panelLayout);
        header_panelLayout.setHorizontalGroup(
            header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_panelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(admin_label)
                .addGap(6, 6, 6)
                .addComponent(welcome_label)
                .addGap(320, 320, 320)
                .addComponent(time_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(270, 270, 270)
                .addGroup(header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(header_panelLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(btn_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(header_panelLayout.createSequentialGroup()
                        .addComponent(bell_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(logout))))
        );
        header_panelLayout.setVerticalGroup(
            header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_panelLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(admin_label))
            .addGroup(header_panelLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(welcome_label, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(time_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(header_panelLayout.createSequentialGroup()
                .addComponent(btn_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bell_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(header_panelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(logout))))
        );

        body_panel.add(header_panel, java.awt.BorderLayout.PAGE_START);

        center_panel.setOpaque(false);
        java.awt.GridBagLayout center_panelLayout = new java.awt.GridBagLayout();
        center_panelLayout.columnWidths = new int[] {0, 50, 0, 50, 0, 50, 0, 50, 0, 50, 0, 50, 0, 50, 0, 50, 0, 50, 0, 50, 0};
        center_panelLayout.rowHeights = new int[] {0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0};
        center_panelLayout.columnWeights = new double[] {0.0};
        center_panelLayout.rowWeights = new double[] {0.0};
        center_panel.setLayout(center_panelLayout);

        reserve_labl.setBackground(new java.awt.Color(255, 255, 255));
        reserve_labl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/reservation.jpg"))); // NOI18N
        reserve_labl.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        reserve_labl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reserve_labl.setPreferredSize(new java.awt.Dimension(144, 144));
        reserve_labl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reserve_lablMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reserve_lablMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reserve_lablMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        center_panel.add(reserve_labl, gridBagConstraints);

        food_labl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/food.jpg"))); // NOI18N
        food_labl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        food_labl.setPreferredSize(new java.awt.Dimension(144, 144));
        food_labl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                food_lablMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                food_lablMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                food_lablMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        center_panel.add(food_labl, gridBagConstraints);

        transport_labl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/transportation.jpg"))); // NOI18N
        transport_labl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        transport_labl.setPreferredSize(new java.awt.Dimension(144, 144));
        transport_labl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transport_lablMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                transport_lablMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                transport_lablMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 0;
        center_panel.add(transport_labl, gridBagConstraints);

        emp_labl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/employee.jpg"))); // NOI18N
        emp_labl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        emp_labl.setPreferredSize(new java.awt.Dimension(144, 144));
        emp_labl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emp_lablMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                emp_lablMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                emp_lablMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        center_panel.add(emp_labl, gridBagConstraints);

        reports_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/report.jpg"))); // NOI18N
        reports_label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reports_label.setPreferredSize(new java.awt.Dimension(144, 144));
        reports_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reports_labelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reports_labelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reports_labelMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        center_panel.add(reports_label, gridBagConstraints);

        guest_labl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/guest_info1.jpg"))); // NOI18N
        guest_labl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guest_labl.setPreferredSize(new java.awt.Dimension(144, 144));
        guest_labl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guest_lablMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                guest_lablMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                guest_lablMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 8;
        center_panel.add(guest_labl, gridBagConstraints);

        msg_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/message.jpg"))); // NOI18N
        msg_label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        msg_label.setPreferredSize(new java.awt.Dimension(144, 144));
        msg_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                msg_labelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                msg_labelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                msg_labelMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 16;
        center_panel.add(msg_label, gridBagConstraints);

        event_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/event.jpg"))); // NOI18N
        event_label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        event_label.setPreferredSize(new java.awt.Dimension(144, 144));
        event_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                event_labelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                event_labelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                event_labelMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 8;
        center_panel.add(event_label, gridBagConstraints);

        setting_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/setting.jpg"))); // NOI18N
        setting_label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setting_label.setPreferredSize(new java.awt.Dimension(144, 144));
        setting_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setting_labelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setting_labelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setting_labelMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 16;
        center_panel.add(setting_label, gridBagConstraints);

        body_panel.add(center_panel, java.awt.BorderLayout.CENTER);

        footer_panel.setOpaque(false);
        footer_panel.setLayout(new java.awt.BorderLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/logo1.png"))); // NOI18N
        footer_panel.add(logo, java.awt.BorderLayout.EAST);

        not_panel.setOpaque(false);
        not_panel.setLayout(null);

        not_food.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        not_food.setForeground(new java.awt.Color(0, 204, 153));
        not_food.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        not_food.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        not_food.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                not_foodMousePressed(evt);
            }
        });
        not_panel.add(not_food);
        not_food.setBounds(210, 150, 80, 30);

        not_trans.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        not_trans.setForeground(new java.awt.Color(0, 204, 153));
        not_trans.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        not_trans.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        not_trans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                not_transMousePressed(evt);
            }
        });
        not_panel.add(not_trans);
        not_trans.setBounds(50, 150, 80, 30);

        not_event.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        not_event.setForeground(new java.awt.Color(0, 204, 153));
        not_event.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        not_event.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        not_event.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                not_eventMousePressed(evt);
            }
        });
        not_panel.add(not_event);
        not_event.setBounds(130, 150, 80, 30);

        notify_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/notify_label.png"))); // NOI18N
        not_panel.add(notify_label);
        notify_label.setBounds(20, 150, 310, 110);

        footer_panel.add(not_panel, java.awt.BorderLayout.CENTER);

        body_panel.add(footer_panel, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(body_panel);
        body_panel.setBounds(0, 0, 710, 610);

        bg_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/hm_bg.jpg"))); // NOI18N
        getContentPane().add(bg_image);
        bg_image.setBounds(0, 0, 710, 610);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      
 
    }//GEN-LAST:event_formWindowActivated

    private void close_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_labelMouseClicked
       System.exit(0);
    }//GEN-LAST:event_close_labelMouseClicked

    private void mini_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mini_labelMouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_mini_labelMouseClicked

    private void reserve_lablMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reserve_lablMouseEntered
        reserve_labl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 153), 4));
        reserve_labl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/reservation1.jpg")));
    }//GEN-LAST:event_reserve_lablMouseEntered

    private void reserve_lablMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reserve_lablMouseExited
        reserve_labl.setBorder(null);
        reserve_labl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/reservation.jpg")));
    }//GEN-LAST:event_reserve_lablMouseExited

    private void food_lablMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_food_lablMouseEntered
        food_labl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 153), 4));
        food_labl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/food1.jpg")));
    }//GEN-LAST:event_food_lablMouseEntered

    private void food_lablMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_food_lablMouseExited
        food_labl.setBorder(null);
        food_labl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/food.jpg")));
    }//GEN-LAST:event_food_lablMouseExited

    private void transport_lablMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transport_lablMouseEntered
        transport_labl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 153), 4));
        transport_labl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/transportation1.jpg")));
    }//GEN-LAST:event_transport_lablMouseEntered

    private void transport_lablMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transport_lablMouseExited
        transport_labl.setBorder(null);
        transport_labl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/transportation.jpg")));
    }//GEN-LAST:event_transport_lablMouseExited

    private void emp_lablMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emp_lablMouseEntered
        emp_labl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 153), 4));
        emp_labl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/employee1.jpg")));
    }//GEN-LAST:event_emp_lablMouseEntered

    private void emp_lablMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emp_lablMouseExited
       emp_labl.setBorder(null);
       emp_labl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/employee.jpg")));
    }//GEN-LAST:event_emp_lablMouseExited

    private void event_labelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_event_labelMouseEntered
        event_label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 153), 4));
        event_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/event1.jpg")));
    }//GEN-LAST:event_event_labelMouseEntered

    private void event_labelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_event_labelMouseExited
       event_label.setBorder(null);
       event_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/event.jpg")));
    }//GEN-LAST:event_event_labelMouseExited

    private void guest_lablMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guest_lablMouseEntered
        guest_labl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 153), 4));
        guest_labl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/guest_info2.jpg")));
    }//GEN-LAST:event_guest_lablMouseEntered

    private void guest_lablMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guest_lablMouseExited
       guest_labl.setBorder(null);
       guest_labl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/guest_info1.jpg")));
    }//GEN-LAST:event_guest_lablMouseExited

    private void reports_labelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reports_labelMouseEntered
        reports_label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 153), 4));
       reports_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/report1.jpg")));
    }//GEN-LAST:event_reports_labelMouseEntered

    private void reports_labelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reports_labelMouseExited
       reports_label.setBorder(null);
       reports_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/report.jpg")));
    }//GEN-LAST:event_reports_labelMouseExited

    private void msg_labelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_msg_labelMouseEntered
       msg_label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 153), 4));
        msg_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/message1.jpg"))); 
        
    }//GEN-LAST:event_msg_labelMouseEntered

    private void msg_labelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_msg_labelMouseExited
       msg_label.setBorder(null);
       msg_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/message.jpg")));
    }//GEN-LAST:event_msg_labelMouseExited

    private void setting_labelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setting_labelMouseEntered
      setting_label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 153), 4));
       setting_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/setting1.jpg"))); 
    }//GEN-LAST:event_setting_labelMouseEntered

    private void setting_labelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setting_labelMouseExited
         setting_label.setBorder(null);
       setting_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/setting.jpg")));
    }//GEN-LAST:event_setting_labelMouseExited

    private void emp_lablMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emp_lablMouseClicked
     
        employee f = new employee();
        f.setVisible(true);
       timerun=1;
        this.dispose();
    }//GEN-LAST:event_emp_lablMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void bellMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bellMousePressed
        notification();
    }//GEN-LAST:event_bellMousePressed

    private void not_foodMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_not_foodMousePressed
        food f=new food();
        f.setVisible(true);
        timerun=1;
        this.dispose();
        
        
    }//GEN-LAST:event_not_foodMousePressed

    private void not_transMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_not_transMousePressed
        transportation t=new transportation();
        t.setVisible(true);
        timerun=1;
        this.dispose();
        
    }//GEN-LAST:event_not_transMousePressed

    private void not_eventMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_not_eventMousePressed
        event e=new event();
        e.setVisible(true);
        timerun=1;
        this.dispose();
    }//GEN-LAST:event_not_eventMousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
  

    }//GEN-LAST:event_formWindowOpened

    private void reserve_lablMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reserve_lablMouseClicked
       reservation r = new reservation();
       r.setVisible(true);
       timerun=1;
       this.dispose();
    }//GEN-LAST:event_reserve_lablMouseClicked

    private void food_lablMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_food_lablMouseClicked
      food f = new food();
      f.setVisible(true);
      timerun=1;
      this.dispose();
    }//GEN-LAST:event_food_lablMouseClicked

    private void transport_lablMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transport_lablMouseClicked
      transportation t = new transportation();
      t.setVisible(true);
      timerun=1;
      this.dispose();
    }//GEN-LAST:event_transport_lablMouseClicked

    private void event_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_event_labelMouseClicked
        event e = new event();
        e.setVisible(true);
        timerun=1;
        this.dispose();
    }//GEN-LAST:event_event_labelMouseClicked

    private void guest_lablMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guest_lablMouseClicked
        guest  g= new guest();
        g.setVisible(true);
        timerun=1;
        this.dispose();
    }//GEN-LAST:event_guest_lablMouseClicked

    private void msg_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_msg_labelMouseClicked
       message m = new message();
       m.setVisible(true);
       timerun=1;
       this.dispose();
    }//GEN-LAST:event_msg_labelMouseClicked

    private void setting_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setting_labelMouseClicked
        setting s = new setting();
        s.setVisible(true);
        timerun=1;
        
    }//GEN-LAST:event_setting_labelMouseClicked

    private void reports_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reports_labelMouseClicked
        reports r = new reports();
        r.setVisible(true);
        timerun=1;
        this.dispose();
    }//GEN-LAST:event_reports_labelMouseClicked

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admin_label;
    private javax.swing.JLabel bell;
    private javax.swing.JPanel bell_panel;
    private javax.swing.JLabel bg_image;
    private javax.swing.JPanel body_panel;
    private javax.swing.JPanel btn_panel;
    private javax.swing.JPanel center_panel;
    private javax.swing.JLabel clock;
    private javax.swing.JLabel clock2;
    private javax.swing.JLabel close_label;
    private javax.swing.JLabel day;
    private javax.swing.JLabel emp_labl;
    private javax.swing.JLabel event_label;
    private javax.swing.JLabel food_labl;
    private javax.swing.JPanel footer_panel;
    private javax.swing.JLabel guest_labl;
    private javax.swing.JPanel header_panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel mini_label;
    private javax.swing.JLabel month;
    private javax.swing.JLabel msg_label;
    private javax.swing.JLabel not_event;
    private javax.swing.JLabel not_food;
    private javax.swing.JPanel not_panel;
    private javax.swing.JLabel not_trans;
    private javax.swing.JLabel notify_label;
    private javax.swing.JLabel num_label;
    private javax.swing.JLabel red_circle;
    private javax.swing.JLabel reports_label;
    private javax.swing.JLabel reserve_labl;
    private javax.swing.JLabel setting_label;
    private javax.swing.JLabel time_label;
    private javax.swing.JPanel time_panel;
    private javax.swing.JLabel transport_labl;
    private javax.swing.JLabel welcome_label;
    private javax.swing.JLabel year;
    // End of variables declaration//GEN-END:variables
}
