package florianldm;

public class Cercle extends Forme{
    /** Centre du cercle. */
    private Point centre;
    /** Rayon du cercle.*/
    private int rayon;

    /**
     * Constructeur du cercle.
     * @param nom du cercle.
     * @param centre1 du cercle.
     * @param rayon1 du cercle.
     */
    public Cercle(final String nom, final Point centre1, final int rayon1) {
        super(nom);
        this.centre = centre1;
        this.rayon = rayon1;
    }

    /**
     * Getter nom du cercle.
     * @return nom.
     */
    @Override
    public String getNom() {
        return super.getNom();
    }

    /**
     * Getter rayon du cercle.
     * @return rayon.
     */
    public int getRayon() {
        return rayon;
    }

    /**
     * Getter centre du cercle.
     * @return centre.
     */
    public Point getCentre() {
        return centre;
    }

    /**
     * Déplacement du cercle.
     * @param p le point de destination.
     */
    @Override
    public void move(final Point p) {
        this.centre = p;
    }
}
