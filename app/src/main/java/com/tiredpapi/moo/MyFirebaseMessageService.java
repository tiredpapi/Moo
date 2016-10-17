package com.tiredpapi.moo;

import android.media.MediaPlayer;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by michal on 12.10.16.
 */

public class MyFirebaseMessageService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.i(Constant.LOG_TAG, "Message recieved");

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.cow);
        mediaPlayer.start();
    }
}
