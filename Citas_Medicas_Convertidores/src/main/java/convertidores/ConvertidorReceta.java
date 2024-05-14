/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidores;

import dtos.RecetaDTO;
import entidades.Receta;

/**
 *Clase que proporciona métodos para convertir entre objetos Receta y RecetaDTO. 
 * @author Serva
 */
public class ConvertidorReceta {

    /**
     * Constructor de la clase ConvertidorReceta.
     */
    public ConvertidorReceta() {
    }

    /**
     * Convierte un objeto RecetaDTO a un objeto Receta.
     *
     * @param r El objeto RecetaDTO a convertir.
     * @return Un objeto Receta generado a partir del RecetaDTO.
     */
    public Receta convertidorDTOAEntidad(RecetaDTO r) {

        return new Receta(
                r.getMedicamento(),
                r.getDosis()
        );
    }

    /**
     * Convierte un objeto Receta a un objeto RecetaDTO.
     *
     * @param receta El objeto Receta a convertir.
     * @return Un objeto RecetaDTO generado a partir de la Receta.
     */
    public RecetaDTO convertirEntidadADTO(Receta receta) {
        return new RecetaDTO(
                receta.getId(),
                receta.getMedicamento(),
                receta.getDosis()
        );
    }
}
