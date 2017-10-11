package com.hpdeveloper.eventbus.di.components;

import com.hpdeveloper.eventbus.activities.DetailsActivity;
import com.hpdeveloper.eventbus.activities.HomeActivity;
import com.hpdeveloper.eventbus.services.MyService;
import com.hpdeveloper.eventbus.di.modules.RxBusModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by hirenpatel on 10/10/17.
 */
@Singleton
@Component(modules = RxBusModule.class)
public interface AppComponent {
    void inject(HomeActivity homeActivity);
    void inject(DetailsActivity detailsActivity);
    void inject(MyService myService);
}
