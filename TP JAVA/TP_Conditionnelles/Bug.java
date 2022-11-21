/**
 * Created by zulupero on 20/06/16.
 */
public class Bug extends Buggle {
    public Bug(int posx, int posy, int dir) {
        super(posx, posy, dir);
    }

    public void enRoute() throws InterruptedException {
            
            String ligne; 
            double i=0 , o =0; 

            while (Main.input.hasNext()) { // lit une ligne du fichier
                i = i+1;
            ligne = Main.input.nextLine();

            if (ligne.charAt(0)>='A' && ligne.charAt(0)<='Z')
            {
                o = o+ 1;
            } 


            }
    
    
            double rep = (o/i*100);
    
    
            System.out.println (rep + "%");
    }
}
