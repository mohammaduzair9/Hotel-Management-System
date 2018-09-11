/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Fawad
 */
public class guest extends javax.swing.JFrame {

    boolean on_off=true;
    ResultSet rs =null;
    PreparedStatement pst=null;
    Connection con =null;
    int guest_id;
    int timerun =0;
    Calendar cal;
    //methods
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
   
    public guest() {
       
        initComponents();
        con=DatabaseManager.getconnect();
        Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(d.width, d.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bg_label.setSize(d.width,d.height);
        body_panel.setSize(d.width,d.height);
        guest_tab.removeAll();
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
        guest_list = new javax.swing.JLabel();
        modify_guest = new javax.swing.JLabel();
        search_guest = new javax.swing.JLabel();
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
        footer_panel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        center_outer = new javax.swing.JPanel();
        center_inner = new javax.swing.JPanel();
        guest_tab = new javax.swing.JTabbedPane();
        mg_tab = new javax.swing.JPanel();
        mg_form = new javax.swing.JPanel();
        mg_label2 = new javax.swing.JLabel();
        mg_label3 = new javax.swing.JLabel();
        mg_label6 = new javax.swing.JLabel();
        mg_label4 = new javax.swing.JLabel();
        mg_label10 = new javax.swing.JLabel();
        mg_guestId_txt = new javax.swing.JTextField();
        mg_fname_txt = new javax.swing.JTextField();
        mg_gender_cbox = new javax.swing.JComboBox();
        mg_contact_txt = new javax.swing.JTextField();
        mg_label9 = new javax.swing.JLabel();
        mg_label12 = new javax.swing.JLabel();
        mg_label8 = new javax.swing.JLabel();
        mg_nat_txt = new javax.swing.JTextField();
        mg_natId_txt = new javax.swing.JTextField();
        mg_lname_txt = new javax.swing.JTextField();
        mg_txtlabel2 = new javax.swing.JLabel();
        mg_txtlabel3 = new javax.swing.JLabel();
        mg_txtlabel1 = new javax.swing.JLabel();
        mg_txtlabel6 = new javax.swing.JLabel();
        mg_txtlabel5 = new javax.swing.JLabel();
        mg_txtlabel8 = new javax.swing.JLabel();
        mg_pane1 = new javax.swing.JScrollPane();
        mg_add_txt = new javax.swing.JTextArea();
        mg_updatBtn = new javax.swing.JLabel();
        mg_deleteBtn = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mg_tabel_panel = new javax.swing.JPanel();
        mg_tabel_pane = new javax.swing.JScrollPane();
        mg_tabel = new javax.swing.JTable();
        mg_closeBtn = new javax.swing.JLabel();
        mg_label1 = new javax.swing.JLabel();
        mg_bgImage = new javax.swing.JLabel();
        sg_tab = new javax.swing.JPanel();
        sg_closeBtn = new javax.swing.JLabel();
        sg_label1 = new javax.swing.JLabel();
        sg_pane = new javax.swing.JScrollPane();
        sg_tabel = new javax.swing.JTable();
        sg_searchBtn = new javax.swing.JLabel();
        sg_modifyBtn = new javax.swing.JLabel();
        sg_deleteBtn = new javax.swing.JLabel();
        sg_select_txt = new javax.swing.JTextField();
        sg_txtlabel = new javax.swing.JLabel();
        sg_select_cbox = new javax.swing.JComboBox();
        sg_recordsMsg = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sg_bgImage = new javax.swing.JLabel();
        gl_tab = new javax.swing.JPanel();
        gl_label1 = new javax.swing.JLabel();
        gl_pane = new javax.swing.JScrollPane();
        gl_tabel = new javax.swing.JTable();
        gl_closeBtn = new javax.swing.JLabel();
        gl_searchBtn = new javax.swing.JLabel();
        gl_recordsMsg = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        gl_bgImage = new javax.swing.JLabel();
        bg_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        body_panel.setOpaque(false);
        body_panel.setLayout(new java.awt.BorderLayout());

        side_panel.setOpaque(false);

        side_btn.setOpaque(false);

        guest_list.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/gl_1.jpg"))); // NOI18N
        guest_list.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guest_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guest_listMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                guest_listMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                guest_listMouseExited(evt);
            }
        });

        modify_guest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/mg_1.png"))); // NOI18N
        modify_guest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modify_guest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modify_guestMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                modify_guestMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                modify_guestMouseExited(evt);
            }
        });

        search_guest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/sg_1.jpg"))); // NOI18N
        search_guest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        search_guest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search_guestMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                search_guestMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                search_guestMouseExited(evt);
            }
        });

        javax.swing.GroupLayout side_btnLayout = new javax.swing.GroupLayout(side_btn);
        side_btn.setLayout(side_btnLayout);
        side_btnLayout.setHorizontalGroup(
            side_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(guest_list, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
            .addComponent(search_guest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(modify_guest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        side_btnLayout.setVerticalGroup(
            side_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_btnLayout.createSequentialGroup()
                .addComponent(guest_list)
                .addGap(28, 28, 28)
                .addComponent(modify_guest)
                .addGap(32, 32, 32)
                .addComponent(search_guest)
                .addContainerGap(26, Short.MAX_VALUE))
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
                .addContainerGap(237, Short.MAX_VALUE))
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

        guest_tab.setPreferredSize(new java.awt.Dimension(945, 600));

        mg_tab.setLayout(null);

        mg_form.setOpaque(false);
        mg_form.setLayout(null);

        mg_label2.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mg_label2.setText("Guest ID");
        mg_form.add(mg_label2);
        mg_label2.setBounds(200, 70, 120, 40);

        mg_label3.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mg_label3.setText("First Name ");
        mg_form.add(mg_label3);
        mg_label3.setBounds(200, 120, 110, 40);

        mg_label6.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mg_label6.setText("Gender");
        mg_form.add(mg_label6);
        mg_label6.setBounds(200, 30, 80, 30);

        mg_label4.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mg_label4.setText("Last Name");
        mg_form.add(mg_label4);
        mg_label4.setBounds(200, 170, 90, 40);

        mg_label10.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mg_label10.setText("Contact Num");
        mg_form.add(mg_label10);
        mg_label10.setBounds(500, 120, 103, 40);

        mg_guestId_txt.setBackground(new java.awt.Color(123, 211, 172));
        mg_guestId_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mg_guestId_txt.setBorder(null);
        mg_guestId_txt.setOpaque(false);
        mg_guestId_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        mg_form.add(mg_guestId_txt);
        mg_guestId_txt.setBounds(320, 80, 130, 23);

        mg_fname_txt.setBackground(new java.awt.Color(123, 211, 172));
        mg_fname_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mg_fname_txt.setBorder(null);
        mg_fname_txt.setOpaque(false);
        mg_fname_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        mg_form.add(mg_fname_txt);
        mg_fname_txt.setBounds(320, 130, 130, 23);

        mg_gender_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mg_gender_cbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        mg_form.add(mg_gender_cbox);
        mg_gender_cbox.setBounds(320, 30, 130, 25);

        mg_contact_txt.setBackground(new java.awt.Color(123, 211, 172));
        mg_contact_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mg_contact_txt.setBorder(null);
        mg_contact_txt.setOpaque(false);
        mg_contact_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        mg_form.add(mg_contact_txt);
        mg_contact_txt.setBounds(630, 130, 130, 23);

        mg_label9.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mg_label9.setText("Nationality");
        mg_form.add(mg_label9);
        mg_label9.setBounds(500, 70, 90, 40);

        mg_label12.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mg_label12.setText("National ID");
        mg_form.add(mg_label12);
        mg_label12.setBounds(500, 170, 86, 40);

        mg_label8.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mg_label8.setText("Address");
        mg_form.add(mg_label8);
        mg_label8.setBounds(200, 250, 60, 30);

        mg_nat_txt.setBackground(new java.awt.Color(123, 211, 172));
        mg_nat_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mg_nat_txt.setBorder(null);
        mg_nat_txt.setOpaque(false);
        mg_nat_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        mg_form.add(mg_nat_txt);
        mg_nat_txt.setBounds(630, 80, 130, 23);

        mg_natId_txt.setBackground(new java.awt.Color(123, 211, 172));
        mg_natId_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mg_natId_txt.setBorder(null);
        mg_natId_txt.setOpaque(false);
        mg_natId_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        mg_form.add(mg_natId_txt);
        mg_natId_txt.setBounds(630, 180, 130, 23);

        mg_lname_txt.setBackground(new java.awt.Color(123, 211, 172));
        mg_lname_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        mg_lname_txt.setBorder(null);
        mg_lname_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        mg_form.add(mg_lname_txt);
        mg_lname_txt.setBounds(320, 180, 130, 23);

        mg_txtlabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        mg_form.add(mg_txtlabel2);
        mg_txtlabel2.setBounds(310, 120, 150, 40);

        mg_txtlabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        mg_form.add(mg_txtlabel3);
        mg_txtlabel3.setBounds(310, 170, 150, 40);

        mg_txtlabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        mg_form.add(mg_txtlabel1);
        mg_txtlabel1.setBounds(310, 70, 150, 40);

        mg_txtlabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        mg_form.add(mg_txtlabel6);
        mg_txtlabel6.setBounds(620, 120, 150, 40);

        mg_txtlabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        mg_form.add(mg_txtlabel5);
        mg_txtlabel5.setBounds(620, 70, 150, 40);

        mg_txtlabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        mg_form.add(mg_txtlabel8);
        mg_txtlabel8.setBounds(620, 170, 150, 40);

        mg_add_txt.setColumns(20);
        mg_add_txt.setFont(new java.awt.Font("GardensC", 0, 14)); // NOI18N
        mg_add_txt.setRows(5);
        mg_pane1.setViewportView(mg_add_txt);

        mg_form.add(mg_pane1);
        mg_pane1.setBounds(310, 240, 460, 100);

        mg_updatBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/update1.png"))); // NOI18N
        mg_updatBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mg_updatBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mg_updatBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mg_updatBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mg_updatBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mg_updatBtnMousePressed(evt);
            }
        });
        mg_form.add(mg_updatBtn);
        mg_updatBtn.setBounds(250, 370, 100, 50);

        mg_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_1.png"))); // NOI18N
        mg_deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mg_deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mg_deleteBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mg_deleteBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mg_deleteBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mg_deleteBtnMousePressed(evt);
            }
        });
        mg_form.add(mg_deleteBtn);
        mg_deleteBtn.setBounds(360, 370, 100, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/rc_header.png"))); // NOI18N
        mg_form.add(jLabel3);
        jLabel3.setBounds(0, 374, 130, 50);

        mg_tab.add(mg_form);
        mg_form.setBounds(0, 50, 940, 420);

        mg_tabel_pane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        mg_tabel_pane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        mg_tabel.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        mg_tabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        mg_tabel.setFocusable(false);
        mg_tabel.setGridColor(new java.awt.Color(215, 215, 203));
        mg_tabel.setRowHeight(30);
        mg_tabel.setSelectionBackground(new java.awt.Color(3, 201, 169));
        mg_tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mg_tabelMouseClicked(evt);
            }
        });
        mg_tabel_pane.setViewportView(mg_tabel);

        javax.swing.GroupLayout mg_tabel_panelLayout = new javax.swing.GroupLayout(mg_tabel_panel);
        mg_tabel_panel.setLayout(mg_tabel_panelLayout);
        mg_tabel_panelLayout.setHorizontalGroup(
            mg_tabel_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mg_tabel_pane, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
        );
        mg_tabel_panelLayout.setVerticalGroup(
            mg_tabel_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mg_tabel_pane, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        );

        mg_tab.add(mg_tabel_panel);
        mg_tabel_panel.setBounds(0, 470, 940, 220);

        mg_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        mg_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mg_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mg_closeBtnMouseClicked(evt);
            }
        });
        mg_tab.add(mg_closeBtn);
        mg_closeBtn.setBounds(900, 0, 34, 31);

        mg_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        mg_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mg_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/mg_h.png"))); // NOI18N
        mg_tab.add(mg_label1);
        mg_label1.setBounds(0, 20, 200, 50);

        mg_bgImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        mg_tab.add(mg_bgImage);
        mg_bgImage.setBounds(0, 0, 940, 690);

        guest_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/mg_tab.png")), mg_tab); // NOI18N

        sg_tab.setLayout(null);

        sg_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        sg_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sg_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sg_closeBtnMouseClicked(evt);
            }
        });
        sg_tab.add(sg_closeBtn);
        sg_closeBtn.setBounds(903, 0, 30, 30);

        sg_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        sg_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/sb_header.png"))); // NOI18N
        sg_tab.add(sg_label1);
        sg_label1.setBounds(-6, 20, 210, 50);

        sg_pane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        sg_pane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        sg_tabel.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        sg_tabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        sg_tabel.setGridColor(new java.awt.Color(215, 215, 203));
        sg_tabel.setOpaque(false);
        sg_tabel.setRowHeight(30);
        sg_tabel.setSelectionBackground(new java.awt.Color(3, 201, 169));
        sg_tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sg_tabelMouseClicked(evt);
            }
        });
        sg_pane.setViewportView(sg_tabel);

        sg_tab.add(sg_pane);
        sg_pane.setBounds(0, 330, 940, 360);

        sg_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search.png"))); // NOI18N
        sg_searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sg_searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sg_searchBtnMouseClicked(evt);
            }
        });
        sg_tab.add(sg_searchBtn);
        sg_searchBtn.setBounds(760, 90, 150, 65);

        sg_modifyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/modify1.png"))); // NOI18N
        sg_modifyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sg_modifyBtn.setEnabled(false);
        sg_modifyBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sg_modifyBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sg_modifyBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sg_modifyBtnMouseExited(evt);
            }
        });
        sg_tab.add(sg_modifyBtn);
        sg_modifyBtn.setBounds(760, 160, 160, 65);

        sg_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/delete1.png"))); // NOI18N
        sg_deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sg_deleteBtn.setEnabled(false);
        sg_deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sg_deleteBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sg_deleteBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sg_deleteBtnMousePressed(evt);
            }
        });
        sg_tab.add(sg_deleteBtn);
        sg_deleteBtn.setBounds(760, 240, 150, 65);

        sg_select_txt.setBackground(new java.awt.Color(123, 211, 172));
        sg_select_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        sg_select_txt.setBorder(null);
        sg_select_txt.setOpaque(false);
        sg_select_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        sg_select_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sg_select_txtKeyReleased(evt);
            }
        });
        sg_tab.add(sg_select_txt);
        sg_select_txt.setBounds(500, 150, 130, 23);

        sg_txtlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        sg_tab.add(sg_txtlabel);
        sg_txtlabel.setBounds(490, 140, 150, 40);

        sg_select_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        sg_select_cbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "guest_id", "first_name", "last_name", "nationality", "nat_id", "gender" }));
        sg_tab.add(sg_select_cbox);
        sg_select_cbox.setBounds(320, 140, 120, 30);

        sg_recordsMsg.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        sg_recordsMsg.setForeground(new java.awt.Color(255, 0, 0));
        sg_tab.add(sg_recordsMsg);
        sg_recordsMsg.setBounds(180, 290, 220, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/rc_header.png"))); // NOI18N
        sg_tab.add(jLabel4);
        jLabel4.setBounds(0, 290, 130, 40);

        sg_bgImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        sg_tab.add(sg_bgImage);
        sg_bgImage.setBounds(0, 0, 940, 690);

        guest_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/sg_tab.png")), sg_tab); // NOI18N

        gl_tab.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        gl_tab.setLayout(null);

        gl_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        gl_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/ag_h.png"))); // NOI18N
        gl_label1.setToolTipText("");
        gl_tab.add(gl_label1);
        gl_label1.setBounds(0, 10, 150, 60);

        gl_pane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        gl_tabel.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        gl_tabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        gl_tabel.setGridColor(new java.awt.Color(215, 215, 203));
        gl_tabel.setOpaque(false);
        gl_tabel.setRowHeight(30);
        gl_tabel.setSelectionBackground(new java.awt.Color(3, 201, 169));
        gl_pane.setViewportView(gl_tabel);

        gl_tab.add(gl_pane);
        gl_pane.setBounds(0, 142, 940, 550);

        gl_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        gl_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gl_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gl_closeBtnMouseClicked(evt);
            }
        });
        gl_tab.add(gl_closeBtn);
        gl_closeBtn.setBounds(903, 0, 34, 31);

        gl_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search.png"))); // NOI18N
        gl_searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gl_searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gl_searchBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gl_searchBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                gl_searchBtnMousePressed(evt);
            }
        });
        gl_tab.add(gl_searchBtn);
        gl_searchBtn.setBounds(780, 70, 150, 65);

        gl_recordsMsg.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        gl_recordsMsg.setForeground(new java.awt.Color(255, 0, 0));
        gl_tab.add(gl_recordsMsg);
        gl_recordsMsg.setBounds(170, 100, 220, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/rc_header.png"))); // NOI18N
        gl_tab.add(jLabel2);
        jLabel2.setBounds(0, 100, 130, 40);

        gl_bgImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        gl_tab.add(gl_bgImage);
        gl_bgImage.setBounds(0, 0, 937, 692);

        guest_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/gl_tab.png")), gl_tab, ""); // NOI18N

        javax.swing.GroupLayout center_innerLayout = new javax.swing.GroupLayout(center_inner);
        center_inner.setLayout(center_innerLayout);
        center_innerLayout.setHorizontalGroup(
            center_innerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(guest_tab, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
        );
        center_innerLayout.setVerticalGroup(
            center_innerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(guest_tab, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
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

        getContentPane().add(body_panel);
        body_panel.setBounds(0, 0, 1280, 1030);

        bg_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/hm_bg.jpg"))); // NOI18N
        getContentPane().add(bg_label);
        bg_label.setBounds(0, 0, 1280, 1024);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guest_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guest_listMouseClicked
        guest_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/gl_tab.png")), gl_tab);
        guest_tab.setSelectedComponent(gl_tab);
    }//GEN-LAST:event_guest_listMouseClicked

    private void guest_listMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guest_listMouseEntered
        guest_list.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/gl_2.png")));
        guest_list.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_guest_listMouseEntered

    private void guest_listMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guest_listMouseExited
        guest_list.setBorder(null);
        guest_list.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/gl_1.jpg")));
    }//GEN-LAST:event_guest_listMouseExited

    private void modify_guestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modify_guestMouseClicked
        guest_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/mg_tab.png")),mg_tab);
        guest_tab.setSelectedComponent(mg_tab);
    }//GEN-LAST:event_modify_guestMouseClicked

    private void modify_guestMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modify_guestMouseEntered
        modify_guest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/mg_2.png")));
        modify_guest.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_modify_guestMouseEntered

    private void modify_guestMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modify_guestMouseExited
        modify_guest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/mg_1.png")));
        modify_guest.setBorder(null);
    }//GEN-LAST:event_modify_guestMouseExited

    private void search_guestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_guestMouseClicked
        guest_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/sg_tab.png")),sg_tab);
        guest_tab.setSelectedComponent(sg_tab);
    }//GEN-LAST:event_search_guestMouseClicked

    private void search_guestMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_guestMouseEntered
        search_guest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/sg_2.jpg")));
        search_guest.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_search_guestMouseEntered

    private void search_guestMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_guestMouseExited
        search_guest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/sg_1.jpg")));
        search_guest.setBorder(null);
    }//GEN-LAST:event_search_guestMouseExited

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

    private void mg_updatBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mg_updatBtnMouseClicked
        mg_updatBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/update3.png")));
    }//GEN-LAST:event_mg_updatBtnMouseClicked

    private void mg_updatBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mg_updatBtnMouseEntered
        mg_updatBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/update2.png")));
    }//GEN-LAST:event_mg_updatBtnMouseEntered

    private void mg_updatBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mg_updatBtnMouseExited
        mg_updatBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/update1.png")));
    }//GEN-LAST:event_mg_updatBtnMouseExited

    private void mg_updatBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mg_updatBtnMousePressed
        try{

            int id=Integer.parseInt(mg_guestId_txt.getText());
            String fname= mg_fname_txt.getText();
            String lname= mg_lname_txt.getText();
            String nat= mg_nat_txt.getText();
            int cnt= Integer.parseInt(mg_contact_txt.getText());
            int nat_id= Integer.parseInt(mg_natId_txt.getText());
            String gndr= mg_gender_cbox.getSelectedItem().toString();
            String add=mg_add_txt.getText();
                String sql= "update guests set guest_id='"+id+"',first_name='"+fname+"'  ,last_name='"+lname+"' ,nationality= '"+nat+"', contact= '"+cnt+"' , "
                + "nat_id= '"+nat_id+"',gender='"+gndr+"', address='"+add+"'  where guest_id='"+guest_id+"' ";

                pst=con.prepareStatement(sql);

                pst.execute();
                JOptionPane.showMessageDialog(this, "Succesfully Updated", "Message",JOptionPane.INFORMATION_MESSAGE );
                
            
          

            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,e );
        }

    }//GEN-LAST:event_mg_updatBtnMousePressed

    private void mg_deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mg_deleteBtnMouseClicked
        mg_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_3.png")));
    }//GEN-LAST:event_mg_deleteBtnMouseClicked

    private void mg_deleteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mg_deleteBtnMouseEntered
        mg_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_2.png")));
    }//GEN-LAST:event_mg_deleteBtnMouseEntered

    private void mg_deleteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mg_deleteBtnMouseExited
        mg_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_1.png")));
    }//GEN-LAST:event_mg_deleteBtnMouseExited

    private void mg_deleteBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mg_deleteBtnMousePressed
        String sql= "Delete from guests where guest_id='"+guest_id+"'";
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
    }//GEN-LAST:event_mg_deleteBtnMousePressed

    private void mg_tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mg_tabelMouseClicked
        try{

            String query="select * from guests where guest_id='"+guest_id+"'";
            PreparedStatement pstt=con.prepareStatement(query);
            ResultSet res=pstt.executeQuery();

            while(res.next())
            {

                mg_guestId_txt.setText(Integer.toString(res.getInt("guest_id")));
                mg_fname_txt.setText(res.getString("first_name"));
                mg_lname_txt.setText(res.getString("last_name"));
                mg_nat_txt.setText(res.getString("nationality"));
                mg_contact_txt.setText(res.getString("contact"));
                mg_natId_txt.setText(res.getString("nat_id"));
                mg_gender_cbox.setSelectedItem(res.getString("gender"));
                mg_add_txt.setText(res.getString("address"));
          
            }

        }

        catch(Exception e)
        {
            e.printStackTrace();
        }

    }//GEN-LAST:event_mg_tabelMouseClicked

    private void mg_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mg_closeBtnMouseClicked
        guest_tab.remove(mg_tab);
    }//GEN-LAST:event_mg_closeBtnMouseClicked

    private void sg_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sg_closeBtnMouseClicked
        guest_tab.remove(sg_tab);
    }//GEN-LAST:event_sg_closeBtnMouseClicked

    private void sg_tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sg_tabelMouseClicked
        int row =sg_tabel.getSelectedRow();

        if(sg_tabel.isRowSelected(row)==true)
        {
            sg_modifyBtn.setEnabled(true);
            sg_deleteBtn.setEnabled(true);
        }
        else
        {
            sg_modifyBtn.setEnabled(false);
            sg_deleteBtn.setEnabled(false);
        }

    }//GEN-LAST:event_sg_tabelMouseClicked

    private void sg_searchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sg_searchBtnMouseClicked

        if(on_off==true){
            sg_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search1.png")));
            on_off=false;
        }
        else
        {
            sg_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search.png")));
            on_off=true;
        }

    }//GEN-LAST:event_sg_searchBtnMouseClicked

    private void sg_modifyBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sg_modifyBtnMouseClicked
        if(sg_modifyBtn.isEnabled())
        {
            guest_tab.setSelectedComponent(mg_tab);
            int row = sg_tabel.getSelectedRow();
            guest_id= (int) sg_tabel.getModel().getValueAt(row, 0);

            try
            {

                String query="Select * from guests where guest_id='"+guest_id+"'";
                pst=con.prepareStatement(query);
                rs=pst.executeQuery();

                mg_tabel.setModel(DbUtils.resultSetToTableModel(rs));
                setColumn(mg_tabel);
                

            }
            catch(Exception e){
                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_sg_modifyBtnMouseClicked

    private void sg_modifyBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sg_modifyBtnMouseEntered
        sg_modifyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/modify2.png")));
    }//GEN-LAST:event_sg_modifyBtnMouseEntered

    private void sg_modifyBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sg_modifyBtnMouseExited
        sg_modifyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/modify1.png")));
    }//GEN-LAST:event_sg_modifyBtnMouseExited

    private void sg_deleteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sg_deleteBtnMouseEntered
        sg_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/delete2.png")));
    }//GEN-LAST:event_sg_deleteBtnMouseEntered

    private void sg_deleteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sg_deleteBtnMouseExited
        sg_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/delete1.png")));
    }//GEN-LAST:event_sg_deleteBtnMouseExited

    private void sg_deleteBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sg_deleteBtnMousePressed
        int row = sg_tabel.getSelectedRow();
        guest_id= (int) sg_tabel.getModel().getValueAt(row, 0);
        String sql= "Delete from guests where guest_id='"+guest_id+"'";
        int option=JOptionPane.showConfirmDialog(null,"Are You Sure You want to delete data");
        if(option==JOptionPane.YES_OPTION)
        {

            try{
                pst=con.prepareStatement(sql);

                pst.execute();

                JOptionPane.showMessageDialog(null,"Deleted Succesfully","Message",JOptionPane.INFORMATION_MESSAGE);
             
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_sg_deleteBtnMousePressed

    private void sg_select_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sg_select_txtKeyReleased

        if(on_off==false){
            try{
                
                
                int index=sg_select_cbox.getSelectedIndex();
                String Selection = sg_select_cbox.getSelectedItem().toString();
                String sql = "select * from guests where "+Selection+" =? ";
                pst= con.prepareStatement(sql);
                pst.setString(1,sg_select_txt.getText());
                rs= pst.executeQuery();
                sg_tabel.setModel(DbUtils.resultSetToTableModel(rs));
                setColumn(sg_tabel);
              
                //records Counting
                int rows= sg_tabel.getRowCount();

                if(rows>0)
                {
                    sg_recordsMsg.setForeground(new java.awt.Color(16, 109, 64));
                    sg_recordsMsg.setText("Records Found "+rows);
                }
                else
                {
                    sg_recordsMsg.setForeground(new java.awt.Color(255, 0, 0));
                    sg_recordsMsg.setText("No Records Found ");
                }

            }

            catch(Exception e)
            {

                e.printStackTrace();
            }
        }
        else{

            JOptionPane.showMessageDialog(this,"Searching is OFF" ,"Error", JOptionPane.WARNING_MESSAGE);

        }

    }//GEN-LAST:event_sg_select_txtKeyReleased

    private void gl_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gl_closeBtnMouseClicked
        guest_tab.remove(gl_tab);
    }//GEN-LAST:event_gl_closeBtnMouseClicked

    private void gl_searchBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gl_searchBtnMouseEntered
        gl_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search1.png")));
    }//GEN-LAST:event_gl_searchBtnMouseEntered

    private void gl_searchBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gl_searchBtnMouseExited
        gl_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search.png")));
    }//GEN-LAST:event_gl_searchBtnMouseExited

    private void gl_searchBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gl_searchBtnMousePressed

        String sql="Select * from guests";
        try
        {
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            gl_tabel.setModel(DbUtils.resultSetToTableModel(rs));
            setColumn(gl_tabel);
           

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        int rows= gl_tabel.getRowCount();

        if(rows>0)
        {
            gl_recordsMsg.setForeground(new java.awt.Color(16, 109, 64));
            gl_recordsMsg.setText("Records Found "+rows);
        }
        else
        {
            gl_recordsMsg.setForeground(new java.awt.Color(255, 0, 0));
            gl_recordsMsg.setText("No Records Found ");
        }

    }//GEN-LAST:event_gl_searchBtnMousePressed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adm_label;
    private javax.swing.JLabel admin_label;
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
    private javax.swing.JPanel footer_panel;
    private javax.swing.JLabel gl_bgImage;
    private javax.swing.JLabel gl_closeBtn;
    private javax.swing.JLabel gl_label1;
    private javax.swing.JScrollPane gl_pane;
    private javax.swing.JLabel gl_recordsMsg;
    private javax.swing.JLabel gl_searchBtn;
    private javax.swing.JPanel gl_tab;
    private javax.swing.JTable gl_tabel;
    private javax.swing.JLabel guest_list;
    private javax.swing.JTabbedPane guest_tab;
    private javax.swing.JPanel header_panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logout;
    private javax.swing.JTextArea mg_add_txt;
    private javax.swing.JLabel mg_bgImage;
    private javax.swing.JLabel mg_closeBtn;
    private javax.swing.JTextField mg_contact_txt;
    private javax.swing.JLabel mg_deleteBtn;
    private javax.swing.JTextField mg_fname_txt;
    private javax.swing.JPanel mg_form;
    private javax.swing.JComboBox mg_gender_cbox;
    private javax.swing.JTextField mg_guestId_txt;
    private javax.swing.JLabel mg_label1;
    private javax.swing.JLabel mg_label10;
    private javax.swing.JLabel mg_label12;
    private javax.swing.JLabel mg_label2;
    private javax.swing.JLabel mg_label3;
    private javax.swing.JLabel mg_label4;
    private javax.swing.JLabel mg_label6;
    private javax.swing.JLabel mg_label8;
    private javax.swing.JLabel mg_label9;
    private javax.swing.JTextField mg_lname_txt;
    private javax.swing.JTextField mg_natId_txt;
    private javax.swing.JTextField mg_nat_txt;
    private javax.swing.JScrollPane mg_pane1;
    private javax.swing.JPanel mg_tab;
    private javax.swing.JTable mg_tabel;
    private javax.swing.JScrollPane mg_tabel_pane;
    private javax.swing.JPanel mg_tabel_panel;
    private javax.swing.JLabel mg_txtlabel1;
    private javax.swing.JLabel mg_txtlabel2;
    private javax.swing.JLabel mg_txtlabel3;
    private javax.swing.JLabel mg_txtlabel5;
    private javax.swing.JLabel mg_txtlabel6;
    private javax.swing.JLabel mg_txtlabel8;
    private javax.swing.JLabel mg_updatBtn;
    private javax.swing.JLabel mini_label;
    private javax.swing.JLabel modify_guest;
    private javax.swing.JLabel month;
    private javax.swing.JLabel search_guest;
    private javax.swing.JLabel sg_bgImage;
    private javax.swing.JLabel sg_closeBtn;
    private javax.swing.JLabel sg_deleteBtn;
    private javax.swing.JLabel sg_label1;
    private javax.swing.JLabel sg_modifyBtn;
    private javax.swing.JScrollPane sg_pane;
    private javax.swing.JLabel sg_recordsMsg;
    private javax.swing.JLabel sg_searchBtn;
    private javax.swing.JComboBox sg_select_cbox;
    private javax.swing.JTextField sg_select_txt;
    private javax.swing.JPanel sg_tab;
    private javax.swing.JTable sg_tabel;
    private javax.swing.JLabel sg_txtlabel;
    private javax.swing.JPanel side_btn;
    private javax.swing.JPanel side_panel;
    private javax.swing.JLabel time_label;
    private javax.swing.JPanel time_panel;
    private javax.swing.JLabel year;
    // End of variables declaration//GEN-END:variables
}
