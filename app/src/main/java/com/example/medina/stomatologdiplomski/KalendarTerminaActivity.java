package com.example.medina.stomatologdiplomski;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.Toast;


import java.util.Date;
import java.util.List;
import java.util.Random;

public class KalendarTerminaActivity extends AppCompatActivity {
private CalendarView kalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalendar_termina);
        kalendar=(CalendarView)findViewById(R.id.calendarView);




    }


}
