package com.example.annax.survivalgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by annax on 10/6/2017.
 */

public class DifficultyFragment extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        Button itemSpwan = (Button)v.findViewById(R.id.ItemSpawn);
        itemSpwan.setOnClickListener(this);
        Button monsterSpwan = (Button)v.findViewById(R.id.MonsterSpawn);
        monsterSpwan.setOnClickListener(this);
        Button back = (Button)v.findViewById(R.id.Diff_back);
        back.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ItemSpawn:
                break;
            case R.id.MonsterSpawn:
                break;
            case R.id.Diff_back:
                getActivity().finish();
                break;
        }
    }
}
