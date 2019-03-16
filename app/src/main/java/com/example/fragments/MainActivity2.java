package com.example.fragments;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;


public class MainActivity2  extends AppCompatActivity{
    public static final String DATA = "date";
    public static final String BUTTON_TEXT = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        fm.beginTransaction();
        fragment3 frag = new fragment3();
        ft.add(R.id.container, frag);
        ft.commit();

        setContentView(R.layout.activity_main2);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String str1 = extras.getString(DATA);
            String str2 = extras.getString(BUTTON_TEXT);
            Log.e("str1",str1);
            Log.e("str2",str2);

            fragment2 fragment = (fragment2) getSupportFragmentManager()
                    .findFragmentById(R.id.detailFragment);
            fragment.setText(str1);
            fragment3 fragment3 = (fragment3) getSupportFragmentManager()
                    .findFragmentById(R.id.container);
            if(fragment3 != null) {
                fragment3.setText(str2);
            }


        }
    }

}