import java.util.Random;

/**
 * Created by zulupero on 01/12/15.
 */
public class GuitarString {
    final Random RAND = new Random();  // pour la génération du bruit blanc
    final double ATTN = 0.994;         // coefficient d'atténuation énergétique
    int toc ;                          // compteur de pas de simulation
    RingBuffer buf ;                   // le RingBuffer de la corde
    System out = new System.out;

    /**
     * Constructeur. Alloue un RingBuffer de capacité Fe/freq
     * @param freq
     */
    public GuitarString(double freq){
        buf = new RingBuffer((int)Math.round((StdAudio.SAMPLE_RATE/freq)+(1/2)));
    }

    /**
     * Initialise le buffer avec du bruit blanc
     */
    public void pluck(){
        while (!buf.isFull()){
            buf.enqueue(RAND.nextDouble()-0.5);
        }
    }

    /**
     * execute un pas de simulation
     */
    public void tic(){
        double result = (buf.buffer[buf.first]+buf.buffer[(buf.first+1)%buf.buffer.length])/2;
        buf.dequeue();
        buf.enqueue(result);
        toc++;
    }

    /**
     * retourne le prochain échantillon à envoyer sur la sorte audio (en tête de file du RingBuffer)
     * @return
     */
    public double sample(){
        double result = buf.pick();
        return result;
    }


    public int time(){
        return toc;
    }

    /* public static void main(String[] args) {
        
        double f0 = 659.26; // case7 corde5
        double f1 = 783.99; // case10 corde5
        double f2 = 587.33; // case10 corde6
        double f3 = 523.25; // case8 corde6
        double f4 = 987.77; // case7 corde6
        GuitarString corde5case7 = new GuitarString(f0);
        GuitarString corde5case10 = new GuitarString(f1);
        GuitarString corde6case10 = new GuitarString(f2);
        GuitarString corde6case8 = new GuitarString(f3);
        GuitarString corde6case7 = new GuitarString(f4);
        corde5case7.pluck();
        corde5case10.pluck();
        corde6case10.pluck();
        corde6case8.pluck();
        corde6case7.pluck();

        for (int j = 0; j <= StdAudio.SAMPLE_RATE; j++) {
            StdAudio.play(corde5case7.sample());
            corde5case7.tic();
        }
         

        for (int j = 0; j <= StdAudio.SAMPLE_RATE; j++) {
            StdAudio.play(corde5case7.sample());
            corde5case7.tic();
        } 

        for (int j = 0; j <= StdAudio.SAMPLE_RATE; j++) {
            StdAudio.play(corde5case10.sample());
            corde5case10.tic();
        } 

        for (int j = 0; j <= StdAudio.SAMPLE_RATE; j++) {
            StdAudio.play(corde5case7.sample());
            corde5case7.tic();
        } 

        for (int j = 0; j <= StdAudio.SAMPLE_RATE; j++) {
            StdAudio.play(corde6case10.sample());
            corde6case10.tic();
        } 

        for (int j = 0; j <= StdAudio.SAMPLE_RATE; j++) {
            StdAudio.play(corde6case8.sample());
            corde6case8.tic();
        } 

        for (int j = 0; j <= StdAudio.SAMPLE_RATE; j++) {
            StdAudio.play(corde5case7.sample());
            corde6case7.tic();
        } 
        
        StdAudio.close();

        
    } */


    public static void main(String[] args) {
        
        double C = 261.6;
        double Cd = 277.2;
        double D = 293.7;
        double Dd = 311.1;
        double E = 329.6;
        double F = 349.2;
        double Fd = 369.9;
        double G = 392.0;
        double Gd = 415.3;
        double A = 440.0;
        double Ad = 466.2;
        double B = 493.9;
        

        


        GuitarString LA = new GuitarString(A);
        GuitarString LAd = new GuitarString(Ad);
        GuitarString SI = new GuitarString(B);
        GuitarString DO = new GuitarString(C);
        GuitarString DOd = new GuitarString(Cd);
        GuitarString RE = new GuitarString(D);
        GuitarString REd = new GuitarString(Dd);
        GuitarString MI = new GuitarString(E);
        GuitarString FA = new GuitarString(F);
        GuitarString FAd = new GuitarString(Fd);
        GuitarString SOL = new GuitarString(G);
        GuitarString SOLd = new GuitarString(Gd);
        

        LA.pluck();
        LAd.pluck();
        SI.pluck();
        DO.pluck();
        DOd.pluck();
        RE.pluck();
        REd.pluck();
        MI.pluck();
        FA.pluck();
        FAd.pluck();
        SOL.pluck();
        SOLd.pluck();
        

        

        for (int j = 0; j <= StdAudio.SAMPLE_RATE; j++) {
            StdAudio.play(DO.sample());
            DO.tic();
        }

        

        for (int j = 0; j <= StdAudio.SAMPLE_RATE; j++) {
            StdAudio.play(RE.sample());
            RE.tic();
        }

        do{
            char str = system.in.read();
        }while(true); 



        for (int j = 0; j <= StdAudio.SAMPLE_RATE; j++) {
            StdAudio.play(MI.sample());
            MI.tic();
        }

        for (int j = 0; j <= StdAudio.SAMPLE_RATE; j++) {
            StdAudio.play(FA.sample());
            FA.tic();
        }

        for (int j = 0; j <= StdAudio.SAMPLE_RATE; j++) {
            StdAudio.play(LA.sample());
            LA.tic();
        }

        

        for (int j = 0; j <= StdAudio.SAMPLE_RATE; j++) {
            StdAudio.play(SI.sample());
            SI.tic();
        }
    }
}
