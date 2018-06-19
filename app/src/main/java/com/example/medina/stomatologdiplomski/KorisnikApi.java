package com.example.medina.stomatologdiplomski;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.medina.stomatologdiplomski.Helper.Config;
import com.example.medina.stomatologdiplomski.Helper.MyRunnable;
import com.example.medina.stomatologdiplomski.Helper.volley.MyVolley;
import com.example.medina.stomatologdiplomski.Model.KorisniciVM;

public class KorisnikApi {
    public static void IzmjenaPodataka(final Context context, final MyRunnable<KorisniciVM> onSuccess, final Object object) {

        final String url = Config.urlApi + "Korisnik/IzmjenaPodatka";
        MyVolley.post(url, KorisniciVM.class, new Response.Listener<KorisniciVM>() {
                    @Override
                    public void onResponse(KorisniciVM response) {

                        onSuccess.run(response);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MyApp.getContext(), "Greška sa konekcijom : " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                },
                object

        );
    }
}
