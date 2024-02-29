package EjercitoRuso;

public abstract class Hormiga {
    private String ssNombre;

    public Hormiga(String ssNombre) {
        this.ssNombre = ssNombre;
    }

    public Hormiga() {
    }

    public String getssNombre() {
        return ssNombre;
    }

    public void setssNombre(String ssNombre) {
        this.ssNombre = ssNombre;
    }

}
