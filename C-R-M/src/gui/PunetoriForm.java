/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import Ejb.Departamenti;
import Ejb.Kontrata;
import Ejb.Punetori;
import Ejb.Users;
import bl.DepartamentiInterface;
import bl.DepartamentiRepository;
import bl.KontrataInterface;
import bl.KontrataRepository;
import bl.PunetoriInterface;
import bl.PunetoriRepository;
import bl.UsersException;
import bl.UsersInterface;
import bl.UsersRepository;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;
import model.ComboBoxModel.DepartamentiComboBoxModel;
import model.ComboBoxModel.KontrataComboBoxModel;
import model.ComboBoxModel.UsersComboBoxModel;
import models.TableModel.PunetoriTableModel;
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
public class PunetoriForm extends javax.swing.JInternalFrame {
    
    PunetoriInterface punetoriRepository=new PunetoriRepository();
    PunetoriTableModel punetoriTableModel=new PunetoriTableModel();
    UsersInterface usersRepository=new UsersRepository();
    UsersComboBoxModel usersComboBoxModel;
    DepartamentiInterface departamentiRepository=new DepartamentiRepository();
    DepartamentiComboBoxModel departamentiComboBoxModel;
    PunetoriRepository pr=new PunetoriRepository();
    Punetori item;
    KontrataInterface kontrataRepository=new KontrataRepository();
    KontrataComboBoxModel kontrataComboBoxModel;
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    RowFilter<PunetoriTableModel, Punetori> rf = null;
    TableRowSorter sorter = null;
 
    /**
     * Creates new form PunetoriForm
     */
    public PunetoriForm() {
        initComponents();
        comboBoxLoad();
        tabelaLoad();
       
    }
    
     private void comboBoxLoad()
    {
        List<Users> lista=usersRepository.findAll();
        usersComboBoxModel=new UsersComboBoxModel(lista);
        this.cmb_Username.setModel(usersComboBoxModel);
        
        List<Departamenti> lista2=departamentiRepository.findAll();
        departamentiComboBoxModel=new DepartamentiComboBoxModel(lista2);
        this.cmb_Departamenti.setModel(departamentiComboBoxModel);
        
        
        List<Kontrata> lista3=kontrataRepository.findAll();
        kontrataComboBoxModel=new KontrataComboBoxModel(lista3);
        this.cmb_Kontrata.setModel(kontrataComboBoxModel);
    }

