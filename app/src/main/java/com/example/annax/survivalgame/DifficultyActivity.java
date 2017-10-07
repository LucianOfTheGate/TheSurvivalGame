package com.example.annax.survivalgame;
import android.support.v4.app.Fragment;
/**
 * Created by annax on 10/6/2017.
 */

public class DifficultyActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new DifficultyFragment();
    }
}

