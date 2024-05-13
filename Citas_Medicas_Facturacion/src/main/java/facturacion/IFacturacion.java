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
    
    /**
     * Busca un rfc dentro del sistema de pacientes.
     *
     * @param rfc El RFC a buscar dentro del sistema.
     * @return El paciente encontrado, o null si no se encontro ningun paciente.
     */
    public PacienteDTO buscarRFCExistente(String rfc);
    
    /**
     * Obtiene el folio a utilizar para la siguiente factura de un medico especifico
     *
     * @param medico El medico que realiza la factura.
     * @return El numero de folio a utilizar.
     */
    public Integer obtenerNuevoFolio(MedicoDTO medico);
    
}
