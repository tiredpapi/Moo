package com.tiredpapi.moo;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;

/**
 * Created by michal on 17.10.16.
 */

public class AndroidID {
    private Context context;
    private final String androidId;


    public AndroidID(Context context) {
        this.context = context;
        this.androidId = android.provider.Settings.Secure.getString(this.context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public String getAndroidID() {
        if (androidId == null) {
            Log.w(Constant.LOG_TAG, "AndroidID is null");
        } else {
            Log.i(Constant.LOG_TAG, "AndroidID found");
        }

        return androidId;
    }
}
