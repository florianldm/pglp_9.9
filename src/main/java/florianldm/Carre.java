package florianldm;

public class Carre extends Forme {
    /** Position du rectangle (centre des diagonales). */
    private Point position;
    /** Taille du rectangle (côté). */
    private int taille;

    /**
     * Constructeur du carré.
     * @param nom .
     * @param pos position.
     * @param taille1 taille.
     */
    public Carre(final String nom, final Point pos, final int taille1) {
        super(nom);
        this.position = pos;
        this.taille = taille1;
    }

    /**
     * Getter nom.
     * @return nom du carré.
     */
    @Override
    public String getNom() {
        return super.getNom();
    }

    /**
     * Getter taille.
     * @return taille du carré.
     */
    public int getTaille() {
        return taille;
    }

    /**
     * Getter position.
     * @return position du carré.
     */
    public Point getPosition() {
        return position;
    }

    /**
     * Déplacement du carré.
     * @param p le point de destination.
     */
    @Override
    public void move(final Point p) {
        this.position = p;
    }
}
