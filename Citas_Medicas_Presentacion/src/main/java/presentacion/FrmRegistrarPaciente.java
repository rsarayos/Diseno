package presentacion;

import auxiliar.FiltrosJTextFields;
import auxiliares.Validadores;
import consultarPacientes.FConsultarPaciente;
import consultarPacientes.IConsultarPaciente;
import dtos.MedicoDTO;
import dtos.PacienteDTO;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import registrarPaciente.IRegistrarPaciente;
import registrarPaciente.FRegistrarPaciente;

/**
 * Clase que representa el formulario para registrar nuevos pacientes.
 */
public class FrmRegistrarPaciente extends javax.swing.JDialog {
    
    /**
     * Objeto para gestionar el registro de pacientes
     */
    private IRegistrarPaciente registro;
    
    /**
     * Objeto para gestionar la consulta de pacientes
     */
    private IConsultarPaciente regPacientes;
    
    /**
     * Medico activo en la consulta
     */
    private MedicoDTO medico;
    
    /**
     * Formulario de citas médicas
     */
    private FrmCitas frmCitas;
    
    /**
     * Filtros para los campos de texto
     */
    private FiltrosJTextFields filtro;
    
    /**
     * Constructor de la clase FrmRegistrarPaciente.
     * @param parent Componente padre del formulario.
     * @param modal Indica si el diálogo es modal.
     * @param frmCitas Formulario FrmCitas asociado.
     */
    public FrmRegistrarPaciente(java.awt.Frame parent, boolean modal, MedicoDTO medico, FrmCitas frmCitas) {
        super(parent, modal);
        initComponents();
        this.registro = new FRegistrarPaciente();
        this.regPacientes = new FConsultarPaciente();
        this.medico = medico;
        this.frmCitas = frmCitas;
        this.filtro  = new FiltrosJTextFields();
        filtrarCampostxt();
        
    }
    
    /**
     * Método para agregar filtros a los campos del formulario.
     */
    private void filtrarCampostxt(){
        this.txtNombres.setDocument(filtro.filtroJTextLetras());
        this.txtApellidoPaterno.setDocument(filtro.filtroJTextLetras());
        this.txtApellidoMaterno.setDocument(filtro.filtroJTextLetras());
        this.txtTelefono.setDocument(filtro.filtroJTextNumeros());
    
    }
    
    /**
     * Método para validar los campos del formulario.
     * @return true si todos los campos son válidos, false de lo contrario.
     */
    private boolean validarCampos() {
        Validadores validador = new Validadores();
        if (!validador.validaNombre(txtNombres.getText())){
            JOptionPane.showMessageDialog(this, "Campo nombre invalido, favor de corregirlo",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }    
        if (!validador.validaApellidos(txtApellidoPaterno.getText())) {
            JOptionPane.showMessageDialog(this, "Campo apellido paterno invalido, favor de corregirlo",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            return false;    
        }
        if (!validador.validaApellidos(txtApellidoMaterno.getText())) {
            JOptionPane.showMessageDialog(this, "Campo apellido materno invalido, favor de corregirlo",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            return false; 
        }
        if (!validador.validaTelefono(txtTelefono.getText())) {
            JOptionPane.showMessageDialog(this, "Campo telefono invalido, favor de corregirlo",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            return false; 
        }
        if (!validador.validaEmail(txtCorreo.getText())) {
            JOptionPane.showMessageDialog(this, "Campo correo invalido, favor de corregirlo",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            return false; 
        }
        PacienteDTO telefonoRegistrado = regPacientes.consultarTelefonoRegistrado(txtTelefono.getText());
        if (telefonoRegistrado != null) {
            JOptionPane.showMessageDialog(this, "El telefono ya se encuentra registrado",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            return false; 
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtApellidoPaterno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        dpFechaNacimiento = new com.github.lgooddatepicker.components.DatePicker();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 130, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("REGISTRAR PACIENTE");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 50));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("DATOS DEL PACIENTE");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 260, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, 90, 30));

        btnConfirmar.setText("Confirmar");
        btnConfirmar.setBackground(new java.awt.Color(204, 204, 204));
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, 90, 30));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Fecha de nacimiento");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 150, 20));

        txtCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 340, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombres");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 110, 20));

        txtNombres.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 340, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Apellido Paterno");
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 120, 20));

        txtApellidoPaterno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 340, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Apellido Materno");
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 110, 20));

        txtApellidoMaterno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 340, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Telefono");
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 100, 20));

        txtTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 340, -1));

        dpFechaNacimiento.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jPanel1.add(dpFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, -1, -1));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Correo");
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 100, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 570, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método invocado al hacer clic en el botón "Cancelar".
     * Cierra el formulario actual.
     * @param evt Evento de acción generado al hacer clic en el botón.
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * Método invocado al hacer clic en el botón "Confirmar".
     * Registra un nuevo paciente si todos los campos son válidos y están completos.
     * @param evt Evento de acción generado al hacer clic en el botón.
     */
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if (!txtNombres.getText().isEmpty() && !txtApellidoPaterno.getText().isEmpty() && !txtApellidoMaterno.getText().isEmpty()
                && !txtTelefono.getText().isEmpty() && !txtCorreo.getText().isEmpty() && dpFechaNacimiento.getDate() != null) {

            
            if (this.validarCampos()) {
                String nombre = this.txtNombres.getText();
                String aPaterno = this.txtApellidoPaterno.getText();
                String aMaterno = this.txtApellidoMaterno.getText();
                LocalDate fechaIngresada = dpFechaNacimiento.getDate();
                Calendar fechaNacimiento = new GregorianCalendar(fechaIngresada.getYear(), fechaIngresada.getMonthValue() - 1, fechaIngresada.getDayOfMonth());
                String telefono = this.txtTelefono.getText();
                String correo = this.txtCorreo.getText();

                PacienteDTO paciente = new PacienteDTO(
                        nombre,
                        aPaterno,
                        aMaterno,
                        fechaNacimiento.getTime(),
                        telefono,
                        correo);

                PacienteDTO pacienteRegistrado = this.registro.registrarPaciente(paciente);
                if (pacienteRegistrado != null) {
                    JOptionPane.showMessageDialog(this, "Paciente registrado.", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    if (this.frmCitas != null) {
                        this.frmCitas.vaciarPacientesCbx();
                        this.frmCitas.obtenerPacientesCbx();
                    } else {
                        FrmDatosFiscales frmFiscal = new FrmDatosFiscales(null, true, pacienteRegistrado, medico);
                        frmFiscal.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El paciente ya se encuentra registrado.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                }
            } 
        } else {
            JOptionPane.showMessageDialog(this, "Se tienen que llenar todos los campos",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnConfirmarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private com.github.lgooddatepicker.components.DatePicker dpFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
