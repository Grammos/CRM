/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import Ejb.GrupiKlientav;
import Ejb.Klienti;
import Ejb.Oferta;
import Ejb.Oppertunities;
import bl.GrupiKlientavInterface;
import bl.GrupiKlientavRepository;
import bl.KlientiInterface;
import bl.KlientiRepository;
import bl.OfertaInterface;
import bl.OfertaRepository;
import bl.OpportunitiesInterface;
import bl.OpportunitiesRepository;
import bl.UsersException;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Frame;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;
import model.ComboBoxModel.GrupiKlientavComboBoxModel;
import model.ComboBoxModel.OfertaComboBoxModel;
import model.ComboBoxModel.OpportunitiesComboBoxModel;
import models.TableModel.KlientiTableModel;
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
public class KlientiForm extends javax.swing.JInternalFrame {

    KlientiInterface klientiRepository=new KlientiRepository();
    KlientiTableModel klientiTableModel=new KlientiTableModel();
    GrupiKlientavInterface grupiklientavrepository=new GrupiKlientavRepository();
    GrupiKlientavComboBoxModel grupiklientavComboBoxModel;
    OpportunitiesInterface oppertunitiesRepository=new OpportunitiesRepository();
    OpportunitiesComboBoxModel opportunitiesComboBoxModel;
    OfertaInterface ofertarepository=new OfertaRepository();
    OfertaComboBoxModel ofertaComboBoxModel;
    KlientiRepository kr=new KlientiRepository();
    Klienti item;
    
    RowFilter<KlientiTableModel, Klienti> rf = null;
    TableRowSorter sorter = null;
   
