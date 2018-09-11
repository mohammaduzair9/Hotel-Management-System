/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;


import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;


/**
 *
 * @author Fawda
 */
public class food extends javax.swing.JFrame {

    //variables
    String fname;
    int timerun =0;
    String path;
    ResultSet rs =null;
    PreparedStatement pst=null;
    Connection con =null;
    
    //methods
     private void updateTable(String f_name,JTable tabel){
     try
     {   
    String sql="Select * from foods where food_name='"+f_name+"'";
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
     
     private void check_food(){
     int total=0;
     try
     {
     
     String sql="Select * from food_orders where status=0";
     pst=con.prepareStatement(sql);
     rs=pst.executeQuery();
     while(rs.next()){
     total++;
     }
     if(total > 0){
        food_not.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/not_label.png")));
        food_notNum_label.setText(Integer.toString(total));
        }
        else if(total<=0){
        
        food_notNum_label.setText("");
        food_not.setIcon(null);}
     

     }
     catch(Exception e){e.printStackTrace();}
     
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
    
    public food() {
       initComponents();
       Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
       this.setSize(d.width, d.height);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       bg_label.setSize(d.width,d.height);
       body_panel.setSize(d.width,d.height);
       food_tab.removeAll();    
       con=DatabaseManager.getconnect();
       check_food();
        
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
        add_food = new javax.swing.JLabel();
        modify_food = new javax.swing.JLabel();
        food_notNum_label = new javax.swing.JLabel();
        food_not = new javax.swing.JLabel();
        order_rec = new javax.swing.JLabel();
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
        center_outer = new javax.swing.JPanel();
        center_inner = new javax.swing.JPanel();
        food_tab = new javax.swing.JTabbedPane();
        mf_tab = new javax.swing.JPanel();
        mf_formPanel = new javax.swing.JPanel();
        mf_label2 = new javax.swing.JLabel();
        mf_label3 = new javax.swing.JLabel();
        mf_itemName_txt = new javax.swing.JTextField();
        mf_type_cbox = new javax.swing.JComboBox();
        mf_rate_txt = new javax.swing.JTextField();
        mf_inameL = new javax.swing.JLabel();
        mf_rateL = new javax.swing.JLabel();
        mf_imageFrame = new javax.swing.JPanel();
        mf_selectImg = new javax.swing.JLabel();
        mf_updateBtn = new javax.swing.JLabel();
        mf_deleteBtn = new javax.swing.JLabel();
        mf_searchBtn = new javax.swing.JLabel();
        mf_selectImgBtn = new javax.swing.JLabel();
        mf_label4 = new javax.swing.JLabel();
        mf_label1 = new javax.swing.JLabel();
        mf_label5 = new javax.swing.JLabel();
        mf_closeBtn = new javax.swing.JLabel();
        mf_pane = new javax.swing.JScrollPane();
        mf_tabel = new javax.swing.JTable();
        mf_bgImage = new javax.swing.JLabel();
        or_tab = new javax.swing.JPanel();
        or_closeBtn = new javax.swing.JLabel();
        or_form = new javax.swing.JPanel();
        or_confirmBtn = new javax.swing.JLabel();
        or_pane = new javax.swing.JScrollPane();
        or_orderTable = new javax.swing.JTable();
        or_label3 = new javax.swing.JLabel();
        or_label1 = new javax.swing.JLabel();
        or_viewOrderBtn = new javax.swing.JLabel();
        or_refreshBtn = new javax.swing.JLabel();
        or_DeleteBtn = new javax.swing.JLabel();
        or_label2 = new javax.swing.JLabel();
        or_pane1 = new javax.swing.JScrollPane();
        or_table = new javax.swing.JTable();
        or_bgImage = new javax.swing.JLabel();
        af_tab = new javax.swing.JPanel();
        af_closeBtn = new javax.swing.JLabel();
        af_foodPanel = new javax.swing.JPanel();
        af_label2 = new javax.swing.JLabel();
        af_label3 = new javax.swing.JLabel();
        af_itemName_txt = new javax.swing.JTextField();
        af_type_cbox = new javax.swing.JComboBox();
        af_rate_txt = new javax.swing.JTextField();
        af_inameL = new javax.swing.JLabel();
        af_rateL = new javax.swing.JLabel();
        af_imageFrame = new javax.swing.JPanel();
        af_selectImg = new javax.swing.JLabel();
        af_label4 = new javax.swing.JLabel();
        af_saveBtn = new javax.swing.JLabel();
        af_resetBtn = new javax.swing.JLabel();
        af_error1 = new javax.swing.JLabel();
        af_error3 = new javax.swing.JLabel();
        af_msg = new javax.swing.JLabel();
        af_selectImgBtn = new javax.swing.JLabel();
        af_label1 = new javax.swing.JLabel();
        af_bgImg = new javax.swing.JLabel();
        footer_panel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        bg_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        body_panel.setOpaque(false);
        body_panel.setLayout(new java.awt.BorderLayout());

        side_panel.setOpaque(false);

        side_btn.setOpaque(false);
        side_btn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add_food.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/add_food1.jpg"))); // NOI18N
        add_food.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add_food.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_foodMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add_foodMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                add_foodMouseExited(evt);
            }
        });
        side_btn.add(add_food, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 293, -1));

