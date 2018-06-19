package com.example.medina.stomatologdiplomski.Helper;

import android.view.View;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Medina on 22-Nov-17.
 */

public class F {
    public static <T> T findView(View view, int id, Class<T> tClass)
    {
        final View viewById = view.findViewById(id);
        return (T) viewById;
    }

    public static String Date_ddMMyyyy(Date datum)
    {
        final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return sdf.format(datum);
    }
    public static String Time_HHmm(Date datum)
    {
        final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(datum);
    }
    public static String decimal_0_00(float value)
    {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(value);
    }
}
