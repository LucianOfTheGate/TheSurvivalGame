package com.example.annax.survivalgame;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;


public class QuitAppDialogFragment extends DialogFragment {
    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle(getActivity().getResources().getString(R.string.exit))
                .setMessage(getActivity().getResources().getString(R.string.should_quit))
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(getActivity().getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent svc=new Intent(getActivity(), BackgroundMusicService.class);
                        getActivity().stopService(svc);
                        getActivity().finish();
                    }
                })
                .setNegativeButton(getActivity().getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).create();
    }
}
