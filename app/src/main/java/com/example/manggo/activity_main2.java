package com.example.manggo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

public class activity_main2 extends AppCompatActivity {
    ImageButton imageView10;
    Button bts_btn;
    Button dtm_btn;
    Button lsg_btn;
    TextView text_chart;
    ImageButton imageView9;

    private BottomSheetBehavior bottomSheetBehavior;
    private LinearLayout linearLayoutBSheet;
    private ToggleButton tbUpDown;
    private ListView listView;
    private TextView txtCantante, txtCancion;
    private ContentLoadingProgressBar progbar;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView10 = findViewById(R.id.imageView10);

        imageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_main2.this, activity_cloud.class);
                startActivity(intent);//액티비티 이동
            }
        });

        bts_btn = findViewById(R.id.bts_btn);

        bts_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_main2.this, Play_Stop.class);
                startActivity(intent);

            }
        });
        dtm_btn = findViewById(R.id.dtm_btn);

        dtm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_main2.this, Play_Stop.class);
                startActivity(intent);
            }
        });
        lsg_btn = findViewById(R.id.lsg_btn);

        lsg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_main2.this, Play_Stop.class);
                startActivity(intent);
            }
        });
        imageView9 = findViewById(R.id.imageView9);

        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_main2.this, activity_coin.class);
                startActivity(intent);//액티비티 이동
            }
        });
        TextView text_chart = findViewById(R.id.text_chart);
        text_chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_main2.this, Main_chart.class);
                startActivity(intent);
            }
        });


        init();



        tbUpDown.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }else{
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View view, int newState) {
                if(newState == BottomSheetBehavior.STATE_EXPANDED){
                    tbUpDown.setChecked(true);
                }else if(newState == BottomSheetBehavior.STATE_COLLAPSED){
                    tbUpDown.setChecked(false);
                }
            }

            @Override
            public void onSlide(View view, float v) {

            }
        });
    }

    private void init() {
        this.linearLayoutBSheet = findViewById(R.id.bottomSheet);
        this.bottomSheetBehavior = BottomSheetBehavior.from(linearLayoutBSheet);
        this.tbUpDown = findViewById(R.id.toggleButton);

        this.txtCantante = findViewById(R.id.txtCantante);
        this.txtCancion = findViewById(R.id.txtCancion);
        this.progbar = findViewById(R.id.progbar);




        //배열로 데이터 준비
        ArrayList<Playlist> data = new ArrayList<>();
        data.add(new Playlist("방탄", "Dynamite", "방탄소년단"));
        data.add(new Playlist("창모", "Meteor", "창모"));
        data.add(new Playlist("블핑", "Lovesick Girls", "BLACKPINK"));
        data.add(new Playlist( "하이어", "도착", "H1gher"));
        data.add(new Playlist( "지코", "Summer Hate", "ZICO"));
        data.add(new Playlist("도망가", "도망가", "MINO"));
        data.add(new Playlist( "크러쉬", "놓아줘(with 태연)", "크러쉬"));
        data.add(new Playlist( "나플라", "Wu", "nafla"));
        data.add(new Playlist( "백예린", "Square", "백예린"));
        data.add(new Playlist( "아이유", "INTO THE I-LAND", "아이유"));
        //어댑터
        Adapter1 adapter1 = new Adapter1(data);
        //뷰
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter1);
        //클릭

    }
}