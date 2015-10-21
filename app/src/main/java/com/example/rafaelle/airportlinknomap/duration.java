package com.example.rafaelle.airportlinknomap;

import android.nfc.Tag;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by Carrot on 20-Oct-15.
 */
public class duration {

    private static final String TAG = "rafaelle";//for debugging purposes

    HashMap<String, Integer> hashMap = new HashMap<>();

    /*int phayathai = 0;
    int ratchaprarop = 1;
    int makkasan = 4;
    int ramkhamhaeng = 8;
    int huamak = 12;
    int banthapchang = 16;
    int latkrabang = 21;
    int suvarnabhumi = 26;*/

    String Start;
    String End;
    int duration;

    public duration(String start, String end) {
        Start = start.replaceAll("\\s","").toLowerCase(); //delete white spaces and switch to lower case
        End = end.replaceAll("\\s","").toLowerCase(); //Phaya Thai will be phayathai
        Log.i(TAG, "Start: " + Start);
        Log.i(TAG, "End: " + End);

        //put values in hashMap
        hashMap.put("phayathai", 0);
        hashMap.put("ratchaprarop", 1);
        hashMap.put("makkasan", 4);
        hashMap.put("ramkhamhaeng", 8);
        hashMap.put("huamak", 12);
        hashMap.put("banthapchang", 16);
        hashMap.put("latkrabang", 21);
        hashMap.put("suvarnabhumi", 26);

        int from = hashMap.get(String.valueOf(Start));
        Log.i(TAG, "int from: " + String.valueOf(from));
        int to = hashMap.get(End);
        Log.i(TAG, "int to: " + String.valueOf(to));
        duration = Math.abs(to - from);//in minutes
        Log.i(TAG, "Duration: " + String.valueOf(duration));
    }

    public int getDuration() {
        return duration;
    }
}
