/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class setting extends javax.swing.JFrame {
    
    boolean on_off=true;
    ResultSet rs =null;
    PreparedStatement pst=null;
    Connection con =null;
    String user_name;

    public setting() {
        initComponents();
         Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
         int jframeW= this.getSize().width;
         int jframeH= this.getSize().height;  
         
        
         int locationX=(d.width-jframeW)/2;
         int locationY=(d.height-jframeH)/2;
         this.setLocation(locationX, locationY);
        con=DatabaseManager.getconnect();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setting_panel = new javax.swing.JPanel();
        label5 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        btn_closed = new javax.swing.JLabel();
        btn_minimize = new javax.swing.JLabel();
        admin_btn = new javax.swing.JLabel();
        user_cbox = new javax.swing.JComboBox();
        label2 = new javax.swing.JLabel();
        newPass_txt = new javax.swing.JPasswordField();
        confPass_txt = new javax.swing.JPasswordField();
        oldpass_txt = new javax.swing.JPasswordField();
        label4 = new javax.swing.JLabel();
        txt_label1 = new javax.swing.JLabel();
        txt_label2 = new javax.swing.JLabel();
        txt_label3 = new javax.swing.JLabel();
        confirmBtn = new javax.swing.JLabel();
        checkBtn = new javax.swing.JLabel();
        error_msg = new javax.swing.JLabel();
        error1 = new javax.swing.JLabel();
        error2 = new javax.swing.JLabel();
        bg_image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        setting_panel.setMaximumSize(new java.awt.Dimension(500, 350));
        setting_panel.setPreferredSize(new java.awt.Dimension(500, 350));
        setting_panel.setLayout(null);

        label5.setFont(new java.awt.Font("GardensC", 0, 36)); // NOI18N
        label5.setForeground(new java.awt.Color(3, 201, 169));
        label5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label5.setText("Setting");
        label5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        setting_panel.add(label5);
        label5.setBounds(230, 40, 130, 40);

        label3.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        label3.setText("Confirm Password");
        setting_panel.add(label3);
        label3.setBounds(50, 250, 150, 40);

        label1.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        label1.setText("Select User");
        setting_panel.add(label1);
        label1.setBounds(100, 100, 90, 30);

        btn_closed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_closed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_closedMouseClicked(evt);
            }
        });
        setting_panel.add(btn_closed);
        btn_closed.setBounds(550, 10, 40, 30);

        btn_minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_minimizeMouseClicked(evt);
            }
        });
        setting_panel.add(btn_minimize);
        btn_minimize.setBounds(510, 0, 30, 40);

        admin_btn.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        admin_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/radio_btn1.png"))); // NOI18N
        admin_btn.setText("Admin");
        admin_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin_btn.setIconTextGap(10);
        admin_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_btnMouseClicked(evt);
            }
        });
        setting_panel.add(admin_btn);
        admin_btn.setBounds(220, 100, 80, 30);

        user_cbox.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        setting_panel.add(user_cbox);
        user_cbox.setBounds(320, 100, 120, 30);

        label2.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        label2.setText("Old Password");
        setting_panel.add(label2);
        label2.setBounds(80, 150, 110, 40);

        newPass_txt.setBackground(new java.awt.Color(123, 211, 172));
        newPass_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        newPass_txt.setBorder(null);
        newPass_txt.setOpaque(false);
        setting_panel.add(newPass_txt);
        newPass_txt.setBounds(220, 210, 120, 19);

        confPass_txt.setBackground(new java.awt.Color(123, 211, 172));
        confPass_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        confPass_txt.setBorder(null);
        confPass_txt.setOpaque(false);
        confPass_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                confPass_txtKeyReleased(evt);
            }
        });
        setting_panel.add(confPass_txt);
        confPass_txt.setBounds(220, 260, 120, 19);

        oldpass_txt.setBackground(new java.awt.Color(123, 211, 172));
        oldpass_txt.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        oldpass_txt.setBorder(null);
        oldpass_txt.setOpaque(false);
        oldpass_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                oldpass_txtKeyReleased(evt);
            }
        });
        setting_panel.add(oldpass_txt);
        oldpass_txt.setBounds(220, 160, 120, 19);

        label4.setFont(new java.awt.Font("GardensC", 0, 18)); // NOI18N
        label4.setText("New Password");
        setting_panel.add(label4);
        label4.setBounds(70, 200, 113, 40);

        txt_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        setting_panel.add(txt_label1);
        txt_label1.setBounds(210, 150, 150, 40);

        txt_label2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        setting_panel.add(txt_label2);
        txt_label2.setBounds(210, 200, 150, 40);

        txt_label3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/txt_field.png"))); // NOI18N
        setting_panel.add(txt_label3);
        txt_label3.setBounds(210, 250, 150, 40);

        confirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/confirm1.png"))); // NOI18N
        confirmBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirmBtn.setEnabled(false);
        confirmBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirmBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirmBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                confirmBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                confirmBtnMouseReleased(evt);
            }
        });
        setting_panel.add(confirmBtn);
        confirmBtn.setBounds(240, 310, 100, 50);

        checkBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/find.png"))); // NOI18N
        checkBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                checkBtnMousePressed(evt);
            }
        });
        setting_panel.add(checkBtn);
        checkBtn.setBounds(450, 100, 32, 32);

        error_msg.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        error_msg.setForeground(new java.awt.Color(204, 0, 0));
        setting_panel.add(error_msg);
        error_msg.setBounds(350, 310, 230, 40);
        setting_panel.add(error1);
        error1.setBounds(360, 150, 50, 40);
        setting_panel.add(error2);
        error2.setBounds(360, 250, 50, 40);

        bg_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/bg_img/setting.jpg"))); // NOI18N
        setting_panel.add(bg_image);
        bg_image.setBounds(0, 0, 600, 420);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(setting_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(setting_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_closedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closedMouseClicked
        
        this.dispose();
       
       
    }//GEN-LAST:event_btn_closedMouseClicked

    private void btn_minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_minimizeMouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_btn_minimizeMouseClicked

    private void admin_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseClicked

        if(on_off==true){

            admin_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/radio_btn2.png")));
            user_cbox.setEnabled(false);
           

            on_off=false;
        }
        else
        {
            admin_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/radio_btn1.png")));
            user_cbox.setEnabled(true);
           

            on_off=true;
        }
    }//GEN-LAST:event_admin_btnMouseClicked

    private void checkBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkBtnMousePressed
       try
       {
       user_cbox.removeAllItems();
       String sql="Select user_name from login where user_name !='Admin'";
       pst=con.prepareStatement(sql);
       rs=pst.executeQuery();
       while(rs.next()){
       user_cbox.addItem(rs.getString("user_name"));
       
       }

       }
       catch(Exception e){e.printStackTrace();}
        
    }//GEN-LAST:event_checkBtnMousePressed

    private void confirmBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtnMousePressed
      if(confirmBtn.isEnabled()){
          confirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/confirm3.png")));
          try{
          System.out.print(user_name);
          String sql="update login set password= ? where user_name='"+user_name+"'";
          pst=con.prepareStatement(sql);
          pst.setString(1, confPass_txt.getText());
         pst.execute();
              JOptionPane.showMessageDialog(this,"Succesfully Updated");
          
          }
      catch(Exception e){e.printStackTrace();}
      }
        
    }//GEN-LAST:event_confirmBtnMousePressed

    private void oldpass_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_oldpass_txtKeyReleased
        String pass=null;
        if(on_off==false){
       
        try{    
        user_name="Admin";
        String sql="Select password from login where user_name='Admin'" ;
        pst=con.prepareStatement(sql);
        rs=pst.executeQuery();
        while(rs.next()){
            
        pass=rs.getString("password");
        }
        String passText = new String(oldpass_txt.getPassword());
        
        
        if(pass.equals(passText)){
        
        newPass_txt.setEditable(true);
        error1.setIcon(null);
        error_msg.setText("");
        
        }
        else{
        newPass_txt.setEditable(false);
        error1.setIcon(new ImageIcon(getClass().getResource("/admin/Icons/errorIcon.png")));
        error_msg.setText("The Password Does not Match !");
        
        }
        }
        catch(Exception e){e.printStackTrace();}
        }
        else{
        try{
        user_name=user_cbox.getSelectedItem().toString();
        String sql2="Select password from login where user_name=?" ;
        pst=con.prepareStatement(sql2);
        pst.setString(1,user_name);
        rs=pst.executeQuery();
        while(rs.next()){
        pass=rs.getString("password");
        
        }
        
        String passText = new String(oldpass_txt.getPassword());
      
        
        if(pass.equals(passText)){
             newPass_txt.setEditable(true);
            error1.setIcon(null);
            error_msg.setText("");
           
            
        }
        else{
             newPass_txt.setEditable(false);
            error1.setIcon(new ImageIcon(getClass().getResource("/admin/Icons/errorIcon.png")));
            error_msg.setText("The Password Does not Match !");
           
            
        }
        
        }
        catch(Exception e){e.printStackTrace();}
        
        }
          
    }//GEN-LAST:event_oldpass_txtKeyReleased

    private void confPass_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confPass_txtKeyReleased
     if(newPass_txt.getText().equals(confPass_txt.getText()))
      {
      
      confirmBtn.setEnabled(true);
       error2.setIcon(null);
        error_msg.setText("");
      }
      else{
     confirmBtn.setEnabled(false);
     
   
     error2.setIcon(new ImageIcon(getClass().getResource("/admin/Icons/errorIcon.png")));
     error_msg.setText("The Password Does not Match !"); 
      }  
    }//GEN-LAST:event_confPass_txtKeyReleased

    private void confirmBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtnMouseEntered
confirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/confirm2.png")));
    }//GEN-LAST:event_confirmBtnMouseEntered

    private void confirmBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtnMouseExited
  confirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/confirm1.png")));
    }//GEN-LAST:event_confirmBtnMouseExited

    private void confirmBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtnMouseReleased
confirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/Icons/confirm2.png")));
    }//GEN-LAST:event_confirmBtnMouseReleased

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admin_btn;
    private javax.swing.JLabel bg_image;
    private javax.swing.JLabel btn_closed;
    private javax.swing.JLabel btn_minimize;
    private javax.swing.JLabel checkBtn;
    private javax.swing.JPasswordField confPass_txt;
    private javax.swing.JLabel confirmBtn;
    private javax.swing.JLabel error1;
    private javax.swing.JLabel error2;
    private javax.swing.JLabel error_msg;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JPasswordField newPass_txt;
    private javax.swing.JPasswordField oldpass_txt;
    private javax.swing.JPanel setting_panel;
    private javax.swing.JLabel txt_label1;
    private javax.swing.JLabel txt_label2;
    private javax.swing.JLabel txt_label3;
    private javax.swing.JComboBox user_cbox;
    // End of variables declaration//GEN-END:variables
}
