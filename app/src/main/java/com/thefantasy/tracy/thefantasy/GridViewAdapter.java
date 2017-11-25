package com.thefantasy.tracy.thefantasy;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.security.PublicKey;

/**
 * Created by tracy on 25/11/2017.
 */

public class GridViewAdapter extends MainActivity{

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ImageView imageView;
        if (convertView == null){
            imageView = new ImageView(getApplicationContext());
        }
        else {
            ImageView = (ImageView) convertView;
        }

        picasso
        return convertView;
    }
}
