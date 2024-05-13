/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.consultarmedicobo.objetosNegocio;

import com.mycompany.consultarmedicodto.DTOS.MedicoDTO;
import com.mycompany.consultarmediconegocio.Excepciones.NegocioException;
import java.util.List;

/**
 * Interfaz que define las operaciones relacionadas con la lógica de negocio de los médicos.
 */
public interface IMedicoNegocio {

    /**
     * Método para registrar un médico en el sistema.
     *
     * @param medico El objeto DTO del médico a registrar.
     * @return El objeto DTO del médico registrado.
     * @throws NegocioException Si ocurre un error durante el proceso de
     * registro.
     */
    public MedicoDTO registrarMedico(MedicoDTO medico) throws NegocioException;

    /**
     * Método para consultar todos los médicos registrados en el sistema.
     *
     * @return Una lista de objetos DTO que representan a los médicos
     * consultados.
     * @throws NegocioException Si ocurre un error durante el proceso de
     * consulta.
     */
    public List<MedicoDTO> consultarMedico() throws NegocioException;

    /**
     * Método para eliminar un médico del sistema.
     *
     * @param medico El objeto DTO del médico a eliminar.
     * @return El objeto DTO del médico eliminado.
     * @throws NegocioException Si ocurre un error durante el proceso de
     * eliminación.
     */
    public MedicoDTO eliminarMedico(MedicoDTO medico) throws NegocioException;

    /**
     * Método para buscar médicos en el sistema según criterios como nombre,
     * cédula y especialidad.
     *
     * @param nombre El nombre del médico a buscar (puede ser null o vacío para
     * no considerar este criterio).
     * @param cedula La cédula del médico a buscar (puede ser null o vacío para
     * no considerar este criterio).
     * @param especialidad La especialidad del médico a buscar (puede ser null o
     * vacío para no considerar este criterio).
     * @return Una lista de objetos DTO que representan a los médicos
     * encontrados.
     * @throws NegocioException Si ocurre un error durante el proceso de
     * búsqueda.
     */
    public List<MedicoDTO> buscarMedico(String nombre, String cedula, String especialidad) throws NegocioException;
}
