package com.fateh.beshno_as_naiy;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        StartMediaPlayer.startPlaying(SplashActivity.this);

        ConnectivityManager connectivityManager = (ConnectivityManager) SplashActivity.this.getSystemService(CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (!(networkInfo != null && networkInfo.isConnectedOrConnecting()))
                Toast.makeText(SplashActivity.this, R.string.check_network_warning, Toast.LENGTH_LONG).show();
        }

        new Handler().postDelayed(() -> {
            Intent i = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }, 5000);
    }

}