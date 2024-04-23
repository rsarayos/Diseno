package citas_medicas_dao;

import citas_medicas_entidades.Medico;
import citas_medicas_persistancia_excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Implementación de la interfaz IMedicoDAO que utiliza una lista en memoria para almacenar los médicos.
 */
public class MedicoDAOListas implements IMedicoDAO {
    
     /**
     * Lista que almacena los médicos
     */
    private List<Medico> medicos;

     /**
     * Constructor de la clase MedicoDAOListas.
     * Inicializa la lista de médicos.
     */
    public MedicoDAOListas() {
        this.medicos = new ArrayList<>();
    }

    @Override
    public void agregarMedicos() throws PersistenciaException {
        Medico medico1 = new Medico("12345678", "Juan", "Lopez", "Gomez", new GregorianCalendar(1995, 5, 15), "Pediatría", "ABCR123456", "5551234567", "juan@example.com", "Contra");
        
        this.medicos.add(medico1);
        
    }

    @Override
    public Medico obtenerMedicoCedula(String cedula) throws PersistenciaException {
        if (this.medicos.isEmpty()) {
            return null;
        } else {
            return this.medicos.get(0);
        }
    }
    
}
