package entidades;

import java.io.Serializable;
import org.bson.types.ObjectId;

/**
 * Clase que representa una receta médica. Esta clase se utiliza para mapear
 * objetos de tipo Receta a documentos de MongoDB.
 */
public class Receta implements Serializable {

    private ObjectId id; // El identificador de la receta (generado automáticamente por MongoDB).

    private String medicamento; // El nombre del medicamento prescrito en la receta.

    private String dosis; // La dosis del medicamento prescrito en la receta.

    /**
     * Constructor de la clase Receta.
     *
     * @param medicamento El nombre del medicamento.
     * @param dosis La dosis del medicamento.
     */
    public Receta(String medicamento, String dosis) {
        this.medicamento = medicamento;
        this.dosis = dosis;
    }

    /**
     * Constructor por defecto de la clase Receta. Se requiere para la
     * serialización y deserialización de objetos.
     */
    public Receta() {
    }

    /**
     * Obtiene el identificador de la receta.
     *
     * @return El identificador de la receta.
     */
    public Object getId() {
        return id;
    }

    /**
     * Establece el identificador de la receta.
     *
     * @param id El nuevo identificador de la receta.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del medicamento.
     *
     * @return El nombre del medicamento.
     */
    public String getMedicamento() {
        return medicamento;
    }

    /**
     * Establece el nombre del medicamento.
     *
     * @param medicamento El nuevo nombre del medicamento.
     */
    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    /**
     * Obtiene la dosis del medicamento.
     *
     * @return La dosis del medicamento.
     */
    public String getDosis() {
        return dosis;
    }

    /**
     * Establece la dosis del medicamento.
     *
     * @param dosis La nueva dosis del medicamento.
     */
    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    /**
     * Devuelve una representación en cadena de la receta.
     *
     * @return Una cadena que representa la receta.
     */
    @Override
    public String toString() {
        return "Receta{" + "id=" + id + ", medicamento=" + medicamento + ", dosis=" + dosis + '}';
    }

}
