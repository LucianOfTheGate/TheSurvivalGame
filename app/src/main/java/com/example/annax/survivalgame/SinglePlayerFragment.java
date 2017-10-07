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

public class SinglePlayerFragment extends Fragment implements View.OnClickListener {

    private final String TAG = getClass().getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.single_player_fragment, container, false);

        Button singleBack = (Button)v.findViewById(R.id.SingleBack);
        singleBack.setOnClickListener(this);

        return v;
    }
//testing
    @Override
    public void onClick(View v){

        switch(v.getId()){
            case R.id.Difficulty:
                startActivity(new Intent(getActivity().getApplicationContext(),DifficultyActivity.class));
                break;
            case R.id.RandomChar:
                break;
            case R.id.ChooseChar:
                break;
            case R.id.SingleBack:
                getActivity().finish();
                break;
        }
    }

}
