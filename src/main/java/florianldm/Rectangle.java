package florianldm;

public class Rectangle extends Forme {
    /** Position du rectangle (centre). */
    private Point position;
    /** Hauteur du rectangle. */
    private int hauteur;
    /** Largeur du rectangle. */
    private int largeur;

    /**
     * Constructeur de rectangle.
     * @param nom .
     * @param h hauteur.
     * @param l largeur.
     */
    public Rectangle(final String nom, final int h, final int l) {
        super(nom);
        this.hauteur = h;
        this.largeur = l;
    }

    /**
     * Getter position.
     * @return position rectangle.
     */
    public Point getPosition() {
        return position;
    }

    /**
     * Getter nom.
     * @return nom du rectangle.
     */
    @Override
    public String getNom() {
        return super.getNom();
    }

    /**
     * Getter hauteur.
     * @return hauteur du rectangle.
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * Getter largeur.
     * @return largeur du rectangle.
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * Déplacement du rectangle.
     * @param p le point de destination.
     */
    @Override
    public void move(final Point p) {
        this.position = p;
    }
}
