package florianldm;

public class Point {
    /** Coordonnée x. */
    private int x;
    /** Coordonnée y. */
    private int y;

    /**
     * Constructeur d'un point.
     * @param x1 coordonnée x.
     * @param y1 coordonnée y.
     */
    public Point(final int x1, final int y1) {
        this.x = x1;
        this.y = y1;
    }

    /**
     * Getter Y.
     * @return position y.
     */
    public int getY() {
        return y;
    }

    /**
     * Getter X.
     * @return position x.
     */
    public int getX() {
        return x;
    }

    /**
     * Setter Y.
     * @param y1 position Y.
     */
    public void setY(final int y1) {
        this.y = y1;
    }

    /**
     * Setter X.
     * @param x1 position x.
     */
    public void setX(final int x1) {
        this.x = x1;
    }
}
