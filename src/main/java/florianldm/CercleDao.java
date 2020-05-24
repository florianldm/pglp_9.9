package florianldm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class CercleDao implements Dao<Cercle> {
    /** Liste de cercles. */
    private ArrayList<Cercle> cercles = new ArrayList<Cercle>();

    /**
     * Getter.
     * @param id .
     * @return optional.
     */
    @Override
    public Optional<Cercle> get(final long id) {
        return Optional.empty();
    }

    /**
     * Retourne liste de cercles.
     * @return liste.
     */
    @Override
    public List<Cercle> getAll() {
        return cercles;
    }

    /**
     * Ajout d'un cercle.
     * @param cercle .
     */
    @Override
    public void save(final Cercle cercle) {
        cercles.add(cercle);
    }

    /**
     * Mise à jour d'un cercle.
     * @param cercle mis à jour.
     * @param params tableau de param.
     */
    @Override
    public void update(final Cercle cercle, final String[] params) {
        int index = 0;
        int ok = 0;
        for (Iterator i = this.cercles.iterator(); i.hasNext();) {
            Object objet = i.next();
            Cercle c = (Cercle) objet;
            if (c.getNom().equals(cercle.getNom())) {
                ok = 1;
                break;
            }
            index++;
        }

        if (ok == 1) {
            cercles.remove(index);
            cercles.add(cercle);
        }
    }

    /**
     * Suppression d'un cercle.
     * @param cercle à supprimer.
     */
    @Override
    public void delete(final Cercle cercle) {
        cercles.remove(cercle);
    }
}
