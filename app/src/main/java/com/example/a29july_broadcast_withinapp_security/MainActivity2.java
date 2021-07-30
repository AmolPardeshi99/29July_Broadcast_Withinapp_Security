package com.example.a29july_broadcast_withinapp_security;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView mTvMessage;
    private LocalReceiver localReceiver ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTvMessage = findViewById(R.id.tvShowMessage);
        String message = getIntent().getStringExtra("data");
        mTvMessage.setText(message);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(localReceiver);
    }
}