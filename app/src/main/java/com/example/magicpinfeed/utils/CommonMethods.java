package com.example.magicpinfeed.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class CommonMethods {

    public static boolean isNetworkConnected(Context context) {

        Boolean internetAvailability;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        internetAvailability = cm.getActiveNetworkInfo() != null;

        if(!internetAvailability)
            Toast.makeText(context, "Please connect your internet ", Toast.LENGTH_LONG).show();

        return internetAvailability;

    }
}
