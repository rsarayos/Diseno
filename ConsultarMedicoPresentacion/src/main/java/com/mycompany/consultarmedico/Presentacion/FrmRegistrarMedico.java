package com.mycompany.consultarmedico.Presentacion;

//import com.mycompany.consultarmedicodto.DTOS.MedicoDTO;
//import com.mycompany.consultarmediconegocio.Validadores.Validadores;
import com.mycompany.consultarmedicodto.DTOS.MedicoDTO;
import com.mycompany.consultarmediconegocio.Validadores.Validadores;
import com.mycompany.consultarmedicosubsistemas.BuscarMedico.FachadaBuscarMedico;
import com.mycompany.consultarmedicosubsistemas.BuscarMedico.IBuscarMedico;
import com.mycompany.consultarmedicosubsistemas.RegistrarMedico.FachadaRegistrarMedico;
import com.mycompany.consultarmedicosubsistemas.RegistrarMedico.IRegistrarMedico;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Clase que representa el formulario para registrar nuevos medicos
 */
public class FrmRegistrarMedico extends javax.swing.JDialog {

    private IRegistrarMedico registrar;
    private IBuscarMedico buscarMedico;

    /**
     * Constructor de la clase FrmRegistrarPaciente.
     *
     * @param parent Componente padre del formulario.
     * @param modal Indica si el diálogo es modal.
     */
    public FrmRegistrarMedico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.registrar = new FachadaRegistrarMedico();
        this.buscarMedico = new FachadaBuscarMedico();
    }

    /**
     * Método para validar los campos del formulario.
     *
     * @return true si todos los campos son válidos, false de lo contrario.
     */
    private boolean validarCampos() {
        Validadores validador = new Validadores();
        if (!validador.validaNombre(txtNombres.getText())) {
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
        if (!validador.validaCedula(txtCedula.getText())) {
            JOptionPane.showMessageDialog(this, "Campo Cedula invalido, favor de insertar numeros solamente",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (!validador.validaEspecialidad(txtEspecialidad.getText())) {
            JOptionPane.showMessageDialog(this, "Campo Especialidad invalido, favor de corregirlo",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (!validador.validaPassword(txtPassword.getText())) {
            JOptionPane.showMessageDialog(this, "Campo Contraseña invalido, favor de corregirlo. "
                    + "Debe de contener 8 caracteres, mayusculas, minisculas, simbolos y numeros. Ejemplo: Passw0rd!",
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
        txtPassword = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtApellidoPaterno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEspecialidad = new javax.swing.JTextField();

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
        jLabel4.setText("Registrar Medico");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 50));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("DATOS DEL MEDICO");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 260, -1));

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 90, 30));

        btnConfirmar.setBackground(new java.awt.Color(204, 204, 204));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 90, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Crear Contraseña");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 110, 20));

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 340, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 110, 20));

        txtNombres.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 340, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Apellido Paterno");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 120, 20));

        txtApellidoPaterno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 340, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Apellido Materno");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 110, 20));

        txtApellidoMaterno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 340, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Cédula");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 100, 20));

        txtCedula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        jPanel1.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 340, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Especialidad");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 100, 20));

        txtEspecialidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 340, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 570, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método invocado al hacer clic en el botón "Cancelar". Cierra el
     * formulario actual.
     *
     * @param evt Evento de acción generado al hacer clic en el botón.
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        FrmAdministradorMenu administradorMenu = new FrmAdministradorMenu();
        administradorMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * Método invocado al hacer clic en el botón "Confirmar". Registra un nuevo
     * paciente si todos los campos son válidos y están completos.
     *
     * @param evt Evento de acción generado al hacer clic en el botón.
     */
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed

        if (!txtNombres.getText().isEmpty() && !txtApellidoPaterno.getText().isEmpty() && !txtApellidoMaterno.getText().isEmpty()
                && !txtCedula.getText().isEmpty() && !txtPassword.getText().isEmpty() && !txtEspecialidad.getText().isEmpty()) {

            if (this.validarCampos()) {
                String nombre = this.txtNombres.getText();
                String aPaterno = this.txtApellidoPaterno.getText();
                String aMaterno = this.txtApellidoMaterno.getText();
                String cedula = this.txtCedula.getText();
                String especialidad = this.txtEspecialidad.getText();
                String password = this.txtPassword.getText();

                MedicoDTO medico = new MedicoDTO(
                        cedula,
                        nombre,
                        aPaterno,
                        aMaterno,
                        especialidad,
                        password);

                List<MedicoDTO> medicoEncontrado = this.buscarMedico.buscarMedico(null, cedula, null);
                if (medicoEncontrado.size() > 0) {
                    JOptionPane.showMessageDialog(this, "Medico ya existe.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                MedicoDTO medicoRegistrado = this.registrar.RegistrarMedico(medico);
                if (medicoRegistrado != null) {
                    JOptionPane.showMessageDialog(this, "Medico registrado.", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                    FrmAdministradorMenu administradorMenu = new FrmAdministradorMenu();
                    administradorMenu.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "El medico ya se encuentra registrado.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Se tienen que llenar todos los campos",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
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
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtEspecialidad;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}