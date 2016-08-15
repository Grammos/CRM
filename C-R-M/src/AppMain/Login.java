/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AppMain;

import Ejb.Role;
import Ejb.Users;
import bl.RoleInterface;
import bl.RoleRepository;
import bl.UsersRepository;
import gui.UsersForm;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Drilon
 */


public class Login extends javax.swing.JFrame {

    UsersRepository ur=new UsersRepository();
    UsersForm uu=new UsersForm();
    Users item;
    Role roli;
    RoleInterface rp=new RoleRepository();
    public Login() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setIcon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmd_login = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Backround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        txt_username.setBackground(new java.awt.Color(30, 79, 138));
        txt_username.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_username.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txt_username);
        txt_username.setBounds(660, 300, 170, 30);

        txt_password.setBackground(new java.awt.Color(30, 79, 138));
        txt_password.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        txt_password.setToolTipText("");
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
        });
        getContentPane().add(txt_password);
        txt_password.setBounds(660, 350, 170, 30);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Shfytëzuesi");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(560, 300, 80, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fjalëkalimi");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(560, 350, 70, 30);

        cmd_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        cmd_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_loginActionPerformed(evt);
            }
        });
        cmd_login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmd_loginKeyPressed(evt);
            }
        });
        getContentPane().add(cmd_login);
        cmd_login.setBounds(730, 400, 100, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/psd-blue-login-box.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(500, 200, 400, 300);

        Backround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backround.jpg"))); // NOI18N
        getContentPane().add(Backround);
        Backround.setBounds(0, -30, 1410, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void cmd_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_loginActionPerformed
        String user=txt_username.getText();
        try {
             item =ur.findByUsername(user,txt_password.getText());
            if(item !=null)
            {   
                    
                Menu m=new Menu();
                m.setVisible(true);
                m.PunetoriMenu.setVisible(true);
                dispose();
                        
            }    
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_cmd_loginActionPerformed

    private void cmd_loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmd_loginKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmd_loginKeyPressed

    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER)
         { 
           try {
             item =ur.findByUsername(txt_username.getText(),txt_password.getText());
                if(item !=null)
                {  
                        
                        
                            Menu m=new Menu();
                            m.setVisible(true);
                            m.PunetoriMenu.setVisible(true);
                            dispose();
                       
                }   
           
            }catch(Exception e)
            {
               JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_txt_passwordKeyPressed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Backround;
    private javax.swing.JButton cmd_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.jpg")));
    }

    

}