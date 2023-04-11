package fi.arcada.sos_23_exempel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Statistics {

    public static String greet() {
        return "Hej";
    }

    // Metod för att sortera data
    public static ArrayList<Double> sortValues(ArrayList<Double> values) {
        // vi skapar en kopia så vi inte sorterar ursprungliga datamängden
        ArrayList<Double> sorted = new ArrayList<>(values);
        Collections.sort(sorted);
        return sorted;
    }

    public static double calcMedian(ArrayList<Double> values) {
        ArrayList<Double> sorted = sortValues(values);
        int middle = sorted.size()/2;
        return sorted.get(middle);
    }

    public static double calcMean(ArrayList<Double> values) {
        double total = 0;
        for (int i = 0; i < values.size(); i++) {
            total += values.get(i);
        }

        return total / values.size();

    }

    public static double calcSD(ArrayList<Double> values) {
        double mean = calcMean(values);
        double sumOfDiff = 0;
        for (int i = 0; i < values.size(); i++) {
            sumOfDiff += Math.pow(values.get(i)-mean, 2);
        }
        double variance = sumOfDiff / values.size();

        return Math.sqrt(variance);
    }


}
