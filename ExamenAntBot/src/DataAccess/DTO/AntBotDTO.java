package DataAccess.DTO;

public class AntBotDTO {
    private Integer idAntBot;
    private Integer idIABot;
    private String  nombre;
    private String  serie;
    private String  estado;
    
    public AntBotDTO() {}

    public AntBotDTO(Integer idAntBot, Integer idIABot, String nombre, String serie, String estado) {
        this.idAntBot = idAntBot;
        this.idIABot = idIABot;
        this.nombre = nombre;
        this.serie = serie;
        this.estado = estado;
    }

    public Integer getIdAntBot() {
        return idAntBot;
    }
    public void setIdAntBot(Integer idAntBot) {
        this.idAntBot = idAntBot;
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
    public String getSerie() {
        return serie;
    }
    public void setSerie(String serie) {
        this.serie = serie;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    @Override
    public String toString(){
        return getClass().getName()
        + "\n IdAntBot:         "+ getIdAntBot()   
        + "\n IdIABot:          "+ getIdIABot()   
        + "\n Nombre:           "+ getNombre()  
        + "\n Serie:            "+ getSerie()   
        + "\n Estado:           "+ getEstado();   
        
    }
}
