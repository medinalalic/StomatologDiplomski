package com.example.medina.stomatologdiplomski.Helper.volley;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.medina.stomatologdiplomski.Helper.MyGson;
import com.example.medina.stomatologdiplomski.MyApp;

import org.json.JSONArray;

import java.util.Map;


public class MyVolley {
    public static <T> void get (String urlStr, Class<T> responseType, Response.Listener<T> listener, Response.ErrorListener errorListener, String param1, String param2) {
        String url = urlStr + "/" + param1 + "/" + param2;
        GsonRequest<T> gsonRequest = new GsonRequest<>(url, responseType, null, null, listener, errorListener, Request.Method.GET);
        MySingleton.getInstance(MyApp.getContext()).addToRequestQueue(gsonRequest);


    }

  /*  public static <T> void get (String urlStr, Class<T> responseType, Response.Listener<T> listener, Response.ErrorListener errorListener, String param1) {
        String url = urlStr + "/" + param1;
        GsonRequest<T> gsonRequest = new GsonRequest<>(url, responseType, null, null, listener, errorListener, Request.Method.GET);
        MySingleton.getInstance(MyApp.getContext()).addToRequestQueue(gsonRequest);


    }
    public static <T> void get (String urlStr, Class<T> responseType, Response.Listener<T> listener, Response.ErrorListener errorListener, int param1) {
        String url = urlStr + "/" + param1;
        GsonRequest<T> gsonRequest = new GsonRequest<>(url, responseType, null, null, listener, errorListener, Request.Method.GET);
        MySingleton.getInstance(MyApp.getContext()).addToRequestQueue(gsonRequest);


    }*/
    public static <T> void get (String urlStr, Class<T> responseType, Response.Listener<T> listener, Response.ErrorListener errorListener, Object param1) {
        String url = urlStr + "/" + param1;
        GsonRequest<T> gsonRequest = new GsonRequest<>(url, responseType, null, null, listener, errorListener, Request.Method.GET);
        MySingleton.getInstance(MyApp.getContext()).addToRequestQueue(gsonRequest);


    }
    public static <T> void get (String urlStr, Class<T> responseType, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        String url = urlStr;
        GsonRequest<T> gsonRequest = new GsonRequest<>(url, responseType, null, null, listener, errorListener, Request.Method.GET);
        MySingleton.getInstance(MyApp.getContext()).addToRequestQueue(gsonRequest);


    }

    public static void get2 (String urlStr, JSONArray responseType, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener, Map<String, String>... inputParams)
    {
        String urlParam = "/";

        for (Map<String, String> map : inputParams) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                urlParam += entry.getValue() + "/";
            }
        }

        String url = urlStr + urlParam;

        JsonArrayRequest jsonRequest = new JsonArrayRequest(Request.Method.GET, url, responseType, listener, errorListener );

        MySingleton.getInstance(MyApp.getContext()).addToRequestQueue(jsonRequest);

    }

    public static <T> void post (String urlStr, Class<T> responseType, final Response.Listener<T> listener, Response.ErrorListener errorListener, Object postObject)
    {
        String jsonStr = MyGson.build().toJson(postObject);
        GsonRequest<T> gsonRequest = new GsonRequest<>(urlStr, responseType, null, jsonStr, listener, errorListener, Request.Method.POST);
        MySingleton.getInstance(MyApp.getContext()).addToRequestQueue(gsonRequest);

    }



}