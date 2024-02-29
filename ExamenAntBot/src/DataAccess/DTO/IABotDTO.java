package DataAccess.DTO;

public class IABotDTO {
    private Integer idIABot;
    private String nombre;
    private String estado;
    private String Observacion;
    private String FechaCrea;
    
    public IABotDTO() {}

    public IABotDTO(Integer idIABot, String nombre, String estado, String observacion, String fechaCrea) {
        this.idIABot = idIABot;
        this.nombre = nombre;
        this.estado = estado;
        Observacion = observacion;
        FechaCrea = fechaCrea;
    }

    public Integer getIdIABot() {
        return idIABot;
    }
    public void setIdIABot(Integer idIABot) {
        this.idIABot = idIABot;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getObservacion() {
        return Observacion;
    }
    public void setObservacion(String observacion) {
        Observacion = observacion;
    }
    public String getFechaCrea() {
        return FechaCrea;
    }
    public void setFechaCrea(String fechaCrea) {
        FechaCrea = fechaCrea;
    }

    @Override
    public String toString(){
        return getClass().getName()
        + "\n IdIABot:         "+ getIdIABot()   
        + "\n Nombre:          "+ getNombre()  
        + "\n Estado:          "+ getEstado()    
        + "\n Observacion:     "+ getObservacion()     
        + "\n FechaCrea:       "+ getFechaCrea();   
        
    }


}
