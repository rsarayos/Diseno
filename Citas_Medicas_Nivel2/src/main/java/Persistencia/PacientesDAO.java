package Persistencia;

import Entidades.Paciente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alex_
 */
public class PacientesDAO {
    
    private List<Paciente> pacientes;

    public PacientesDAO() {
        this.pacientes = new ArrayList<>();
        
        pacientes.add(new Paciente("Juan", "Pérez", "Gómez", "5551234567", "juan.perez@example.com"));
        pacientes.add(new Paciente("María", "López", "Fernández", "5552345678", "maria.lopez@example.com"));
        pacientes.add(new Paciente("Carlos", "González", "Ramírez", "5553456789", "carlos.gonzalez@example.com"));
        pacientes.add(new Paciente("Laura", "Martínez", "Sánchez", "5554567890", "laura.martinez@example.com"));
        pacientes.add(new Paciente("Pedro", "Rodríguez", "Pérez", "5555678901", "pedro.rodriguez@example.com"));
        pacientes.add(new Paciente("Ana", "Hernández", "García", "5556789012", "ana.hernandez@example.com"));
        pacientes.add(new Paciente("Luis", "Díaz", "Torres", "5557890123", "luis.diaz@example.com"));
        pacientes.add(new Paciente("Sofía", "Pérez", "Vázquez", "5558901234", "sofia.perez@example.com"));
        pacientes.add(new Paciente("Jorge", "Gómez", "López", "5559012345", "jorge.gomez@example.com"));
        pacientes.add(new Paciente("Fernanda", "Torres", "Sánchez", "5550123456", "fernanda.torres@example.com"));
        pacientes.add(new Paciente("Daniel", "Ramírez", "Martínez", "5551234567", "daniel.ramirez@example.com"));
        pacientes.add(new Paciente("Valeria", "Sánchez", "González", "5552345678", "valeria.sanchez@example.com"));
        pacientes.add(new Paciente("Roberto", "Vázquez", "Hernández", "5553456789", "roberto.vazquez@example.com"));
        pacientes.add(new Paciente("Adriana", "García", "Díaz", "5554567890", "adriana.garcia@example.com"));
        pacientes.add(new Paciente("Miguel", "López", "Pérez", "5555678901", "miguel.lopez@example.com"));
        
    }
    
    public boolean agregarPaciente(Paciente pacienteNuevo){
        return this.pacientes.add(pacienteNuevo);
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }
    
    public Paciente obtenerPaciente(String telefono){
        
        for(Paciente paciente: this.pacientes){
            if (paciente.getTelefono().equals(telefono)) {
                return paciente;
            }
        }
        
        return null;
    }
    
}
