package florianldm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarreDaoJDBC extends DaoAbstrait {
    /**
     * Constructeur.
     * @param c connexion à la BD.
     */
    public CarreDaoJDBC(final Connection c) {
        super(c);
    }

    /**
     * Retrouve un Carre avec un nom.
     * @param o le carre.
     * @return le carre trouvé.
     */
    @Override
    public Object get(final Object o) {
        Carre p = (Carre) o;
        Carre p1 = null;
        String nomp = p.getNom();
        try {
            PreparedStatement requete = c.prepareStatement(
                    "SELECT * FROM Carre WHERE nom = ?");
            requete.setString(1, nomp);
            ResultSet r = requete.executeQuery(requete.toString());
            Point position = new Point(r.getInt(1), r.getInt(2));
            p1 = new Carre(r.getString(0), position, r.getInt(3));
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return p1;
    }

    /**
     * Ajoute un carre dans la BD.
     * @param o le carre à ajouter.
     * @return null.
     */
    @Override
    public Object save(final Object o) {
        Carre p = (Carre) o;
        String nomp = p.getNom();
        try {
            PreparedStatement requete = c.prepareStatement(
                    "INSERT INTO Carre VALUES (?, ?, ?, ?)");
            requete.setString(1, nomp);
            requete.setInt(2, p.getPosition().getX());
            requete.setInt(3, p.getPosition().getY());
            requete.setInt(4, p.getTaille());
            ResultSet r = requete.executeQuery(requete.toString());
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return null;
    }

    /**
     * Mettre à jour un carre dans la BD.
     * @param o le carre.
     * @param nom nom du carre à modifier.
     * @return null.
     */
    @Override
    public Object update(final Object o, final String nom) {
        Carre p = (Carre) o;
        String nomp = p.getNom();
        try {
            PreparedStatement requete = c.prepareStatement(
                    "UPDATE Carre SET Nom = ?, PosX = ?, "
                            + "PosY = ?, Taille = ? WHERE nom = ?");
            requete.setString(1, nomp);
            requete.setInt(2, p.getPosition().getX());
            requete.setInt(3, p.getPosition().getY());
            requete.setInt(4, p.getTaille());
            requete.setString(5, nom);
            ResultSet r = requete.executeQuery(requete.toString());
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return null;
    }

    /**
     * Supprime un carre.
     * @param o le carre à supprimer.
     * @return null.
     */
    @Override
    public Object delete(final Object o) {
        Carre p = (Carre) o;
        String nomp = p.getNom();
        try {
            PreparedStatement requete = c.prepareStatement(
                    "DELETE FROM Carre WHERE Nom = ?");
            requete.setString(1, nomp);
            ResultSet r = requete.executeQuery(requete.toString());
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return null;
    }
}
