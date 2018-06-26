package com.example.medina.stomatologdiplomski;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.medina.stomatologdiplomski.Api.TerminApi;
import com.example.medina.stomatologdiplomski.Helper.F;
import com.example.medina.stomatologdiplomski.Helper.MyRunnable;
import com.example.medina.stomatologdiplomski.Model.PonedjeljakVM;
import com.example.medina.stomatologdiplomski.Model.UtorakVM;


public class ProsliUtorakFragment extends Fragment {


    public ProsliUtorakFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_prosli_utorak, container, false);
        final ListView lista=view.findViewById(R.id.listaUtoProsli);
        TerminApi.getUtorakProsli(getContext(), new MyRunnable<UtorakVM>() {
            @Override
            public void run(final UtorakVM utorakVM) {
                if(utorakVM!=null){
                    lista.setAdapter(new BaseAdapter() {
                        @Override
                        public int getCount() {
                            return utorakVM._Utorak.size();
                        }

                        @Override
                        public Object getItem(int position) {
                            return utorakVM._Utorak.get(position);
                        }

                        @Override
                        public long getItemId(int position) {
                            return 0;
                        }

                        @Override
                        public View getView(int position, View view, ViewGroup parent) {
                            if (view == null) {

                                view = getLayoutInflater().inflate(R.layout.layout_prosliuto, parent, false);
                            }

                            UtorakVM.Utorak x=utorakVM._Utorak.get(position);
                            TextView tv=view.findViewById(R.id.pacijentprou);
                            tv.setText(x.Pacijent);
                            TextView tvr=view.findViewById(R.id.razlog);
                            tvr.setText(x.Napomena);
                            TextView tvvrijeme=view.findViewById(R.id.vrijemeprou);
                            String v=F.Time_HHmm(x.Vrijeme);
                            tvvrijeme.setText(v);
                            return view;
                        }
                    });
                }
                if(utorakVM._Utorak.size()==0) {
                    TextView tv = view.findViewById(R.id.tt);
                    tv.setText("Nema zakazanih termina");
                }
            }
        });


        return view;
    }


}
