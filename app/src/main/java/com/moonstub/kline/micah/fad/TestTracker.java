package com.moonstub.kline.micah.fad;

import android.util.Log;
import android.view.MotionEvent;

import java.util.ArrayList;

/**
 * Created by Micah on 7/24/2016.
 */
public class TestTracker {

    int mCount;
    ArrayList<String> mStrings;

    public TestTracker() {
        mCount = 0;
        mStrings = new ArrayList<>();
    }

    public String Count(){
        mCount += 1;
        return "Count = " + mCount;
    }

    public void LogEvent(MotionEvent e){
        mStrings.add(e.getAction() + " : " + e.toString());
    }

    @Override
    public String toString(){
        return "";
    }

    public void DisplayLog(){
        for(String s : mStrings){
            Log.v("TEST TRACKER", s);
        }
    }
}
