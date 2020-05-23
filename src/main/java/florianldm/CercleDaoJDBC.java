package florianldm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CercleDaoJDBC extends DaoAbstrait {
    /**
     * Constructeur.
     * @param c connexion à la BD.
     */
    public CercleDaoJDBC(final Connection c) {
        super(c);
    }

    /**
     * Retrouve un Cercle avec un nom.
     * @param o le cercle.
     * @return le cercle trouvé.
     */
    @Override
    public Object get(final Object o) {
        Cercle p = (Cercle) o;
        Cercle p1 = null;
        String nomp = p.getNom();
        try {
            PreparedStatement requete = c.prepareStatement(
                    "SELECT * FROM Cercle WHERE nom = ?");
            requete.setString(1, nomp);
            ResultSet r = requete.executeQuery(requete.toString());
            Point position = new Point(r.getInt(1), r.getInt(2));
            p1 = new Cercle(r.getString(0), position, r.getInt(3));
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return p1;
    }

    /**
     * Ajoute un cercle dans la BD.
     * @param o le cercle à ajouter.
     * @return null.
     */
    @Override
    public Object save(final Object o) {
        Cercle p = (Cercle) o;
        String nomp = p.getNom();
        try {
            PreparedStatement requete = c.prepareStatement(
                    "INSERT INTO Cercle VALUES (?, ?, ?, ?)");
            requete.setString(1, nomp);
            requete.setInt(2, p.getCentre().getX());
            requete.setInt(3, p.getCentre().getY());
            requete.setInt(4, p.getRayon());
            ResultSet r = requete.executeQuery(requete.toString());
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return null;
    }

    /**
     * Mettre à jour un cercle dans la BD.
     * @param o le cercle.
     * @param nom le cercle à modifier.
     * @return null.
     */
    @Override
    public Object update(final Object o, final String nom) {
        Cercle p = (Cercle) o;
        String nomp = p.getNom();
        try {
            PreparedStatement requete = c.prepareStatement(
                    "UPDATE Cercle SET Nom = ?, PosX = ?, "
                            + "PosY = ?, Rayon = ? WHERE nom = ?");
            requete.setString(1, nomp);
            requete.setInt(2, p.getCentre().getX());
            requete.setInt(3, p.getCentre().getY());
            requete.setInt(4, p.getRayon());
            requete.setString(5, nom);
            ResultSet r = requete.executeQuery(requete.toString());
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return null;
    }

    /**
     * Supprime un cercle.
     * @param o le cercle à supprimer.
     * @return null.
     */
    @Override
    public Object delete(final Object o) {
        Cercle p = (Cercle) o;
        String nomp = p.getNom();
        try {
            PreparedStatement requete = c.prepareStatement(
                    "DELETE FROM Cercle WHERE Nom = ?");
            requete.setString(1, nomp);
            ResultSet r = requete.executeQuery(requete.toString());
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return null;
    }
}
