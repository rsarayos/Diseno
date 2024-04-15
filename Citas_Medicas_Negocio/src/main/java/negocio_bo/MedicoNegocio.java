package negocio_bo;

import citas_medicas_dao.Conexion;
import citas_medicas_dao.IConexion;
import citas_medicas_dao.IMedicoDAO;
import citas_medicas_dao.MedicoDAO;
import citas_medicas_entidades.Medico;
import citas_medicas_persistancia_excepciones.PersistenciaException;
import convertidores.ConvertidorMedico;
import dtos.MedicoDTO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex_
 */
public class MedicoNegocio implements IMedicoNegocio {
    
    private final IConexion conexion;
    private final IMedicoDAO medicoDAO;
    private ConvertidorMedico convMedico;
    static final Logger logger = Logger.getLogger(MedicoNegocio.class.getName());

    public MedicoNegocio() {
        this.conexion = new Conexion();
        this.medicoDAO = new MedicoDAO(conexion);
        this.convMedico = new ConvertidorMedico();
    }

    @Override
    public void registrarMedico() {
        try {
            medicoDAO.agregarMedicos();
        } catch (PersistenciaException ex) {
            logger.log(Level.INFO, "Se registro el usuario");
        }
    }

    @Override
    public MedicoDTO obtenerMedico(String numCedula) {
        MedicoDTO medico = null;
        try {
            Medico medicoObt = medicoDAO.obtenerMedicoCedula(numCedula);
            medico = convMedico.convertidorEntidadaADTO(medicoObt);
        } catch (PersistenciaException ex) {
            Logger.getLogger(MedicoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return medico;
    }
    
}
