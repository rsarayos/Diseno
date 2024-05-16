package presentacion;

import auxiliar.FiltrosJTextFields;
import auxiliares.Validadores;
import consultarPacientes.FConsultarPaciente;
import consultarPacientes.IConsultarPaciente;
import dtos.DatosFiscalesDTO;
import dtos.MedicoDTO;
import dtos.PacienteDTO;
import facturacion.FFacturacion;
import facturacion.IFacturacion;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * La clase FrmDatosFiscales representa un formulario para ingresar los datos fiscales de un paciente.
 */
public class FrmDatosFiscales extends javax.swing.JDialog {
    
    /**
     * El DTO del paciente.
     */
    private PacienteDTO paciente;
    
    /**
     * El DTO del médico.
     */
    private MedicoDTO medico;
    
    /**
     * El objeto FiltrosJTextFields para aplicar filtros a los campos de texto.
     */
    private FiltrosJTextFields filtro;
    
    /**
     * El objeto Validadores para validar los campos de texto.
     */
    private Validadores validador;
    
    /**
     * La interfaz IFacturacion para realizar la facturación.
     */
    private IFacturacion facturacion;
    
    /**
     * La interfaz IConsultarPaciente para consultar información del paciente.
     */
    private IConsultarPaciente consPacientes;

    /**
     * Constructor de la clase FrmDatosFiscales.
     * @param parent El JFrame padre del diálogo.
     * @param modal Indica si el diálogo es modal o no.
     * @param paciente El DTO del paciente.
     * @param medico El DTO del médico.
     */
    public FrmDatosFiscales(java.awt.Frame parent, boolean modal, PacienteDTO paciente, MedicoDTO medico) {
        super(parent, modal);
        initComponents();
        this.facturacion = new FFacturacion();
        this.consPacientes = new FConsultarPaciente();
        this.paciente = paciente;
        this.medico = medico;
        this.ComboRegimen();
        this.filtro  = new FiltrosJTextFields();
        this.validador = new Validadores();
        filtrarCampostxt();
    }
    
    /**
     * Método privado para llenar un combo con opciones de régimen fiscal.
     */
    private void ComboRegimen(){
        this.cbxRegimen.addItem(null);
        this.cbxRegimen.addItem("Régimen Simplificado de Confianza");
        this.cbxRegimen.addItem("Régimen de Sueldos y Salarios");
        this.cbxRegimen.addItem("Régimen de Servicios Profesionales");
        this.cbxRegimen.addItem("Régimen de Actividades Empresariales y Profesionales");
        this.cbxRegimen.addItem("Régimen de Incorporación Fiscal");
        this.cbxRegimen.addItem("General de Ley Personas Morales");
        
    }
    
    /**
     * Método privado para filtrar los campos de texto.
     */
    private void filtrarCampostxt(){
        this.txtRazonSocial.setDocument(filtro.filtroJTextLetrasNumeros());
        this.txtCalle.setDocument(filtro.filtroJTextLetrasNumeros());
        this.txtColonia.setDocument(filtro.filtroJTextLetrasNumeros());
        this.txtCiudad.setDocument(filtro.filtroJTextLetras());
        this.txtCodigoPostal.setDocument(filtro.filtroJTextNumeros());
        this.txtMunicipio.setDocument(filtro.filtroJTextLetras());
        this.txtEstado.setDocument(filtro.filtroJTextLetras());
        this.txtNumExterior.setDocument(filtro.filtroJTextNumeros());
        this.txtNumeroInterior.setDocument(filtro.filtroJTextNumeros());
        this.txtRFC.setDocument(filtro.filtroJTextLetrasNumerosCase());
    }
    
