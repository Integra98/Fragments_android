package com.example.fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.Date;
public class fragment1 extends Fragment {

    private OnFragmentInteractionListener mListener;
    FragmentManager myFragmentManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        Button button = (Button) view.findViewById(R.id.update_button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Button button = (Button) v.findViewById(R.id.update_button);
                String str = new Date().toString();
                String buttonText = button.getText().toString();
                mListener.onFragmentInteraction(str ,buttonText );
            }
        });
        return view;
    }

    interface OnFragmentInteractionListener {

        void onFragmentInteraction(String link,String link2);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " OnFragmentInteractionListener");
        }
    }

}
