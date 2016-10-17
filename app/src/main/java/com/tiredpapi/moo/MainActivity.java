package com.tiredpapi.moo;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


public class MainActivity extends AppCompatActivity {
    AndroidID androidID;
    Firebase firebaseReference;
    Firebase firebaseUserGroup;
    TextView textView;
    MediaPlayer mediaPlayer;

    public void buttonPushed(View view) {
        firebaseUserGroup.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                    Log.i(Constant.LOG_TAG, "Current key: " + dataSnapshot1.getKey().toString());
                    Log.i(Constant.LOG_TAG, "Current value: " + dataSnapshot1.getValue().toString());

                    if (dataSnapshot1.getValue().toString() == "false") {
                        firebaseUserGroup.child(dataSnapshot1.getKey()).setValue("true");
                        Log.i(Constant.LOG_TAG, "After the change: " + dataSnapshot1.getKey().toString());
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(Constant.LOG_TAG, "onCreate");
        //*

        androidID = new AndroidID(this);
        firebaseReference = new Firebase(FirebaseConfig.FIREBASE_URL);
        firebaseUserGroup = firebaseReference.child("Users");

        textView = (TextView) findViewById(R.id.textAndroidID);
        textView.setText(androidID.getAndroidID());
        mediaPlayer = MediaPlayer.create(this, R.raw.cow);

        firebaseUserGroup.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(androidID.getAndroidID()).exists()) {
                    if(dataSnapshot.child(androidID.getAndroidID()).getValue().toString() == "true") {
                        Log.i(Constant.LOG_TAG, "onData change in main changed the status to false");

                        mediaPlayer.start();
                        firebaseUserGroup.child(androidID.getAndroidID()).setValue(false);
                    }
                } {
                    Log.i(Constant.LOG_TAG, "Android id created: " + androidID.getAndroidID());
                    firebaseUserGroup.child(androidID.getAndroidID()).setValue(false);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.i(Constant.LOG_TAG, "Something is wrong with the database");
            }
        });
    }
}

