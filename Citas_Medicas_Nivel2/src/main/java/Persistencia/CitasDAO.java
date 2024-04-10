package Persistencia;

import Entidades.Cita;
import Entidades.Paciente;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author alex_
 */
public class CitasDAO {
    
    private List<Cita> citas;

    public CitasDAO() {
        this.citas = new ArrayList<>();
        PacientesDAO pacientes = new PacientesDAO();
        citas.add(new Cita(Calendar.getInstance(), pacientes.obtenerPaciente("5551234567"), "Consulta general"));
        citas.add(new Cita(Calendar.getInstance(), pacientes.obtenerPaciente("5552345678"), "Control de rutina"));
        citas.add(new Cita(Calendar.getInstance(), pacientes.obtenerPaciente("5556789012"), "Revisión dental"));
        citas.add(new Cita(Calendar.getInstance(), pacientes.obtenerPaciente("5555678901"), "Consulta general"));
        citas.add(new Cita(Calendar.getInstance(), pacientes.obtenerPaciente("5557890123"), "Consulta pediátrica"));
        citas.add(new Cita(Calendar.getInstance(), pacientes.obtenerPaciente("5558901234"), "Consulta general"));
        citas.add(new Cita(Calendar.getInstance(), pacientes.obtenerPaciente("5559012345"), "Consulta general"));
        citas.add(new Cita(Calendar.getInstance(), pacientes.obtenerPaciente("5550123456"), "Consulta pediátrica"));
        citas.add(new Cita(Calendar.getInstance(), pacientes.obtenerPaciente("5551234567"), "Consulta general"));
        citas.add(new Cita(Calendar.getInstance(), pacientes.obtenerPaciente("5551234567"), "Consulta general"));
        
    }

    public List<Cita> getCitas() {
        return citas;
    }
    
    public boolean agregarCita(Cita citaNueva){
        return this.citas.add(citaNueva);
    }
    
    public boolean fechaOcupada(Calendar fecha){
        for(Cita cita : citas){
            if (cita.getFecha().equals(fecha)) {
                return true;
            }
        }
        
        return false;
    }
    
}
