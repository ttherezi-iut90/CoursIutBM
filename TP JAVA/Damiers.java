import java.util.*;


public class Damiers {
    public static void main(String[] args) {
        

    
    int n = Integer.parseInt(args[0]);

    StdDraw.setXscale(0,n);
    StdDraw.setYscale(0,n);

    for (int i =0; i<n;i++ )
        for( int u =0;u<n; u++)
        {
            if ((i+u)%2 == 0)
                StdDraw.setPenColor(StdDraw.RED);
            else
                StdDraw.setPenColor(StdDraw.BLACK);

        StdDraw.filledSquare(i+0.5, u+0.5, 0.5);
        }

    }
}