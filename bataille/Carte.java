package bataille;

import java.text.Normalizer;
import java.util.regex.Pattern;


public class Carte {

    
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
  /*  méthode getFichierImage
 *  Renvoie une chaîne de caractères coforme aux noms des fichiers des images dans le répertoire "images".
 *  Attention, la chaîne de caractères est sans accents et avec l'extension.
 **/
    String getFichierImage(){
        return valeur.getNom() +"-de-" + couleur.getNom()+".png";
    }
   
    String sansAccent(String s) {
        String strTemp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(strTemp).replaceAll("");
    }
}
