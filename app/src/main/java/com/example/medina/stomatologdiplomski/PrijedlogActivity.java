package com.example.medina.stomatologdiplomski;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medina.stomatologdiplomski.Api.PacijentApi;
import com.example.medina.stomatologdiplomski.Api.PrijedlogApi;
import com.example.medina.stomatologdiplomski.Helper.Global;
import com.example.medina.stomatologdiplomski.Helper.MyRunnable;
import com.example.medina.stomatologdiplomski.Helper.Sesija;
import com.example.medina.stomatologdiplomski.Model.PacijentVM;
import com.example.medina.stomatologdiplomski.Model.PrijedlogVM;

import org.json.JSONArray;

public class PrijedlogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prijedlog);
      final  ListView lista=findViewById(R.id.listaPrijedloga);
        PrijedlogApi.getprijedloge(PrijedlogActivity.this,Sesija.getlogiraniKorisnik().Id,
                new MyRunnable<JSONArray>() {
                    @Override
                    public void run(final JSONArray result) {
                        if (result == null)
                            Toast.makeText(PrijedlogActivity.this, "Neuspješno obavljeno", Toast.LENGTH_SHORT).show();
                        else {

                            Global.prijedlozi = PrijedlogApi.jsonToPrijedlogList(result);


                            lista.setAdapter(new BaseAdapter() {
                                @Override
                                public int getCount() {
                                    return Global.prijedlozi.size();
                                }

                                @Override
                                public Object getItem(int position) {
                                    return Global.prijedlozi.get(position);
                                }

                                @Override
                                public long getItemId(int position) {
                                    return position;
                                }

                                @Override
                                public View getView(int position, View view, ViewGroup parent) {
                                    PrijedlogVM.PrijedlogInfo p = Global.prijedlozi.get(position);

                                    if (view == null) {

                                        view = getLayoutInflater().inflate(R.layout.layout_prijedlog, parent, false);
                                    }


                                    TextView ime = (TextView) view.findViewById(R.id.pacijent);
                                    ime.setText(p.IPPacijent);
                                    TextView ip = (TextView) view.findViewById(R.id.stomatolog);
                                    ip.setText(p.IPStomatolog);
                                    TextView tekst = (TextView) view.findViewById(R.id.prijedlog);
                                    tekst.setText(p.TekstPoruke);
                                    return view;
                                }
                            });((BaseAdapter) lista.getAdapter()).notifyDataSetChanged();
                        }
                    }
                });
    }
}
