package florianldm;

import java.sql.Connection;

public class FabriqueDaoJDBC {
    /** Connexion vers la BD. */
    private static Connection c;

    /**
     * Constructeur FabriqueDaoJDBC.
     * @param c1 connexion vers BD.
     */
    public FabriqueDaoJDBC(final Connection c1) {
        c = c1;
    }

    /**
     * Retourne un CarreDaoJDBC.
     * @return .
     */
    public static CarreDaoJDBC getCarreDao() {
        return new CarreDaoJDBC(c);
    }

    /**
     * Retourne un CercleDaoJDBC.
     * @return .
     */
    public static CercleDaoJDBC getCercleDao() {
        return new CercleDaoJDBC(c);
    }

    /**
     * Retourne un RectangleDaoJDBC.
     * @return .
     */
    public static RectangleDaoJDBC getRectangleDao() {
        return new RectangleDaoJDBC(c);
    }

    /**
     * Retourne un TriangleDaoJDBC.
     * @return .
     */
    public static TriangleDaoJDBC getTriangleDao() {
        return new TriangleDaoJDBC(c);
    }

    /**
     * Retourne un GroupeDaoJDBC.
     * @return .
     */
    public static GroupeDaoJDBC getGroupeDao() {
        return new GroupeDaoJDBC(c);
    }

}
