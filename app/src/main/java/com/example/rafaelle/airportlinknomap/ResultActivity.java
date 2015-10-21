package com.example.rafaelle.airportlinknomap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import javax.xml.datatype.Duration;

public class ResultActivity extends AppCompatActivity {

    TextView resultStations;
    TextView resultDeparture;
    TextView resultArrival;
    TextView resultDuration;
    TextView resultPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        StartingActivity myStartAct = new StartingActivity();
        //DestinationActivity myEndAct = new DestinationActivity();
        //duration myduration = new duration(myStartAct.getStartLoc(),myEndAct.getDestLoc());

        /*resultStations = (TextView) findViewById(R.id.txtResultStation);
        resultStations.setText("From " + myStartAct.getStartLoc() + " to " + myEndAct.getDestLoc());
        resultStations.setVisibility(View.VISIBLE);

        resultDeparture = (TextView) findViewById(R.id.txtResultDeparture);
        resultDeparture.setText(getResources().getString(R.string.result_departure) + String.valueOf(myEndAct.getDeparture()));
        resultDeparture.setVisibility(View.VISIBLE);

        resultArrival = (TextView) findViewById(R.id.txtResultDeparture);
        resultArrival.setText(getResources().getString(R.string.result_arrival) + String.valueOf(myEndAct.getDeparture()));
        resultArrival.setVisibility(View.VISIBLE);

        resultDuration = (TextView) findViewById(R.id.txtResultDuration);
        resultDuration.setText(getResources().getString(R.string.result_duration) + String.valueOf(myduration.getDuration()));
        resultDuration.setVisibility(View.VISIBLE);*/

        resultPrice = (TextView) findViewById(R.id.txtResultPrice);
        resultPrice.setText(getResources().getString(R.string.result_price) + "15-45 THB");
        resultPrice.setVisibility(View.VISIBLE);
    }
}
