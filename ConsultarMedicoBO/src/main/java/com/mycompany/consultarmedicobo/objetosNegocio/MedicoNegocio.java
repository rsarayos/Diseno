package com.mycompany.consultarmedicobo.objetosNegocio;

import com.mycompany.consultarmedicoconvertidor.Convertidor.ConvertidorMedico;
import com.mycompany.consultarmedicodto.DTOS.MedicoDTO;
import com.mycompany.consultarmediconegocio.Excepciones.NegocioException;
import com.mycompany.consultarmedicopersistencia.DAOS.IMedicoDAO;
import com.mycompany.consultarmedicopersistencia.DAOS.MedicoDAO;
import com.mycompany.consultarmedicopersistencia.Excepciones.PersistenciaException;
import com.mycompany.consultarmedicopersistencia.POJO.Medico;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa la interfaz IMedicoNegocio y define la lógica de negocio
 * relacionada con los médicos.
 *
 * Proporciona métodos para registrar un nuevo médico y obtener información de
 * un médico existente.
 *
 */
public class MedicoNegocio implements IMedicoNegocio {

    /**
     * Objeto para interactuar con la capa de acceso a datos de los medicos.
     */
    private IMedicoDAO medicoDAO;

    /**
     * Objeto para convertir entre DTO y entidad de medico.
     */
    private ConvertidorMedico convertidorMedico;

    /**
     * Logger para registrar mensajes de registro.
     */
    static final Logger logger = Logger.getLogger(MedicoNegocio.class.getName());

    public MedicoNegocio() {
        medicoDAO = new MedicoDAO();
        convertidorMedico = new ConvertidorMedico();
    }

    /**
     * Método para registrar un médico en el sistema.
     *
     * @param medico El objeto DTO del médico a registrar.
     * @return El objeto DTO del médico registrado.
     * @throws NegocioException Si ocurre un error durante el proceso de
     * registro.
     */
    @Override
    public MedicoDTO registrarMedico(MedicoDTO medico) throws NegocioException {
        try {
            return convertidorMedico.convertidorEntidadaADTO(medicoDAO.registrarMedico(convertidorMedico.convertidorDTOAEntidad(medico)));
        } catch (PersistenciaException ex) {
            Logger.getLogger(MedicoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Método para consultar todos los médicos registrados en el sistema.
     *
     * @return Una lista de objetos DTO que representan a los médicos
     * consultados.
     * @throws NegocioException Si ocurre un error durante el proceso de
     * consulta.
     */
    @Override
    public List<MedicoDTO> consultarMedico() throws NegocioException {
        List<MedicoDTO> medicoDTO = new LinkedList<>();
        try {
            List<Medico> medicos = medicoDAO.consultarMedico();
            for (Medico medico : medicos) {
                medicoDTO.add(convertidorMedico.convertidorEntidadaADTO(medico));
            }

        } catch (PersistenciaException ex) {
            Logger.getLogger(MedicoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medicoDTO;
    }

    /**
     * Método para eliminar un médico del sistema.
     *
     * @param medico El objeto DTO del médico a eliminar.
     * @return El objeto DTO del médico eliminado.
     * @throws NegocioException Si ocurre un error durante el proceso de
     * eliminación.
     */
    @Override
    public MedicoDTO eliminarMedico(MedicoDTO medico) throws NegocioException {
        try {
            return convertidorMedico.convertidorEntidadaADTO(medicoDAO.eliminarMedico(convertidorMedico.convertidorDTOAEntidad(medico)));
        } catch (PersistenciaException ex) {
            Logger.getLogger(MedicoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Método para buscar médicos en el sistema según criterios como nombre,
     * cédula y especialidad.
     *
     * @param nombre El nombre del médico a buscar (puede ser null o vacío para
     * no considerar este criterio).
     * @param cedula La cédula del médico a buscar (puede ser null o vacío para
     * no considerar este criterio).
     * @param especialidad La especialidad del médico a buscar (puede ser null o
     * vacío para no considerar este criterio).
     * @return Una lista de objetos DTO que representan a los médicos
     * encontrados.
     * @throws NegocioException Si ocurre un error durante el proceso de
     * búsqueda.
     */
    @Override
    public List<MedicoDTO> buscarMedico(String nombre, String cedula, String especialidad) throws NegocioException {
        List<MedicoDTO> medicoDTO = new LinkedList<>();
        try {
            List<Medico> medicos = medicoDAO.buscarMedico(nombre, cedula, especialidad);
            for (Medico medico : medicos) {
                medicoDTO.add(convertidorMedico.convertidorEntidadaADTO(medico));
            }

        } catch (PersistenciaException ex) {
            Logger.getLogger(MedicoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medicoDTO;
    }
}
