package presentacion;

import consultarPacientes.FConsultarPaciente;
import consultarPacientes.IConsultarPaciente;
import dtos.DatosFiscalesDTO;
import dtos.DetalleFacturaDTO;
import dtos.FacturaDTO;
import dtos.MedicoDTO;
import dtos.PacienteDTO;
import facturacion.FFacturacion;
import facturacion.IFacturacion;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * La clase FrmFacturacion representa un formulario para realizar la facturación de servicios médicos.
 */
public class FrmFacturacion extends javax.swing.JDialog {

    /**
     * Objeto para gestionar la consulta de pacientes
     */
    private IConsultarPaciente regPaciente;
    
    /**
     * Médico activo que está utilizando el formulario
     */
    private MedicoDTO medico;
    
    /**
     * Interfaz para realizar la facturación.
     */
    private IFacturacion facturacion;
    
    /**
     * Constructor de la clase FrmFacturacion.
     * @param parent El JFrame padre del diálogo.
     * @param modal Indica si el diálogo es modal o no.
     * @param medico El médico activo que está utilizando el formulario.
     */
    public FrmFacturacion(java.awt.Frame parent, boolean modal, MedicoDTO medico) {
        super(parent, modal);
        initComponents();
        this.regPaciente = new FConsultarPaciente();
        this.medico = medico;
        this.facturacion = new FFacturacion();
        txtFechaFactura.setEditable(false);
        txtRazonSocial.setEditable(false);
        txtRegimen.setEditable(false);
        txtDomicilio.setEditable(false);
        txtRFC.setEditable(false);
        txtFolioInterno.setEditable(false);
        txtImpuesto.setEditable(false);
        txtSubtotal.setEditable(false);
        txtTotal.setEditable(false);
        obtenerPacientesCbx();
        obtenerOtrosCmbx();
        obtenerFolioFechaFactura();
        
    }
    
    /**
     * Método que obtiene la lista de pacientes y los agrega al ComboBox de
     * pacientes.
     */
    private void obtenerPacientesCbx() {
        this.cbxPacientes.removeAllItems();
        this.cbxPacientes.addItem(null);
        for (PacienteDTO paciente : regPaciente.consultarPacientes()) {
            this.cbxPacientes.addItem(paciente);
        }
    }
    
    /**
     * Método privado para obtener otros elementos necesarios para el formulario.
     */
    private void obtenerOtrosCmbx(){
        
        this.cbxUsoCFDI.addItem(null);
        this.cbxUsoCFDI.addItem("D01. Honorarios médicos, dentales y gastos hospitalarios");
        this.cbxUsoCFDI.addItem("D02. Gastos medicos por incapacidad o discapacidad");
        this.cbxUsoCFDI.addItem("D07. Gastos de la prima de seguros de gastos médicos mayores");
        
        this.cbxMetodoPago.addItem(null);
        this.cbxMetodoPago.addItem("PUE. Pago de Una Sola Exhibición");
        this.cbxMetodoPago.addItem("PPD. Pago en Parcialidades o Diferidos");
        
        this.cbxFormaPago.addItem(null);
        this.cbxFormaPago.addItem("01. Efectivo");
        this.cbxFormaPago.addItem("02. Cheque nominativo");
        this.cbxFormaPago.addItem("03. Transferencia electronica de fondos");
        this.cbxFormaPago.addItem("04. Tarjeta de credito");
    }
    
    /**
     * Método privado para calcular el subtotal de la factura en la tabla.
     * @return El subtotal de la factura.
     */
    private Float calcularSubTotal() {
        float subTotal = 0;

        // Recorrer todas las filas de la tabla
        for (int i = 0; i < tblDetalleFactura.getRowCount(); i++) {
            // Obtener el valor de la celda de la séptima columna (índice 6) y sumarlo al subtotal
            Object totalObject = tblDetalleFactura.getValueAt(i, 6);
            if (totalObject != null) {
                subTotal += (float) totalObject;
            }
        }

        return subTotal;
    }

    /**
     * Método privado para calcular los totales de la factura.
     * @param subTotal El subtotal de la factura.
     */
    private void calcularTotales(Float subTotal) {
        txtSubtotal.setText(NumberFormat.getCurrencyInstance().format(subTotal));
        Float impuesto = subTotal * .1f;
        txtImpuesto.setText(NumberFormat.getCurrencyInstance().format(impuesto));
        Float total = subTotal - impuesto;
        txtTotal.setText(NumberFormat.getCurrencyInstance().format(total));
    }
    
