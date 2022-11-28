import java.util.*;

import javax.swing.plaf.basic.BasicTabbedPaneUI.TabSelectionHandler;

public class Rupture {

    /**
     * affiche un tableau mis en parametre
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
     * affiche un tableau mis en parametre
     * 
     * @param tab
     */
    static void afficheTab2D(int[][] tab) {

        System.out.print("Tableau: [ " );
        for (int j = 0; j < tab.length; j++) {

            System.out.print("\n ["+ tab[j][0] );

            for (int i = 1; i < tab[j].length; i++) {


                System.out.print("," + tab[j][i]);
            }
            System.out.print("]") ;

        }

        System.out.println("\n  ]");
    }

    public static int[] RuptureSimple(int[] tabValeur) {

        int cptSequence = 1;

        for (int i = 1; i < tabValeur.length; i++) {
            if (tabValeur[i] <= tabValeur[i - 1]) {
                cptSequence++;
            }
        }

        int[] tabresult = new int[cptSequence];

        int numSequence = 1;
        for (int i = 1; i < tabValeur.length; i++) {
            if (tabValeur[i] <= tabValeur[i - 1]) {
                tabresult[numSequence] = i;
                numSequence++;
            }
        }
        return tabresult;
    }


    public static int[][] sequence(int[] tab) {

        int[] tabRupture = RuptureSimple(tab);
        int[][] tSequence = new int [tabRupture.length][];
        int taille = tabRupture.length; 
        for (int i = 0; i < taille -1; i++) {
            tSequence[i] = new int [tabRupture[i+1]-tabRupture[i]];
            for (int j = tabRupture[i];j< tabRupture[i+1];j++)
            {
                tSequence[i][j - tabRupture[i]] = tab[j];
            }
        

            tSequence[i] = new int [tab.length - tabRupture[taille-1]];

            for (int j = tabRupture[taille-1]; j < taille; j++) {
                tSequence[taille -1][j-tabRupture[taille-1]] = tab[j];
            }
        }

        return tSequence;
    }

 
/**
 * Fonction permettant de trier par ordre croissant un tableau grace au tri par Insertion
 * @param tab
 */
public static void triInsert(int [] tab) {
    int taille = tab.length;
    int valeur;
    int limite;
    int place;

    for ( limite = 1; limite <taille-1;limite++)
    {
        valeur = tab[limite];
        place = limite;
        while ((place>0) && (tab[place-1]>valeur))
        {
            tab[place] = tab[place-1];
            place = place -1;
        }
        tab[place] = valeur;
    }
}



    /**
     * renvoi un tableau entier 1D des indices de début de séquence croissante
     * (quand tab[i]<=tab[i+1])
     * 
     * @param args
     */
    public static void main(String[] args) {

        int[] tabValeur = { 1, 2, 5, 7, 2, 6, 0, 5, 2, 4, 6, 7, 8, 9, 3, 4, 6, 1, 2, 7, 8, 9, 4, 2, 3, 1, 5, 9, 7, 1, 6,6, 3 };
        afficheTab(tabValeur);
        int [][] tab2 = {{1,2,4,5,6},{3,5,2,1,6},{5,6,6}};


       
        triInsert(tabValeur);
        afficheTab(tabValeur);

    }

}