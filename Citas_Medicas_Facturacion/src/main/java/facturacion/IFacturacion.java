package facturacion;

import dtos.FacturaDTO;
import dtos.MedicoDTO;
import dtos.PacienteDTO;

/**
 * Interfaz que define un subsistema para operaciones relacionadas con la facturación.
 */
public interface IFacturacion {
    
    /**
     * Realiza el proceso de facturación.
     *
     * @param factura La factura a ser procesada.
     * @return La factura procesada.
     */
    public FacturaDTO facturar(FacturaDTO factura);
    
    /**
     * Registra datos fiscales de un médico en el sistema.
     *
     * @param medico El médico con datos fiscales a ser registrados.
     * @return El médico con datos fiscales registrados.
     */
    public MedicoDTO registrarDatosFiscalesMedico(MedicoDTO medico);
    
    /**
     * Registra datos fiscales de un paciente en el sistema.
     *
     * @param paciente El paciente con datos fiscales a ser registrados.
     * @return El paciente con datos fiscales registrados.
     */
    public PacienteDTO registrarDatosFiscalesPaciente(PacienteDTO paciente);
    
}
