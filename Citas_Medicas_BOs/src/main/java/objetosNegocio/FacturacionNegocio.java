package objetosNegocio;

import convertidores.ConvertidorFactura;
import convertidores.ConvertidorMedico;
import convertidores.ConvertidorPaciente;
import dao.Conexion;
import dao.ConstantesPersistencia;
import dao.FacturaDAO;
import dao.IFacturaDAO;
import dao.IMedicoDAO;
import dao.IPacienteDAO;
import dao.MedicoDAO;
import dao.PacienteDAO;
import dtos.FacturaDTO;
import dtos.MedicoDTO;
import dtos.PacienteDTO;
import entidades.Factura;
import entidades.Medico;
import entidades.Paciente;
import excepcionesNegocio.NegocioException;
import excepcionesPersistencia.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementación de la interfaz IFacturacionNegocio que proporciona métodos para operaciones de negocio relacionadas con la facturación.
 */
public class FacturacionNegocio implements IFacturacionNegocio{
    
    /** Instancia para interactuar con la capa de persistencia para los pacientes. */
    private final IPacienteDAO pacienteDAO;
    
    /** Instancia para interactuar con la capa de persistencia para los médicos. */
    private final IMedicoDAO medicoDAO;
    
    /** Instancia para interactuar con la capa de persistencia para las facturas. */
    private final IFacturaDAO facturaDAO;
    
    /** Instancia para convertir objetos de tipo Medico. */
    private ConvertidorMedico convMedico;
    
    /** Instancia para convertir objetos de tipo Paciente. */
    private ConvertidorPaciente convPaciente;
    
    /** Instancia para convertir objetos de tipo Factura. */
    private ConvertidorFactura convFactura;

    /**
     * Constructor de la clase FacturacionNegocio que inicializa las instancias de los DAOs y convertidores necesarios.
     */
    public FacturacionNegocio() {
        this.pacienteDAO = new PacienteDAO(new Conexion(ConstantesPersistencia.colecciones.PACIENTES, Paciente.class));
        this.medicoDAO = new MedicoDAO(new Conexion(ConstantesPersistencia.colecciones.MEDICOS, Medico.class));
        this.facturaDAO = new FacturaDAO(new Conexion(ConstantesPersistencia.colecciones.FACTURAS, Factura.class));
        this.convMedico = new ConvertidorMedico();
        this.convPaciente = new ConvertidorPaciente();
        this.convFactura = new ConvertidorFactura();
    }

    @Override
    public FacturaDTO registrarFactura(FacturaDTO factura) throws NegocioException {
        Factura f = convFactura.DTOAEntidad(factura);
        try {
            facturaDAO.registrarFactura(f);
        } catch (PersistenciaException ex) {
            Logger.getLogger(FacturacionNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    @Override
    public PacienteDTO obtenerPacienteRFC(String rfc) throws NegocioException {
        Paciente pacienteEncontrado = null;

        try {
            pacienteEncontrado = pacienteDAO.obtenerPacienteRFC(rfc);

            return convPaciente.EntidadaADTO(pacienteEncontrado);

        } catch (PersistenciaException ex) {
            Logger.getLogger(PacienteNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return convPaciente.EntidadaADTO(pacienteEncontrado);
    }

    @Override
    public Integer obtenerFolioNuevo(MedicoDTO medico) throws NegocioException {
        Integer numFacturaNueva = 10000;
        
            try {
            Factura factura = facturaDAO.consultarUltimaFacturaMedico(convMedico.DTOAEntidadDatosFiscales(medico));
            if (factura != null) {
                numFacturaNueva = factura.getFolioInterno();
                numFacturaNueva++;
                return numFacturaNueva;
            } 
        } catch (PersistenciaException ex) {
            Logger.getLogger(FacturacionNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return numFacturaNueva;
    }
    
}
