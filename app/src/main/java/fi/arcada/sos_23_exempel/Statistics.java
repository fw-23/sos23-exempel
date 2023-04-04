package fi.arcada.sos_23_exempel;

public class Statistics {

    public static String greet() {
        return "Hej";
    }

    public static double calcMean(double[] values) {
        double total = 0;
        for (int i=0; i < values.length; i++) {
            total += values[i];
        }

        return total / values.length;

    }


}
