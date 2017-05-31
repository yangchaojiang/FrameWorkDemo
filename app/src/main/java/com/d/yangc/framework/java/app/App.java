package com.d.yangc.framework.java.app;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.persistence.room.Room;

/**
 * Created by yangc on 2017/5/25.
 * E-Mail:yangchaojiang@outlook.com
 * Deprecated:
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MyDatabase.initData(Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "userName").build());
    }
}
