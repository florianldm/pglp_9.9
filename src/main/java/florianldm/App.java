package florianldm;

/**
 * Application.
 *
 */
public class App {

    /**
     * Constructeur.
     */
    public App() {

    }

    /**
     * Méthode main.
     * @param args .
     */
    public static void main(final String[] args) throws CommandeException {
        DrawingApp d = new DrawingApp();
        d.exec();
    }
}
