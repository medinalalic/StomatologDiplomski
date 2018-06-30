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
import com.example.medina.stomatologdiplomski.Model.CetvrtakVM;
import com.example.medina.stomatologdiplomski.Model.PetakVM;
import com.example.medina.stomatologdiplomski.Model.PonedjeljakVM;
import com.example.medina.stomatologdiplomski.Model.SrijedaVM;
import com.example.medina.stomatologdiplomski.Model.TerminVM;
import com.example.medina.stomatologdiplomski.Model.TrenutnaDatumiVM;
import com.example.medina.stomatologdiplomski.Model.UtorakVM;
import com.example.medina.stomatologdiplomski.MyApp;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TerminApi {
    public static void pretragaTermina(final Context context, final String datum1, final String datum2, final MyRunnable<JSONArray> onSuccess) {
        final String url = Config.urlApi + "Termin/PretragaTermina/" + datum1+"/"+datum2;
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
                Toast.makeText(MyApp.getContext(), "Odaberite datume!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void datumiTrenutne(final Context context, final MyRunnable<TrenutnaDatumiVM> onSuccess) {

        final String url = Config.urlApi + "Termin/DatumiSedmiceTrenutne";


        MyVolley.get(url, TrenutnaDatumiVM.class, new Response.Listener<TrenutnaDatumiVM>() {
            @Override
            public void onResponse(TrenutnaDatumiVM response) {
                onSuccess.run(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MyApp.getContext(), "Greška u komunikaciji sa serverom : " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void datumiNaredne(final Context context, final MyRunnable<TrenutnaDatumiVM> onSuccess) {

        final String url = Config.urlApi + "Termin/DatumiNaredneSedmice";


        MyVolley.get(url, TrenutnaDatumiVM.class, new Response.Listener<TrenutnaDatumiVM>() {
            @Override
            public void onResponse(TrenutnaDatumiVM response) {
                onSuccess.run(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MyApp.getContext(), "Greška u komunikaciji sa serverom : " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public static void datumiProsle(final Context context, final MyRunnable<TrenutnaDatumiVM> onSuccess) {

        final String url = Config.urlApi + "Termin/DatumiProsleSedmice";


        MyVolley.get(url, TrenutnaDatumiVM.class, new Response.Listener<TrenutnaDatumiVM>() {
            @Override
            public void onResponse(TrenutnaDatumiVM response) {
                onSuccess.run(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MyApp.getContext(), "Greška u komunikaciji sa serverom : " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static ArrayList< TerminVM.TerminInfo > jsonToTerminList(JSONArray jsonObj) {

        ArrayList < TerminVM.TerminInfo  > items = new ArrayList < TerminVM.TerminInfo  > ();

        JSONObject o = new JSONObject();


        try {
            for (int i = 0; i < (jsonObj.length()); i++) {

                items.add(new TerminVM.TerminInfo(jsonObj.getJSONObject(i).getInt("Id"),
                        jsonObj.getJSONObject(i).getString("Datum"),
                        jsonObj.getJSONObject(i).getString("Vrijeme"),
                        jsonObj.getJSONObject(i).getBoolean("Odobren"),
                        jsonObj.getJSONObject(i).getInt("PacijentId"),
                        jsonObj.getJSONObject(i).getString("RazlogPosjete"),
                        jsonObj.getJSONObject(i).getString("Ime"),
                        jsonObj.getJSONObject(i).getString("Prezime")


                        ));

            }




        } catch (Exception e) {

            Log.e("jsonTermini", "err: " + e.getMessage());

        }

        return items;

    }








    public static void getPonedjeljak(final Context context, final MyRunnable<PonedjeljakVM> onSuccess) {


        final String url = Config.urlApi + "Termin/PonedjeljakTermini";
        MyVolley.get(url, PonedjeljakVM.class, new Response.Listener<PonedjeljakVM>() {
                    @Override
                    public void onResponse(PonedjeljakVM response) {
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

    public static void getUtorak(final Context context, final MyRunnable<UtorakVM> onSuccess) {


        final String url = Config.urlApi + "Termin/UtorakTermini";
        MyVolley.get(url, UtorakVM.class, new Response.Listener<UtorakVM>() {
                    @Override
                    public void onResponse(UtorakVM response) {
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
    public static void getSrijeda(final Context context, final MyRunnable<SrijedaVM> onSuccess) {


        final String url = Config.urlApi + "Termin/SrijedaTermini";
        MyVolley.get(url, SrijedaVM.class, new Response.Listener<SrijedaVM>() {
                    @Override
                    public void onResponse(SrijedaVM response) {
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
    public static void getCetvrtak(final Context context, final MyRunnable<CetvrtakVM> onSuccess) {


        final String url = Config.urlApi + "Termin/CetvrtakTermini";
        MyVolley.get(url, CetvrtakVM.class, new Response.Listener<CetvrtakVM>() {
                    @Override
                    public void onResponse(CetvrtakVM response) {
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
    public static void getPetak(final Context context, final MyRunnable<PetakVM> onSuccess) {


        final String url = Config.urlApi + "Termin/PetakTermini";
        MyVolley.get(url, PetakVM.class, new Response.Listener<PetakVM>() {
                    @Override
                    public void onResponse(PetakVM response) {
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

    public static void getPonedjeljakProsli(final Context context, final MyRunnable<PonedjeljakVM> onSuccess) {


        final String url = Config.urlApi + "Termin/ProslaSedmicaPonedjeljak";
        MyVolley.get(url, PonedjeljakVM.class, new Response.Listener<PonedjeljakVM>() {
                    @Override
                    public void onResponse(PonedjeljakVM response) {
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

    public static void getUtorakProsli(final Context context, final MyRunnable<UtorakVM> onSuccess) {


        final String url = Config.urlApi + "Termin/ProslaSedmicaUtorak";
        MyVolley.get(url, UtorakVM.class, new Response.Listener<UtorakVM>() {
                    @Override
                    public void onResponse(UtorakVM response) {
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
    public static void getSrijedaProsla(final Context context, final MyRunnable<SrijedaVM> onSuccess) {


        final String url = Config.urlApi + "Termin/ProslaSedmicaSrijeda";
        MyVolley.get(url, SrijedaVM.class, new Response.Listener<SrijedaVM>() {
                    @Override
                    public void onResponse(SrijedaVM response) {
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
    public static void getCetvrtakProsli(final Context context, final MyRunnable<CetvrtakVM> onSuccess) {


        final String url = Config.urlApi + "Termin/ProslaSedmicaCetvrtak";
        MyVolley.get(url, CetvrtakVM.class, new Response.Listener<CetvrtakVM>() {
                    @Override
                    public void onResponse(CetvrtakVM response) {
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
    public static void getPetakProsli(final Context context, final MyRunnable<PetakVM> onSuccess) {


        final String url = Config.urlApi + "Termin/ProslaSedmicaPetak";
        MyVolley.get(url, PetakVM.class, new Response.Listener<PetakVM>() {
                    @Override
                    public void onResponse(PetakVM response) {
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


    public static void getPonedjeljakNaredni(final Context context, final MyRunnable<PonedjeljakVM> onSuccess) {


        final String url = Config.urlApi + "Termin/SlijedecaSedmicaPonedjeljak";
        MyVolley.get(url, PonedjeljakVM.class, new Response.Listener<PonedjeljakVM>() {
                    @Override
                    public void onResponse(PonedjeljakVM response) {
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

    public static void getUtorakNaredni(final Context context, final MyRunnable<UtorakVM> onSuccess) {


        final String url = Config.urlApi + "Termin/SlijedecaSedmicaUtorak";
        MyVolley.get(url, UtorakVM.class, new Response.Listener<UtorakVM>() {
                    @Override
                    public void onResponse(UtorakVM response) {
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
    public static void getSrijedaNaredni(final Context context, final MyRunnable<SrijedaVM> onSuccess) {


        final String url = Config.urlApi + "Termin/SlijedecaSedmicaSrijeda";
        MyVolley.get(url, SrijedaVM.class, new Response.Listener<SrijedaVM>() {
                    @Override
                    public void onResponse(SrijedaVM response) {
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
    public static void getCetvrtakNaredni(final Context context, final MyRunnable<CetvrtakVM> onSuccess) {


        final String url = Config.urlApi + "Termin/SlijedecaSedmicaCetvrtak";
        MyVolley.get(url, CetvrtakVM.class, new Response.Listener<CetvrtakVM>() {
                    @Override
                    public void onResponse(CetvrtakVM response) {
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
    public static void getPetakNaredni(final Context context, final MyRunnable<PetakVM> onSuccess) {


        final String url = Config.urlApi + "Termin/SlijedecaSedmicaPetak";
        MyVolley.get(url, PetakVM.class, new Response.Listener<PetakVM>() {
                    @Override
                    public void onResponse(PetakVM response) {
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
