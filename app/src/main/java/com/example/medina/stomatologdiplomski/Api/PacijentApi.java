package com.example.medina.stomatologdiplomski.Api;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.medina.stomatologdiplomski.Helper.Config;
import com.example.medina.stomatologdiplomski.Helper.MyRunnable;
import com.example.medina.stomatologdiplomski.Helper.volley.MyVolley;
import com.example.medina.stomatologdiplomski.Model.PacijentVM;
import com.example.medina.stomatologdiplomski.MyApp;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class PacijentApi {
    public static void getPacijentByIme(final Context context, final String ime, final MyRunnable<JSONArray> onSuccess) {
        final String url = Config.urlApi + "Pacijent/GetPacijentByIme/" + ime;
        final ProgressDialog dialog = ProgressDialog.show(context, "Pristup podacima", "U toku");
        dialog.show();
        MyVolley.get2(url, new JSONArray(), new Response.Listener < JSONArray > () {
            @Override
            public void onResponse(JSONArray response) {
                dialog.dismiss();
                onSuccess.run(response);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();
                Toast.makeText(MyApp.getContext(), "Greška u komunikaciji sa serverom : " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    public static void getAllPpacijenti(final Context context, final MyRunnable < JSONArray > onSuccess) {

        final String url = Config.urlApi + "Pacijent/GetAllPacijenti";
        final ProgressDialog dialog = ProgressDialog.show(context, "Pristup podacima", "U toku");
        dialog.show();
        MyVolley.get2(url, new JSONArray(), new Response.Listener < JSONArray > () {
            @Override
            public void onResponse(JSONArray response) {
                dialog.dismiss();
                onSuccess.run(response);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();
                Toast.makeText(MyApp.getContext(), "Greška u komunikaciji sa serverom : " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static ArrayList< PacijentVM.PacijentInfo > jsonToPacijentList(JSONArray jsonObj) {

        ArrayList < PacijentVM.PacijentInfo  > items = new ArrayList < PacijentVM.PacijentInfo  > ();

        JSONObject o = new JSONObject();


        try {
            for (int i = 0; i < (jsonObj.length()); i++) {

                items.add(new PacijentVM.PacijentInfo(jsonObj.getJSONObject(i).getInt("Id"),
                        jsonObj.getJSONObject(i).getString("JMBG"),
                        jsonObj.getJSONObject(i).getString("AddedOn"),
jsonObj.getJSONObject(i).get("Slika").toString(),
                        jsonObj.getJSONObject(i).getString("Ime"),
                        jsonObj.getJSONObject(i).getString("Prezime"),
                        jsonObj.getJSONObject(i).getString("Email"),
                        jsonObj.getJSONObject(i).getString("Mobitel")
                        ) );

            }




        } catch (Exception e) {

            Log.e("jsonNeocjProizvodi", "err: " + e.getMessage());

        }

        return items;

    }





}
