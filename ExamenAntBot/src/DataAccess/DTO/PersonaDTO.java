package DataAccess.DTO;

public class PersonaDTO {
    private Integer idPersona;
    private Integer idPersonaTipo;
    private String  cedula;
    private String  nombre;
    private String  estado;
    private String  fechaCrea;
    
    public PersonaDTO() {}

    public PersonaDTO(Integer idPersona, Integer idPersonaTipo, String cedula, String nombre, String estado,
            String fechaCrea) {
        this.idPersona = idPersona;
        this.idPersonaTipo = idPersonaTipo;
        this.cedula = cedula;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaCrea = fechaCrea;
    }
    public Integer getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }
    public Integer getIdPersonaTipo() {
        return idPersonaTipo;
    }
    public void setIdPersonaTipo(Integer idPersonaTipo) {
        this.idPersonaTipo = idPersonaTipo;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
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
    public String getFechaCrea() {
        return fechaCrea;
    }
    public void setFechaCrea(String fechaCrea) {
        this.fechaCrea = fechaCrea;
    }
    @Override
    public String toString(){
        return getClass().getName()
        + "\n IdPersona:       "+ getIdPersona()   
        + "\n IdPersonaTipo:   "+ getIdPersonaTipo()  
        + "\n IdCedula:        "+   getCedula() 
        + "\n Nombre:          "+ getNombre()  
        + "\n Estado:          "+ getEstado()       
        + "\n FechaCrea:       "+ getFechaCrea();   
        
    }
}
