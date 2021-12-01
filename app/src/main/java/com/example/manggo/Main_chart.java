package com.example.manggo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

public class Main_chart extends AppCompatActivity {
    ImageButton imageView1;
    ImageButton imageView2;
    private MediaPlayer mp;
    private BottomSheetBehavior bottomSheetBehavior;
    private LinearLayout linearLayoutBSheet;
    private ToggleButton tbUpDown;
    private ListView listView;
    private TextView txtCantante, txtCancion;
    private ContentLoadingProgressBar progbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chart);

        imageView1 = findViewById(R.id.imageView1);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_chart.this, activity_cloud.class);
                startActivity(intent);//액티비티 이동
            }
        });
        imageView2 = findViewById(R.id.imageView2);

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_chart.this, activity_coin.class);
                startActivity(intent);//액티비티 이동
            }
        });
        //배열로 데이터 준비
        ArrayList<Chart> data = new ArrayList<>();
        data.add(new Chart("1", "방탄", "Dynamite", "방탄소년단", "3:18"));
        data.add(new Chart("2", "환불원정대", "DON'T TOUCH ME", "환불원정대", "3:43"));
        data.add(new Chart("3", "블핑", "Lovesick Girls", "BLACKPINK", "3:44"));
        data.add(new Chart("4", "임창정", "힘든 건 사랑이 아니다", "임창정", "4:29"));
        data.add(new Chart("5", "산들", "취기를 빌려 (취항저격 그녀..)", "산들", "3:48"));
        data.add(new Chart("6", "오래된노래", "오래된 노래", "스탠딩 에그", "4:32"));
        data.add(new Chart("7", "크러쉬", "놓아줘(with 태연)", "크러쉬", "3:32"));
        data.add(new Chart("8", "장범준", "잠이 오질 않네요", "장범준", "4:36"));
        data.add(new Chart("9", "제시", "눈누난나 (NUNU NANA)", "제시", "3:16"));
        data.add(new Chart("10", "아이유", "에잇(Prod.&Feat.SUGA)", "아이유", "2:48"));
        //어댑터
        Adapter adapter = new Adapter(data);
        //뷰
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);
        //클릭
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 상세정보 화면으로 이동하기(인텐트 날리기)
                // 1. 다음화면을 만든다
                // 2. AndroidManifest.xml 에 화면을 등록한다
                // 3. Intent 객체를 생성하여 날린다

                    Intent intent = new Intent(getApplicationContext(), // 현재화면의 제어권자
                            Play_Stop.class); // 다음넘어갈 화면


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