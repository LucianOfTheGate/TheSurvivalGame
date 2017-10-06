package com.example.annax.survivalgame;

import android.support.v4.app.Fragment;

/**
 * Activity for handling Score Screen.
 *
 * Created by adamcchampion on 2017/08/12.
 */

public class ScoresActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new ScoreFragment();
    }
}
