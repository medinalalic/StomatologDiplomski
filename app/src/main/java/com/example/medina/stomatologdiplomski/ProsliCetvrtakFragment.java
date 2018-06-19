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
import com.example.medina.stomatologdiplomski.Model.CetvrtakVM;
import com.example.medina.stomatologdiplomski.Model.PonedjeljakVM;


public class ProsliCetvrtakFragment extends Fragment {


    public ProsliCetvrtakFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_prosli_cetvrtak, container, false);
        final ListView lista=view.findViewById(R.id.listaProcetvrtak);
        TerminApi.getCetvrtakProsli(getContext(), new MyRunnable<CetvrtakVM>() {
            @Override
            public void run(final CetvrtakVM cetvrtakVM) {
                if(cetvrtakVM!=null){
                    lista.setAdapter(new BaseAdapter() {
                        @Override
                        public int getCount() {
                            return cetvrtakVM._Cetvrtak.size();
                        }

                        @Override
                        public Object getItem(int position) {
                            return cetvrtakVM._Cetvrtak.get(position);
                        }

                        @Override
                        public long getItemId(int position) {
                            return 0;
                        }

                        @Override
                        public View getView(int position, View view, ViewGroup parent) {
                            if (view == null) {

                                view = getLayoutInflater().inflate(R.layout.layout_cetvrtpro, parent, false);
                            }

                            CetvrtakVM.Cetvrtak x=cetvrtakVM._Cetvrtak.get(position);
                            TextView tv=view.findViewById(R.id.pcet);
                            tv.setText(x.Pacijent);
                            TextView tvdatum=view.findViewById(R.id.dcet);

                            String t= F.Date_ddMMyyyy(x.Datum);
                            tvdatum.setText(t);
                            TextView tvvrijeme=view.findViewById(R.id.vcet);
                            String v=F.Time_HHmm(x.Vrijeme);
                            tvvrijeme.setText(v);
                            return view;
                        }
                    });
                }
            }
        });


        return view;
    }


}
