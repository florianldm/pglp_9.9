package florianldm;

import java.util.ArrayList;
import java.util.Scanner;

public class DrawingApp {
    /**
     * Méthode exec qui contient la boucle des interactions.
     * entre l'application et l'utilisateur.
     */
    public void exec() {
        String commande = "";
        Scanner cmd = new Scanner(System.in);
        ArrayList<Forme> formes = new ArrayList<Forme>();
        GroupeDao g = new GroupeDao();
        DrawingTUI d = new DrawingTUI();

        while (!commande.equals("quit")) {
            commande = cmd.nextLine();
            if (!commande.equals("quit")) {
                d.nextCommand(commande, formes, g).execute();
                d.nextCommand("print", formes, g).execute();
            }
        }

    }
}
