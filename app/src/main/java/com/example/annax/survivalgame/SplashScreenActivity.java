package com.example.annax.survivalgame;

import android.os.Bundle;
import android.support.v4.app.Fragment;

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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
