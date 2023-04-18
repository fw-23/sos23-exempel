package fi.arcada.sos_23_exempel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // deklarera variabler
    TextView outputText;
    EditText inputText, inputValue;
    RecyclerView recyclerView;
    CustomAdapter adapter;

    ArrayList<DataItem> dataItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //dataItems = Statistics.getSampleData();

        // Vi skapar en koppling mellan vår Java-kod och vår XML-layout
        outputText = findViewById(R.id.outputText);
        inputText = findViewById(R.id.dataName);
        inputValue = findViewById(R.id.dataValue);
        recyclerView = findViewById(R.id.dataItemsRecyclerView);

        adapter = new CustomAdapter(this, dataItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void calculate(View view) {

        if (inputValue.getText() == null) return;

        dataItems.add(new DataItem(
                inputText.getText().toString(),
                Double.parseDouble(inputValue.getText().toString())
        ));

        adapter.notifyDataSetChanged();

        // Skapa values-arraylist med endast värden
        ArrayList<Double> values = new ArrayList<>();
        for (DataItem item: dataItems) {
            values.add(item.getValue());
        }

        if (values.size() < 2) {
            outputText.setText("Mera data behövs...");
            return;
        }

        outputText.setText(String.format("Medelvärde: %.2f\nMedian: %.2f\nStandardavvikelse: %.2f\nTypvärde: %.2f",
                Statistics.calcMean(values),
                Statistics.calcMedian(values),
                Statistics.calcSD(values),
                Statistics.calcMode(values)
        ));
    }


}