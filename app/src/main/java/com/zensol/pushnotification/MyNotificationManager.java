package com.zensol.pushnotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

public class MyNotificationManager {

    private Context mCtx;
    private static MyNotificationManager mInstance;

    private MyNotificationManager(Context context){
        mCtx = context ;
    }

    public static synchronized MyNotificationManager getInstance(Context context){
        if (mInstance == null) {
            mInstance = new MyNotificationManager(context);
        }

        return mInstance;
    }


    public void displayNotification(String title, String body){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mCtx, Constants.CHANNEl_ID)
                .setSmallIcon(R.drawable.ic_stat_name)
                .setContentTitle(title)
                .setContentText(body);


        // user click to notification then open class....
        Intent intent = new Intent(mCtx, PlayStoreActivity.class);








        //
        PendingIntent pi = PendingIntent.getActivity(mCtx, 0, intent,PendingIntent.FLAG_UPDATE_CURRENT);

        mBuilder.setContentIntent(pi);

        NotificationManager notificationManager = (NotificationManager) mCtx.getSystemService(Context.NOTIFICATION_SERVICE);

        if (notificationManager != null){
            notificationManager.notify(1, mBuilder.build());
        }
    }
}
