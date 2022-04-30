package bataille;


public class Bataille {

	Joueur joueurGauche;
	Joueur joueurDroite;

	Bataille(String nomGauche, String nomDroite) {
		this.joueurGauche = new Joueur(nomGauche);
		this.joueurDroite = new Joueur(nomDroite);

		this.joueurGauche.donnerCarte(new Carte());
		this.joueurDroite.donnerCarte(new Carte());

	}
	//Méthode distribue:
	//	donne une carte à chaque joueur. Attention, cette méthode doit vérifier que les joueurs		n'ont pas la même carte: elle re-tire une carte au hasard, tant que les 2 cartes sont les même.
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
	//Renvoie la référence vers le joueur qui a la carte de plus haute valeur. Renvoie null s'il y a bataille.
	Joueur gagnant() {
		if (this.joueurDroite.carte.valeur == this.joueurGauche.carte.valeur) {
			return null;
		} else if (this.joueurGauche.carte.valeur.ordinal() > this.joueurDroite.carte.valeur.ordinal()) {
			return this.joueurGauche;
		}
		return this.joueurDroite;
	}

}