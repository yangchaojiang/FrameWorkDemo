package com.d.yangc.framework.kotlin.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.d.yangc.framework.java.app.MyDatabase
import com.d.yangc.framework.java.bean.UserBean
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

/**
 * Created by yangc on 2017/5/30.
 * E-Mail:yangchaojiang@outlook.com
 * Deprecated: 数据模型
 */
class DataViewModel : ViewModel() {
    /****
     * 插入
     * **/
    fun install(): Flowable<Boolean> {
        val user = UserBean()
        user.data = Date()
        user.seuName = "阳江"
        user.userId = 10
        return Flowable.just(user)
                .map({ bean ->
                    MyDatabase.getDatabase().userDao.insert(bean)
                    true
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

    }

    /***
     * 查询
     * ***/
    fun getAllSync(): LiveData<List<UserBean>> {
        return MyDatabase.getDatabase().userDao.usrAllSync
    }

    /***
     * 删除数据
     * ***/
    fun del(bean: UserBean): Flowable<Int> {
        return Flowable.just(bean).map({
            bean ->
            MyDatabase.getDatabase().userDao.delete(bean)
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}