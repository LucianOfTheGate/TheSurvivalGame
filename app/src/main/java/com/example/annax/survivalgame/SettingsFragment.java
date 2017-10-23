package com.example.annax.survivalgame;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import static com.example.annax.survivalgame.SingleFragmentActivity.enableCommunication_m;
import static com.example.annax.survivalgame.SingleFragmentActivity.enableSoundEffect;

/**
 * Created by anny0 on 10/6/2017.
 */


public class SettingsFragment extends Fragment implements View.OnClickListener {
    private SeekBar volumeSeekbar = null;
    private AudioManager audioManager = null;
    private MediaPlayer mp = null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        Button scoreBack = (Button) v.findViewById(R.id.ScoreBack);
        volumeSeekbar = v.findViewById(R.id.seekBarVolume);
        TextView volume = (TextView) v.findViewById(R.id.textViewVolume);
        volume.setText("Music Volume");
        getActivity().setVolumeControlStream(AudioManager.STREAM_MUSIC);
        initControls();
        mp = MediaPlayer.create(getActivity(), R.raw.sound_effect1);
        CheckBox enableEffect = (CheckBox) v.findViewById(R.id.EnableEffect);
        enableEffect.setChecked(enableSoundEffect);
        CheckBox enableCommunication = (CheckBox) v.findViewById(R.id.EnableCommunication);
        enableCommunication.setChecked(enableCommunication_m);
        scoreBack.setOnClickListener(this);
        enableEffect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if(isChecked){
                    enableSoundEffect = true;
                }
                else{
                    enableSoundEffect = false;
                }
            }
        });
        enableCommunication.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    enableCommunication_m = true;
                }
                else{
                    enableCommunication_m = false;
                }
            }
        });
        return v;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.ScoreBack) {
            if(enableSoundEffect){
                mp.start();
            }
            getActivity().finish();
        }
    }

    private void initControls() {
        try {

            audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
            volumeSeekbar.setMax(audioManager
                    .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            volumeSeekbar.setProgress(audioManager
                    .getStreamVolume(AudioManager.STREAM_MUSIC));

            volumeSeekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
                @Override
                public void onStopTrackingTouch(SeekBar arg0) {
                }

                @Override
                public void onStartTrackingTouch(SeekBar arg0) {
                }

                @Override
                public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                            progress, 0);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
