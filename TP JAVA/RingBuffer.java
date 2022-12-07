public class RingBuffer {
    double[] buffer ;  // le tampon de valeurs à proprement parler
    int first;       // indice du prochain élément à supprimer
    int last;        // indice du prochain élément à insérer +1
    int capacity;    // nmbre maximal d'éléments dans le tampon
    int size;        // nombre d'éléments actifs dans le tampon

    /**
     * Constructeur. prend en paramètre la capacité du buffer et
     * alloue le buffer.
     * @param cap
     */
    public RingBuffer(int cap){
        capacity = cap;
        first = 0 ;
        last = 0 ;
        size = 0 ;
        buffer = new double[cap] ;
    }

    /**
     * retourne le nombre d'éléments actifs dans le tampon
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * le tampon est-il vide ?
     * @return
     */
    public boolean isEmpty(){
        return (size==0);
    } 
    
    /**
     * le tampon est-il plein ? (mais c'est pas utile ??)
     * @return
     */
    public boolean isFull(){
        return (size==buffer.length);
    }
    
    /**
     * ajoute l'élément x en fin de tampon
     * @param x
     */
    public void enqueue(double x){
        if( isFull() ) throw new RuntimeException("Erreur file pleine");
        buffer[last]=x;
        last++;
        last%=buffer.length;
        size++;
    }

    /**
     * supprime et retourne l'élément en tête du tampon
     * @return
     */
    public double dequeue(){
        if( isEmpty() ) throw new RuntimeException("Erreur file vide");
        double result = buffer[first];
        first++;
        first%=buffer.length;
        size--;
        return result;

    } 
    
    /**
     * retourne, sans le supprimer, l'élément en tête du tampon
     * @return
     */
    public double pick(){
        if( isEmpty() ) throw new RuntimeException("Erreur file vide");
        double result = buffer[first];
        return result;
    }            


    public void display(){
        System.out.println(capacity);
        System.out.println(first);
        System.out.println(last);
        System.out.println(size);
        System.out.print("[");
        for (double val : buffer){
            System.out.print(val+", ");
        }
        System.out.println(" ]");
    }

    /**
    * méthode de debug
    */
    public static void main(String[] args){
        RingBuffer buf = new RingBuffer(10);
        buf.enqueue(1.5);
        buf.enqueue(2.5);
        buf.enqueue(3.5);
        buf.enqueue(4.5);
        buf.enqueue(5.5);
        buf.enqueue(6.5);
        buf.enqueue(7.5);
        buf.enqueue(8.5);
        buf.enqueue(9.5);
        buf.enqueue(10);
        buf.display();
    }
}