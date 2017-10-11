package com.hpdeveloper.eventbus;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

import com.hpdeveloper.eventbus.di.modules.RxBusModule;

import javax.inject.Inject;

public class MyService extends Service {
    @Inject
    RxBusModule rxBusModule;

    int counter;

    public MyService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MyApplication.getAppComponent().inject(this);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                counter++;
                rxBusModule.send(counter);
                handler.postDelayed(this, 5000);
            }
        }, 5000);
    }
}
