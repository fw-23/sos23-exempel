package fi.arcada.sos_23_exempel;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;

public class DataLine {

    double[] dataValues;
    String label;
    int startPosition; // x offset
    int color; // t.ex. Color.BLUE ger ett heltal

    // Konstruktormetod som vi anropar när vi skapar ett objekt av denna klass
    public DataLine(double[] dataValues, String label, int startPosition, int color) {
        this.dataValues = dataValues;
        this.label = label;
        this.startPosition = startPosition;
        this.color = color;
    }

    public List<Entry> getEntries() {

        List<Entry> entries = new ArrayList<>();

        for (int i = 0; i < dataValues.length; i++) {
            entries.add(new Entry(i, (float) dataValues[i]));
        }
        return entries;
    }


}
