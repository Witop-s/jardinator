package modele;

public class Legume {
    protected LEGUME legume;
    public enum LEGUME {CAROTTE, NAVET, CHOU, OIGNON}

    public Legume() {}

    public Legume(LEGUME legume) {
        this.legume = legume;
    }

    public LEGUME getLegume() {
        return legume;
    }

    public void setLegume(LEGUME legume) {
        this.legume = legume;
    }
}
