
package admin;



import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.*;
import java.util.Calendar;
import net.proteanit.sql.DbUtils;
import javax.swing.table.*;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;




public class employee extends javax.swing.JFrame {

    Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
    int timerun =0;
    ResultSet rs =null;
    PreparedStatement pst=null;
    Connection con =null;
    DefaultTableModel model;
    DatabaseManager dm;
    String path;
    Calendar cal;
    boolean on_off = true;
    String se_query;
    int emp_id;
    // methods
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
    
  
    
    
    
            
    
    
    public employee()  {
        
        initComponents();
        con=DatabaseManager.getconnect();
        Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(d.width, d.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         bg_image.setSize(d.width,d.height);
         body_panel.setSize(d.width,d.height);
         emp_tab.removeAll();
       
        
        
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

        jFileChooser1 = new javax.swing.JFileChooser();
        body_panel = new javax.swing.JPanel();
        side_panel = new javax.swing.JPanel();
        side_btn = new javax.swing.JPanel();
        emp_list = new javax.swing.JLabel();
        add_emp = new javax.swing.JLabel();
        modify_emp = new javax.swing.JLabel();
        search_emp = new javax.swing.JLabel();
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
        emp_tab = new javax.swing.JTabbedPane();
        modify_tab = new javax.swing.JPanel();
        me_label1 = new javax.swing.JLabel();
        me_form = new javax.swing.JPanel();
        me_label2 = new javax.swing.JLabel();
        me_label3 = new javax.swing.JLabel();
        me_label6 = new javax.swing.JLabel();
        me_label4 = new javax.swing.JLabel();
        me_label7 = new javax.swing.JLabel();
        me_label13 = new javax.swing.JLabel();
        me_label5 = new javax.swing.JLabel();
        me_label10 = new javax.swing.JLabel();
        me_empId_txt = new javax.swing.JTextField();
        me_fname_txt = new javax.swing.JTextField();
        me_gender_cbox = new javax.swing.JComboBox();
        me_salary_txt = new javax.swing.JTextField();
        me_contact_txt = new javax.swing.JTextField();
        me_desig_cbox = new javax.swing.JComboBox();
        me_label9 = new javax.swing.JLabel();
        me_label12 = new javax.swing.JLabel();
        me_label11 = new javax.swing.JLabel();
        me_label14 = new javax.swing.JLabel();
        me_label8 = new javax.swing.JLabel();
        me_nat_txt = new javax.swing.JTextField();
        me_natId_txt = new javax.swing.JTextField();
        me_lname_txt = new javax.swing.JTextField();
        me_relgn_txt = new javax.swing.JTextField();
        me_txtlabel2 = new javax.swing.JLabel();
        me_txtlabel3 = new javax.swing.JLabel();
        me_txtlabel1 = new javax.swing.JLabel();
        me_txtlabel4 = new javax.swing.JLabel();
        me_txtlabel6 = new javax.swing.JLabel();
        me_txtlabel5 = new javax.swing.JLabel();
        me_txtlabel8 = new javax.swing.JLabel();
        me_txtlabel7 = new javax.swing.JLabel();
        me_pane1 = new javax.swing.JScrollPane();
        me_add_txt = new javax.swing.JTextArea();
        me_imageFrame = new javax.swing.JPanel();
        me_selectImage = new javax.swing.JLabel();
        me_updatBtn = new javax.swing.JLabel();
        me_deleteBtn = new javax.swing.JLabel();
        me_selectBtn = new javax.swing.JLabel();
        me_join_date = new javax.swing.JTextField();
        me_txtlabel9 = new javax.swing.JLabel();
        me_dob_date = new javax.swing.JTextField();
        me_txtlabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        me_tabel_panel = new javax.swing.JPanel();
        me_tabel_pane = new javax.swing.JScrollPane();
        me_tabel = new javax.swing.JTable();
        me_closeBtn = new javax.swing.JLabel();
        me_bgImage = new javax.swing.JLabel();
        search_tab = new javax.swing.JPanel();
        se_closeBtn = new javax.swing.JLabel();
        se_label1 = new javax.swing.JLabel();
        se_searchBtn = new javax.swing.JLabel();
        se_modifyBtn = new javax.swing.JLabel();
        se_deleteBtn = new javax.swing.JLabel();
        se_select_txt = new javax.swing.JTextField();
        se_txtlabel1 = new javax.swing.JLabel();
        se_select_cbox = new javax.swing.JComboBox();
        se_recordsMsg = new javax.swing.JLabel();
        se_pane = new javax.swing.JScrollPane();
        se_tabel = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        se_bgImage = new javax.swing.JLabel();
        ae_tab = new javax.swing.JPanel();
        ae_imageFrame = new javax.swing.JPanel();
        ae_selectImage = new javax.swing.JLabel();
        ae_form = new javax.swing.JPanel();
        ae_sep = new javax.swing.JSeparator();
        ae_label2 = new javax.swing.JLabel();
        ae_label3 = new javax.swing.JLabel();
        ae_label4 = new javax.swing.JLabel();
        ae_label7 = new javax.swing.JLabel();
        ae_label8 = new javax.swing.JLabel();
        ae_label6 = new javax.swing.JLabel();
        ae_label5 = new javax.swing.JLabel();
        ae_label9 = new javax.swing.JLabel();
        ae_empid_txt = new javax.swing.JTextField();
        ae_fname_txt = new javax.swing.JTextField();
        ae_gender_cbox = new javax.swing.JComboBox();
        ae_join_date = new com.toedter.calendar.JDateChooser();
        ae_salary_txt = new javax.swing.JTextField();
        ae_contact_txt = new javax.swing.JTextField();
        ae_desg_cbox = new javax.swing.JComboBox();
        ae_label10 = new javax.swing.JLabel();
        ae_sep2 = new javax.swing.JSeparator();
        ae_label11 = new javax.swing.JLabel();
        ae_label14 = new javax.swing.JLabel();
        ae_label12 = new javax.swing.JLabel();
        ae_label15 = new javax.swing.JLabel();
        ae_label13 = new javax.swing.JLabel();
        ae_dob_date = new com.toedter.calendar.JDateChooser();
        ae_nat_txt = new javax.swing.JTextField();
        ae_natid_txt = new javax.swing.JTextField();
        ae_lname_txt = new javax.swing.JTextField();
        ae_relgn_txt = new javax.swing.JTextField();
        ae_pane = new javax.swing.JScrollPane();
        ae_add_txt = new javax.swing.JTextArea();
        ae_sep3 = new javax.swing.JSeparator();
        ae_saveBtn = new javax.swing.JLabel();
        ae_resetBtn = new javax.swing.JLabel();
        ae_txtlabel2 = new javax.swing.JLabel();
        ae_txtlabel4 = new javax.swing.JLabel();
        ae_txtlabel1 = new javax.swing.JLabel();
        ae_txtlabel3 = new javax.swing.JLabel();
        ae_txtlabel5 = new javax.swing.JLabel();
        ae_txtlabel6 = new javax.swing.JLabel();
        ae_txtlabel7 = new javax.swing.JLabel();
        ae_txtlabel8 = new javax.swing.JLabel();
        ae_label1 = new javax.swing.JLabel();
        ae_closeBtn = new javax.swing.JLabel();
        ae_imageBtn = new javax.swing.JLabel();
        ae_msg_label = new javax.swing.JLabel();
        ae_bgImage = new javax.swing.JLabel();
        el_tab = new javax.swing.JPanel();
        el_label1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        el_tabel = new javax.swing.JTable();
        el_closeBtn = new javax.swing.JLabel();
        el_searchBtn = new javax.swing.JLabel();
        el_recordsMsg = new javax.swing.JLabel();
        el_label2 = new javax.swing.JLabel();
        el_bgImage = new javax.swing.JLabel();
        bg_image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        body_panel.setOpaque(false);
        body_panel.setLayout(new java.awt.BorderLayout());

        side_panel.setOpaque(false);

        side_btn.setOpaque(false);

        emp_list.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/emp_list.jpg"))); // NOI18N
        emp_list.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        emp_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emp_listMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                emp_listMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                emp_listMouseExited(evt);
            }
        });

        add_emp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/add_emp.jpg"))); // NOI18N
        add_emp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add_emp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_empMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add_empMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                add_empMouseExited(evt);
            }
        });

        modify_emp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/modify_emp.jpg"))); // NOI18N
        modify_emp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modify_emp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modify_empMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                modify_empMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                modify_empMouseExited(evt);
            }
        });

        search_emp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search_emp.jpg"))); // NOI18N
        search_emp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        search_emp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search_empMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                search_empMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                search_empMouseExited(evt);
            }
        });

        javax.swing.GroupLayout side_btnLayout = new javax.swing.GroupLayout(side_btn);
        side_btn.setLayout(side_btnLayout);
        side_btnLayout.setHorizontalGroup(
            side_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(emp_list, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
            .addComponent(add_emp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(modify_emp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(search_emp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        side_btnLayout.setVerticalGroup(
            side_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_btnLayout.createSequentialGroup()
                .addComponent(emp_list)
                .addGap(18, 18, 18)
                .addComponent(add_emp)
                .addGap(18, 18, 18)
                .addComponent(modify_emp)
                .addGap(18, 18, 18)
                .addComponent(search_emp)
                .addContainerGap(35, Short.MAX_VALUE))
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
                .addContainerGap(134, Short.MAX_VALUE))
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
        center_inner.setPreferredSize(new java.awt.Dimension(950, 730));

        emp_tab.setPreferredSize(new java.awt.Dimension(945, 600));

        modify_tab.setLayout(null);

        me_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        me_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        me_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/me_h.png"))); // NOI18N
        modify_tab.add(me_label1);
        me_label1.setBounds(0, 10, 200, 60);

        me_form.setOpaque(false);
        me_form.setLayout(null);

        me_label2.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_label2.setText("Employee ID");
        me_form.add(me_label2);
        me_label2.setBounds(20, 10, 120, 40);

        me_label3.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_label3.setText("First Name ");
        me_form.add(me_label3);
        me_label3.setBounds(20, 60, 110, 40);

        me_label6.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_label6.setText("Gender");
        me_form.add(me_label6);
        me_label6.setBounds(20, 210, 80, 30);

        me_label4.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_label4.setText("Last Name");
        me_form.add(me_label4);
        me_label4.setBounds(20, 110, 90, 40);

        me_label7.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_label7.setText("Joining Date");
        me_form.add(me_label7);
        me_label7.setBounds(20, 250, 100, 30);

        me_label13.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_label13.setText("Designation");
        me_form.add(me_label13);
        me_label13.setBounds(330, 210, 90, 30);

        me_label5.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_label5.setText("Salary");
        me_form.add(me_label5);
        me_label5.setBounds(20, 160, 80, 40);

        me_label10.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_label10.setText("Contact Num");
        me_form.add(me_label10);
        me_label10.setBounds(330, 60, 103, 40);

        me_empId_txt.setBackground(new java.awt.Color(123, 211, 172));
        me_empId_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_empId_txt.setBorder(null);
        me_empId_txt.setOpaque(false);
        me_empId_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        me_form.add(me_empId_txt);
        me_empId_txt.setBounds(140, 20, 130, 23);

        me_fname_txt.setBackground(new java.awt.Color(123, 211, 172));
        me_fname_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_fname_txt.setBorder(null);
        me_fname_txt.setOpaque(false);
        me_fname_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        me_form.add(me_fname_txt);
        me_fname_txt.setBounds(140, 70, 130, 23);

        me_gender_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_gender_cbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        me_form.add(me_gender_cbox);
        me_gender_cbox.setBounds(140, 210, 130, 25);

        me_salary_txt.setBackground(new java.awt.Color(123, 211, 172));
        me_salary_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_salary_txt.setBorder(null);
        me_salary_txt.setOpaque(false);
        me_salary_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        me_form.add(me_salary_txt);
        me_salary_txt.setBounds(140, 168, 130, 23);

        me_contact_txt.setBackground(new java.awt.Color(123, 211, 172));
        me_contact_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_contact_txt.setBorder(null);
        me_contact_txt.setOpaque(false);
        me_contact_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        me_form.add(me_contact_txt);
        me_contact_txt.setBounds(460, 70, 130, 23);

        me_desig_cbox.setFont(new java.awt.Font("GardensC", 0, 14)); // NOI18N
        me_desig_cbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Manager", "Cleaner", "Security Guard", "Accountant", "Chef" }));
        me_form.add(me_desig_cbox);
        me_desig_cbox.setBounds(460, 210, 130, 25);

        me_label9.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_label9.setText("Nationality");
        me_form.add(me_label9);
        me_label9.setBounds(330, 10, 90, 40);

        me_label12.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_label12.setText("National ID");
        me_form.add(me_label12);
        me_label12.setBounds(330, 160, 86, 40);

        me_label11.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_label11.setText("Relegion");
        me_form.add(me_label11);
        me_label11.setBounds(330, 110, 80, 40);

        me_label14.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_label14.setText("Date of Birth");
        me_form.add(me_label14);
        me_label14.setBounds(330, 250, 99, 30);

        me_label8.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_label8.setText("Address");
        me_form.add(me_label8);
        me_label8.setBounds(20, 290, 60, 30);

        me_nat_txt.setBackground(new java.awt.Color(123, 211, 172));
        me_nat_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_nat_txt.setBorder(null);
        me_nat_txt.setOpaque(false);
        me_nat_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        me_form.add(me_nat_txt);
        me_nat_txt.setBounds(460, 20, 130, 23);

        me_natId_txt.setBackground(new java.awt.Color(123, 211, 172));
        me_natId_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_natId_txt.setBorder(null);
        me_natId_txt.setOpaque(false);
        me_natId_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        me_form.add(me_natId_txt);
        me_natId_txt.setBounds(460, 170, 130, 23);

        me_lname_txt.setBackground(new java.awt.Color(123, 211, 172));
        me_lname_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_lname_txt.setBorder(null);
        me_lname_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        me_form.add(me_lname_txt);
        me_lname_txt.setBounds(140, 120, 130, 23);

        me_relgn_txt.setBackground(new java.awt.Color(123, 211, 172));
        me_relgn_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_relgn_txt.setBorder(null);
        me_relgn_txt.setOpaque(false);
        me_relgn_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        me_form.add(me_relgn_txt);
        me_relgn_txt.setBounds(460, 120, 130, 23);

        me_txtlabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        me_form.add(me_txtlabel2);
        me_txtlabel2.setBounds(130, 60, 150, 40);

        me_txtlabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        me_form.add(me_txtlabel3);
        me_txtlabel3.setBounds(130, 110, 150, 40);

        me_txtlabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        me_form.add(me_txtlabel1);
        me_txtlabel1.setBounds(130, 10, 150, 40);

        me_txtlabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        me_form.add(me_txtlabel4);
        me_txtlabel4.setBounds(130, 160, 150, 40);

        me_txtlabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        me_form.add(me_txtlabel6);
        me_txtlabel6.setBounds(450, 60, 150, 40);

        me_txtlabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        me_form.add(me_txtlabel5);
        me_txtlabel5.setBounds(450, 10, 150, 40);

        me_txtlabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        me_form.add(me_txtlabel8);
        me_txtlabel8.setBounds(450, 160, 150, 40);

        me_txtlabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        me_form.add(me_txtlabel7);
        me_txtlabel7.setBounds(450, 110, 150, 40);

        me_add_txt.setColumns(20);
        me_add_txt.setFont(new java.awt.Font("GardensC", 0, 14)); // NOI18N
        me_add_txt.setRows(5);
        me_pane1.setViewportView(me_add_txt);

        me_form.add(me_pane1);
        me_pane1.setBounds(140, 300, 450, 60);

        me_imageFrame.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        me_imageFrame.setPreferredSize(new java.awt.Dimension(215, 215));

        me_selectImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/emp.png"))); // NOI18N
        me_selectImage.setMaximumSize(new java.awt.Dimension(215, 215));

        javax.swing.GroupLayout me_imageFrameLayout = new javax.swing.GroupLayout(me_imageFrame);
        me_imageFrame.setLayout(me_imageFrameLayout);
        me_imageFrameLayout.setHorizontalGroup(
            me_imageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(me_selectImage, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );
        me_imageFrameLayout.setVerticalGroup(
            me_imageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, me_imageFrameLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(me_selectImage, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        me_form.add(me_imageFrame);
        me_imageFrame.setBounds(651, 8, 210, 220);

        me_updatBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/update1.png"))); // NOI18N
        me_updatBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                me_updatBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                me_updatBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                me_updatBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                me_updatBtnMousePressed(evt);
            }
        });
        me_form.add(me_updatBtn);
        me_updatBtn.setBounds(170, 380, 100, 50);

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
        me_form.add(me_deleteBtn);
        me_deleteBtn.setBounds(280, 380, 100, 50);

        me_selectBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_1.png"))); // NOI18N
        me_selectBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                me_selectBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                me_selectBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                me_selectBtnMouseExited(evt);
            }
        });
        me_form.add(me_selectBtn);
        me_selectBtn.setBounds(650, 240, 100, 50);

        me_join_date.setBackground(new java.awt.Color(123, 211, 172));
        me_join_date.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_join_date.setBorder(null);
        me_join_date.setOpaque(false);
        me_join_date.setSelectionColor(new java.awt.Color(3, 201, 169));
        me_form.add(me_join_date);
        me_join_date.setBounds(140, 260, 130, 23);

        me_txtlabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        me_form.add(me_txtlabel9);
        me_txtlabel9.setBounds(130, 250, 150, 40);

        me_dob_date.setBackground(new java.awt.Color(123, 211, 172));
        me_dob_date.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        me_dob_date.setBorder(null);
        me_dob_date.setOpaque(false);
        me_dob_date.setSelectionColor(new java.awt.Color(3, 201, 169));
        me_form.add(me_dob_date);
        me_dob_date.setBounds(460, 260, 130, 23);

        me_txtlabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        me_form.add(me_txtlabel10);
        me_txtlabel10.setBounds(450, 250, 150, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/rc_header.png"))); // NOI18N
        me_form.add(jLabel3);
        jLabel3.setBounds(0, 390, 130, 40);

        modify_tab.add(me_form);
        me_form.setBounds(0, 70, 940, 430);

        me_tabel_panel.setLayout(new java.awt.BorderLayout());

        me_tabel_pane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        me_tabel_pane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        me_tabel.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        me_tabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        me_tabel.setFocusable(false);
        me_tabel.setGridColor(new java.awt.Color(215, 215, 203));
        me_tabel.setOpaque(false);
        me_tabel.setRowHeight(30);
        me_tabel.setSelectionBackground(new java.awt.Color(3, 201, 169));
        me_tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                me_tabelMouseClicked(evt);
            }
        });
        me_tabel_pane.setViewportView(me_tabel);

        me_tabel_panel.add(me_tabel_pane, java.awt.BorderLayout.CENTER);

        modify_tab.add(me_tabel_panel);
        me_tabel_panel.setBounds(0, 500, 940, 190);

        me_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        me_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        me_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                me_closeBtnMouseClicked(evt);
            }
        });
        modify_tab.add(me_closeBtn);
        me_closeBtn.setBounds(900, 0, 34, 31);

        me_bgImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        modify_tab.add(me_bgImage);
        me_bgImage.setBounds(0, 0, 940, 690);

        emp_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/tab_label3.jpg")), modify_tab); // NOI18N

        search_tab.setLayout(null);

        se_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        se_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        se_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                se_closeBtnMouseClicked(evt);
            }
        });
        search_tab.add(se_closeBtn);
        se_closeBtn.setBounds(903, 0, 30, 30);

        se_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        se_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/sb_header.png"))); // NOI18N
        search_tab.add(se_label1);
        se_label1.setBounds(0, 20, 190, 40);

        se_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search.png"))); // NOI18N
        se_searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        se_searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                se_searchBtnMouseClicked(evt);
            }
        });
        search_tab.add(se_searchBtn);
        se_searchBtn.setBounds(760, 90, 150, 65);

        se_modifyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/modify1.png"))); // NOI18N
        se_modifyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        se_modifyBtn.setEnabled(false);
        se_modifyBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                se_modifyBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                se_modifyBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                se_modifyBtnMouseExited(evt);
            }
        });
        search_tab.add(se_modifyBtn);
        se_modifyBtn.setBounds(760, 160, 160, 65);

        se_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/delete1.png"))); // NOI18N
        se_deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        se_deleteBtn.setEnabled(false);
        se_deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                se_deleteBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                se_deleteBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                se_deleteBtnMousePressed(evt);
            }
        });
        search_tab.add(se_deleteBtn);
        se_deleteBtn.setBounds(760, 240, 150, 65);

        se_select_txt.setBackground(new java.awt.Color(123, 211, 172));
        se_select_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        se_select_txt.setBorder(null);
        se_select_txt.setOpaque(false);
        se_select_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        se_select_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                se_select_txtKeyReleased(evt);
            }
        });
        search_tab.add(se_select_txt);
        se_select_txt.setBounds(500, 150, 130, 23);

        se_txtlabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        search_tab.add(se_txtlabel1);
        se_txtlabel1.setBounds(490, 140, 150, 40);

        se_select_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        se_select_cbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "emp_id", "contact", "salary", "first_name", "last_name", "designation", "gender" }));
        search_tab.add(se_select_cbox);
        se_select_cbox.setBounds(320, 140, 120, 30);

        se_recordsMsg.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        se_recordsMsg.setForeground(new java.awt.Color(255, 0, 0));
        search_tab.add(se_recordsMsg);
        se_recordsMsg.setBounds(190, 290, 220, 40);

        se_pane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        se_pane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        se_tabel.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        se_tabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        se_tabel.setGridColor(new java.awt.Color(215, 215, 203));
        se_tabel.setOpaque(false);
        se_tabel.setRowHeight(30);
        se_tabel.setSelectionBackground(new java.awt.Color(3, 201, 169));
        se_tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                se_tabelMouseClicked(evt);
            }
        });
        se_pane.setViewportView(se_tabel);

        search_tab.add(se_pane);
        se_pane.setBounds(0, 330, 940, 360);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/rc_header.png"))); // NOI18N
        search_tab.add(jLabel2);
        jLabel2.setBounds(0, 290, 150, 40);

        se_bgImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        search_tab.add(se_bgImage);
        se_bgImage.setBounds(0, 0, 940, 690);

        emp_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/tab_label2.jpg")), search_tab); // NOI18N

        ae_tab.setMaximumSize(new java.awt.Dimension(900, 600));
        ae_tab.setOpaque(false);
        ae_tab.setPreferredSize(new java.awt.Dimension(900, 600));
        ae_tab.setLayout(null);

        ae_imageFrame.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        ae_imageFrame.setPreferredSize(new java.awt.Dimension(215, 215));

        ae_selectImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/emp.png"))); // NOI18N
        ae_selectImage.setMaximumSize(new java.awt.Dimension(215, 215));

        javax.swing.GroupLayout ae_imageFrameLayout = new javax.swing.GroupLayout(ae_imageFrame);
        ae_imageFrame.setLayout(ae_imageFrameLayout);
        ae_imageFrameLayout.setHorizontalGroup(
            ae_imageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ae_selectImage, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );
        ae_imageFrameLayout.setVerticalGroup(
            ae_imageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ae_selectImage, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
        );

        ae_tab.add(ae_imageFrame);
        ae_imageFrame.setBounds(651, 48, 210, 220);

        ae_form.setOpaque(false);
        ae_form.setLayout(null);
        ae_form.add(ae_sep);
        ae_sep.setBounds(0, 210, 610, 10);

        ae_label2.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ae_label2.setText("Employee ID");
        ae_form.add(ae_label2);
        ae_label2.setBounds(20, 20, 120, 40);

        ae_label3.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ae_label3.setText("First Name ");
        ae_form.add(ae_label3);
        ae_label3.setBounds(20, 70, 110, 40);

        ae_label4.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ae_label4.setText("Gender");
        ae_form.add(ae_label4);
        ae_label4.setBounds(20, 120, 80, 30);

        ae_label7.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ae_label7.setText("Last Name");
        ae_form.add(ae_label7);
        ae_label7.setBounds(340, 70, 90, 40);

        ae_label8.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ae_label8.setText("Joining Date");
        ae_form.add(ae_label8);
        ae_label8.setBounds(340, 120, 100, 30);

        ae_label6.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ae_label6.setText("Designation");
        ae_form.add(ae_label6);
        ae_label6.setBounds(340, 30, 90, 30);

        ae_label5.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ae_label5.setText("Salary");
        ae_form.add(ae_label5);
        ae_label5.setBounds(20, 160, 80, 40);

        ae_label9.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ae_label9.setText("Contact Num");
        ae_form.add(ae_label9);
        ae_label9.setBounds(340, 160, 103, 40);

        ae_empid_txt.setBackground(new java.awt.Color(123, 211, 172));
        ae_empid_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ae_empid_txt.setBorder(null);
        ae_empid_txt.setOpaque(false);
        ae_empid_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        ae_empid_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ae_empid_txtKeyTyped(evt);
            }
        });
        ae_form.add(ae_empid_txt);
        ae_empid_txt.setBounds(140, 28, 130, 23);

        ae_fname_txt.setBackground(new java.awt.Color(123, 211, 172));
        ae_fname_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ae_fname_txt.setBorder(null);
        ae_fname_txt.setOpaque(false);
        ae_fname_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        ae_form.add(ae_fname_txt);
        ae_fname_txt.setBounds(140, 78, 130, 23);

        ae_gender_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ae_gender_cbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        ae_form.add(ae_gender_cbox);
        ae_gender_cbox.setBounds(140, 120, 130, 25);

        ae_join_date.setDateFormatString("MM/dd/yyyy");
        ae_form.add(ae_join_date);
        ae_join_date.setBounds(470, 120, 130, 30);

        ae_salary_txt.setBackground(new java.awt.Color(123, 211, 172));
        ae_salary_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ae_salary_txt.setBorder(null);
        ae_salary_txt.setOpaque(false);
        ae_salary_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        ae_salary_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ae_salary_txtKeyTyped(evt);
            }
        });
        ae_form.add(ae_salary_txt);
        ae_salary_txt.setBounds(140, 168, 130, 23);

        ae_contact_txt.setBackground(new java.awt.Color(123, 211, 172));
        ae_contact_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ae_contact_txt.setBorder(null);
        ae_contact_txt.setOpaque(false);
        ae_contact_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        ae_contact_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ae_contact_txtKeyTyped(evt);
            }
        });
        ae_form.add(ae_contact_txt);
        ae_contact_txt.setBounds(470, 168, 130, 23);

        ae_desg_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ae_desg_cbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Manager", "Cleaner", "Security Guard", "Accountant", "Chef" }));
        ae_form.add(ae_desg_cbox);
        ae_desg_cbox.setBounds(470, 30, 130, 25);

        ae_label10.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        ae_label10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ae_label10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/pd_h.png"))); // NOI18N
        ae_form.add(ae_label10);
        ae_label10.setBounds(0, 220, 210, 40);
        ae_form.add(ae_sep2);
        ae_sep2.setBounds(0, 0, 610, 10);

        ae_label11.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ae_label11.setText("Nationality");
        ae_form.add(ae_label11);
        ae_label11.setBounds(20, 280, 90, 40);

        ae_label14.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ae_label14.setText("National ID");
        ae_form.add(ae_label14);
        ae_label14.setBounds(340, 280, 86, 40);

        ae_label12.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ae_label12.setText("Relegion");
        ae_form.add(ae_label12);
        ae_label12.setBounds(20, 330, 80, 40);

        ae_label15.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ae_label15.setText("Date of Birth");
        ae_form.add(ae_label15);
        ae_label15.setBounds(340, 340, 99, 30);

        ae_label13.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ae_label13.setText("Address");
        ae_form.add(ae_label13);
        ae_label13.setBounds(20, 390, 60, 30);

        ae_dob_date.setDateFormatString("MMMMM d, yyyy");
        ae_dob_date.setMinSelectableDate(new java.util.Date(-62135783902000L));
        ae_form.add(ae_dob_date);
        ae_dob_date.setBounds(470, 340, 130, 30);

        ae_nat_txt.setBackground(new java.awt.Color(123, 211, 172));
        ae_nat_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ae_nat_txt.setBorder(null);
        ae_nat_txt.setOpaque(false);
        ae_nat_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        ae_form.add(ae_nat_txt);
        ae_nat_txt.setBounds(140, 288, 130, 23);

        ae_natid_txt.setBackground(new java.awt.Color(123, 211, 172));
        ae_natid_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ae_natid_txt.setBorder(null);
        ae_natid_txt.setOpaque(false);
        ae_natid_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        ae_natid_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ae_natid_txtKeyTyped(evt);
            }
        });
        ae_form.add(ae_natid_txt);
        ae_natid_txt.setBounds(470, 288, 130, 23);

        ae_lname_txt.setBackground(new java.awt.Color(123, 211, 172));
        ae_lname_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ae_lname_txt.setBorder(null);
        ae_lname_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        ae_form.add(ae_lname_txt);
        ae_lname_txt.setBounds(470, 78, 130, 23);

        ae_relgn_txt.setBackground(new java.awt.Color(123, 211, 172));
        ae_relgn_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        ae_relgn_txt.setBorder(null);
        ae_relgn_txt.setOpaque(false);
        ae_relgn_txt.setSelectionColor(new java.awt.Color(3, 201, 169));
        ae_form.add(ae_relgn_txt);
        ae_relgn_txt.setBounds(140, 338, 130, 23);

        ae_add_txt.setColumns(20);
        ae_add_txt.setFont(new java.awt.Font("GardensC", 0, 14)); // NOI18N
        ae_add_txt.setRows(5);
        ae_pane.setViewportView(ae_add_txt);

        ae_form.add(ae_pane);
        ae_pane.setBounds(130, 390, 470, 130);
        ae_form.add(ae_sep3);
        ae_sep3.setBounds(0, 260, 610, 2);

        ae_saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save1.png"))); // NOI18N
        ae_saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ae_saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ae_saveBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ae_saveBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ae_saveBtnMousePressed(evt);
            }
        });
        ae_form.add(ae_saveBtn);
        ae_saveBtn.setBounds(140, 550, 150, 70);

        ae_resetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/reset_1.png"))); // NOI18N
        ae_resetBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ae_resetBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ae_resetBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ae_resetBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ae_resetBtnMouseExited(evt);
            }
        });
        ae_form.add(ae_resetBtn);
        ae_resetBtn.setBounds(320, 550, 160, 70);

        ae_txtlabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        ae_form.add(ae_txtlabel2);
        ae_txtlabel2.setBounds(130, 70, 150, 40);

        ae_txtlabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        ae_form.add(ae_txtlabel4);
        ae_txtlabel4.setBounds(460, 70, 150, 40);

        ae_txtlabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        ae_form.add(ae_txtlabel1);
        ae_txtlabel1.setBounds(130, 20, 150, 40);

        ae_txtlabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        ae_form.add(ae_txtlabel3);
        ae_txtlabel3.setBounds(130, 160, 150, 40);

        ae_txtlabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        ae_form.add(ae_txtlabel5);
        ae_txtlabel5.setBounds(460, 160, 150, 40);

        ae_txtlabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        ae_form.add(ae_txtlabel6);
        ae_txtlabel6.setBounds(130, 280, 150, 40);

        ae_txtlabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        ae_form.add(ae_txtlabel7);
        ae_txtlabel7.setBounds(460, 280, 150, 40);

        ae_txtlabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        ae_form.add(ae_txtlabel8);
        ae_txtlabel8.setBounds(130, 330, 150, 40);

        ae_tab.add(ae_form);
        ae_form.setBounds(0, 60, 641, 630);

        ae_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        ae_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ae_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/ed_h.png"))); // NOI18N
        ae_tab.add(ae_label1);
        ae_label1.setBounds(2, 11, 210, 40);

        ae_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        ae_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ae_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ae_closeBtnMouseClicked(evt);
            }
        });
        ae_tab.add(ae_closeBtn);
        ae_closeBtn.setBounds(903, 0, 34, 31);

        ae_imageBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_1.png"))); // NOI18N
        ae_imageBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ae_imageBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ae_imageBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ae_imageBtnMouseExited(evt);
            }
        });
        ae_tab.add(ae_imageBtn);
        ae_imageBtn.setBounds(650, 290, 100, 50);
        ae_tab.add(ae_msg_label);
        ae_msg_label.setBounds(660, 460, 250, 80);

        ae_bgImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        ae_bgImage.setText("jLabel19");
        ae_tab.add(ae_bgImage);
        ae_bgImage.setBounds(-10, 0, 950, 690);

        emp_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/tab_label1.jpg")), ae_tab); // NOI18N

        el_tab.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        el_tab.setLayout(null);

        el_label1.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        el_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/el_header.png"))); // NOI18N
        el_label1.setToolTipText("");
        el_tab.add(el_label1);
        el_label1.setBounds(0, 10, 170, 60);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        el_tabel.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        el_tabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        el_tabel.setGridColor(new java.awt.Color(215, 215, 203));
        el_tabel.setOpaque(false);
        el_tabel.setRowHeight(30);
        el_tabel.setSelectionBackground(new java.awt.Color(3, 201, 169));
        jScrollPane4.setViewportView(el_tabel);

        el_tab.add(jScrollPane4);
        jScrollPane4.setBounds(0, 142, 940, 550);

        el_closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/close_image.png"))); // NOI18N
        el_closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        el_closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                el_closeBtnMouseClicked(evt);
            }
        });
        el_tab.add(el_closeBtn);
        el_closeBtn.setBounds(903, 0, 34, 31);

        el_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search.png"))); // NOI18N
        el_searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        el_searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                el_searchBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                el_searchBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                el_searchBtnMousePressed(evt);
            }
        });
        el_tab.add(el_searchBtn);
        el_searchBtn.setBounds(780, 70, 150, 65);

        el_recordsMsg.setFont(new java.awt.Font("GardensC", 0, 24)); // NOI18N
        el_recordsMsg.setForeground(new java.awt.Color(255, 0, 0));
        el_tab.add(el_recordsMsg);
        el_recordsMsg.setBounds(190, 100, 220, 40);

        el_label2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/rc_header.png"))); // NOI18N
        el_tab.add(el_label2);
        el_label2.setBounds(0, 100, 120, 40);

        el_bgImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/bg12.jpg"))); // NOI18N
        el_tab.add(el_bgImage);
        el_bgImage.setBounds(0, 0, 937, 692);

        emp_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/tab_label4.jpg")), el_tab, ""); // NOI18N

        javax.swing.GroupLayout center_innerLayout = new javax.swing.GroupLayout(center_inner);
        center_inner.setLayout(center_innerLayout);
        center_innerLayout.setHorizontalGroup(
            center_innerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(emp_tab, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
        );
        center_innerLayout.setVerticalGroup(
            center_innerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(emp_tab, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
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
            .addGap(0, 750, Short.MAX_VALUE)
            .addGroup(center_outerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(center_inner, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE))
        );

        body_panel.add(center_outer, java.awt.BorderLayout.CENTER);

        getContentPane().add(body_panel);
        body_panel.setBounds(0, 0, 1280, 1030);

        bg_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/hm_bg.jpg"))); // NOI18N
        getContentPane().add(bg_image);
        bg_image.setBounds(0, 0, 1280, 1024);

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    
    private void close_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_labelMouseClicked
        System.exit(0);
    }//GEN-LAST:event_close_labelMouseClicked

    private void mini_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mini_labelMouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_mini_labelMouseClicked

    private void emp_listMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emp_listMouseEntered
      emp_list.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/emp_list1.jpg")));
      emp_list.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_emp_listMouseEntered

    private void emp_listMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emp_listMouseExited
        emp_list.setBorder(null);
        emp_list.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/emp_list.jpg")));
    }//GEN-LAST:event_emp_listMouseExited

    private void add_empMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_empMouseEntered
        add_emp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/add_emp1.jpg")));
        add_emp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_add_empMouseEntered

    private void add_empMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_empMouseExited
        add_emp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/add_emp.jpg")));
        add_emp.setBorder(null);
    }//GEN-LAST:event_add_empMouseExited

    private void modify_empMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modify_empMouseEntered
       modify_emp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/modify_emp1.jpg")));
       modify_emp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_modify_empMouseEntered

    private void modify_empMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modify_empMouseExited
       modify_emp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/modify_emp.jpg")));
       modify_emp.setBorder(null);
    }//GEN-LAST:event_modify_empMouseExited

    private void search_empMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_empMouseEntered
       search_emp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search_emp1.jpg")));
       search_emp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(3,201,169)));
    }//GEN-LAST:event_search_empMouseEntered

    private void search_empMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_empMouseExited
        search_emp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search_emp.jpg")));
        search_emp.setBorder(null);
    }//GEN-LAST:event_search_empMouseExited

    private void ae_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ae_closeBtnMouseClicked
            emp_tab.remove(ae_tab);
    }//GEN-LAST:event_ae_closeBtnMouseClicked

    private void emp_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emp_listMouseClicked
        emp_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/tab_label4.jpg")), el_tab); 
       emp_tab.setSelectedComponent(el_tab);     
    }//GEN-LAST:event_emp_listMouseClicked

    private void add_empMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_empMouseClicked
       emp_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/tab_label1.jpg")), ae_tab); 
       emp_tab.setSelectedComponent(ae_tab);
    }//GEN-LAST:event_add_empMouseClicked

    private void ae_imageBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ae_imageBtnMouseClicked
        
        ae_imageBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_3.png")));
        int a=jFileChooser1.showOpenDialog(this);
        if(a==JFileChooser.APPROVE_OPTION){
        File f= jFileChooser1.getSelectedFile();
        path=f.getPath();
        
        
        ae_selectImage.setIcon(new ImageIcon(""+f));}
        
    }//GEN-LAST:event_ae_imageBtnMouseClicked
    
    
    private void ae_imageBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ae_imageBtnMouseEntered
        
        ae_imageBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_2.png")));
    }//GEN-LAST:event_ae_imageBtnMouseEntered

    private void ae_imageBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ae_imageBtnMouseExited
       ae_imageBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_1.png")));
    }//GEN-LAST:event_ae_imageBtnMouseExited

    private void ae_resetBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ae_resetBtnMouseEntered
             ae_resetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/reset_2.png")));

    }//GEN-LAST:event_ae_resetBtnMouseEntered

    private void ae_resetBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ae_resetBtnMouseExited
       ae_resetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/reset_1.png")));
    }//GEN-LAST:event_ae_resetBtnMouseExited

    private void ae_saveBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ae_saveBtnMouseEntered
        ae_saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save2.png")));
    }//GEN-LAST:event_ae_saveBtnMouseEntered

    private void ae_saveBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ae_saveBtnMouseExited
        ae_saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save1.png")));
    }//GEN-LAST:event_ae_saveBtnMouseExited

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

    private void se_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_se_closeBtnMouseClicked
        emp_tab.remove(search_tab);
    }//GEN-LAST:event_se_closeBtnMouseClicked

    private void ae_resetBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ae_resetBtnMouseClicked
        ae_fname_txt.setText("");
        ae_lname_txt.setText("");
        ae_empid_txt.setText("");
        ae_salary_txt.setText("");
        ae_contact_txt.setText("");
        ae_nat_txt.setText("");
        ae_natid_txt.setText("");
        ae_relgn_txt.setText("");
        ae_msg_label.setIcon(null);
        ae_add_txt.setText("");
        ae_desg_cbox.setSelectedIndex(0);
        ae_dob_date.setCalendar(null);
        ae_join_date.setCalendar(null);
        ae_gender_cbox.setSelectedIndex(0);
        ae_selectImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/emp.png")));
 
    }//GEN-LAST:event_ae_resetBtnMouseClicked

    private void search_empMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_empMouseClicked
        emp_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/tab_label2.jpg")),search_tab); 
       emp_tab.setSelectedComponent(search_tab);
    }//GEN-LAST:event_search_empMouseClicked

    private void se_modifyBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_se_modifyBtnMouseEntered
        se_modifyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/modify2.png")));
    }//GEN-LAST:event_se_modifyBtnMouseEntered

    private void se_modifyBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_se_modifyBtnMouseExited
        se_modifyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/modify1.png")));
    }//GEN-LAST:event_se_modifyBtnMouseExited

    private void se_deleteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_se_deleteBtnMouseEntered
        se_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/delete2.png")));
    }//GEN-LAST:event_se_deleteBtnMouseEntered

    private void se_deleteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_se_deleteBtnMouseExited
        se_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/delete1.png")));
    }//GEN-LAST:event_se_deleteBtnMouseExited

    private void me_updatBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_updatBtnMouseEntered
        me_updatBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/update2.png")));

    }//GEN-LAST:event_me_updatBtnMouseEntered

    private void me_updatBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_updatBtnMouseExited
        me_updatBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/update1.png")));
    }//GEN-LAST:event_me_updatBtnMouseExited

    private void me_updatBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_updatBtnMouseClicked
       me_updatBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/update3.png")));
    }//GEN-LAST:event_me_updatBtnMouseClicked

    private void me_deleteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_deleteBtnMouseEntered
     me_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_2.png")));                                     

    }//GEN-LAST:event_me_deleteBtnMouseEntered

    private void me_deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_deleteBtnMouseClicked
    me_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_3.png")));                                      
    }//GEN-LAST:event_me_deleteBtnMouseClicked

    private void me_deleteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_deleteBtnMouseExited
    me_deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/del_1.png")));                                      

    }//GEN-LAST:event_me_deleteBtnMouseExited

    private void me_selectBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_selectBtnMouseClicked
        me_selectBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_3.png")));
        int a=jFileChooser1.showOpenDialog(this);
        if(a==JFileChooser.APPROVE_OPTION){
        File f= jFileChooser1.getSelectedFile();
        path=f.getPath();
        
        
        me_selectImage.setIcon(new ImageIcon(""+f));}
    }//GEN-LAST:event_me_selectBtnMouseClicked

    private void me_selectBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_selectBtnMouseEntered
        me_selectBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_2.png")));
    }//GEN-LAST:event_me_selectBtnMouseEntered

    private void me_selectBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_selectBtnMouseExited
        me_selectBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/select_1.png")));
    }//GEN-LAST:event_me_selectBtnMouseExited

    private void el_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_el_closeBtnMouseClicked
      emp_tab.remove(el_tab); 
    }//GEN-LAST:event_el_closeBtnMouseClicked

    private void me_closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_closeBtnMouseClicked
      emp_tab.remove(modify_tab);
    }//GEN-LAST:event_me_closeBtnMouseClicked

    private void modify_empMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modify_empMouseClicked
       emp_tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/tab_label3.jpg")),modify_tab); 
       emp_tab.setSelectedComponent(modify_tab);
    }//GEN-LAST:event_modify_empMouseClicked

   
    private void se_searchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_se_searchBtnMouseClicked
    
   if(on_off==true){    
   se_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search1.png")));
   on_off=false;
   }
   else
   {  
   se_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search.png")));
   on_off=true;    
   }     

        
    }//GEN-LAST:event_se_searchBtnMouseClicked

    private void se_tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_se_tabelMouseClicked
        int row =se_tabel.getSelectedRow();
        
       
       
        if(se_tabel.isRowSelected(row)==true)
       {
       se_modifyBtn.setEnabled(true);
       se_deleteBtn.setEnabled(true);
       }
        else
        {
       se_modifyBtn.setEnabled(false);
       se_deleteBtn.setEnabled(false);
        }
        
    }//GEN-LAST:event_se_tabelMouseClicked

    private void ae_empid_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ae_empid_txtKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE ))
        {
        getToolkit().beep();
        evt.consume();
        }
        
    }//GEN-LAST:event_ae_empid_txtKeyTyped
    private String getdate(String date){
    String d= date;
    String Date=d.substring(0,12);
    return Date;
    
    }
    
    private void ae_saveBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ae_saveBtnMousePressed
  
        try
        {
            Connection con = DatabaseManager.getconnect();
            String sql= "Insert into employee (emp_id,first_name,last_name,nationality,contact,relegion,salary,national_id,gender,designation,join_date,dob,address,emp_image) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst =con.prepareStatement(sql);
            
            pst.setInt(1,Integer.parseInt(ae_empid_txt.getText()));
            pst.setString(2, ae_fname_txt.getText());
            pst.setString(3, ae_lname_txt.getText());
            pst.setString(4, ae_nat_txt.getText());
            pst.setString(5,ae_contact_txt.getText());
            pst.setString(6, ae_relgn_txt.getText());
            pst.setInt(7, Integer.parseInt(ae_salary_txt.getText()));
            pst.setString(8, ae_natid_txt.getText());
            pst.setString(9, ae_gender_cbox.getSelectedItem().toString());
            pst.setString(10, ae_desg_cbox.getSelectedItem().toString());
            String date1=getdate(ae_join_date.getDate().toLocaleString());
            pst.setString(11,date1);
            String date2=getdate(ae_dob_date.getDate().toLocaleString());
            pst.setString(12,date2);
            pst.setString(13, ae_add_txt.getText());
            pst.setString(14,path );
            pst.execute();
            
            
            ae_msg_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/save_msg.png")));
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e,"Error Message",JOptionPane.ERROR_MESSAGE);
          
            ae_msg_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/error_msg.png")));
            }
        
        
    }//GEN-LAST:event_ae_saveBtnMousePressed

    private void ae_salary_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ae_salary_txtKeyTyped
      char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE ))
        {
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_ae_salary_txtKeyTyped

    private void ae_contact_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ae_contact_txtKeyTyped
         char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE ))
        {
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_ae_contact_txtKeyTyped

    private void ae_natid_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ae_natid_txtKeyTyped
     char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE ))
        {
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_ae_natid_txtKeyTyped

    private void se_select_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_se_select_txtKeyReleased
      
        if(on_off==false){   
        try{
        
        con=DatabaseManager.getconnect();
        int index=se_select_cbox.getSelectedIndex();
        String Selection = se_select_cbox.getSelectedItem().toString();
        se_query = "select * from employee where "+Selection+"= ? ";
        pst= con.prepareStatement(se_query);
        if( (index==0) || (index==1) || (index==2) ){
        pst.setInt(1,Integer.parseInt(se_select_txt.getText()));
        rs= pst.executeQuery();
        //System.out.println(rs.getCursorName());
        se_tabel.setModel(DbUtils.resultSetToTableModel(rs));
        setColumn(se_tabel);
            
        }
        else
 
        { pst.setString(1,se_select_txt.getText());
        rs= pst.executeQuery();
        //System.out.println(rs.getCursorName());
        
        se_tabel.setModel(DbUtils.resultSetToTableModel(rs));}
        setColumn(se_tabel);
       //records Counting
        int rows= se_tabel.getRowCount();
        
        if(rows>0)
        {
        se_recordsMsg.setForeground(new java.awt.Color(16, 109, 64));
        se_recordsMsg.setText("Records Found "+rows);
        }
        else
        {
        se_recordsMsg.setForeground(new java.awt.Color(255, 0, 0));
        se_recordsMsg.setText("No Records Found ");
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
       
        
        
    }//GEN-LAST:event_se_select_txtKeyReleased

    private void se_modifyBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_se_modifyBtnMouseClicked
       if(se_modifyBtn.isEnabled())
       {    
       emp_tab.setSelectedComponent(modify_tab);
       int row = se_tabel.getSelectedRow();
       emp_id= (int) se_tabel.getModel().getValueAt(row, 0);
       
       try
       {
       
       String query="Select * from employee where emp_id='"+emp_id+"'";
       pst=con.prepareStatement(query);
       rs=pst.executeQuery();
       
       
       me_tabel.setModel(DbUtils.resultSetToTableModel(rs));
       setColumn(me_tabel);
       
       
     
       }
       catch(Exception e){
       e.printStackTrace();
       }

       
       }
       
       
       
       
        
    }//GEN-LAST:event_se_modifyBtnMouseClicked

    private void me_tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_tabelMouseClicked
        try{ 
       
       
       
       String query="select * from employee where emp_id='"+emp_id+"'";
       PreparedStatement pstt=con.prepareStatement(query);
       ResultSet res=pstt.executeQuery();
       
                
                while(res.next())
                {
                         
                   
                    me_empId_txt.setText(Integer.toString(res.getInt("emp_id")));
                    me_fname_txt.setText(res.getString("first_name"));
                    me_lname_txt.setText(res.getString("last_name"));
                    me_nat_txt.setText(res.getString("nationality"));
                    me_contact_txt.setText(res.getString("contact"));
                    me_relgn_txt.setText(res.getString("relegion"));
                    me_salary_txt.setText(Integer.toString(res.getInt("salary")));
                    me_natId_txt.setText(res.getString("national_id"));
                    me_gender_cbox.setSelectedItem(res.getString("gender"));
                    me_desig_cbox.setSelectedItem(res.getString("designation"));
                    me_join_date.setText(res.getString("join_date"));
                    me_dob_date.setText(res.getString("dob"));
                    me_add_txt.setText(res.getString("address"));
                    String image_url= res.getString("emp_image");
                    ImageIcon image = new ImageIcon(image_url);
                    me_selectImage.setIcon(image);
                    
                    
                   
                }    
          
        }
       
      
      
      catch(Exception e)
      {
      e.printStackTrace();
      }
        
        
    }//GEN-LAST:event_me_tabelMouseClicked

    private void me_deleteBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_deleteBtnMousePressed
       String sql= "Delete from employee where emp_id='"+emp_id+"'";
       int option=JOptionPane.showConfirmDialog(null,"Are You Sure You want to delete data");
       if(option==JOptionPane.YES_OPTION){
       try{
       pst=con.prepareStatement(sql);
       
       pst.execute();
       
       JOptionPane.showMessageDialog(null,"Deleted Succesfully","Message",JOptionPane.INFORMATION_MESSAGE);
           updateTable(emp_id,me_tabel);
       
           
       }catch(Exception e){
       e.printStackTrace();
       }
       }
    }//GEN-LAST:event_me_deleteBtnMousePressed
    
    private void updateTable(int id,JTable tabel){
     try
     {   
    String sql="Select * from employee where emp_id='"+id+"'";
    pst=con.prepareStatement(sql);
    rs=pst.executeQuery();
    tabel.setModel(DbUtils.resultSetToTableModel(rs));
     }
     catch(Exception e)
     {
     e.printStackTrace();
     }
    
    }
    
    
    private void me_updatBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_me_updatBtnMousePressed
        try{
            
        int id=Integer.parseInt(me_empId_txt.getText());
        String fname= me_fname_txt.getText();
        String lname= me_lname_txt.getText();
        String nat= me_nat_txt.getText();
        int cnt= Integer.parseInt(me_contact_txt.getText());
        String relg=me_relgn_txt.getText();
        int salary=Integer.parseInt(me_salary_txt.getText());
        int nat_id= Integer.parseInt(me_natId_txt.getText());
        String gndr= me_gender_cbox.getSelectedItem().toString();
        String desg= me_desig_cbox.getSelectedItem().toString();
        String join_d=me_join_date.getText().toString();
        String dob= me_dob_date.getText().toString();
        String add=me_add_txt.getText();
        String url=path;
        if(path==null){   
        String sql= "update employee set emp_id='"+id+"',first_name='"+fname+"'  ,last_name='"+lname+"' ,nationality= '"+nat+"', contact= '"+cnt+"', relegion='"+relg+"' , "
                + "salary= '"+salary+"',  national_id= '"+nat_id+"',gender='"+gndr+"' , designation='"+desg+"' , join_date='"+join_d+"' , dob='"+dob+"' , address='"+add+"'  where emp_id='"+emp_id+"' ";
        
        pst=con.prepareStatement(sql);
        
        pst.execute();
        JOptionPane.showMessageDialog(this, "Succesfully Updated", "Message",JOptionPane.INFORMATION_MESSAGE );
            updateTable(id,me_tabel);
        }
        else{
        String sql= "update employee set emp_id='"+id+"',first_name='"+fname+"'  ,last_name='"+lname+"' ,nationality= '"+nat+"', contact= '"+cnt+"', relegion='"+relg+"' , "
                + "salary= '"+salary+"',  national_id= '"+nat_id+"',gender='"+gndr+"' , designation='"+desg+"' , join_date='"+join_d+"' , dob='"+dob+"' , address='"+add+"' , emp_image= '"+url+"' where emp_id='"+emp_id+"' ";
        
        pst=con.prepareStatement(sql);
        
        pst.execute();
        JOptionPane.showMessageDialog(this, "Succesfully Updated", "Message",JOptionPane.INFORMATION_MESSAGE );
            updateTable(id,me_tabel);
        
        
        }
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(this,e );
        }
        
    }//GEN-LAST:event_me_updatBtnMousePressed

    private void el_searchBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_el_searchBtnMouseEntered
     el_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search1.png")));
    }//GEN-LAST:event_el_searchBtnMouseEntered

    private void el_searchBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_el_searchBtnMouseExited
      el_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/search.png")));
    }//GEN-LAST:event_el_searchBtnMouseExited

    
    
   
    private void el_searchBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_el_searchBtnMousePressed
        
        String sql="Select * from employee";
        try
        {
        pst=con.prepareStatement(sql);
        rs=pst.executeQuery();
        el_tabel.setModel(DbUtils.resultSetToTableModel(rs)); 
        setColumn(el_tabel);
        

        }
        catch(Exception e)
        {
        e.printStackTrace();
        }
        
        int rows= el_tabel.getRowCount();
        
        if(rows>0)
        {
        el_recordsMsg.setForeground(new java.awt.Color(16, 109, 64));
        el_recordsMsg.setText("Records Found "+rows);
        }
        else
        {
        el_recordsMsg.setForeground(new java.awt.Color(255, 0, 0));
        el_recordsMsg.setText("No Records Found ");
        }
        
        
    }//GEN-LAST:event_el_searchBtnMousePressed

    private void se_deleteBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_se_deleteBtnMousePressed
       int row = se_tabel.getSelectedRow();
       emp_id= (int) se_tabel.getModel().getValueAt(row, 0);
       String sql= "Delete from employee where emp_id='"+emp_id+"'";
       int option=JOptionPane.showConfirmDialog(null,"Are You Sure You want to delete data");
       if(option==JOptionPane.YES_OPTION)
       {
       
       try{
       pst=con.prepareStatement(sql);
       
       pst.execute();
       
       JOptionPane.showMessageDialog(null,"Deleted Succesfully","Message",JOptionPane.INFORMATION_MESSAGE);
       updateTable(emp_id,se_tabel);
       
           
       }catch(Exception e){
       e.printStackTrace();
       }
       }
    }//GEN-LAST:event_se_deleteBtnMousePressed
    
   

  
    
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel add_emp;
    private javax.swing.JLabel adm_label;
    private javax.swing.JLabel admin_label;
    private javax.swing.JTextArea ae_add_txt;
    private javax.swing.JLabel ae_bgImage;
    private javax.swing.JLabel ae_closeBtn;
    private javax.swing.JTextField ae_contact_txt;
    private javax.swing.JComboBox ae_desg_cbox;
    private com.toedter.calendar.JDateChooser ae_dob_date;
    private javax.swing.JTextField ae_empid_txt;
    private javax.swing.JTextField ae_fname_txt;
    private javax.swing.JPanel ae_form;
    private javax.swing.JComboBox ae_gender_cbox;
    private javax.swing.JLabel ae_imageBtn;
    private javax.swing.JPanel ae_imageFrame;
    private com.toedter.calendar.JDateChooser ae_join_date;
    private javax.swing.JLabel ae_label1;
    private javax.swing.JLabel ae_label10;
    private javax.swing.JLabel ae_label11;
    private javax.swing.JLabel ae_label12;
    private javax.swing.JLabel ae_label13;
    private javax.swing.JLabel ae_label14;
    private javax.swing.JLabel ae_label15;
    private javax.swing.JLabel ae_label2;
    private javax.swing.JLabel ae_label3;
    private javax.swing.JLabel ae_label4;
    private javax.swing.JLabel ae_label5;
    private javax.swing.JLabel ae_label6;
    private javax.swing.JLabel ae_label7;
    private javax.swing.JLabel ae_label8;
    private javax.swing.JLabel ae_label9;
    private javax.swing.JTextField ae_lname_txt;
    private javax.swing.JLabel ae_msg_label;
    private javax.swing.JTextField ae_nat_txt;
    private javax.swing.JTextField ae_natid_txt;
    private javax.swing.JScrollPane ae_pane;
    private javax.swing.JTextField ae_relgn_txt;
    private javax.swing.JLabel ae_resetBtn;
    private javax.swing.JTextField ae_salary_txt;
    private javax.swing.JLabel ae_saveBtn;
    private javax.swing.JLabel ae_selectImage;
    private javax.swing.JSeparator ae_sep;
    private javax.swing.JSeparator ae_sep2;
    private javax.swing.JSeparator ae_sep3;
    private javax.swing.JPanel ae_tab;
    private javax.swing.JLabel ae_txtlabel1;
    private javax.swing.JLabel ae_txtlabel2;
    private javax.swing.JLabel ae_txtlabel3;
    private javax.swing.JLabel ae_txtlabel4;
    private javax.swing.JLabel ae_txtlabel5;
    private javax.swing.JLabel ae_txtlabel6;
    private javax.swing.JLabel ae_txtlabel7;
    private javax.swing.JLabel ae_txtlabel8;
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
    private javax.swing.JLabel el_bgImage;
    private javax.swing.JLabel el_closeBtn;
    private javax.swing.JLabel el_label1;
    private javax.swing.JLabel el_label2;
    private javax.swing.JLabel el_recordsMsg;
    private javax.swing.JLabel el_searchBtn;
    private javax.swing.JPanel el_tab;
    private javax.swing.JTable el_tabel;
    private javax.swing.JLabel emp_list;
    private javax.swing.JTabbedPane emp_tab;
    private javax.swing.JPanel footer_panel;
    private javax.swing.JPanel header_panel;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logout;
    private javax.swing.JTextArea me_add_txt;
    private javax.swing.JLabel me_bgImage;
    private javax.swing.JLabel me_closeBtn;
    private javax.swing.JTextField me_contact_txt;
    private javax.swing.JLabel me_deleteBtn;
    private javax.swing.JComboBox me_desig_cbox;
    private javax.swing.JTextField me_dob_date;
    private javax.swing.JTextField me_empId_txt;
    private javax.swing.JTextField me_fname_txt;
    private javax.swing.JPanel me_form;
    private javax.swing.JComboBox me_gender_cbox;
    private javax.swing.JPanel me_imageFrame;
    private javax.swing.JTextField me_join_date;
    private javax.swing.JLabel me_label1;
    private javax.swing.JLabel me_label10;
    private javax.swing.JLabel me_label11;
    private javax.swing.JLabel me_label12;
    private javax.swing.JLabel me_label13;
    private javax.swing.JLabel me_label14;
    private javax.swing.JLabel me_label2;
    private javax.swing.JLabel me_label3;
    private javax.swing.JLabel me_label4;
    private javax.swing.JLabel me_label5;
    private javax.swing.JLabel me_label6;
    private javax.swing.JLabel me_label7;
    private javax.swing.JLabel me_label8;
    private javax.swing.JLabel me_label9;
    private javax.swing.JTextField me_lname_txt;
    private javax.swing.JTextField me_natId_txt;
    private javax.swing.JTextField me_nat_txt;
    private javax.swing.JScrollPane me_pane1;
    private javax.swing.JTextField me_relgn_txt;
    private javax.swing.JTextField me_salary_txt;
    private javax.swing.JLabel me_selectBtn;
    private javax.swing.JLabel me_selectImage;
    private javax.swing.JTable me_tabel;
    private javax.swing.JScrollPane me_tabel_pane;
    private javax.swing.JPanel me_tabel_panel;
    private javax.swing.JLabel me_txtlabel1;
    private javax.swing.JLabel me_txtlabel10;
    private javax.swing.JLabel me_txtlabel2;
    private javax.swing.JLabel me_txtlabel3;
    private javax.swing.JLabel me_txtlabel4;
    private javax.swing.JLabel me_txtlabel5;
    private javax.swing.JLabel me_txtlabel6;
    private javax.swing.JLabel me_txtlabel7;
    private javax.swing.JLabel me_txtlabel8;
    private javax.swing.JLabel me_txtlabel9;
    private javax.swing.JLabel me_updatBtn;
    private javax.swing.JLabel mini_label;
    private javax.swing.JLabel modify_emp;
    private javax.swing.JPanel modify_tab;
    private javax.swing.JLabel month;
    private javax.swing.JLabel se_bgImage;
    private javax.swing.JLabel se_closeBtn;
    private javax.swing.JLabel se_deleteBtn;
    private javax.swing.JLabel se_label1;
    private javax.swing.JLabel se_modifyBtn;
    private javax.swing.JScrollPane se_pane;
    private javax.swing.JLabel se_recordsMsg;
    private javax.swing.JLabel se_searchBtn;
    private javax.swing.JComboBox se_select_cbox;
    private javax.swing.JTextField se_select_txt;
    private javax.swing.JTable se_tabel;
    private javax.swing.JLabel se_txtlabel1;
    private javax.swing.JLabel search_emp;
    private javax.swing.JPanel search_tab;
    private javax.swing.JPanel side_btn;
    private javax.swing.JPanel side_panel;
    private javax.swing.JLabel time_label;
    private javax.swing.JPanel time_panel;
    private javax.swing.JLabel year;
    // End of variables declaration//GEN-END:variables

    private void ImageIcon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