    /**
     * Método privado para obtener los detalles de la factura.
     * @return Una lista de DetalleFacturaDTO con los detalles de la factura.
     */
    private List<DetalleFacturaDTO> obtenerDetalles() {
        List<DetalleFacturaDTO> detalles = new LinkedList<>();
        for (int i = 0; i < tblDetalleFactura.getRowCount(); i++) {
            // Obtener el valor de la celda de la séptima columna (índice 6) y sumarlo al subtotal
            Object cantidad = tblDetalleFactura.getValueAt(i, 0);
            Object unidad = tblDetalleFactura.getValueAt(i, 1);
            Object claveUnidad = tblDetalleFactura.getValueAt(i, 2);
            Object claveProducto = tblDetalleFactura.getValueAt(i, 3);
            Object descripcion = tblDetalleFactura.getValueAt(i, 4);
            Object valorUnitario = tblDetalleFactura.getValueAt(i, 5);
            Object importe = tblDetalleFactura.getValueAt(i, 6);
            if (cantidad != null && unidad != null && claveUnidad != null && claveProducto != null 
                    && descripcion != null && valorUnitario != null && importe != null) {
                DetalleFacturaDTO detalle = new DetalleFacturaDTO(
                        (Integer) cantidad, 
                        (String) unidad, 
                        (String) claveUnidad, 
                        (String) claveProducto, 
                        (String) descripcion, 
                        (Float) valorUnitario, 
                        (Float) importe);
                
                detalles.add(detalle);
            }
        }
        
        return detalles;
    }
    
    /**
     * Método privado para verificar los campos antes de realizar la facturación.
     * @return true si los campos están correctamente llenos, false en caso contrario.
     */
    private boolean verificacionesCampos(){

        if (this.cbxPacientes.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Seleccionar un receptor para la factura",
                        "Datos incompletos", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (this.cbxUsoCFDI.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Seleccionar un uso de CFDI para la factura",
                        "Datos incompletos", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (this.cbxMetodoPago.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Seleccionar un metodo de pago para la factura",
                        "Datos incompletos", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (this.cbxFormaPago.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Seleccionar una forma de pago para la factura",
                        "Datos incompletos", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (obtenerDetalles().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresar los datos de detalle de la factura",
                        "Datos incompletos", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
        return true;
        
    }
    
    /**
     * Método privado para convertir una cadena a un valor de punto flotante (float).
     * @param cadena La cadena a convertir.
     * @return El valor de punto flotante (float) obtenido.
     */
    private Float convertirStringAFloat(String cadena) {
        // Eliminar el símbolo de la moneda y los separadores de miles y decimales
        String cadenaLimpia = cadena.replaceAll("[^\\d.]", "");

        // Convertir la cadena a un valor flotante
        return Float.parseFloat(cadenaLimpia);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnFacturar = new javax.swing.JButton();
        cbxPacientes = new javax.swing.JComboBox<>();
        btnAgregarReceptor = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtFolioInterno = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtFechaFactura = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtRegimen = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtRFC = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtDomicilio = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        cbxUsoCFDI = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        cbxMetodoPago = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        cbxFormaPago = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtSubtotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalleFactura = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        txtImpuesto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("FACTURACION");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 50));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Fecha:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 40, -1));

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 90, 30));

