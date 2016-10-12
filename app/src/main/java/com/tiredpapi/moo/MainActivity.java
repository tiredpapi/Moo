package com.tiredpapi.moo;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    public void playButton(View view) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(LogTag.LOG_TAG, "App started");

        textView = (TextView) findViewById(R.id.textViewNumber);
        textView.setText("Received notification: " + LogTag.number);
    }

    @Override
    protected void onStart() {
        super.onStart();

        textView.setText("Received notification: " + LogTag.number);
    }
}
