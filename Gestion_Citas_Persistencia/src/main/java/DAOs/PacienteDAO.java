/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.Cita;
import Entidades.Paciente;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import excepciones.PersistenciaException;
import java.util.List;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Clase paciente DAO
 * @author JESUS
 */
public class PacienteDAO {
    
    private final MongoCollection<Paciente> coleccion;
    static final Logger logger = Logger.getLogger(PacienteDAO.class.getName());
    
    /**
     * Metodo para conectar a la coleccion de pacientes
     */
    public PacienteDAO(){
        this.coleccion=conexion.ConexionBD.getDatabase().getCollection("pacientes",Paciente.class);
    }
    
    /**
     * Regresa la coleccion
     * @return coleccion
     */
     public MongoCollection<Paciente> getColeccion() {
        return coleccion;
    }
    
    
    
}
