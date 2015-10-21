package com.example.rafaelle.airportlinknomap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class DestinationActivity extends AppCompatActivity {

    private static final String TAG = "rafaelle";//for debugging purposes

    Spinner spinnerDest;
    ArrayAdapter<CharSequence> adapterDest;
    String startLoc;
    String destLoc;
    TextView startingStation;
    TimePicker timePicker;
    int departure;
    String test;
    DBHelper mydbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        timePicker.setEnabled(false);

        spinnerDest = (Spinner)findViewById(R.id.spnDest); //initialize spinnerStart
        adapterDest = ArrayAdapter.createFromResource(this, R.array.stations, android.R.layout.simple_spinner_item); //create layout for arrayadapter
        adapterDest.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //layout for dropdown list
        spinnerDest.setAdapter(adapterDest); //set adapter for the spinner

        //mydbhelper = new DBHelper(this, null, null, 1);

        //startLoc = mydbhelper.readStart();

        //StartingActivity myStartAct = new StartingActivity();
        startingStation = (TextView) findViewById(R.id.txtStart);
        startingStation.setText("Starting Station");
        //test = myStartAct.getStartLoc();
        //Log.i(TAG,"startloc: "+test);

        startingStation.setText(startLoc);
        startingStation.setVisibility(View.VISIBLE);
        Log.i(TAG, String.valueOf(startingStation));

        spinnerDest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                destLoc = spinnerDest.getSelectedItem().toString();
                Log.i(TAG, "spnDest item selected: " + destLoc);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button goToResult = (Button) findViewById(R.id.btnDestNext);
        goToResult.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent resultIntent = new Intent("android.intent.action.RESULT");
                        startActivity(resultIntent);
                    }
                }
        );
    }

    public String getDestLoc() {
        return destLoc;
    }

    public void onRadClick(View view){

        boolean checked = ((RadioButton) view).isChecked(); //check if the radio buttons are checked

        switch (view.getId()){
            case R.id.radNow:
                if (checked){
                    //
                    Calendar calendar = Calendar.getInstance();
                    int hour = calendar.get(Calendar.HOUR_OF_DAY);
                    int minutes = calendar.get(Calendar.MINUTE);
                    departure = Integer.valueOf(String.valueOf(hour) + String.valueOf(minutes));
                    Log.i(TAG, "Departure Now: " + String.valueOf(departure));
                    timePicker.setEnabled(false);
                }
                break;
            case R.id.radChoose:
                if (checked){
                    //
                    timePicker.setEnabled(true);
                    int hour = timePicker.getCurrentHour();
                    int minutes = timePicker.getCurrentMinute();
                    departure = Integer.valueOf(String.valueOf(hour) + String.valueOf(minutes));
                    Log.i(TAG, "Chosen departure time: " + String.valueOf(departure));
                }
                break;
        }
    }

    public int getDeparture() {
        return departure;
    }
}
