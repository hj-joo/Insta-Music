package com.example.manggo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

public class Bottomnavi extends AppCompatActivity {

    private BottomSheetBehavior bottomSheetBehavior;
    private LinearLayout linearLayoutBSheet;
    private ToggleButton tbUpDown;
    private ListView listView;
    private TextView txtCantante, txtCancion;
    private ContentLoadingProgressBar progbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomnavi);

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




        //????????? ????????? ??????
        ArrayList<Playlist> data = new ArrayList<>();
        data.add(new Playlist("??????", "Dynamite", "???????????????"));
        data.add(new Playlist("??????", "Meteor", "??????"));
        data.add(new Playlist("??????", "Lovesick Girls", "BLACKPINK"));
        data.add(new Playlist( "?????????", "??????", "H1gher"));
        data.add(new Playlist( "??????", "Summer Hate", "ZICO"));
        data.add(new Playlist("?????????", "?????????", "MINO"));
        data.add(new Playlist( "?????????", "?????????(with ??????)", "?????????"));
        data.add(new Playlist( "?????????", "Wu", "nafla"));
        data.add(new Playlist( "?????????", "Square", "?????????"));
        data.add(new Playlist( "?????????", "INTO THE I-LAND", "?????????"));
        //?????????
        Adapter1 adapter1 = new Adapter1(data);
        //???
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter1);
        //??????

    }
}