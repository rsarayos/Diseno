package entidades;

/**
 *
 * @author alex_
 */
public class DatosFiscales {
    
    private String razonSocial;
    private String regimenFiscal;
    private String RFC;
    private String calle;
    private String colonia;
    private String numExterior;
    private String numInterior;
    private String codigoPostal;
    private String ciudad;
    private String municipio;
    private String estado;

    public DatosFiscales() {
    }

    public DatosFiscales(String razonSocial, String regimenFiscal, String RFC, String calle, String colonia, String numExterior, String numInterior, String codigoPostal, String ciudad, String municipio, String estado) {
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

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRegimenFiscal() {
        return regimenFiscal;
    }

    public void setRegimenFiscal(String regimenFiscal) {
        this.regimenFiscal = regimenFiscal;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumExterior() {
        return numExterior;
    }

    public void setNumExterior(String numExterior) {
        this.numExterior = numExterior;
    }

    public String getNumInterior() {
        return numInterior;
    }

    public void setNumInterior(String numInterior) {
        this.numInterior = numInterior;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DatosFiscales{");
        sb.append("razonSocial=").append(razonSocial);
        sb.append(", regimenFiscal=").append(regimenFiscal);
        sb.append(", RFC=").append(RFC);
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
