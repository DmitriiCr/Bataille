package bataille;

import java.text.Normalizer;
import java.util.regex.Pattern;

/**
 * Classe Carte.
 *
 * 0- Attributs:
 * 		se repporter au diagramme UML de classes  pour le nom et le type des attributs
 *
 * 1- Constructeurs:
 * Le constructeur par défaut de la classe carte choisi
 * un couleur au hasard parmi les couleurs possibles et une
 * valeur au hasard parmi les valeurs possibles.
 * Note: pour choisir une valeur entre 0 et 1, vous pouvez utiliser la méthode Math.random()
 * Note: pour connaître toutes les valeur possibles d'une énumeration Enum, vous pouvez utiliser
 * Enum[] valeursPossiblesDeEnum = Enum.values();
 *
 * Le constructeur qui prend 2 paramètres, affecte les références passées en paramètre sans les copier.
 *
 *  2- méthode toString
 *  Renvoie une chaîne de caractère sous la forme: "As de trèfle" ou "Roi de coeur".
 *
 *  3- méthode egale
 *  Renvoie vrai si la carte courante et la carte passée en paramètre ont la
 *  même couleur et la même valeur. renvoie faux sinon.
 *
 *  4- méthode getFichierImage
 *  Renvoie une chaîne de caractères coforme aux noms des fichiers des images dans le répertoire "images".
 *  Attention, la chaîne de caractères est sans accents et avec l'extension.
 *
 * @author cfouard
 */
public class Carte {

    /**
     * Ne PAS modifier cette méthode.
     * Vous pouvez l'utiliser dans d'autres méthodes de la classe Carte.
     * @param s
     * @return
     */
    Couleur couleur;
    Valeur valeur;

    Carte(){
    Couleur[] valCouleurs = Couleur.values();
    Valeur[] valeurs = Valeur.values();
    this.couleur = valCouleurs[ (int) (Math.random() * (valCouleurs.length-1))];
    this.valeur = valeurs[ (int) (Math.random() * (valeurs.length-1))];


    }
    Carte(Valeur valeur , Couleur couleur){
        this.valeur = valeur;
        this.couleur = couleur;
    }
    public String toString(){
            return valeur.getNom() + "de" + couleur.getNom();
    }
    boolean egale(Carte c){
        return this.valeur==c.valeur && this.couleur == c.couleur;
    }
    String getFichierImage(){
        return valeur.getNom() +"-de-" + couleur.getNom()+".png";
    }
   
    String sansAccent(String s) {
        String strTemp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(strTemp).replaceAll("");
    }
}
