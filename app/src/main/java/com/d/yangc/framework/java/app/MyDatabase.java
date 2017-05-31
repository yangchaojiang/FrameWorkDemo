package com.d.yangc.framework.java.app;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.d.yangc.framework.java.dao.MYDao;
import com.d.yangc.framework.java.bean.UserBean;

/**
 * Created by yangc on 2017/5/25.
 * E-Mail:yangchaojiang@outlook.com
 * Deprecated:
 */
@Database(entities = {UserBean.class}, version = 2)
public abstract class MyDatabase extends RoomDatabase {
    public abstract MYDao getUserDao();

   // public abstract UserKotlinDao getUserKotlinDao();

    private static MyDatabase INSTANCE;


    public static MyDatabase getDatabase() {

        return INSTANCE;
    }

    public static void initData(MyDatabase database) {
        INSTANCE = database;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
