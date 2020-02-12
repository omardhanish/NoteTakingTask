package com.example.notetakingtask.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils
{

    public static String getTimeStamp()
    {
        SimpleDateFormat dateTime = new SimpleDateFormat("dd/MM/yyyy hh.mm aa");
        return dateTime.format(new Date());
    }

}
