package Exoesqueleto;

public class Antenas implements Icontrolarhormigas {
    private Integer largo;
    private Integer dureza;

    void detectarSonido(){
        System.out.println("El AntBot detecta con sus antenas de " + largo + " cm un sonido ");
    }

    public Integer getLargo() {
        return largo;
    }
    public void setLargo(Integer largo) {
        this.largo = largo;
    }
    public Integer getDureza() {
        return dureza;
    }
    public void setDureza(Integer dureza) {
        this.dureza = dureza;
    }
    @Override
    public void cumplirInstrucciones() {
        System.out.println("El AntBot sigue Instrucciones y intenta detectar enemigos ");
    }


}
