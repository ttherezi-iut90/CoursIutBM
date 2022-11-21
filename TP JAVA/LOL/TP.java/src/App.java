import java.util.*;
/* 
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int n;=
        double somme =0.0;
        System.out.println("entrez le parametre n : ");
        n = input.nextInt();

        while (n<=0)
        {
            for (int i=1;i<=n; i++)
            {
                somme = somme +(1.0/i);
            }
        }

        System.out.println("total : "+ somme);

    }
}
*/


/*
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int n;
        
        System.out.println("entrez le parametre n : ");
        n = input.nextInt();

       for (int u=0; u<=n;u++)
       {
        for(int i =1; i<=u;i++)
        {
            System.out.print(i+" ");
        }
            System.out.println();
       }
    }
}
*/

/*
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int n, m;
        
        do 
        {
            System.out.println("entrez le parametre n : ");
            n = input.nextInt();
            m = input.nextInt();
        }while( n > m );


        for (int i = n; i<=m; i++)
        {

            System.out.println(i + " " + i*i + " "+ i*i*i);
            
        }         
    }
}

*/


public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int MAX =12;
        for (int u = 1;u<=10;u++)
        {
            for (int i= 1; i<=MAX;i++)
            {
                System.out.print(u + "*"+ i +" = " + (u*i)+ '\t');

            }
        }        
     

        
    }
}




