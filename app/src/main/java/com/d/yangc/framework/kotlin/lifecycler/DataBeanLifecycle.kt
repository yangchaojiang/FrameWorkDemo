package com.d.yangc.framework.kotlin.lifecycler

import android.app.Activity
import android.arch.lifecycle.*
import android.util.Log
import android.widget.Toast
import com.d.yangc.framework.java.bean.UserBean
import com.d.yangc.framework.kotlin.data.Main7Activity
import com.d.yangc.framework.kotlin.viewModel.DataViewModel

/**
 * Created by yangc on 2017/5/31.
 * E-Mail:yangchaojiang@outlook.com
 * Deprecated:
 */
/**
 * Created by yangc on 2017/5/31.
 * E-Mail:yangchaojiang@outlook.com
 * Deprecated:
 */
class DataBeanLifecycle(activity: Main7Activity) : LifecycleObserver {

    companion object {
        var TAG = "DataBeanLifecycle"
    }

    val mActivity = activity
    var mDataViewModel: DataViewModel? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun create() {
        mDataViewModel = ViewModelProviders.DefaultFactory(mActivity.application).create(DataViewModel::class.java)
        get()

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resume() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy() {

    }


    /***
     * 添加数据
     *
     */
    fun add() {
        mDataViewModel!!.install().subscribe {
            b ->
            Toast.makeText(mActivity, "添加" + b, Toast.LENGTH_LONG).show()
        }

    }

    /**
     * 查询数据
     * **/
    fun get() {
        mDataViewModel!!.getAllSync().observe(mActivity, Observer<List<UserBean>> {
            list ->
            if (list != null) {
                mActivity.setData(list)
            }
        })
    }

    /**
     * 删除数据
     * **/
    fun del(bean :UserBean) {
        mDataViewModel!!.del(bean).subscribe {
            count->
            Log.d(TAG,"delCount:"+count)
        }
    }
}