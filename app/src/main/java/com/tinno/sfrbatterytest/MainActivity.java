package com.tinno.sfrbatterytest;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import com.tinno.sfrbatterytest.service.TestingService;

public class MainActivity extends Activity {
    private TestingService testingService = null;
    private Context context;
    protected boolean isBonud = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startService(View view){
        Intent intent = new Intent(MainActivity.this, TestingService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
        isBonud = true;
    }

    public void stopService(View view){
        if(isBonud){
            unbindService(connection);
        }

    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            testingService = ((TestingService.LocalBinder)service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

            testingService = null;
        }
    };
}
