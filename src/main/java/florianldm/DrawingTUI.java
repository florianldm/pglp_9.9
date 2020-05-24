package florianldm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class DrawingTUI {

    /**
     * Interprétation des commandes.
     * @param cmd commandes entrée par l'utilisateur.
     * @param liste liste des formes.
     */
    public Commande nextCommand(final String cmd, final ArrayList<Forme> liste, final GroupeDao g) {
        if (cmd.startsWith("ce") || cmd.startsWith("cr") || cmd.startsWith("rc") || cmd.startsWith("tr")) {
            if (cmd.startsWith("ce")) { //cercle
                //Exemple commande: ce1 = 0,0,20
                String[] s = cmd.split("=");
                String nomcercle = s[0].trim();
                String params = s[1];
                String[] s2 = params.trim().split(",");
                int PosX = Integer.parseInt(s2[0]);
                int PosY = Integer.parseInt(s2[1]);
                int Rayon = Integer.parseInt(s2[2]);
                return addCercle(nomcercle, PosX, PosY, Rayon, liste);

            } else if (cmd.startsWith("cr")) { //carre
                //Exemple commande: cr1 = 0,5,50
                String[] s = cmd.split("=");
                String nomcarre = s[0].trim();
                String params = s[1];
                String[] s2 = params.trim().split(",");
                int PosX = Integer.parseInt(s2[0]);
                int PosY = Integer.parseInt(s2[1]);
                int Taille = Integer.parseInt(s2[2]);
                return addCarre(nomcarre, PosX, PosY, Taille, liste);

            } else if (cmd.startsWith("rc")) { //rectangle
                //Exemple commande: rc = 0,5,50
                String[] s = cmd.split("=");
                String nomrectangle = s[0].trim();
                String params = s[1];
                String[] s2 = params.trim().split(",");
                int Hauteur = Integer.parseInt(s2[0]);
                int Largeur = Integer.parseInt(s2[1]);
                int PosX = Integer.parseInt(s2[2]);
                int PosY = Integer.parseInt(s2[3]);
                return addRectangle(nomrectangle, Hauteur, Largeur, PosX, PosY, liste);

            } else if (cmd.startsWith("tr")) { //triangle
                //Exemple commande: tr1 = 0,5,0,2,0,4
                String[] s = cmd.split("=");
                String nomtriangle = s[0].trim();
                String params = s[1];
                String[] s2 = params.trim().split(",");
                int Pos1X = Integer.parseInt(s2[0]);
                int Pos1Y = Integer.parseInt(s2[1]);
                int Pos2X = Integer.parseInt(s2[2]);
                int Pos2Y = Integer.parseInt(s2[3]);
                int Pos3X = Integer.parseInt(s2[4]);
                int Pos3Y = Integer.parseInt(s2[5]);
                return addTriangle(nomtriangle, Pos1X, Pos1Y, Pos2X, Pos2Y, Pos3X, Pos3Y, liste);

            }
        }
        if (cmd.startsWith("move")) { //Commande MOVE
            //move ce1 = 4,5
            String[] cmd1 = cmd.split("=");
            String[] gauche = cmd1[0].split(" ");
            String nomforme = gauche[1].trim();
            String[] destination = cmd1[1].trim().split(",");
            int posx = Integer.parseInt(destination[0]);
            int posy = Integer.parseInt(destination[1]);
            return moveForme(nomforme, posx, posy, liste);

        } else if (cmd.startsWith("delete")) { //Commande DELETE
            String[] cmd1 = cmd.split(" ");
            String nomforme = cmd1[1].trim();
            return deleteForme(nomforme, liste);

        } else if (cmd.startsWith("quit")) { //Commande QUIT

        } else if (cmd.equals("print")) { //Commande PRINT
            return afficheDessin(liste);

        } else if (cmd.equals("gp")) { //Commande GROUPE
            //gp45 = ce1,rc2,cr47
            String[] cmd1 = cmd.split("=");
            String nomgroupe = cmd1[0].trim();
            String[] formes_groupe = cmd1[1].trim().split(",");
            return createGroupe(nomgroupe, formes_groupe, liste, g);
        }
        return null;
    }

    /**
     * Appel de la commande Cercle.
     * @param nom du cercle
     * @param posx position x.
     * @param posy position y.
     * @param rayon cercle.
     * @param liste liste des formes.
     * @return Commande.
     */
    private Commande addCercle(final String nom, final int posx, final int posy, final int rayon, final ArrayList<Forme> liste) {
        Cercle cercle = new Cercle(nom, new Point(posx, posy), rayon);
        liste.add(cercle);
        return new CommandeCercle(cercle);
    }

    /**
     * Appel de la commande Carre.
     * @param nom du carre.
     * @param posx position x.
     * @param posy position y.
     * @param taille carre.
     * @param liste liste des formes.
     * @return Commande.
     */
    private Commande addCarre(final String nom, final int posx, final int posy, final int taille, final ArrayList<Forme> liste) {
        Carre carre = new Carre(nom, new Point(posx, posy), taille);
        liste.add(carre);
        return new CommandeCarre(carre);
    }

    /**
     * Appel de la commande Rectangle.
     * @param nom du rectangle.
     * @param hauteur rectangle.
     * @param largeur rectangle.
     * @param posx position x.
     * @param posy position y.
     * @param liste liste des formes.
     * @return Commande.
     */
    private Commande addRectangle(final String nom, final int hauteur, final int largeur, final int posx, final int posy, final ArrayList<Forme> liste) {
        Rectangle rectangle = new Rectangle(nom, hauteur, largeur, new Point(posx, posy));
        liste.add(rectangle);
        return new CommandeRectangle(rectangle);
    }

    /**
     * Appel de la commande Triangle.
     * @param nom triangle.
     * @param pos1x position x 1er point.
     * @param pos1y position y 1er point.
     * @param pos2x position x 2e point.
     * @param pos2y position y 2e point.
     * @param pos3x position x 3e point.
     * @param pos3y position y 3e point.
     * @param liste liste des formes.
     * @return Commande.
     */
    private Commande addTriangle(final String nom, final int pos1x, final int pos1y, final int pos2x, final int pos2y, final int pos3x, final int pos3y, final ArrayList<Forme> liste) {
        Triangle triangle = new Triangle(nom, new Point(pos1x, pos1y), new Point(pos2x, pos2y), new Point(pos3x, pos3y));
        liste.add(triangle);
        return new CommandeTriangle(triangle);
    }

    /**
     * Appel de la commande pour déplacer une forme.
     * @param nom de la forme.
     * @param posx position x nouvelle.
     * @param posy position y nouvelle.
     * @param liste des formes.
     * @return Commande.
     */
    private Commande moveForme(final String nom, final int posx, final int posy, final ArrayList<Forme> liste) {
        int ok = 0;
        int k = 0;

        for (Forme i : liste) {
            if (i.getNom().equals(nom)) {
                ok = 1;
                break;
            }
            k++;
        }
        if (ok == 1) {
            Forme f = liste.get(k);
            f.move(new Point(posx, posy));
            liste.remove(k);
            liste.add(f);
            Forme f2 = liste.get(k);
            return new CommandeMove(f2, new Point(posx, posy));
        }
        return null;
    }

    /**
     * Commande pour supprimer une forme.
     * @param nom de la forme.
     * @param liste des formes.
     * @return commande.
     */
    private Commande deleteForme(final String nom, final ArrayList<Forme> liste) {
        int ok = 0;
        int k = 0;

        for (Forme i : liste) {
            if (i.getNom().equals(nom)) {
                ok = 1;
                break;
            }
            k++;
        }
        if (ok == 1) {
            liste.remove(k);
            return new CommandeDelete();
        }
        return null;
    }

    /**
     * Création d'un groupe.
     * @param nomgroupe .
     * @param formes que l'on veut ajouter au groupe.
     * @param g groupes.
     * @return
     */
    private Commande createGroupe(final String nomgroupe, final String[] formes, ArrayList<Forme> liste, final GroupeDao g) {
        Groupe groupe = new Groupe(nomgroupe);
        int pb = 0;
        for (int i = 0; i < formes.length - 1; i++) {
            for (int k = i + 1; k < formes.length ; k++) {
                if (formes[i].equals(formes[k])) {
                    pb = 1;
                    break;
                }
            }
        }

        if(pb == 0) {  //si pas 2 entrées identiques
            for (int k = 0; k < formes.length; k++) { //on regarde si les formes entrées existent.
                for (Forme i : liste) {
                    if (i.getNom().equals(formes[k])) {
                        groupe.add(i);
                    } else {
                        //throw new exception
                    }
                }
            }
            g.save(groupe);
        }
        return new CommandeGroupe();
    }

    /**
     * Affiche les formes et groupes
     * @param liste des formes.
     */
    public Commande afficheDessin(final ArrayList<Forme> liste) {
        return new CommandePrint(liste);
    }
}
