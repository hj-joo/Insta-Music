package com.example.manggo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SongDetail extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play__stop);

        TextView tvTitle = (TextView)findViewById(R.id.cover_text);
        TextView tvArtist = (TextView)findViewById(R.id.singer_text);
        ImageView iv = (ImageView)findViewById(R.id.chart_cover);

        Intent intent = getIntent(); // 보내온 Intent를 얻는다
        tvTitle.setText(intent.getStringExtra("title"));
        tvArtist.setText(intent.getStringExtra("artist"));
        iv.setImageResource(intent.getIntExtra("img", 0));
    } // end of onCreate
} // end of class


