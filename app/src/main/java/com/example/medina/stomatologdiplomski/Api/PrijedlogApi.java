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
import com.example.medina.stomatologdiplomski.Model.PrijedlogVM;
import com.example.medina.stomatologdiplomski.MyApp;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class PrijedlogApi {
    public static void getprijedloge(final Context context,int stomatologID, final MyRunnable< JSONArray > onSuccess) {

        final String url = Config.urlApi + "Poruka/GetPrijedloge/"+stomatologID;
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

    public static ArrayList< PrijedlogVM.PrijedlogInfo > jsonToPrijedlogList(JSONArray jsonObj) {

        ArrayList <  PrijedlogVM.PrijedlogInfo  > items = new ArrayList <  PrijedlogVM.PrijedlogInfo  > ();

        JSONObject o = new JSONObject();


        try {
            for (int i = 0; i < (jsonObj.length()); i++) {

                items.add(new PrijedlogVM.PrijedlogInfo(jsonObj.getJSONObject(i).getInt("Id"),
                        jsonObj.getJSONObject(i).getString("IPPacijent"),
                        jsonObj.getJSONObject(i).getString("TekstPoruke"),
                        jsonObj.getJSONObject(i).getString("IPStomatolog")
                ) );

            }




        } catch (Exception e) {

            Log.e("jsonPrijedlozi", "err: " + e.getMessage());

        }

        return items;

    }
}
