package DataAccess.DTO;

public class HormigaDTO {
    private Integer idHormiga;
    private Integer idHormigaTipo;
    private String Codigo;
    private String nombre;
    private String Estado;
    private String FechaCrea;

    public HormigaDTO() {
    }

    public HormigaDTO(Integer idHormiga, Integer idHormigaTipo, String codigo, String nombre, String estado,
            String fechaCrea) {
        this.idHormiga = idHormiga;
        this.idHormigaTipo = idHormigaTipo;
        Codigo = codigo;
        this.nombre = nombre;
        Estado = estado;
        FechaCrea = fechaCrea;
    }

    public HormigaDTO(Integer idHormigaRol) {
        idHormigaTipo = idHormigaRol;
    }

    public Integer getIdHormiga() {
        return idHormiga;
    }

    public void setIdHormiga(Integer idHormiga) {
        this.idHormiga = idHormiga;
    }

    public Integer getIdHormigaTipo() {
        return idHormigaTipo;
    }

    public void setIdHormigaTipo(Integer idHormigaTipo) {
        this.idHormigaTipo = idHormigaTipo;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getFechaCrea() {
        return FechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        FechaCrea = fechaCrea;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "\n IdHormiga:       " + getIdHormiga()
                + "\n IdHormigaTipo:   " + getIdHormigaTipo()
                + "\n IdCodigo:        " + getCodigo()
                + "\n Nombre:          " + getNombre()
                + "\n Estado:          " + getEstado()
                + "\n FechaCrea:       " + getFechaCrea();

    }

    public String toStringIdHormigaRol() {
        return "" + idHormigaTipo;
    }

    public String toStringCodigo() {

        return getCodigo();
    }
}
