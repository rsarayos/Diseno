/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entidades.Receta;
import excepcionesPersistencia.PersistenciaException;
import java.util.List;

/**
 * Interfaz para el acceso a datos de recetas médicas.
 */
public interface IRecetaDAO {
    
    /**
     * Agrega una receta médica a la base de datos.
     * 
     * @param receta La receta médica que se desea agregar.
     * @return La receta médica agregada.
     * @throws PersistenciaException Si ocurre un error al agregar la receta médica.
     */
    public Receta agregarReceta(Receta receta) throws PersistenciaException;
    
    /**
     * Obtiene la lista de todas las recetas médicas de la base de datos.
     * 
     * @return La lista de todas las recetas médicas.
     * @throws PersistenciaException Si ocurre un error al obtener las recetas médicas.
     */
    public List<Receta> obtenerRecetas() throws PersistenciaException;
}