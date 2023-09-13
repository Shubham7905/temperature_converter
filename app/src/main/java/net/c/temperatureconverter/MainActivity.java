package net.c.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Boolean check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        Button convert = findViewById(R.id.button);
        EditText degreeTxt = findViewById(R.id.degreesTxt);
        EditText resultTxt = findViewById(R.id.resultTxt);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Celsius");
        arrayList.add("Fahrenheit");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (adapterView.getItemAtPosition(i).toString()){
                    case "Celsius":
                        check = true;
                        break;

                    case "Fahrenheit":
                        check = false;
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check){
                    float input = Float.parseFloat(degreeTxt.getText().toString());
                    // (20°C × 9/5) + 32 = 68°F
                    String result = String.valueOf((input*(9f/5f))+32);
                    resultTxt.setText(result+"°F");
                }
                else {
                    float input = Float.parseFloat(degreeTxt.getText().toString());
                    // (32°F − 32) × 5/9 = °C
                    String result = String.valueOf((input-32)*(5f/9f));
                    resultTxt.setText(result+"°C");
                }
            }
        });

    }
}