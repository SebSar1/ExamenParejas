package DataAccess.DTO;

public class saHormigaComidaDTO {
    private Integer saIdHormiga;
    private String saHormigaTipo;
    private String saCodigoHormiga;
    private String saEstado;
    private String saComio;
    private String saRegion;
    
    public saHormigaComidaDTO() {}
    
    public saHormigaComidaDTO(Integer saIdHormiga, String saHormigaTipo, String saCodigoHormiga, String saEstado,
            String saComio, String saRegion) {
        this.saIdHormiga = saIdHormiga;
        this.saHormigaTipo = saHormigaTipo;
        this.saCodigoHormiga = saCodigoHormiga;
        this.saEstado = saEstado;
        this.saComio = saComio;
        this.saRegion = saRegion;
    }

    public Integer getSaIdHormiga() {
        return saIdHormiga;
    }
    public void setSaIdHormiga(Integer saIdHormiga) {
        this.saIdHormiga = saIdHormiga;
    }
    public String getSaHormigaTipo() {
        return saHormigaTipo;
    }
    public void setSaHormigaTipo(String saHormigaTipo) {
        this.saHormigaTipo = saHormigaTipo;
    }
    public String getSaCodigoHormiga() {
        return saCodigoHormiga;
    }
    public void setSaCodigoHormiga(String saCodigoHormiga) {
        this.saCodigoHormiga = saCodigoHormiga;
    }
    public String getSaEstado() {
        return saEstado;
    }
    public void setSaEstado(String saEstado) {
        this.saEstado = saEstado;
    }
    public String getSaComio() {
        return saComio;
    }
    public void setSaComio(String saComio) {
        this.saComio = saComio;
    }
    public String getSaRegion() {
        return saRegion;
    }
    public void setSaRegion(String saRegion) {
        this.saRegion = saRegion;
    }
    @Override
    public String toString(){
        return "" + getSaIdHormiga();
    }
}
