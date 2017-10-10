package com.example.annax.survivalgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class GameOptionFragment extends Fragment implements View.OnClickListener {
    private final String TAG = getClass().getSimpleName();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        Button newGame = (Button)v.findViewById(R.id.SinglePlayer);
        newGame.setOnClickListener(this);
        Button match = (Button)v.findViewById(R.id.Multiplayer);
        match.setOnClickListener(this);
        Button score = (Button)v.findViewById(R.id.Scores);
        score.setOnClickListener(this);
        Button settings = (Button)v.findViewById(R.id.Settings);
        settings.setOnClickListener(this);
        Button quit = (Button)v.findViewById(R.id.Quit);
        quit.setOnClickListener(this);

        setHasOptionsMenu(true);
        return v;
    }

    @Override
    public void onResume() {
        Log.d(TAG, "Our Group Called OnResume()");
        super.onResume();
        try {
            ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setSubtitle(getResources().getString(R.string.app_name));
            }
        }
        catch (NullPointerException npe) {
            Log.e(TAG, "Could not set subtitle");
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Scores:
                startActivity(new Intent(getActivity().getApplicationContext(), ScoresActivity.class));
                break;
            case R.id.SinglePlayer:
                startActivity(new Intent(getActivity().getApplicationContext(),SinglePlayerActivity.class));
                break;
            case R.id.Settings:
                startActivity(new Intent(getActivity().getApplicationContext(),SettingsActivity.class));
                break;
            case R.id.Multiplayer:
                startActivity(new Intent(getActivity().getApplicationContext(), MatchActivity.class));
                break;
            case R.id.Quit:
                showQuitAppDialog();
                break;
        }
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

    private void showQuitAppDialog() {
        FragmentManager manager = getFragmentManager();
        QuitAppDialogFragment fragment = new QuitAppDialogFragment();
        fragment.show(manager, "quit_app");
    }
}
