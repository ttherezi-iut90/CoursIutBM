import java.util.*;


public class Rupture {

    /**
     * affiche un tableau mis en parametre
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
     * renvoi un tableau entier 1D des indices de début de séquence croissante (quand tab[i]<=tab[i+1])
     * @param args
     */
    public static void main(String[] args)
    {

        int [] tabValeur = {1, 2, 5, 7, 2, 6, 0, 5, 2, 4, 6, 7, 8, 9, 3, 4, 6, 1, 2, 7, 8, 9, 4, 2, 3, 1, 5, 9, 7, 1, 6, 6, 3};
        afficheTab(tabValeur);

        int [] tabresult;
        
        int i = 0;int n = 0;
        while (i<tabValeur.length) {
            while (tabValeur[i] <= tabValeur[i + 1]) {
                i++;
            }
            tabresult[n] = i;
            n++;
        }

    }




}