package com.example.a29july_broadcast_withinapp_security;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class LocalReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Intent activityIntent = new Intent(context, MainActivity2.class);
            String message = intent.getStringExtra("data");
            activityIntent.putExtra("data", message);
            context.startActivity(activityIntent);
        }
    }
}