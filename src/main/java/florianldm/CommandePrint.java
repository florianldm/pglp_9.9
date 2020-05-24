package florianldm;

import java.util.ArrayList;

public class CommandePrint implements Commande {

    /** Liste de formes. */
    private ArrayList<Forme> liste;
    /** Liste des groupes.*/
    private GroupeDao groupes;

    /**
     * Constructeur de la commande Print.
     * @param list la liste des formes.
     * @param g les groupes.
     */
    public CommandePrint(final ArrayList<Forme> list, final GroupeDao g) {
        this.liste = list;
        this.groupes = g;
    }

    /**
     * Parcours de la liste.
     */
    @Override
    public void execute() {
        System.out.println("LISTE DES ELEMENTS DU DESSIN: ");
        for (Forme i : liste) {
            if (i.getNom().startsWith("ce")) {
                Cercle c = (Cercle) i;
                System.out.println("Cercle: " + i.getNom() + " - Position:"
                        + " (" + c.getCentre().getX() + ";"
                        + "" + c.getCentre().getY() + ") - Rayon: "
                        + "" + c.getRayon());
            } else if (i.getNom().startsWith("cr")) {
                Carre c = (Carre) i;
                System.out.println("Carre " + i.getNom() + " - Position: "
                        + "(" + c.getPosition().getX() + ";"
                        + "" + c.getPosition().getY() + ""
                        + ") - Taille: " + c.getTaille());
            } else if (i.getNom().startsWith("tr")) {
                Triangle t = (Triangle) i;
                System.out.println("Triangle " + i.getNom()
                        + " - Position: " + " P1: "
                        + "(" + t.getP1().getX() + ";"
                        + "" + t.getP1().getY() + ") P2: "
                        + "(" + t.getP2().getX() + ";"
                        + "" + t.getP2().getY() + ") P3: ("
                        + "" + t.getP3().getX() + ";"
                        + "" + t.getP3().getY() + ")");
            } else if (i.getNom().startsWith("rc")) {
                Rectangle r = (Rectangle) i;
                System.out.println("Rectangle " + i.getNom() + " - Hauteur: "
                        + "" + r.getHauteur() + " - Largeur:"
                        + " " + r.getLargeur() + " - "
                        + "Position: ("
                        + "" + r.getPosition().getX() + ";"
                        + "" + r.getPosition().getY() + ")");
            }
        }

        //Affichage des groupes.
        for (Groupe g : groupes.getAll()) {
            System.out.print("Groupe: " + g.getNom() + " - Formes: ");
            for (Forme f : g.getFormes()) {
                System.out.print(f.getNom() + " ");
            }
            System.out.println("");
        }

    }
}
