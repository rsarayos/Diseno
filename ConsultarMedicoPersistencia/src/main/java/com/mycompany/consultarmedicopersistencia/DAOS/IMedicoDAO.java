/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.consultarmedicopersistencia.DAOS;

import com.mycompany.consultarmedicopersistencia.Excepciones.PersistenciaException;
import com.mycompany.consultarmedicopersistencia.POJO.Medico;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Medico.
 */
public interface IMedicoDAO {

    /**
     * Método para registrar un médico en la base de datos.
     *
     * @param medico El objeto de tipo Medico a registrar.
     * @return El objeto Medico registrado.
     * @throws PersistenciaException Si ocurre un error durante el proceso de
     * registro.
     */
    public Medico registrarMedico(Medico medico) throws PersistenciaException;

    /**
     * Método para consultar todos los médicos registrados en la base de datos.
     *
     * @return Una lista de objetos de tipo Medico que representan a los médicos
     * consultados.
     * @throws PersistenciaException Si ocurre un error durante el proceso de
     * consulta.
     */
    public List<Medico> consultarMedico() throws PersistenciaException;

    /**
     * Método para eliminar un médico de la base de datos.
     *
     * @param medico El objeto de tipo Medico a eliminar.
     * @return El objeto Medico eliminado.
     * @throws PersistenciaException Si ocurre un error durante el proceso de
     * eliminación.
     */
    public Medico eliminarMedico(Medico medico) throws PersistenciaException;

    /**
     * Método para buscar médicos en la base de datos según criterios como
     * nombre, cédula y especialidad.
     *
     * @param nombre El nombre del médico a buscar (puede ser null o vacío para
     * no considerar este criterio).
     * @param cedula La cédula del médico a buscar (puede ser null o vacío para
     * no considerar este criterio).
     * @param especialidad La especialidad del médico a buscar (puede ser null o
     * vacío para no considerar este criterio).
     * @return Una lista de objetos de tipo Medico que representan a los médicos
     * encontrados.
     * @throws PersistenciaException Si ocurre un error durante el proceso de
     * búsqueda.
     */
    public List<Medico> buscarMedico(String nombre, String cedula, String especialidad) throws PersistenciaException;

}
