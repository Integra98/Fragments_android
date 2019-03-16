package com.example.fragments;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity
        implements fragment1.OnFragmentInteractionListener {

    public static  String DATA = "date";
    public static  String BUTTON_TEXT = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            fm.beginTransaction();
            fragment3 frag = new fragment3();
            ft.add(R.id.container, frag);
            ft.commit();


        }


        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (DATA != null && BUTTON_TEXT != null) {

                Log.e("---str1", DATA);
                Log.e("---str2", BUTTON_TEXT);

                fragment2 fragment = (fragment2) getSupportFragmentManager()
                        .findFragmentById(R.id.detailFragment);

                fragment3 fragment3 = (fragment3) getSupportFragmentManager()
                        .findFragmentById(R.id.container);

                if (fragment != null && fragment3 != null) {
                    fragment.setText(DATA);
                    fragment3.setText(BUTTON_TEXT);
                }
            }
        }

    }

    @Override
    public void onFragmentInteraction(String link, String link2) {
        fragment2 fragment = (fragment2) getSupportFragmentManager()
                .findFragmentById(R.id.detailFragment);

        fragment3 fragment3 = (fragment3) getSupportFragmentManager()
                .findFragmentById(R.id.container);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            fragment.setText(link);
            fragment3.setText(link2);


        } else {
            DATA = link;
            BUTTON_TEXT = link2;

            Intent intent = new Intent(this,
                    MainActivity2.class);
            intent.putExtra(MainActivity2.DATA, link);
            intent.putExtra(MainActivity2.BUTTON_TEXT, link2);
            startActivity(intent);
        }
    }


}