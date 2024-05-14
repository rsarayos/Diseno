/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package crearRecetas;

import dtos.RecetaDTO;
import java.util.List;

/**
 *
 * @author Serva
 */
public interface ICrearReceta {

    public RecetaDTO agregarReceta(RecetaDTO NuevaReceta);

    /**
     * Obtiene la lista de todas las recetas médicas de la base de datos.
     *
     * @return La lista de todas las recetas médicas.
     */
    public List<RecetaDTO> obtenerRecetas();

}
