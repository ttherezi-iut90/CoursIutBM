import java.util.Scanner;
import java.util.Random;

public class JeuVie {
    static final Scanner input = new Scanner(System.in);
    static final Random rand = new Random();
    static final int CANVAS_WIDTH = (int) (500 * 1.2);
    static final int CANVAS_HEIGHT = 500;

    enum Cell {
        DEAD, ALIVE
    }
//j'ai modifier le code
    int size;
    Cell[][] ecosysteme;
    int[][] voisines;

    /**
     * Renvoie vrai avec une probabilité p
     * 
     * @param p la probabilité de tirage vrai souhaitée
     * @return le tirage vrai ou faux
     */
    public boolean tireProba(double p) {
        if (rand.nextDouble() < p)
            return true;
        return false;
    }

    /**
     * Constructeur d'un jeu de la vie de taille n.
     * Initialisé avec nxn cellules dont p% sont vivantes
     * 
     * @param n la taille du coté de l'écosystème
     */
    public JeuVie(int n, double p) {
        size = n;
        voisines = new int[n][n];
        ecosysteme = new Cell[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (tireProba(p)) {
                    ecosysteme[row][col] = Cell.ALIVE;
                } else {
                    ecosysteme[row][col] = Cell.DEAD;
                }
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                voisines[row][col] = nbVoisines(row, col);
            }
        }
    }

    public JeuVie(int n) {
        size = n;
        boolean clicked = false;
        boolean editing = false;
        double btnX;
        double btnY;
        double btnW = size * .08;
        double btnH = size * .03;
        double mouseX;
        double mouseY;
        int cellRow;
        int cellCol;

        voisines = new int[size][size];
        ecosysteme = new Cell[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                ecosysteme[row][col] = Cell.DEAD;
            }
        }

        btnX = 1.1 * n;
        btnY = .7 * n;

        do {
            dispEco();
            StdDraw.setPenColor(15, 255, 30);
            StdDraw.filledRectangle(btnX, btnY, btnW, btnH);
            StdDraw.setPenColor();
            StdDraw.text(btnX, btnY, "Fin init");
            StdDraw.show();

            mouseX = StdDraw.mouseX();
            mouseY = StdDraw.mouseY();

            if (StdDraw.isMousePressed() && !editing) {
                if (mouseX > btnX - btnH && mouseX < btnX + btnH && mouseY > btnY - btnW && mouseY < btnY + btnW) {
                    clicked = true;
                } else if (mouseX < size && mouseY < size) {
                    editing = true;
                    cellRow = (int) mouseX;
                    cellCol = (int) mouseY;

                    if (ecosysteme[cellRow][cellCol] == Cell.DEAD) {
                        ecosysteme[cellRow][cellCol] = Cell.ALIVE;
                    } else {
                        ecosysteme[cellRow][cellCol] = Cell.DEAD;
                    }
                    for (int row = -1; row <= 1; row++) {
                        for (int col = -1; col <= 1; col++) {
                            voisines[(size + cellRow + row) % size][(size + cellCol + col) % size] = nbVoisines(
                                    (size + cellRow + row) % size,
                                    (size + cellCol + col) % size);
                        }
                    }
                }
            } else if (editing && !StdDraw.isMousePressed()) {
                editing = false;
            }
            StdDraw.pause(50);
        } while (!clicked);

    }

    /**
     * Affice l'état de l'écosystème
     */
    public void dispEco() {
        StdDraw.clear();
        StdDraw.setPenColor();
        StdDraw.line(size, 0, size, size);
        for (int i = 0; i < size; i++) {
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            StdDraw.line(0, i, size, i);
            StdDraw.line(i, 0, i, size);
            for (int j = 0; j < size; j++) {
                if (ecosysteme[i][j] == Cell.ALIVE) {
                    StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.filledCircle(i + .5, j + .5, .5);
                }
                if (size <= 30) {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                    StdDraw.text(i + .5, j + .5, String.valueOf(voisines[i][j]));
                }
            }
        }
        StdDraw.show();
    }

    /**
     * Affice l'état de l'écosystème
     */
    public void dispEco(int gen) {
        dispEco();
        StdDraw.setPenColor();
        StdDraw.text(size * 1.12, .5 * size, "Gen : " + gen);
        StdDraw.show();
    }

    /**
     * Calcule le nombre de cellules voisinnes vivantes
     * 
     * @param i indice de ligne i de la cellule
     * @param j indice de la colonne j de la cellule
     * @return nombre de voisines vivantes de la cellule en (i,j)
     */
    public int nbVoisines(int i, int j) {
        int nbVoisines = 0;
        for (int row = -1; row <= 1; row++) {
            for (int col = -1; col <= 1; col++) {
                if ((row != 0 || col != 0)
                        && ecosysteme[(size + i + row) % size][(size + j + col) % size] == Cell.ALIVE) {
                    nbVoisines++;
                }
            }
        }
        return nbVoisines;
    }

    public int nextGen() {
        int changes = 0;
        int cellVoisines;
        Cell cellState;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cellVoisines = voisines[i][j];
                cellState = ecosysteme[i][j];
                if (cellState == Cell.DEAD && cellVoisines == 3) {
                    ecosysteme[i][j] = Cell.ALIVE;
                    changes++;
                } else if (cellState == Cell.ALIVE && !(cellVoisines == 2 || cellVoisines == 3)) {
                    ecosysteme[i][j] = Cell.DEAD;
                    changes++;
                }
            }
        }
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                voisines[row][col] = nbVoisines(row, col);
            }
        }

        return changes;
    }

    public static void main(String[] args) {
        boolean auto;
        boolean placement;
        int n; // taille de l'ecosystème
        int nb; // nombre de générations à sauter entre deux affichages
        int gen = 0; // numéro de la génération courante
        int cpt; // compteur de générations à sauter entre deux affichages
        int ch; // nombre de changements d'une génération à l'autre
        final double PROBA = 0.5; // pour l'initialisation

        JeuVie jeu;

        System.out.print("Taille de l'ecosystème : ");
        n = input.nextInt();

        System.out.println("Déroulement automatique ? (y)");
        if (input.next().equals("y")) {
            auto = true;
        } else {
            auto = false;
        }

        System.out.println("Placment manuel ? (y)");
        if (input.next().equals("y")) {
            placement = true;
        } else {
            placement = false;
        }

        StdDraw.setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        StdDraw.setXscale(0.0, 1.2 * n); // mise à l'échelle de la fenêtre
        StdDraw.setYscale(0.0, n); // mise à l'échelle de la fenêtre
        StdDraw.enableDoubleBuffering();

        if (placement) {
            jeu = new JeuVie(n);
        } else {
            jeu = new JeuVie(n, PROBA); // création du jeu
        }

        jeu.dispEco(gen); // affichage initial

        if (auto) {
            while (true) {
                ch = jeu.nextGen();
                gen++;
                jeu.dispEco(gen);
                System.out.println("il y a eu " + ch + " changements");
                StdDraw.pause(30);
            }
        } else {
            do {
                System.out.print("Combien de génération avant prochain affichage ? ");
                nb = input.nextInt();
                cpt = 0;
                while (cpt != nb) {
                    ch = jeu.nextGen();
                    System.out.println("il y a eu " + ch + " changements");
                    cpt++;
                }
                jeu.dispEco();
            } while (nb != 0);
        }

        System.exit(1);
    }

}