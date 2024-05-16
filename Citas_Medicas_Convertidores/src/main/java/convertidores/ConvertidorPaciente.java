package convertidores;

import entidades.Cita;
import entidades.Paciente;
import dtos.CitaDTO;
import dtos.DatosFiscalesDTO;
import dtos.PacienteDTO;
import entidades.DatosFiscales;
import java.util.LinkedList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que proporciona métodos para convertir entre objetos de tipo Paciente y PacienteDTO.
 * 
 * Esta clase se utiliza para realizar la conversión entre entidades de Paciente y sus respectivos DTO (Data Transfer Objects).
 * Los métodos en esta clase permiten convertir objetos de tipo Paciente a PacienteDTO y viceversa.
 * 
 */
public class ConvertidorPaciente {

    /**
     * Constructor predeterminado de ConvertidorPaciente.
     */
    public ConvertidorPaciente() {

    }

    /**
     * Convierte un objeto de tipo PacienteDTO a un objeto de tipo Paciente.
     *
     * @param p El objeto de tipo PacienteDTO que se va a convertir.
     * @return Un objeto de tipo Paciente resultante de la conversión.
     */
    public Paciente DTOAEntidad(PacienteDTO p) {

        return new Paciente(
                p.getNombres(),
                p.getApellidoPaterno(),
                p.getApellidoMaterno(),
                p.getFechaNacimiento(),
                p.getTelefono(),
                p.getCorreo()
        );

    }

    /**
     * Convierte un objeto de tipo PacienteDTO a un objeto de tipo Paciente, incluyendo los datos fiscales.
     * 
     * @param p El objeto de tipo PacienteDTO que se va a convertir.
     * @return Un objeto de tipo Paciente resultante de la conversión, incluyendo los datos fiscales.
     */
    public Paciente DTOAEntidadCompleto(PacienteDTO p) {

        List<DatosFiscales> datosFiscales = null;
        
        if (p.getDatosFiscales() != null) {
            datosFiscales = new LinkedList<>();

            DatosFiscales datos = new DatosFiscales(
                    p.getDatosFiscales().get(0).getRazonSocial(),
                    p.getDatosFiscales().get(0).getRegimenFiscal(),
                    p.getDatosFiscales().get(0).getRFC(),
                    p.getDatosFiscales().get(0).getCalle(),
                    p.getDatosFiscales().get(0).getColonia(),
                    p.getDatosFiscales().get(0).getNumExterior(),
                    p.getDatosFiscales().get(0).getNumInterior(),
                    p.getDatosFiscales().get(0).getCodigoPostal(),
                    p.getDatosFiscales().get(0).getCiudad(),
                    p.getDatosFiscales().get(0).getMunicipio(),
                    p.getDatosFiscales().get(0).getEstado());

            datosFiscales.add(datos);
        }

        return new Paciente(
                p.getID(),
                p.getNombres(),
                p.getApellidoPaterno(),
                p.getApellidoMaterno(),
                p.getFechaNacimiento(),
                p.getTelefono(),
                p.getCorreo(),
                datosFiscales
        );

    }

    /**
     * Convierte un objeto de tipo PacienteDTO a un objeto de tipo Paciente, incluyendo los datos fiscales.
     * 
     * @param p El objeto de tipo PacienteDTO que se va a convertir.
     * @return Un objeto de tipo Paciente resultante de la conversión, incluyendo los datos fiscales.
     */
    public Paciente DTOAEntidadDatosFiscales(PacienteDTO p) {

        List<DatosFiscales> datosFiscales = new LinkedList<>();

        DatosFiscales datos = new DatosFiscales(
                p.getDatosFiscales().get(0).getRazonSocial(),
                p.getDatosFiscales().get(0).getRegimenFiscal(),
                p.getDatosFiscales().get(0).getRFC(),
                p.getDatosFiscales().get(0).getCalle(),
                p.getDatosFiscales().get(0).getColonia(),
                p.getDatosFiscales().get(0).getNumExterior(),
                p.getDatosFiscales().get(0).getNumInterior(),
                p.getDatosFiscales().get(0).getCodigoPostal(),
                p.getDatosFiscales().get(0).getCiudad(),
                p.getDatosFiscales().get(0).getMunicipio(),
                p.getDatosFiscales().get(0).getEstado());

        datosFiscales.add(datos);

        return new Paciente(
                p.getNombres(),
                p.getApellidoPaterno(),
                p.getApellidoMaterno(),
                p.getFechaNacimiento(),
                p.getTelefono(),
                p.getCorreo(),
                datosFiscales
        );

    }

    /**
     * Convierte un objeto de tipo Paciente a un objeto de tipo PacienteDTO.
     *
     * @param p El objeto de tipo Paciente que se va a convertir.
     * @return Un objeto de tipo PacienteDTO resultante de la conversión.
     */
    public PacienteDTO EntidadaADTO(Paciente p) {
        if (p != null) {

            List<DatosFiscalesDTO> datosFiscales = null;
            if (p.getDatosFiscales() != null) {

                DatosFiscalesDTO datos = new DatosFiscalesDTO(
                        p.getDatosFiscales().get(0).getRazonSocial(),
                        p.getDatosFiscales().get(0).getRegimenFiscal(),
                        p.getDatosFiscales().get(0).getRfc(),
                        p.getDatosFiscales().get(0).getCalle(),
                        p.getDatosFiscales().get(0).getColonia(),
                        p.getDatosFiscales().get(0).getNumExterior(),
                        p.getDatosFiscales().get(0).getNumInterior(),
                        p.getDatosFiscales().get(0).getCodigoPostal(),
                        p.getDatosFiscales().get(0).getCiudad(),
                        p.getDatosFiscales().get(0).getMunicipio(),
                        p.getDatosFiscales().get(0).getEstado());

                datosFiscales = new LinkedList<>();
                datosFiscales.add(datos);
            }

            return new PacienteDTO(
                    p.getId(),
                    p.getNombre(),
                    p.getApellidoPaterno(),
                    p.getApellidoMaterno(),
                    p.getFechaNacimiento(),
                    p.getEdad(),
                    p.getTelefono(),
                    p.getCorreo(),
                    datosFiscales
            );
        } else {
            return null;
        }

    }

}
