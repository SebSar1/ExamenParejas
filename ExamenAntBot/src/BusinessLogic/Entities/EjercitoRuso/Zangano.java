package EjercitoRuso;

public class Zangano extends Hormiga implements IhomigaExtremidad {
    private String clasificacion;
        
    public Zangano(String nombre, String clasificacion) {
        super(nombre);
        this.clasificacion = clasificacion;
    }
    
    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {            
            this.clasificacion = clasificacion;
    }
}
