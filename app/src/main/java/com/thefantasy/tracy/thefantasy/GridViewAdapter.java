package com.thefantasy.tracy.thefantasy;

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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.security.PublicKey;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by tracy on 25/11/2017.
 */

public class GridViewAdapter extends ArrayAdapter
{
        private Context context;
        private LayoutInflater inflater;
        private String[] imagesArray;

        public GridViewAdapter(Context context, String[] imagesArray) throws IOException, JSONException {
            super(context, R.layout.activity_main2);
            this.context = context;
            this.imagesArray = imagesArray;
            /*getimagesurls();*/
            inflater = LayoutInflater.from(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (null == convertView) {
                convertView = inflater.inflate(R.layout.activity_main2, parent, false);
            }
            Picasso.with(context)
                    .load(imagesArray[position])
                    .fit()
                    .into((ImageView) convertView);
            return convertView;
        }
      /*  public void getimagesurls() throws IOException, JSONException {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            String data = response.body().string();

            jobj = new JSONObject(data);
            jary = jobj.optJSONArray("tracy");
            for (int i =0;i<jary.length();i++) imagesArray[i] = jary.getString(i);
        }*/
}