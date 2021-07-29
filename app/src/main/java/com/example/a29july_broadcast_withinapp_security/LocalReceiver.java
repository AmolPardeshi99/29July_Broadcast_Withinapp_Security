package com.example.a29july_broadcast_withinapp_security;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LocalReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent != null && intent.getAction() !=null ){
            Intent activityIntent = new Intent(context,MainActivity2.class);
            activityIntent.putExtra("data",intent.getStringExtra("message"));
            context.startActivity(activityIntent);
        }
    }
}