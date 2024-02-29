package DataAccess.DTO;

public class HormigaTipoDTO {
    private Integer  idHormigaTipo;
    private Integer  idHormigaTipoPadre;
    private String   nombre;
    private String   estado;
    private String   fechaCrea;
    
    public HormigaTipoDTO() {
    }
    public HormigaTipoDTO(Integer idHormigaTipo, Integer idHormigaTipoPadre, String nombre, String estado,
            String fechaCrea) {
        this.idHormigaTipo = idHormigaTipo;
        this.idHormigaTipoPadre = idHormigaTipoPadre;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaCrea = fechaCrea;
    }
    public Integer getIdHormigaTipo() {
        return idHormigaTipo;
    }
    public void setIdHormigaTipo(Integer idHormigaTipo) {
        this.idHormigaTipo = idHormigaTipo;
    }
    public Integer getIdHormigaTipoPadre() {
        return idHormigaTipoPadre;
    }
    public void setIdHormigaTipoPadre(Integer idHormigaTipoPadre) {
        this.idHormigaTipoPadre = idHormigaTipoPadre;
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
        + "\n IdHormigaTipo:   "+ getIdHormigaTipo()   
        + "\n Nombre:          "+ getNombre()  
        + "\n Estado:          "+ getEstado()       
        + "\n FechaCrea:       "+ getFechaCrea();   
        
    }
}
