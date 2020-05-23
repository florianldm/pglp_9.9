package florianldm;

public class Triangle extends Forme {
    /** 1er point. */
    private Point p1;
    /** 2e point. */
    private Point p2;
    /** 3e point. */
    private Point p3;

    /**
     * Constructeur.
     * @param nom .
     * @param p11 Point 1.
     * @param p22 Point 2.
     * @param p33 Point 3.
     */
    public Triangle(final String nom, final Point p11, final Point p22, final Point p33) {
        super(nom);
        this.p1 = p11;
        this.p2 = p22;
        this.p3 = p33;
    }

    /**
     * Getter nom.
     * @return nom du triangle.
     */
    @Override
    public String getNom() {
        return super.getNom();
    }

    /**
     * Getter Point 1.
     * @return point 1 du triangle.
     */
    public Point getP1() {
        return p1;
    }

    /**
     * Getter Point 2.
     * @return point 2 du triangle.
     */
    public Point getP2() {
        return p2;
    }

    /**
     * Getter Point 3.
     * @return point 3 du triangle.
     */
    public Point getP3() {
        return p3;
    }

    /**
     * Déplacement du triangle.
     * @param p le point de destination.
     */
    @Override
    public void move(final Point p) {
        this.p1 = p;
        this.p2 = new Point(p2.getX() + (p.getX() - p1.getX()), p2.getY() + (p.getY() - p1.getY()));
        this.p3 = new Point(p3.getX() + (p.getX() - p1.getX()), p3.getY() + (p.getY() - p1.getY()));
    }
}
