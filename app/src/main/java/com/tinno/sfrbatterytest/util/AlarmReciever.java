package com.tinno.sfrbatterytest.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.net.Socket;

/**
 * Created by Lando on 2016/4/12.
 */
public class AlarmReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        int index = (int)intent.getExtras().get("index");

    }

    public void sendSocket(int index){



    }
}
