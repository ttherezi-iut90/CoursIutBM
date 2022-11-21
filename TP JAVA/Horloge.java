import java.util.*;

public class Horloge {

    // hours = Calendar.getInstance().get(Calendar.HOUR) ;
    // minutes = Calendar.getInstance().get(Calendar.MINUTE) ;
    // seconds = Calendar.getInstance().get(Calendar.SECOND) ;

    public static void main(String[] args) {

        StdDraw.setTitle(Calendar.getInstance().get(Calendar.HOUR) + " : " + Calendar.getInstance().get(Calendar.MINUTE)
                + " . " + Calendar.getInstance().get(Calendar.SECOND));

        StdDraw.setXscale(-1.2, 1.2);
        StdDraw.setYscale(-1.2, 1.2);

        double angle = (Math.PI * 2) / 12;
        double angleHeure = (Math.PI * 2) / 12;
        double angleMinute = (Math.PI * 2) / 60;
        double angleSeconde = (Math.PI * 2) / 60;
        double angleMilli = (Math.PI * 2) / 60000;

        double milli = 0;
        double seconde = 0;
        double minutes = 0;
        double heure = 0;

        StdDraw.enableDoubleBuffering();

        while (true) {
            StdDraw.clear(StdDraw.GRAY);

            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setPenRadius(0.04);
            StdDraw.filledCircle(0, 0, 1.1);

            StdDraw.setPenColor(StdDraw.BLUE);
            for (int i = 0; i < 12; i++) {

                StdDraw.point(Math.cos(angle * i), Math.sin(angle * i));

            }

            milli = Calendar.getInstance().get(Calendar.MILLISECOND);
            seconde = Calendar.getInstance().get(Calendar.SECOND);
            minutes = Calendar.getInstance().get(Calendar.MINUTE);
            heure = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

            StdDraw.setTitle((int) heure + " : " + (int) minutes + " . " + (int) seconde);

            ////////////////////// SECONDE

            StdDraw.setPenColor(StdDraw.YELLOW);
            StdDraw.setPenRadius(0.007);

            StdDraw.line(0, 0, Math.sin(angleMilli * (seconde * 1000 + milli)) * 0.8,
                    Math.cos(angleMilli * (seconde * 1000 + milli)) * 0.8);

            ////////// MINUTE

            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.setPenRadius(0.006);

            StdDraw.line(0, 0, Math.sin(angleMinute * (minutes + (seconde / 60))) * 0.6,
                    Math.cos(angleMinute * (minutes + (seconde / 60))) * 0.6);

            ///////////////// HEURE

            StdDraw.setPenColor(StdDraw.GREEN);
            StdDraw.setPenRadius(0.004);

            StdDraw.line(0, 0, Math.sin(angleHeure * (heure + (minutes / 60))) * 0.4,
                    Math.cos(angleHeure * (heure + (minutes / 60))) * 0.4);

            StdDraw.show();

            StdDraw.pause(10);

        }
    }

}