        btnFacturar.setBackground(new java.awt.Color(204, 204, 204));
        btnFacturar.setText("Facturar");
        btnFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturarActionPerformed(evt);
            }
        });
        jPanel1.add(btnFacturar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, 90, 30));

        cbxPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPacientesActionPerformed(evt);
            }
        });
        jPanel1.add(cbxPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 180, -1));

        btnAgregarReceptor.setText("Agregar");
        btnAgregarReceptor.setBackground(new java.awt.Color(204, 204, 204));
        btnAgregarReceptor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarReceptorActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarReceptor, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 67, 80, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Regimen:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 80, -1));

        txtFolioInterno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtFolioInterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 90, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Folio:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 40, -1));

        txtFechaFactura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtFechaFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 100, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Receptor:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 70, -1));
        jPanel1.add(txtRegimen, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 650, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Razon Social:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 90, -1));
        jPanel1.add(txtRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 650, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Total:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 360, 90, -1));
        jPanel1.add(txtRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 650, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Domicilio:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 80, -1));
        jPanel1.add(txtDomicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 650, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("RFC:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 80, -1));
        jPanel1.add(cbxUsoCFDI, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 430, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Uso CFDI:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 70, -1));
        jPanel1.add(cbxMetodoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 430, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Metodo Pago:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 100, -1));
        jPanel1.add(cbxFormaPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 430, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Forma Pago:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 90, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Subtotal:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, 90, -1));

        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 360, 100, -1));

        txtSubtotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 320, 100, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tblDetalleFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cantidad", "Unidad", "ClaveUnidad", "ClaveProducto", "Descripcion", "ValorUnitario", "Importe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetalleFactura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tblDetalleFacturaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblDetalleFacturaFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(tblDetalleFactura);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 730, 70));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Impuestos:");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 90, -1));

        txtImpuesto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(txtImpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, 100, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 780, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Manejador de eventos para el botón de cancelar.
     * @param evt El evento que desencadena esta acción.
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * Manejador de eventos para el botón de facturar.
     * @param evt El evento que desencadena esta acción.
     */
    private void btnFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturarActionPerformed

        if (verificacionesCampos()) {
            Integer folioInterno = Integer.valueOf(txtFolioInterno.getText());
            Calendar fechaTimbrado = new GregorianCalendar();
            PacienteDTO paciente = cbxPacientes.getItemAt(cbxPacientes.getSelectedIndex());
            List<DetalleFacturaDTO> detalles = obtenerDetalles();
            String usoCFDI = cbxUsoCFDI.getItemAt(cbxUsoCFDI.getSelectedIndex());
            String formaPago = cbxFormaPago.getItemAt(cbxFormaPago.getSelectedIndex());
            String metodoPago = cbxMetodoPago.getItemAt(cbxMetodoPago.getSelectedIndex());
            Float subtotal = convertirStringAFloat(txtSubtotal.getText());
            Float impuesto = convertirStringAFloat(txtImpuesto.getText());
            Float total = convertirStringAFloat(txtTotal.getText());
            
            FacturaDTO facturaNueva = new FacturaDTO(
                    folioInterno, 
                    fechaTimbrado.getTime(), 
                    medico, 
                    paciente, 
                    detalles, 
                    usoCFDI, 
                    formaPago, 
                    metodoPago, 
                    subtotal, 
                    impuesto, 
                    total);
            
            FacturaDTO factura = facturacion.facturar(facturaNueva);
            if (factura != null) {
                JOptionPane.showMessageDialog(this, "Se ha timbrado la factura con folio: \n" + factura.getFolioFiscal() + "\nSe envio al correo: \n" + paciente.getCorreo(),
                        "Factura timbrada", JOptionPane.INFORMATION_MESSAGE);
            }
            dispose();
        }
    }//GEN-LAST:event_btnFacturarActionPerformed

    /**
     * Manejador de eventos para el ComboBox de pacientes.
     * @param evt El evento que desencadena esta acción.
     */
    private void cbxPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPacientesActionPerformed
        if (cbxPacientes.getSelectedItem() != null) {
            if (cbxPacientes.getItemAt(cbxPacientes.getSelectedIndex()).getDatosFiscales() != null) {
                PacienteDTO paciente = cbxPacientes.getItemAt(cbxPacientes.getSelectedIndex());
                txtRazonSocial.setText(paciente.getDatosFiscales().get(0).getRazonSocial());
                txtRFC.setText(paciente.getDatosFiscales().get(0).getRFC());
                // se junta la direccion
                StringBuilder direccion = new StringBuilder();
                direccion.append(paciente.getDatosFiscales().get(0).getCalle());
                direccion.append(" ");
                direccion.append(paciente.getDatosFiscales().get(0).getNumExterior());
                direccion.append(" ");
                direccion.append(paciente.getDatosFiscales().get(0).getColonia());
                direccion.append(" ");
                direccion.append(paciente.getDatosFiscales().get(0).getCodigoPostal());
                direccion.append(" ");
                direccion.append(paciente.getDatosFiscales().get(0).getCiudad());
                direccion.append(" ");
                direccion.append(paciente.getDatosFiscales().get(0).getMunicipio());
                direccion.append(" ");
                direccion.append(paciente.getDatosFiscales().get(0).getEstado());
                direccion.append(" ");
                String direccionCompleta = direccion.toString();
                txtDomicilio.setText(direccionCompleta);
                txtRegimen.setText(paciente.getDatosFiscales().get(0).getRegimenFiscal());
                btnAgregarReceptor.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "El paciente seleccionado requiere informacion para la emision de la factura, favor de capturarlos",
                        "Datos incompletos", JOptionPane.INFORMATION_MESSAGE);
                FrmDatosFiscales regReceptor = new FrmDatosFiscales(null, true, cbxPacientes.getItemAt(cbxPacientes.getSelectedIndex()), medico);
                this.dispose();
                regReceptor.setVisible(true);

            }
        } else {
            txtRazonSocial.setText("");
            txtRFC.setText("");
            txtDomicilio.setText("");
            txtRegimen.setText("");
            btnAgregarReceptor.setEnabled(true);
        }
    }//GEN-LAST:event_cbxPacientesActionPerformed

    /**
     * Método privado para obtener el folio y la fecha de la factura.
     */
    private void obtenerFolioFechaFactura(){
        // aqui se obtendria el folio y la fecha con persistencia
        Integer folioNuevo = facturacion.obtenerNuevoFolio(medico);
        txtFolioInterno.setText(folioNuevo.toString());    
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fechaActual.format(formato);
        txtFechaFactura.setText(fechaFormateada);
        
    }
    
    /**
     * Manejador de eventos para el botón de agregar receptor.
     * @param evt El evento que desencadena esta acción.
     */
    private void btnAgregarReceptorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarReceptorActionPerformed
        // TODO add your handling code here:
        if(cbxPacientes.getItemAt(cbxPacientes.getSelectedIndex()) != null){
        FrmDatosFiscales regReceptor = new FrmDatosFiscales(null, true, cbxPacientes.getItemAt(cbxPacientes.getSelectedIndex()), medico);
        this.dispose();
        regReceptor.setVisible(true);
        } else {
            FrmRegistrarPaciente frmRegistro = new FrmRegistrarPaciente(null, true, medico, null);
            this.dispose();
            frmRegistro.setVisible(true);
        }
    }//GEN-LAST:event_btnAgregarReceptorActionPerformed

    /**
     * Manejador de eventos cuando la tabla de detalle de factura gana el foco.
     * @param evt El evento que desencadena esta acción.
     */
    private void tblDetalleFacturaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblDetalleFacturaFocusGained
        // Obtener el índice de la fila seleccionada
    int filaSeleccionada = tblDetalleFactura.getSelectedRow();

    // Verificar si hay una fila seleccionada
    if (filaSeleccionada != -1) {
        // Obtener el valor de la cantidad (primera columna)
        Object cantidadObject = tblDetalleFactura.getValueAt(filaSeleccionada, 0);
        // Obtener el valor unitario (sexta columna)
        Object valorUnitarioObject = tblDetalleFactura.getValueAt(filaSeleccionada, 5);

        // Verificar si ambos valores no son nulos
        if (cantidadObject != null && valorUnitarioObject != null) {
            // Convertir los valores a los tipos correspondientes
            int cantidad = (int) cantidadObject;
            float valorUnitario = (float) valorUnitarioObject;

            // Verificar si la cantidad y el valor unitario son positivos
            if (cantidad >= 0 && valorUnitario >= 0) {
                // setea los otros campos una vez se ingresa la cantidad
                if (cantidad > 0) {
                    tblDetalleFactura.setValueAt("Servicio", filaSeleccionada, 1);
                    tblDetalleFactura.setValueAt("E48", filaSeleccionada, 2);
                    tblDetalleFactura.setValueAt("85121600", filaSeleccionada, 3);
                    tblDetalleFactura.setValueAt("Consulta Medica", filaSeleccionada, 4);
                }

                // Calcular el total
                float total = cantidad * valorUnitario;

                // Actualizar la celda correspondiente con el total calculado
                tblDetalleFactura.setValueAt(total, filaSeleccionada, 6);

                // Llamar al método para calcular los totales globales
                calcularTotales(calcularSubTotal());
            } else {
                // Mostrar un mensaje de error si la cantidad o el valor unitario son negativos
                tblDetalleFactura.setValueAt(null,filaSeleccionada, 0);
                tblDetalleFactura.setValueAt(null,filaSeleccionada, 1);
                tblDetalleFactura.setValueAt(null,filaSeleccionada, 2);
                tblDetalleFactura.setValueAt(null,filaSeleccionada, 3);
                tblDetalleFactura.setValueAt(null,filaSeleccionada, 4);
                tblDetalleFactura.setValueAt(null,filaSeleccionada, 5);
                JOptionPane.showMessageDialog(null, "La cantidad y el valor unitario deben ser valores positivos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    }//GEN-LAST:event_tblDetalleFacturaFocusGained

    /**
     * Manejador de eventos cuando la tabla de detalle de factura pierde el foco.
     * @param evt El evento que desencadena esta acción.
     */
    private void tblDetalleFacturaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblDetalleFacturaFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tblDetalleFacturaFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarReceptor;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFacturar;
    private javax.swing.JComboBox<String> cbxFormaPago;
    private javax.swing.JComboBox<String> cbxMetodoPago;
    private javax.swing.JComboBox<PacienteDTO> cbxPacientes;
    private javax.swing.JComboBox<String> cbxUsoCFDI;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDetalleFactura;
    private javax.swing.JTextField txtDomicilio;
    private javax.swing.JTextField txtFechaFactura;
    private javax.swing.JTextField txtFolioInterno;
    private javax.swing.JTextField txtImpuesto;
    private javax.swing.JTextField txtRFC;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtRegimen;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
