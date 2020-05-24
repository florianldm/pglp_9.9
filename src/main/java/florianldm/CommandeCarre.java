package florianldm;

public class CommandeCarre implements Commande {

    /** Le carré sur lequel exécuter la commande. */
    private Carre c;

    /**
     * Constructeur de la commande carre.
     * @param c1 le carré.
     */
    public CommandeCarre(final Carre c1) {
        this.c = c1;
    }

    /**
     * Méthode execute de la commande.
     */
    @Override
    public void execute() {
        Dao<Carre> carre = FabriqueDao.getCarreDao();
        carre.save(this.c);
    }
}
