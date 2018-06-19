package com.example.medina.stomatologdiplomski.Api;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.medina.stomatologdiplomski.Helper.Config;
import com.example.medina.stomatologdiplomski.Helper.MyRunnable;
import com.example.medina.stomatologdiplomski.Helper.volley.MyVolley;
import com.example.medina.stomatologdiplomski.Model.PregledPostVM;
import com.example.medina.stomatologdiplomski.MyApp;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PregledApi {
    public static void postPregled(final Context context, final MyRunnable<PregledPostVM> onSuccess, PregledPostVM pregled) {

        final String url = Config.urlApi + "Pregled/PostPregled/";

//double k=round2(pregled.Cijena);
        MyVolley.post(url, PregledPostVM.class, new Response.Listener<PregledPostVM>() {
            @Override
            public void onResponse(PregledPostVM response) {
                onSuccess.run(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MyApp.getContext(), "Greška u komunikaciji sa serverom : " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }, pregled);
    }



    public static double round2(Double val) {
        return new BigDecimal(val.toString()).setScale(2,RoundingMode.HALF_UP).doubleValue();
    }
}
