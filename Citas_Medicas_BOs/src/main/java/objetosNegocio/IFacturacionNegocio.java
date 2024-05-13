package objetosNegocio;

import dtos.FacturaDTO;
import dtos.MedicoDTO;
import dtos.PacienteDTO;
import excepcionesNegocio.NegocioException;

/**
 * Interfaz que define un contrato para operaciones de negocio relacionadas con la facturación.
 */
public interface IFacturacionNegocio {
    
    /**
     * Registra una factura en el sistema.
     *
     * @param factura La factura a ser registrada.
     * @return La factura registrada.
     * @throws NegocioException Si ocurre un error durante el proceso de negocio.
     */
    public FacturaDTO registrarFactura(FacturaDTO factura) throws NegocioException;
    
    /**
     * Registra datos fiscales de un médico en el sistema.
     *
     * @param medico El médico con datos fiscales a ser registrados.
     * @return El médico con datos fiscales registrados.
     * @throws NegocioException Si ocurre un error durante el proceso de negocio.
     */
    public MedicoDTO registrarDFMedico(MedicoDTO medico) throws NegocioException;
    
    /**
     * Registra datos fiscales de un paciente en el sistema.
     *
     * @param paciente El paciente con datos fiscales a ser registrados.
     * @return El paciente con datos fiscales registrados.
     * @throws NegocioException Si ocurre un error durante el proceso de negocio.
     */
    public PacienteDTO registrarDFPaciente(PacienteDTO paciente) throws NegocioException;
    
    /**
     * Obtener un paciente existente en el sistema mediante su rfc.
     * 
     * @param rfc El rfc del paciente a buscar.
     * @return El paciente encontrado o null en caso de no encontrar coincidencia.
     * @throws NegocioException Si ocurre un error durante el registro del paciente.
     */
    public PacienteDTO obtenerPacienteRFC(String rfc) throws NegocioException;
    
    /**
     * Obtener el folio interno para la siguiente factura a realizar.
     * 
     * @param medico El medico emisor de las facturas a consultar.
     * @return El numero de factura a utilizar para la nueva factura
     * @throws NegocioException Si ocurre un error durante la consulta.
     */
    public Integer obtenerFolioNuevo(MedicoDTO medico) throws NegocioException;
    
}
