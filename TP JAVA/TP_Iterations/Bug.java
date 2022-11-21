/**
 * Created by zulupero on 20/06/16.
 */
import java.awt.*;

public class Bug extends Buggle {
    public Bug(int posx, int posy, int dir) {
        super(posx, posy, dir);
    }

    public void enRoute() {

        setVitesse(100);
        /*
        while(isFaceMur()==false)
        {
            
            avance();
        }
        */

        /*
        while (isSurBiscuit()==false)
        {
            
            avance();
        }
        prendBiscuit();
        */

        /*
        int nbPasFaits=0;

        while (isSurBiscuit()==false)
        {
            nbPasFaits++;
            avance();
        }
        prendBiscuit();
        retourne();
        avance(nbPasFaits);
        retourne();
        */


        /*
        int nbPasFaits=0;
        int nbBiscuitpris=0;

        while((nbBiscuitpris<4) && (isFaceMur()==false))
        {
            avance();
            nbPasFaits++;
            if (isSurBiscuit() == true)
            {
                prendBiscuit();
                nbBiscuitpris++;
            }

        }
            retourne();
            avance(nbPasFaits);
            retourne();

        */


        /*
        int nbPasFaits=0;
        int nbBiscuitpris=0;
        int nbPV=9;
        boolean life=true;

        while((nbBiscuitpris<4) && (isFaceMur()==false) && life)
        {
            
            avance();
            nbPasFaits++;

            if( getCouleurSol().equals(StdDraw.YELLOW)  )
            {
                nbPV--;
                if(isSurBiscuit() == true)
                {
                    prendBiscuit();
                    nbBiscuitpris++;
                    nbPV--;
                }
            }
            else
            {
                if(isSurBiscuit() == true)
                {
                    prendBiscuit();
                    nbBiscuitpris++;
                
                }
            }

            
            
            if(nbPV<=0)
            {
                setCouleur(StdDraw.BLACK);
                life=false;
                baisseBrosse();
                

            }

        }

        if (life)
        {
    
            retourne();
            avance(nbPasFaits);
            retourne();

        }
        */

        int NBR_TOUR=10;
        int coefCouleur = ((225-128)/(NBR_TOUR*4)*0);
        Color couleurPiste = new Color(255,255,255) ;


        setX(10);
        setY(0);

        for (int i = 0;i<(4*NBR_TOUR);i++)
        {

            baisseBrosse();
            setCouleur(couleurPiste);
            do
            {
                avance();
            }
            while(isFaceMur()==false);

            gauche();
            if (i%4==0)
            {

               couleurPiste = new Color(255-coefCouleur*i,255-coefCouleur*i,255-coefCouleur*i) ;
                
            }

        }


        
    }
}
