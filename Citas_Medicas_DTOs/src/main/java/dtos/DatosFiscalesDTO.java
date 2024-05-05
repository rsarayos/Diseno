package dtos;

/**
 *
 * @author alex_
 */
public class DatosFiscalesDTO {
    
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

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getRegimenFiscal() {
        return regimenFiscal;
    }

    public String getRFC() {
        return RFC;
    }

    public String getCalle() {
        return calle;
    }

    public String getColonia() {
        return colonia;
    }

    public String getNumExterior() {
        return numExterior;
    }

    public String getNumInterior() {
        return numInterior;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getEstado() {
        return estado;
    }

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
