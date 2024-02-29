package DataAccess.DTO;

public class PersonaTipoDTO {
    private Integer idPersonaTipo;
    private String  nombre;
    private String  estado;
    private String  fechaCrea;
    
    
    public PersonaTipoDTO() {}


    public PersonaTipoDTO(Integer idPersonaTipo, String nombre, String estado, String fechaCrea) {
        this.idPersonaTipo = idPersonaTipo;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaCrea = fechaCrea;
    }


    public Integer getIdPersonaTipo() {
        return idPersonaTipo;
    }


    public void setIdPersonaTipo(Integer idPersonaTipo) {
        this.idPersonaTipo = idPersonaTipo;
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
        + "\n IdPersonaTipo:   "+ getIdPersonaTipo()  
        + "\n Nombre:          "+ getNombre()        
        + "\n FechaCrea:       "+ getFechaCrea();   
        
    }
}
