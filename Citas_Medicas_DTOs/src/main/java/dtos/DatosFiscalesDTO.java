package dtos;

/**
 * La clase DatosFiscalesDTO representa los datos fiscales de una entidad.
 */
public class DatosFiscalesDTO {
    
    /**
     * La razón social de la entidad.
     */
    private String razonSocial;
    
    /**
     * El régimen fiscal de la entidad.
     */
    private String regimenFiscal;
    
    /**
     * El RFC (Registro Federal de Contribuyentes) de la entidad.
     */
    private String RFC;
    
    /**
     * La calle de la dirección fiscal de la entidad.
     */
    private String calle;
    
    /**
     * La colonia de la dirección fiscal de la entidad.
     */
    private String colonia;
    
    /**
     * El número exterior de la dirección fiscal de la entidad.
     */
    private String numExterior;
    
    /**
     * El número interior de la dirección fiscal de la entidad.
     */
    private String numInterior;
    
    /**
     * El código postal de la dirección fiscal de la entidad.
     */
    private String codigoPostal;
    
    /**
     * La ciudad de la dirección fiscal de la entidad.
     */
    private String ciudad;
    
    /**
     * El municipio de la dirección fiscal de la entidad.
     */
    private String municipio;
    
    /**
     * El estado de la dirección fiscal de la entidad.
     */
    private String estado;

    /**
     * Constructor de la clase DatosFiscalesDTO.
     * @param razonSocial La razón social de la entidad.
     * @param regimenFiscal El régimen fiscal de la entidad.
     * @param RFC El RFC de la entidad.
     * @param calle La calle de la dirección fiscal de la entidad.
     * @param colonia La colonia de la dirección fiscal de la entidad.
     * @param numExterior El número exterior de la dirección fiscal de la entidad.
     * @param numInterior El número interior de la dirección fiscal de la entidad.
     * @param codigoPostal El código postal de la dirección fiscal de la entidad.
     * @param ciudad La ciudad de la dirección fiscal de la entidad.
     * @param municipio El municipio de la dirección fiscal de la entidad.
     * @param estado El estado de la dirección fiscal de la entidad.
     */
    public DatosFiscalesDTO(String razonSocial, String regimenFiscal, String RFC, String calle, String colonia, String numExterior, String numInterior, String codigoPostal, String ciudad, String municipio, String estado) {
        this.razonSocial = razonSocial;
        this.regimenFiscal = regimenFiscal;
        this.RFC = RFC;
        this.calle = calle;
        this.colonia = colonia;
        this.numExterior = numExterior;
        this.numInterior = numInterior;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.municipio = municipio;
        this.estado = estado;
    }

    /**
     * Obtiene la razón social de la entidad.
     * @return La razón social de la entidad.
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * Obtiene el régimen fiscal de la entidad.
     * @return El régimen fiscal de la entidad.
     */
    public String getRegimenFiscal() {
        return regimenFiscal;
    }

    /**
     * Obtiene el RFC de la entidad.
     * @return El RFC de la entidad.
     */
    public String getRFC() {
        return RFC;
    }

    /**
     * Obtiene la calle de la dirección fiscal de la entidad.
     * @return La calle de la dirección fiscal de la entidad.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Obtiene la colonia de la dirección fiscal de la entidad.
     * @return La colonia de la dirección fiscal de la entidad.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Obtiene el número exterior de la dirección fiscal de la entidad.
     * @return El número exterior de la dirección fiscal de la entidad.
     */
    public String getNumExterior() {
        return numExterior;
    }

    /**
     * Obtiene el número interior de la dirección fiscal de la entidad.
     * @return El número interior de la dirección fiscal de la entidad.
     */
    public String getNumInterior() {
        return numInterior;
    }

    /**
     * Obtiene el código postal de la dirección fiscal de la entidad.
     * @return El código postal de la dirección fiscal de la entidad.
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Obtiene la ciudad de la dirección fiscal de la entidad.
     * @return La ciudad de la dirección fiscal de la entidad.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Obtiene el municipio de la dirección fiscal de la entidad.
     * @return El municipio de la dirección fiscal de la entidad.
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * Obtiene el estado de la dirección fiscal de la entidad.
     * @return El estado de la dirección fiscal de la entidad.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Devuelve una representación de cadena de estos datos fiscales.
     * @return Una cadena que representa estos datos fiscales.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DatosFiscalesDTO{");
        sb.append("razonSocial=").append(razonSocial);
        sb.append(", regimenFiscal=").append(regimenFiscal);
        sb.append(", RFC=").append(RFC);
        sb.append(", calle=").append(calle);
        sb.append(", colonia=").append(colonia);
        sb.append(", numExterior=").append(numExterior);
        sb.append(", codigoPostal=").append(codigoPostal);
        sb.append(", ciudad=").append(ciudad);
        sb.append(", municipio=").append(municipio);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