    /**
     * Método privado para validar que todos los campos estén completos.
     * @return true si todos los campos están completos, false en caso contrario.
     */
    private boolean validarCamposCompletos(){
        if (this.cbxRegimen.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Seleccionar un regimen fiscal",
                        "Datos incompletos", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (this.txtRazonSocial.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresar la Razon social",
                        "Datos incompletos", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (this.txtRFC.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresar el RFC",
                        "Datos incompletos", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (this.txtCalle.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresar la calle",
                        "Datos incompletos", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (this.txtColonia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresar la colonia",
                        "Datos incompletos", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (this.txtNumExterior.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresar el numero exterior",
                        "Datos incompletos", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (this.txtCodigoPostal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresar el codigo postal",
                        "Datos incompletos", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (this.txtCiudad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresar la ciudad",
                        "Datos incompletos", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (this.txtMunicipio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresar el municipio",
                        "Datos incompletos", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (this.txtEstado.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresar el estado",
                        "Datos incompletos", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (!validador.validaRFC(txtRFC.getText())) {
            JOptionPane.showMessageDialog(this, "El RFC es invalido: AAAA000000AAA",
                        "Datos incompletos", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else {
            PacienteDTO rfcRegistrado = facturacion.buscarRFCExistente(txtRFC.getText());
            if (rfcRegistrado != null) {
                JOptionPane.showMessageDialog(this, "El RFC ya se encuentra registrado",
                        "Datos incompletos", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        }

        return true;

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
        jLabel4 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtRFC = new javax.swing.JTextField();
        txtCalle = new javax.swing.JTextField();
        txtColonia = new javax.swing.JTextField();
        txtNumExterior = new javax.swing.JTextField();
        txtNumeroInterior = new javax.swing.JTextField();
        txtCodigoPostal = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();
        txtMunicipio = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbxRegimen = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DATOS FISCALES");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 50));

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, 90, 30));

        btnConfirmar.setBackground(new java.awt.Color(204, 204, 204));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 90, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Razon Social:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 120, 30));

        txtRazonSocial.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 410, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Regimen Fiscal:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 120, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("RFC:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 120, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Calle:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 120, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Colonia:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 120, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Numero ext:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 120, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Numero int:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 120, 30));

        txtRFC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 410, -1));

        txtCalle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 410, -1));

        txtColonia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 410, -1));

        txtNumExterior.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtNumExterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 410, -1));

        txtNumeroInterior.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtNumeroInterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 410, -1));

        txtCodigoPostal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtCodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 410, -1));

        txtCiudad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 410, -1));

        txtMunicipio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtMunicipio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 410, -1));

        txtEstado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 410, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Codigo postal:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 120, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Ciudad:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 120, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Municipio:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 120, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Estado:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 120, 30));
        jPanel1.add(cbxRegimen, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 410, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 450));

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
     * Manejador de eventos para el botón de confirmar.
     * @param evt El evento que desencadena esta acción.
     */
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if (validarCamposCompletos()) {
            
            String razonSocial = txtRazonSocial.getText();
            String regimenFiscal = cbxRegimen.getItemAt(cbxRegimen.getSelectedIndex());
            String rfc = txtRFC.getText();
            String calle = txtCalle.getText();
            String colonia = txtColonia.getText();
            String numExterior = txtNumExterior.getText();
            String numInterior = txtNumeroInterior.getText();
            String codigoPostal = txtCodigoPostal.getText();
            String ciudad = txtCiudad.getText();
            String municipio = txtMunicipio.getText();
            String estado = txtEstado.getText();
            
            if (this.paciente == null) {
                DatosFiscalesDTO datos = new DatosFiscalesDTO(
                        razonSocial, 
                        regimenFiscal, 
                        rfc, 
                        calle, 
                        colonia, 
                        numExterior, 
                        numInterior, 
                        codigoPostal, 
                        ciudad, 
                        municipio, 
                        estado);
                List<DatosFiscalesDTO> datosFiscales = new LinkedList<>();
                datosFiscales.add(datos);
                this.medico.setDatosFiscales(datosFiscales);
                
                MedicoDTO resultado = this.facturacion.registrarDatosFiscalesMedico(medico);
                
                if (resultado != null) {
                    JOptionPane.showMessageDialog(this, "Se registraron los datos del medico",
                        "Registro", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se registraron los datos del medico",
                            "Error", JOptionPane.INFORMATION_MESSAGE);
                }
                
                FrmFacturacion frmFacturacion = new FrmFacturacion(null, true, medico);
                this.dispose();
                frmFacturacion.setVisible(true);
                
            } else {
                DatosFiscalesDTO datos = new DatosFiscalesDTO(
                        razonSocial, 
                        regimenFiscal, 
                        rfc, 
                        calle, 
                        colonia, 
                        numExterior, 
                        numInterior, 
                        codigoPostal, 
                        ciudad, 
                        municipio, 
                        estado);
                List<DatosFiscalesDTO> datosFiscales = new LinkedList<>();
                datosFiscales.add(datos);
                this.paciente.setDatosFiscales(datosFiscales);
                
                PacienteDTO resultado = this.facturacion.registrarDatosFiscalesPaciente(paciente);
                
                if (resultado != null) {
                    JOptionPane.showMessageDialog(this, "Se registraron los datos del paciente",
                            "Registro", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se registraron los datos del paciente",
                            "Error", JOptionPane.INFORMATION_MESSAGE);
                }
                
                FrmFacturacion frmFacturacion = new FrmFacturacion(null, true, medico);
                this.dispose();
                frmFacturacion.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<String> cbxRegimen;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtCodigoPostal;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtNumExterior;
    private javax.swing.JTextField txtNumeroInterior;
    private javax.swing.JTextField txtRFC;
    private javax.swing.JTextField txtRazonSocial;
    // End of variables declaration//GEN-END:variables
}
