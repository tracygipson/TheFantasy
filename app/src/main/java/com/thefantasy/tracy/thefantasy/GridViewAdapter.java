package com.thefantasy.tracy.thefantasy;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by tracy on 25/11/2017.
 */

public class GridViewAdapter extends ArrayAdapter {
    private Context context;
   /* private LayoutInflater inflater;*/
    private String[] imagesurls;
    /*ArrayList<images> imagesurls;*/
    public ImageView imgy;

    public GridViewAdapter(Context context, String[] imagesArray) {
        super(context, R.layout.activity_main2, imagesArray);
        this.context = context;
        this.imagesurls = imagesArray;
        System.out.println(imagesurls[3]);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
           LayoutInflater inflater = (LayoutInflater)getContext()
            .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                   convertView = inflater.inflate(R.layout.activity_main2, null, true);
        }
        imgy = (ImageView) convertView.findViewById(R.id.img);
        Picasso.with(context)
                .load(imagesurls[position])
                .into(imgy);
        return convertView;
    }
}