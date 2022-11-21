/**
 * Created by zulupero on 20/06/16.
 */
public class Bug extends Buggle {
    public Bug(int posx, int posy, int dir) {
        super(posx, posy, dir);
    }

    public void enRoute() {
      setCouleur(StdDraw.BOOK_LIGHT_BLUE);
      setVitesse (20);

      setX(0);
      setY(0);

      droite();
      avance(7);
      gauche();
      avance();

      baisseBrosse();

      gauche();

      avance(5);

      droite();

      avance();

      baisseBrosse();
      leveBrosse();
      avance();
      droite();
      avance();
      gauche();

      baisseBrosse();
      leveBrosse();
      avance();
      droite();
      avance();
      gauche();

      baisseBrosse();
      leveBrosse();
      avance();
      droite();
      avance();
      gauche();

      baisseBrosse();
      leveBrosse();
      avance();
      droite();
      avance();
      gauche();

      baisseBrosse();
      leveBrosse();
      avance();
      droite();
      avance();
      gauche();

      baisseBrosse();
      avance();
      gauche();
      avance(5);

message("FINIS  ");
setVitesse (1000);

setCouleur(StdDraw.WHITE);

      retourne();
      baisseBrosse();
      for (int val =0; val <4 ;val ++ ) {


      for (int i = 0;i< 5 ;i++ ) {
        avance();
      }
      droite();
      avance();
      droite();
      for (int u =0;u<5 ;u++) {
        avance();
      }
      gauche();
      avance();
      gauche();

}
      retourne();
      avance(2);
      droite();


    }

}
