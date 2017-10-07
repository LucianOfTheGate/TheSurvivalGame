package com.example.annax.survivalgame;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.v4.app.Fragment;

/**
 * Created by anny0 on 10/6/2017.
 */

public class SettingsFragment extends Fragment implements View.OnClickListener {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        Button scoreBack = (Button)v.findViewById(R.id.ScoreBack);
        scoreBack.setOnClickListener(this);
        return v;
    }

    public void onClick(View view){
        if(view.getId()==R.id.ScoreBack){
            getActivity().finish();
        }
        if(view.getId()==R.id.Volume){

        }
        if(view.getId()==R.id.EnableCommunication){

        }
    }
}
