/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crearRecetas;

import dtos.RecetaDTO;
import java.util.List;

/**
 * Clase que implementa la interfaz ICrearReceta para la creación y obtención de recetas médicas.
 * 
 * Esta clase actúa como intermediario entre la interfaz de usuario u otro componente y el controlador
 * CCrearReceta, proporcionando métodos para agregar y obtener recetas médicas.
 */
public class FCrearReceta implements ICrearReceta {

    /**
     * Controlador para la creación y obtención de recetas médicas.
     */
    private final CCrearReceta control;

    /**
     * Constructor que inicializa el controlador para la creación y obtención de recetas médicas.
     */
    public FCrearReceta() {
        control = new CCrearReceta();
    }
            
    /**
     * Método para agregar una nueva receta médica.
     * 
     * @param nuevaReceta La receta médica a agregar.
     * @return La receta médica agregada.
     */
    @Override
    public RecetaDTO agregarReceta(RecetaDTO nuevaReceta) {
        return control.agregarReceta(nuevaReceta);
    }

    /**
     * Método para obtener todas las recetas médicas almacenadas.
     * 
     * @return Lista de todas las recetas médicas almacenadas.
     */
    @Override
    public List<RecetaDTO> obtenerRecetas() {
        return control.obtenerRecetas();
    }
}
