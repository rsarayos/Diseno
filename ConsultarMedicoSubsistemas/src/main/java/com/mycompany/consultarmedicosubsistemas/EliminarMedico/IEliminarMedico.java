/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.consultarmedicosubsistemas.EliminarMedico;

import com.mycompany.consultarmedicodto.DTOS.MedicoDTO;

/**
 * Interfaz que define las operaciones para la eliminacion de médicos en el
 * sistema.
 *
 * Esta interfaz proporciona métodos para eliminar nuevos médicos en el sistema
 *
 */
public interface IEliminarMedico {

    /**
     * Elimina médico en el sistema.
     *
     * @param medico
     */
    public MedicoDTO eliminarMedico(MedicoDTO medico);
}
