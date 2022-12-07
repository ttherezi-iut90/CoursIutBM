import java.util.Random;

/**
 * Created by zulupero on 01/12/15.
 */
public class GuitarString {
    final Random RAND = new Random();  // pour la génération du bruit blanc
    final double ATTN = 0.994;         // coefficient d'atténuation énergétique
    int toc ;                          // compteur de pas de simulation
    RingBuffer buf ;                   // le RingBuffer de la corde

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

    public static void main(String[] args) {
        
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

        
    }
}
