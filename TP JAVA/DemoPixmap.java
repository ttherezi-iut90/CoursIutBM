import java.io.IOException;

/**
 * Created by zulupero on 09/11/15.
 */
public class DemoPixmap {

    public static byte[][] traceCadre(byte[][] imgIn, int e){
        final int I_DIM = imgIn.length ;
        final int J_DIM = imgIn[0].length ;

        byte[][] imgOut = new byte[I_DIM][J_DIM] ;
        
        //faire un traitement sur l'image en negatif
        for(int i=0; i<I_DIM; i++)
            for(int j=0; j<J_DIM; j++)
                imgOut[i][j] = (byte) (255 - imgIn[i][j]) ;

        return imgOut ;
    }


    public static void main(String[] args) {
        BytePixmap img;
        try {
            img = new BytePixmap(args[0]);         // lecture du fichier
        } catch (IOException e) { img = null; System.exit(0); }
        System.out.println("image lue : "+ img.height+"x"+img.width);

        byte[][] imgIn = new byte[img.height][img.width] ;
        byte[][] imgOut;

         /*
         * image 1D dans imgIn 2D
         */
        for(int i=0; i< img.height; i++)
            for(int j=0; j<img.width; j++)
                imgIn[i][j] = img.data[i*img.width + j] ;

        /*
        * Appels aux fonctions de traitement
        */
        imgOut = traceCadre(imgIn, 3) ;
	
        /*
         * imgIn 2D dans img 1D
         */
        for(int i=0; i< img.height; i++)
            for(int j=0; j<img.width; j++)
                img.data[i*img.width + j] = imgOut[i][j] ;

	    // écriture de l'image de sortie
        img.write("neg_"+args[0]);                
        }
}

