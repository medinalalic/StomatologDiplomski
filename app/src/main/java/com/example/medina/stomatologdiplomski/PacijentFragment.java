package com.example.medina.stomatologdiplomski;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medina.stomatologdiplomski.Api.PacijentApi;
import com.example.medina.stomatologdiplomski.Helper.Global;
import com.example.medina.stomatologdiplomski.Helper.MyRunnable;
import com.example.medina.stomatologdiplomski.Helper.Sesija;
import com.example.medina.stomatologdiplomski.Model.PacijentVM;
import com.example.medina.stomatologdiplomski.Model.ZubVM;

import org.json.JSONArray;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class PacijentFragment extends Fragment {

    public static ArrayList<PacijentVM.PacijentInfo> lista = new ArrayList<>();
    public PacijentFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView= inflater.inflate(R.layout.fragment_pacijent, container, false);
      final ListView pacijenti=(ListView) rootView.findViewById(R.id.ip);
        final EditText unos=(EditText) rootView.findViewById(R.id.search);

        ImageView pretraga=(ImageView) rootView.findViewById(R.id.btnTrazi);


        PacijentApi.getAllPpacijenti(getContext(),
                new MyRunnable<JSONArray>() {
                    @Override
                    public void run(final JSONArray result) {
                        if (result == null)
                            Toast.makeText(getContext(), "Neuspješno obavljeno", Toast.LENGTH_SHORT).show();
                        else {

                            Global.sviPacijenti = PacijentApi.jsonToPacijentList(result);


                            pacijenti.setAdapter(new BaseAdapter() {
                                @Override
                                public int getCount() {
                                    return Global.sviPacijenti.size();
                                }

                                @Override
                                public Object getItem(int position) {
                                    return Global.sviPacijenti.get(position);
                                }

                                @Override
                                public long getItemId(int position) {
                                    return position;
                                }

                                @Override
                                public View getView(int position, View view, ViewGroup parent) {
                                    PacijentVM.PacijentInfo p = Global.sviPacijenti.get(position);

                                    if (view == null) {

                                        view = getLayoutInflater().inflate(R.layout.layout_stavka_pacijent, parent, false);
                                    }


                                    TextView ime = (TextView) view.findViewById(R.id.ime);
                                    ime.setText(p.Ime);
                                    TextView prezime = (TextView) view.findViewById(R.id.prezime);
                                    prezime.setText(p.Prezime);
                                    TextView email = (TextView) view.findViewById(R.id.email);
                                    email.setText(p.Email);
                                    TextView mob = (TextView) view.findViewById(R.id.mob);
                                    mob.setText(p.Mobitel);
                                    return view;
                                }
                            });
                        }
                    }
                });
        pacijenti.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final PacijentDetaljiFragment d=new PacijentDetaljiFragment();

                final PacijentVM.PacijentInfo x = Global.sviPacijenti.get(position);


                Bundle arg=new Bundle();
                arg.putInt("pacijent",x.Id);
                d.setArguments(arg);
                Util.otvoriFragmentKaoDialog(getActivity(),d);





            }
        });
        pretraga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!unos.getText().toString().equals("")){
                    PacijentApi.getPacijentByIme(getActivity(),unos.getText().toString(),
                            new MyRunnable<JSONArray>() {
                                @Override
                                public void run(final JSONArray result) {

                                    if (result==null){
                                        Toast.makeText(getActivity(), "Neuspješno obavljeno", Toast.LENGTH_SHORT).show();

                                    }
                                  else {

                                        Global.sviPacijenti = PacijentApi.jsonToPacijentList(result);
                                        pacijenti.setAdapter(new BaseAdapter() {
                                            @Override
                                            public int getCount() {
                                                return Global.sviPacijenti.size();
                                            }

                                            @Override
                                            public Object getItem(int position) {
                                                return Global.sviPacijenti.get(position);
                                            }

                                            @Override
                                            public long getItemId(int position) {
                                                return position;
                                            }

                                            @Override
                                            public View getView(int position, View view, ViewGroup parent) {
                                                PacijentVM.PacijentInfo p = Global.sviPacijenti.get(position);

                                                if (view == null) {

                                                   view = getLayoutInflater().inflate(R.layout.layout_stavka_pacijent, parent, false);
                                                }


                                                TextView ime = (TextView) view.findViewById(R.id.ime);
                                                ime.setText(p.Ime);
                                                TextView prezime = (TextView) view.findViewById(R.id.prezime);
                                                prezime.setText(p.Prezime);
                                                TextView email = (TextView) view.findViewById(R.id.email);
                                                email.setText(p.Email);
                                                TextView mob = (TextView) view.findViewById(R.id.mob);
                                                mob.setText(p.Mobitel);
                                                return view;
                                            }
                                        });
                                    }
                                }
                            });
                    pacijenti.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            final PacijentDetaljiFragment d=new PacijentDetaljiFragment();

                            final PacijentVM.PacijentInfo x = Global.sviPacijenti.get(position);


                            Bundle arg=new Bundle();
                            arg.putInt("pacijent",x.Id);
                            d.setArguments(arg);
                            Util.otvoriFragmentKaoDialog(getActivity(),d);





                        }
                    });

                }
                else{
                    PacijentApi.getAllPpacijenti(getActivity(),
                            new MyRunnable<JSONArray>() {
                                @Override
                                public void run(final JSONArray result) {
                                    if (result == null)
                                        Toast.makeText(getActivity(), "Neuspješno obavljeno", Toast.LENGTH_SHORT).show();
                                    else {

                                        Global.sviPacijenti = PacijentApi.jsonToPacijentList(result);
                                        pacijenti.setAdapter(new BaseAdapter() {
                                            @Override
                                            public int getCount() {
                                                return Global.sviPacijenti.size();
                                            }

                                            @Override
                                            public Object getItem(int position) {
                                                return Global.sviPacijenti.get(position);
                                            }

                                            @Override
                                            public long getItemId(int position) {
                                                return position;
                                            }

                                            @Override
                                            public View getView(int position, View view, ViewGroup parent) {
                                                PacijentVM.PacijentInfo p = Global.sviPacijenti.get(position);

                                                if (view == null) {

                                                   view = getLayoutInflater().inflate(R.layout.layout_stavka_pacijent, parent, false);
                                                }

                                                TextView ime = (TextView) view.findViewById(R.id.ime);
                                                ime.setText(p.Ime);
                                                TextView prezime = (TextView) view.findViewById(R.id.prezime);
                                                prezime.setText(p.Prezime);
                                                TextView email = (TextView) view.findViewById(R.id.email);
                                                email.setText(p.Email);
                                                TextView mob = (TextView) view.findViewById(R.id.mob);
                                                mob.setText(p.Mobitel);


                                                return view;
                                            }
                                        });


                                    }
                                }
                            });

                    pacijenti.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            final PacijentDetaljiFragment d=new PacijentDetaljiFragment();

                            final PacijentVM.PacijentInfo x = Global.sviPacijenti.get(position);


                            Bundle arg=new Bundle();
                            arg.putInt("pacijent",x.Id);
                            d.setArguments(arg);
                            Util.otvoriFragmentKaoDialog(getActivity(),d);





                        }
                    });

                }
            }
        });







        return rootView;
    }


}
