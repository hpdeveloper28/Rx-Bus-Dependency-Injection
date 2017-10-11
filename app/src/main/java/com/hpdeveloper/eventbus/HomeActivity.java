package com.hpdeveloper.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hpdeveloper.eventbus.di.modules.RxBusModule;

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

//
//        final Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                counter++;
//                rxBusModule.send(counter);
//                handler.postDelayed(this, 5000);
//            }
//        }, 2000);

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