        modify_food.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/modify_food1.jpg"))); // NOI18N
        modify_food.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modify_food.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modify_foodMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                modify_foodMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                modify_foodMouseExited(evt);
            }
        });
        side_btn.add(modify_food, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 293, -1));

        food_notNum_label.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        food_notNum_label.setForeground(new java.awt.Color(255, 255, 255));
        food_notNum_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        side_btn.add(food_notNum_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 50, 50));

        food_not.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        side_btn.add(food_not, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, -1, -1));

        order_rec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/order_rec1.jpg"))); // NOI18N
        order_rec.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        order_rec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                order_recMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                order_recMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                order_recMouseExited(evt);
            }
        });
        side_btn.add(order_rec, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 304, 293, -1));

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
                .addComponent(side_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        body_panel.add(side_panel, java.awt.BorderLayout.LINE_START);

        header_panel.setMaximumSize(new java.awt.Dimension(1024, 165));
        header_panel.setMinimumSize(new java.awt.Dimension(1024, 165));
        header_panel.setOpaque(false);
        header_panel.setPreferredSize(new java.awt.Dimension(1280, 165));

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
                .addGroup(header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header_panelLayout.createSequentialGroup()
                        .addComponent(ar_refersh2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addContainerGap(65, Short.MAX_VALUE))
        );

        body_panel.add(header_panel, java.awt.BorderLayout.PAGE_START);

        center_outer.setOpaque(false);
        center_outer.setPreferredSize(new java.awt.Dimension(987, 750));

        center_inner.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        center_inner.setAutoscrolls(true);
        center_inner.setMaximumSize(new java.awt.Dimension(950, 730));
        center_inner.setMinimumSize(new java.awt.Dimension(950, 730));
        center_inner.setOpaque(false);
        center_inner.setPreferredSize(new java.awt.Dimension(950, 740));

        food_tab.setPreferredSize(new java.awt.Dimension(945, 600));

        mf_tab.setLayout(null);

        mf_formPanel.setOpaque(false);
        mf_formPanel.setLayout(null);

        mf_label2.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mf_label2.setText("Item Name");
        mf_formPanel.add(mf_label2);
        mf_label2.setBounds(230, 120, 120, 40);

        mf_label3.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mf_label3.setText("Type");
        mf_formPanel.add(mf_label3);
        mf_label3.setBounds(230, 170, 80, 30);

        mf_itemName_txt.setBackground(new java.awt.Color(123, 211, 172));
        mf_itemName_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mf_itemName_txt.setBorder(null);
        mf_itemName_txt.setOpaque(false);
        mf_itemName_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        mf_formPanel.add(mf_itemName_txt);
        mf_itemName_txt.setBounds(340, 130, 130, 23);

        mf_type_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mf_type_cbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Meat", "Chicken", "Chinese", "Desert", "Drink", "Sea Food", "Junk Food", "Snacks", "Other" }));
        mf_formPanel.add(mf_type_cbox);
        mf_type_cbox.setBounds(340, 170, 130, 25);

        mf_rate_txt.setBackground(new java.awt.Color(123, 211, 172));
        mf_rate_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mf_rate_txt.setBorder(null);
        mf_rate_txt.setOpaque(false);
        mf_rate_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        mf_rate_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mf_rate_txtKeyTyped(evt);
            }
        });
        mf_formPanel.add(mf_rate_txt);
        mf_rate_txt.setBounds(340, 220, 130, 23);

        mf_inameL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        mf_formPanel.add(mf_inameL);
        mf_inameL.setBounds(330, 120, 150, 40);

        mf_rateL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        mf_formPanel.add(mf_rateL);
        mf_rateL.setBounds(330, 210, 150, 40);

        mf_imageFrame.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        mf_imageFrame.setPreferredSize(new java.awt.Dimension(215, 215));

        mf_selectImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/food_image.png"))); // NOI18N
        mf_selectImg.setMaximumSize(new java.awt.Dimension(215, 215));

        javax.swing.GroupLayout mf_imageFrameLayout = new javax.swing.GroupLayout(mf_imageFrame);
        mf_imageFrame.setLayout(mf_imageFrameLayout);
        mf_imageFrameLayout.setHorizontalGroup(
            mf_imageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mf_selectImg, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );
        mf_imageFrameLayout.setVerticalGroup(
            mf_imageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mf_imageFrameLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mf_selectImg, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mf_formPanel.add(mf_imageFrame);
        mf_imageFrame.setBounds(560, 50, 210, 220);

        mf_updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/update1.png"))); // NOI18N
        mf_updateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mf_updateBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mf_updateBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mf_updateBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mf_updateBtnMousePressed(evt);
            }
        });
        mf_formPanel.add(mf_updateBtn);
        mf_updateBtn.setBounds(320, 320, 100, 50);

        mf_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_1.png"))); // NOI18N
        mf_deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mf_deleteBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mf_deleteBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mf_deleteBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mf_deleteBtnMousePressed(evt);
            }
        });
        mf_formPanel.add(mf_deleteBtn);
        mf_deleteBtn.setBounds(440, 320, 100, 50);

        mf_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/s_1.png"))); // NOI18N
        mf_searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mf_searchBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mf_searchBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mf_searchBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mf_searchBtnMousePressed(evt);
            }
        });
        mf_formPanel.add(mf_searchBtn);
        mf_searchBtn.setBounds(200, 320, 100, 50);

        mf_selectImgBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_1.png"))); // NOI18N
        mf_selectImgBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mf_selectImgBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mf_selectImgBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mf_selectImgBtnMouseExited(evt);
            }
        });
        mf_formPanel.add(mf_selectImgBtn);
        mf_selectImgBtn.setBounds(620, 280, 100, 50);

        mf_label4.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mf_label4.setText("Rate");
        mf_formPanel.add(mf_label4);
        mf_label4.setBounds(230, 210, 90, 40);

        mf_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        mf_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mf_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/mf_h.png"))); // NOI18N
        mf_formPanel.add(mf_label1);
        mf_label1.setBounds(0, 30, 210, 40);

        mf_label5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/rc_header.png"))); // NOI18N
        mf_formPanel.add(mf_label5);
        mf_label5.setBounds(0, 330, 130, 40);

        mf_tab.add(mf_formPanel);
        mf_formPanel.setBounds(0, 0, 940, 370);

        mf_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        mf_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mf_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mf_closeBtnMouseClicked(evt);
            }
        });
        mf_tab.add(mf_closeBtn);
        mf_closeBtn.setBounds(900, 0, 34, 31);

        mf_pane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        mf_tabel.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        mf_tabel.setRowHeight(30);
        mf_tabel.setSelectionBackground(new java.awt.Color(3, 201, 169));
        mf_tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mf_tabelMouseClicked(evt);
            }
        });
        mf_pane.setViewportView(mf_tabel);

        mf_tab.add(mf_pane);
        mf_pane.setBounds(0, 372, 940, 310);

        mf_bgImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        mf_tab.add(mf_bgImage);
        mf_bgImage.setBounds(0, 0, 940, 680);

        food_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/modifyfood_tab.jpg")), mf_tab); // NOI18N
        mf_tab.getAccessibleContext().setAccessibleParent(food_tab);

        or_tab.setLayout(null);

        or_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        or_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        or_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                or_closeBtnMouseClicked(evt);
            }
        });
        or_tab.add(or_closeBtn);
        or_closeBtn.setBounds(903, 0, 30, 30);

        or_form.setOpaque(false);
        or_form.setLayout(null);

        or_confirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/confirm1.png"))); // NOI18N
        or_confirmBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                or_confirmBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                or_confirmBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                or_confirmBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                or_confirmBtnMouseReleased(evt);
            }
        });
        or_form.add(or_confirmBtn);
        or_confirmBtn.setBounds(120, 290, 100, 60);

        or_pane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        or_orderTable.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        or_orderTable.setOpaque(false);
        or_orderTable.setRowHeight(25);
        or_orderTable.setSelectionBackground(new java.awt.Color(3, 201, 169));
        or_pane.setViewportView(or_orderTable);

        or_form.add(or_pane);
        or_pane.setBounds(30, 70, 290, 200);

        or_label3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/or_h.png"))); // NOI18N
        or_form.add(or_label3);
        or_label3.setBounds(30, 30, 100, 40);

        or_tab.add(or_form);
        or_form.setBounds(0, 100, 360, 580);

        or_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        or_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/orr_h.png"))); // NOI18N
        or_tab.add(or_label1);
        or_label1.setBounds(0, 30, 210, 40);

        or_viewOrderBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/view_order1.png"))); // NOI18N
        or_viewOrderBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        or_viewOrderBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                or_viewOrderBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                or_viewOrderBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                or_viewOrderBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                or_viewOrderBtnMousePressed(evt);
            }
        });
        or_tab.add(or_viewOrderBtn);
        or_viewOrderBtn.setBounds(640, 50, 100, 50);

        or_refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/refresh1.png"))); // NOI18N
        or_refreshBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        or_refreshBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                or_refreshBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                or_refreshBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                or_refreshBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                or_refreshBtnMouseReleased(evt);
            }
        });
        or_tab.add(or_refreshBtn);
        or_refreshBtn.setBounds(540, 50, 100, 50);

        or_DeleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_1.png"))); // NOI18N
        or_DeleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        or_DeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                or_DeleteBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                or_DeleteBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                or_DeleteBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                or_DeleteBtnMouseReleased(evt);
            }
        });
        or_tab.add(or_DeleteBtn);
        or_DeleteBtn.setBounds(740, 50, 100, 50);

        or_label2.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        or_label2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/rc_header.png"))); // NOI18N
        or_tab.add(or_label2);
        or_label2.setBounds(370, 60, 130, 40);

        or_pane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        or_table.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        or_table.setOpaque(false);
        or_table.setRowHeight(30);
        or_table.setSelectionBackground(new java.awt.Color(3, 201, 169));
        or_pane1.setViewportView(or_table);

        or_tab.add(or_pane1);
        or_pane1.setBounds(370, 100, 570, 580);

        or_bgImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        or_tab.add(or_bgImage);
        or_bgImage.setBounds(0, 0, 940, 690);

        food_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/order_tab.jpg")), or_tab); // NOI18N
        or_tab.getAccessibleContext().setAccessibleParent(food_tab);

        af_tab.setMaximumSize(new java.awt.Dimension(900, 600));
        af_tab.setOpaque(false);
        af_tab.setPreferredSize(new java.awt.Dimension(900, 600));
        af_tab.setLayout(null);

        af_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        af_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        af_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                af_closeBtnMouseClicked(evt);
            }
        });
        af_tab.add(af_closeBtn);
        af_closeBtn.setBounds(903, 0, 34, 31);

        af_foodPanel.setOpaque(false);
        af_foodPanel.setLayout(null);

        af_label2.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        af_label2.setText("Item Name");
        af_foodPanel.add(af_label2);
        af_label2.setBounds(170, 150, 120, 40);

        af_label3.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        af_label3.setText("Type");
        af_foodPanel.add(af_label3);
        af_label3.setBounds(170, 210, 80, 30);

        af_itemName_txt.setBackground(new java.awt.Color(123, 211, 172));
        af_itemName_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        af_itemName_txt.setBorder(null);
        af_itemName_txt.setOpaque(false);
        af_itemName_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        af_foodPanel.add(af_itemName_txt);
        af_itemName_txt.setBounds(280, 160, 130, 23);

        af_type_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        af_type_cbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Meat", "Chicken", "Chinese", "Desert", "Drink", "Sea Food", "Junk Food", "Snacks", "Other" }));
        af_foodPanel.add(af_type_cbox);
        af_type_cbox.setBounds(280, 210, 130, 25);

        af_rate_txt.setBackground(new java.awt.Color(123, 211, 172));
        af_rate_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        af_rate_txt.setBorder(null);
        af_rate_txt.setOpaque(false);
        af_rate_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        af_rate_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                af_rate_txtKeyTyped(evt);
            }
        });
        af_foodPanel.add(af_rate_txt);
        af_rate_txt.setBounds(280, 270, 130, 23);

        af_inameL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        af_foodPanel.add(af_inameL);
        af_inameL.setBounds(270, 150, 150, 40);

        af_rateL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        af_foodPanel.add(af_rateL);
        af_rateL.setBounds(270, 260, 150, 40);

        af_imageFrame.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        af_imageFrame.setPreferredSize(new java.awt.Dimension(215, 215));

        af_selectImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/food_image.png"))); // NOI18N
        af_selectImg.setMaximumSize(new java.awt.Dimension(215, 215));

        javax.swing.GroupLayout af_imageFrameLayout = new javax.swing.GroupLayout(af_imageFrame);
        af_imageFrame.setLayout(af_imageFrameLayout);
        af_imageFrameLayout.setHorizontalGroup(
            af_imageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(af_selectImg, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );
        af_imageFrameLayout.setVerticalGroup(
            af_imageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, af_imageFrameLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(af_selectImg, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        af_foodPanel.add(af_imageFrame);
        af_imageFrame.setBounds(500, 80, 210, 220);

        af_label4.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        af_label4.setText("Rate");
        af_foodPanel.add(af_label4);
        af_label4.setBounds(170, 260, 90, 40);

        af_saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save1.png"))); // NOI18N
        af_saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                af_saveBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                af_saveBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                af_saveBtnMousePressed(evt);
            }
        });
        af_foodPanel.add(af_saveBtn);
        af_saveBtn.setBounds(310, 440, 150, 65);

        af_resetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/reset_1.png"))); // NOI18N
        af_resetBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                af_resetBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                af_resetBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                af_resetBtnMouseExited(evt);
            }
        });
        af_foodPanel.add(af_resetBtn);
        af_resetBtn.setBounds(490, 440, 150, 65);
        af_foodPanel.add(af_error1);
        af_error1.setBounds(430, 150, 40, 40);
        af_foodPanel.add(af_error3);
        af_error3.setBounds(430, 260, 40, 40);
        af_foodPanel.add(af_msg);
        af_msg.setBounds(170, 340, 250, 70);

        af_selectImgBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_1.png"))); // NOI18N
        af_selectImgBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                af_selectImgBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                af_selectImgBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                af_selectImgBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                af_selectImgBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                af_selectImgBtnMouseReleased(evt);
            }
        });
        af_foodPanel.add(af_selectImgBtn);
        af_selectImgBtn.setBounds(550, 320, 100, 50);

        af_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        af_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        af_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/af_h.png"))); // NOI18N
        af_foodPanel.add(af_label1);
        af_label1.setBounds(0, 0, 210, 50);

        af_tab.add(af_foodPanel);
        af_foodPanel.setBounds(0, 20, 940, 630);

        af_bgImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        af_bgImg.setText("jLabel19");
        af_tab.add(af_bgImg);
        af_bgImg.setBounds(0, 0, 940, 690);

        food_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/addfood_tab.jpg")), af_tab); // NOI18N
        af_tab.getAccessibleContext().setAccessibleParent(food_tab);

        javax.swing.GroupLayout center_innerLayout = new javax.swing.GroupLayout(center_inner);
        center_inner.setLayout(center_innerLayout);
        center_innerLayout.setHorizontalGroup(
            center_innerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(food_tab, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
        );
        center_innerLayout.setVerticalGroup(
            center_innerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(food_tab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGroup(center_outerLayout.createSequentialGroup()
                    .addComponent(center_inner, javax.swing.GroupLayout.PREFERRED_SIZE, 729, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        body_panel.add(center_outer, java.awt.BorderLayout.CENTER);

        footer_panel.setOpaque(false);
        footer_panel.setLayout(new java.awt.BorderLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/logo1.png"))); // NOI18N
        footer_panel.add(logo, java.awt.BorderLayout.EAST);

        body_panel.add(footer_panel, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(body_panel);
        body_panel.setBounds(0, 0, 1280, 1030);

        bg_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/hm_bg.jpg"))); // NOI18N
        getContentPane().add(bg_label);
        bg_label.setBounds(0, 0, 1280, 1024);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add_foodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_foodMouseClicked
        food_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/addfood_tab.jpg")), af_tab);
        food_tab.setSelectedComponent(af_tab);
    }//GEN-LAST:event_add_foodMouseClicked

    private void add_foodMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_foodMouseEntered
        add_food.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/add_food2.jpg")));
        add_food.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_add_foodMouseEntered

    private void add_foodMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_foodMouseExited
        add_food.setBorder(null);
        add_food.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/add_food2.jpg")));
    }//GEN-LAST:event_add_foodMouseExited

    private void modify_foodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modify_foodMouseClicked
        food_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/modifyfood_tab.jpg")), mf_tab);
        food_tab.setSelectedComponent(mf_tab);
    }//GEN-LAST:event_modify_foodMouseClicked

    private void modify_foodMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modify_foodMouseEntered
        modify_food.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/modify_food2.jpg")));
        modify_food.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_modify_foodMouseEntered

    private void modify_foodMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modify_foodMouseExited
        modify_food.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/modify_food1.jpg")));
        modify_food.setBorder(null);
    }//GEN-LAST:event_modify_foodMouseExited

    private void order_recMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_order_recMouseClicked
      food_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/order_tab.jpg")),or_tab);
       food_tab.setSelectedComponent(or_tab);
    }//GEN-LAST:event_order_recMouseClicked

    private void order_recMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_order_recMouseEntered
        order_rec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/order_rec2.jpg")));
        order_rec.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_order_recMouseEntered

    private void order_recMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_order_recMouseExited
        order_rec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/order_rec1.jpg")));
        order_rec.setBorder(null);
    }//GEN-LAST:event_order_recMouseExited

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

    private void mf_updateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mf_updateBtnMouseClicked
        mf_updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/update3.png")));
    }//GEN-LAST:event_mf_updateBtnMouseClicked

    private void mf_updateBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mf_updateBtnMouseEntered
        mf_updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/update2.png")));
    }//GEN-LAST:event_mf_updateBtnMouseEntered

    private void mf_updateBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mf_updateBtnMouseExited
        mf_updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/update1.png")));
    }//GEN-LAST:event_mf_updateBtnMouseExited

    private void mf_deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mf_deleteBtnMouseClicked
       mf_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_3.png")));
    }//GEN-LAST:event_mf_deleteBtnMouseClicked

    private void mf_deleteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mf_deleteBtnMouseEntered
        mf_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_2.png")));
    }//GEN-LAST:event_mf_deleteBtnMouseEntered

    private void mf_deleteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mf_deleteBtnMouseExited
        mf_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_1.png")));
    }//GEN-LAST:event_mf_deleteBtnMouseExited

    private void mf_searchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mf_searchBtnMouseClicked
        mf_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/s_3.png")));
    }//GEN-LAST:event_mf_searchBtnMouseClicked

    private void mf_searchBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mf_searchBtnMouseEntered
        mf_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/s_2.png")));
    }//GEN-LAST:event_mf_searchBtnMouseEntered

    private void mf_searchBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mf_searchBtnMouseExited
        mf_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/s_1.png")));
    }//GEN-LAST:event_mf_searchBtnMouseExited

    private void mf_selectImgBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mf_selectImgBtnMouseClicked
        mf_selectImgBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_3.png")));
        int a=jFileChooser1.showOpenDialog(this);
        if(a==JFileChooser.APPROVE_OPTION){
            File f= jFileChooser1.getSelectedFile();
            path=f.getPath();
            mf_selectImg.setIcon(new ImageIcon(""+f));}
    }//GEN-LAST:event_mf_selectImgBtnMouseClicked

    private void mf_selectImgBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mf_selectImgBtnMouseEntered
        mf_selectImgBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_2.png")));
    }//GEN-LAST:event_mf_selectImgBtnMouseEntered

    private void mf_selectImgBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mf_selectImgBtnMouseExited
        mf_selectImgBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_1.png")));
    }//GEN-LAST:event_mf_selectImgBtnMouseExited

    private void mf_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mf_closeBtnMouseClicked
        food_tab.remove(mf_tab);
    }//GEN-LAST:event_mf_closeBtnMouseClicked

    private void or_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_or_closeBtnMouseClicked
        food_tab.remove(or_tab);
    }//GEN-LAST:event_or_closeBtnMouseClicked

    private void af_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_af_closeBtnMouseClicked
        food_tab.remove(af_tab);
    }//GEN-LAST:event_af_closeBtnMouseClicked

    private void af_saveBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_af_saveBtnMouseEntered
    af_saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save2.png")));
       
    }//GEN-LAST:event_af_saveBtnMouseEntered

    private void af_saveBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_af_saveBtnMouseExited
    af_saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save1.png")));

    }//GEN-LAST:event_af_saveBtnMouseExited

    private void af_resetBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_af_resetBtnMouseEntered
        af_resetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/reset_2.png")));

    }//GEN-LAST:event_af_resetBtnMouseEntered

    private void af_resetBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_af_resetBtnMouseExited
        af_resetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/reset_1.png")));

    }//GEN-LAST:event_af_resetBtnMouseExited

    private void af_resetBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_af_resetBtnMouseClicked
        af_itemName_txt.setText("");
        af_type_cbox.setSelectedIndex(0);       
        af_rate_txt.setText("");
        af_selectImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/food_image.png")));
        af_error1.setIcon(null);
        
        af_error3.setIcon(null);
        af_msg.setIcon(null);

    }//GEN-LAST:event_af_resetBtnMouseClicked

    private void or_viewOrderBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_or_viewOrderBtnMouseClicked
       or_viewOrderBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/view_order3.png")));
    }//GEN-LAST:event_or_viewOrderBtnMouseClicked

    private void or_viewOrderBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_or_viewOrderBtnMouseEntered
        or_viewOrderBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/view_order2.png")));

    }//GEN-LAST:event_or_viewOrderBtnMouseEntered

    private void or_viewOrderBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_or_viewOrderBtnMouseExited
        or_viewOrderBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/view_order1.png")));
    }//GEN-LAST:event_or_viewOrderBtnMouseExited

    private void af_selectImgBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_af_selectImgBtnMouseClicked
        af_selectImgBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_3.png")));
        int a=jFileChooser1.showOpenDialog(this);
        if(a==JFileChooser.APPROVE_OPTION){
            File f= jFileChooser1.getSelectedFile();
            path=f.getPath();
            af_selectImg.setIcon(new ImageIcon(""+f));}
    }//GEN-LAST:event_af_selectImgBtnMouseClicked

    private void af_selectImgBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_af_selectImgBtnMouseEntered
