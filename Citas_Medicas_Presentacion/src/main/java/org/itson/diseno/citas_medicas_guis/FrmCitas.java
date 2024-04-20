package org.itson.diseno.citas_medicas_guis;

import agendarCita.AgendarCita;
import agendarCita.IAgendarCita;
import consultarPacientes.ConsultarPaciente;
import consultarPacientes.IConsultarPaciente;
import dtos.CitaDTO;
import dtos.MedicoDTO;
import dtos.PacienteDTO;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author alex_
 */
public class FrmCitas extends javax.swing.JDialog {
    
    private IConsultarPaciente regPaciente;
    private IAgendarCita regCita;
    private FrmMenuPrincipal menu;
    private MedicoDTO medico;
    private boolean fechaValida;

    /**
     * Creates new form Citas
     */
    public FrmCitas(java.awt.Frame parent, boolean modal, MedicoDTO medico) {
        super(parent, modal);
        initComponents();
        this.regPaciente = new ConsultarPaciente();
        this.regCita = new AgendarCita();
        this.fechaValida = false;
        this.medico = medico;
        this.obtenerPacientesCbx();
        this.btnModificarFecha.setEnabled(false);
        
    }
    
    protected void obtenerPacientesCbx(){
        for (PacienteDTO paciente: regPaciente.consultarPacientes()) {
            this.cbxPacientes.addItem(paciente);
        }
    }
    
    protected void vaciarPacientesCbx(){
        this.cbxPacientes.removeAllItems();
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
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnVerificaCita = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnCancelar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        cbxPacientes = new javax.swing.JComboBox<>();
        btnAddPaciente = new javax.swing.JButton();
        dtpFechaHora = new com.github.lgooddatepicker.components.DateTimePicker();
        btnModificarFecha = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 50));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("AGENDAR CITA");
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 50));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("DATOS DE LA CITA");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 200, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("SELECCIONAR AL PACIENTE");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 260, -1));

        jLabel12.setText("Observaciones");
        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 170, -1));

        btnVerificaCita.setText("Verificar");
        btnVerificaCita.setBackground(new java.awt.Color(204, 204, 204));
        btnVerificaCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificaCitaActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerificaCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, -1, -1));

        jLabel13.setText("Fecha y hora de la cita");
        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 150, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 500, 70));

        btnCancelar.setText("Cancelar");
        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, 90, 30));

        btnConfirmar.setText("Confirmar");
        btnConfirmar.setBackground(new java.awt.Color(204, 204, 204));
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 90, 30));

        cbxPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPacientesActionPerformed(evt);
            }
        });
        jPanel1.add(cbxPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 230, -1));

        btnAddPaciente.setText("Añadir paciente");
        btnAddPaciente.setBackground(new java.awt.Color(204, 204, 204));
        btnAddPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPacienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, -1, -1));

        dtpFechaHora.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel1.add(dtpFechaHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 250, -1));

        btnModificarFecha.setBackground(new java.awt.Color(204, 204, 204));
        btnModificarFecha.setText("Modificar");
        btnModificarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarFechaActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificarFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 570, 430));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        this.getParent().setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if (fechaValida) {
            GregorianCalendar fecha = new GregorianCalendar(dtpFechaHora.getDateTimePermissive().getYear(), dtpFechaHora.getDateTimePermissive().getMonthValue() - 1, dtpFechaHora.getDateTimePermissive().getDayOfMonth(), dtpFechaHora.getDateTimePermissive().getHour(), dtpFechaHora.getDateTimePermissive().getMinute());
            CitaDTO citaNueva = new CitaDTO(
                    fecha,
                    this.medico,
                    cbxPacientes.getItemAt(cbxPacientes.getSelectedIndex()),
                    jTextArea1.getText(),
                    Boolean.TRUE);

            CitaDTO citaReg = regCita.registrarCita(citaNueva);

            if (citaReg != null) {
                JOptionPane.showMessageDialog(this, "Cita registrada de forma exitosa",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                this.getParent().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar la cita",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Se tienen que validar la fecha de la cita",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnAddPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPacienteActionPerformed
        FrmRegistrarPaciente regPaciente = new FrmRegistrarPaciente(null, true, this);
        regPaciente.setVisible(true);
    }//GEN-LAST:event_btnAddPacienteActionPerformed

    private void btnVerificaCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificaCitaActionPerformed
        if (dtpFechaHora.getDateTimePermissive() != null) {
            GregorianCalendar fecha = new GregorianCalendar(dtpFechaHora.getDateTimePermissive().getYear(), dtpFechaHora.getDateTimePermissive().getMonthValue() - 1, dtpFechaHora.getDateTimePermissive().getDayOfMonth(), dtpFechaHora.getDateTimePermissive().getHour(), dtpFechaHora.getDateTimePermissive().getMinute());
            CitaDTO cita = regCita.consultarDisponibilidadCita(new CitaDTO(fecha, this.medico));
            if (cita == null) {
                this.fechaValida = true;
                dtpFechaHora.setEnabled(false);
                this.btnVerificaCita.setEnabled(false);
                this.btnModificarFecha.setEnabled(true);
                JOptionPane.showMessageDialog(this, "Fecha disponible.", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Fecha no disponible.", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnVerificaCitaActionPerformed

    private void btnModificarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarFechaActionPerformed
        this.fechaValida = false;
        this.dtpFechaHora.setEnabled(true);
        this.btnVerificaCita.setEnabled(true);
        this.btnModificarFecha.setEnabled(false);
    }//GEN-LAST:event_btnModificarFechaActionPerformed

    private void cbxPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPacientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPacientesActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPaciente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnModificarFecha;
    private javax.swing.JButton btnVerificaCita;
    private javax.swing.JComboBox<PacienteDTO> cbxPacientes;
    private com.github.lgooddatepicker.components.DateTimePicker dtpFechaHora;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
