package com.example.annax.survivalgame;

import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static com.example.annax.survivalgame.SingleFragmentActivity.enableSoundEffect;

/**
 * A placeholder fragment containing a simple view.
 */
public class MatchFragment  extends Fragment implements View.OnClickListener {

    private MediaPlayer mp = null;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_match, container, false);

        mp = MediaPlayer.create(getActivity(), R.raw.sound_effect1);
        Button scoreBack = (Button)v.findViewById(R.id.ScoreBack);
        scoreBack.setOnClickListener(this);
        return v;
    }

    public void onClick(View view){
        if(view.getId()==R.id.ScoreBack){
            if(enableSoundEffect){
                mp.start();
            }
            getActivity().finish();
        }
    }

}
