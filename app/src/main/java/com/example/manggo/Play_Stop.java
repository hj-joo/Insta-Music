package com.example.manggo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.annotation.SuppressLint;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;



public class Play_Stop extends AppCompatActivity implements View.OnClickListener {
    private ImageButton share1;
    private ImageButton play;
    private ImageButton stream;
    private  ImageButton heart;
    private TextView num;
    private CheckBox chk_heart;
    private static MediaPlayer mp;
    private Runnable runnable;
    private TextView curTime;
    TextView totTime;
    private SeekBar mSeekBar;
    boolean isPlaying;
    private Handler handler;
    private  static int counter = 3000;
    private TextView count;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play__stop);
        TextView count = (TextView) findViewById(R.id.count);
        if (mp != null && mp.isPlaying()) {
            mp.reset();
            count.setText(counter+ "");
            counter += 1;


        }
        else {
            count.setText(counter+ "");
        }

        num = (TextView) findViewById(R.id.num);

        CheckBox chk_heart = (CheckBox) findViewById(R.id.chk_heart) ;
        chk_heart.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox)v).isChecked()) {
                    num.setText("329,756");
                } else {
                    num.setText("329,757");
                }
            }
        }) ;

        share1 = findViewById(R.id.share1);
        share1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Play_Stop.this, activity_share.class);
                startActivity(intent);
            }
        });

        stream = findViewById(R.id.stream );
        stream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Play_Stop.this, activity_stream.class);
                startActivity(intent);
            }
        });





        handler = new Handler();
        mSeekBar = findViewById(R.id.mSeekBar);
        mp = MediaPlayer.create(this, R.raw.dynamite);
        play = findViewById(R.id.play);


        play.setOnClickListener(this);


        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mSeekBar.setMax(mp.getDuration());
                mp.start();
                play.setImageResource(R.drawable.ic_pause);
                changeSeekbar();
            }


        });
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b){
                    mp.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    private void changeSeekbar() {
        mSeekBar.setProgress(mp.getCurrentPosition());
        if (mp.isPlaying()) {

            runnable = new Runnable() {
                @Override
                public void run() {
                    changeSeekbar();
                }
            };
            handler.postDelayed(runnable, 1000);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play:
            if(mp.isPlaying()){
                mp.pause();
                play.setImageResource(R.drawable.ic_play);
            }
            else
            {
                mp.start();
                play.setImageResource(R.drawable.ic_pause);
                changeSeekbar();
            }
            break;


        }


    }


}

