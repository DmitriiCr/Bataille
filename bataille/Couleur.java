package bataille;

public enum Couleur {

    PIQUE("pique"), COEUR("coeur"), CARREAU("carreau"), TREFLE("trèfle");

    String nom;

    Couleur(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
