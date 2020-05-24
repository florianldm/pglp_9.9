package florianldm;

public class CommandeException extends Exception {
    /**
     * Exception pour erreur de commande.
     */
    public CommandeException() {
        System.out.println("Erreur de commande !");
    }

    /**
     * Affichage.
     */
    public void afficheMessage() {
        System.out.println("Erreur de commande !");
    }
}
