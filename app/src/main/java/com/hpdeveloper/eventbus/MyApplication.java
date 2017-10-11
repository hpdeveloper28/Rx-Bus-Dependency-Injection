package com.hpdeveloper.eventbus;

import android.app.Application;

import com.hpdeveloper.eventbus.di.components.AppComponent;
import com.hpdeveloper.eventbus.di.components.DaggerAppComponent;
import com.hpdeveloper.eventbus.di.modules.RxBusModule;


/**
 * Created by hirenpatel on 11/10/17.
 */

public class MyApplication extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .rxBusModule(new RxBusModule())
                .build();
    }
    public static AppComponent getAppComponent() {
        return appComponent;
    }


}
