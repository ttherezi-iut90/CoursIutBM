class Hello {

    public void lireDiagonaleHautDroite(int[][] tableau) {
        for (int i = 0; i < tableau.length; i++) {
            for (int j = i, k = 0; j >= 0 && k < tableau[i].length; j--, k++) {
                System.out.print(tableau[j][k] + " ");
            }
            System.out.println();
        }
        for (int i = 1; i < tableau[0].length; i++) {
            for (int j = tableau.length - 1, k = i; j >= 0 && k < tableau[i].length; j--, k++) {
                System.out.print(tableau[j][k] + " ");
            }
            System.out.println();
        }
    }
    

    public  static void main (String[] args)
    {
        int [][] tableau = {{1,2,3,4,5},
                            {6,7,8,9,10},
                            {11,12,13,14,15},
                            {16,17,18,19,20},
                            {21,22,23,24,25}};
        Hello h = new Hello();
        h.lireDiagonaleHautDroite(tableau);
    }
}