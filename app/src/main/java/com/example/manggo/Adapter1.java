package com.example.manggo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Adapter1 extends BaseAdapter {
    private List<Playlist> mData;
    private Map<String ,Integer> mCoverImageMap;

    public Adapter1(List<Playlist> data){
        this.mData = data;
        mCoverImageMap = new HashMap<>();
        mCoverImageMap.put("아이유",R.drawable.iu2);
        mCoverImageMap.put("방탄",R.drawable.dynamite);
        mCoverImageMap.put("빈지노",R.drawable.blurry);
        mCoverImageMap.put("블핑",R.drawable.blackpink);
        mCoverImageMap.put("하이어",R.drawable.higher);
        mCoverImageMap.put("창모",R.drawable.meteor);
        mCoverImageMap.put("도망가",R.drawable.mino);
        mCoverImageMap.put("백예린",R.drawable.square);
        mCoverImageMap.put("크러쉬",R.drawable.crush);
        mCoverImageMap.put("나플라",R.drawable.wu);
        mCoverImageMap.put("지코",R.drawable.zico);

    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list,parent,false);
        ImageView coverImage = convertView.findViewById(R.id.chart_cover);
        TextView covertext = convertView.findViewById(R.id.cover_text);
        TextView singertext = convertView.findViewById(R.id.singer_text);


        Playlist playlist = mData.get(position);
        coverImage.setImageResource(mCoverImageMap.get(playlist.getCover()));
        covertext.setText(playlist.getTitle());
        singertext.setText(playlist.getSinger());


        return convertView;
    }
}