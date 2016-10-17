package com.tiredpapi.moo;

import android.util.Log;

/**
 * Created by michal on 17.10.16.
 */

public class User {
    String androndID;
    boolean status;

    User (String s, boolean b) {
        this.androndID = s;
        this.status = b;
    }

    public void setAndrondID(String androndID) {
        this.androndID = androndID;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAndrondID() {
        return androndID;
    }

    public boolean getStatus() {
        return status;
    }
}
