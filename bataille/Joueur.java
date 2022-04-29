package bataille;

/* TODO Écrivez la classe Joueur
0- Attributs: se reporter au diagramme Uml de Classe.
1- Constructeurs: à l'initialisation, la carte d'un joueur est null
2- Méthode donnerCarte: on fait ici l'affectation des références, pas de copie
3- Méthode joue: le joueur renvoie sa carte, mais ne l'efface pas (ne change pas l'attribut carte).
4- Méthode getNom(): idem que joue...*/
// 
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