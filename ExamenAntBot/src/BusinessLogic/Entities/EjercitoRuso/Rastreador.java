package EjercitoRuso;

public class Rastreador extends Hormiga implements IhomigaExtremidad {
    private String clasificacion;
        
    public Rastreador(String nombre, String clasificacion) {
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
