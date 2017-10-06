package com.example.annax.survivalgame;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.File;

import static android.app.Activity.RESULT_OK;

/**
 * Created by annax on 10/2/2017.
 */

public class ScoreFragment extends Fragment implements View.OnClickListener{

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.score_fragment, container, false);
        Button scoreBack = (Button)v.findViewById(R.id.ScoreBack);
        scoreBack.setOnClickListener(this);
        return v;
    }

    public void onClick(View view){
        if(view.getId()==R.id.ScoreBack){
            getActivity().finish();
        }
    }

}
