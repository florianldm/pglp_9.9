package florianldm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RectangleDaoJDBC extends DaoAbstrait {
    /**
     * Constructeur.
     * @param c connexion à la BD.
     */
    public RectangleDaoJDBC(final Connection c) {
        super(c);
    }

    /**
     * Retrouve un rectangle avec un nom.
     * @param o le rectangle.
     * @return le rectangle trouvé.
     */
    @Override
    public Object get(final Object o) {
        Rectangle p = (Rectangle) o;
        Rectangle p1 = null;
        String nomp = p.getNom();
        try {
            PreparedStatement requete = c.prepareStatement(
                    "SELECT * FROM Rectangle WHERE nom = ?");
            requete.setString(1, nomp);
            ResultSet r = requete.executeQuery(requete.toString());
            Point position = new Point(r.getInt(1), r.getInt(2));
            p1 = new Rectangle(r.getString(0),
                    r.getInt(3), r.getInt(4), position);
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return p1;
    }

    /**
     * Ajoute un rectangle dans la BD.
     * @param o le rectangle à ajouter.
     * @return null.
     */
    @Override
    public Object save(final Object o) {
        Rectangle p = (Rectangle) o;
        String nomp = p.getNom();
        try {
            PreparedStatement requete = c.prepareStatement(
                    "INSERT INTO Rectangle VALUES (?, ?, ?, ?, ?)");
            requete.setString(1, nomp);
            requete.setInt(2, p.getHauteur());
            requete.setInt(3, p.getLargeur());
            requete.setInt(4, p.getPosition().getX());
            requete.setInt(4, p.getPosition().getY());
            ResultSet r = requete.executeQuery(requete.toString());
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return null;
    }

    /**
     * Mettre à jour un rectangle dans la BD.
     * @param o le rectangle.
     * @param nom le rectangle à modifier.
     * @return null.
     */
    @Override
    public Object update(final Object o, final String nom) {
        Rectangle p = (Rectangle) o;
        String nomp = p.getNom();
        try {
            PreparedStatement requete = c.prepareStatement(
                    "UPDATE Rectangle SET Nom = ?, Hauteur = ?, "
                            + "Largeur = ?, PosX = ?, PosY = ? WHERE Nom = ?");
            requete.setString(1, nomp);
            requete.setInt(2, p.getHauteur());
            requete.setInt(3, p.getLargeur());
            requete.setInt(4, p.getPosition().getX());
            requete.setInt(5, p.getPosition().getY());
            requete.setString(6, nom);
            ResultSet r = requete.executeQuery(requete.toString());
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return null;
    }

    /**
     * Supprime un rectangle.
     * @param o le rectangle à supprimer.
     * @return null.
     */
    @Override
    public Object delete(final Object o) {
        Rectangle p = (Rectangle) o;
        String nomp = p.getNom();
        try {
            PreparedStatement requete = c.prepareStatement(
                    "DELETE FROM Rectangle WHERE Nom = ?");
            requete.setString(1, nomp);
            ResultSet r = requete.executeQuery(requete.toString());
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return null;
    }
}
