/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

import auxiliares.Validadores;
import convertidores.ConvertidorReceta;
import dao.Conexion;
import dao.ConstantesPersistencia;
import dao.IRecetaDAO;
import dao.RecetaDAO;
import dtos.RecetaDTO;
import entidades.Receta;
import excepcionesNegocio.NegocioException;
import excepcionesPersistencia.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RecetaNegocio implements IRecetaNegocio {

    private final IRecetaDAO recetaDAO;
    private final ConvertidorReceta convReceta;
    static final Logger logger = Logger.getLogger(PacienteNegocio.class.getName());

    public RecetaNegocio() {
        this.recetaDAO = new RecetaDAO(new Conexion(ConstantesPersistencia.colecciones.RECETAS, Receta.class));
        this.convReceta = new ConvertidorReceta();
    }

    @Override
    public RecetaDTO agregarReceta(RecetaDTO receta) throws NegocioException {
        if (!validarReceta(receta)) {
            throw new NegocioException("La receta no es válida");
        }

        try {
            Receta entidadReceta = convReceta.convertidorDTOAEntidad(receta);
            Receta nuevaReceta = recetaDAO.agregarReceta(entidadReceta);
            RecetaDTO recetaAgregada = convReceta.convertirEntidadADTO(nuevaReceta);

            return recetaAgregada;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error de persistencia al agregar la receta", ex);
            throw new NegocioException("Error al agregar la receta: " + ex.getMessage(), ex);
        }
    }

    private boolean validarReceta(RecetaDTO receta) {
        return validarMedicamento(receta.getMedicamento()) && validarDosis(receta.getDosis());
    }

    private boolean validarMedicamento(String medicamento) {
        return new Validadores().validaMedicamento(medicamento);
    }

    private boolean validarDosis(String dosis) {
        return new Validadores().validaDosis(dosis);
    }

    @Override
    public List<RecetaDTO> obtenerRecetas() throws NegocioException {
        try {
            List<Receta> recetas = recetaDAO.obtenerRecetas();
            List<RecetaDTO> recetasDTO = new ArrayList<>();
            for (Receta receta : recetas) {
                recetasDTO.add(convReceta.convertirEntidadADTO(receta));
            }

            return recetasDTO;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error de persistencia al obtener las recetas", ex);
            throw new NegocioException("Error al obtener las recetas: " + ex.getMessage(), ex);
        }
    }

}