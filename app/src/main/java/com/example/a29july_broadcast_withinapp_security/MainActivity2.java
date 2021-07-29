package com.example.a29july_broadcast_withinapp_security;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView mTvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTvName = findViewById(R.id.tvShowMessage);

        if (getIntent() != null && getIntent().getExtras() !=null){
            mTvName.setText(getIntent().getStringExtra("data"));
        }
    }



}