package Exoesqueleto;

public class Tenazas implements Icontrolarhormigas {
    private Integer ancho;
    private Integer largo;

    public void mover(){
        System.out.println("Las tenazas de " + ancho + " y "+ largo +" cm han picado a un enemigo ");
    }

    public Integer getAncho() {
        return ancho;
    }

    public void setAncho(Integer ancho) {
        this.ancho = ancho;
    }


    @Override
    public void cumplirInstrucciones() {
    System.out.println("La hormiga ha sido controlada y ha comenzado a usar sus tenazas");
    }



}
