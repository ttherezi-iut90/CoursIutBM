/**
 * Created by zulupero on 20/06/16.
 */
import static java.lang.System.exit;

import javax.activation.ActivationDataFlavor;
import javax.lang.model.util.ElementScanner6;
public class Bug extends Buggle {
    public Bug(int posx, int posy, int dir) {
        super(posx, posy, dir);
    }


int mode = 0,i = 0; 
int Sommeangle = 90;
public void modegauche()
        {
            while(Sommeangle!=0 && isSurBiscuit()==false)
            {
                gauche();
                if (isFaceMur() == true)
                {   
                    droite();

                    if (isFaceMur() == true)
                    {
                        droite();
                        Sommeangle = Sommeangle+90;
                                

                    }
                    else
                    {
                        avance();
                        Sommeangle = Sommeangle;
                               

                    }

                }
                else
                {
                    avance();
                    Sommeangle = Sommeangle - 90;
                    
                    
                }
            }
            return;
        }

        public void TtDroit()
            {
                while(isFaceMur()==false)
                {
                avance();
                
                }
                droite();
                Sommeangle = Sommeangle+90;
                return;
            }






    public void enRoute() {
        

        setX(4);
        setY(3);
        setCouleur(StdDraw.BLUE);
        baisseBrosse();
        
        setVitesse(10000000);
        
       while (isSurBiscuit()==false)
       {    
            
        if (Sommeangle == 0)
        {
            TtDroit();
        } 
        
        modegauche();

        
          




       }
        
    }
}



/* switch(mode)
            {
            case 0:
                
                setDirection("N");


                while(isFaceMur()==false)
                {
                    avance();
                }    
                mode =1;
                droite()            
                break;

            case 1:

            gauche();
            if (isFaceMur() == true)
            {   
                droite();

                if (isFaceMur() == true)
                {
                    droite();
                    
                }
                else
                {
                    avance();
                    

                }

            }
            else
            {
                avance();
                
                mode = 0;
                
            }
            break;
            }    
*/