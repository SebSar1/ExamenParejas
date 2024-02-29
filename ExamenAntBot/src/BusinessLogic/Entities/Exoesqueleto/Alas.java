package Exoesqueleto;

public class Alas {
    public static int nivelDeEnergia;

    public Alas() {
        nivelDeEnergia = 100;
    }

    public int getNivelDeEnergia() {
        return nivelDeEnergia;
    }

    public void setNivelDeEnergia(int nivelEnergia) {
        nivelDeEnergia = nivelEnergia;
    }

    public void volar() {
        for (int porcentajeBateria = 100; porcentajeBateria >= 0; porcentajeBateria--) {
            System.out.print("\rExobot Volando...batería al " + porcentajeBateria + "%");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();

    }
}
