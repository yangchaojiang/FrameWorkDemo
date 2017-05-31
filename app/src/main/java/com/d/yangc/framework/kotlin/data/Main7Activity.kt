package com.d.yangc.framework.kotlin.data

import android.app.Dialog
import android.arch.lifecycle.LifecycleActivity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.d.yangc.framework.R
import com.d.yangc.framework.java.bean.UserBean
import com.d.yangc.framework.kotlin.lifecycler.DataBeanLifecycle
import com.d.yangc.framework.kotlin.recyclerView.UserAdapter
import kotlinx.android.synthetic.main.activity_main7.*
import kotlinx.android.synthetic.main.dialog_eidt_view.*

/****
 * 数据添加类
 * ******/
class Main7Activity : LifecycleActivity() {
    private var adapter: UserAdapter? = null
    private val mDataBeanLifecycle: DataBeanLifecycle = DataBeanLifecycle(this)
    private val mLinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

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
        recyclerView.layoutManager = mLinearLayoutManager
        recyclerView.adapter = adapter
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        button3.setOnClickListener {
            mDataBeanLifecycle.add()
        }
        button4.setOnClickListener {
            mDataBeanLifecycle.del(adapter!!.getItem(adapter!!.itemCount - 1))
        }
        adapter!!.setmOnItemClickLitener(object : UserAdapter.OnItemClickLitener {
            override fun onItemClick(view: View, position: Int) {
                editDialog(adapter!!.getItem(position))
            }

            override fun onItemLongClick(view: View, position: Int) {

            }
        })
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

    /***
     * 显示编辑框
     * **/
    fun editDialog(bean: UserBean) {
        val editDialog = Dialog(this)
        editDialog.setContentView(R.layout.dialog_eidt_view)
        editDialog.button8.setOnClickListener {
            editDialog.dismiss()
        }
        editDialog.button7.setOnClickListener {
            if (editDialog.editText.text.toString().trim().isEmpty()) {
          Toast.makeText(this,"输入名称",Toast.LENGTH_LONG).show()
            }
            bean.seuName = editDialog.editText.text.toString().trim()
            mDataBeanLifecycle.update(bean)
            editDialog.dismiss()
        }
        editDialog.show()
    }
}
