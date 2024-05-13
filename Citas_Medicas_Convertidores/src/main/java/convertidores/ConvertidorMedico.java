package convertidores;

import entidades.Cita;
import entidades.Medico;
import dtos.CitaDTO;
import dtos.DatosFiscalesDTO;
import dtos.MedicoDTO;
import entidades.DatosFiscales;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que proporciona métodos para convertir entre objetos de tipo Medico y MedicoDTO.
 * 
 * Esta clase se utiliza para realizar la conversión entre entidades de Medico y sus respectivos DTO (Data Transfer Objects).
 * Los métodos en esta clase permiten convertir objetos de tipo Medico a MedicoDTO y viceversa.
 * 
 */
public class ConvertidorMedico {

    /**
     * Constructor predeterminado de ConvertidorMedico.
     */
    public ConvertidorMedico() {
        
    }
    
    /**
     * Convierte un objeto de tipo MedicoDTO a un objeto de tipo Medico.
     * 
     * @param m El objeto de tipo MedicoDTO que se va a convertir.
     * @return Un objeto de tipo Medico resultante de la conversión.
     */
    public Medico DTOAEntidad(MedicoDTO m) {
        
        return new Medico(
                m.getCedulaProfesional(),
                m.getNombre(),
                m.getApellidoPaterno(),
                m.getApellidoMaterno(),
                m.getFechaNacimiento(),
                m.getEspecialidad(),
                m.getTelefono(),
                m.getCorreo(),
                m.getContrasenia()
        );
        
    }
    
    /**
     * Convierte un objeto de tipo MedicoDTO a un objeto de tipo Medico con datos fiscales.
     * 
     * @param m El objeto de tipo MedicoDTO que se va a convertir.
     * @return Un objeto de tipo Medico resultante de la conversión.
     */
    public Medico DTOAEntidadDatosFiscales(MedicoDTO m) {
        
        List<DatosFiscales> datosFiscales = new LinkedList<>();

        DatosFiscales datos = new DatosFiscales(
                m.getDatosFiscales().get(0).getRazonSocial(),
                m.getDatosFiscales().get(0).getRegimenFiscal(),
                m.getDatosFiscales().get(0).getRFC(),
                m.getDatosFiscales().get(0).getCalle(),
                m.getDatosFiscales().get(0).getColonia(),
                m.getDatosFiscales().get(0).getNumExterior(),
                m.getDatosFiscales().get(0).getNumInterior(),
                m.getDatosFiscales().get(0).getCodigoPostal(),
                m.getDatosFiscales().get(0).getCiudad(),
                m.getDatosFiscales().get(0).getMunicipio(),
                m.getDatosFiscales().get(0).getEstado());
        
        datosFiscales.add(datos);
        
        return new Medico(
                m.getCedulaProfesional(),
                m.getNombre(),
                m.getApellidoPaterno(),
                m.getApellidoMaterno(),
                m.getFechaNacimiento(),
                m.getEspecialidad(),
                m.getTelefono(),
                m.getCorreo(),
                m.getContrasenia(),
                datosFiscales
        );
        
    }
    
    /**
     * Convierte un objeto de tipo Medico a un objeto de tipo MedicoDTO.
     * 
     * @param m El objeto de tipo Medico que se va a convertir.
     * @return Un objeto de tipo MedicoDTO resultante de la conversión.
     */
    public MedicoDTO EntidadaADTO(Medico m) {
        if (m != null) {

            List<DatosFiscalesDTO> datosFiscales = null;
            if (m.getDatosFiscales() != null) {

                DatosFiscalesDTO datos = new DatosFiscalesDTO(
                        m.getDatosFiscales().get(0).getRazonSocial(),
                        m.getDatosFiscales().get(0).getRegimenFiscal(),
                        m.getDatosFiscales().get(0).getRfc(),
                        m.getDatosFiscales().get(0).getCalle(),
                        m.getDatosFiscales().get(0).getColonia(),
                        m.getDatosFiscales().get(0).getNumExterior(),
                        m.getDatosFiscales().get(0).getNumInterior(),
                        m.getDatosFiscales().get(0).getCodigoPostal(),
                        m.getDatosFiscales().get(0).getCiudad(),
                        m.getDatosFiscales().get(0).getMunicipio(),
                        m.getDatosFiscales().get(0).getEstado());

                datosFiscales = new LinkedList<>();
                datosFiscales.add(datos);
            }

            return new MedicoDTO(
                    m.getCedulaProfesional(),
                    m.getNombre(),
                    m.getApellidoPaterno(),
                    m.getApellidoMaterno(),
                    m.getFechaNacimiento(),
                    m.getEspecialidad(),
                    m.getTelefono(),
                    m.getCorreo(),
                    m.getContrasenia(),
                    datosFiscales
            );
        } else {
            return null;
        }
    }
    
}
