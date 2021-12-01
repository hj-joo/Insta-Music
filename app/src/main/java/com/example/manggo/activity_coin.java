package com.example.manggo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

public class activity_coin extends AppCompatActivity {
    private BottomSheetBehavior bottomSheetBehavior;
    private LinearLayout linearLayoutBSheet;
    private ToggleButton tbUpDown;
    private ListView listView;
    private TextView txtCantante, txtCancion;
    private ContentLoadingProgressBar progbar;

    public void OnPopupClick1(View view){

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Insta music");
        alert.setMessage("결제 하시겠습니까?");
        alert.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(activity_coin.this, "결제가 취소되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        alert.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(activity_coin.this, "잠시만 기다려 주십시오..", Toast.LENGTH_SHORT).show();
            }
        });
        alert.create().show();
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin);
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