    /**
     * Creates new form KlientiForm
     */
    public KlientiForm() {
        initComponents();
        tabelaLoad();
        ComboBoxLoad();
    }
    
       
    public void ComboBoxLoad()
    {
        List<GrupiKlientav> lista=grupiklientavrepository.findAll();
        grupiklientavComboBoxModel=new GrupiKlientavComboBoxModel(lista);
        this.cmb_GrupiK.setModel(grupiklientavComboBoxModel);
        
        List<Oppertunities>lista1=oppertunitiesRepository.findAll();
        opportunitiesComboBoxModel=new OpportunitiesComboBoxModel(lista1);
        this.cmb_o.setModel(opportunitiesComboBoxModel);
        
        List <Oferta>lista2=ofertarepository.findAll();
        ofertaComboBoxModel=new OfertaComboBoxModel(lista2);
        this.cmb_Oferta.setModel(ofertaComboBoxModel);
    }
    public void tabelaLoad()
    {
        List<Klienti>lista=klientiRepository.findAll();
        klientiTableModel.add(lista);
        tabela.setModel(klientiTableModel);
        klientiTableModel.fireTableDataChanged();
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
                    Klienti item = klientiTableModel.getKlienti(selectedIndex);
                    txt_Emri.setText(item.getKEmri());
                    txt_Mbiemri.setText(item.getKMbiemri());
                    txt_Adresa.setText(item.getKAdresa());
                    txt_Email.setText(item.getEmail());
                    txt_Telefoni.setText(item.getTelefoni()+"");
                    cmb_GrupiK.setSelectedItem(item.getGKid());
                    cmb_GrupiK.repaint(); 
                    cmb_o.setSelectedItem(item.getOid());
                    cmb_o.repaint(); 
                    cmb_Oferta.setSelectedItem(item.getOferta());
                    cmb_Oferta.repaint();
                }
            }
        });
    
    }
    public void emptyObject()
    {
        txt_Emri.setText("");
        txt_Mbiemri.setText("");
        txt_Adresa.setText("");
        txt_Email.setText("");
        txt_Telefoni.setText("");
        cmb_GrupiK.setSelectedItem(null);
        cmb_GrupiK.repaint();
        cmb_o.setSelectedItem(null);
        cmb_o.repaint();
        cmb_Oferta.setSelectedItem(null);
        cmb_Oferta.repaint();
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

        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txt_Emri = new javax.swing.JTextField();
        txt_Mbiemri = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmb_GrupiK = new javax.swing.JComboBox();
        txt_Telefoni = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_Email = new javax.swing.JTextField();
        txt_Adresa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmb_o = new javax.swing.JComboBox();
        cmb_Oferta = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        btn_Save = new javax.swing.JButton();
        btn_Delete = new javax.swing.JButton();
        btn_Cancel = new javax.swing.JButton();
        btn_Raporti = new javax.swing.JButton();
        btn_Pdf = new javax.swing.JButton();
        btn_Excel = new javax.swing.JButton();
        btn_Word = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        FilterId = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Forma për regjstrimin e Klientëve");
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
        jScrollPane2.setViewportView(tabela);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txt_Emri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_EmriActionPerformed(evt);
            }
        });
        txt_Emri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_EmriKeyTyped(evt);
            }
        });

        txt_Mbiemri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_MbiemriKeyTyped(evt);
            }
        });

        jLabel7.setText("Grupi");

        jLabel5.setText("Email");

        cmb_GrupiK.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txt_Telefoni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_TelefoniKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_TelefoniKeyTyped(evt);
            }
        });

        jLabel3.setText("Mbiemri");

        jLabel4.setText("Adresa");

        jLabel6.setText("Telefoni");

        jLabel2.setText("Emri");

        jLabel8.setText("Opporutnities");

        cmb_Oferta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Oferta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_Emri)
                    .addComponent(txt_Mbiemri, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_Adresa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Telefoni, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(txt_Email))))
                .addGap(83, 83, 83)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmb_Oferta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_GrupiK, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_o, 0, 102, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_Adresa, txt_Email, txt_Telefoni});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel4))
                                    .addComponent(txt_Adresa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(cmb_o, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(cmb_GrupiK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txt_Telefoni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmb_Oferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Emri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_Mbiemri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        btn_Raporti.setText("Lista");
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

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Eksporto");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrimi sipas emrit"));
        jPanel2.setPreferredSize(new java.awt.Dimension(158, 50));

        FilterId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FilterIdKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FilterId, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(FilterId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton1.setText("Raporti");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Delete)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Cancel)
                        .addGap(66, 66, 66)
                        .addComponent(btn_Raporti, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_Pdf)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_Excel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_Word, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_Cancel, btn_Delete, btn_Save});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_Excel, btn_Pdf, btn_Word});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_Raporti, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_Cancel)
                                .addComponent(btn_Delete)
                                .addComponent(btn_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_Word, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Excel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Pdf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_Cancel, btn_Delete, btn_Excel, btn_Pdf, btn_Raporti, btn_Save, btn_Word});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelActionPerformed
        emptyObject();
    }//GEN-LAST:event_btn_CancelActionPerformed

    private void btn_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SaveActionPerformed
       try{
            int row = tabela.getSelectedRow();
            if (txt_Emri.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Ju lutem shkruani Emrin","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txt_Mbiemri.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Ju lutem shkruani Mbiemrin","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txt_Adresa.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Ju lutem shkruani Adresen","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txt_Email.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Ju lutem shkruani Emailin","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txt_Telefoni.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Ju lutem shkruani numrin e telefonit","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (cmb_GrupiK.getSelectedItem()==null) {
                JOptionPane.showMessageDialog( this, "Ju lutem zgjedhni grupin","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(txt_Emri.getText()!=null && !txt_Emri.getText().equals("") && txt_Mbiemri.getText()!=null && !txt_Mbiemri.getText().equals("") && txt_Adresa.getText()!=null && !txt_Adresa.getText().equals("")&& txt_Email.getText() !=null && !txt_Email.getText().equals("")&& txt_Telefoni.getText()!=null && !txt_Telefoni.getText().equals("")&& cmb_GrupiK.getSelectedItem()!=null  ){
                 if(row == -1){
                    Klienti k=new Klienti();                
                    k.setKEmri(txt_Emri.getText());
                    k.setKMbiemri(txt_Mbiemri.getText());
                    k.setEmail(txt_Email.getText());
                    k.setKAdresa(txt_Adresa.getText());
                    k.setTelefoni(txt_Telefoni.getText()+"");
                    k.setGKid(grupiklientavComboBoxModel.getElementAt(cmb_GrupiK.getSelectedIndex()));
                    if(cmb_o.getSelectedItem()!=null)
                    {    
                        k.setOid(opportunitiesComboBoxModel.getElementAt(cmb_o.getSelectedIndex()));
                    }
                    if(cmb_o.getSelectedItem()==null)
                    {
                        k.setOid(null);
                    }
                    if(cmb_Oferta.getSelectedItem()!=null)
                    {    
                        k.setOferta(ofertaComboBoxModel.getElementAt(cmb_Oferta.getSelectedIndex()));
                    }
                    if(cmb_Oferta.getSelectedItem()==null)
                    {
                        k.setOferta(null);
                    }
                    klientiRepository.create(k);
                    JOptionPane.showMessageDialog(this, "E dhëna u ruajt me sukses!");
                }
                else{
                    Klienti k=klientiTableModel.getKlienti(row);
                    k.setKEmri(txt_Emri.getText());
                    k.setKMbiemri(txt_Mbiemri.getText());
                    k.setEmail(txt_Email.getText());
                    k.setKAdresa(txt_Adresa.getText());
                    k.setTelefoni(txt_Telefoni.getText()+"");
                    k.setGKid(grupiklientavComboBoxModel.getElementAt(cmb_GrupiK.getSelectedIndex()));
                    if(cmb_o.getSelectedItem()!=null)
                    {    
                        k.setOid(opportunitiesComboBoxModel.getElementAt(cmb_o.getSelectedIndex()));
                    }
                    if(cmb_o.getSelectedItem()==null)
                    {
                        k.setOid(null);
                    }
                    
                    klientiRepository.edit(k);
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
        try{
            int row=tabela.getSelectedRow();
            if(row >-1)
            {   
                Object [] ob={"Po","Jo"};
                int i = javax.swing.JOptionPane.showOptionDialog(this, "A jeni i sigurt që doni ta fshini ?","",JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if(i==0)
                {   
                    Klienti p=this.klientiTableModel.getKlienti(row);
                    klientiRepository.remove(p);
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

    private void btn_RaportiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RaportiActionPerformed
         try{   
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CRM;user=loni;password=gramosi2");
            String report="C:\\Users\\Gramos\\Desktop\\Raporti\\Raportet\\report4.jrxml";
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

    private void btn_PdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PdfActionPerformed
         try{   
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CRM;user=loni;password=gramosi2");
            String report="C:\\Users\\Gramos\\Desktop\\Raporti\\Raportet\\report4.jrxml";
            JasperReport jr=JasperCompileManager.compileReport(report);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,con);
            JasperExportManager.exportReportToPdfFile(jp,"C:\\Users\\Gramos\\Desktop\\Raporti\\Klienti.pdf");
        }catch(ClassNotFoundException | SQLException | JRException e)
        {
            JOptionPane.showMessageDialog(null,e);
        } 
    }//GEN-LAST:event_btn_PdfActionPerformed

    private void btn_ExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExcelActionPerformed
        try{   
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CRM;user=loni;password=gramosi2");
            String report="C:\\Users\\Gramos\\Desktop\\Raporti\\Raportet\\report4.jrxml";
            JasperReport jr=JasperCompileManager.compileReport(report);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,con);
            JExcelApiExporter exporter = new JExcelApiExporter();

            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "C:\\Users\\Gramos\\Desktop\\Raporti\\Klienti.xls");
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
            String report="C:\\Users\\Gramos\\Desktop\\Raporti\\Raportet\\report4.jrxml";
            JasperReport jr=JasperCompileManager.compileReport(report);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,con);
            JRDocxExporter exporter = new JRDocxExporter();

            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "C:\\Users\\Gramos\\Desktop\\Raporti\\Klienti.doc");
            exporter.exportReport();
        }catch(ClassNotFoundException | SQLException | JRException e)
        {
            JOptionPane.showMessageDialog(null,e);
        } 
    }//GEN-LAST:event_btn_WordActionPerformed

    private void txt_EmriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_EmriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_EmriActionPerformed

    private void txt_TelefoniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TelefoniKeyPressed
        
    }//GEN-LAST:event_txt_TelefoniKeyPressed

    private void txt_TelefoniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TelefoniKeyTyped
        char ch = evt.getKeyChar();
        
        if(ch< '0' || ch > '9' )
        {    
            evt.consume();
        }
    }//GEN-LAST:event_txt_TelefoniKeyTyped

    private void txt_EmriKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_EmriKeyTyped
        char ch = evt.getKeyChar();
        if(evt.isShiftDown())
        {    
            return;
        }
        if (ch < 'a' || evt.getKeyCode() > 'Z'){
            evt.consume();
        }
    }//GEN-LAST:event_txt_EmriKeyTyped
    private void newFilter() {    
        sorter = new TableRowSorter<KlientiTableModel>(klientiTableModel);    
        tabela.setRowSorter(sorter);    
        try {
            rf = RowFilter.regexFilter(FilterId.getText(),1);
        } 
        catch(java.util.regex.PatternSyntaxException pe) {
            return;
        }
        sorter.setRowFilter(rf);   
    }
    private void txt_MbiemriKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_MbiemriKeyTyped
        char ch = evt.getKeyChar();
       
        if (ch < 'a' || evt.getKeyCode() > 'Z'){
            evt.consume();
        }
    }//GEN-LAST:event_txt_MbiemriKeyTyped

    private void FilterIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FilterIdKeyReleased
        newFilter();
    }//GEN-LAST:event_FilterIdKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String value2 = txt_Emri.getText();
        String value3 = txt_Mbiemri.getText();
        String value5= cmb_GrupiK.getSelectedItem().toString();
        String value7 = txt_Adresa.getText();
        String value8 = txt_Email.getText();
        String value9 = txt_Telefoni.getText();

        try{
            Document document = new Document(PageSize.A4.rotate()) {};
            PdfWriter.getInstance(document,new FileOutputStream("Raport-Klienti.pdf"));
            document.open();
            document.add(new Paragraph(new Date().toString()));
            document.add(new Paragraph(""));
            PdfPTable table = new PdfPTable(2);
            PdfPCell cell = new PdfPCell(new Paragraph("Profili i Klientit"));
            cell.setColspan(4);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            table.addCell("Emri");
            table.addCell(value2);
            table.addCell("Mbiemri");
            table.addCell(value3);
            table.addCell("Adresa");
            table.addCell(value7);
            table.addCell("Email");
            table.addCell(value8);
            table.addCell("Telefoni");
            table.addCell(value9);
            table.addCell("Grupi");
            table.addCell(value5);
            document.add(table);
            document.close();
            JOptionPane.showMessageDialog(null, "Raporti u ruajt");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FilterId;
    private javax.swing.JButton btn_Cancel;
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_Excel;
    private javax.swing.JButton btn_Pdf;
    private javax.swing.JButton btn_Raporti;
    private javax.swing.JButton btn_Save;
    private javax.swing.JButton btn_Word;
    private javax.swing.JComboBox cmb_GrupiK;
    private javax.swing.JComboBox cmb_Oferta;
    private javax.swing.JComboBox cmb_o;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txt_Adresa;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_Emri;
    private javax.swing.JTextField txt_Mbiemri;
    private javax.swing.JTextField txt_Telefoni;
    // End of variables declaration//GEN-END:variables
}
