/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import entidades.Receta;
import excepcionesPersistencia.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RecetaDAO implements IRecetaDAO {

    /**
     * Objeto para manejar la conexión a la base de datos.
     */
    private final IConexion conexion;

    /**
     * Logger para registrar información y errores.
     */
    static final Logger logger = Logger.getLogger(RecetaDAO.class.getName());

    /**
     * Constructor que inicializa la conexión a la base de datos.
     *
     * @param conexion Objeto para manejar la conexión a la base de datos.
     */
    public RecetaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Método para agregar una receta médica a la base de datos.
     *
     * @param receta La receta médica a agregar.
     * @return La receta médica agregada.
     * @throws PersistenciaException Si ocurre un error al agregar la receta a
     * la base de datos.
     */
    @Override
    public Receta agregarReceta(Receta receta) throws PersistenciaException {

        MongoClient recetas = conexion.obtenerConexion();
        MongoCollection coleccionRecetas = conexion.obtenerColeccion(recetas);
        try {
            // Guardar la receta en la colección de MongoDB
            coleccionRecetas.insertOne(receta);
            logger.log(Level.INFO, "Se agregó la receta a MongoDB");
            return receta; // Devolver la receta agregada
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al agregar la receta a MongoDB", e);
            // Lanzar una excepción de persistencia en caso de error
            throw new PersistenciaException("No se pudo registrar la receta en la BD.");
        }
    }

    /**
     * Método para obtener todas las recetas médicas de la base de datos.
     *
     * @return Lista de todas las recetas médicas almacenadas en la base de
     * datos.
     * @throws PersistenciaException Si ocurre un error al obtener las recetas
     * de la base de datos.
     */
    @Override
    public List<Receta> obtenerRecetas() throws PersistenciaException {
        List<Receta> recetas = new ArrayList<>();

        try {
            // Obtener todas las recetas de la colección de MongoDB utilizando la conexión
            conexion.obtenerColeccion(conexion.obtenerConexion()).find().into(recetas);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al obtener las recetas médicas de la base de datos", e);
            // Lanzar una excepción de persistencia en caso de error
            throw new PersistenciaException("No se pudieron obtener las recetas de la BD.");
        }

        return recetas;
    }
}
