package fi.arcada.sos_23_exempel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // deklarera variabler
    TextView outputText;
    EditText inputText;

    double[] values = { 3.5, 5, 8.6, 23, 7, 9, 5, 3, 2 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vi skapar en koppling mellan vår Java-kod och vår XML-layout
        outputText = findViewById(R.id.outputText);
        inputText = findViewById(R.id.editTextName);

        outputText.setText("...");

        Toast.makeText(this, "Hello!", Toast.LENGTH_LONG).show();

    }

    public void calculate(View view) {

        try {
            outputText.setText(String.format("Hej talet är %.2f",
                    Double.parseDouble(inputText.getText().toString())
            ));
        } catch (NumberFormatException e) {
            outputText.setText("Du måste ge ett giltigt tal!");

            // toast: https://developer.android.com/guide/topics/ui/notifiers/toasts#java
            Toast.makeText(getApplicationContext(), "Du måste ge ett giltigt tal!", Toast.LENGTH_LONG).show();

        }

    }


    /*public void buttonHandler(View view) {
        //System.out.println("Du tryckte på knappen!");

        // Vi avläser vår EditText och omvandlar till String
        String namn = inputText.getText().toString();

        outputText.setText(Statistics.greet() + " " + namn + "!");

    }*/
}