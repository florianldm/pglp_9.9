package florianldm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Base {
    /** Connexion avec BD. */
    private static Connection c;

    /**
     * Gestion de la base de données.
     * Etablissement de la connexion.
     */
    public static void create() throws SQLException {
        try {
            c = DriverManager.getConnection("jdbc:derby:bd; create = true");
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }

    /**
     * Suppression des tables de la BD.
     * @param c1 la connexion à la BD.
     */
    public static void drop(final Connection c1) throws SQLException {
        Statement s = c1.createStatement();
        try {
            s.execute("DROP TABLE Groupe");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            s.execute("DROP TABLE Cercle");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            s.execute("DROP TABLE Rectangle");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            s.execute("DROP TABLE Carre");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            s.execute("DROP TABLE Triangle");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Création des tables de la BD.
     * @param c1 connexion à la BD.
     * @throws SQLException .
     */
    public static void createTables(final Connection c1) throws SQLException {
        Statement s = c1.createStatement();
        try {
            s.execute("CREATE TABLE Groupe "
                    + "(Nom VARCHAR(40), Nom_P VARCHAR(40)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            s.execute("CREATE TABLE Cercle (Nom VARCHAR(40) PRIMARY KEY" +
                    ", PosX INT, PosY INT, Rayon INT)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            s.execute("CREATE TABLE Carre "
                    + "(Nom VARCHAR(40) PRIMARY KEY, PosX INT, PosY INT, Rayon INT");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            s.execute("CREATE TABLE Rectangle "
                    + "('Nom VARCHAR(40) PRIMARY KEY, Hauteur INT,"
                    + " Largeur INT, PosX INT, PosY INT");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            s.execute("CREATE TABLE Triangle "
                    + "('Nom VARCHAR(40) PRIMARY KEY, Pos1X INT, Pos1Y INT, "
                    + "Pos2X INT, Pos2Y INT, Pos3X INT, Pos3Y INT");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode fermant la connexion.
     * @throws SQLException .
     */
    public static void closeConnection() throws SQLException {
        if(c != null) {
            c.close();
        }
    }
}
