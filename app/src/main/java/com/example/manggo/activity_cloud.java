package com.example.manggo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class activity_cloud extends AppCompatActivity {
private ListView listView;
SearchView searchView;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloud);


    listView = findViewById(R.id.list);
       //데이터 준비
      ArrayList<people> data = new ArrayList<>();
    data.add(new people("1. Insta gang - @ehdgnslee","heart","(3,237)"));
    data.add(new people("2. 운수데통 - @bumsu","heart","(2,136)"));
    data.add(new people("3. Steal Hungry - @ju_hyeoungjun","heart","(1,657)"));
    data.add(new people("4. We're the one - @tipsy_ziasu","heart","(1,296)"));
    data.add(new people("5. BBackgu - @wooki_booki","heart","(1,067)"));
    data.add(new people("6. 데이터 - @data","heart","(  999 )"));
    data.add(new people("7. 통신 - @Communicate","heart","(  999 )"));
    data.add(new people("8. 설계 - @design","heart","(  777 )"));
    data.add(new people("9. 다들 - @everybody","heart","(  666 )"));
    data.add(new people("10. 화이팅! - @Fighting!","heart","(  555 )"));










    // 어댑터
       Addpter adapter = new Addpter(data);
        //view
        ListView listView = findViewById(R.id.list);
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
                        Play_Stop2.class); // 다음넘어갈 화면


                startActivity(intent);
            }





        });

    }



}