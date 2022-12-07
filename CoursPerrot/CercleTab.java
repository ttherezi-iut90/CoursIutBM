import java.util.List;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;

public class CercleTab {
   

    public static List<int[]> cercle(int xc,int yc, int r) {
        int y = r;
        int x = 0;
        List<int[]> liste = new ArrayList<>();
        int m = 5-4*r;
        
        while(y>x)
        {
            liste.add(new int[]{x+xc,y+yc});
            
            if ( m > 0)
            {
                y--;
                m=m-8*y;
                
            }
            
                m = m + 8*x + 12 ;
                x++;
                
               
            
            
        }

        return liste;
    }

    public static void trace(List<int[]> liste, Color Color ) {
        StdDraw.setPenColor(Color);
        for(int[] point : liste)
        {
            StdDraw.point(point[0], point[1]);
        }
    }


    public static void main(String[] args) {
    final int SIZE = 512;
    // 1 pixel par unité
    StdDraw.setCanvasSize(SIZE, SIZE);
    StdDraw.setXscale(-SIZE/2, SIZE/2);
    StdDraw.setYscale(-SIZE/2, SIZE/2);
/* 
    List<int[]> lSeg = new ArrayList<>();

    for (int i = 0; i<200;i++)
    {
        lSeg.add(new int[]{i,i});
    }
    trace(lSeg, StdDraw.BLUE);
*/
    List<int[]> lCercle1;
    List<int[]> lCercle2;
    lCercle1 = cercle(0,0,120);
    lCercle2 = cercle(100,50,80);

    trace(lCercle1, StdDraw.BLUE);
    trace(lCercle2, StdDraw.GREEN); 
    



}
}