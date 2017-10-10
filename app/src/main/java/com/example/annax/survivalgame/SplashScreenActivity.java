package com.example.annax.survivalgame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

public class SplashScreenActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new SplashScreenFragment();
    }

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(getClass().getSimpleName(), "Our Group Called OnCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }

    @Override
    protected void onStart() {
        Log.d(getClass().getSimpleName(), "Our Group Called OnStart()");
        super.onStart();
    }

}
