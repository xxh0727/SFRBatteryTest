package com.tinno.sfrbatterytest.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by Lando on 2016/4/12.
 */
public class TestingService extends Service {

    public class LocalBinder{
        public TestingService getService(){
            return TestingService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
