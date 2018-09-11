/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;
        
import AppPackage.AnimationClass;
import java.awt.Component;
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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import net.proteanit.sql.DbUtils;

public class message extends javax.swing.JFrame {
    //instance variables
    
    int timerun =0;
    AnimationClass ac= new AnimationClass();
    ResultSet rs =null;
    PreparedStatement pst=null;
    Connection con =null;
    boolean on_off=true;
    Date date;
    SpinnerDateModel sm;
    Calendar cal;
    //methods
    //1
    public void messageSend(){
        
         new Thread(){ 
        @Override
        public void run()
        {  
             try {
       ac.jLabelYUp(650, 550, 4, 2, message_label);
           
                Thread.sleep(2000);
                
       ac.jLabelYDown(550, 650, 4, 2, message_label);
            } catch (Exception ex) {
               ex.printStackTrace();
            }
       
        }
       
       }.start();
 
    }
    //2
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

         

    
     
    public message() {
        
        initComponents();
        Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(d.width, d.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bg_image.setSize(d.width,d.height);
        body_panel.setSize(d.width,d.height);
        con=DatabaseManager.getconnect();
        msg_tab.removeAll();
        
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

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body_panel = new javax.swing.JPanel();
        side_panel = new javax.swing.JPanel();
        side_btn = new javax.swing.JPanel();
        create_msg = new javax.swing.JLabel();
        sent_msg = new javax.swing.JLabel();
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
        msg_tab = new javax.swing.JTabbedPane();
        sm_tab = new javax.swing.JPanel();
        sm_label1 = new javax.swing.JLabel();
        sm_closeBtn = new javax.swing.JLabel();
        sm_deleteBtn = new javax.swing.JLabel();
        sm_refreshBtn = new javax.swing.JLabel();
        sm_pane = new javax.swing.JScrollPane();
        sm_table = new javax.swing.JTable();
        del_msg = new javax.swing.JLabel();
        sm_bgImg = new javax.swing.JLabel();
        cm_tab = new javax.swing.JPanel();
        cm_form = new javax.swing.JPanel();
        cm_message_label = new javax.swing.JLabel();
        cm_subject_label = new javax.swing.JLabel();
        cm_sendBtn = new javax.swing.JLabel();
        cm_to_label = new javax.swing.JLabel();
        cm_scroll_pane = new javax.swing.JScrollPane();
        cm_msgBody_txtArea = new javax.swing.JTextArea();
        cm_txtLabel2 = new javax.swing.JLabel();
        cm_subject_txt = new javax.swing.JTextField();
        cm_txtLabel = new javax.swing.JLabel();
        cm_sent_all = new javax.swing.JLabel();
        cm_guest_cbox = new javax.swing.JComboBox();
        message_label = new javax.swing.JLabel();
        cm_checkBtn = new javax.swing.JLabel();
        cm_error_msg = new javax.swing.JLabel();
        cm_label1 = new javax.swing.JLabel();
        cm_closeBtn = new javax.swing.JLabel();
        cm_bgImage = new javax.swing.JLabel();
        footer_panel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        useless_panel = new javax.swing.JPanel();
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

        side_panel.setOpaque(false);

        side_btn.setOpaque(false);

        create_msg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/cm_label1.jpg"))); // NOI18N
        create_msg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        create_msg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                create_msgMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                create_msgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                create_msgMouseExited(evt);
            }
        });

        sent_msg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/sm_label1.jpg"))); // NOI18N
        sent_msg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sent_msg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sent_msgMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sent_msgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sent_msgMouseExited(evt);
            }
        });

        javax.swing.GroupLayout side_btnLayout = new javax.swing.GroupLayout(side_btn);
        side_btn.setLayout(side_btnLayout);
        side_btnLayout.setHorizontalGroup(
            side_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(create_msg, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
            .addComponent(sent_msg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        side_btnLayout.setVerticalGroup(
            side_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_btnLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(create_msg)
                .addGap(36, 36, 36)
                .addComponent(sent_msg)
                .addContainerGap(165, Short.MAX_VALUE))
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
                .addGap(87, 87, 87)
                .addComponent(side_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
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

        msg_tab.setPreferredSize(new java.awt.Dimension(945, 600));

        sm_tab.setLayout(null);

        sm_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        sm_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sm_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/sm_header.png"))); // NOI18N
        sm_tab.add(sm_label1);
        sm_label1.setBounds(0, 40, 200, 40);

        sm_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        sm_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sm_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sm_closeBtnMouseClicked(evt);
            }
        });
        sm_tab.add(sm_closeBtn);
        sm_closeBtn.setBounds(900, 0, 34, 31);

        sm_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_1.png"))); // NOI18N
        sm_deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sm_deleteBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sm_deleteBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sm_deleteBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sm_deleteBtnMouseReleased(evt);
            }
        });
        sm_tab.add(sm_deleteBtn);
        sm_deleteBtn.setBounds(120, 120, 100, 50);

        sm_refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/refresh1.png"))); // NOI18N
        sm_refreshBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sm_refreshBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sm_refreshBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sm_refreshBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sm_refreshBtnMouseReleased(evt);
            }
        });
        sm_tab.add(sm_refreshBtn);
        sm_refreshBtn.setBounds(10, 120, 100, 50);

        sm_table.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        sm_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        sm_table.setOpaque(false);
        sm_table.setRowHeight(30);
        sm_table.setSelectionBackground(new java.awt.Color(3, 201, 169));
        sm_pane.setViewportView(sm_table);

        sm_tab.add(sm_pane);
        sm_pane.setBounds(0, 180, 940, 510);

        del_msg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/delete_msg.png"))); // NOI18N
        sm_tab.add(del_msg);
        del_msg.setBounds(390, -100, 260, 80);

        sm_bgImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        sm_bgImg.setText("Data");
        sm_tab.add(sm_bgImg);
        sm_bgImg.setBounds(0, 0, 940, 690);

        msg_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/sm_tab_label.png")), sm_tab); // NOI18N

        cm_tab.setMaximumSize(new java.awt.Dimension(900, 600));
        cm_tab.setOpaque(false);
        cm_tab.setPreferredSize(new java.awt.Dimension(900, 600));
        cm_tab.setLayout(null);

        cm_form.setToolTipText("");
        cm_form.setOpaque(false);
        cm_form.setLayout(null);

        cm_message_label.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        cm_message_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/msg_label.png"))); // NOI18N
        cm_form.add(cm_message_label);
        cm_message_label.setBounds(-210, 210, 140, 60);

        cm_subject_label.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        cm_subject_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/sub_label.png"))); // NOI18N
        cm_form.add(cm_subject_label);
        cm_subject_label.setBounds(-210, 110, 140, 60);

        cm_sendBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/sendBtn1.png"))); // NOI18N
        cm_sendBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cm_sendBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cm_sendBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cm_sendBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cm_sendBtnMousePressed(evt);
            }
        });
        cm_form.add(cm_sendBtn);
        cm_sendBtn.setBounds(430, 650, 180, 60);

        cm_to_label.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        cm_to_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/to_label.png"))); // NOI18N
        cm_to_label.setToolTipText("");
        cm_form.add(cm_to_label);
        cm_to_label.setBounds(-210, 30, 140, 60);

        cm_scroll_pane.setBackground(new java.awt.Color(123, 211, 172));

        cm_msgBody_txtArea.setBackground(new java.awt.Color(123, 211, 172));
        cm_msgBody_txtArea.setColumns(20);
        cm_msgBody_txtArea.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        cm_msgBody_txtArea.setLineWrap(true);
        cm_msgBody_txtArea.setRows(5);
        cm_msgBody_txtArea.setBorder(null);
        cm_msgBody_txtArea.setCaretColor(new java.awt.Color(123, 211, 172));
        cm_msgBody_txtArea.setDisabledTextColor(new java.awt.Color(123, 211, 172));
        cm_msgBody_txtArea.setMargin(new java.awt.Insets(5, 5, 5, 5));
        cm_msgBody_txtArea.setOpaque(false);
        cm_msgBody_txtArea.setSelectionColor(new java.awt.Color(0, 204, 153));
        cm_scroll_pane.setViewportView(cm_msgBody_txtArea);

        cm_form.add(cm_scroll_pane);
        cm_scroll_pane.setBounds(270, 230, 470, 170);

        cm_txtLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/messageBox.png"))); // NOI18N
        cm_txtLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        cm_form.add(cm_txtLabel2);
        cm_txtLabel2.setBounds(220, 200, 550, 230);

        cm_subject_txt.setBackground(new java.awt.Color(123, 211, 172));
        cm_subject_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        cm_subject_txt.setBorder(null);
        cm_subject_txt.setOpaque(false);
        cm_subject_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        cm_form.add(cm_subject_txt);
        cm_subject_txt.setBounds(270, 130, 480, 30);

        cm_txtLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/subjectBox.png"))); // NOI18N
        cm_txtLabel.setText("jLabel3");
        cm_form.add(cm_txtLabel);
        cm_txtLabel.setBounds(250, 110, 510, 70);

        cm_sent_all.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        cm_sent_all.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/radio_btn1.png"))); // NOI18N
        cm_sent_all.setText("All");
        cm_sent_all.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cm_sent_all.setIconTextGap(10);
        cm_sent_all.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cm_sent_allMouseClicked(evt);
            }
        });
        cm_form.add(cm_sent_all);
        cm_sent_all.setBounds(260, 40, 90, 40);

        cm_guest_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        cm_form.add(cm_guest_cbox);
        cm_guest_cbox.setBounds(350, 40, 120, 30);

        message_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/send_msg.png"))); // NOI18N
        cm_form.add(message_label);
        message_label.setBounds(380, 650, 260, 70);

        cm_checkBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/find.png"))); // NOI18N
        cm_checkBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cm_checkBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cm_checkBtnMousePressed(evt);
            }
        });
        cm_form.add(cm_checkBtn);
        cm_checkBtn.setBounds(490, 40, 32, 30);

        cm_error_msg.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cm_error_msg.setForeground(new java.awt.Color(204, 0, 51));
        cm_form.add(cm_error_msg);
        cm_error_msg.setBounds(550, 30, 290, 50);

        cm_tab.add(cm_form);
        cm_form.setBounds(0, 60, 940, 630);

        cm_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        cm_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cm_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/cm_header.png"))); // NOI18N
        cm_tab.add(cm_label1);
        cm_label1.setBounds(0, 10, 210, 40);

        cm_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        cm_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cm_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cm_closeBtnMouseClicked(evt);
            }
        });
        cm_tab.add(cm_closeBtn);
        cm_closeBtn.setBounds(903, 0, 34, 31);

        cm_bgImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        cm_bgImage.setText("jLabel19");
        cm_tab.add(cm_bgImage);
        cm_bgImage.setBounds(-10, 0, 950, 700);

        msg_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/cm_tab_label.png")), cm_tab); // NOI18N

        javax.swing.GroupLayout center_innerLayout = new javax.swing.GroupLayout(center_inner);
        center_inner.setLayout(center_innerLayout);
        center_innerLayout.setHorizontalGroup(
            center_innerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(msg_tab, javax.swing.GroupLayout.PREFERRED_SIZE, 942, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        center_innerLayout.setVerticalGroup(
            center_innerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(msg_tab, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
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

        useless_panel.setOpaque(false);
        useless_panel.setLayout(null);
        footer_panel.add(useless_panel, java.awt.BorderLayout.CENTER);

        body_panel.add(footer_panel, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(body_panel);
        body_panel.setBounds(0, 0, 1280, 1030);

        bg_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/hm_bg.jpg"))); // NOI18N
        getContentPane().add(bg_image);
        bg_image.setBounds(0, 0, 1280, 1030);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void create_msgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_create_msgMouseClicked
        msg_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/cm_tab_label.png")), cm_tab);
        msg_tab.setSelectedComponent(cm_tab);
        final AnimationClass ac= new AnimationClass();
        
        new Thread(){ 
        
        int count=0;
        @Override
        public void run() {
        switch(count){
            case 0:{
         ac.jLabelXRight(-210, 70, 4, 3, cm_to_label);
         ac.jLabelXRight(-210, 70, 4, 3, cm_subject_label);
         ac.jLabelXRight(-210, 70, 4, 3, cm_message_label);
            
            count =1;
            }
            case 1:{
            try {
                Thread.sleep(600);
                 ac.jLabelYUp(650, 450, 4, 2, cm_sendBtn);
                  
            
            } catch (InterruptedException ex) {
                Logger.getLogger(message.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
            }
        }
}
    }.start();
         
         
        
    }//GEN-LAST:event_create_msgMouseClicked

    private void create_msgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_create_msgMouseEntered
        create_msg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/cm_label2.jpg")));
        create_msg.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_create_msgMouseEntered

    private void create_msgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_create_msgMouseExited
        create_msg.setBorder(null);
        create_msg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/cm_label1.jpg")));
    }//GEN-LAST:event_create_msgMouseExited

    private void sent_msgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sent_msgMouseClicked
        msg_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/sm_tab_label.png")), sm_tab);
        msg_tab.setSelectedComponent(sm_tab);
    }//GEN-LAST:event_sent_msgMouseClicked

    private void sent_msgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sent_msgMouseEntered
        sent_msg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/sm_label2.jpg")));
        sent_msg.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_sent_msgMouseEntered

    private void sent_msgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sent_msgMouseExited
        sent_msg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/sm_label1.jpg")));
        sent_msg.setBorder(null);
    }//GEN-LAST:event_sent_msgMouseExited

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

    private void cm_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cm_closeBtnMouseClicked
        cm_to_label.setLocation(-210, 30);
        cm_subject_label.setLocation(-210, 110);
        cm_message_label.setLocation(-210, 210);
        cm_sendBtn.setLocation(320, 650);
       
        cm_guest_cbox.setEnabled(true);
        on_off=true;
        cm_guest_cbox.removeAllItems();
        cm_sent_all.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/radio_btn1.png")));
        cm_subject_txt.setText("");
        message_label.setLocation(380, 650);
        cm_msgBody_txtArea.setText("");
       
        msg_tab.remove(cm_tab);
    }//GEN-LAST:event_cm_closeBtnMouseClicked

    private void cm_sent_allMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cm_sent_allMouseClicked
            if(on_off==true){

            cm_sent_all.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/radio_btn2.png")));

            cm_guest_cbox.setEnabled(false);
            cm_error_msg.setText(null);
            

            on_off=false;
        }
        else
        {
            cm_sent_all.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/radio_btn1.png")));
            
            cm_guest_cbox.setEnabled(true);

            on_off=true;
        }
    }//GEN-LAST:event_cm_sent_allMouseClicked

    private void cm_sendBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cm_sendBtnMouseExited
        cm_sendBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/sendBtn1.png")));
    }//GEN-LAST:event_cm_sendBtnMouseExited

    private void cm_sendBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cm_sendBtnMouseEntered
        cm_sendBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/sendBtn2.png")));
    }//GEN-LAST:event_cm_sendBtnMouseEntered

    private void sm_deleteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sm_deleteBtnMouseExited
        sm_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_1.png")));
    }//GEN-LAST:event_sm_deleteBtnMouseExited

    private void sm_deleteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sm_deleteBtnMouseEntered
        sm_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_2.png")));
    }//GEN-LAST:event_sm_deleteBtnMouseEntered

    private void sm_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sm_closeBtnMouseClicked
        msg_tab.remove(sm_tab);
    }//GEN-LAST:event_sm_closeBtnMouseClicked

    private void cm_checkBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cm_checkBtnMousePressed

        try{
        cm_error_msg.setText(null);
        cm_guest_cbox.removeAllItems();
        String sql="Select guest_id from guests";
        pst=con.prepareStatement(sql);
        rs=pst.executeQuery();
        
        while(rs.next()){
            
        int id =rs.getInt("guest_id");
        
        cm_guest_cbox.addItem(id);
   
        }
       if(cm_guest_cbox.getItemCount()==0){
       
       JOptionPane.showMessageDialog(null, "Sorry No Guests are availabel !","Info", JOptionPane.INFORMATION_MESSAGE);
           
       }   
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
    }//GEN-LAST:event_cm_checkBtnMousePressed

    private void cm_sendBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cm_sendBtnMousePressed
        try{
        if(on_off == false)
        {
        cm_error_msg.setText(null);
        String sql="Insert into messages (sent_all,msg_subject,msg_body) values(?,?,?)";
        pst=con.prepareStatement(sql);
        pst.setBoolean(1,true);
        pst.setString(2, cm_subject_txt.getText());
        pst.setString(3, cm_msgBody_txtArea.getText());
        pst.execute();
        
        messageSend();
        
        }
        
        else 
        {
            
                if(cm_guest_cbox.getItemCount()==0)
                {
                    cm_error_msg.setText("Please Select the Guest First !");
                
                }
                else{
                    cm_error_msg.setText(null);
                    String sql="Insert into messages (guest_id,msg_subject,msg_body) values(?,?,?)";
                pst=con.prepareStatement(sql);
                pst.setInt(1, (int) cm_guest_cbox.getSelectedItem());
                pst.setString(2, cm_subject_txt.getText());
                pst.setString(3, cm_msgBody_txtArea.getText());
                pst.execute();

                messageSend();
                

                }

        }
        
        
        
        }
        catch(Exception e){e.printStackTrace();}
        
        
    }//GEN-LAST:event_cm_sendBtnMousePressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
   
       Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
       this.setSize(d.width, d.height);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       bg_image.setSize(d.width,d.height);
        body_panel.setSize(d.width,d.height);

    }//GEN-LAST:event_formWindowActivated

    private void sm_refreshBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sm_refreshBtnMousePressed
    sm_refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/refresh3.png")));       
        try{
        
        String sql="Select * from messages";
        pst=con.prepareStatement(sql);
        rs=pst.executeQuery();
        
        sm_table.setModel(DbUtils.resultSetToTableModel(rs));
        setColumn(sm_table);
        
        
        }
        catch(Exception e){e.printStackTrace();}
        
        
        
    }//GEN-LAST:event_sm_refreshBtnMousePressed

    private void sm_deleteBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sm_deleteBtnMousePressed
        sm_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_3.png")));
        int row = sm_table.getSelectedRow();
       
        if(row ==-1){
        JOptionPane.showMessageDialog(this,"Please Select the Record you want to delete !");
        }
        else{
     int   msg_id= (int) sm_table.getModel().getValueAt(row, 0);
       String sql= "Delete from messages where message_id='"+msg_id+"'";
       int option=JOptionPane.showConfirmDialog(null,"Are You Sure You want to delete data");
       if(option==JOptionPane.YES_OPTION)
       {
       
       try{
       pst=con.prepareStatement(sql);
       
       pst.execute();
       
       new Thread(){
       
       public void run(){
       try{
       ac.jLabelYDown(-100, 10, 3 , 1, del_msg);
       Thread.sleep(3000);
       ac.jLabelYUp(10, -100, 3, 1, del_msg);
       }
       catch(Exception e){e.printStackTrace();}
       
       }
       
       
       }.start();
       
       
       
           
       }catch(Exception e){
       e.printStackTrace();
       }
       }
        } 
        
    }//GEN-LAST:event_sm_deleteBtnMousePressed

    private void sm_refreshBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sm_refreshBtnMouseEntered
   sm_refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/refresh2.png")));

    }//GEN-LAST:event_sm_refreshBtnMouseEntered

    private void sm_refreshBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sm_refreshBtnMouseExited
       sm_refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/refresh1.png")));
    }//GEN-LAST:event_sm_refreshBtnMouseExited

    private void sm_refreshBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sm_refreshBtnMouseReleased
    sm_refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/refresh2.png")));

    }//GEN-LAST:event_sm_refreshBtnMouseReleased

    private void sm_deleteBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sm_deleteBtnMouseReleased
    sm_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_2.png")));    
        
    }//GEN-LAST:event_sm_deleteBtnMouseReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      msg_tab.remove(cm_tab);
      msg_tab.remove(sm_tab);
    }//GEN-LAST:event_formWindowOpened

    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adm_label;
    private javax.swing.JLabel admin_label;
    private javax.swing.JLabel back_label;
    private javax.swing.JLabel bg_image;
    private javax.swing.JPanel body_panel;
    private javax.swing.JPanel btn_panel;
    private javax.swing.JPanel center_inner;
    private javax.swing.JPanel center_outer;
    private javax.swing.JLabel clock;
    private javax.swing.JLabel clock2;
    private javax.swing.JLabel close_label;
    private javax.swing.JLabel cm_bgImage;
    private javax.swing.JLabel cm_checkBtn;
    private javax.swing.JLabel cm_closeBtn;
    private javax.swing.JLabel cm_error_msg;
    private javax.swing.JPanel cm_form;
    private javax.swing.JComboBox cm_guest_cbox;
    private javax.swing.JLabel cm_label1;
    private javax.swing.JLabel cm_message_label;
    private javax.swing.JTextArea cm_msgBody_txtArea;
    private javax.swing.JScrollPane cm_scroll_pane;
    private javax.swing.JLabel cm_sendBtn;
    private javax.swing.JLabel cm_sent_all;
    private javax.swing.JLabel cm_subject_label;
    private javax.swing.JTextField cm_subject_txt;
    private javax.swing.JPanel cm_tab;
    private javax.swing.JLabel cm_to_label;
    private javax.swing.JLabel cm_txtLabel;
    private javax.swing.JLabel cm_txtLabel2;
    private javax.swing.JLabel create_msg;
    private javax.swing.JLabel day;
    private javax.swing.JLabel del_msg;
    private javax.swing.JPanel footer_panel;
    private javax.swing.JPanel header_panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel message_label;
    private javax.swing.JLabel mini_label;
    private javax.swing.JLabel month;
    private javax.swing.JTabbedPane msg_tab;
    private javax.swing.JLabel sent_msg;
    private javax.swing.JPanel side_btn;
    private javax.swing.JPanel side_panel;
    private javax.swing.JLabel sm_bgImg;
    private javax.swing.JLabel sm_closeBtn;
    private javax.swing.JLabel sm_deleteBtn;
    private javax.swing.JLabel sm_label1;
    private javax.swing.JScrollPane sm_pane;
    private javax.swing.JLabel sm_refreshBtn;
    private javax.swing.JPanel sm_tab;
    private javax.swing.JTable sm_table;
    private javax.swing.JLabel time_label;
    private javax.swing.JPanel time_panel;
    private javax.swing.JPanel useless_panel;
    private javax.swing.JLabel year;
    // End of variables declaration//GEN-END:variables
}
