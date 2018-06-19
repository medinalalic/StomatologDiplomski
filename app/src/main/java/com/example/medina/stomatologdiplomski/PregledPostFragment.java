package com.example.medina.stomatologdiplomski;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.medina.stomatologdiplomski.Api.DijagnozaApi;
import com.example.medina.stomatologdiplomski.Api.LijekApi;
import com.example.medina.stomatologdiplomski.Api.PregledApi;
import com.example.medina.stomatologdiplomski.Api.UslugaApi;
import com.example.medina.stomatologdiplomski.Helper.F;
import com.example.medina.stomatologdiplomski.Helper.Global;
import com.example.medina.stomatologdiplomski.Helper.MyRunnable;
import com.example.medina.stomatologdiplomski.Helper.Sesija;
import com.example.medina.stomatologdiplomski.Model.DijagnozaDropVM;
import com.example.medina.stomatologdiplomski.Model.LijekVM;
import com.example.medina.stomatologdiplomski.Model.PregledPostVM;
import com.example.medina.stomatologdiplomski.Model.UslugaNazivVM;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PregledPostFragment extends DialogFragment {
private Spinner lista;
private Spinner lista2;
private Spinner lista3;
    final PregledPostVM p=new PregledPostVM();

    public PregledPostFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_pregled_post, container, false);
        lista = view.findViewById(R.id.spinner);
        lista2 = view.findViewById(R.id.spinner2);
        lista3 = view.findViewById(R.id.spinner3);

       final Bundle args = getArguments();
        if (args != null) {
            getDialog().setTitle("Unos pregleda");
            MyRunnable<DijagnozaDropVM> onSuccess = new MyRunnable<DijagnozaDropVM>() {
                public void run(DijagnozaDropVM response) {

                    SetujSpinner(response);
                }
            };
            DijagnozaApi.getDijagnoze(getContext(), onSuccess);


            MyRunnable<UslugaNazivVM> onSuccess1 = new MyRunnable<UslugaNazivVM>() {
                public void run(UslugaNazivVM response) {

                    SetujSpinner2(response);
                }
            };
            UslugaApi.getUsluge(getContext(), onSuccess1);


            MyRunnable<LijekVM> onSuccess3 = new MyRunnable<LijekVM>() {
                public void run(LijekVM response) {

                    SetujSpinner3(response);
                }
            };
            LijekApi.getLijekove(getContext(), onSuccess3);



       p.TerminId=args.getInt("terminId");
       p.PacijentId=args.getInt("pacijentId");
       p.ZubId=args.getInt("zubId");
p.StomatologId=Sesija.getlogiraniKorisnik().Id;
p.IsObavljen=true;


            p.Datum=new Date();
            p.Vrijeme=new Date();

Button btn=view.findViewById(R.id.btnPregled);
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        EditText t=view.findViewById(R.id.tv);
        String s=t.getText().toString();
        DecimalFormat df = new DecimalFormat("#.00");
        String dd = df.format(Double.parseDouble(s));
        p.Cijena=dd;
        PregledApi.postPregled(getContext(), new MyRunnable<PregledPostVM>() {
            @Override
            public void run(PregledPostVM result) {
                if (result != null) {
                   // Toast.makeText(getContext(), "Pregled je unesen ", Toast.LENGTH_SHORT).show();
                    //notifikacija
                   
                   String d=F.Date_ddMMyyyy(new Date());
                   String body = "Pregled uspješno evidentiran";
                    Intent intent = new Intent(getActivity(), MeniActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    PendingIntent p = PendingIntent.getActivity(getActivity(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
                    Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    NotificationCompat.Builder notify = new NotificationCompat.Builder(getActivity())
                            .setContentText(body)
                            .setContentTitle(d)
                            .setSmallIcon(R.drawable.icon)
                            .setSound(sound)
                            .setAutoCancel(true)
                            .setContentIntent(p);


                    NotificationManager notif = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);

                    notif.notify(0, notify.build());
getDialog().dismiss();
                } else{
                    Toast.makeText(getContext(), "Greška, pokušajte kasnije ", Toast.LENGTH_SHORT).show();
                    getDialog().dismiss();

                }

            }
        }, p);
    }
});


    }
            return view;

        }

        private void SetujSpinner3 (LijekVM response){
            final String[] listaD = new String[response.lijekovi.size()];
            for (int i = 0; i < response.lijekovi.size(); i++) {
                listaD[i] = response.lijekovi.get(i).Naziv;
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.layout_spinner_item, listaD);
            lista3.setAdapter(adapter);
            lista3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    long selected =lista3.getSelectedItemId()+1;
                    p.LijekId=((int)selected);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

        private void SetujSpinner (DijagnozaDropVM response){
            final String[] listaD = new String[response.dijagnoze.size()];
            for (int i = 0; i < response.dijagnoze.size(); i++) {
                listaD[i] = response.dijagnoze.get(i).Naziv;
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.layout_spinner_item, listaD);
            lista.setAdapter(adapter);
            lista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    long selected2 = lista.getSelectedItemId()+1;
                    p.DijagnozaId= ((int) selected2);

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }



    private void SetujSpinner2 (UslugaNazivVM response){
            final String[] listaU = new String[response.usluge.size()];
            for (int i = 0; i < response.usluge.size(); i++) {
                listaU[i] = response.usluge.get(i).Naziv;
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.layout_spinner_itemdva, listaU);
            lista2.setAdapter(adapter);

            lista2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    long selected3 =lista2.getSelectedItemId()+13;//zbog id u bazi ne ide od 1
                    p.UslugaId=((int)selected3);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }



}
