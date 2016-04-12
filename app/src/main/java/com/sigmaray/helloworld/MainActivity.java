package com.sigmaray.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.handleButtonClicks();
    }

    private void handleButtonClicks() {
        Button buttonShowMessage = (Button) findViewById(R.id.buttonShowMessage);
        buttonShowMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hello, World!", Toast.LENGTH_LONG).show();
            }
        });

        Button buttonClose = (Button) findViewById(R.id.buttonClose);
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Is it correct way to close app?
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });

        mp=MediaPlayer.create(this, R.raw.papua_dub);
        mp.setLooping(true);
        Button buttonPlay = (Button) findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.mp.start();

            }
        });

        Button buttonStop = (Button) findViewById(R.id.buttonStop);
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.mp.pause();
            }
        });
    }
}
