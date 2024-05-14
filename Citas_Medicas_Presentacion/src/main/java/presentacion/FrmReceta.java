/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import com.itextpdf.io.IOException;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.kernel.colors.DeviceCmyk;
import java.awt.Desktop;
import java.io.File;
import dtos.RecetaDTO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Serva
 */
public class FrmReceta extends javax.swing.JFrame {

    /**
     * Creates new form FrmReceta
     */
    public FrmReceta() {
        initComponents();
        tabla();
    }

    public static void actualizarTabla(RecetaDTO receta) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tblReceta.getModel();
        modeloTabla.addRow(new Object[]{receta.getMedicamento(), receta.getDosis()});
    }

    public void tabla() {
        tblReceta.setDefaultRenderer(Object.class, new RenderTabla());

        DefaultTableModel modeloTabla = new DefaultTableModel();
        tblReceta.setModel(modeloTabla);

        tblReceta.setRowHeight(40);

        // Definición de las columnas y sus encabezados
        String[] encabezados = {"Medicamento", "Dosis"};
        modeloTabla.setColumnIdentifiers(encabezados);

        // Configuración del ancho preferido de las columnas
        int[] anchos = {200, 100}; // Ajusta los anchos según tus preferencias
        for (int i = 0; i < anchos.length; i++) {
            tblReceta.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }

    public void mostrarRecetas(List<RecetaDTO> recetas) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tblReceta.getModel();
        modeloTabla.setRowCount(0); // Limpia la tabla antes de cargar los nuevos datos

        // Itera sobre la lista de recetas y agrega cada receta a la tabla
        for (RecetaDTO receta : recetas) {
            Object[] fila = {receta.getMedicamento(), receta.getDosis()};
            modeloTabla.addRow(fila);
        }
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
        btnRegresar = new javax.swing.JButton();
        btnAgregarMedicamento = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReceta = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnRegresar.setBackground(new java.awt.Color(204, 204, 204));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnAgregarMedicamento.setBackground(new java.awt.Color(204, 204, 204));
        btnAgregarMedicamento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAgregarMedicamento.setText("Agregar Medicamento");
        btnAgregarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMedicamentoActionPerformed(evt);
            }
        });

        btnPDF.setBackground(new java.awt.Color(204, 204, 204));
        btnPDF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPDF.setText("Generar PDF");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });

        tblReceta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblReceta.setToolTipText("");
        jScrollPane1.setViewportView(tblReceta);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRegresar)
                        .addGap(18, 18, 18)
                        .addComponent(btnPDF)
                        .addGap(41, 41, 41)
                        .addComponent(btnAgregarMedicamento)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarMedicamento)
                    .addComponent(btnPDF)
                    .addComponent(btnRegresar))
                .addGap(100, 100, 100))
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RECETA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose(); // Cierra el formulario actual
        if (this.getParent() instanceof FrmMenuPrincipal) {
            FrmMenuPrincipal menuPrincipal = (FrmMenuPrincipal) this.getParent();
            menuPrincipal.setVisible(true); // Muestra el formulario padre
        } else {
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAgregarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMedicamentoActionPerformed
        FrmMedicamento frmMedicamento = new FrmMedicamento();
        frmMedicamento.setVisible(true);
    }//GEN-LAST:event_btnAgregarMedicamentoActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        try {
            // Definir el nombre del archivo PDF
            String pdfFilePath = "receta.pdf";

            // Crear un nuevo documento PDF
            PdfWriter writer = new PdfWriter(pdfFilePath);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            // Agregar el título
            document.add(new Paragraph("RECETA")
                    .setFont(PdfFontFactory.createFont())
                    .setFontSize(24)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setMarginBottom(20));

            // Crear una tabla iText a partir de la tabla Swing (jTable)
            Table table = new Table(tblReceta.getColumnCount());
            for (int i = 0; i < tblReceta.getColumnCount(); i++) {
                table.addCell(new Cell().add(new Paragraph(tblReceta.getColumnName(i)))
                        .setBackgroundColor(DeviceCmyk.CYAN)
                        .setTextAlignment(TextAlignment.CENTER));
            }
            for (int row = 0; row < tblReceta.getRowCount(); row++) {
                for (int column = 0; column < tblReceta.getColumnCount(); column++) {
                    table.addCell(new Cell().add(new Paragraph(tblReceta.getValueAt(row, column).toString()))
                            .setTextAlignment(TextAlignment.CENTER));
                }
            }

            // Agregar la tabla al documento
            document.add(table);

            // Agregar el lugar para la firma
            document.add(new Paragraph("\n\n\n\n\n\n\n\n\n\nFirma del médico: ____________________")
                    .setFont(PdfFontFactory.createFont())
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.CENTER));

            // Cerrar el documento
            document.close();

            // Abrir el archivo PDF generado
            File file = new File(pdfFilePath);
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            }

        } catch (IOException | java.io.IOException ex) {
        }
    }//GEN-LAST:event_btnPDFActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarMedicamento;
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tblReceta;
    // End of variables declaration//GEN-END:variables
}
