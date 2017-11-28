package com.thefantasy.tracy.thefantasy;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static java.sql.DriverManager.println;

public class Main2Activity extends AppCompatActivity {
    public GridView griddy;
    public OkHttpClient client;
    public JSONArray jary;
    public JSONObject jobj;
    public String url="https://raw.githubusercontent.com/tracygipson/TheFantasy/master/TestImages.JSON";

    private String[] imagesArray = new String[100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        griddy=(GridView) findViewById(R.id.griddy);
        new AsyncClass().execute();
        somefn();
    }

    public class AsyncClass extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String data = null;
            try {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(url)
                        .build();
                Response response = null;
                response = client.newCall(request).execute();
                data = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result){
            super.onPostExecute(result);
            try {
                jobj = new JSONObject(result);

            jary = jobj.optJSONArray("tracy");
            for (int i =0;i<jary.length();i++) imagesArray[i] = jary.getString(i);
            somefn();
            println(imagesArray[2]);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void somefn(){
        try {
            griddy.setAdapter(new GridViewAdapter(getApplicationContext(),imagesArray));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
