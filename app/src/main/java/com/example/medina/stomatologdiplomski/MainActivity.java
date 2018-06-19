package com.example.medina.stomatologdiplomski;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.medina.stomatologdiplomski.Api.AutentifikacijaApi;
import com.example.medina.stomatologdiplomski.Helper.MyRunnable;
import com.example.medina.stomatologdiplomski.Helper.Sesija;
import com.example.medina.stomatologdiplomski.Model.KorisniciVM;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.user);
        password = findViewById(R.id.password);
        submit = findViewById(R.id.btnLogin);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLoginInitiate();
            }
        });



    }

    private void doLoginInitiate() {
        AutentifikacijaApi.Provjera(this,
                new MyRunnable<KorisniciVM>() {
                    @Override
                    public void run(KorisniciVM result) {
                        if (result == null)
                            Toast.makeText(getApplicationContext(), "Pogrešan Username ili Password", Toast.LENGTH_SHORT).show();
                        else {
                            Sesija.setlogiraniKorisnik(result);
                            Toast.makeText(getApplicationContext(), "Dobrodošli "+result.KorisnickoIme+"!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this, MeniActivity.class));
                        }

                    }



                }, username.getText().toString(), password.getText().toString());

    }
}
