package com.example.annax.survivalgame;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

/**
 * Created by anny0 on 10/22/2017.
 */

public class BackgroundMusicService extends Service {
    private static final String TAG = null;
    MediaPlayer player;
    public IBinder onBind(Intent arg0) {
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.sample1);
        player.setLooping(true); // Set looping
        player.setVolume(100,100);
    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return START_NOT_STICKY;
    }
    public IBinder onUnBind(Intent arg0) {
        // TO DO Auto-generated method
        return null;
    }

    public void onPause()
    {
        player.stop();

    }

    public void onStop()
    {
        player.stop();

    }
    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }
}
