package com.example.annax.survivalgame;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static com.example.annax.survivalgame.SingleFragmentActivity.enableSoundEffect;

public class SinglePlayerFragment extends Fragment implements View.OnClickListener {

    private final String TAG = getClass().getSimpleName();
    private MediaPlayer mp = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.single_player_fragment, container, false);

        mp = MediaPlayer.create(getActivity(), R.raw.sound_effect1);
        Button difficulty = (Button)v.findViewById(R.id.Difficulty);
        Button randomChar = (Button)v.findViewById(R.id.RandomChar);
        Button chooseChar = (Button)v.findViewById(R.id.ChooseChar);
        difficulty.setOnClickListener(this);
        randomChar.setOnClickListener(this);
        chooseChar.setOnClickListener(this);
        Button singleBack = (Button)v.findViewById(R.id.SingleBack);
        singleBack.setOnClickListener(this);


        return v;
    }

    @Override
    public void onClick(View v){

        switch(v.getId()){
            case R.id.Difficulty:
                if(enableSoundEffect){
                    mp.start();
                }
                startActivity(new Intent(getActivity().getApplicationContext(),DifficultyActivity.class));
                break;
            case R.id.RandomChar:
                if(enableSoundEffect){
                    mp.start();
                }
                break;
            case R.id.ChooseChar:
                if(enableSoundEffect){
                    mp.start();
                }
                break;
            case R.id.SingleBack:
                if(enableSoundEffect){
                    mp.start();
                }
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
