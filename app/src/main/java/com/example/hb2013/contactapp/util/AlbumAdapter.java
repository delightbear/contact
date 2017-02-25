package com.example.hb2013.contactapp.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.hb2013.contactapp.R;

/**
 * Created by hb2013 on 2017-02-25.
 */

public class AlbumAdapter  extends BaseAdapter {
    private Context context;
    private String[] photoValues;

    public AlbumAdapter(Context context, String[] photoValues) {
        this.context = context;
        this.photoValues = photoValues;
    }

    @Override
    public int getCount() {
        return photoValues.length;
    }

    @Override
    public Object getItem(int i) { // 인덱스
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View v, ViewGroup g) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if(v==null){
            gridView = new View(context);
            gridView=inflater.inflate(R.layout.album_grid,null);
            ImageView iv = (ImageView) gridView.findViewById(R.id.ivPhoto);
            String photo = photoValues[i];
            switch(photo) {
                case "mov01":
                    iv.setImageResource(R.drawable.mov01);
                    break;
                case "mov02":
                    iv.setImageResource(R.drawable.mov02);
                    break;
                case "mov03":
                    iv.setImageResource(R.drawable.mov03);
                    break;
                case "mov04":
                    iv.setImageResource(R.drawable.mov04);
                    break;
                case "mov05":
                    iv.setImageResource(R.drawable.mov05);
                    break;
                case "mov06":
                    iv.setImageResource(R.drawable.mov06);
                    break;
                case "mov07":
                    iv.setImageResource(R.drawable.mov07);
                    break;
                case "mov08":
                    iv.setImageResource(R.drawable.mov08);
                    break;
                case "mov09":
                    iv.setImageResource(R.drawable.mov09);
                    break;
                case "mov10":
                    iv.setImageResource(R.drawable.mov10);
                    break;
                 }

            }
            else {
                gridView=(View)v;
            }

        return gridView;
    }
}
