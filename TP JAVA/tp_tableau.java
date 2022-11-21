
import java.lang.Thread.State;
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;


class MonthsTab
{

    public static void main(String[] args) {
    
        
        final String[] mois = {"","janvier","fevrier","mars","avril","mai","juin","juillet","aout","septembre","octobre","novembre","décembre"};



        for (int i = 0; i<mois.length; i++)

        System.out.println(mois[i]);
    }

     
}




class SommTab{


    static final Scanner input = new Scanner(System.in);
    static final int BORNE_MAX = 10;


    static int[] generatTab( int tab[])
    {
        for (int i = 0; i< tab.length ; i++)
        {
            tab[i] = (int)(Math.random()*BORNE_MAX *(-(BORNE_MAX/2)));
            // -(BORNE_MAX/2)
            if (Math.random() <0.5)
                tab[i] = -tab[i];
                
        }

        return tab;
    }



    static int[] additionnalTab(int tab1[], int tab2[])
    {

        int[] sommeTab = new int[tab1.length]; 

        for (int i = 0; i < tab1.length ; i++)
        {
            
            sommeTab[i] = tab1[i]+tab2[i];  

        }

        return sommeTab;

    }

    static void printTab(int tab[])
    {

        for (int i = 0; i< tab.length ; i++)
        {
            System.out.print(tab[i]+",");
        }
        System.out.println();
    }

static int[] tabPositifNegatif (int tab[])
{
    int tabPosNeg[]= new int[2];
    int nbPos=0;
    int nbNeg = 0;
    for(int i=0; i<tab.length;i++)
    {
        if (tab[i]>=0)
            nbPos++;
        else
            nbNeg++;
    }
    tabPosNeg[0] = nbPos;
    tabPosNeg[1]= nbNeg;
   
    return tabPosNeg;
}  

static int Schtroumpf(int[] tab1, int[] tab2)
    {
        int TT=0;
        for (int i =0;i<tab2.length;i++)
        {
            for(int u=0; u<tab1.length; u++)
            {
                TT = TT + (tab2[i]*tab1[u]);
            }
        }    
        
    System.out.println("TT = " + TT);
    
    return TT;
       
    
    }

static int recherche(int tab[],int val)
{

    int place = -1;
    for (int i =0; i< tab.length; i++)
    {
        if (tab[i]==val)
            place ++;
    }

    place = place +1;
    if (place < 0 )
        System.out.println("pas val dans le tableau" );
    else 
        System.out.println("val apparait  " + place + " fois");

        return place; 









    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        




        int n;
        do {
        System.out.println("entrer n : ");
        n = input.nextInt();
        }while(n<1);
        int tab1[] = new int[n];

        int tab2[] = new int[n];
        
        
        
        SommTab.generatTab(tab1);
        SommTab.generatTab(tab2);

        int TT = Schtroumpf(tab1, tab2);
    }














}




