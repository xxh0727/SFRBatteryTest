package com.tinno.sfrbatterytest.util;

import android.app.AlarmManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by Lando on 2016/4/12.
 */
public class Test {
    public static String ACTION_SENDING = "com.tinno.sfrbatterytest.SetSending";

    public static ArrayList<Calendar> getCalendar(){
        int[] hours = {9,9,10,10,11,11,14,14,15,15};
        int[] minutes = {0,30,0,30,0,30,0,30,0,30};
        int[] seconds = {0,0,0,0,0,0,0,0,0,0};
        ArrayList<Calendar> list = new ArrayList<Calendar>();

        for(int i=0; i<10; i++){
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            calendar.set(Calendar.HOUR_OF_DAY, hours[i]);
            calendar.set(Calendar.MINUTE, minutes[i]);
            calendar.set(Calendar.SECOND, seconds[i]);
            list.add(calendar);
        }
        return list;
    }

    public static void wakeUpAndUnlock(Context context){
        KeyguardManager km = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
        KeyguardManager.KeyguardLock kl = km.newKeyguardLock("unLock");
        kl.disableKeyguard();
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.SCREEN_DIM_WAKE_LOCK,"bright");
        wl.acquire();
        wl.release();
    }
}
