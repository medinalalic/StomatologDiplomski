package com.example.medina.stomatologdiplomski;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MjestoFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mjesto_fragment);
        Util.otvoriFragmentKaoReplace(this,R.id.mjestoFragmenta,new PacijentFragment());
    }
}
