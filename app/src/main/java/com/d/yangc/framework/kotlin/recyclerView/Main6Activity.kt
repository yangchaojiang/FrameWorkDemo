package com.d.yangc.framework.kotlin.recyclerView

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.d.yangc.framework.R
import kotlinx.android.synthetic.main.activity_main6.*

class Main6Activity : AppCompatActivity()  {

    val mDefaultItemAnimator :DefaultItemAnimator=DefaultItemAnimator()

    var myAdapter: KotlinAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
        myAdapter = KotlinAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        myAdapter!!.addAll(getData())
        recyclerView.adapter = myAdapter
        recyclerView.itemAnimator =mDefaultItemAnimator
        recyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
    }


    fun getData(): ArrayList<String> {
        var list: ArrayList<String> = ArrayList<String>()
        for (i in 0..99) {
            list.add(i, "我的的$i")
        }
        return list;
    }
}
