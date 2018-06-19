package com.example.medina.stomatologdiplomski;

import android.app.usage.UsageEvents;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class KalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalendar);

        KalendarFragment caldroidFragment = new KalendarFragment();
        Bundle args = new Bundle();
        Calendar cal = Calendar.getInstance();
        args.putInt(KalendarFragment.MONTH, cal.get(Calendar.MONTH) + 1);
        args.putInt(KalendarFragment.YEAR, cal.get(Calendar.YEAR));
        caldroidFragment.setArguments(args);
        Util.otvoriFragmentKaoReplace(KalendarActivity.this,R.id.mjesto,caldroidFragment);

    }
}
