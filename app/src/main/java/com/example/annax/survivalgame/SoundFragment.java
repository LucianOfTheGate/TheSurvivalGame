package com.example.annax.survivalgame;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class SoundFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sound, container, false);

        Button singleBack = v.findViewById(R.id.SingleBack);
        singleBack.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v){

        switch(v.getId()){
            case R.id.SingleBack:
                getActivity().finish();
                break;
        }
    }
}
