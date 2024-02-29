package InteligenciaArtificial;

import java.util.Hashtable;

import Exoesqueleto.ITecnicoRuso;
import Exoesqueleto.ITecnicoIngles;


public class IABOT implements ITecnicoRuso, ITecnicoIngles {
    // patron Singletoon
    private static String nombre;
    private static IABOT instancia;

    private IABOT() {
    }

    protected IABOT(IABOT ia) {
        if (ia != null) {
            instancia = ia;
        }
    }

    public static IABOT getInstancia(String nombre) {
        if (instancia == null) {
            instancia = new IABOT();
            IABOT.nombre = nombre;
        }
        return instancia;
    }

    public String getssNombre() {
        return nombre;
    }

    private void setNombre(String Nombre) {
        nombre = Nombre;
    }

    Hashtable<Integer, String> listaAprendizajes = new Hashtable<>();

    public void aprenderIdiomaIngles() {
        listaAprendizajes.put(1, " Ingles");
    }

    public void aprenderIdiomaRuso() {
        listaAprendizajes.put(2, " Ruso");
    }

    public void mostrarIdiomasAprendidos() {
        System.out.println("IAbot ha logrado aprender:");
        listaAprendizajes.forEach((k, v) -> {
            System.out.print(v + " , ");
        });
        System.out.println();
    }


    @Override
    public String traducirIngles(String texto) {
       return texto;
    }
    @Override
    public String traducirRuso(String texto) {
       return texto;
    }

}
