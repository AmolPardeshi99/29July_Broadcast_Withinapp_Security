package com.example.a29july_broadcast_withinapp_security;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnSend;
    public LocalBroadcastManager broadcastManager;
    private LocalReceiver localReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        broadcastManager = LocalBroadcastManager.getInstance(this);
        mBtnSend = findViewById(R.id.btnSend);
        registerlocal();
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.amol");
                intent.putExtra("message","This is message from activity1");
                broadcastManager.sendBroadcast(intent);
            }
        });

    }

    private void registerlocal() {
        IntentFilter intentFilter = new IntentFilter("com.amol");
       localReceiver = new LocalReceiver();
        broadcastManager.registerReceiver(localReceiver,intentFilter);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        broadcastManager.unregisterReceiver(localReceiver);
    }

}