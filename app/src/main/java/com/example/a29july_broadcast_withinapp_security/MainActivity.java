package com.example.a29july_broadcast_withinapp_security;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
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
    private LocalReceiver localReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnSend = findViewById(R.id.btnSend);
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.amol");
                intent.putExtra("data", "This is message from activity1");
                sendBroadcast(intent);
                registerlocal();
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent("com.amol");
        intent.putExtra("data","This is message from activity1");
        sendBroadcast(intent,Manifest.permission.CAMERA);
       }

    private void registerlocal() {
        localReceiver = new LocalReceiver();
        IntentFilter intentFilter = new IntentFilter("com.amol");
        registerReceiver(localReceiver, intentFilter);
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        unregisterReceiver(localReceiver);
//    }

}