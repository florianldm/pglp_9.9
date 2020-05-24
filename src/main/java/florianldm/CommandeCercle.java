package florianldm;

public class CommandeCercle implements Commande {
    /** Le cercle sur lequel exécuter la commande. */
    private Cercle c;

    /**
     * Constructeur de la commande cercle.
     * @param c1 le cercle.
     */
    public CommandeCercle(final Cercle c1) {
        this.c = c1;
    }

    /**
     * Méthode execute de la commande.
     */
    @Override
    public void execute() {
        Dao<Cercle> cercle = FabriqueDao.getCercleDao();
        cercle.save(this.c);
    }
}
