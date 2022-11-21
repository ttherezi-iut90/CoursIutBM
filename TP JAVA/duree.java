import java.util.*;

class Duree {
  static final Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    int duree, heure, min, sec;


    // input.useLocale(Locale.ROOT);

     System.out.println("Entrer une duree en seconde: ");
     duree = input.nextInt();

     heure = duree/360;
     min = (duree%360)/60;
     sec = duree%60; 

     System.out.print( duree +" =en seconde : " +heure +" heure, "+min +" minutes , "+ sec +" secondes");

     

  }

}


class charactère {
  static final Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    
      String car;
      int nb;

    // input.useLocale(Locale.ROOT);

    nb = input.nextInt();
    car = input.next();
    for (int u = 0; u <nb ; u++)
    {
      for (int i = 0; i <nb; i++)
        {
          System.out.print(car);
          
        }
        System.out.println();     
        
    }
  }

}



/*
 * Variables :
 * 
 *    car caractère
 *    nb entier 
 * debut:
 *    lire nb
 *    lire car 
 * 
 *    pour i = 0 de nb
 *      ecrire (car)
 * 
 *      
 * 
 * 
 */