import java.util.List;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;

public class CercleTab {
   

    public static void cercle(int xc,int yc, int r) {
        
    }

    public static void trace(List<int[]> liste, Color Color ) {
        for(int i=0;i<liste.size();i++)
        {
            StdDraw.setPenColor(Color);
            StdDraw.point(liste.get(i)[0], liste.get(i)[1]);
        }
    }


    public static void main(String[] args) {
    final int SIZE = 512;
    // 1 pixel par unité
    StdDraw.setCanvasSize(SIZE, SIZE);
    StdDraw.setXscale(-SIZE/2, SIZE/2);
    StdDraw.setYscale(-SIZE/2, SIZE/2);

    List<int[]> lCercle1;
    List<int[]> lCercle2;
    //lCercle1 = cercle(0,0,120);
    //lCercle2 = cercle(100,50,80);

    trace(lCercle1, StdDraw.BLUE);
    trace(lCercle2, StdDraw.GREEN);
}
}