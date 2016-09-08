package com.example.android.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.telephony.SmsMessage;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle info = intent.getExtras();
        if(info!=null){
            Object[] pduArray = (Object[]) info.get("pdus");
            SmsMessage[] messages = new SmsMessage[pduArray.length];
            for(int i=0;i<pduArray.length;i++)
            {
                messages[i]=SmsMessage.createFromPdu((byte[])pduArray[i]);
                Log.d("br", "Msg de:" + messages[i].getOriginatingAddress());
                Log.d("br","Texto:"+messages[i].getMessageBody());
            }
        }

        NotificationManager mNotificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        int icon = R.mipmap.ic_launcher;
        String tickerText = "Evento de sms";
        long when = System.currentTimeMillis();
        CharSequence contentTitle = "SMS";
        CharSequence contentText = "Evento de sms";
        Intent notificationIntent = new Intent(context,MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder  builder = new NotificationCompat.Builder(context);

        Notification notification = builder.setContentIntent(contentIntent)
                .setSmallIcon(icon)
                .setTicker(tickerText)
                .setWhen(when)
                .setAutoCancel(true)
                .setContentTitle(contentTitle)
                .setContentText(contentText)
                .addAction(R.mipmap.ic_launcher,"boton", contentIntent)
                .setStyle(new android.support.v4.app.NotificationCompat.BigTextStyle())
                .build();

        mNotificationManager.notify(0, notification);

    }
}
