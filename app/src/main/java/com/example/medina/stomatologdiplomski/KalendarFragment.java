package com.example.medina.stomatologdiplomski;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roomorama.caldroid.CaldroidFragment;

import java.util.Date;
import java.util.HashMap;


public class KalendarFragment extends CaldroidFragment {

    public KalendarFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_kalendar, container, false);



        return view;
    }
    public void setBackgroundDrawableForDates(HashMap<Date, Drawable> backgroundForDateMap){

    }

}
