/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import Ejb.Qmimorja;
import bl.QmimorjaInterface;
import bl.QmimorjaRepository;
import bl.UsersException;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import models.TableModel.QmimorjaTableModel;
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
public class QmimorjaForm extends javax.swing.JInternalFrame {
    QmimorjaInterface qmimorjaRepository=new QmimorjaRepository();
    QmimorjaTableModel qmimorjaTableModel=new QmimorjaTableModel();
    
    /**
     * Creates new form QmimorjaForm
     */
    public QmimorjaForm() {
        initComponents();
        tabelaLoad();
    }

    public void tabelaLoad()
    {
        List<Qmimorja>list=qmimorjaRepository.findAll();
        qmimorjaTableModel.add(list);
        tabela.setModel(qmimorjaTableModel);
        qmimorjaTableModel.fireTableDataChanged();
        tabelaSelectedIndexChange();
    }
    
    public void tabelaSelectedIndexChange()
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
                    Qmimorja item = qmimorjaTableModel.getQmimorja(selectedIndex);
                    txt_Emri.setText(item.getEmri());
                    txt_Qmimi.setText(item.getQmimi()+"");     
                    
                }
            }
        });
    }
    
    public void emptyObject()
    {
        txt_Emri.setText("");
        txt_Qmimi.setText("");  
        tabela.clearSelection();
    }
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
        txt_Qmimi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_Emri = new javax.swing.JTextField();
        btn_Lista = new javax.swing.JButton();
        btn_Pdf = new javax.swing.JButton();
        btn_Excel = new javax.swing.JButton();
        btn_Word = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Forma për regjistrimin e qmimores");

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txt_Qmimi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_QmimiKeyTyped(evt);
            }
        });

        jLabel3.setText("Qmimi");

        jLabel2.setText("Emri");

        txt_Emri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_EmriKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_Emri, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txt_Qmimi, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Qmimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_Emri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        btn_Lista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report-icon.png"))); // NOI18N
        btn_Lista.setText("Lista");
        btn_Lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ListaActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(176, 176, 176)
                .addComponent(btn_Lista, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(btn_Pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Excel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Word, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Cancel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Word, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(btn_Excel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Pdf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Lista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_Cancel, btn_Delete});

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
            if( txt_Emri.getText()!=null && !txt_Emri.getText().equals("") && txt_Qmimi.getText()!=null && !txt_Qmimi.getText().equals("") ){
                if(row == -1){
                    Qmimorja q=new Qmimorja();
                    q.setEmri(txt_Emri.getText());
                    q.setQmimi(Integer.parseInt(txt_Qmimi.getText()));
                    qmimorjaRepository.create(q);
                    JOptionPane.showMessageDialog(this, "E dhëna u ruajt me sukses!");
                }
                else{
                   Qmimorja q=qmimorjaTableModel.getQmimorja(row);
                    q.setEmri(txt_Emri.getText());
                    q.setQmimi(Integer.parseInt(txt_Qmimi.getText()));
                    qmimorjaRepository.edit(q);
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
                    Qmimorja p=this.qmimorjaTableModel.getQmimorja(row);
                    qmimorjaRepository.remove(p);
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

    private void txt_QmimiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_QmimiKeyTyped
        char ch = evt.getKeyChar();
        
        if(ch< '0' || ch > '9' )
        {    
            evt.consume();
        }
    }//GEN-LAST:event_txt_QmimiKeyTyped

    private void txt_EmriKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_EmriKeyTyped
        char ch = evt.getKeyChar();
       
        if (ch < 'a' || evt.getKeyCode() > 'Z'){
            evt.consume();
        }
    }//GEN-LAST:event_txt_EmriKeyTyped

    private void btn_ListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ListaActionPerformed
        try{   
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CRM;user=loni;password=gramosi2");
            String report="C:\\Users\\Gramos\\Desktop\\Raporti\\Raportet\\report11.jrxml";
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
    }//GEN-LAST:event_btn_ListaActionPerformed

    private void btn_PdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PdfActionPerformed
        try{   
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CRM;user=loni;password=gramosi2");
            String report="C:\\Users\\Gramos\\Desktop\\Raporti\\Raportet\\report11.jrxml";
            JasperReport jr=JasperCompileManager.compileReport(report);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,con);
            JasperExportManager.exportReportToPdfFile(jp,"C:\\Users\\Gramos\\Desktop\\Raporti\\Qmimorja.pdf");
        }catch(ClassNotFoundException | SQLException | JRException e)
        {
            JOptionPane.showMessageDialog(null,e);
        } 
    }//GEN-LAST:event_btn_PdfActionPerformed

    private void btn_ExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExcelActionPerformed
       try{   
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CRM;user=loni;password=gramosi2");
            String report="C:\\Users\\Gramos\\Desktop\\Raporti\\Raportet\\report11.jrxml";
            JasperReport jr=JasperCompileManager.compileReport(report);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,con);
            JExcelApiExporter exporter = new JExcelApiExporter();

            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "C:\\Users\\Gramos\\Desktop\\Raporti\\Qmimorja.xls");
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
            String report="C:\\Users\\Gramos\\Desktop\\Raporti\\Raportet\\report11.jrxml";
            JasperReport jr=JasperCompileManager.compileReport(report);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,con);
            JRDocxExporter exporter = new JRDocxExporter();

            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "C:\\Users\\Gramos\\Desktop\\Raporti\\Qmimorja.doc");
            exporter.exportReport();
        }catch(ClassNotFoundException | SQLException | JRException e)
        {
            JOptionPane.showMessageDialog(null,e);
        } 
    }//GEN-LAST:event_btn_WordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancel;
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_Excel;
    private javax.swing.JButton btn_Lista;
    private javax.swing.JButton btn_Pdf;
    private javax.swing.JButton btn_Save;
    private javax.swing.JButton btn_Word;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txt_Emri;
    private javax.swing.JTextField txt_Qmimi;
    // End of variables declaration//GEN-END:variables
}
