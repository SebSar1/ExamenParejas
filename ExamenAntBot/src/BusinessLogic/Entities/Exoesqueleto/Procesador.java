package Exoesqueleto;

public class Procesador {
    private Integer nucleos;
    private Integer memoria;

    void analizar(){
        System.out.println("El procesador ha analizado a fondo y espera nuvas ordenes para AntBot");
    }


    public Integer getNucleos() {
        return nucleos;
    }
    public void setNucleos(Integer nucleos) {
        this.nucleos = nucleos;
    }
    public Integer getMemoria() {
        return memoria;
    }
    public void setMemoria(Integer memoria) {
        this.memoria = memoria;
    }


}
