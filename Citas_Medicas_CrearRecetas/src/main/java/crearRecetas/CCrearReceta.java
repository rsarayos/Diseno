/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crearRecetas;

import dtos.RecetaDTO;
import excepcionesNegocio.NegocioException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetosNegocio.IRecetaNegocio;
import objetosNegocio.RecetaNegocio;

/**
 * Clase controladora para la creación y obtención de recetas médicas.
 * 
 * Esta clase proporciona métodos para agregar nuevas recetas médicas a la base de datos
 * y para obtener todas las recetas almacenadas en la base de datos.
 */
public class CCrearReceta {

    /**
     * Objeto de negocio para el manejo de recetas médicas.
     */
    private final IRecetaNegocio recetaBO;

    /**
     * Logger para registrar información y errores.
     */
    static final Logger logger = Logger.getLogger(CCrearReceta.class.getName());

    /**
     * Constructor que inicializa el objeto de negocio para el manejo de recetas médicas.
     */
    public CCrearReceta() {
        recetaBO = new RecetaNegocio();
    }

    /**
     * Método para agregar una nueva receta médica a la base de datos.
     * 
     * @param nuevaReceta La nueva receta médica a agregar.
     * @return La receta médica agregada.
     */
    protected RecetaDTO agregarReceta(RecetaDTO nuevaReceta) {
        RecetaDTO receta = null;
        try {
            receta = recetaBO.agregarReceta(nuevaReceta);
        } catch (NegocioException ex) {
            logger.log(Level.SEVERE, "Error en negocio al registrar la receta médica", ex);
        }
        return receta;
    }

    /**
     * Método para obtener todas las recetas médicas almacenadas en la base de datos.
     * 
     * @return Lista de todas las recetas médicas almacenadas.
     */
    protected List<RecetaDTO> obtenerRecetas() {
        List<RecetaDTO> recetas = null;
        try {
            recetas = recetaBO.obtenerRecetas();
        } catch (NegocioException ex) {
            logger.log(Level.SEVERE, "Error en negocio al obtener las recetas médicas", ex);
        }
        return recetas;
    }
}