package com.d.yangc.framework.java.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.d.yangc.framework.java.bean.UserBean;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by yangc on 2017/5/25.
 * E-Mail:yangchaojiang@outlook.com
 * Deprecated:
 */
@Dao
public interface MYDao {

    @Query("select *from UserBean  where  id=:id")
    Flowable<UserBean> loadUserByidSync(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(UserBean... users);//只能在子线程运行

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(UserBean users);//只能在子线程运行

    @Delete
    int delete(UserBean... user);//只能在子线程运行

    @Update
    int update(UserBean... user);//只能在子线程运行

    @Query("SELECT *FROM UserBean")
//只能在子线程运行
    List<UserBean> getUsrAll();

    @Query("SELECT *FROM UserBean")
    LiveData<List<UserBean>> getUsrAllSync();

    @Query("SELECT *FROM UserBean where id=:id")
    LiveData<UserBean> getSingle(Integer id);
}
