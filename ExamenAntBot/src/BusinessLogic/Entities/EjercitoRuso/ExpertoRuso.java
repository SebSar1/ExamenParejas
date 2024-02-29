package EjercitoRuso;

import Exoesqueleto.ITecnicoRuso;

public class ExpertoRuso {
    private final String nombreExpertoRuso;

    public ExpertoRuso() {
        this.nombreExpertoRuso = "Sebastian";
    }

    public String getNombreExpertoRuso() {
        return nombreExpertoRuso;
    }

    public void ensenarRuso(ITecnicoRuso iTecnicoRuso) {
        System.out.println("Ensenando a la AntBot Ruso" + " soy el maestro " + getNombreExpertoRuso());
    }
}
