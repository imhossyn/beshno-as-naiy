package com.fateh.beshno_as_naiy;

import android.content.Context;
import android.media.MediaPlayer;

import java.io.Serializable;

public class StartMediaPlayer implements Serializable {

    public static MediaPlayer mp;

    public static boolean startPlaying(Context context) {
        try {
            mp = MediaPlayer.create(context, R.raw.start_music);
            mp.start();
            return true;
        } catch (Exception ignore) {
            return false;
        }
    }

    public static MediaPlayer getMedia() {
        return mp;
    }

    public static boolean stopMedia() {
        try {
            if (mp != null && mp.isPlaying()) {
                mp.release();
            }
            return true;
        } catch (Exception ignore) {
            return false;
        }

    }
}
