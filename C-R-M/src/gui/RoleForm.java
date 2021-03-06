/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import Ejb.Forms;
import Ejb.Role;
import bl.FormsInterface;
import bl.FormsRepository;
import bl.RoleInterface;
import bl.RoleRepository;
import bl.UsersException;
import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.ComboBoxModel.FormsComboBoxModel;
import models.TableModel.RoleTableModel;

/**
 *
 * @author Gramos
 */
public class RoleForm extends javax.swing.JInternalFrame {

    RoleInterface rolerepository=new RoleRepository();
    RoleTableModel roleTableModel=new RoleTableModel();
    
    FormsInterface formsrepository=new FormsRepository();
    FormsComboBoxModel formsComboBoxModel;
    Role item;
    
    /**
     * Creates new form RoleForm
     */
    public RoleForm() {
        initComponents();
        comboBoxLoad();
        tabelaLoad();
    }
    
    private void comboBoxLoad()
    {
        List<Forms> list=formsrepository.findAll();
        formsComboBoxModel=new FormsComboBoxModel(list);
        this.cmb_Form.setModel(formsComboBoxModel);
        
    }
    private void tabelaLoad()
    {
        List<Role> lista=rolerepository.findAll();
        roleTableModel.add(lista);
        tabela.setModel(roleTableModel);
        roleTableModel.fireTableDataChanged();
        tabelaSelectedIndexChange();
    }
     private void tabelaSelectedIndexChange()
    {
        ListSelectionModel rowSM = tabela.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting())
                    return;
                ListSelectionModel rowSM = (ListSelectionModel)e.getSource();
                int selectedIndex = rowSM.getMinSelectionIndex();
                if(selectedIndex > -1){
                    Role item = roleTableModel.getRole(selectedIndex);
                    txt_Role.setText(item.getRoleName());
                    txt_Description.setText(item.getRoleDescripton());
                    cmb_Form.setSelectedItem(item.getFormsCollection().toArray(new Forms[0]));
                    cmb_Form.repaint(); 
  
                }
            }
        });
    }
     public void emptyObject()
    {
        txt_Role.setText("");
        txt_Description.setText("");
        cmb_Form.setSelectedItem(null);
        cmb_Form.repaint();
        tabela.clearSelection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btn_Save = new javax.swing.JButton();
        btn_Delete = new javax.swing.JButton();
        btn_Cancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cmb_Form = new javax.swing.JComboBox();
        txt_Description = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_Role = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txt_Search = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Forma për  regjistrimin e roleve");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btn_Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save-icon.png"))); // NOI18N
        btn_Save.setText("Ruaje");
        btn_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SaveActionPerformed(evt);
            }
        });

        btn_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-edit-delete-icon.png"))); // NOI18N
        btn_Delete.setText("Fshije");
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });

        btn_Cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-dialog-cancel-icon.png"))); // NOI18N
        btn_Cancel.setText("Anulo");
        btn_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel4.setText("Forma");

        cmb_Form.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txt_Description.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_DescriptionKeyTyped(evt);
            }
        });

        jLabel3.setText("Përshkrimi");

        txt_Role.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_RoleKeyTyped(evt);
            }
        });

        jLabel2.setText("Roli");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_Role, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Description, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_Form, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(268, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmb_Form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_Role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(txt_Description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Kërko"));

        txt_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_SearchKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Delete)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Cancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_Cancel, btn_Delete, btn_Save});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Cancel)
                            .addComponent(btn_Delete)
                            .addComponent(btn_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_Cancel, btn_Delete, btn_Save});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelActionPerformed
        // TODO add your handling code here:
        emptyObject();
    }//GEN-LAST:event_btn_CancelActionPerformed

    private void btn_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SaveActionPerformed
        // TODO add your handling code here:
         try{
            int row = tabela.getSelectedRow();
            if( txt_Role.getText()!=null && !txt_Role.getText().equals("") &&txt_Description.getText()!=null && !txt_Description.getText().equals("")&&  cmb_Form.getSelectedItem()!=null){
                if(row == -1){
                    Role r=new Role();
                    r.setRoleName(txt_Role.getText());
                    r.setRoleDescripton(txt_Description.getText());
                    Forms form=(formsComboBoxModel.getElementAt(cmb_Form.getSelectedIndex()));
                    r.getFormsCollection().add(form);
                    rolerepository.create(r);
                    JOptionPane.showMessageDialog(this, "E dhëna u ruajt me sukses!");
                }
                else{
                    Role r=roleTableModel.getRole(row);
                    r.setRoleName(txt_Role.getText());
                    r.setRoleDescripton(txt_Description.getText());
                    Forms form=(formsComboBoxModel.getElementAt(cmb_Form.getSelectedIndex()));
                    r.getFormsCollection().add(form);
                    rolerepository.edit(r);
                    JOptionPane.showMessageDialog(this, "E dhëna u editua me sukses!");
                }
                emptyObject();
                tabelaLoad();
            }
            else{
                JOptionPane.showMessageDialog(this, "Ju lutem plotësoni të gjitha fushat e detyrushme!");
            }
        }catch(UsersException re){
            JOptionPane.showMessageDialog(this, re.getMessage());

        }
    }//GEN-LAST:event_btn_SaveActionPerformed

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
        // TODO add your handling code here:
        try{
            int row=tabela.getSelectedRow();
            if(row >-1)
            {   
                Object [] ob={"Po","Jo"};
                int i = javax.swing.JOptionPane.showOptionDialog(this, "A jeni i sigurt që doni ta fshini ?","",JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if(i==0)
                {   
                    Role p=this.roleTableModel.getRole(row);
                    rolerepository.remove(p);
                    tabelaLoad();
                    emptyObject();
                    JOptionPane.showMessageDialog(this, "E dhëna është fshir me sukses!");
                }
                else{
                JOptionPane.showMessageDialog(this, "Nuk keni selektuar asgjë për të fshir!");
                }
            }
        
        }catch(UsersException ue)
        {
            JOptionPane.showMessageDialog(this, ue.getMessage());
        }
    }//GEN-LAST:event_btn_DeleteActionPerformed

    private void txt_SearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {   
            try
            {
                item=rolerepository.findByKEmri(txt_Search.getText());
                
                if(item!=null)
                { 
                        txt_Role.setText(item.getRoleName());
                        txt_Description.setText(item.getRoleDescripton());
                        cmb_Form.setSelectedItem(item.getFormsCollection());
                        cmb_Form.repaint();    
                }
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Nuk është gjetur shfytëzuesi me emrin e dhënë");
            }   
        }
    }//GEN-LAST:event_txt_SearchKeyPressed

    private void txt_RoleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_RoleKeyTyped
       char e = evt.getKeyChar();
        
        if(e < 'a' || e > 'Z'){
            evt.consume();
        }
    }//GEN-LAST:event_txt_RoleKeyTyped

    private void txt_DescriptionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_DescriptionKeyTyped
       char e = evt.getKeyChar();
        
        if(e < 'a' || e > 'Z'){
            evt.consume();
        }
    }//GEN-LAST:event_txt_DescriptionKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancel;
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_Save;
    private javax.swing.JComboBox cmb_Form;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txt_Description;
    private javax.swing.JTextField txt_Role;
    private javax.swing.JTextField txt_Search;
    // End of variables declaration//GEN-END:variables
}
