/**
 * TD2D
 */
import java.util.*;
public class TD2D {

    static void printTab(int TabMN[][])
    {

        for (int i = 0;i<TabMN.length ;i++){
            for(int u=0;u<TabMN[1].length;u++ ){

                System.out.print(TabMN[i][u] +  " ");
                
            }
            System.out.println();
        }

    }


    static Double Moyenne(int TabMN[][])
    {


        int sommes=0;
        for (int i = 0;i<TabMN.length  ;i++){
            
            for(int u=0;u<TabMN[1].length;u++ ){

               sommes = sommes+ TabMN[i][u];
                
            }

        }
        return ((double)sommes / (TabMN.length*TabMN[1].length));
    }







    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int M=10;
        int N=10;

        
        /*
        do{
            System.out.println("entre val M :");
            M = input.nextInt();
            System.out.println("entre val N :");
            N = input.nextInt();
        }while(!((M >= 10) && (M<=100) && (N >= 10) && (N<=100)) );
        */



        int [][] TabMN = new int[M][N];
        for (int i = 0;i<M  ;i++){
            for(int u=0;u<N;u++ ){

               TabMN[i][u] = 10+((int)(Math.random()*(101-10))); 
                
            }
        }
        
        printTab(TabMN);
        double Moy = Moyenne(TabMN);
        System.out.println(Moy);

        
   }
}