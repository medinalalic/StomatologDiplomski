package com.example.medina.stomatologdiplomski.Api;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.medina.stomatologdiplomski.Helper.Config;
import com.example.medina.stomatologdiplomski.Helper.MyRunnable;
import com.example.medina.stomatologdiplomski.Helper.volley.MyVolley;
import com.example.medina.stomatologdiplomski.Model.DijagnozaDropVM;
import com.example.medina.stomatologdiplomski.Model.LijekVM;
import com.example.medina.stomatologdiplomski.MyApp;

public class LijekApi {

    public static void getLijekove(final Context context, final MyRunnable<LijekVM> onSuccess) {


        final String url = Config.urlApi + "Lijek/GetLijekDrop";
        MyVolley.get(url, LijekVM.class, new Response.Listener<LijekVM>() {
                    @Override
                    public void onResponse(LijekVM response) {
                        onSuccess.run(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(MyApp.getContext(), "Greška u komunikaciji sa serverom : " + error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
