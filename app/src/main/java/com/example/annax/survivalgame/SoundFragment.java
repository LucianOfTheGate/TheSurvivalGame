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
public class SoundFragment extends Fragment implements View.OnClickListener {
    private MediaPlayer mp = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sound, container, false);

        mp = MediaPlayer.create(getActivity(), R.raw.sound_effect1);
        Button singleBack = v.findViewById(R.id.SingleBack);
        singleBack.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v){

        switch(v.getId()){
            case R.id.SingleBack:
                if(enableSoundEffect){
                    mp.start();
                }
                getActivity().finish();
                break;
        }
    }
}
