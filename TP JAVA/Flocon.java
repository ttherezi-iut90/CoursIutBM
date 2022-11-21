import java.util.*;;

public class Flocon {

    static void CourbeVonkonch(double[] a, double[] b, int n) {

        double deg = Math.PI / 3;

        
        if (n <= 0) {
            StdDraw.line(a[0], a[1], b[0], b[1]);

        } else {
            double[] c = new double[2];
            c[0] = (a[0] + (b[0] - a[0]) / 3);
            c[1] = (a[1] + (b[1] - a[1]) / 3);

            double[] d = new double[2];
            d[0] = (a[0] + 2 * (b[0] - a[0]) / 3);
            d[1] = (a[1] + 2 * (b[1] - a[1]) / 3);

            double[] e = new double[2];
            e[0] = (((c[0] + d[0]) * Math.cos(deg)) - ((d[1] - c[1]) * Math.sin(deg)));
            e[1] = ((c[1] + d[1]) * Math.cos(deg) + (d[0] - c[0]) * Math.sin(deg));

            CourbeVonkonch(a, c, n - 1);
            CourbeVonkonch(c, e, n - 1);
            CourbeVonkonch(e, d, n - 1);
            CourbeVonkonch(d, b, n - 1);

        }

    }

    public static void main(String[] args) {

        StdDraw.setXscale(-0.2, 1.2);
        StdDraw.setYscale(-0.2, 0.7);

        double[] a = {0,0};
        

        double[] b = {1,0};
        

        CourbeVonkonch(a, b, 10);

    }

}
