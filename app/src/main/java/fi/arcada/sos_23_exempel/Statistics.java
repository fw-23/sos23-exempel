package fi.arcada.sos_23_exempel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Statistics {

    public static ArrayList<DataItem> getSampleData() {
        ArrayList<DataItem> dataItems = new ArrayList<>();
        String[] names = { "Helsingfors", "Esbo", "Tammerfors", "Vanda", "Uleåborg", "Åbo", "Jyväskylä", "Kuopio", "Lahtis", "Björneborg", "Kouvola", "Joensuu", "Villmanstrand", "Tavastehus", "Vasa", "Seinäjoki", "Rovaniemi", "S:t Michel", "Salo", "Kotka", "Borgå", "Karleby", "Hyvinge", "Lojo", "Träskända", "Raumo", "Kervo", "Kajana", "S:t Karins", "Nokia", "Ylöjärvi", "Kangasala", "Nyslott", "Riihimäki", "Raseborg", "Imatra", "Reso", "Brahestad", "Sastamala", "Torneå", "Idensalmi", "Valkeakoski", "Kurikka", "Kemi", "Varkaus", "Jämsä", "Fredrikshamn", "Nådendal", "Jakobstad", "Heinola", "Äänekoski", "Pieksämäki", "Forssa", "Ackas", "Orimattila", "Loimaa", "Nystad", "Ylivieska", "Kauhava", "Kuusamo", "Pargas", "Lovisa", "Lappo", "Kauhajoki", "Ulvsby", "Kankaanpää", "Kalajoki", "Mariehamn", "Alavo", "Pemar", "Lieksa", "Grankulla", "Nivala", "Kides", "Vittis", "Mänttä-Vilppula", "Närpes", "Keuru", "Nurmes", "Alajärvi", "Saarijärvi", "Orivesi", "Högfors", "Somero", "Letala", "Hangö", "Kuhmo", "Kiuruvesi", "Pudasjärvi", "Nykarleby", "Kemijärvi", "Oulainen", "Kumo", "Suonenjoki", "Ikalis", "Haapajärvi", "Harjavalta", "Haapavesi", "Outokumpu", "Virdois", "Kristinestad", "Parkano", "Viitasaari", "Etseri", "Kannus", "Pyhäjärvi", "Kaskö" };
        double[] values = { 658457, 297132, 244223, 239206, 209551, 195137, 144473, 121543, 120027, 83482, 80454, 77261, 72634, 67971, 67615, 64736, 64180, 52122, 51400, 51241, 51149, 47909, 46880, 45988, 45226, 38959, 37232, 36493, 35497, 34884, 33533, 32622, 32547, 28521, 27484, 25655, 24810, 24260, 23998, 21333, 20958, 20695, 20197, 19982, 19973, 19767, 19702, 19579, 19097, 18344, 18318, 17253, 16573, 16467, 15808, 15628, 15463, 15357, 15312, 15165, 15086, 14643, 14203, 12890, 12669, 12662, 12412, 11742, 11197, 11041, 10543, 10396, 10396, 9877, 9870, 9563, 9562, 9443, 9423, 9311, 9117, 8978, 8717, 8563, 8456, 7979, 7928, 7759, 7702, 7497, 7105, 7102, 6951, 6891, 6877, 6802, 6785, 6613, 6506, 6465, 6380, 6286, 6070, 5484, 5390, 4964, 1289 };

        for (int i=0; i < names.length; i++) {
            dataItems.add(new DataItem(names[i], values[i]));
        }

        return dataItems;
    }

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
        double median = sorted.get(middle);

        // Om datamängden har jämnt antal
        if (sorted.size() % 2 == 0) {
            median = (sorted.get(middle) + sorted.get(middle-1)) / 2;
        }

        return median;
    }

    public static double calcMean(ArrayList<Double> values) {
        System.out.println(values.size());

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

    /**
     * Lånad från 2022 (se video på itslearning)
     */
    public static double calcMode(ArrayList<Double> dataset) {
        HashMap<Double, Integer> valueCount = new HashMap<>();

        for (double dataValue: dataset) {
            Integer count = valueCount.get(dataValue);

            // Om vi inte tidigare räknat detta värde, sätt det till 0
            if (count == null)  count = 0;
            // Öka counten för detta värde med 1
            valueCount.put(dataValue, count+1);
            //valueCount.put(dataValue, (count == null ? 0 : count) + 1);

            /* Om vi tänker JSON skulle det se ut så här (fast vi ju inte får ha double som nycklar...)
                {   268.0: 1,  316.0, 3 ...
             */
        }
        int maxCount = 0;
        double modeValue = 0.0;

        // Enklast att loopa HashMap med keyset()
        for (Double dataValue: valueCount.keySet()) {
            Integer curCount = valueCount.get(dataValue);

            // Om det nuvarande värdet är högre än det senast funna högsta värdet
            if (curCount > maxCount) {
                maxCount = curCount;
                modeValue = dataValue;
            }
        }
        return modeValue;

    }

    /**
     * Glidande medelvärde fönster 3 (Simple Moving Avg)
     */
    static double[] sma3(double[] dataset) {
        double[] ma = new double[dataset.length];

        for (int i = 2; i < dataset.length; i++) {
            ma[i] = (dataset[i] + dataset[i-1] + dataset[i-2])/3;
        }
        return ma;
    }

    /**
     * Glidande medelvärde (Simple Moving Avg)
     */
    static double[] sma(double[] dataset, int window) {
        double[] ma = new double[dataset.length];

        for (int i = window-1; i < dataset.length; i++) {
            double sum = 0;
            // Inre loop loopar igenom window
            for (int j = 0; j < window; j++) {
                sum += dataset[i-j]; // addera window-värdet till summan
            }
            ma[i] = sum/window;
        }
        return ma;
    }

}
