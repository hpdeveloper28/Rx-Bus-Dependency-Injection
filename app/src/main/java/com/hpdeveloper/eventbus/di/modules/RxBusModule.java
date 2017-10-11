package com.hpdeveloper.eventbus.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by hirenpatel on 11/10/17.
 */
@Module
public class RxBusModule {

    @Provides
    @Singleton
    RxBusModule getModule(){
        return this;
    }

    private BehaviorSubject<Object> bus = BehaviorSubject.create();

    @Provides
    @Singleton
    BehaviorSubject<Object> getBus(){
        return bus;
    }

    public void send(Object o) {
        getBus().onNext(o);
    }

    @Provides
    @Singleton
    public Observable<Object> toObservable() {
        return getBus();
    }

}
