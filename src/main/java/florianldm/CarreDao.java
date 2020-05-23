package florianldm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class CarreDao implements Dao<Carre> {

    /** Liste de carrés. */
    private ArrayList<Carre> carres = new ArrayList<Carre>();

    /**
     * Getter.
     * @param id .
     * @return optional.
     */
    @Override
    public Optional<Carre> get(final long id) {
        return Optional.empty();
    }

    /**
     * Retourne liste de carrés.
     * @return liste.
     */
    @Override
    public List<Carre> getAll() {
        return carres;
    }

    /**
     * Ajout d'un carré.
     * @param carre .
     */
    @Override
    public void save(final Carre carre) {
        carres.add(carre);
    }

    /**
     * Mise à jour d'un carré.
     * @param carre mis à jour.
     * @param params tableau de param.
     */
    @Override
    public void update(final Carre carre, final String[] params) {
        int index = 0;
        int ok = 0;
        for (Iterator i = this.carres.iterator(); i.hasNext();) {
            Object objet = i.next();
            Carre c = (Carre) objet;
            if (c.getNom().equals(carre.getNom())) {
                ok = 1;
                break;
            }
            index++;
        }

        if (ok == 1) {
            carres.remove(index);
            carres.add(carre);
        }
    }

    /**
     * Suppression d'un carré.
     * @param carre à supprimer.
     */
    @Override
    public void delete(final Carre carre) {
        carres.remove(carre);
    }
}
