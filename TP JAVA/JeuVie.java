import java.util.*;


public class JeuVie {
    static final Scanner input = new Scanner(System.in);
    static final Random rand = new Random();
  
    enum Cell{DEAD, ALIVE}
    int size ;
    Cell[][] ecosysteme ;
    int[][] voisines ;
  
    /**
     * Renvoie vrai avec une probabilité p
     * @param p la probabilité de tirage vrai souhaitée
     * @return  le tirage vrai ou faux
     */
    public boolean tireProba(double p){
        if(rand.nextDouble() < p) return true ;
        return false ;
    }
  
    /**
     * Constructeur d'un jeu de la vie de taille n.
     * Initialisé avec nxn cellules dont p% sont vivantes
     * @param n la taille du coté de l'écosystème
     */
    public JeuVie(int n, double p){
        size = n;
        ecosysteme = new Cell[size][size];
        for (int i=0; i<size;i++)
        {
            for (int u=0; u<size; u++)
            {
                if (tireProba(p))
                {
                    ecosysteme[i][u] = Cell.ALIVE;
                }
                else
                {
                    ecosysteme[i][u] = Cell.DEAD;

                }
            }
        
        }
        for (int i=0; i<size;i++)
        {
            for (int u=0; u<size; u++)
            {
                
            }
    
        }
    }
    

    public static void main(String[] args) {
        
    }
    
  }