package DataAccess.DTO;

public class UsuarioSistemaDTO {
    private Integer idUsuarioSistema;
    private Integer idHormigaTipo;
    private String Contraseña;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;

    public UsuarioSistemaDTO() {
    }

    public UsuarioSistemaDTO(Integer idUsuarioSistema, Integer idHormigaTipo, String contraseña, String estado,
            String fechaCrea, String fechaModifica) {
        this.idUsuarioSistema = idUsuarioSistema;
        this.idHormigaTipo = idHormigaTipo;
        Contraseña = contraseña;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }

    public Integer getIdUsuarioSistema() {
        return idUsuarioSistema;
    }

    public UsuarioSistemaDTO(int idHormigaTipo) {
        this.idHormigaTipo = idHormigaTipo;
    }

    public void setIdUsuarioSistema(Integer idUsuarioSistema) {
        this.idUsuarioSistema = idUsuarioSistema;
    }

    public Integer getIdHormigaTipo() {
        return idHormigaTipo;
    }

    public void setIdHormigaTipo(Integer idHormigaTipo) {
        this.idHormigaTipo = idHormigaTipo;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
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

    public String getFechaModifica() {
        return FechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "\n IdUsuarioSistema:         " + getIdUsuarioSistema()
                + "\n IdHormigaTipo:          " + getIdHormigaTipo()
                + "\n Contraseña:           " + getContraseña()
                + "\n FechaCrea:            " + getFechaCrea()
                + "\n FechaModifica:           " + getFechaModifica();

    }

    public String toStringClave() {
        return Contraseña;
    }

    public String toStringIdPersona() {
        return "" + idHormigaTipo;
    }

    public UsuarioSistemaDTO(String clave) {
        Contraseña = clave;
    }
}
