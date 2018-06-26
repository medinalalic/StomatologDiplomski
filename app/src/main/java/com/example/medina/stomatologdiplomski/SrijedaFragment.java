package com.example.medina.stomatologdiplomski;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.medina.stomatologdiplomski.Api.TerminApi;
import com.example.medina.stomatologdiplomski.Helper.F;
import com.example.medina.stomatologdiplomski.Helper.MyRunnable;
import com.example.medina.stomatologdiplomski.Model.PonedjeljakVM;
import com.example.medina.stomatologdiplomski.Model.SrijedaVM;
import com.example.medina.stomatologdiplomski.Model.UtorakVM;

import java.util.Date;


public class SrijedaFragment extends Fragment {


    public SrijedaFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_srijeda, container, false);
        final ListView lista=view.findViewById(R.id.srijedaLista);
        TerminApi.getSrijeda(getContext(), new MyRunnable<SrijedaVM>() {
            @Override
            public void run(final SrijedaVM srijedaVM) {
                if(srijedaVM!=null){
                    lista.setAdapter(new BaseAdapter() {
                        @Override
                        public int getCount() {
                            return srijedaVM._Srijeda.size();
                        }

                        @Override
                        public Object getItem(int position) {
                            return srijedaVM._Srijeda.get(position);
                        }

                        @Override
                        public long getItemId(int position) {
                            return 0;
                        }

                        @Override
                        public View getView(int position, View view, ViewGroup parent) {
                            if (view == null) {

                                view = getLayoutInflater().inflate(R.layout.layout_sri, parent, false);
                            }

                            SrijedaVM.Srijeda x=srijedaVM._Srijeda.get(position);
                            TextView tv=view.findViewById(R.id.ip);
                            tv.setText(x.Pacijent);
                            TextView tvr=view.findViewById(R.id.razlog);
                            tvr.setText(x.Napomena);
                            TextView tvvrijeme=view.findViewById(R.id.vr);
                            String v=F.Time_HHmm(x.Vrijeme);
                            tvvrijeme.setText(v);

                            return view;
                        }
                    });
                    lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            SrijedaVM.Srijeda x=srijedaVM._Srijeda.get(position);


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
                if(srijedaVM._Srijeda.size()==0) {
                    TextView tv = view.findViewById(R.id.tt);
                    tv.setText("Nema zakazanih termina");
                }
            }
        });

        return view;
    }


}
