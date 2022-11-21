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

public class Reversi {
    

    /**
     * Réordonne les valeurs du tableau d'entier tab de tab[0] à tab[nbval] en sens opposé
     * @param tab 
     * @param nbval
     */
    static void permuteTab(int [] tab, int nbval){
        int tmp;
        for (int i=0; i<(nbval/2);i++)
        {
            tmp = tab[i];
            tab[i]=tab[nbval-1-i];
            tab[nbval-1-i]=tmp;

        }
    }

    /***
     * crée et retour un tableau de n valeur, allant dans l'ordre de 1 à n
     * @param n
     * @return 
     */
    static int [] creeTabInt(int n){

        int [] tab = new int[n];
        for (int i=0;i<n;i++ )
        {

            tab[i]=i+1;

        }
        
        return tab;
    }
    


    

    static void shuffle(int [] tab){

        int n = tab.length;
        int tmp;



    }


    public static void main(String[] args) {
        
    }


}
