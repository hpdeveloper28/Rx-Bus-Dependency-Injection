package com.hpdeveloper.eventbus.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

import com.hpdeveloper.eventbus.MyApplication;
import com.hpdeveloper.eventbus.di.modules.RxBusModule;
import com.hpdeveloper.eventbus.entities.UserEntity;

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
                UserEntity userEntity =  new UserEntity(counter, "Hiren");
                rxBusModule.send(userEntity);
                handler.postDelayed(this, 5000);
            }
        }, 5000);
    }
}
