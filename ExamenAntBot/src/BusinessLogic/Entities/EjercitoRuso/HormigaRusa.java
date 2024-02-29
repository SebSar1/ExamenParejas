package EjercitoRuso;

import Exoesqueleto.FuentePoder;
import Exoesqueleto.Alas;

public class HormigaRusa extends Hormiga implements IhomigaExtremidad {
    private String clasificacion;
        
    public HormigaRusa(String nombre, String clasificacion) {
        super(nombre);
        this.clasificacion = clasificacion;
    }
    
    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {            
            this.clasificacion = clasificacion;
        }


    public void reemplazarBateriaFuente(FuentePoder fuentePoder) {
        System.out.println("Recargando/ reemplazando batería");
        FuentePoder.nivelDeEnergia = 100;

    }
}
