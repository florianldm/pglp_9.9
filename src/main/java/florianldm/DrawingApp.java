package florianldm;

import java.util.ArrayList;
import java.util.Scanner;

public class DrawingApp {
    /**
     * Méthode exec qui contient la boucle des interactions.
     * entre l'application et l'utilisateur.
     */
    public void exec() throws CommandeException{
        String commande = "";
        Scanner cmd = new Scanner(System.in);
        ArrayList<Forme> formes = new ArrayList<Forme>();
        GroupeDao g = new GroupeDao();
        DrawingTUI d = new DrawingTUI();
        System.out.println("Bienvenue, tapez help "
                + "pour voir les commandes !");

        while (!commande.equals("quit")) {
            commande = cmd.nextLine();
            if (!commande.equals("quit") && !commande.equals("help") && !commande.equals("") && (commande.startsWith("cr") || commande.startsWith("ce") || commande.startsWith("tr") || commande.startsWith("rc") || commande.startsWith("move") || commande.startsWith("delete") || commande.startsWith("gp"))) {
                d.nextCommand(commande, formes, g).execute();
                d.nextCommand("print", formes, g).execute();
            }
            if (commande.equals("help")) {
                System.out.println("Commandes:");
                System.out.println("Quitter: quit");
                System.out.println("****************************");
                System.out.println("CREER une forme: ");
                System.out.println("Cercle: ce+numero(attachés) = position x,"
                        + "position y,rayon ");
                System.out.println("Triangle: tr+numero(attachés) = position x,position y,"
                        + "position2x,position2y,position3x,position3y ");
                System.out.println("Rectangle: rc+numero(attachés) ="
                        + " hauteur,largeur,position x,position y");
                System.out.println("Carre: cr+numero(attachés) = positionx,positiony,taille");
                System.out.println("****************************");
                System.out.println("CREER un Groupe:");
                System.out.println("gp+numero(attachés) = nomforme1,nomforme2 etc..");
                System.out.println("****************************");
                System.out.println("SUPPRIMER une forme: ");
                System.out.println("delete nomforme ou delete nomgroupe");
                System.out.println("****************************");
                System.out.println("DEPLACER des formes:");
                System.out.println("move nomgroupe ou move nomforme");
            }
        }

    }
}
