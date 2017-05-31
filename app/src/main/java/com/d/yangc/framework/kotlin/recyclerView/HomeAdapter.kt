package com.d.yangc.framework.kotlin.recyclerView

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.d.yangc.framework.R

import java.util.ArrayList

/**
 * Created by yangc on 2017/5/29.
 * E-Mail:yangchaojiang@outlook.com
 * Deprecated:
 */
internal class HomeAdapter(private val context: Context) : RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {
    private var mDatas: MutableList<String>? = null

    init {
        if (mDatas == null) {
            mDatas = ArrayList<String>()
        }
    }

    fun addAll(list: List<String>) {
        mDatas!!.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val holder = MyViewHolder(LayoutInflater.from(
                context).inflate(android.R.layout.simple_list_item_1, parent,
                false))
        return holder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tv.text = mDatas!![position]
    }

    override fun getItemCount(): Int {
        return mDatas!!.size
    }

    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var tv: TextView

        init {
            tv = view.findViewById(android.R.id.text1) as TextView
        }
    }
}
