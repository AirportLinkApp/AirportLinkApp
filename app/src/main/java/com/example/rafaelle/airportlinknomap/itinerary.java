package com.example.rafaelle.airportlinknomap;

/**
 * Created by Carrot on 21-Oct-15.
 */
public class itinerary {

    private int _id = 1;
    private String _start;
    private String _end;
    private int _duration;

    public itinerary(String _start, String _end, int _duration) {
        this._start = _start;
        this._end = _end;
        this._duration = _duration;
    }

    public itinerary() {
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_start() {
        return _start;
    }

    public void set_start(String _start) {
        this._start = _start;
    }

    public String get_end() {
        return _end;
    }

    public void set_end(String _end) {
        this._end = _end;
    }

    public int get_duration() {
        return _duration;
    }

    public void set_duration(int _duration) {
        this._duration = _duration;
    }
}
