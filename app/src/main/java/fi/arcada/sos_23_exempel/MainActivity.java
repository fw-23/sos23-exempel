package fi.arcada.sos_23_exempel;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // deklarera variabler
    TextView outputText;
    double[] temps = {-4.7, -4.8, -1.8, 0.7, 0.1, -6, -7.8, -7, -3.8, -10.6, -10.3, -0.3, 4.8, 2.6, 0.1, 1.2, -1.5, -2.7, 1.8, 0.2, -2, -5.5, -1.3, 2.1, -0.6, -0.9, 1, -0.5, -1.4, -1.6, -5.3, -7.7, -8.2, -9.5, -3.9, -0.4, 1, 0.8, -0.4, 0.6, 1, -1.5, -0.5, 1.4, 1.5, 1.8, 2, 1.1, -0.1, 0.1, -0.7, -0.4, -3, -6.8, 2, 1.5, -1.3, -0.2, 1.6, 1.9, 1.3, 0.6, -2, -2.4, 0.8, -0.3, -2.5, -2.6, -0.7, 1.8, 1.3, 0.9, 3, 0.7, 0.8, 1.6, 2.5, 2, 6.2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputText = findViewById(R.id.outputText);

        outputText.setText("hello");

        System.out.println(Arrays.toString(
                Statistics.sma3(temps)
        ));

        System.out.println(Arrays.toString(
                Statistics.sma(temps, 3)
        ));

        System.out.println(Arrays.toString(
                Statistics.sma(temps, 10)
        ));
    }

}