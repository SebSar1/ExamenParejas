package EjercitoRuso;

import Exoesqueleto.AntBot;
import InteligenciaArtificial.IABOT;

public class Mecatronico extends Hormiga {

    public Mecatronico(String nombre) {
        super(nombre);
    }

    public void ensamblar(HormigaRusa hRusa, AntBot antBot, IABOT iaBot) throws InterruptedException {
        System.out.println("Ensamblando AntBot, con sus potenciadores");
        antBot.unirseHormigaRusa(hRusa);
    }

}
