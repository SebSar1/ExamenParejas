package EjercitoRuso;

import Exoesqueleto.ITecnicoIngles;

public class ExpertoIngles {
    private final String nombreExpertoIngles;

    public ExpertoIngles() {
        this.nombreExpertoIngles = "Arthur";
    }

    public String getNombreExpertoIngles() {
        return nombreExpertoIngles;
    }

    public void ensenarIngles(ITecnicoIngles iTecnicoIngles) {
        System.out.println("Ensenando a la AntBot ingles" + " soy el maestro " + getNombreExpertoIngles());
    }

}
