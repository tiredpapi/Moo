package com.tiredpapi.moo;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by michal on 13.10.16.
 */

public class FirebaseConfig extends Application {
    public static final String FIREBASE_URL = "https://mooo-b054e.firebaseio.com";
    public static final String FIREBASE_USERS = "Users";

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
