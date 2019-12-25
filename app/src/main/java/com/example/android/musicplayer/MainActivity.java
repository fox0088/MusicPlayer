package com.example.android.musicplayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileDescriptor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button play = findViewById(R.id.play_music);
        final Button pause = findViewById(R.id.pause_music);
        final Button stop = findViewById(R.id.stop_music);

        final Button volup = findViewById(R.id.volup);
        final Button voldown = findViewById(R.id.voldown);

        final MediaPlayer MP = MediaPlayer.create(this, R.raw.gladiator);
        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MP.start();
                MP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(MainActivity.this, "Music ends", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MP.pause();
            }
        });
        
        stop.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                MP.pause();
                MP.seekTo(0);
             }
        });
    }
}