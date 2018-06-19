package com.example.medina.stomatologdiplomski.Api;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.medina.stomatologdiplomski.Helper.Config;
import com.example.medina.stomatologdiplomski.Helper.MyRunnable;
import com.example.medina.stomatologdiplomski.Helper.volley.MyVolley;
import com.example.medina.stomatologdiplomski.Model.KorisniciVM;
import com.example.medina.stomatologdiplomski.MyApp;


public class AutentifikacijaApi {
    public static void Provjera(final Context context, final MyRunnable<KorisniciVM> onSuccess, final String username, final String password) {
        final String url = Config.urlApi + "Autentifikacija/ProvjeraStomatolog";
        final ProgressDialog dialog = ProgressDialog.show(context, "Pristup podacima", "U toku...");
        dialog.show();

        MyVolley.get(url, KorisniciVM.class, new Response.Listener<KorisniciVM>() {
                    @Override
                    public void onResponse(KorisniciVM response) {
                        dialog.dismiss();

                        if (response == null) {
                            Toast.makeText(MyApp.getContext(), "Pristupni podaci nisu ispravni : ", Toast.LENGTH_SHORT).show();
                        } else {

                            onSuccess.run(response);  }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        dialog.dismiss();
                        Toast.makeText(MyApp.getContext(), "Greška u komunikaciji sa serverom : " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }, username,
                password
        );
    }
}
