package com.tinno.sfrbatterytest.util;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.tinno.sfrbatterytest.service.TestingService;

/**
 * Created by Lando on 2016/4/12.
 */
public class ServiceUtil {

    public static void startAlarmManager(Context context){
        PendingIntent alarmSender = null;
        Intent startIntent = new Intent(context, TestingService.class);
        startIntent.setAction(Constants.TESTING_SERVICE_ACTION);
        try {
            alarmSender = PendingIntent.getService(context, 0, startIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        }catch (Exception e){
            e.printStackTrace();
        }
        AlarmManager am = (AlarmManager) context.getSystemService(Activity.ALARM_SERVICE);
        am.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), Constants.ELAPSED_TIME, alarmSender);
    }

    public static void stopAlarmManager(Context context){
        Intent intent = new Intent(context, TestingService.class);
        intent.setAction(Constants.TESTING_SERVICE_ACTION);
        PendingIntent pendingIntent= PendingIntent.getService(context, 0, intent,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarm=(AlarmManager)context.getSystemService(Activity.ALARM_SERVICE);
        alarm.cancel(pendingIntent);
    }
}
