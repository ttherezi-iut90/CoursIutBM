import java.util.*;

public class TableMultiplication {

    public static void initCercle() {
        StdDraw.setXscale(-1.2, 1.2);
        StdDraw.setYscale(-1.2, 1.2);

        StdDraw.filledCircle(0, 0, 1.001);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledCircle(0, 0, 0.999);
        StdDraw.setPenRadius(0.001);
        StdDraw.setPenColor(StdDraw.BLUE);

    }

    public static double[][] preCalc(int n) {
        double[][] TabPosition = new double[n][2];
        double angle = (Math.PI * 2) / n;
        for (int i = 0; i < n; i++) {
            TabPosition[i][0] = Math.cos(angle * i);
            TabPosition[i][1] = Math.sin(angle * i);
        }
        return TabPosition;
    }

    public static void drawTT(int n, int tt, double[][] TabPosition) {

        

        StdDraw.line(TabPosition[n][0], TabPosition[n][1], TabPosition[(n * tt) % TabPosition.length][0],
                TabPosition[(n * tt) % TabPosition.length][1]);

    }
    

    public static void repPoint(double[][] TabPosition) {

        if (TabPosition.length < 21) {
            for (int i = 0; i < TabPosition.length; i++) {
                StdDraw.text(TabPosition[i][0] * 1.1, TabPosition[i][1] * 1.1, String.valueOf(i));
            }
        }
    }



    public static void fonctionP2(int tt,int u) {
        initCercle();

        for (int n = 10; n < 2000; n++) {
            initCercle();
            
            double[][] TabPosition = preCalc(n);
            
            StdDraw.setPenColor(StdDraw.BLUE);
            
            repPoint(TabPosition);
            
            for (int i = 0; i < n; i++) {
                drawTT(i, tt, TabPosition);
                
            }
            StdDraw.show();
            StdDraw.pause(100);
            StdDraw.clear();
           

        }
    }


    public static void DrawTest(int Depart, int Arrive,double[][] TabPosition) {
        StdDraw.line(TabPosition[Depart][0], TabPosition[Depart][1],
             TabPosition[(Arrive) % TabPosition.length][0],
             TabPosition[(Arrive) % TabPosition.length][1]);

    }
    public static void Raytrace(int tt,int n) {
        initCercle();
        double[][] TabPosition = preCalc(n);
        
        
        
        StdDraw.setPenColor(StdDraw.BLUE);
        for (int i=1;i < TabPosition.length;i++ )
        {
           
            

            DrawTest(0, i, TabPosition);
            DrawTest(i, i*2, TabPosition);
            StdDraw.show();
            StdDraw.pause(100);
            

        }

        
    } 
    public static void main(String[] args) {

        StdDraw.enableDoubleBuffering();
        int tt = Integer.parseInt(args[1]);
        int u = Integer.parseInt(args[0]);

        //fonctionP2(tt, u);

        Raytrace(tt, u);





        
    }
}
