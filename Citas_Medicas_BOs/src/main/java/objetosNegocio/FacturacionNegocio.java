package objetosNegocio;

import convertidores.ConvertidorMedico;
import convertidores.ConvertidorPaciente;
import dao.Conexion;
import dao.ConstantesPersistencia;
import dao.IMedicoDAO;
import dao.IPacienteDAO;
import dao.MedicoDAO;
import dao.PacienteDAO;
import dtos.FacturaDTO;
import dtos.MedicoDTO;
import dtos.PacienteDTO;
import entidades.Medico;
import entidades.Paciente;
import excepcionesNegocio.NegocioException;
import excepcionesPersistencia.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex_
 */
public class FacturacionNegocio implements IFacturacionNegocio{
    
    /** Instancia para interactuar con la capa de persistencia para los pacientes. */
    private final IPacienteDAO pacienteDAO;
    
    /** Instancia para interactuar con la capa de persistencia para los médicos. */
    private final IMedicoDAO medicoDAO;
    
    private ConvertidorMedico convMedico;
    
    private ConvertidorPaciente convPaciente;

    public FacturacionNegocio() {
        this.pacienteDAO = new PacienteDAO(new Conexion(ConstantesPersistencia.colecciones.PACIENTES, Paciente.class));
        this.medicoDAO = new MedicoDAO(new Conexion(ConstantesPersistencia.colecciones.MEDICOS, Medico.class));
        this.convMedico = new ConvertidorMedico();
        this.convPaciente = new ConvertidorPaciente();
    }

    @Override
    public FacturaDTO registrarFactura(FacturaDTO factura) throws NegocioException {
        return factura;
    }

    @Override
    public MedicoDTO registrarDFMedico(MedicoDTO medico) throws NegocioException {
        Medico m = convMedico.DTOAEntidadDatosFiscales(medico);
        try {
            medicoDAO.agregarDatosFiscales(m);
        } catch (PersistenciaException ex) {
            Logger.getLogger(FacturacionNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medico;
    }

    @Override
    public PacienteDTO registrarDFPaciente(PacienteDTO paciente) throws NegocioException {
        Paciente p = convPaciente.DTOAEntidadCompleto(paciente);
        try {
            pacienteDAO.agregarDatosFiscales(p);
        } catch (PersistenciaException ex) {
            Logger.getLogger(FacturacionNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paciente;
    }
    
}
