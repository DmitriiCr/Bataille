package bataille;


public enum Valeur {

    SEPT("sept"),
    HUIT("huit"),
    NEUF("neuf"),
    DIX("dix"),
    VALET("valet"),
    DAME("dame"),
    ROI("roi"),
    AS("as");

    String nom;

    Valeur(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
