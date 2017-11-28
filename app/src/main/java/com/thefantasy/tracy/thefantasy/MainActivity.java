package com.thefantasy.tracy.thefantasy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import org.json.JSONException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    public ImageView imageView;
    /*public GridView griddy;*/
    public Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.tracy);
        btn = (Button) findViewById(R.id.btn);
        /*int visibility = btn.getVisibility();*/

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(myIntent);
            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;
    {
        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("WrongConstant")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        /*mTextMessage.setText(R.string.title_home);*/
                        btn.setVisibility(View.INVISIBLE);
                        Picasso.with(getApplicationContext()).load("https://i.pinimg.com/736x/64/d3/c4/64d3c4bbd6d9d6f290ac9a7aeaf50800.jpg ").into(imageView);
                        return true;
                    case R.id.navigation_dashboard:
                       /* mTextMessage.setText(R.string.title_dashboard);*/
                        btn.setVisibility(View.INVISIBLE);
                        Picasso.with(getApplicationContext()).load("https://i.pinimg.com/736x/64/d3/c4/64d3c4bbd6d9d6f290ac9a7aeaf50800.jpg").into(imageView);
                        return true;
                    case R.id.navigation_notifications:
                        btn.setVisibility(View.VISIBLE);
                        /*somefn();*/

                        return true;
                }
                return false;
            }
        };
    }

   /* public void somefn(){
        try {
            griddy.setAdapter(new GridViewAdapter(getApplicationContext()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }*/
   /* public abstract View view();*/
}
