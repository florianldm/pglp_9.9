package florianldm;

public class CommandeMove implements Commande {
    /** Forme à déplacer */
    private Forme f;
    /** Destination. */
    private Point destination;

    /**
     * Constructeur avec une forme.
     * @param f1 forme à déplacer.
     * @param dest destination.
     */
    public CommandeMove(final Forme f1, final Point dest) {
        this.f = f1;
        this.destination = dest;
    }

    @Override
    public void execute() {
/*
        if (f.getNom().startsWith("ce")) {
            int ok = 0;
            int i = 0;
            Dao<Cercle> cercle = FabriqueDao.getCercleDao();
            Cercle c = null;
            while (ok == 0) {
                System.out.println(cercle.getAll().size());
                if (cercle.getAll().get(i).getNom().equals(f.getNom())) {
                    ok = 1;
                    c = cercle.getAll().get(i);
                }
                i++;
            }
            c.move(destination);
            cercle.update(c, new String[0]);
        } else if (f.getNom().startsWith("cr")) {
            int ok = 0;
            int i = 0;
            Dao<Carre> carre = FabriqueDao.getCarreDao();
            Carre c = null;
            while (ok == 0) {
                if (carre.getAll().get(i).getNom().equals(f.getNom())) {
                    ok = 1;
                    c = carre.getAll().get(i);
                }
                i++;
            }
            c.move(destination);
            carre.update(c, new String[0]);
        } else if (f.getNom().startsWith("rc")) {
            int ok = 0;
            int i = 0;
            Dao<Rectangle> rectangle = FabriqueDao.getRectangleDao();
            Rectangle r = null;
            while (ok == 0) {
                if (rectangle.getAll().get(i).getNom().equals(f.getNom())) {
                    ok = 1;
                    r = rectangle.getAll().get(i);
                }
                i++;
            }
            r.move(destination);
            rectangle.update(r, new String[0]);
        } else if (f.getNom().startsWith("tr")) {
            int ok = 0;
            int i = 0;
            Dao<Triangle> triangle = FabriqueDao.getTriangleDao();
            Triangle t = null;
            while (ok == 0) {
                if (triangle.getAll().get(i).getNom().equals(f.getNom())) {
                    ok = 1;
                    t = triangle.getAll().get(i);
                }
                i++;
            }
            t.move(destination);
            triangle.update(t, new String[0]);
        }
        */
    }
}
