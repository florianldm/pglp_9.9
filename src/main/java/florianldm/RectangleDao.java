package florianldm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class RectangleDao implements Dao<Rectangle> {
    /** Liste de rectangles. */
    private ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();

    /**
     * Getter.
     * @param id .
     * @return optional.
     */
    @Override
    public Optional<Rectangle> get(final long id) {
        return Optional.empty();
    }

    /**
     * Retourne liste de rectangles.
     * @return liste.
     */
    @Override
    public List<Rectangle> getAll() {
        return rectangles;
    }

    /**
     * Ajout d'un rectangle.
     * @param rectangle .
     */
    @Override
    public void save(final Rectangle rectangle) {
        rectangles.add(rectangle);
    }

    /**
     * Mise à jour d'un rectangle.
     * @param rectangle mis à jour.
     * @param params tableau de param.
     */
    @Override
    public void update(final Rectangle rectangle, final String[] params) {
        int index = 0;
        int ok = 0;
        for (Iterator i = this.rectangles.iterator(); i.hasNext();) {
            Object objet = i.next();
            Rectangle r = (Rectangle) objet;
            if (r.getNom().equals(rectangle.getNom())) {
                ok = 1;
                break;
            }
            index++;
        }

        if (ok == 1) {
            rectangles.remove(index);
            rectangles.add(rectangle);
        }
    }

    /**
     * Suppression d'un rectangle.
     * @param rectangle à supprimer.
     */
    @Override
    public void delete(final Rectangle rectangle) {
        rectangles.remove(rectangle);
    }
}
