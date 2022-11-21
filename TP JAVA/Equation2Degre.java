import java.util.*;

class Equation2Degre {
  static final Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    double a,b,c;
    double delta;
    double x0,x1;



    // input.useLocale(Locale.ROOT);

     System.out.println("Entrer a, b ,c : ");
     a = input.nextInt();
     b = input.nextInt();
     c = input.nextInt();

     delta = ((b*b) - (4*a*c));
     System.out.println(delta);

     if (delta == 0)
     {
        System.out.println("l'equation a x*x + bx +c = 0 a une sol : ");
        x0 = (-1*b)/(2*a);
        System.out.println(x0);

     }
     else if (delta > 0)
     {
        System.out.println("l'equation a x*x + bx +c = 0 a 2 sol : ");
        x0 = ((-1*b) + Math.sqrt(delta)) /(2*a);
        System.out.println(x0);
        x1 = ((-1*b)-(Math.sqrt(delta)))/(2*a);
        System.out.println(x1);
        
     }
     else
     {
        System.out.println("l'equation a x*x + bx +c = 0 n'as pas de sol reel: ");
     }
     
    

     

  }

}
