package com.example.rafaelle.airportlinknomap;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MediaPlayer introsound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        introsound = MediaPlayer.create(MainActivity.this, R.raw.pin);
        introsound.start();
        Thread intro = new Thread(){
            public void run(){
                try{
                    sleep(5000);//5 seconds
                    Intent startingIntent = new Intent("android.intent.action.STARTING");
                    startActivity(startingIntent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally{
                    finish();
                }
            }

        };
        intro.start();
    }
}
