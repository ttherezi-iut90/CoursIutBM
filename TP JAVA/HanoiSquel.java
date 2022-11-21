class Hanoi {

    // Affiche les liste des étapes de résolution du problème des tours de
    // Hanoï, où il faut déplacer 'n' disques du piquet 'source' vers le
    // piquet 'destination', en utilisant éventuellement un troisième
    // piquet : 'intermediaire'.
    //
    // Retourne le nombre de mouvements effectués.
    static int hanoi(int n, char source, char destination, char intermediaire)
    {
        int nmouv;
       
       /* votre code ici */
        return nmouv;
    }
    
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Hanoi <n>");
        } else {
            int n = Integer.parseInt(args[0]);
            int nmouv;
            System.out.println("# Résolution des tours de Hanoï pour n = " +
                               n + "...");
            nmouv = hanoi(n, 'A', 'C', 'B');
            System.out.println();
            System.out.println("# ... résolution en " + nmouv + " mouvement" +
                               (nmouv == 1 ? "" : "s"));
        }
    }
}
