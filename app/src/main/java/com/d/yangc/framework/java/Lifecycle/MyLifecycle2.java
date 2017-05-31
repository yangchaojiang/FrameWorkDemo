package com.d.yangc.framework.java.Lifecycle;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModelProvider;
import android.util.Log;

import com.d.yangc.framework.java.viewmodle.MyViewModel;


/**
 * Created by yangc on 2017/5/26.
 * E-Mail:yangchaojiang@outlook.com
 * Deprecated:
 */
public class MyLifecycle2 implements LifecycleObserver {

    private static final String TAG = "MyLifecycle";
    private MyViewModel myViewModel;
    public Activity activity;

    public MyLifecycle2(Activity activity) {
        this.activity = activity;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void create() {
        // connect to system location service
        Log.d(TAG, "create");
        myViewModel = new ViewModelProvider.NewInstanceFactory().create(MyViewModel.class);
        myViewModel.setUserName("我的");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void stop() {
        // disconnect from system location service
        Log.d(TAG, "stop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume() {
        Log.d(TAG, "onResume");


    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {
        Log.d(TAG, "onDestroy");

    }

    public LiveData<String> getData() {
        return myViewModel.getData();
    }
}
