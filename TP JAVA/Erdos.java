import java.util.*;



public class Erdos {


    static boolean tireProba(double parseInt)
    {

        double n =  Math.random();
        if (n<= parseInt)
            return true;
        else
            return false;

    }




    


    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);

        StdDraw.setXscale(-1.2, 1.2);
        StdDraw.setYscale(-1.2, 1.2);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.02);
        double angle = (Math.PI*2)/n;

        for (int i = 0; i < n; i++) 
        {


            StdDraw.point(Math.cos(angle*i), Math.sin(angle*i));

            
        }

        StdDraw.setPenRadius(0.001);
        for(int i = 0; i<n;i++)
        {
            for(int u =0; u<n;u++)
            {
                if (tireProba(p))
                    StdDraw.line(Math.cos(angle*i), Math.sin(angle*i), Math.cos(angle*u), Math.sin(angle*u));
            }
        }




    }

}
