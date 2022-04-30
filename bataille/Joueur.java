package bataille;


/*Attributs: se reporter au diagramme Uml de Classe.
 Constructeurs: à l'initialisation, la carte d'un joueur est null
 Méthode donnerCarte: on fait ici l'affectation des références, pas de copie
 Méthode joue: le joueur renvoie sa carte, mais ne l'efface pas (ne change pas l'attribut carte).
 Méthode getNom(): idem que joue...*/

public class Joueur{
    String nom;
    Carte carte;

    Joueur(String nom){
        this.nom = nom;
        this.carte = null;
    }
    void donnerCarte(Carte carte){
        this.carte = carte ;
    }
    Carte joue(){
        return this.carte;
    }
    String getNom(){
        return this.nom;
    }
}