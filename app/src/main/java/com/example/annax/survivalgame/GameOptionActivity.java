package com.example.annax.survivalgame;

import android.support.v4.app.Fragment;



public class GameOptionActivity extends SingleFragmentActivity {
    protected final String TAG = getClass().getSimpleName();

    @Override
    protected Fragment createFragment() {
        return new GameOptionFragment();
    }
}
