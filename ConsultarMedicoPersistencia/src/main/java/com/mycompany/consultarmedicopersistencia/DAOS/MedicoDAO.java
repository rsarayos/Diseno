
package com.mycompany.consultarmedicopersistencia.DAOS;

import com.mongodb.MongoException;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.regex;
import com.mycompany.consultarmedicopersistencia.ConexionBD.Conexion;
import com.mycompany.consultarmedicopersistencia.Excepciones.PersistenciaException;
import com.mycompany.consultarmedicopersistencia.POJO.Medico;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 * Clase que implementa las operaciones de acceso a datos para la entidad Medico
 * utilizando MongoDB.
 */
public class MedicoDAO implements IMedicoDAO {

    private final MongoCollection<Medico> coleccion;

    /**
     * Constructor que inicializa la colección de MongoDB para la entidad
     * Medico.
     */
    public MedicoDAO() {
        this.coleccion = Conexion.getDatabase().getCollection("medicos", Medico.class);
    }

    /**
     * Método para registrar un médico en la base de datos.
     *
     * @param medico El objeto de tipo Medico a registrar.
     * @return El objeto Medico registrado.
     * @throws PersistenciaException Si ocurre un error durante el proceso de
     * registro.
     */
    @Override
    public Medico registrarMedico(Medico medico) throws PersistenciaException {
        try {
            this.coleccion.insertOne(medico);
            return medico;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al registrar al medico" + medico.getNombre());
        }
    }

    /**
     * Método para consultar todos los médicos registrados en la base de datos.
     *
     * @return Una lista de objetos de tipo Medico que representan a los médicos
     * consultados.
     * @throws PersistenciaException Si ocurre un error durante el proceso de
     * consulta.
     */
    @Override
    public List<Medico> consultarMedico() throws PersistenciaException {
        try {
            List<Medico> medicos = new ArrayList();
            coleccion.find().into(medicos);
            return medicos;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al consultar al medico");
        }
    }

    /**
     * Método para eliminar un médico de la base de datos.
     *
     * @param medico El objeto de tipo Medico a eliminar.
     * @return El objeto Medico eliminado.
     * @throws PersistenciaException Si ocurre un error durante el proceso de
     * eliminación.
     */
    @Override
    public Medico eliminarMedico(Medico medico) throws PersistenciaException {
        try {
            this.coleccion.deleteOne(Filters.eq("cedula", medico.getCedula()));
            return medico;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al eliminar al medico");
        }
    }

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
    @Override
    public List<Medico> buscarMedico(String nombre, String cedula, String especialidad) throws PersistenciaException {
        try {
            List<Medico> medicos = new ArrayList<>();

            coleccion.find(and(
                    nombre != null ? regex("nombre", nombre, "i") : new Document(),
                    cedula != null ? regex("cedula", cedula, "i") : new Document(),
                    especialidad != null ? regex("especialidad", especialidad, "i") : new Document()
            )).into(medicos);

            return medicos;

        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Error al buscar al medico", e);
        }
    }
}
