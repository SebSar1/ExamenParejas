package Exoesqueleto;

public class CircuitoAnillado{
    private int salidaVoltaje = 300;
    private int resistencia;

    public int getSalidaVoltaje() {
        return salidaVoltaje;
    }

    public void setSalidaVoltaje(int salidaVoltaje) {
        this.salidaVoltaje = salidaVoltaje;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    void electrocutar() {
        System.out.println("El AntBot con un voltaje de " + salidaVoltaje + " ha electrocutado a un enemigo");
    }

}
