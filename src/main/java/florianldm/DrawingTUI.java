package florianldm;

import java.util.ArrayList;
import java.util.Iterator;

public class DrawingTUI {

    /**
     * Interprétation des commandes.
     * @param cmd commandes entrée par l'utilisateur.
     * @param liste liste des formes.
     * @param g les groupes.
     * @return commande.
     */
    public Commande nextCommand(final String cmd, final
    ArrayList<Forme> liste, final GroupeDao g) {
        if (cmd.startsWith("ce") || cmd.startsWith("cr"
                + "") || cmd.startsWith("rc") || cmd.startsWith("tr")) {
            if (cmd.startsWith("ce")) { //cercle
                //Exemple commande: ce1 = 0,0,20
                String[] s = cmd.split("=");
                String nomcercle = s[0].trim();
                String params = s[1];
                String[] s2 = params.trim().split(",");
                int posx = Integer.parseInt(s2[0]);
                int posy = Integer.parseInt(s2[1]);
                int rayon = Integer.parseInt(s2[2]);
                return addCercle(nomcercle, posx, posy, rayon, liste);

            } else if (cmd.startsWith("cr")) { //carre
                //Exemple commande: cr1 = 0,5,50
                String[] s = cmd.split("=");
                String nomcarre = s[0].trim();
                String params = s[1];
                String[] s2 = params.trim().split(",");
                int posx = Integer.parseInt(s2[0]);
                int posy = Integer.parseInt(s2[1]);
                int taille = Integer.parseInt(s2[2]);
                return addCarre(nomcarre, posx, posy, taille, liste);

            } else if (cmd.startsWith("rc")) { //rectangle
                //Exemple commande: rc = 0,5,50
                String[] s = cmd.split("=");
                String nomrectangle = s[0].trim();
                String params = s[1];
                String[] s2 = params.trim().split(",");
                int hauteur = Integer.parseInt(s2[0]);
                int largeur = Integer.parseInt(s2[1]);
                int posx = Integer.parseInt(s2[2]);
                int posy = Integer.parseInt(s2[3]);
                return addRectangle(nomrectangle, hauteur,
                        largeur, posx, posy, liste);

            } else if (cmd.startsWith("tr")) { //triangle
                //Exemple commande: tr1 = 0,5,0,2,0,4
                String[] s = cmd.split("=");
                String nomtriangle = s[0].trim();
                String params = s[1];
                String[] s2 = params.trim().split(",");
                int pos1x = Integer.parseInt(s2[0]);
                int pos1y = Integer.parseInt(s2[1]);
                int pos2x = Integer.parseInt(s2[2]);
                int pos2y = Integer.parseInt(s2[3]);
                int pos3x = Integer.parseInt(s2[4]);
                int pos3y = Integer.parseInt(s2[5]);
                return addTriangle(nomtriangle, pos1x, pos1y,
                        pos2x, pos2y, pos3x, pos3y, liste);

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
            return moveForme(nomforme, posx, posy, liste, g);

        } else if (cmd.startsWith("delete")) { //Commande DELETE
            String[] cmd1 = cmd.split(" ");
            String nomforme = cmd1[1].trim();
            return deleteForme(nomforme, liste, g);

        } else if (cmd.startsWith("quit")) { //Commande QUIT
            System.out.println("Fermeture");
        } else if (cmd.equals("print")) { //Commande PRINT
            return afficheDessin(liste, g);

        } else if (cmd.startsWith("gp")) { //Commande GROUPE
            //gp45 = ce1,rc2,cr47
            String[] cmd1 = cmd.split("=");
            String nomgroupe = cmd1[0].trim();
            String[] formesgroupe = cmd1[1].trim().split(",");
            return createGroupe(nomgroupe, formesgroupe, liste, g);
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
    private Commande addCercle(final String nom, final int posx,
                               final int posy, final int rayon,
                               final ArrayList<Forme> liste) {
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
    private Commande addCarre(final String nom, final int posx,
                              final int posy, final int taille,
                              final ArrayList<Forme> liste) {
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
    private Commande addRectangle(final String nom, final int hauteur,
                                  final int largeur, final int posx,
                                  final int posy,
                                  final ArrayList<Forme> liste) {
        Rectangle rectangle = new Rectangle(nom, hauteur,
                largeur, new Point(posx, posy));
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
    private Commande addTriangle(final String nom, final int pos1x,
                                 final int pos1y, final int pos2x,
                                 final int pos2y, final int pos3x,
                                 final int pos3y,
                                 final ArrayList<Forme> liste) {
        Triangle triangle = new Triangle(nom, new Point(pos1x, pos1y),
                new Point(pos2x, pos2y), new Point(pos3x, pos3y));
        liste.add(triangle);
        return new CommandeTriangle(triangle);
    }

    /**
     * Appel de la commande pour déplacer une forme.
     * @param nom de la forme.
     * @param posx position x nouvelle.
     * @param posy position y nouvelle.
     * @param liste des formes.
     * @param groupes groupes.
     * @return Commande.
     */
    private Commande moveForme(final String nom, final int posx,
                               final int posy,
                               final ArrayList<Forme> liste,
                               final GroupeDao groupes) {
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

            ArrayList<Groupe> groupesamettreajour = new ArrayList<Groupe>();
            //Suppression de la forme dans ses groupes (ancienne version)
            for (Iterator i = groupes.getAll().iterator(); i.hasNext();) {
                Object objet = i.next();
                Groupe g = (Groupe) objet;
                for (Iterator j = g.getFormes().iterator(); j.hasNext();) {
                    Object o = j.next();
                    Forme ff = (Forme) o;
                    if (ff.getNom().equals(nom)) {
                        j.remove();
                        groupesamettreajour.add(g);
                       // g.getFormes().add(f);
                    }
                }
            }
            //Mise a jour de la forme dans les groupes
            for (Groupe gg : groupesamettreajour) {
                gg.add(f);
            }

            return new CommandeMove(f2, new Point(posx, posy));
        }

        //Partie déplacement de groupe.
        int ok2 = 0;
        Groupe groupeadeplacer = null;
        if (nom.startsWith("gp")) {
            //Recherche du groupe s'il existe
            for (Groupe gg : groupes.getAll()) {
                if (gg.getNom().equals(nom)) {
                    ok2 = 1;
                    groupeadeplacer = gg;
                    break;
                }
            }
            if (ok2 == 1) {
                ArrayList<Forme> formeamettreajour = new ArrayList<Forme>();
                for (Iterator i = groupeadeplacer.
                        //Deplacement des éléments du groupe
                        getFormes().iterator(); i.hasNext();) {
                    Object o = i.next();
                    Forme ff = (Forme) o;
                    if (ff.getNom().startsWith("cr")) {
                        Carre c = (Carre) ff;
                        ff.move(new Point(
                                c.getPosition().getX() + posx,
                                c.getPosition().getY() + posy));
                    } else if (ff.getNom().startsWith("ce")) {
                        Cercle c1 = (Cercle) ff;
                        ff.move(new Point(
                                c1.getCentre().getX() + posx,
                                c1.getCentre().getY() + posy));
                    } else if (ff.getNom().startsWith("rc")) {
                        Rectangle r1 = (Rectangle) ff;
                        ff.move(new Point(
                                r1.getPosition().getX() + posx,
                                r1.getPosition().getY() + posy));
                    } else {
                        ff.move(new Point(posx, posy));
                    }
                    //On supprime l'ancienne version de la forme.
                    for (Iterator j = liste.iterator(); j.hasNext();) {
                        Object o2 = j.next();
                        Forme fff = (Forme) o2;
                        if (fff.getNom().equals(ff.getNom())) {
                            j.remove();
                            formeamettreajour.add(ff);
                        }
                    }
                }
                //mise a jour des formes dans la liste.
                for (Forme ff : formeamettreajour) {
                    liste.add(ff);
                }

                return new CommandeMove(groupeadeplacer,
                        new Point(posx, posy));
            }
        }

        return null;
    }

    /**
     * Commande pour supprimer une forme.
     * @param nom de la forme.
     * @param liste des formes.
     * @param groupes groupes.
     * @return commande.
     */
    private Commande deleteForme(final String nom,
                                 final ArrayList<Forme> liste,
                                 final GroupeDao groupes) {
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

            //Suppression de la forme dans les groupes
            for (Iterator i = groupes.getAll().iterator(); i.hasNext();) {
                Object objet = i.next();
                Groupe g = (Groupe) objet;
                for (Iterator j = g.getFormes().iterator(); j.hasNext();) {
                    Object o = j.next();
                    Forme ff = (Forme) o;
                    if (ff.getNom().equals(nom)) {
                        j.remove();
                    }
                }
                //Suppression d'un groupe s'il est vide.
                if (g.getFormes().isEmpty()) {
                    i.remove();
                }
            }

            return new CommandeDelete();
        }

        //Suppression d'un groupe.
        if (nom.startsWith("gp")) {
            for (Iterator l = groupes.getAll().iterator(); l.hasNext();) {
                Object o = l.next();
                Groupe gg = (Groupe) o;
                if (gg.getNom().equals(nom)) {
                    l.remove();
                }
            }
            return new CommandeDelete();
        }
        return new CommandeDelete();
    }

    /**
     * Création d'un groupe.
     * @param nomgroupe .
     * @param formes que l'on veut ajouter au groupe.
     * @param g groupes.
     * @param liste liste de formes.
     * @return Commande.
     */
    private Commande createGroupe(final String nomgroupe,
                                  final String[] formes,
                                  final ArrayList<Forme> liste,
                                  final GroupeDao g) {
        Groupe groupe = new Groupe(nomgroupe);
        int pb = 0;
        for (int i = 0; i < formes.length - 1; i++) {
            for (int k = i + 1; k < formes.length; k++) {
                if (formes[i].equals(formes[k])) {
                    pb = 1;
                    break;
                }
            }
        }

        if (pb == 0) {  //si pas 2 entrées identiques.
            //on regarde si les formes entrées existent.
            for (int k = 0; k < formes.length; k++) {
                for (Forme i : liste) {
                    if (i.getNom().equals(formes[k])) {
                        groupe.add(i);
                    } else {
                        //throw new exception.
                        System.out.println("Entrée inexistante");
                    }
                }
            }
            g.save(groupe);
        }
        return new CommandeGroupe();
    }

    /**
     * Affiche les formes et groupes.
     * @param liste des formes.
     * @param g groupes.
     * @return Commande.
     */
    public Commande afficheDessin(final ArrayList<Forme> liste,
                                  final GroupeDao g) {
        return new CommandePrint(liste, g);
    }
}
