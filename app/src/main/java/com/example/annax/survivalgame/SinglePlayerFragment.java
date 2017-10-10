package com.example.annax.survivalgame;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.nfc.Tag;
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

        Button difficulty = (Button)v.findViewById(R.id.Difficulty);
        difficulty.setOnClickListener(this);
        Button singleBack = (Button)v.findViewById(R.id.SingleBack);
        singleBack.setOnClickListener(this);


        return v;
    }

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Our Group Called OnCreate()");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d(TAG, "Our Group Called OnStart()");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d(TAG, "Our Group Called OnResume()");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(TAG, "Our Group Called OnPause()");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(TAG, "Our Group Called OnStop()");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "Our Group Called onDestroy()");
        super.onDestroy();
    }

}
