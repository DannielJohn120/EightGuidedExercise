package com.example.eightguidedexercise;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner names;
    TextView result;
    ArrayAdapter<String> adapter;

    // List of names to show in Spinner
    String[] listOfNames = {
            "Name Here", "Papsi", "Pol", "Che", "Tin",
            "Renz", "Lou", "Chan", "Ven", "Jher"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        names = findViewById(R.id.spnrNamesGE8);
        result = findViewById(R.id.tvResultGE8);

        // Create and set up adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listOfNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        names.setAdapter(adapter);

        // Handle spinner selection
        names.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0) {
                    String selectedName = listOfNames[i];
                    result.setText("Name: " + selectedName);
                    Toast.makeText(getApplicationContext(), "Name: " + selectedName, Toast.LENGTH_SHORT).show();
                } else {
                    result.setText("Name: ");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Optional: handle if nothing is selected
            }
        });
    }
}
