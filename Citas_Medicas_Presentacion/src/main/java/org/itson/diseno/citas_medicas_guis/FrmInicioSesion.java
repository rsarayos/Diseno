package org.itson.diseno.citas_medicas_guis;

import dtos.MedicoDTO;
import javax.swing.JOptionPane;
import registroMedico.IRegistroMedico;
import registroMedico.RegistroMedico;

/**
 * Clase que representa el formulario de inicio de sesión de la aplicación.
 */
public class FrmInicioSesion extends javax.swing.JFrame {

    /**
     * Constructor de la clase FrmInicioSesion.
     * Inicializa los componentes del formulario.
     */
    public FrmInicioSesion() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        btnRegistro = new javax.swing.JButton();
        btnIniciarSesion = new javax.swing.JButton();
        txtContrasenia = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar Sesion");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Cedula");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 49, 100, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Contraseña");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 93, 100, -1));

        txtCedula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 50, 220, 25));

        btnRegistro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegistro.setText("Registro");
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 120, 35));

        btnIniciarSesion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnIniciarSesion.setText("Iniciar Sesion");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 120, 35));

        txtContrasenia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 220, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 440, 260));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("INICIAR SESION");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 440, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 70));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que se ejecuta al hacer clic en el botón "Iniciar Sesión".
     * Verifica las credenciales del médico e inicia sesión si son válidas.
     * Abre el formulario del menú principal si las credenciales son correctas.
     * Muestra un mensaje de error si las credenciales son incorrectas o si no se encuentra al médico.
     * @param evt Evento de acción generado al hacer clic en el botón "Iniciar Sesión".
     */
    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        if (!txtCedula.getText().isEmpty() && !txtContrasenia.getText().isEmpty()) {
            String cedula = txtCedula.getText();
            String contra = txtContrasenia.getText();

            IRegistroMedico reg = new RegistroMedico();
            MedicoDTO medico = reg.obtenerMedico(cedula);

            if (medico != null) {
                if (medico.getContrasenia().equals(contra)) {
                    FrmMenuPrincipal frmPrincipal = new FrmMenuPrincipal(medico);
                    frmPrincipal.setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Contraseña incorrecta",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se encontro al medico",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Introducir informacion a los campos.",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    /**
     * Método que se ejecuta al hacer clic en el botón "Registro".
     * Intenta registrar un nuevo médico y muestra un mensaje de éxito o error.
     * @param evt Evento de acción generado al hacer clic en el botón "Registro".
     */
    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        IRegistroMedico reg = new RegistroMedico();
        MedicoDTO medico = reg.obtenerMedico("12345678");
        if (medico == null) {
            reg.registrarMedico();
            JOptionPane.showMessageDialog(this, "Registro exitoso: Usuario: 12345678 Contraseña: Contra",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Ya se registro al usuario previamente.",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JPasswordField txtContrasenia;
    // End of variables declaration//GEN-END:variables
}
