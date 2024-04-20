package negocio_bo;

import dtos.MedicoDTO;

/**
 * Interfaz que define las operaciones relacionadas con la lógica de negocio de los médicos.
 * 
 * Proporciona métodos para registrar un nuevo médico y obtener información de un médico existente.
 * 
 */
public interface IMedicoNegocio {
    
    /**
     * Método para registrar un nuevo médico.
     */
    public void registrarMedico();
    
    /**
     * Método para obtener la información de un médico dado su número de cédula profesional.
     * 
     * @param numCedula el número de cédula profesional del médico que se desea obtener.
     * @return un objeto de tipo MedicoDTO que contiene la información del médico.
     */
    public MedicoDTO obtenerMedico(String numCedula);
    
}
