package com.example.medina.stomatologdiplomski;

import android.app.DatePickerDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medina.stomatologdiplomski.Api.TerminApi;
import com.example.medina.stomatologdiplomski.Helper.Global;
import com.example.medina.stomatologdiplomski.Helper.MyRunnable;
import com.example.medina.stomatologdiplomski.Helper.Sesija;
import com.example.medina.stomatologdiplomski.Model.TerminVM;

import org.json.JSONArray;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PretragaTerminaActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    Button datum;
    Button datum2;
int button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pretraga_termina);

        final ListView listatermina=(ListView)findViewById(R.id.listaTermina);
        datum = findViewById(R.id.btnOD);
        datum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1 = 1;
                Util.otvoriFragmentKaoDialog(PretragaTerminaActivity.this, new DatePickerFragment());

            }
        });

        datum2 = findViewById(R.id.btnDO);
        datum2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1 = 2;
                Util.otvoriFragmentKaoDialog(PretragaTerminaActivity.this, new DatePickerFragment());

            }
        });

        ImageButton pretraga=(ImageButton)findViewById(R.id.btnPretraga);
        pretraga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                if(!datum.getText().toString().equals("") && !datum2.getText().toString().equals("") ){
                   TerminApi.pretragaTermina(PretragaTerminaActivity.this,datum.getText().toString(),datum2.getText().toString(),
                            new MyRunnable<JSONArray>() {
                                @Override
                                public void run(final JSONArray result) {
                                    if (result == null)
                                        Toast.makeText(PretragaTerminaActivity.this, "Neuspješno obavljeno", Toast.LENGTH_SHORT).show();
                                    else {
                                        CardView cd=(CardView)findViewById(R.id.card);
                                        cd.setVisibility(View.VISIBLE);
                                        Global.sviTermini = TerminApi.jsonToTerminList(result);
                                        listatermina.setAdapter(new BaseAdapter() {
                                            @Override
                                            public int getCount() {
                                                return Global.sviTermini.size();
                                            }

                                            @Override
                                            public Object getItem(int position) {
                                                return Global.sviTermini.get(position);
                                            }

                                            @Override
                                            public long getItemId(int position) {
                                                return position;
                                            }

                                            @Override
                                            public View getView(int position, View view, ViewGroup parent) {
                                                TerminVM.TerminInfo p = Global.sviTermini.get(position);
                                                p.PacijentId= Sesija.getlogiraniKorisnik().Id;
                                                if (view == null) {

                                                    view = getLayoutInflater().inflate(R.layout.layout_termin_stavka, parent, false);
                                                }


                                                TextView ime = (TextView) view.findViewById(R.id.ime);
                                                TextView prezime = (TextView) view.findViewById(R.id.prezime);
                                                TextView razlog = (TextView) view.findViewById(R.id.razlog);

                                                ime.setText(p.Ime);
                                                prezime.setText(p.Prezime);
                                                razlog.setText(p.RazlogPosjete);
                                                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
                                                DateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy");

                                                Date date = null;
                                                try {
                                                    date = inputFormat.parse(p.Datum);
                                                } catch (ParseException e) {
                                                    e.printStackTrace();
                                                }
                                                String outputDateStr = outputFormat.format(date);
                                                TextView datumm = view.findViewById(R.id.datum2);
                                                datumm.setText(outputDateStr);



                                                return view;
                                            }
                                        });((BaseAdapter) listatermina.getAdapter()).notifyDataSetChanged();
                                    }
                                }
                            });


                }
            }
        });

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c=Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        if (button1==1)
            datum.setText(format1.format(c.getTime()));

        if (button1==2)
         datum2.setText(format1.format(c.getTime()));

        }


}
