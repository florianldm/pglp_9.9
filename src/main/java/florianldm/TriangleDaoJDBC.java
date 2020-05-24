package florianldm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TriangleDaoJDBC extends DaoAbstrait {
    /**
     * Constructeur.
     * @param c connexion à la BD.
     */
    public TriangleDaoJDBC(final Connection c) {
        super(c);
    }

    /**
     * Retrouve un triangle avec un nom.
     * @param o le triangle.
     * @return le triangle trouvé.
     */
    @Override
    public Object get(final Object o) {
        Triangle p = (Triangle) o;
        Triangle p1 = null;
        String nomp = p.getNom();
        try {
            PreparedStatement requete = c.prepareStatement(
                    "SELECT * FROM Rectangle WHERE nom = ?");
            requete.setString(1, nomp);
            ResultSet r = requete.executeQuery(requete.toString());
            Point position1 = new Point(r.getInt(1), r.getInt(2));
            Point position2 = new Point(r.getInt(3), r.getInt(4));
            Point position3 = new Point(r.getInt(5), r.getInt(6));
            p1 = new Triangle(r.getString(0), position1, position2, position3);
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return p1;
    }

    /**
     * Ajoute un triangle dans la BD.
     * @param o le triangle à ajouter.
     * @return null.
     */
    @Override
    public Object save(final Object o) {
        Triangle p = (Triangle) o;
        String nomp = p.getNom();
        try {
            PreparedStatement requete = c.prepareStatement(
                    "INSERT INTO Triangle VALUES (?, ?, ?, ?, ?, ?, ?)");
            requete.setString(1, nomp);
            requete.setInt(2, p.getP1().getX());
            requete.setInt(3, p.getP1().getY());
            requete.setInt(4, p.getP2().getX());
            requete.setInt(5, p.getP2().getY());
            requete.setInt(6, p.getP3().getX());
            requete.setInt(7, p.getP3().getY());
            ResultSet r = requete.executeQuery(requete.toString());
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return null;
    }

    /**
     * Mettre à jour un triangle dans la BD.
     * @param o le triangle.
     * @param nom le triangle à modifier.
     * @return null.
     */
    @Override
    public Object update(final Object o, final String nom) {
        Triangle p = (Triangle) o;
        String nomp = p.getNom();
        try {
            PreparedStatement requete = c.prepareStatement(
                    "UPDATE Triangle SET Nom = ?, Pos1X = ?, "
                            + "Pos1Y = ?, Pos2X = ?, Pos2Y = ?, "
                            + "Pos3X = ?, Pos3Y = ?, WHERE nom = ?");
            requete.setString(1, nomp);
            requete.setInt(2, p.getP1().getX());
            requete.setInt(3, p.getP1().getY());
            requete.setInt(4, p.getP2().getX());
            requete.setInt(5, p.getP2().getY());
            requete.setInt(6, p.getP3().getX());
            requete.setInt(7, p.getP3().getY());
            requete.setString(8, nom);
            ResultSet r = requete.executeQuery(requete.toString());
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return null;
    }

    /**
     * Supprime un triangle.
     * @param o le triangle à supprimer.
     * @return null.
     */
    @Override
    public Object delete(final Object o) {
        Triangle p = (Triangle) o;
        String nomp = p.getNom();
        try {
            PreparedStatement requete = c.prepareStatement(
                    "DELETE FROM Triangle WHERE Nom = ?");
            requete.setString(1, nomp);
            ResultSet r = requete.executeQuery(requete.toString());
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return null;
    }
}
