package com.example.medina.stomatologdiplomski;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medina.stomatologdiplomski.Api.PacijentApi;
import com.example.medina.stomatologdiplomski.Api.TerminApi;
import com.example.medina.stomatologdiplomski.Helper.F;
import com.example.medina.stomatologdiplomski.Helper.Global;
import com.example.medina.stomatologdiplomski.Helper.MyRunnable;
import com.example.medina.stomatologdiplomski.Model.PacijentVM;
import com.example.medina.stomatologdiplomski.Model.PonedjeljakVM;

import org.json.JSONArray;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


public class PonedjeljakFragment extends Fragment {


    public PonedjeljakFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_ponedjeljak, container, false);

       final ListView lista=view.findViewById(R.id.listaPon);
        TerminApi.getPonedjeljak(getContext(), new MyRunnable<PonedjeljakVM>() {
            @Override
            public void run(final PonedjeljakVM ponedjeljakVM) {
                if(ponedjeljakVM !=null){
lista.setAdapter(new BaseAdapter() {
    @Override
    public int getCount() {
        return ponedjeljakVM._Ponedjeljak.size();
    }

    @Override
    public Object getItem(int position) {
        return ponedjeljakVM._Ponedjeljak.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {

            view = getLayoutInflater().inflate(R.layout.layout_pon, parent, false);
        }

        PonedjeljakVM.Ponedjeljak x=ponedjeljakVM._Ponedjeljak.get(position);
        TextView tv=view.findViewById(R.id.pacijent);
        tv.setText(x.Pacijent);
        TextView tvdatum=view.findViewById(R.id.datum);

        String t=F.Date_ddMMyyyy(x.Datum);
        tvdatum.setText(t);
        TextView tvvrijeme=view.findViewById(R.id.vrijeme);
        String v=F.Time_HHmm(x.Vrijeme);
        tvvrijeme.setText(v);

        return view;
    }
});
                }


                lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        PonedjeljakVM.Ponedjeljak x=ponedjeljakVM._Ponedjeljak.get(position);
                        Date date= new Date();


if(  F.Date_ddMMyyyy(date).compareTo(F.Date_ddMMyyyy(x.Datum))==0)  {
    DialogFragment d = new UnosPregledaFragment();
    Bundle arg = new Bundle();
    arg.putInt("terminId", x.Id);
    arg.putInt("pacijentId", x.PacijentId);
    d.setArguments(arg);
    Util.otvoriFragmentKaoDialog(getActivity(), d);
}
                    }
                });
            }
        });

        return view;
    }

}


