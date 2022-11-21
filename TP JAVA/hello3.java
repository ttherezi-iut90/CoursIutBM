import java.util.*;
CONST println : System.out.println ;


class Hello3 {
  static final Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    int entier;
    double reel;
    String chaine;

    // input.useLocale(Locale.ROOT);

     System.out.println("Entrer un entier : ");
     entier = input.nextInt();
     println("Donner un mot : ");
     chaine = input.next();
     System.out.println("Valeurs saisies : " + entier + " " + chaine);
  }

}
