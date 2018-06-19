package com.example.medina.stomatologdiplomski.Helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.medina.stomatologdiplomski.Model.KorisniciVM;
import com.example.medina.stomatologdiplomski.MyApp;

import java.io.Serializable;


public class Sesija implements Serializable {

    private static KorisniciVM logoiraniKorisnik;



    private static final String PREFS_NAME = "DatotekaZaSharedPreferences";

    public static KorisniciVM getlogiraniKorisnik()
    {
        // Restore preferences
        SharedPreferences settings = MyApp.getContext().getSharedPreferences(PREFS_NAME, 0);
        String str = settings.getString("logiraniKorisnikJson", "");

        if (str.length() == 0)
            return null;
        final KorisniciVM logiraniKorisnik = MyGson.build().fromJson(str, KorisniciVM.class);

        return logiraniKorisnik;
    }


    public static void setlogiraniKorisnik(KorisniciVM logiraniKorisnik)
    {
        final String str = MyGson.build().toJson(logiraniKorisnik);
        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences settings = MyApp.getContext().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("logiraniKorisnikJson", str);

        // Commit the edits!
        editor.commit();

    }
    public static void OdjavaKorisnik(Context context){
        SharedPreferences settings=context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor=settings.edit();
        editor.clear().commit();
    }

}
