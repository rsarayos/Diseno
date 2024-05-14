/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bson.Document;

/**
 * DTO (Data Transfer Object) para representar una receta médica.
 */
public class RecetaDTO {

    private Object id; // Identificador único de la receta

    private String medicamento; // Nombre del medicamento

    private String dosis; // Dosis del medicamento

    /**
     * Constructor de la clase RecetaDTO.
     *
     * @param id El ID de la receta.
     */
    public RecetaDTO(Object id) {
        this.id = id;
    }

    /**
     * Constructor con todos los campos.
     *
     * @param medicamento El nombre del medicamento.
     * @param dosis La dosis del medicamento.
     */
    public RecetaDTO(String medicamento, String dosis) {
        this.medicamento = medicamento;
        this.dosis = dosis;
    }
    
    /**
     * Constructor con todos los campos.
     *
     * @param id El ID de la receta
     * @param medicamento El nombre del medicamento.
     * @param dosis La dosis del medicamento.
     */
    public RecetaDTO(Object id, String medicamento, String dosis) {
        this.id = id;
        this.medicamento = medicamento;
        this.dosis = dosis;
    }

    /**
     * Obtiene el identificador único de la receta.
     *
     * @return El identificador único de la receta.
     */
    public Object getId() {
        return id;
    }

    /**
     * Establece el identificador único de la receta.
     *
     * @param id El identificador único de la receta.
     */
    public void setId(Object id) {
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
     * @param medicamento El nombre del medicamento.
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
     * @param dosis La dosis del medicamento.
     */
    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    /**
     * Convierte el objeto RecetaDTO a un Document de MongoDB.
     * 
     * @return El Document de MongoDB representando el objeto RecetaDTO.
     */
    public Document toDocument() {
        Document doc = new Document();
        doc.append("id", id);
        doc.append("medicamento", medicamento);
        doc.append("dosis", dosis);
        return doc;
    }

    /**
     * Crea un objeto RecetaDTO a partir de un Document de MongoDB.
     * 
     * @param doc El Document de MongoDB.
     * @return El objeto RecetaDTO creado a partir del Document.
     */
    public static RecetaDTO fromDocument(Document doc) {
        Object id = doc.get("id");
        String medicamento = doc.getString("medicamento");
        String dosis = doc.getString("dosis");
        return new RecetaDTO(id, medicamento, dosis);
    }

    /**
     * Valida un nombre de medicamento.
     *
     * @param medicamento El nombre del medicamento a validar.
     * @return true si el nombre del medicamento es válido, false en caso contrario.
     */
    public boolean validaMedicamento(String medicamento) {
        Pattern patron = Pattern.compile("^[a-zA-Z0-9áéíóúÁÉÍÓÚüÜñÑ\\s.,()-]{1,100}$");
        Matcher matcher = patron.matcher(medicamento);
        return matcher.matches();
    }

    /**
     * Valida una dosis de medicamento.
     *
     * @param dosis La dosis del medicamento a validar.
     * @return true si la dosis del medicamento es válida, false en caso contrario.
     */
    public boolean validaDosis(String dosis) {
        Pattern patron = Pattern.compile("^[0-9.]+\\s*(mg|g|ml|mg/ml|g/ml|mg/m2|mcg|mcg/ml|mcg/mg|UI|U|U.I.|l|Lt|L|cc|fl|oz|sobres|cápsulas|comprimidos|tabletas)$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = patron.matcher(dosis);
        return matcher.matches();
    }

    /**
     * Retorna una representación de cadena de la receta.
     *
     * @return Una cadena que representa la receta.
     */
    @Override
    public String toString() {
        return "RecetaDTO{" + "id=" + id + ", medicamento=" + medicamento + ", dosis=" + dosis + '}';
    }
}
