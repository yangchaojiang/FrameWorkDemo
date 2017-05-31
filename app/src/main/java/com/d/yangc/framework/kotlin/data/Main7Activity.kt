package com.d.yangc.framework.kotlin.data

import android.arch.lifecycle.LifecycleActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.d.yangc.framework.R
import com.d.yangc.framework.java.bean.UserBean
import com.d.yangc.framework.kotlin.lifecycler.DataBeanLifecycle
import com.d.yangc.framework.kotlin.recyclerView.UserAdapter
import kotlinx.android.synthetic.main.activity_main7.*

/****
 * 数据添加类
 * ******/
class Main7Activity : LifecycleActivity() {
    private var adapter: UserAdapter? = null
    private val mDataBeanLifecycle: DataBeanLifecycle = DataBeanLifecycle(this)

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, Main7Activity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)
        adapter = UserAdapter(this)
        lifecycle.addObserver(mDataBeanLifecycle)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        button3.setOnClickListener {
            mDataBeanLifecycle.add()
        }
        button4.setOnClickListener {
            mDataBeanLifecycle.del(adapter!!.getItem(adapter!!.itemCount - 1))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(mDataBeanLifecycle)
    }

    /***
     * 将数据展示到view上
     * ***/
    fun setData(list: List<UserBean>) {
        adapter!!.clear()
        adapter!!.addAll(list)
    }

}
