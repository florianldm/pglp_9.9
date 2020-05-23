package florianldm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class GroupeDaoJDBC extends DaoAbstrait{
    /**
     * Constructeur.
     * @param c connexion à la BD.
     */
    public GroupeDaoJDBC(final Connection c) {
        super(c);
    }

    /**
     * Cherche un groupe dans la BD avec un nom donné.
     * Pour chaque forme dans le groupe on recherche ses infos et on .
     * reconstruit la liste de formes.
     * @param o groupe à chercher.
     * @return Groupe.
     */
    @Override
    public Object get(final Object o) {
        Groupe g = (Groupe) o;
        String nomg = g.getNom();
        String nomp = "";
        try {
            PreparedStatement requete = c.prepareStatement(
                    "SELECT * FROM Groupe WHERE nom = ?");
            requete.setString(1, nomg);
            ResultSet r = requete.executeQuery(requete.toString());
            while (r != null) {
                while (r.next()) {
                    nomp = r.getString(2);
                    PreparedStatement requete2 = c.prepareStatement(
                            "SELECT * FROM Carre WHERE nom = ? UNION SELECT * FROM Triangle WHERE nom = ?"
                                    + " UNION SELECT * FROM Rectangle WHERE nom = ? UNION "
                                    + "SELECT * FROM Cercle WHERE nom = ?");
                    requete2.setString(1, nomp);
                    requete2.setString(2, nomp);
                    requete2.setString(3, nomp);
                    requete2.setString(4, nomp);
                    ResultSet r2 = requete2.executeQuery(requete2.toString());
                    if (nomp.startsWith("tr")) { //Si l'objet est un triangle
                        Point p1 = new Point(r2.getInt(1), r2.getInt(2));
                        Point p2 = new Point(r2.getInt(3), r2.getInt(4));
                        Point p3 = new Point(r2.getInt(5), r2.getInt(6));
                        Triangle p = new Triangle(r2.getString(0), p1, p2, p3);
                        g.add(p);
                    } else if (nomp.startsWith("cr")) { //Si l'objrt est un carré
                        Point p1 = new Point(r2.getInt(1), r2.getInt(2));
                        Carre p  = new Carre(r2.getString(0), p1, r2.getInt(3));
                        g.add(p);
                    } else if (nomp.startsWith("rc")) { //Si l'objet est un rectangle
                        Point p1 = new Point(r2.getInt(3), r2.getInt(4));
                        Rectangle p = new Rectangle(r2.getString(0),
                                r2.getInt(1), r2.getInt(2), p1);
                        g.add(p);
                    } else if (nomp.startsWith("ce")) { //Si l'objet est un cercle
                        Point p1 = new Point(r2.getInt(1), r2.getInt(2));
                        Cercle p = new Cercle(r2.getString(0), p1, r2.getInt(3));
                        g.add(p);
                    }
                }
                if (requete.getMoreResults()) {
                    r = requete.getResultSet();
                } else {
                    r.close();
                    r = null;
                }
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return g;
    }

    /**
     * Permet d'insérer un groupe dans la BD.
     * Pour le groupe à insérer, on ajoute pour chaque forme .
     * du groupe un tuple nom groupe - nom forme.
     * @param o le groupe (pour le nom).
     * @return null.
     * @throws SQLException
     */
    @Override
    public Object save(final Object o) throws SQLException {
        Groupe g = (Groupe) o;
        ArrayList<Forme> liste = g.getFormes();
        String nomF = "";
        String nomG = "";

        try {
            for (Iterator i = liste.iterator(); i.hasNext();) {
                PreparedStatement requete = c.prepareStatement(
                        "INSERT INTO Groupe VALUES (?, ?)");
                Object objet = i.next();
                Forme p = (Forme) objet;
                nomF = p.getNom();
                nomG = g.getNom();
                requete.setString(1, nomG);
                requete.setString(2, nomF);
                requete.execute();
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return null;
    }

    /**
     * Mettre à jour le nom d'un groupe.
     * @param o le groupe.
     * @return null.
     * @throws SQLException .
     */
    @Override
    public Object update(final Object o, final String nom) throws SQLException {
        Groupe g = (Groupe) o;
        String nomG = g.getNom();

        try {
            PreparedStatement requete = c.prepareStatement(
                    "UPDATE Groupe SET nom = ? WHERE nom = ?");
            requete.setString(1, nomG);
            requete.setString(2, nomG);
            ResultSet r = requete.executeQuery(requete.toString());
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return null;
    }

    /**
     * Suppression d'un groupe dans la table.
     * @param o le groupe à supprimer.
     * @return null.
     * @throws SQLException .
     */
    @Override
    public Object delete(final Object o) throws SQLException {
        Groupe g = (Groupe) o;
        String nomG = g.getNom();
        try {
            PreparedStatement requete = c.prepareStatement(
                    "DELETE FROM Groupe WHERE nom = ?");
            requete.setString(1, nomG);
            ResultSet r = requete.executeQuery(requete.toString());
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return null;
    }
}
