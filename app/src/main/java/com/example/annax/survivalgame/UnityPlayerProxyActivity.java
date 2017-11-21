package com.example.annax.survivalgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.unity3d.player.*;

/**
 * @deprecated Use UnityPlayerActivity instead.
 */
public class UnityPlayerProxyActivity extends Activity
{
    @Override protected void onCreate (Bundle savedInstanceState)
    {
        Log.w("Unity", "UnityPlayerNativeActivity has been deprecated, please update your AndroidManifest to use UnityPlayerActivity instead");
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, com.example.annax.survivalgame.UnityPlayerActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        Bundle extras = getIntent().getExtras();
        if (extras != null)
            intent.putExtras(extras);
        startActivity(intent);
    }
}