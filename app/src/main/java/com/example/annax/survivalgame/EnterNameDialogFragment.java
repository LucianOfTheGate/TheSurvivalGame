package com.example.annax.survivalgame;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.InputType;
import android.widget.EditText;

import java.util.Random;


public class EnterNameDialogFragment extends DialogFragment {
    private String mEditText;
    private SharedPreferences sharedPref = null;
    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Enter your name:");

// Set up the input
        final EditText input = new EditText(getActivity());
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mEditText = input.getText().toString();
                Random r = new Random();
                int score = r.nextInt(100 - 50) + 50;
                SharedPreferences.Editor editor = sharedPref.edit();
                int oldScore = sharedPref.getInt(mEditText,0);
                if(score > oldScore) {
                    editor.putInt(mEditText, score);
                    editor.commit();
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        return builder.create();
    }

}
