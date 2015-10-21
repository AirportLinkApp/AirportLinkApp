package com.example.rafaelle.airportlinknomap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class StartingActivity extends AppCompatActivity {

    private static final String TAG = "rafaelle";//for debugging purposes

    Spinner spinnerStart;
    ArrayAdapter<CharSequence> adapterStart;
    String startLoc;
    DBHelper mydbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

        spinnerStart = (Spinner)findViewById(R.id.spnStart); //initialize spinnerStart
        adapterStart = ArrayAdapter.createFromResource(this, R.array.stations, android.R.layout.simple_spinner_item); //create layout for arrayadapter
        adapterStart.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //layout for dropdown list
        spinnerStart.setAdapter(adapterStart); //set adapter for the spinner

        //mydbhelper = new DBHelper(this, null, null, 1);

        spinnerStart.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                startLoc = spinnerStart.getSelectedItem().toString();
                Log.i(TAG, "spnStart item selected: " + startLoc);
                setStartLoc(startLoc);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button goToDest = (Button) findViewById(R.id.btnStartNext);
        goToDest.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent destinationIntent = new Intent("android.intent.action.DESTINATION");
                        startActivity(destinationIntent);
                    }
                }
        );
    }

    public void setStartLoc(String startLoc) {
        Log.i(TAG, "setStartLoc: " + startLoc);
        this.startLoc = startLoc;
    }

    public String getStartLoc() {
        Log.i(TAG, "getStartLoc: " + startLoc);
        return startLoc;
    }

    public void saveStart(){
        itinerary i = new itinerary(startLoc,null,0);
        //mydbhelper.addItinerary(i);
    }
}
