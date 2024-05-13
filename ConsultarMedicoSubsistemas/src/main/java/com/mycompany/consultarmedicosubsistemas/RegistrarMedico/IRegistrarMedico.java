
package com.mycompany.consultarmedicosubsistemas.RegistrarMedico;

import com.mycompany.consultarmedicodto.DTOS.MedicoDTO;

/**
 * Interfaz que define las operaciones para el registro de
 * médicos en el sistema.
 *
 * Esta interfaz proporciona métodos para registrar nuevos médicos en el sistema
 *
 */
public interface IRegistrarMedico {

    /**
     * Registra un nuevo médico en el sistema.
     * 
     * @param medico envia un MedicoDTO
     * @return 
     */
    public MedicoDTO RegistrarMedico(MedicoDTO medico);
}
