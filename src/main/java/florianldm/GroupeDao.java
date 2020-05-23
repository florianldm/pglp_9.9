package florianldm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class GroupeDao implements Dao<Groupe> {
    /** Liste de groupes. */
    private ArrayList<Groupe> groupes = new ArrayList<Groupe>();

    /**
     * Getter.
     * @param id .
     * @return optional.
     */
    @Override
    public Optional<Groupe> get(final long id) {
        return Optional.empty();
    }

    /**
     * Retourne liste de groupes.
     * @return liste.
     */
    @Override
    public List<Groupe> getAll() {
        return groupes;
    }

    /**
     * Ajout d'un groupe.
     * @param groupe .
     */
    @Override
    public void save(final Groupe groupe) {
        groupes.add(groupe);
    }

    /**
     * Mise à jour d'un groupe.
     * @param groupe mis à jour.
     * @param params tableau de param.
     */
    @Override
    public void update(final Groupe groupe, final String[] params) {
        int index = 0;
        int ok = 0;
        for (Iterator i = this.groupes.iterator(); i.hasNext();) {
            Object objet = i.next();
            Groupe g = (Groupe) objet;
            if (g.getNom().equals(groupe.getNom())) {
                ok = 1;
                break;
            }
            index++;
        }

        if (ok == 1) {
            groupes.remove(index);
            groupes.add(groupe);
        }
    }

    /**
     * Suppression d'un groupe.
     * @param groupe à supprimer.
     */
    @Override
    public void delete(final Groupe groupe) {
        groupes.remove(groupe);
    }
}
