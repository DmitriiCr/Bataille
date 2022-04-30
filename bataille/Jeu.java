package bataille;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Jeu {

    static final String PATH_TO_IMAGES = "images/";

    Bataille bataille;

    JFrame frameJeuDeBataille;

    JLabel commentaire;

    JLabel carteJoueurGaucheLabel;

    JLabel carteJoueurDroiteLabel;

    Jeu(String nomGauche, String nomDroite) {
        bataille = new Bataille(nomGauche, nomDroite);
        
        initFrame();
    }
 /*   la méthode void afficheCarteJoueur(PlaceJoueur joueur, Carte carte)
    * Cette méthode affiche la carte carte sur le label de la carte gauche (carteJoueurGaucheLabel)
    * si joueur == PlaceJoueur.GAUCHE ou sur le label de la carte droite (carteJoueurDroiteLabel) si
    * joueur == PlaceJoueur.DROITE.*/

    void afficheCarteJoueur(PlaceJoueur joueur, Carte carte) {
        String file = PATH_TO_IMAGES+carte.getFichierImage();
  
        JLabel carteJoueur = null ;
        if(joueur == PlaceJoueur.GAUCHE ){
            carteJoueur = this.carteJoueurGaucheLabel;
        }
        else{
            carteJoueur = this.carteJoueurDroiteLabel ; 
        }
        carteJoueur.setIcon(new ImageIcon(file));
        
    }

   // la méthode jouer()
/* Cette méthode est la méthode appelée lorsque l'on clique sur le bouton jouer.
  Cette méthode implément un tour de jeu de bataille:
  	- distribution des cartes aux 2 joueurs
   - affichage des cartes de chaque joueur
   - affichage d'un commentaire sous la forme:
   	"nomDuJoueurGauche joue un(e) nomDeLaCarteJouéeParLeJoueurGauche\n
   	 nomDujoueurDroite joue un(e) nomDeLaCarteJouéeParLeJoueurDroite."
     par exemple:
     	Anna Tomie joue un(e) roi de trèfle
    	Guy de Michelin joue un(e) as de pique*/
    void jouer() {
  
        this.bataille.distribue();
        this.afficheCarteJoueur(PlaceJoueur.GAUCHE, this.bataille.joueurGauche.joue());
        this.afficheCarteJoueur(PlaceJoueur.DROITE, this.bataille.joueurDroite.joue());
        commentaire.setText(this.bataille.joueurGauche.getNom()+"joue un(e)"+this.bataille.joueurGauche.carte.toString()+"\n"+this.bataille.joueurDroite.getNom()+"joue un(e)"+bataille.joueurDroite.carte.toString());

    }

  /*  la méthode remporter()
 * Cette méthode est la méthode appelée lorsque l'on clique sur le bouton remporter.
 * Cette méthode implément ce qu'il se passe lorsque les 2 joueurs ont joués et que l'un d'eux remporte.
 * 	- Appel la méthode gagnant() de la classe Bataille
 *  - S'il y a bataille, écrit un commentaire "Bataille ! on rejoue..."
 *  - Sinon, écrit "C'est le joueur nomDujoueurQuiRemporte qui remporte le pli." et
 *  	vide le set de jeu de ses cartes.
 
*/
    void remporter() {

        if(this.bataille.gagnant()==null){
            commentaire.setText("Bataille ! on rejoue...");
        }
        else if(this.bataille.gagnant() == this.bataille.joueurGauche){
            commentaire.setText("C'est le joueur "+this.bataille.joueurGauche.getNom()+"  qui remporte le pli.");
            this.carteJoueurGaucheLabel.setIcon(null);
            this.carteJoueurDroiteLabel.setIcon(null);
        }
        else{
            commentaire.setText("C'est le joueur "+this.bataille.joueurDroite.getNom()+" qui remporte le pli.");
            this.carteJoueurGaucheLabel.setIcon(null);
            this.carteJoueurDroiteLabel.setIcon(null);
        }

        
    }

    void initFrame() {
        String nomGauche = bataille.joueurGauche.getNom();
        String nomDroite = bataille.joueurDroite.getNom();
        frameJeuDeBataille = new JFrame();
        frameJeuDeBataille.getContentPane().setMinimumSize(new Dimension(1000, 550));
        frameJeuDeBataille.getContentPane().setPreferredSize(new Dimension(1000, 550));
        frameJeuDeBataille.setTitle("Jeu de Bataille");
        frameJeuDeBataille.getContentPane().setBackground(new Color(0, 100, 0));
        frameJeuDeBataille.getContentPane().setLayout(new BoxLayout(frameJeuDeBataille.getContentPane(), BoxLayout.Y_AXIS));
        JPanel joueursPanel = new JPanel();
        frameJeuDeBataille.getContentPane().add(joueursPanel);
        joueursPanel.setLayout(new BoxLayout(joueursPanel, BoxLayout.X_AXIS));
        JPanel joueur1Panel = new JPanel();
        joueur1Panel.setBackground(new Color(100, 149, 237));
        joueursPanel.add(joueur1Panel);
        joueur1Panel.setLayout(new BoxLayout(joueur1Panel, BoxLayout.Y_AXIS));
        JLabel labelJoueur1 = new JLabel(nomGauche);
        labelJoueur1.setHorizontalAlignment(SwingConstants.CENTER);
        joueur1Panel.add(labelJoueur1);
        JPanel joueur1CartesPanel = new JPanel();
        joueur1CartesPanel.setPreferredSize(new Dimension(500, 400));
        joueur1CartesPanel.setMinimumSize(new Dimension(500, 400));
        joueur1CartesPanel.setBackground(new Color(0, 100, 0));
        joueur1Panel.add(joueur1CartesPanel);
        joueur1CartesPanel.setLayout(new GridLayout(1, 0, 20, 0));
        JLabel tasJoueurGaucheLabel = new JLabel();
        tasJoueurGaucheLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tasJoueurGaucheLabel.setPreferredSize(new Dimension(240, 360));
        tasJoueurGaucheLabel.setMaximumSize(new Dimension(240, 360));
        tasJoueurGaucheLabel.setMinimumSize(new Dimension(240, 360));
        tasJoueurGaucheLabel.setIcon(new ImageIcon(PATH_TO_IMAGES + "dos-de-carte.png"));
        joueur1CartesPanel.add(tasJoueurGaucheLabel);
        carteJoueurGaucheLabel = new JLabel();
        carteJoueurGaucheLabel.setHorizontalAlignment(SwingConstants.CENTER);
        carteJoueurGaucheLabel.setPreferredSize(new Dimension(240, 360));
        carteJoueurGaucheLabel.setMaximumSize(new Dimension(240, 360));
        carteJoueurGaucheLabel.setMinimumSize(new Dimension(240, 360));
        joueur1CartesPanel.add(carteJoueurGaucheLabel);
        JPanel joueur2Panel = new JPanel();
        joueur2Panel.setBackground(new Color(245, 222, 179));
        joueursPanel.add(joueur2Panel);
        joueur2Panel.setLayout(new BoxLayout(joueur2Panel, BoxLayout.Y_AXIS));
        JLabel labelJoueur2 = new JLabel(nomDroite);
        labelJoueur2.setHorizontalAlignment(SwingConstants.CENTER);
        joueur2Panel.add(labelJoueur2);
        JPanel joueur2CartesPanel = new JPanel();
        joueur2CartesPanel.setPreferredSize(new Dimension(500, 400));
        joueur2CartesPanel.setMinimumSize(new Dimension(500, 400));
        joueur2CartesPanel.setBackground(new Color(0, 100, 0));
        joueur2Panel.add(joueur2CartesPanel);
        joueur2CartesPanel.setLayout(new GridLayout(1, 0, 20, 0));
        carteJoueurDroiteLabel = new JLabel();
        carteJoueurDroiteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        carteJoueurDroiteLabel.setPreferredSize(new Dimension(240, 360));
        carteJoueurDroiteLabel.setMaximumSize(new Dimension(240, 360));
        carteJoueurDroiteLabel.setMinimumSize(new Dimension(240, 360));
        joueur2CartesPanel.add(carteJoueurDroiteLabel);
        JLabel tasJoueurDroiteLabel = new JLabel();
        tasJoueurDroiteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tasJoueurDroiteLabel.setPreferredSize(new Dimension(240, 360));
        tasJoueurDroiteLabel.setMaximumSize(new Dimension(240, 360));
        tasJoueurDroiteLabel.setMinimumSize(new Dimension(240, 360));
        tasJoueurDroiteLabel.setIcon(new ImageIcon(PATH_TO_IMAGES + "dos-de-carte.png"));
        joueur2CartesPanel.add(tasJoueurDroiteLabel);
        JPanel commentairePanel = new JPanel();
        commentairePanel.setBackground(new Color(0, 100, 0));
        frameJeuDeBataille.getContentPane().add(commentairePanel);
        commentairePanel.setLayout(new BoxLayout(commentairePanel, BoxLayout.X_AXIS));
        commentaire = new JLabel("Commentaire");
        commentairePanel.add(commentaire);
        JPanel boutonsPanel = new JPanel();
        frameJeuDeBataille.getContentPane().add(boutonsPanel);
        boutonsPanel.setLayout(new BoxLayout(boutonsPanel, BoxLayout.X_AXIS));
        JButton btnRJouer = new JButton("Jouer");
        btnRJouer.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                jouer();
            }
        });
        boutonsPanel.add(btnRJouer);
        JButton btnRemporter = new JButton("Remporter");
        btnRemporter.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                remporter();
            }
        });
        boutonsPanel.add(btnRemporter);
        commentaire.setForeground(new Color(255, 255, 240));
        commentaire.setHorizontalAlignment(SwingConstants.CENTER);
        frameJeuDeBataille.setBounds(100, 100, 1054, 490);
        frameJeuDeBataille.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    Jeu window = new Jeu("Anna Tomie", "Guy de Michelin");
                    window.frameJeuDeBataille.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
