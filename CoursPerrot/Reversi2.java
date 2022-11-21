
/***********************************************************
 * Reversi.java
 * 
 * Petit jeu Reversi
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 *************************************************************/

import java.util.*;

public class Reversi2 {
    /**
     * Programme qui vérifie que l'entrée de l'utilisateur soit bien un indice d'un
     * tableau donné
     * 
     * @param taille
     */
    static int entreeUtilisateur(int taille) {
        int resultat;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Entrez un indice: ");
            resultat = input.nextInt();
        } while (resultat > taille || resultat < 0);
        return resultat;
    }

    /**
     * Programme qui échange deux valeurs d'un tableau
     * 
     * @param tab
     * @param i
     * @param j
     */
    static void echangeTab(int[] tab, int i, int j) {
        int temp = tab[i];
        tab[i] = tab[j];
        tab[j] = temp;
    }

    /**
     * Programme qui mélange la liste
     * 
     * @param tab
     */
    static void shuffle(int[] tab) {
        int j;
        for (int i = 0; i < tab.length - 1; i++) {
            j = i + 1 + (int) (Math.random() * (tab.length - (i + 1)));
            echangeTab(tab, i, j);
        }
    }

    /**
     * Programme qui échange les n premières valeurs d'un tableau
     * 
     * @param tab
     * @param nbVal
     */
    static void permuteTab(int[] tab, int nbVal) {
        for (int i = 0; i < nbVal / 2; i++) {
            echangeTab(tab, i, nbVal - 1 - i);
        }
    }

    /**
     * Programme pour afficher un tableau
     * 
     * @param tab
     */
    static void afficheTab(int[] tab) {
        System.out.print("Tableau: [" + tab[0]);
        for (int i = 1; i < tab.length; i++) {
            System.out.print("," + tab[i]);
        }
        System.out.println("]");
    }

    /**
     * Renvoie vrai si le tableau en paramètre est bien
     * [ 1, 2, 3, ...., TAILLE], faux sinon
     * 
     * @param tab
     * @return
     */
    static boolean verifTab(int[] tab) {
        int taille = tab.length; // ou NMAX ou TAILLE
        int i = 0;
        while (i < taille && tab[i] == i + 1) {
            i++;
        }
        if (i == taille) {
            return true;
        }
        return false;

    }

    /**
     * Remplit un tableau de valeur de 1 à la taille du tableau
     * 
     * @param tab
     */
    static void initTab(int[] tab) {
        for (int i = 0; i < tab.length; i++) {
            tab[i] = i + 1;
        }
    }

    /**
     * @param tValeurs
     * @return
     */
    public static int joueur(int[] tValeurs) {
        int j = tValeurs.length-1;
        while (tValeurs[j] == j+1)
        {
            j--;
        }
        int i = 0;
        while (tValeurs[i]!=(j+1))
        {
            i++;
        }
        if (i==0){
            return j+1;
        }
        return i;
    }

    public static void main(String args[]){
        
        int TAILLE = 9;
        //int[] tValeurs = new int[TAILLE];
        int[] tValeurs = new int[TAILLE];
        int nbCoups=0;
        initTab(tValeurs);
        shuffle(tValeurs);
        afficheTab(tValeurs);
        do {
            //permuteTab(tValeurs, entreeUtilisateur(TAILLE));
            permuteTab(tValeurs, joueur(tValeurs));
            nbCoups++;
            afficheTab(tValeurs);
        } while (!verifTab(tValeurs));
        System.out.println("Tu as réussi en "+nbCoups+"coups...");
    }
}