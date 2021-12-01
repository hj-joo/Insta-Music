package com.example.manggo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class activity_stream extends AppCompatActivity {

    TextView hash;
    TextView hash2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream);
        TextView hash = findViewById(R.id.hash);
        TextView hash2 = findViewById(R.id.hash2);

        hash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity_stream.this, "3000 Streamed", Toast.LENGTH_SHORT).show();

            }
        });


        hash2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity_stream.this, "3001 Streamed", Toast.LENGTH_SHORT).show();

            }
        });

    }
}