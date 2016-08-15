/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import Ejb.GrupiProduktev;
import bl.GrupiProdukteveInterface;
import bl.GrupiProdukteveRepository;
import bl.UsersException;
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
import models.TableModel.GrupiProdukteveTableModel;
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
public class GrupiProdukteveForm extends javax.swing.JInternalFrame {
    GrupiProdukteveInterface grupiProdukteveRepository=new GrupiProdukteveRepository();
    GrupiProdukteveTableModel grupiProdukteveTableModel=new GrupiProdukteveTableModel();
    RowFilter<GrupiProdukteveTableModel, GrupiProduktev> rf = null;
    TableRowSorter sorter = null;
    /**
     * Creates new form GrupiProdukteveForm
     */
    public GrupiProdukteveForm() {
        initComponents();
        tabelaLoad();
        
    }
    
    public void tabelaLoad()
    {
        List<GrupiProduktev>list=grupiProdukteveRepository.findAll();
        grupiProdukteveTableModel.add(list);
        tabela.setModel(grupiProdukteveTableModel);
        grupiProdukteveTableModel.fireTableDataChanged();
        tabelaSelectedIndexChange();
    }
    
    public void  tabelaSelectedIndexChange()
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
                    GrupiProduktev item = grupiProdukteveTableModel.grupiProduktev(selectedIndex);
                    txt_Pershkrimi.setText(item.getPershkrimi());
                }
            }
        });
    }
    public void emptyObject()
    {
        txt_Pershkrimi.setText("");
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
        txt_Pershkrimi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_Lista = new javax.swing.JButton();
        btn_Pdf = new javax.swing.JButton();
        btn_Excel = new javax.swing.JButton();
        btn_Word = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        FilterId = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Forma për regjistrimin e grupit te produkteve");

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        txt_Pershkrimi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_PershkrimiKeyTyped(evt);
            }
        });

        jLabel2.setText("Pershkrimi i grupit");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txt_Pershkrimi, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Pershkrimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(17, Short.MAX_VALUE))
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

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrimi sipas emrit"));

        FilterId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FilterIdKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FilterIdKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FilterId, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FilterId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane1.setLayer(FilterId, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btn_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(btn_Lista, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btn_Pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Excel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Word, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_Delete)
                                .addComponent(btn_Cancel)
                                .addComponent(btn_Lista, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_Pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btn_Excel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Word, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_Cancel, btn_Delete, btn_Lista, btn_Save});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_Excel, btn_Pdf});

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
            if(txt_Pershkrimi.getText()!=null && !txt_Pershkrimi.getText().equals("")  ){
                if(row == -1){
                    GrupiProduktev gp=new GrupiProduktev();
                    gp.setPershkrimi(txt_Pershkrimi.getText());
                    grupiProdukteveRepository.create(gp);
                    JOptionPane.showMessageDialog(this, "E dhëna u ruajt me sukses!");
                }
                else{
                   GrupiProduktev gp=grupiProdukteveTableModel.grupiProduktev(row);
                    gp.setPershkrimi(txt_Pershkrimi.getText());
                    grupiProdukteveRepository.edit(gp);
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
                    GrupiProduktev p=this.grupiProdukteveTableModel.grupiProduktev(row);
                    grupiProdukteveRepository.remove(p);
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

    private void txt_PershkrimiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PershkrimiKeyTyped
        char ch = evt.getKeyChar();
       
        if (ch < 'a' || evt.getKeyCode() > 'Z'){
            evt.consume();
        }
    }//GEN-LAST:event_txt_PershkrimiKeyTyped

    private void btn_ListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ListaActionPerformed
        try{   
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CRM;user=loni;password=gramosi2");
            String report="C:\\Users\\Gramos\\Desktop\\Raporti\\Raportet\\report12.jrxml";
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
            String report="C:\\Users\\Gramos\\Desktop\\Raporti\\Raportet\\report12.jrxml";
            JasperReport jr=JasperCompileManager.compileReport(report);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,con);
            JasperExportManager.exportReportToPdfFile(jp,"C:\\Users\\Gramos\\Desktop\\Raporti\\GrupiProdukteve.pdf");
        }catch(ClassNotFoundException | SQLException | JRException e)
        {
            JOptionPane.showMessageDialog(null,e);
        } 
    }//GEN-LAST:event_btn_PdfActionPerformed

    private void btn_ExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExcelActionPerformed
      try{   
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CRM;user=loni;password=gramosi2");
            String report="C:\\Users\\Gramos\\Desktop\\Raporti\\Raportet\\report12.jrxml";
            JasperReport jr=JasperCompileManager.compileReport(report);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,con);
            JExcelApiExporter exporter = new JExcelApiExporter();

            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "C:\\Users\\Gramos\\Desktop\\Raporti\\GrupiProdukteve.xls");
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
            String report="C:\\Users\\Gramos\\Desktop\\Raporti\\Raportet\\report12.jrxml";
            JasperReport jr=JasperCompileManager.compileReport(report);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,con);
            JRDocxExporter exporter = new JRDocxExporter();

            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "C:\\Users\\Gramos\\Desktop\\Raporti\\GrupiProdukteve.doc");
            exporter.exportReport();
        }catch(ClassNotFoundException | SQLException | JRException e)
        {
            JOptionPane.showMessageDialog(null,e);
        } 
    }//GEN-LAST:event_btn_WordActionPerformed

    private void FilterIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FilterIdKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_FilterIdKeyTyped
    private void filteri() {    
        sorter = new TableRowSorter<GrupiProdukteveTableModel>(grupiProdukteveTableModel);    
        tabela.setRowSorter(sorter);    
        try {
            rf = RowFilter.regexFilter(FilterId.getText(),1);
        } 
        catch(java.util.regex.PatternSyntaxException pe) {
            return;
        }
        sorter.setRowFilter(rf);   
    }
    private void FilterIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FilterIdKeyReleased
        filteri();
    }//GEN-LAST:event_FilterIdKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FilterId;
    private javax.swing.JButton btn_Cancel;
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_Excel;
    private javax.swing.JButton btn_Lista;
    private javax.swing.JButton btn_Pdf;
    private javax.swing.JButton btn_Save;
    private javax.swing.JButton btn_Word;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txt_Pershkrimi;
    // End of variables declaration//GEN-END:variables

    
}
