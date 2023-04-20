package fi.arcada.sos_23_exempel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // deklarera variabler
    TextView outputText;
    EditText inputText;

    //shared prefs 1: deklarera
    SharedPreferences sharedPref;
    SharedPreferences.Editor prefEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputText = findViewById(R.id.outputText);
        inputText = findViewById(R.id.dataName);

        // shared prefs 2: initialisera
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        prefEditor = sharedPref.edit();

        // CodeChallenge App Start Counter version 1
        int appStarts = sharedPref.getInt("appStartCount", 0);
        appStarts++; // öka med 1
        prefEditor.putInt("appStartCount", appStarts); // spara som shared pref

        // CodeChallenge App Start Counter version 2 "One-Liner"
        prefEditor.putInt("appStartCount2", sharedPref.getInt("appStartCount2", 0)+1);

        // spara "på hårdskivan"
        prefEditor.apply();

        // shared prefs 3: läs från shared prefs
        outputText.setText(String.format("%s %s\nDu har startat appen %d gånger.",
                sharedPref.getString("greeting", "Hej"),
                sharedPref.getString("savedName", "främling"),
                sharedPref.getInt("appStartCount", 0)
        ));
    }

    public void openSettings(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void calculate(View view) {

        String myName = inputText.getText().toString();

        // shared prefs 4: spara i shared prefs
        prefEditor.putString("savedName", myName);
        prefEditor.apply();

        outputText.setText(String.format("Hej %s", myName));


    }
}