package com.example.annax.survivalgame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;
import static com.example.annax.survivalgame.SingleFragmentActivity.enableSoundEffect;

/**
 * A placeholder fragment containing a simple view.
 */
public class MatchFragment  extends Fragment implements View.OnClickListener {

    private MediaPlayer mp = null;
    public ListView mList;
    public Button speakButton;
    public static final int VOICE_RECOGNITION_REQUEST_CODE = 1234;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_match, container, false);
        mp = MediaPlayer.create(getActivity(), R.raw.sound_effect1);
        Button scoreBack = (Button)v.findViewById(R.id.ScoreBack);
        scoreBack.setOnClickListener(this);
        speakButton = (Button) v.findViewById(R.id.VoiceControl);
        speakButton.setOnClickListener(this);
        mList = (ListView) v.findViewById(R.id.VoiceList);
        return v;
    }

    public void onClick(View view){
        if(view.getId()==R.id.ScoreBack){
            if(enableSoundEffect){
                mp.start();
            }
            getActivity().finish();
        }
        else if(view.getId()==R.id.VoiceControl){
            startVoiceRecognitionActivity();
        }
    }

    public void startVoiceRecognitionActivity() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Speech recognition demo");
        startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == VOICE_RECOGNITION_REQUEST_CODE && resultCode == RESULT_OK) {
            // Fill the list view with the strings the recognizer thought it
            // could have heard
            ArrayList matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            mList.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, matches));
            // matches is the result of voice input. It is a list of what the
            // user possibly said.
            // Using an if statement for the keyword you want to use allows the
            // use of any activity if keywords match
            // it is possible to set up multiple keywords to use the same
            // activity so more than one word will allow the user
            // to use the activity (makes it so the user doesn't have to
            // memorize words from a list)
            // to use an activity from the voice input information simply use
            // the following format;
            // if (matches.contains("keyword here") { startActivity(new
            // Intent("name.of.manifest.ACTIVITY")

            if (matches.contains("back")) {
                getActivity().finish();
            }
            if(matches.contains("menu")){
                startActivity(new Intent(getActivity().getApplicationContext(), GameOptionActivity.class));
            }
            if(matches.contains("score")){
                startActivity(new Intent(getActivity().getApplicationContext(), ScoresActivity.class));
            }
            if(matches.contains("setting")){
                startActivity(new Intent(getActivity().getApplicationContext(), SettingsActivity.class));
            }

        }
    }
}
