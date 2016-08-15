/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import Ejb.Role;
import Ejb.Users;
import bl.RoleInterface;
import bl.RoleRepository;
import bl.UsersException;
import bl.UsersInterface;
import bl.UsersRepository;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;
import model.ComboBoxModel.RoleComboBoxModel;
import models.TableModel.RoleTableModel;
import models.TableModel.UsersTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author Gramos
 */
public class UsersForm extends javax.swing.JInternalFrame {

    UsersInterface usersRepository=new UsersRepository();
    UsersTableModel usersTableModel=new UsersTableModel();
    RoleInterface roleRepository=new RoleRepository();
    RoleTableModel roletableModel=new RoleTableModel();
    RoleComboBoxModel roleComboBoxModel;
    UsersRepository ur=new UsersRepository();
    Users item;
    RowFilter<UsersTableModel, Users> rf = null;
    TableRowSorter sorter = null;
    /**
     * Creates new form UsersForm
     */
    public UsersForm() {
        initComponents();
        tabelaLoad();
        comboBoxLoad();
    }
    
    private void comboBoxLoad()
    {
        List<Role> lista=roleRepository.findAll();
        roleComboBoxModel=new RoleComboBoxModel(lista);
        this.cmbRole.setModel(roleComboBoxModel);
    }

    private void tabelaLoad()
    {
        List<Users> lista =usersRepository.findAll();
        usersTableModel.add(lista);
        tabela.setModel(usersTableModel);
        usersTableModel.fireTableDataChanged();
        tabelaSelectedIndexChange();
    }
    private void tabelaSelectedIndexChange(){
        ListSelectionModel rowSM = tabela.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting())
                    return;
                ListSelectionModel rowSM = (ListSelectionModel)e.getSource();
                int selectedIndex = rowSM.getMinSelectionIndex();
                if(selectedIndex > -1){
                    Users item = usersTableModel.getUsers(selectedIndex);
                    txt_username.setText(item.getShfrytezuesi());
                    txt_password.setText(item.getFjalekalimi());
                    cmbRole.setSelectedItem(item.getRoleid());
                    cmbRole.repaint();    
                }
            }
        });
   }
    public void emptyObject(){
        txt_username.setText("");
        txt_password.setText("");
        cmbRole.setSelectedItem(null);
        cmbRole.repaint();
        tabela.clearSelection();   
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        ScrollPane = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        cmbRole = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_Save = new javax.swing.JButton();
        btn_Delete = new javax.swing.JButton();
        btn_Cancel = new javax.swing.JButton();
        btn_Raporti = new javax.swing.JButton();
        btn_Pdf = new javax.swing.JButton();
        btn_Excel = new javax.swing.JButton();
        btn_Word = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        FilterId = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Forma për regjistrimin e përdoruesve");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(1080, 600));

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
        ScrollPane.setViewportView(tabela);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(ScrollPane)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        cmbRole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRoleActionPerformed(evt);
            }
        });

        jLabel3.setText("Fjalekalimi");

        txt_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_usernameKeyTyped(evt);
            }
        });

        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_passwordKeyTyped(evt);
            }
        });

        jLabel2.setText("Shfytezuesi");

        jLabel4.setText("Roli");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        btn_Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save-icon.png"))); // NOI18N
        btn_Save.setText("Ruaj");
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

        btn_Raporti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report-icon.png"))); // NOI18N
        btn_Raporti.setText("Raporti");
        btn_Raporti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RaportiActionPerformed(evt);
            }
        });

        btn_Pdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf-icon.png"))); // NOI18N
        btn_Pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PdfActionPerformed(evt);
            }
        });

        btn_Excel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Excel-icon.png"))); // NOI18N
        btn_Excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExcelActionPerformed(evt);
            }
        });

        btn_Word.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Word-icon.png"))); // NOI18N
        btn_Word.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_WordActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Eksporto");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrimi sipas emrit"));
        jPanel3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel3KeyReleased(evt);
            }
        });

        FilterId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FilterIdKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FilterId, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FilterId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btn_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(btn_Raporti, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_Pdf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addComponent(btn_Excel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Word)
                .addGap(200, 200, 200)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_Cancel, btn_Delete, btn_Save});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_Excel, btn_Pdf, btn_Word});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_Raporti, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_Cancel)
                                .addComponent(btn_Delete)
                                .addComponent(btn_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_Excel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Word))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 25, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_Cancel, btn_Delete, btn_Raporti, btn_Save});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_Excel, btn_Pdf, btn_Word});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelActionPerformed
        // TODO add your handling code here:
        emptyObject();
    }//GEN-LAST:event_btn_CancelActionPerformed

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
        // TODO add your handling code here:
       try{
            int row=tabela.getSelectedRow();
            if(row > -1){
                 Object[] ob = {"Po","Jo"};
                int i = javax.swing.JOptionPane.showOptionDialog(this, "A jeni i sigurt që doni ta fshini ?","",JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if(i==0)
                {
                    Users item=this.usersTableModel.getUsers(row);
                    usersRepository.remove(item);
                    tabelaLoad();
                    emptyObject();
                    JOptionPane.showMessageDialog(this, "E dhëna është fshir me sukses!");
                }
            }

            else
            JOptionPane.showMessageDialog(this, "Nuk keni selektuar asgjë për të fshir!");

        }catch(UsersException ue)
        {
            JOptionPane.showMessageDialog(this, ue.getMessage());
        }
    }//GEN-LAST:event_btn_DeleteActionPerformed

    public void valido()
    {
        for(int i=0; i < usersTableModel.getRowCount(); i++){
            Role role = roletableModel.getRole(i); 
        }
    }

    private void btn_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SaveActionPerformed
        // TODO add your handling code here:
        try{
            int row = tabela.getSelectedRow();
            if(txt_username.getText()!=null && !txt_username.getText().equals("") && txt_password.getText()!=null && !txt_password.getText().equals("") && cmbRole.getSelectedItem()!=null ){
                if(row == -1){
                    Users u=new Users();
                    u.setShfrytezuesi(txt_username.getText());
                    if(txt_password.getText().length()>6)
                    {
                       u.setFjalekalimi(txt_password.getText());
                    }
                    else {
                        JOptionPane.showMessageDialog(this, "Fjalekalimi duhet te jete me i gjate se  6 karaktere");
                        return;
                    }
                    u.setRoleid(roleComboBoxModel.getElementAt(cmbRole.getSelectedIndex()));
                    usersRepository.create(u);
                    JOptionPane.showMessageDialog(this, "E dhëna u ruajt me sukses!");
                }
                else{
                    Users u=this.usersTableModel.getUsers(row);
                    u.setShfrytezuesi(txt_username.getText());
                    if(txt_password.getText().length()>6)
                    {
                         u.setFjalekalimi(txt_password.getText());
                    }
                    else {
                        JOptionPane.showMessageDialog(this, "Fjalekalimi duhet te jete me i gjate se  6 karaktere");
                        return;
                    }
                    u.setRoleid(roleComboBoxModel.getElementAt(cmbRole.getSelectedIndex()));
                    usersRepository.edit(u);
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

    private void cmbRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRoleActionPerformed
    
    private void btn_PdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PdfActionPerformed
        // TODO add your handling code here:
         try{   
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CRM;user=loni;password=gramosi2");
            String report="C:\\Users\\Gramos\\Desktop\\Raporti\\Raportet\\report3.jrxml";
            JasperReport jr=JasperCompileManager.compileReport(report);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,con);
            JasperExportManager.exportReportToPdfFile(jp,"C:\\Users\\Gramos\\Desktop\\Raporti\\Shfrytezuesit.pdf");
        }catch(ClassNotFoundException | SQLException | JRException e)
        {
            JOptionPane.showMessageDialog(null,e);
        } 
    }//GEN-LAST:event_btn_PdfActionPerformed

    private void btn_RaportiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RaportiActionPerformed
        // TODO add your handling code here:
        try{   
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CRM;user=loni;password=gramosi2");
            String report="C:\\Users\\Gramos\\Desktop\\Raporti\\Raportet\\report3.jrxml";
            JasperReport jr=JasperCompileManager.compileReport(report);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,con);
            
            JFrame frame = new JFrame("Raporti");
            frame.setExtendedState(Frame.MAXIMIZED_BOTH); 
            frame.getContentPane().add(new JRViewer(jp));
            frame.pack();
            frame.setVisible(true);
        }catch(ClassNotFoundException | SQLException | JRException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }   
    }//GEN-LAST:event_btn_RaportiActionPerformed

    private void btn_ExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExcelActionPerformed
        // TODO add your handling code here:
        try{   
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CRM;user=loni;password=gramosi2");
            String report="C:\\Users\\Gramos\\Desktop\\Raporti\\Raportet\\report3.jrxml";
            JasperReport jr=JasperCompileManager.compileReport(report);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,con);
            JExcelApiExporter exporter = new JExcelApiExporter();

            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "C:\\Users\\Gramos\\Desktop\\Raporti\\Shfrytezuesit.xls");
            exporter.exportReport();
        }catch(ClassNotFoundException | SQLException | JRException e)
        {
            JOptionPane.showMessageDialog(null,e);
        } 
    }//GEN-LAST:event_btn_ExcelActionPerformed

    private void btn_WordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_WordActionPerformed
        try{   
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CRM;user=loni;password=gramosi2");
            String report="C:\\Users\\Gramos\\Desktop\\Raporti\\Raportet\\report3.jrxml";
            JasperReport jr=JasperCompileManager.compileReport(report);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,con);
            JRDocxExporter exporter = new JRDocxExporter();

            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "C:\\Users\\Gramos\\Desktop\\Raporti\\Shfrytezuesit.doc");
            exporter.exportReport();
        }catch(ClassNotFoundException | SQLException | JRException e)
        {
            JOptionPane.showMessageDialog(null,e);
        } 
    }//GEN-LAST:event_btn_WordActionPerformed

    private void txt_usernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usernameKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameKeyTyped

    private void txt_passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyTyped
        
    }//GEN-LAST:event_txt_passwordKeyTyped

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
       
    }//GEN-LAST:event_txt_passwordActionPerformed
    private void Filteri() {    
        sorter = new TableRowSorter<UsersTableModel>(usersTableModel);    
        tabela.setRowSorter(sorter);    
        try {
            rf = RowFilter.regexFilter(FilterId.getText(),1);
        } 
        catch(java.util.regex.PatternSyntaxException pe) {
            return;
        }
        sorter.setRowFilter(rf);   
    }
    private void jPanel3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel3KeyReleased
        
    }//GEN-LAST:event_jPanel3KeyReleased

    private void FilterIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FilterIdKeyReleased
      Filteri();
    }//GEN-LAST:event_FilterIdKeyReleased
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FilterId;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JButton btn_Cancel;
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_Excel;
    private javax.swing.JButton btn_Pdf;
    private javax.swing.JButton btn_Raporti;
    private javax.swing.JButton btn_Save;
    private javax.swing.JButton btn_Word;
    public javax.swing.JComboBox cmbRole;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
