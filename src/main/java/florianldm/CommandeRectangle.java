package florianldm;

public class CommandeRectangle implements Commande {
    /** Le rectangle sur lequel exécuter la commande. */
    private Rectangle r;

    /**
     * Constructeur de la commande rectangle.
     * @param r1 le rectangle.
     */
    public CommandeRectangle(final Rectangle r1) {
        this.r = r1;
    }

    /**
     * Méthode execute de la commande.
     */
    @Override
    public void execute() {
        Dao<Rectangle> rectangle = FabriqueDao.getRectangleDao();
        rectangle.save(this.r);
    }
}
