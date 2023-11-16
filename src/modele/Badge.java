package modele;

public class Badge {
    protected BADGE BADGE;
    public enum BADGE {MARIN1, MARIN2};

    public Badge() {}

    public Badge(BADGE BADGE) {
        this.BADGE = BADGE;
    }

    public BADGE getLegume() {
        return BADGE;
    }

    public void setLegume(BADGE BADGE) {
        this.BADGE = BADGE;
    }
}
