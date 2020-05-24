package florianldm;

import java.util.Scanner;

public class DrawingTUI {

    public DrawingTUI() {

    }

    public void nextCommand(final String cmd) {
        if (cmd.startsWith("ce") || cmd.startsWith("cr") || cmd.startsWith("rc") || cmd.startsWith("tr")) {
            if (cmd.startsWith("ce")) {
                //Exemple commande: ce1 = 0,0,20
                String[] s = cmd.split("=");
                String nomcercle = s[0];
                String params = s[1];
                String[] s2 = params.split(",");
                String PosX = s2[0];
                String PosY = s2[1];
                String Rayon = s2[2];
                //appel fonction
            } else if (cmd.startsWith("cr")) {
                //Exemple commande: cr1 = 0,5,50
                String[] s = cmd.split("=");
                String nomcarre = s[0];
                String params = s[1];
                String[] s2 = params.split(",");
                String PosX = s2[0];
                String PosY = s2[1];
                String Taille = s2[2];
                //appel fonction
            } else if (cmd.startsWith("rc")) {
                //Exemple commande: rc = 0,5,50
                String[] s = cmd.split("=");
                String nomrectangle = s[0];
                String params = s[1];
                String[] s2 = params.split(",");
                String Hauteur = s2[0];
                String Largeur = s2[1];
                String PosX = s2[2];
                String PosY = s2[3];
                //appel fonction
            } else if (cmd.startsWith("tr")) {
                //Exemple commande: tr1 = 0,5,0,2,0,4
                String[] s = cmd.split("=");
                String nomtriangle = s[0];
                String params = s[1];
                String[] s2 = params.split(",");
                String Pos1X = s2[0];
                String Pos1Y = s2[1];
                String Pos2X = s2[2];
                String Pos2Y = s2[3];
                String Pos3X = s2[4];
                String Pos3Y = s2[5];
                //appel fonction
            }
        }

    }

    public void afficheDessin() {

    }
}
