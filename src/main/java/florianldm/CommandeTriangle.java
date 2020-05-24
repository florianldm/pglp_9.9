package florianldm;

public class CommandeTriangle implements Commande {
    /** Le triangle sur lequel exécuter la commande. */
    private Triangle t;

    /**
     * Constructeur de la commande triangle.
     * @param t1 le triangle.
     */
    public CommandeTriangle(final Triangle t1) {
        this.t = t1;
    }

    /**
     * Méthode execute de la commande.
     */
    @Override
    public void execute() {
        Dao<Triangle> triangle = FabriqueDao.getTriangleDao();
        triangle.save(this.t);
    }
}
