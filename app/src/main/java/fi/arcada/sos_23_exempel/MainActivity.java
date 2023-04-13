package fi.arcada.sos_23_exempel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    // deklarera variabler
    TextView outputText;
    EditText inputText;
    RecyclerView recyclerView;

    ArrayList<DataItem> dataItems = new ArrayList<>();
    ArrayList<Double> values = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataItems = Statistics.getSampleData();

        // for-loop
        /*for (int i = 0; i < dataItems.size(); i++) {
            values.add(dataItems.get(i).getValue());
        }*/
        // samma sak med en for each-loop
        for (DataItem item: dataItems) {
            values.add(item.getValue());
        }

        // Vi skapar en koppling mellan vår Java-kod och vår XML-layout
        outputText = findViewById(R.id.outputText);
        inputText = findViewById(R.id.editTextName);
        recyclerView = findViewById(R.id.dataItemsRecyclerView);

        CustomAdapter adapter = new CustomAdapter(this, dataItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        DataItem mittObjekt = new DataItem("Helsingfors", 658457);
        DataItem mittAndraObjekt = new DataItem("Esbo", 297132);

        // HashMap-exempel
        HashMap<String,Double> cities = new HashMap<>();
        cities.put("Helsingfors", 658457.0);
        cities.put("Esbo", 297132.0);

        HashMap<String,DataItem> cityItems = new HashMap<>();
        cityItems.put("manse", new DataItem("Tammerfors", 244223));
        /* JavaScript: cityItems = { manse: { name: "Tammerfors", value: 244223 }}
        *   cityItems.manse.name
        * */

        outputText.setText(String.format("%s: %.2f\nEsbo: %.2f\n%s: %.2f",
                mittObjekt.getName(),
                mittObjekt.getValue(),
                cities.get("Esbo"),
                cityItems.get("manse").getName(),
                cityItems.get("manse").getValue()
        ));


    }

    public void calculate(View view) {

        outputText.setText(String.format("Hej %s\n\nMedelvärde: %.2f\nMedian: %.2f\nStandardavvikelse: %.2f",
                inputText.getText(),
                Statistics.calcMean(values),
                Statistics.calcMedian(values),
                Statistics.calcSD(values)
        ));
    }


}