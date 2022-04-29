package bataille;

/**
 * Énumération représentant la valeur des cartes.
 * Les valeurs sont classées dans l'ordre selon la hiérarichie du bridge
 * https://fr.wikipedia.org/wiki/Bataille_(jeu)
 *
 * NE PAS MODIFIER CETTE ENUMERATION
 * @author cfouard
 */
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
