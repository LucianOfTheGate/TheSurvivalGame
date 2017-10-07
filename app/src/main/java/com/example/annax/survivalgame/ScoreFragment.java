package com.example.annax.survivalgame;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
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
import java.net.URI;
import java.util.List;
import java.util.LinkedList;
import static android.app.Activity.RESULT_OK;

/**
 * Created by annax on 10/2/2017.
 */

public class ScoreFragment extends Fragment implements View.OnClickListener{

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.score_fragment, container, false);
        Button scoreBack = v.findViewById(R.id.ScoreBack);
        Button facebook = v.findViewById(R.id.Facebook);
        scoreBack.setOnClickListener(this);
        facebook.setOnClickListener(this);
        return v;
    }

    public void onClick(View view){
        if(view.getId()==R.id.ScoreBack){
            getActivity().finish();
        } else if (view.getId() == R.id.Facebook){
            Uri facebook = Uri.parse("https://www.facebook.com/");
            Intent fIntent = new Intent(Intent.ACTION_VIEW, facebook);
            PackageManager packageManager = getActivity().getPackageManager();
            List<ResolveInfo> activities = packageManager.queryIntentActivities(fIntent, 0);
            if( activities.size() > 0) {
                startActivity(fIntent);
            }
        }
    }

}
