package com.example.annax.survivalgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import static com.example.annax.survivalgame.SingleFragmentActivity.enableSoundEffect;

/**
 * Created by annax on 10/2/2017.
 */

public class ScoreFragment extends Fragment implements View.OnClickListener{

    private MediaPlayer mp = null;
    private SharedPreferences sharedPref = null;
    LinearLayout linearLayout = null;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.score_fragment, container, false);
        sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        mp = MediaPlayer.create(getActivity(), R.raw.sound_effect1);
        linearLayout = v.findViewById(R.id.scoreHistory);
        setScoreHistory();
        Button enterName = v.findViewById(R.id.enterName);
        Button scoreBack = v.findViewById(R.id.ScoreBack);
        Button facebook = v.findViewById(R.id.Facebook);
        enterName.setOnClickListener(this);
        scoreBack.setOnClickListener(this);
        facebook.setOnClickListener(this);
        return v;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.ScoreBack) {
            if (enableSoundEffect) {
                mp.start();
            }
            getActivity().finish();
        } else if (view.getId() == R.id.Facebook) {
            if (enableSoundEffect) {
                mp.start();
            }
            Uri facebook = Uri.parse("https://www.facebook.com/");
            Intent fIntent = new Intent(Intent.ACTION_VIEW, facebook);
            PackageManager packageManager = getActivity().getPackageManager();
            List<ResolveInfo> activities = packageManager.queryIntentActivities(fIntent, 0);
            if (activities.size() > 0) {
                startActivity(fIntent);
            }
        } else if (view.getId() == R.id.enterName) {
            showEnterNameDialog();
        }
    }
    private void showEnterNameDialog() {
        FragmentManager manager = getFragmentManager();
        EnterNameDialogFragment fragment = new EnterNameDialogFragment();
        fragment.show(manager, "enter_name");
    }

    private void setScoreHistory(){
        Map<String,?> keys = sharedPref.getAll();
        for(Map.Entry<String,?> entry : keys.entrySet()){
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            textView.setTextSize(25);
            textView.setText(entry.getKey() + " : " +
                    entry.getValue().toString());
            linearLayout.addView(textView);
        }
    }

}
