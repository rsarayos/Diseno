package consultarCitas;

import Persistencia.CitasDAO;
import java.util.Calendar;

/**
 *
 * @author alex_
 */
public class ConsultarCita implements IConsultarCita{
    
    private CitasDAO citas;

    public ConsultarCita() {
        citas = new CitasDAO();
    }
    
    @Override
    public boolean consultarFechaCita(Calendar fecha) {
        
        return citas.fechaOcupada(fecha);
        
    }
    
}
