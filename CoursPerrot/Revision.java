class Revision {

    public static void affiche(int[] t) {
        for (int i = 1; i < t[0] + 1 && i < t.length; i++) {
            System.out.print(t[i] + " ");
        }
        System.out.println();
    }

    public static int taille(int[] t) {
        return t[0];
    }

    public static boolean isVide(int[] t) {
        return t[0] == 0;
    }

    public static boolean isPlein(int[] t) {
        return t[0] == t.length - 1;
    }

    public static void initialise(int[] t, int k) {
        t[0] = k;
        for (int i = 1; i < t[0] + 1 && i < t.length; i++) {
            t[i] = i;
        }

    }

    public static int indice(int[] t, int x) {
        int i = 1;
        while (i < t.length && t[i] <= x) {
            if (t[i] == x)
                return i;

            i++;
        }
        return -1;
    }

    public static void supprimeFin(int[] t) {
        if (!isVide(t))
            t[0] = t[0] - 1;

    }

    public static void ajouteFin(int[] t, int x) {
        if (!isPlein(t) && t[t[0]] <= x  ) {
            t[0] += 1;
            t[t[0]] = x;
        }
    }

    public static void main(String[] args) {

        int[] tab = { 0, 5, 3, 6, 2, 4, 5, 8, 3, 6, 2, 7, 3, 4, 0 };
        int[] tab2 = { 0, 2, 3, 6, 2, 4, 5, 8, 3, 6, 2, 7, 3, 4, 0 };

        affiche(tab);
        System.out.println(taille(tab));
        affiche(tab2);
        System.out.println(taille(tab2));
        System.out.println(isVide(tab));
        System.out.println(isPlein(tab));
        System.out.println(isVide(tab2));
        System.out.println(isPlein(tab2));
        int[] tab3 = new int[7];
        initialise(tab3, 6);
        affiche(tab3);
        System.out.println(indice(tab3, 4));
        supprimeFin(tab3);
        affiche(tab3);
        ajouteFin(tab3, 9);
        affiche(tab3);
        ajouteFin(tab3, 10);
        affiche(tab3);

    }

}
