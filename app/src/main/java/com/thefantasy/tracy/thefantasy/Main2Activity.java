package com.thefantasy.tracy.thefantasy;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static java.sql.DriverManager.println;

public class Main2Activity extends AppCompatActivity {
    public ImageView img;
    public ListView listy;
    public OkHttpClient client;
    public JSONArray jary;
    public JSONObject jobj;
    public String url="https://raw.githubusercontent.com/tracygipson/TheFantasy/master/TestImages.JSON";

    private String[] imagesArray = new String[100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listy=(ListView) findViewById(R.id.listy);
        new AsyncClass().execute("https://raw.githubusercontent.com/tracygipson/TheFantasy/master/TestImages.JSON");
        somefn();
    }

    public class AsyncClass extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            String data = null;
            try {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(urls[0])
                        .build();
                Response response = null;
                response = client.newCall(request).execute();
                data = response.body().string();
                System.out.println(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }


        @Override
        protected void onPostExecute(String result){
            super.onPostExecute(result);
            System.out.println(result);
            try {
            jobj = new JSONObject(result);
            jary = jobj.optJSONArray("tracy");
            for (int i =0;i<jary.length();i++) imagesArray[i] = jary.getString(i);
            somefn();
            System.out.println(imagesArray[2]);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void somefn(){

            lv.setAdapter(new GridViewAdapter(getApplicationContext(),imagesArray));
    }
}
