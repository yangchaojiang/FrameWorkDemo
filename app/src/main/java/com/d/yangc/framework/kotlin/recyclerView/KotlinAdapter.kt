package com.d.yangc.framework.kotlin.recyclerView

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


/**
 * Created by yangc on 2017/5/29.
 * E-Mail:yangchaojiang@outlook.com
 * Deprecated:
 */
/**
 * Created by yangc on 2017/5/29.
 * E-Mail:yangchaojiang@outlook.com
 * Deprecated:
 */
class KotlinAdapter(private val context: Context) : RecyclerView.Adapter<KotlinAdapter.MyViewHolder>() {

    private var mList: MutableList<String>? = null

    init {
        if (mList == null) {
            mList = ArrayList<String>()
        }
    }

    public fun addAll(list: ArrayList<String>) {
        mList!!.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder?, position: Int) {
        if (viewHolder != null) {
            viewHolder.tv.text = mList!![position]
        }
    }


    override fun getItemCount(): Int {
        return mList!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, p1: Int): KotlinAdapter.MyViewHolder? {
        val holder = MyViewHolder(LayoutInflater.from(
                context).inflate(android.R.layout.simple_list_item_1, parent,
                false))
        return holder
    }

    inner class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        var tv: TextView

        init {
            tv = itemView!!.findViewById(android.R.id.text1) as TextView
        }

    }
}