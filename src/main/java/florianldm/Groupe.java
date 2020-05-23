package florianldm;

import java.util.ArrayList;
import java.util.Iterator;

public class Groupe {
    /** Nom du groupe. */
    private String nom;
    /** Liste de formes. */
    private ArrayList<Forme> formes;

    /**
     * Constructeur de groupe.
     * @param nom1 nom du groupe.
     */
    public Groupe(final String nom1) {
        this.nom = nom1;
        this.formes = new ArrayList<Forme>();
    }

    /**
     * Getter nom.
     * @return nom groupe.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter liste.
     * @return liste de formes.
     */
    public ArrayList<Forme> getFormes() {
        return formes;
    }

    /**
     * Déplacement de chaque forme du groupe.
     * @param p le point destination.
     */
    public void move(final Point p) {
        Iterator<Forme> i;
        i = this.formes.iterator();

        while (i.hasNext()) {
            i.next().move(p);
        }
    }
}
