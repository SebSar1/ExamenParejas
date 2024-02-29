package Exoesqueleto;

public class Radio implements Icontrolarhormigas{

    private Integer frecuencia;
    private Integer amplitud;
    
    void detectarEnemigos(){
        System.out.println("Se comunica por la radio de un AntBot que se ha detectado un enemigo");
    }

    public Integer getFrecuencia() {
        return frecuencia;
    }



    public void setFrecuencia(Integer frecuencia) {
        this.frecuencia = frecuencia;
    }



    public Integer getAmplitud() {
        return amplitud;
    }



    public void setAmplitud(Integer amplitud) {
        this.amplitud = amplitud;
    }



    @Override
    public void cumplirInstrucciones() {
        System.out.println("La antobot sigue ordenes y usa su radio constantemente ");
    }

}
