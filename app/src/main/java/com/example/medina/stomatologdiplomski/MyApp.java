package com.example.medina.stomatologdiplomski;

import android.app.Application;
import android.content.Context;

/**
 * Created by Medina on 16-Nov-17.
 */

public class MyApp extends Application {
    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}