af_selectImgBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_2.png"))); 
        
    }//GEN-LAST:event_af_selectImgBtnMouseEntered

    private void af_selectImgBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_af_selectImgBtnMouseExited
af_selectImgBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_1.png")));  

    }//GEN-LAST:event_af_selectImgBtnMouseExited

    private void af_saveBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_af_saveBtnMousePressed
        
        af_error1.setIcon(null);
        
        af_error3.setIcon(null);
        
        
       
        if("".equals(af_itemName_txt.getText()))
        {
        af_error1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/errorIcon.png")));
        af_msg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/error_msg.png"))); 
        Toolkit.getDefaultToolkit().beep();
        
        }
        
        
        else  if("".equals(af_rate_txt.getText()))
        {
        af_error3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/errorIcon.png")));
        af_msg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/error_msg.png")));   
        Toolkit.getDefaultToolkit().beep();

        }
        else {
        af_error1.setIcon(null);
       
        af_error3.setIcon(null);
                
        
        
        
        
        try{
          
       String sql = "Insert into foods (food_name,food_type,rate,food_image) values (?,?,?,?)"; 
          
          pst=con.prepareStatement(sql);
          pst.setString(1, af_itemName_txt.getText());
          pst.setString(2, af_type_cbox.getSelectedItem().toString());
          pst.setInt(3, Integer.parseInt(af_rate_txt.getText()));
          pst.setString(4, path);
          
          pst.execute();
          
          af_msg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save_msg.png")));
      }
      catch(Exception e){
     JOptionPane.showMessageDialog(this, e);
      
      
      }
        }
    }//GEN-LAST:event_af_saveBtnMousePressed

    private void mf_searchBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mf_searchBtnMousePressed
        
        try{
        
        String sql="Select * from foods order by food_type";
        pst=con.prepareStatement(sql);
        rs=pst.executeQuery();
        
        mf_tabel.setModel(DbUtils.resultSetToTableModel(rs));
        setColumn(mf_tabel);
        if(mf_tabel.getRowCount()==0){JOptionPane.showMessageDialog(this,"Sorry No Record Found !");}
        
        
        }
        catch(Exception e){ e.printStackTrace();}
        

    }//GEN-LAST:event_mf_searchBtnMousePressed

    private void mf_tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mf_tabelMouseClicked
     
       int row = mf_tabel.getSelectedRow();
       fname=  mf_tabel.getModel().getValueAt(row, 0).toString();
       
       try
       {
       
       String query="Select * from foods where food_name='"+fname+"'";
       pst=con.prepareStatement(query);
       rs=pst.executeQuery();
       
       while(rs.next())
       {
       
       mf_itemName_txt.setText(rs.getString("food_name"));
       mf_type_cbox.setSelectedItem(rs.getString("food_type"));
       mf_rate_txt.setText(rs.getString("rate"));
       String image_url= rs.getString("food_image");
       ImageIcon image = new ImageIcon(image_url);
       mf_selectImg.setIcon(image);

       }
       
       }
       catch(Exception e){
       e.printStackTrace();
       }




    }//GEN-LAST:event_mf_tabelMouseClicked

    private void mf_updateBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mf_updateBtnMousePressed
     
        
     try{
     if(path==null){
     String sql="Update foods set food_name= ? ,food_type= ? , rate= ? where food_name = '"+fname+"' ";
     pst=con.prepareStatement(sql);
     pst.setString(1, mf_itemName_txt.getText());
     pst.setString(2, mf_type_cbox.getSelectedItem().toString());
     pst.setInt(3, Integer.parseInt(mf_rate_txt.getText()));
     pst.execute();
     JOptionPane.showMessageDialog(this, "Succesfully Updated", "Message",JOptionPane.INFORMATION_MESSAGE );
     updateTable(mf_itemName_txt.getText(), mf_tabel);
     }
     else{
     String sql1="Update foods set food_name= ? ,food_type= ? , rate= ?, food_image= ?  where food_name = '"+fname+"' ";
     pst=con.prepareStatement(sql1);
     pst.setString(1, mf_itemName_txt.getText());
     pst.setString(2, mf_type_cbox.getSelectedItem().toString());
     pst.setInt(3, Integer.parseInt(mf_rate_txt.getText()));
     pst.setString(4,path);
     
     pst.execute();
     JOptionPane.showMessageDialog(this, "Succesfully Updated", "Message",JOptionPane.INFORMATION_MESSAGE );
     updateTable(mf_itemName_txt.getText(), mf_tabel);
     }
     }
     catch(Exception e){
     JOptionPane.showMessageDialog(this,e );
     
     }
        
        
    }//GEN-LAST:event_mf_updateBtnMousePressed

    private void mf_deleteBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mf_deleteBtnMousePressed
       
        int row = mf_tabel.getSelectedRow();
        if(row ==-1){
        JOptionPane.showMessageDialog(this,"Please Select the Record you want to delete !");
        }
        else{
       String fname=  mf_tabel.getModel().getValueAt(row, 0).toString();
       String sql= "Delete from foods where food_name='"+fname+"'";
       int option=JOptionPane.showConfirmDialog(null,"Are You Sure You want to delete data");
       if(option==JOptionPane.YES_OPTION)
       {
       
       try{
       pst=con.prepareStatement(sql);
       
       pst.execute();
       
       JOptionPane.showMessageDialog(null,"Deleted Succesfully","Message",JOptionPane.INFORMATION_MESSAGE);
       updateTable(fname,mf_tabel);
       
           
       }
       catch(Exception e){
       e.printStackTrace();
       }
       }
       }
    }//GEN-LAST:event_mf_deleteBtnMousePressed

    private void af_rate_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_af_rate_txtKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE ))
        {
        getToolkit().beep();
        evt.consume();
        }


    }//GEN-LAST:event_af_rate_txtKeyTyped

    private void mf_rate_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mf_rate_txtKeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE ))
        {
        getToolkit().beep();
        evt.consume();
        }



    }//GEN-LAST:event_mf_rate_txtKeyTyped

    private void or_refreshBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_or_refreshBtnMousePressed
        or_refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/refresh3.png"))); 
    
        try{
        
        
        String sql="Select * from food_orders where status =0";
        pst=con.prepareStatement(sql);
        rs=pst.executeQuery();
        or_table.setModel(DbUtils.resultSetToTableModel(rs));
        setColumn(or_table);
        
        
        }
        catch(Exception e){e.printStackTrace();}
        
    }//GEN-LAST:event_or_refreshBtnMousePressed

   
    private void or_viewOrderBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_or_viewOrderBtnMousePressed
       
        try
        {
          
            
        int row=or_table.getSelectedRow();
        int order_id=(int) or_table.getValueAt(row, 0);
        
        String sql="Select * from food_orders where  order_id="+order_id+" ";
        pst=con.prepareStatement(sql);
        rs=pst.executeQuery();
        String orders = null;
        while(rs.next()){
        orders=rs.getString("orders");
        }
        //Seprating String after "," and storing in to array
       String[] items =orders.split(",");
       ArrayList<String> list= new ArrayList();
       //transfering values from array to ArrayList
       for(int i=0;i<items.length;i++)
       { list.add(i, items[i]);}
            
        DefaultTableModel model= new DefaultTableModel();
        model.addColumn("Order Item");
        model.addColumn("Quantity");
       
       
        Set alSet=new HashSet<String>(list); // no duplicates allowed in set, we get uniques
        for(Object element:alSet)  
        {
        int count=Collections.frequency(list,element); // this method counts the occurrences
        model.addRow(new Object[]{element,count});//adding the values in to table
        }
        or_orderTable.setModel(model);
        
        
        }
        catch(Exception e){e.printStackTrace();}

    }//GEN-LAST:event_or_viewOrderBtnMousePressed

    private void or_DeleteBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_or_DeleteBtnMousePressed
    or_DeleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_3.png"))); // NOI18N

        int row = or_table.getSelectedRow();
        if(row ==-1){
        JOptionPane.showMessageDialog(this,"Please Select the Record you want to delete !");
        }
        else{
       int id=  (int) or_table.getModel().getValueAt(row, 0);
       String sql= "Delete from food_orders where order_id='"+id+"'";
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
    }//GEN-LAST:event_or_DeleteBtnMousePressed

    private void ar_refersh2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ar_refersh2MousePressed
      check_food();
    }//GEN-LAST:event_ar_refersh2MousePressed

    private void or_refreshBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_or_refreshBtnMouseEntered
     or_refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/refresh2.png"))); 

        
    }//GEN-LAST:event_or_refreshBtnMouseEntered

    private void or_refreshBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_or_refreshBtnMouseExited
    or_refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/refresh1.png"))); 
    }//GEN-LAST:event_or_refreshBtnMouseExited

    private void or_refreshBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_or_refreshBtnMouseReleased
    or_refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/refresh2.png"))); 
    }//GEN-LAST:event_or_refreshBtnMouseReleased

    private void or_DeleteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_or_DeleteBtnMouseEntered
    or_DeleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_2.png"))); 
    }//GEN-LAST:event_or_DeleteBtnMouseEntered

    private void or_DeleteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_or_DeleteBtnMouseExited
    or_DeleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_1.png"))); 

    }//GEN-LAST:event_or_DeleteBtnMouseExited

    private void or_DeleteBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_or_DeleteBtnMouseReleased
