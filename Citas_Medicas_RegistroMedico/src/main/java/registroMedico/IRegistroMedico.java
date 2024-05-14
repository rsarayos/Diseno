package registroMedico;

import dtos.MedicoDTO;

/**
 * Interfaz que define las operaciones para el registro y la obtención de médicos en el sistema.
 * 
 * Esta interfaz proporciona métodos para registrar nuevos médicos en el sistema y para obtener información
 * sobre un médico existente utilizando su número de cédula profesional.
 * 
 */
public interface IRegistroMedico {
    
    /**
     * Registra un nuevo médico en el sistema.
     */
    public void registrarMedico();
    
    /**
     * Obtiene la información de un médico mediante su número de cédula profesional.
     * 
     * @param numCedula el número de cédula profesional del médico a obtener.
     * @return un objeto MedicoDTO que contiene la información del médico, o null si no se encuentra.
     */
    public MedicoDTO obtenerMedico(String numCedula);
    
    /**
     * Registra un nuevo médico en el sistema.
     * 
     * @param medico envia un MedicoDTO
     * @return 
     */
    public MedicoDTO RegistrarMedicoNuevo(MedicoDTO medico);
    
}
