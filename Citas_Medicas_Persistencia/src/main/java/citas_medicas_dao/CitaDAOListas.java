package citas_medicas_dao;

import citas_medicas_entidades.Cita;
import citas_medicas_entidades.Medico;
import citas_medicas_persistancia_excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Implementación de la interfaz ICitaDAO que utiliza una lista en memoria para almacenar las citas.
 * 
 */
public class CitaDAOListas implements ICitaDAO {
    
    /**
     * Lista de citas
     */
    private List<Cita> citas;

    /**
     * Constructor de la clase CitaDAOListas.
     * Inicializa la lista de citas.
     */
    public CitaDAOListas() {
        this.citas = new ArrayList<>();
        
    }

    @Override
    public Cita agregarCita(Cita cita) throws PersistenciaException {
        if (this.citas.add(cita)) {
            return cita;
        } else {
            throw new PersistenciaException("No se pudo agregar la cita");
        }
    }

    @Override
    public Cita consultarConFecha(Calendar fecha, Medico medico) throws PersistenciaException {
        if (this.citas.isEmpty()) {
            return null;
        } else {
            for (Cita cita : citas) {
                if (cita.getFechaHora().equals(fecha) && cita.getMedico().equals(medico)) {
                    return cita;
                }
            }
        }
        
        return null;
    }

}