or_DeleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_2.png")));

    }//GEN-LAST:event_or_DeleteBtnMouseReleased

    private void or_confirmBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_or_confirmBtnMousePressed
    or_confirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/confirm3.png")));

    try{
    int row = or_table.getSelectedRow();
    int id=  (int) or_table.getModel().getValueAt(row, 0);
    String sql="Update food_orders set status=1 where order_id= "+id+"";
    pst=con.prepareStatement(sql);
    pst.execute();
    check_food();
    JOptionPane.showMessageDialog(this,"Succesfully Authorised !");
    
    }
    catch(Exception e){e.printStackTrace();}


    }//GEN-LAST:event_or_confirmBtnMousePressed

    private void or_confirmBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_or_confirmBtnMouseEntered
or_confirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/confirm2.png"))); 

    }//GEN-LAST:event_or_confirmBtnMouseEntered

    private void or_confirmBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_or_confirmBtnMouseExited
or_confirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/confirm1.png"))); 

    }//GEN-LAST:event_or_confirmBtnMouseExited

    private void or_confirmBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_or_confirmBtnMouseReleased
or_confirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/confirm2.png"))); 

    }//GEN-LAST:event_or_confirmBtnMouseReleased

    private void af_selectImgBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_af_selectImgBtnMousePressed
