package EjercitoRuso;

public class Soldado extends Hormiga implements IhomigaExtremidad {
    private String clasificacion;
        
    public Soldado(String nombre, String clasificacion) {
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
