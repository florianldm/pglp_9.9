package florianldm;

public abstract class Forme {
    /** Nom de la forme. **/
    private String nom;

    /**
     * Constructeur de la forme.
     * @param nom1 le nom de la forme.
     */
    public Forme(final String nom1) {
        this.nom = nom1;
    }

    /**
     * Getter nom de la forme.
     * @return nom (string).
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode qui déplace une forme.
     * @param p le point de destination.
     */
    public abstract void move(final Point p);
}
