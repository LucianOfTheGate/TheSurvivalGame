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
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.example.annax.survivalgame.SingleFragmentActivity.enableSoundEffect;

/**
 * Created by annax on 10/2/2017.
 */

public class ScoreFragment extends Fragment implements View.OnClickListener{

    private MediaPlayer mp = null;
    private SharedPreferences sharedPref = null;
    private LinearLayout tableLayout = null;
    private static boolean scoresDeclared = false;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.score_fragment, container, false);
        sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        mp = MediaPlayer.create(getActivity(), R.raw.sound_effect1);
        tableLayout = v.findViewById(R.id.scoreHistory);

        //Initialize score history
        if (!scoresDeclared) {
            createInitialScoresMap();
        }

        //We still need to re-sort the scores every time you open the screen
        setScoreHistory();

        //Initialize buttons
        Button enterName = v.findViewById(R.id.enterName);
        Button scoreBack = v.findViewById(R.id.ScoreBack);
        Button facebook = v.findViewById(R.id.Facebook);
        Button loginButton = v.findViewById(R.id.login_button);

        //Create button listeners
        enterName.setOnClickListener(this);
        scoreBack.setOnClickListener(this);
        facebook.setOnClickListener(this);
        loginButton.setOnClickListener(this);

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
        } else if (view.getId() == R.id.login_button) {

        }
    }
    private void showEnterNameDialog() {
        FragmentManager manager = getFragmentManager();
        EnterNameDialogFragment fragment = new EnterNameDialogFragment();
        fragment.show(manager, "enter_name");
    }

    private void setScoreHistory(){
        Map<String, ?> keys = sharedPref.getAll();
        //For the sake of everyone's sanity the scores shall be sorted in order you expect
        List<Map.Entry<String, ?>> scores = sortScoreMap(keys);
        for(Map.Entry<String,?> entry : scores){
            TableRow row = new TableRow(getActivity());
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT));
            row.setPadding(5, 5, 5, 5);
            row.setGravity(Gravity.CENTER_VERTICAL);
            TextView name = new TextView(getActivity());
            TextView score = new TextView(getActivity());
            name.setTextSize(20);
            name.setWidth(500);
            name.setPadding(80,0,0,0);
            score.setWidth(500);
            score.setTextSize(20);
            name.setText(entry.getKey());
            score.setText(entry.getValue().toString());
            row.addView(name);
            row.addView(score);
            tableLayout.addView(row);
        }
    }

    private List<Map.Entry<String, ?>> sortScoreMap(Map<String, ?> keys) {
        //Useful variables
        List<Map.Entry<String, ?>> values = new LinkedList<>();
        List<Map.Entry<String, ?>> temp = new LinkedList<>();

        //Get all of the values (not keys) within the map
        //[It does not matter if there are duplicate values]
        for (Map.Entry<String, ?> entry : keys.entrySet()) {
            temp.add(entry);
        }

        //Uses insertion sort to sort the list
        //[Insertion sort is used mainly for my peace of mind]
        //[I also forgot how to write insertion sort so I had to ask google (tutorials point)]
        int length = temp.size();
        for (int i = 1; i < length; i++) {
            Map.Entry<String, ?> value = temp.get(i);
            int j = i - 1;
            while ((j > -1) && ((Integer)temp.get(j).getValue() > (Integer) value.getValue())) {
                temp.set(j + 1, temp.get(j));
                j--;
            }
            temp.set(j + 1, value);
        }

        //Reverse the order of the entries
        for (int k = 0; k < length; k++)
            values.add(k, temp.get(length-k-1));

        return values;
    }
    private void createInitialScoresMap() {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("J.T. Barrett", 500);
        editor.putInt("David Hasslehoff",1000);
        editor.putInt("Julius Caeser", 2000);
        editor.putInt("Sir Robert Walpole", 3000);
        editor.putInt("Char Aznable", 4000);
        editor.putInt("Ur Mom", 4050);
        editor.commit();
    }

}
