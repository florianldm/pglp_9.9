package florianldm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class TriangleDao implements Dao<Triangle> {
    /** Liste de triangles. */
    private ArrayList<Triangle> triangles = new ArrayList<Triangle>();

    /**
     * Getter.
     * @param id .
     * @return optional.
     */
    @Override
    public Optional<Triangle> get(final long id) {
        return Optional.empty();
    }

    /**
     * Retourne liste de triangles.
     * @return liste.
     */
    @Override
    public List<Triangle> getAll() {
        return triangles;
    }

    /**
     * Ajout d'un triangle.
     * @param triangle .
     */
    @Override
    public void save(final Triangle triangle) {
        triangles.add(triangle);
    }

    /**
     * Mise à jour d'un triangle.
     * @param triangle mis à jour.
     * @param params tableau de param.
     */
    @Override
    public void update(final Triangle triangle, final String[] params) {
        int index = 0;
        int ok = 0;
        for (Iterator i = this.triangles.iterator(); i.hasNext();) {
            Object objet = i.next();
            Triangle t = (Triangle) objet;
            if (t.getNom().equals(triangle.getNom())) {
                ok = 1;
                break;
            }
            index++;
        }

        if (ok == 1) {
            triangles.remove(index);
            triangles.add(triangle);
        }
    }

    /**
     * Suppression d'un triangle.
     * @param triangle à supprimer.
     */
    @Override
    public void delete(final Triangle triangle) {
        triangles.remove(triangle);
    }
}
