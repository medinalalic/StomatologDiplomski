package com.example.medina.stomatologdiplomski;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.medina.stomatologdiplomski.Helper.Sesija;

public class MeniActivity extends AppCompatActivity {
private ImageView odjava;
private ImageView pacijent;
private ImageView termin;
private ImageView kalendar;
private ImageView profil;
    private ImageView poruka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meni);
odjava=findViewById(R.id.btnOdjava);
pacijent=findViewById(R.id.btnPregled);
termin=findViewById(R.id.btnPretraga);
        kalendar=findViewById(R.id.btnTermin);
        profil=findViewById(R.id.btnProfil);
        poruka=findViewById(R.id.btnPoruka);

        odjava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sesija.setlogiraniKorisnik(null);
                Toast.makeText(MeniActivity.this,"Uspješno ste se odjavili.", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MeniActivity.this, MainActivity.class));
                return;


            }
        });

        pacijent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MeniActivity.this, MjestoFragmentActivity.class));

            }
        });
        poruka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MeniActivity.this, PrijedlogActivity.class));

            }
        });

        termin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MeniActivity.this, PretragaTerminaActivity.class));

            }
        });
        kalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MeniActivity.this, TabActivity.class));

            }
        });
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MeniActivity.this, UrediProfilActivity.class));

            }
        });
    }
}
