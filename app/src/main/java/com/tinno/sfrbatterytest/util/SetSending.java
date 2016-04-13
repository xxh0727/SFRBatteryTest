package com.tinno.sfrbatterytest.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Lando on 2016/4/12.
 */
public class SetSending {
    public Context context;

    public SetSending(Context context){
        this.context = context;
    }

    public void setAlarm(Context context){

        ArrayList<Calendar> list = Test.getCalendar();
        for(int i=0; i<list.size(); i++){
            Intent intent = new Intent(context, AlarmReciever.class);
            intent.setAction(Test.ACTION_SENDING);
            intent.putExtra("index", i+1);
            PendingIntent sender = PendingIntent.getBroadcast(
                    context, 0, intent, 0);
            Calendar calendar = list.get(i);
            AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
        }
    }
}
