package com.example.annax.survivalgame;

import android.support.v4.app.Fragment;

/**
 * Created by annax on 10/5/2017.
 */

public class SinglePlayerActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new SinglePlayerFragment();
    }
}
