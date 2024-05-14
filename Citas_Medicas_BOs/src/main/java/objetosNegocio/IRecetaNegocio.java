/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package objetosNegocio;

import dtos.RecetaDTO;
import excepcionesNegocio.NegocioException;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio relacionadas con las recetas
 * médicas.
 *
 * @author Serva
 */
public interface IRecetaNegocio {

    /**
     * Agrega una nueva receta médica.
     *
     * @param receta La receta médica a agregar.
     * @return El objeto RecetaDTO que representa la receta agregada.
     * @throws NegocioException Si ocurre un error durante la operación de
     * negocio.
     */
    public RecetaDTO agregarReceta(RecetaDTO receta) throws NegocioException;

    /**
     * Obtiene todas las recetas médicas.
     *
     * @return Una lista de objetos RecetaDTO que representan las recetas
     * médicas.
     * @throws NegocioException Si ocurre un error durante la operación de
     * negocio.
     */
    public List<RecetaDTO> obtenerRecetas() throws NegocioException;
}
