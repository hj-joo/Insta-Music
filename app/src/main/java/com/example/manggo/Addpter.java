package com.example.manggo;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Addpter extends BaseAdapter {
    private List<people> mData;
    private Map<String,Integer> mHeart;

    public  Addpter(List<people> data)
    {
        this.mData = data;
        mHeart = new HashMap<>();
        mHeart.put("heart",R.drawable.ic_favorite);

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
                .inflate(R.layout.list_people,parent,false);
        ImageView heart = convertView.findViewById(R.id.heart);

        TextView name = convertView.findViewById(R.id.name);
        TextView num = convertView.findViewById(R.id.num);
        people people = mData.get(position);
        name.setText(people.getName());
        num.setText(people.getNum());
        heart.setImageResource(mHeart.get(people.getHeart()));

        return convertView;
    }
}