af_selectImgBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_3.png"))); 

    }//GEN-LAST:event_af_selectImgBtnMousePressed

    private void af_selectImgBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_af_selectImgBtnMouseReleased
af_selectImgBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_2.png"))); 

    }//GEN-LAST:event_af_selectImgBtnMouseReleased

  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel add_food;
    private javax.swing.JLabel adm_label;
    private javax.swing.JLabel admin_label;
    private javax.swing.JLabel af_bgImg;
    private javax.swing.JLabel af_closeBtn;
    private javax.swing.JLabel af_error1;
    private javax.swing.JLabel af_error3;
    private javax.swing.JPanel af_foodPanel;
    private javax.swing.JPanel af_imageFrame;
    private javax.swing.JLabel af_inameL;
    private javax.swing.JTextField af_itemName_txt;
    private javax.swing.JLabel af_label1;
    private javax.swing.JLabel af_label2;
    private javax.swing.JLabel af_label3;
    private javax.swing.JLabel af_label4;
    private javax.swing.JLabel af_msg;
    private javax.swing.JLabel af_rateL;
    private javax.swing.JTextField af_rate_txt;
    private javax.swing.JLabel af_resetBtn;
    private javax.swing.JLabel af_saveBtn;
    private javax.swing.JLabel af_selectImg;
    private javax.swing.JLabel af_selectImgBtn;
    private javax.swing.JPanel af_tab;
    private javax.swing.JComboBox af_type_cbox;
    private javax.swing.JLabel ar_refersh2;
    private javax.swing.JLabel back_label;
    private javax.swing.JLabel bg_label;
    private javax.swing.JPanel body_panel;
    private javax.swing.JPanel btn_panel;
    private javax.swing.JPanel center_inner;
    private javax.swing.JPanel center_outer;
    private javax.swing.JLabel clock;
    private javax.swing.JLabel clock2;
    private javax.swing.JLabel close_label;
    private javax.swing.JLabel day;
    private javax.swing.JLabel food_not;
    private javax.swing.JLabel food_notNum_label;
    private javax.swing.JTabbedPane food_tab;
    private javax.swing.JPanel footer_panel;
    private javax.swing.JPanel header_panel;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel mf_bgImage;
    private javax.swing.JLabel mf_closeBtn;
    private javax.swing.JLabel mf_deleteBtn;
    private javax.swing.JPanel mf_formPanel;
    private javax.swing.JPanel mf_imageFrame;
    private javax.swing.JLabel mf_inameL;
    private javax.swing.JTextField mf_itemName_txt;
    private javax.swing.JLabel mf_label1;
    private javax.swing.JLabel mf_label2;
    private javax.swing.JLabel mf_label3;
    private javax.swing.JLabel mf_label4;
    private javax.swing.JLabel mf_label5;
    private javax.swing.JScrollPane mf_pane;
    private javax.swing.JLabel mf_rateL;
    private javax.swing.JTextField mf_rate_txt;
    private javax.swing.JLabel mf_searchBtn;
    private javax.swing.JLabel mf_selectImg;
    private javax.swing.JLabel mf_selectImgBtn;
    private javax.swing.JPanel mf_tab;
    private javax.swing.JTable mf_tabel;
    private javax.swing.JComboBox mf_type_cbox;
    private javax.swing.JLabel mf_updateBtn;
    private javax.swing.JLabel mini_label;
    private javax.swing.JLabel modify_food;
    private javax.swing.JLabel month;
    private javax.swing.JLabel or_DeleteBtn;
    private javax.swing.JLabel or_bgImage;
    private javax.swing.JLabel or_closeBtn;
    private javax.swing.JLabel or_confirmBtn;
    private javax.swing.JPanel or_form;
    private javax.swing.JLabel or_label1;
    private javax.swing.JLabel or_label2;
    private javax.swing.JLabel or_label3;
    private javax.swing.JTable or_orderTable;
    private javax.swing.JScrollPane or_pane;
    private javax.swing.JScrollPane or_pane1;
    private javax.swing.JLabel or_refreshBtn;
    private javax.swing.JPanel or_tab;
    private javax.swing.JTable or_table;
    private javax.swing.JLabel or_viewOrderBtn;
    private javax.swing.JLabel order_rec;
    private javax.swing.JPanel side_btn;
    private javax.swing.JPanel side_panel;
    private javax.swing.JLabel time_label;
    private javax.swing.JPanel time_panel;
    private javax.swing.JLabel year;
    // End of variables declaration//GEN-END:variables
}
