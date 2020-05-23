package florianldm;

public class FabriqueDao {
    /**
     * Méthode retournant un GroupeDao.
     * @return GroupeDao.
     */
    public static Dao<Groupe> getGroupeDao() {
        return new GroupeDao();
    }

    /**
     * Méthode retournant un CarreDao.
     * @return CarreDao.
     */
    public static Dao<Carre> getCarreDao() {
        return new CarreDao();
    }

    /**
     * Méthode retournant un CercleDao.
     * @return CercleDao.
     */
    public static Dao<Cercle> getCercleDao() {
        return new CercleDao();
    }

    /**
     * Méthode retournant un RectangleDao.
     * @return RectangleDao.
     */
    public static Dao<Rectangle> getRectangleDao() {
        return new RectangleDao();
    }

    /**
     * Méthode retournant un TriangleDao.
     * @return TriangleDao.
     */
    public static Dao<Triangle> getTriangleDao() {
        return new TriangleDao();
    }

}
