package florianldm;

import java.util.ArrayList;

public class CommandePrint implements Commande {

    private ArrayList<Forme> liste;

    /**
     * Constructeur de la commande Print.
     * @param list la liste des formes.
     */
    public CommandePrint(final ArrayList<Forme> list) {
        this.liste = list;
    }

    /**
     * Parcours de la liste.
     */
    @Override
    public void execute() {
        for (Forme i : liste) {
            if (i.getNom().startsWith("ce")) {
                Cercle c = (Cercle) i;
                System.out.println(i.getNom() + " - Position: (" + c.getCentre().getX() + ";" + c.getCentre().getY() + ") - Rayon: " + c.getRayon());
            } else if (i.getNom().startsWith("cr")) {
                Carre c = (Carre) i;
                System.out.println(i.getNom() + " - Position: (" + c.getPosition().getX() + ";" + c.getPosition().getY() + ") - Taille: " + c.getTaille());
            } else if (i.getNom().startsWith("tr")) {
                Triangle t = (Triangle) i;
                System.out.println(i.getNom() + " - Position: " + " P1: (" + t.getP1().getX() + ";" + t.getP1().getY() + ") P2: (" + t.getP2().getX() + ";" + t.getP2().getY() + ") P3: (" + t.getP3().getX() + ";" + t.getP3().getY() + ")");
            } else if (i.getNom().startsWith("rc")) {
                Rectangle r = (Rectangle) i;
                System.out.println(i.getNom() + " - Hauteur: " + r.getHauteur() + " - Largeur: " + r.getLargeur() + " - Position: (" + r.getPosition().getX() + ";" + r.getPosition().getY() + ")");
            }
        }
    }
}
