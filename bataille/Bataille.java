package bataille;

/* TODO Écrivez la classe Bataille
0-Attributs: suivre à la lettre les indications du diagramme UML de classes
1- Constructeur:		en plus d'initialiser les attributs, ici, le constructeur distribue une carte à chaque joueur.
2- Méthode distribue:
		donne une carte à chaque joueur. Attention, cette méthode doit vérifier que les joueurs		n'ont pas la même carte: elle re-tire une carte au hasard, tant que les 2 cartes sont les même.
3- Méthode gangnant:
		Renvoie la référence vers le joueur qui a la carte de plus haute valeur. Renvoie null s'il y a bataille.
		Tip: Pour récupérer la valeur (ordre dans lequel est classé une constante dans une énumération), vous pouvez			utiliser enum.ordinal où enum est une référence vers une valeur d'énumération.
*/
// 
public class Bataille {

	Joueur joueurGauche;
	Joueur joueurDroite;

	Bataille(String nomGauche, String nomDroite) {
		this.joueurGauche = new Joueur(nomGauche);
		this.joueurDroite = new Joueur(nomDroite);

		this.joueurGauche.donnerCarte(new Carte());
		this.joueurDroite.donnerCarte(new Carte());

	}

	void distribue() {
		Carte c1;
		do {
			c1 = new Carte();
		} while (c1.egale(this.joueurDroite.carte));

		this.joueurDroite.donnerCarte(c1);

		do {
			c1 = new Carte();
		} while (c1.egale(this.joueurGauche.carte));
		this.joueurGauche.donnerCarte(c1);

	}

	Joueur gagnant() {
		if (this.joueurDroite.carte.valeur == this.joueurGauche.carte.valeur) {
			return null;
		} else if (this.joueurGauche.carte.valeur.ordinal() > this.joueurDroite.carte.valeur.ordinal()) {
			return this.joueurGauche;
		}
		return this.joueurDroite;
	}

}