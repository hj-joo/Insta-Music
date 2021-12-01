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

public class Adapter extends BaseAdapter {
    private List<Chart> mData;
    private Map<String ,Integer> mCoverImageMap;

    public Adapter(List<Chart> data){
        this.mData = data;
        mCoverImageMap = new HashMap<>();
        mCoverImageMap.put("아이유", R.drawable.iu2);
        mCoverImageMap.put("방탄", R.drawable.bts);
        mCoverImageMap.put("임창정", R.drawable.lim);
        mCoverImageMap.put("블핑", R.drawable.lovesick);
        mCoverImageMap.put("환불원정대", R.drawable.dontouchme);
        mCoverImageMap.put("장범준", R.drawable.jang);
        mCoverImageMap.put("산들", R.drawable.sandle);
        mCoverImageMap.put("오래된노래", R.drawable.oldsong);
        mCoverImageMap.put("크러쉬", R.drawable.crush);
        mCoverImageMap.put("제시", R.drawable.nunu);

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
                .inflate(R.layout.item_chart,parent,false);
        TextView numtext = convertView.findViewById(R.id.num_text);
        ImageView coverImage = convertView.findViewById(R.id.chart_cover);
        TextView covertext = convertView.findViewById(R.id.cover_text);
        TextView singertext = convertView.findViewById(R.id.singer_text);
        TextView timetext = convertView.findViewById(R.id.time_text);

        Chart chart = mData.get(position);
        numtext.setText(chart.getNum());
        coverImage.setImageResource(mCoverImageMap.get(chart.getCover()));
        covertext.setText(chart.getTitle());
        singertext.setText(chart.getSinger());
        timetext.setText(chart.getTime());

        return convertView;
    }
}
