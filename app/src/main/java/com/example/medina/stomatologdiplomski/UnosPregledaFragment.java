package com.example.medina.stomatologdiplomski;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class UnosPregledaFragment extends DialogFragment {

    public UnosPregledaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_unos_pregleda, container, false);
        final  ImageView zub13=(ImageView)view.findViewById(R.id.zub13);
        final  ImageView zub11=(ImageView)view.findViewById(R.id.zub11);
        final  ImageView zub12=(ImageView)view.findViewById(R.id.zub12);
        final  ImageView zub22=(ImageView)view.findViewById(R.id.zub22);
        final  ImageView zub14=(ImageView)view.findViewById(R.id.zub14);
        final  ImageView zub15=(ImageView)view.findViewById(R.id.zub15);
        final  ImageView zub16=(ImageView)view.findViewById(R.id.zub16);
        final  ImageView zub17=(ImageView)view.findViewById(R.id.zub17);
        final  ImageView zub18=(ImageView)view.findViewById(R.id.zub18);
        final  ImageView zub21=(ImageView)view.findViewById(R.id.zub21);
        final  ImageView zub23=(ImageView)view.findViewById(R.id.zub23);
        final  ImageView zub24=(ImageView)view.findViewById(R.id.zub24);
        final  ImageView zub25=(ImageView)view.findViewById(R.id.zub25);
        final  ImageView zub26=(ImageView)view.findViewById(R.id.zub26);
        final  ImageView zub27=(ImageView)view.findViewById(R.id.zub27);
        final  ImageView zub28=(ImageView)view.findViewById(R.id.zub28);
        final  ImageView zub31=(ImageView)view.findViewById(R.id.zub31);
        final  ImageView zub32=(ImageView)view.findViewById(R.id.zub32);
        final  ImageView zub33=(ImageView)view.findViewById(R.id.zub33);
        final  ImageView zub34=(ImageView)view.findViewById(R.id.zub34);
        final  ImageView zub35=(ImageView)view.findViewById(R.id.zub35);
        final  ImageView zub36=(ImageView)view.findViewById(R.id.zub36);
        final  ImageView zub37=(ImageView)view.findViewById(R.id.zub37);
        final  ImageView zub38=(ImageView)view.findViewById(R.id.zub38);
        final  ImageView zub41=(ImageView)view.findViewById(R.id.zub41);
        final  ImageView zub42=(ImageView)view.findViewById(R.id.zub42);
        final  ImageView zub43=(ImageView)view.findViewById(R.id.zub43);
        final  ImageView zub44=(ImageView)view.findViewById(R.id.zub44);
        final  ImageView zub45=(ImageView)view.findViewById(R.id.zub45);
        final  ImageView zub46=(ImageView)view.findViewById(R.id.zub46);
        final  ImageView zub47=(ImageView)view.findViewById(R.id.zub47);
        final  ImageView zub48=(ImageView)view.findViewById(R.id.zub48);


        final Bundle args=getArguments();
getDialog().setTitle("Dijagram zuba");
if(args!=null){
    zub11.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        DialogFragment d=new PregledPostFragment();
        Bundle arg=new Bundle();
        arg.putInt("terminId",args.getInt("terminId"));
        arg.putInt("pacijentId",args.getInt("pacijentId"));
arg.putInt("zubId",1);
d.setArguments(arg);
getDialog().dismiss();
        Util.otvoriFragmentKaoDialog(getActivity(),d);
    }
      });
    zub12.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",2);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub13.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",3);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub14.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",4);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub15.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",5);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub16.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",6);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub17.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",7);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub18.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",8);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub21.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",9);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub22.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",10);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub23.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",11);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub24.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",12);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub25.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",13);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub26.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",14);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub27.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",15);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub28.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",16);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub31.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",18);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub32.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",20);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub33.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",21);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub34.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",22);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub35.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",23);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub36.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",24);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub37.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",25);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub38.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",26);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub41.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",27);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub42.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",28);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub43.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",29);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub44.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",30);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub45.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",31);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub46.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",32);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub47.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",33);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
    zub48.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment d=new PregledPostFragment();
            Bundle arg=new Bundle();
            arg.putInt("terminId",args.getInt("terminId"));
            arg.putInt("pacijentId",args.getInt("pacijentId"));
            arg.putInt("zubId",34);
            d.setArguments(arg);
            getDialog().dismiss();
            Util.otvoriFragmentKaoDialog(getActivity(),d);
        }
    });
}

        return view;
    }

}
