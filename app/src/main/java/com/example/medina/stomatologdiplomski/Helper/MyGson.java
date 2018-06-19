package com.example.medina.stomatologdiplomski.Helper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Medina on 17-Nov-2017
 */
public class MyGson {
    public static Gson build()
    {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return gsonBuilder.create();
    }
}

