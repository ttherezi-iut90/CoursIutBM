import java.security.Timestamp;
import java.sql.Time;
import java.util.function.Function;

public class Profiler {


    static long TotalTime;
    static int CallCount;

    public static Boolean analyse(Function<Double, Boolean> oneMethod, double p){
        long debut = timestamp();
        Boolean res = oneMethod.apply(p);
        long fin = timestamp();
        CallCount ++;
        TotalTime = TotalTime + (fin - debut);
        return res;

    }

    public static void init() {
        CallCount = 0;
        TotalTime = 0;
    }

    public static String getTotalTime() {
        double elapsed = (System.nanoTime() - TotalTime) / 1e9;
            String unit = "s";
            if (elapsed < 1.0) {
                elapsed *= 1000.0;
                unit = "ms";
            }
            return String.format("%.4g%s elapsed", TotalTime, unit);
        
    }

    public static int getCallCount() {
        return CallCount;        
    }

  /* public static double analyse(Function<Double, Double> oneMethod, double p){
          long debut = timestamp();
          double res = oneMethod.apply(p);
          System.out.println(timestamp(debut));
          return res;
   } */

   
  
   

    /**
     * Si clock0 est >0, retourne une chaîne de caractères
     * représentant la différence de temps depuis clock0.
     * @param clock0 instant initial
     * @return expression du temps écoulé depuis clock0
     */
    public static String timestamp(long clock0) {
        String result = null;

        if (clock0 > 0) {
            double elapsed = (System.nanoTime() - clock0) / 1e9;
            String unit = "s";
            if (elapsed < 1.0) {
                elapsed *= 1000.0;
                unit = "ms";
            }
            result = String.format("%.4g%s elapsed", elapsed, unit);
        }
        return result;
    }

    /**
     * retourne l'heure courante en ns.
     * @return
     */
    public static long timestamp() {
        return System.nanoTime();
    }
}