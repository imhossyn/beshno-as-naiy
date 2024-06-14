package com.fateh.beshno_as_naiy;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PlayerBarFragment extends DialogFragment {

    private PoemModel poemModel;
    private TextView title_voice;
    private ImageView play_button;
    private Context mContext;
    private MediaPlayer mediaPlayer;

    public PlayerBarFragment(Context context, PoemModel poemModel) {
        this.poemModel = poemModel;
        this.mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_player_bar, container, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) mediaPlayer.release();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title_voice = view.findViewById(R.id.title_voice);
        play_button = view.findViewById(R.id.play_button);

        title_voice.setText(poemModel.getPoem_title());


        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer == null) {
                    Toast.makeText(getContext(), "آمادگی برای پخش شدن ...", Toast.LENGTH_LONG).show();
                    mediaPlayer = new MediaPlayer();
                    generateMusic();
                    new Thread(() -> mediaPlayer.start()).start();
                }
                else if (mediaPlayer.isPlaying()) {
                    Toast.makeText(getContext(), "توقف", Toast.LENGTH_SHORT).show();
                    mediaPlayer.pause();
                } else if (mediaPlayer.getCurrentPosition() == 0) {
                    Toast.makeText(getContext(), "پخش مجدد ...", Toast.LENGTH_LONG).show();
                    new Thread(() -> mediaPlayer.start()).start();
                } else {
                    Toast.makeText(getContext(), "ادامه", Toast.LENGTH_SHORT).show();
                    new Thread(() -> mediaPlayer.start()).start();
                }

//                File musicFile = new File(mContext.getApplicationInfo().dataDir + "/files/Music/", poemModel.getDb_id() + ".mp3");
//                if (musicFile.exists()) {
//                    // The file exists, play it
//                    playMusic(musicFile);
//                } else {
//                    // The file doesn't exist, download it and then play it
//                    downloadAndPlayMusic(poemModel.getVoice_url(), musicFile);
//                }

            }
        });
    }

//    public void downloadAndPlayMusic(String url, File destinationFile) {
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder().url(url).build();
//        Log.d("music", "in download");
//
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                // Handle download failure
//                requireActivity().runOnUiThread(() -> Toast.makeText(mContext, "Download Failed", Toast.LENGTH_SHORT).show());
//                Log.d("music", "on fail");
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                if (!response.isSuccessful()) {
//                    Log.d("music", "response not success");
//                    throw new IOException("Unexpected code " + response);
//                }
//
//                try (ResponseBody responseBody = response.body()) {
//                    Log.d("music", "success");
//                    if (responseBody != null) {
//                        Log.d("music", "write file");
//                        try {
//                            FileOutputStream fos = new FileOutputStream(destinationFile);
//                            fos.write(responseBody.bytes());
//                            fos.flush();
//                            Log.d("music", "finish write file");
//                            // File downloaded, play it
//                            requireActivity().runOnUiThread(() -> playMusic(destinationFile));
//                        } catch (IOException e) {
//                            Log.d("music", "error write file : " + e);
//                            e.printStackTrace();
//                        } finally {
//                            responseBody.close();
//                        }
//                    }
//                }
//            }
//        });
//    }

    public void generateMusic() {
        Log.d("play", "start");

        try {
            String url = "https://s15.uupload.ir/files/horahimi/" + poemModel.getDb_id() + ".mp3";
            Log.d("music url", url);
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
            // Handle music playback completion
            mediaPlayer.setOnCompletionListener(MediaPlayer::release);
//            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}