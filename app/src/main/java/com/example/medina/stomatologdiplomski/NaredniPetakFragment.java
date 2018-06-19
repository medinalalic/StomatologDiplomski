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
import com.example.medina.stomatologdiplomski.Model.PetakVM;


public class NaredniPetakFragment extends Fragment {

    public NaredniPetakFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_naredni_petak, container, false);
        final ListView lista=view.findViewById(R.id.petak);
        TerminApi.getPetakNaredni(getContext(), new MyRunnable<PetakVM>() {
            @Override
            public void run(final PetakVM petakVM) {
               if(petakVM!=null){
                   lista.setAdapter(new BaseAdapter() {
                       @Override
                       public int getCount() {
                           return petakVM._Petak.size();
                       }

                       @Override
                       public Object getItem(int position) {
                           return petakVM._Petak.get(position);
                       }

                       @Override
                       public long getItemId(int position) {
                           return 0;
                       }

                       @Override
                       public View getView(int position, View view, ViewGroup parent) {
                           if (view == null) {

                               view = getLayoutInflater().inflate(R.layout.layout_np, parent, false);
                           }

                           PetakVM.Petak x=petakVM._Petak.get(position);
                           TextView tv=view.findViewById(R.id.p);
                           tv.setText(x.Pacijent);
                           TextView tvdatum=view.findViewById(R.id.d);

                           String t= F.Date_ddMMyyyy(x.Datum);
                           tvdatum.setText(t);
                           TextView tvvrijeme=view.findViewById(R.id.v);
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