    private void tabelaLoad()
    {
        List<Punetori> lista =punetoriRepository.findAll();
        punetoriTableModel.add(lista);
        tabela.setModel(punetoriTableModel);
        punetoriTableModel.fireTableDataChanged();
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
                    Punetori item = punetoriTableModel.getPunetori(selectedIndex);
                    txt_Emri.setText(item.getEmri());
                    txt_Mbiemri.setText(item.getMbiemri());
                    txt_Adresa.setText(item.getAdresa());
                    txt_Qyteti.setText(item.getQyteti());
                    txt_Telefoni.setText(item.getTelefoni()+"");  
                    cmb_Username.setSelectedItem(item.getUid());
                    cmb_Username.repaint();
                    cmb_Departamenti.setSelectedItem(item.getDid());
                    cmb_Departamenti.repaint();
                    cmb_Kontrata.setSelectedItem(item.getKontrataid());
                    cmb_Kontrata.repaint();
                }
            }
        });
    
    
    
    
    }
    
    public void emptyObject(){
        txt_Emri.setText("");
        txt_Mbiemri.setText("");
        txt_Adresa.setText("");
        txt_Qyteti.setText("");
        txt_Telefoni.setText("");
        cmb_Username.setSelectedItem(null);
        cmb_Username.repaint();
        cmb_Departamenti.setSelectedItem(null);
        cmb_Departamenti.repaint();
        cmb_Kontrata.setSelectedItem(null);
        cmb_Kontrata.repaint();
        tabela.clearSelection();  
        FilterId.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txt_Telefoni = new javax.swing.JTextField();
        txt_Mbiemri = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_Emri = new javax.swing.JTextField();
        cmb_Username = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_Adresa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_Qyteti = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmb_Departamenti = new javax.swing.JComboBox();
        cmb_Kontrata = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        btn_Cancel = new javax.swing.JButton();
        btn_Delete = new javax.swing.JButton();
        btn_Save = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        FilterId = new javax.swing.JTextField();

        jButton5.setText("jButton5");

        setClosable(true);
        setIconifiable(true);
        setTitle("Forma për regjistrimin e punëtorëve");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(1080, 600));
        setVisible(true);

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1049, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txt_Telefoni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_TelefoniKeyTyped(evt);
            }
        });

        txt_Mbiemri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_MbiemriKeyTyped(evt);
            }
        });

        jLabel4.setText("Adresa");

        txt_Emri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_EmriKeyTyped(evt);
            }
        });

        cmb_Username.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Shfrytezuesi");

        jLabel5.setText("Telefoni");

        jLabel2.setText("Emri");

        jLabel3.setText("Mbiemri");

        jLabel10.setText("Qyteti");

        jLabel6.setText("Departamenti");

        cmb_Departamenti.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_Departamenti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_DepartamentiActionPerformed(evt);
            }
        });

        cmb_Kontrata.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Kontrata");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Mbiemri, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Emri, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(txt_Adresa, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(txt_Telefoni, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_Qyteti)))
                .addGap(81, 81, 81)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmb_Username, 0, 125, Short.MAX_VALUE)
                    .addComponent(cmb_Departamenti, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_Kontrata, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_Adresa, txt_Qyteti, txt_Telefoni});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_Adresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(cmb_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_Qyteti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(cmb_Departamenti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_Emri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_Mbiemri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Telefoni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cmb_Kontrata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap())
        );

        btn_Cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-dialog-cancel-icon.png"))); // NOI18N
        btn_Cancel.setText("Anulo");
        btn_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelActionPerformed(evt);
            }
        });

        btn_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-edit-delete-icon.png"))); // NOI18N
        btn_Delete.setText("Fshije");
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });

        btn_Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save-icon.png"))); // NOI18N
        btn_Save.setText("Ruaj");
        btn_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SaveActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report-icon.png"))); // NOI18N
        jButton1.setText("Lista");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf-icon.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Excel-icon.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Word-icon.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Eksporto");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrimi sipas emrit"));

        FilterId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FilterIdKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(FilterId, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FilterId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(11, 11, 11)
                                        .addComponent(jButton3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 5, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(5, 5, 5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_Cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_Cancel, btn_Delete, btn_Save, jButton1});

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
            if( txt_Emri.getText()!=null && !txt_Emri.getText().equals("") && txt_Mbiemri.getText()!=null && !txt_Mbiemri.getText().equals("") && txt_Adresa.getText()!=null && !txt_Adresa.getText().equals("")&&txt_Qyteti.getText()!=null && !txt_Qyteti.getText().equals("") &&txt_Telefoni.getText()!=null && !txt_Telefoni.getText().equals("")&&cmb_Departamenti.getSelectedItem()!=null &&cmb_Kontrata.getSelectedItem()!=null){
                
                if(row == -1){
                    Punetori p=new Punetori();
                    p.setEmri(txt_Emri.getText());
                    p.setMbiemri(txt_Mbiemri.getText());
                    p.setAdresa(txt_Adresa.getText());
                    p.setQyteti(txt_Qyteti.getText());
                    p.setTelefoni(Integer.parseInt(txt_Telefoni.getText()));
                    p.setDid(departamentiComboBoxModel.getElementAt(cmb_Departamenti.getSelectedIndex()));
                    if(cmb_Username.getSelectedItem()!=null)
                    {    
                        p.setUid(usersComboBoxModel.getElementAt(cmb_Username.getSelectedIndex()));
                    }
                    if(cmb_Username.getSelectedItem()==null)
                    {
                         p.setUid(null);
                    }
                    p.setKontrataid(kontrataComboBoxModel.getElementAt(cmb_Kontrata.getSelectedIndex()));
                    punetoriRepository.create(p);
                    JOptionPane.showMessageDialog(this, "E dhëna u ruajt me sukses!");
                }
                else{
                    Punetori p=this.punetoriTableModel.getPunetori(row);
                    p.setEmri(txt_Emri.getText());
                    p.setMbiemri(txt_Mbiemri.getText());
                    p.setAdresa(txt_Adresa.getText());
                    p.setQyteti(txt_Qyteti.getText());
                    p.setTelefoni(Integer.parseInt(txt_Telefoni.getText()));
                    p.setDid(departamentiComboBoxModel.getElementAt(cmb_Departamenti.getSelectedIndex()));
                     if(cmb_Username.getSelectedItem()!=null)
                    {    
                        p.setUid(usersComboBoxModel.getElementAt(cmb_Username.getSelectedIndex()));
                    }
                    if(cmb_Username.getSelectedItem()==null)
                    {
                         p.setUid(null);
                    }
                    p.setKontrataid(kontrataComboBoxModel.getElementAt(cmb_Kontrata.getSelectedIndex()));
                    punetoriRepository.edit(p);
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
                    Punetori p=this.punetoriTableModel.getPunetori(row);
                    punetoriRepository.remove(p);
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
    public void jasper()
    {
         try{   
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CRM;user=loni;password=gramosi2");
            String report="C:\\Users\\Gramos\\Desktop\\Raporti\\Raportet\\report1.jrxml";
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
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       jasper();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
            try{   
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CRM;user=loni;password=gramosi2");
            String report="C:\\Users\\Gramos\\Desktop\\Raporti\\Raportet\\report1.jrxml";
            JasperReport jr=JasperCompileManager.compileReport(report);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,con);
            JasperExportManager.exportReportToPdfFile(jp,"C:\\Users\\Gramos\\Desktop\\Raporti\\Punetori.pdf");
        }catch(ClassNotFoundException | SQLException | JRException e)
        {
            JOptionPane.showMessageDialog(null,e);
        } 
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try{   
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CRM;user=loni;password=gramosi2");
            String report="C:\\Users\\Gramos\\Desktop\\Raporti\\Raportet\\report1.jrxml";
            JasperReport jr=JasperCompileManager.compileReport(report);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,con);
            JExcelApiExporter exporter = new JExcelApiExporter();

            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "C:\\Users\\Gramos\\Desktop\\Raporti\\Punetori.xls");
            exporter.exportReport();
        }catch(ClassNotFoundException | SQLException | JRException e)
        {
            JOptionPane.showMessageDialog(null,e);
        } 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         try{   
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CRM;user=loni;password=gramosi2");
            String report="C:\\Users\\Gramos\\Desktop\\Raporti\\Raportet\\report1.jrxml";
            JasperReport jr=JasperCompileManager.compileReport(report);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,con);
            JRDocxExporter exporter = new JRDocxExporter();

            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "C:\\Users\\Gramos\\Desktop\\Raporti\\Punetori.doc");
            exporter.exportReport();
        }catch(ClassNotFoundException | SQLException | JRException e)
        {
            JOptionPane.showMessageDialog(null,e);
        } 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cmb_DepartamentiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_DepartamentiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_DepartamentiActionPerformed

    private void txt_TelefoniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TelefoniKeyTyped
        char ch = evt.getKeyChar();
        
        if(ch< '0' || ch > '9' )
        {    
            evt.consume();
        }
    }//GEN-LAST:event_txt_TelefoniKeyTyped

    private void txt_EmriKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_EmriKeyTyped
        char ch = evt.getKeyChar();
       
        if (ch < 'a' || evt.getKeyCode() > 'Z'){
            evt.consume();
        }
    }//GEN-LAST:event_txt_EmriKeyTyped

    private void txt_MbiemriKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_MbiemriKeyTyped
        char ch = evt.getKeyChar();
       
        if (ch < 'a' || evt.getKeyCode() > 'Z'){
            evt.consume();
        }
    }//GEN-LAST:event_txt_MbiemriKeyTyped
    private void newFilter() {    
        sorter = new TableRowSorter<PunetoriTableModel>(punetoriTableModel);    
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
        newFilter();
    }//GEN-LAST:event_FilterIdKeyReleased

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FilterId;
    private javax.swing.JButton btn_Cancel;
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_Save;
    private javax.swing.JComboBox cmb_Departamenti;
    private javax.swing.JComboBox cmb_Kontrata;
    private javax.swing.JComboBox cmb_Username;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txt_Adresa;
    private javax.swing.JTextField txt_Emri;
    private javax.swing.JTextField txt_Mbiemri;
    private javax.swing.JTextField txt_Qyteti;
    private javax.swing.JTextField txt_Telefoni;
    // End of variables declaration//GEN-END:variables
}
