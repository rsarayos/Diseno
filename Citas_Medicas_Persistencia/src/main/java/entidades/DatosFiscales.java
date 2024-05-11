package entidades;

/**
 * Representa los datos fiscales de una entidad.
 */
public class DatosFiscales {
    
    /**
     * razon social de la entidad.
     */
    private String razonSocial;
    
    /**
     * regimen fiscal de la entidad.
     */
    private String regimenFiscal;
    
    /**
     * rfc de la entidad.
     */
    private String rfc;
    
    /**
     *calle correspondiente al domicilio de la entidad.
     */
    private String calle;
    
    /**
     *colonia correspondiente al domicilio de la entidad.
     */
    private String colonia;
    
    /**
     *numero exterior correspondiente al domicilio de la entidad.
     */
    private String numExterior;
    
    /**
     *numero interior correspondiente al domicilio de la entidad.
     */
    private String numInterior;
    
    /**
     *codigo postal correspondiente al domicilio de la entidad.
     */
    private String codigoPostal;
    
    /**
     *ciudad correspondiente al domicilio de la entidad.
     */
    private String ciudad;
    
    /**
     *municipio correspondiente al domicilio de la entidad.
     */
    private String municipio;
    
    /**
     *estado correspondiente al domicilio de la entidad.
     */
    private String estado;

    /**
     * Constructor por defecto de DatosFiscales.
     */
    public DatosFiscales() {
    }

    /**
     * Constructor de DatosFiscales con todos los campos.
     * 
     * @param razonSocial La razón social.
     * @param regimenFiscal El régimen fiscal.
     * @param RFC El Registro Federal de Contribuyentes (RFC).
     * @param calle La calle.
     * @param colonia La colonia.
     * @param numExterior El número exterior.
     * @param numInterior El número interior.
     * @param codigoPostal El código postal.
     * @param ciudad La ciudad.
     * @param municipio El municipio.
     * @param estado El estado.
     */
    public DatosFiscales(String razonSocial, String regimenFiscal, String RFC, String calle, String colonia, String numExterior, String numInterior, String codigoPostal, String ciudad, String municipio, String estado) {
        this.razonSocial = razonSocial;
        this.regimenFiscal = regimenFiscal;
        this.rfc = RFC;
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
     * Obtiene la razon social de la entidad.
     * 
     * @return La razon social de la entidad.
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * Establece la razon social de la entidad.
     * 
     * @param razonSocial La nueva razon social de la entidad.
     */
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    /**
     * Obtiene el regimen fiscal de la entidad.
     * 
     * @return El regimen fiscal de la entidad.
     */
    public String getRegimenFiscal() {
        return regimenFiscal;
    }

    /**
     * Establece el regimen fiscal de la entidad.
     * 
     * @param regimenFiscal La nueva razon social de la entidad.
     */
    public void setRegimenFiscal(String regimenFiscal) {
        this.regimenFiscal = regimenFiscal;
    }

    /**
     * Obtiene el RFC de la entidad.
     * 
     * @return El RFC de la entidad.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Establece el rfc de la entidad.
     * 
     * @param RFC La nueva razon social de la entidad.
     */
    public void setRfc(String RFC) {
        this.rfc = RFC;
    }

    /**
     * Obtiene la calle correspondiente al domicilio de la entidad.
     * 
     * @return La calle de la entidad.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle correspondiente al domicilio de la entidad.
     * 
     * @param calle La nueva calle de la entidad.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene la colonia correspondiente al domicilio de la entidad.
     * 
     * @return La colonia de la entidad.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece la colonia correspondiente al domicilio de la entidad.
     * 
     * @param colonia La nueva colonia de la entidad.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Obtiene el numero exterior correspondiente al domicilio de la entidad.
     * 
     * @return El numero exterior de la entidad.
     */
    public String getNumExterior() {
        return numExterior;
    }

    /**
     * Establece el numero exterior correspondiente al domicilio de la entidad.
     * 
     * @param numExterior El nuevo numero exterior de la entidad.
     */
    public void setNumExterior(String numExterior) {
        this.numExterior = numExterior;
    }

    /**
     * Obtiene el numero interior correspondiente al domicilio de la entidad.
     * 
     * @return El numero interior de la entidad.
     */
    public String getNumInterior() {
        return numInterior;
    }

    /**
     * Establece el numero interior correspondiente al domicilio de la entidad.
     * 
     * @param numInterior El nuevo numero interior de la entidad.
     */
    public void setNumInterior(String numInterior) {
        this.numInterior = numInterior;
    }

    /**
     * Obtiene el codigo postal correspondiente al domicilio de la entidad.
     * 
     * @return El codigo postal de la entidad.
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Establece el codigo postal correspondiente al domicilio de la entidad.
     * 
     * @param codigoPostal El nuevo codigo postal de la entidad.
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Obtiene la ciudad correspondiente al domicilio de la entidad.
     * 
     * @return La ciudad de la entidad.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad correspondiente al domicilio de la entidad.
     * 
     * @param ciudad La nueva ciudad de la entidad.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene el municipio correspondiente al domicilio de la entidad.
     * 
     * @return El municipio de la entidad.
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * Establece el municipio correspondiente al domicilio de la entidad.
     * 
     * @param municipio El nuevo municipio de la entidad.
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     * Obtiene el estado correspondiente al domicilio de la entidad.
     * 
     * @return El estado de la entidad.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado correspondiente al domicilio de la entidad.
     * 
     * @param estado El nuevoestado de la entidad.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Devuelve una representación de cadena de los datos fiscales.
     * 
     * @return Una representación de cadena de los datos fiscales.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DatosFiscales{");
        sb.append("razonSocial=").append(razonSocial);
        sb.append(", regimenFiscal=").append(regimenFiscal);
        sb.append(", RFC=").append(rfc);
        sb.append(", calle=").append(calle);
        sb.append(", colonia=").append(colonia);
        sb.append(", numExterior=").append(numExterior);
        sb.append(", numInterior=").append(numInterior);
        sb.append(", codigoPostal=").append(codigoPostal);
        sb.append(", ciudad=").append(ciudad);
        sb.append(", municipio=").append(municipio);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }
    
}
