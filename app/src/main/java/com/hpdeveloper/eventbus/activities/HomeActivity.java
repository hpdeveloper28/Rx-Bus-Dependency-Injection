package com.hpdeveloper.eventbus.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hpdeveloper.eventbus.MyApplication;
import com.hpdeveloper.eventbus.R;
import com.hpdeveloper.eventbus.di.modules.RxBusModule;
import com.hpdeveloper.eventbus.services.MyService;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class HomeActivity extends AppCompatActivity {

    int counter;
    @Inject
    RxBusModule rxBusModule;
    private final CompositeDisposable disposables = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getAppComponent().inject(this);
        setContentView(R.layout.activity_home);

        startService(new Intent(HomeActivity.this, MyService.class));
        startActivity(new Intent(HomeActivity.this, DetailsActivity.class));
//        disposables.add(rxBusModule.toObservable()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Object>() {
//                    @Override
//                    public void accept(Object object) throws Exception {
//
//                    }
//                }));

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                rxBusModule.send("Hiren");
                startActivity(new Intent(HomeActivity.this, DetailsActivity.class));
            }
        });


    }


}
