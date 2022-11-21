/* 
Variables : 
    n,i entier
    somme entier
Debut :
    lire n
    somme :=0
    Pour i de 1 à n faire 
        somme := somme+i
    ecrire "la somme de est " + somme

    */

 import java.util.*;

class SommeN {
  static final Scanner input = new Scanner(System.in);

  public static void main(String[] args) 
  {
    int n, i, somme = 0;

    n=input.nextInt();

     for (i = 1; i<=n; i++)
     {
        somme+=i;
     }

     System.out.println(somme);
     

  }

}


class MaxN {
  static final Scanner input = new Scanner(System.in);

  public static void main(String[] args) 
  {
    int n, max = 0, nbr;
    System.out.println("combien d'entré : ");
    n=input.nextInt();

     for (int i = 1; i<=n; i++)
     {
        System.out.println("entré val : ");
        nbr = input.nextInt();

        if (max < nbr) 
        {
            System.out.println("nouveau max ");
            max = nbr;
            System.out.println(max);
        }
     }

     System.out.println(max);
     

  }

}



class MoyN {
  static final Scanner input = new Scanner(System.in);

  public static void main(String[] args) 
  {
    int n, max = 0, nbr;
    double moy;
    System.out.println("combien d'entré : ");
    n=input.nextInt();

     for (int i = 1; i<=n; i++)
     {
        System.out.println("entré val : ");
        nbr = input.nextInt();

        max = max+ nbr;
        
     }
        moy = max/n;
     System.out.println(moy);
     

  }

}