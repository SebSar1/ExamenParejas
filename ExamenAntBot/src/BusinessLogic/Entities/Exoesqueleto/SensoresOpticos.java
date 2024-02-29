package Exoesqueleto;

public class SensoresOpticos implements Icontrolarhormigas {

    private Integer lupa;
    private Integer sensor;

    void visualizarEnemigo(){
        System.out.println("La AntBot con sus sensores opticos ha visualizado a un enemigo");
    }
    
    public Integer getLupa() {
        return lupa;
    }


    public void setLupa(Integer lupa) {
        this.lupa = lupa;
    }


    public Integer getSensor() {
        return sensor;
    }


    public void setSensor(Integer sensor) {
        this.sensor = sensor;
    }


    @Override
    public void cumplirInstrucciones() {
        System.out.println("La hormiga ha sido controlada y empiza a usar sus sensores opticos");
    }




}
