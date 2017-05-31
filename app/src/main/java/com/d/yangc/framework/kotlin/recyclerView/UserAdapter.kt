package com.d.yangc.framework.kotlin.recyclerView

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.d.yangc.framework.R
import com.d.yangc.framework.java.Lifecycle.Tes
import com.d.yangc.framework.java.bean.UserBean

/**
 * Created by yangc on 2017/5/30.
 * E-Mail:yangchaojiang@outlook.com
 * Deprecated:
 */
/**
 * Created by yangc on 2017/5/30.
 * E-Mail:yangchaojiang@outlook.com
 * Deprecated:
 */
class UserAdapter(private val context: Context) : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    private var mData: MutableList<UserBean> = ArrayList()
    fun addAll(list: List<UserBean>) {
        mData.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {

        return mData.size
    }

    override fun getItemId(position: Int): Long {
        return mData[position].id.toLong()
    }

    fun getItem(position: Int): UserBean {

        return mData[position]
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        p0.setData(mData[p1])
        p0.itemView.setOnClickListener {mOnItemClickLitener!!.onItemClick( p0.itemView,p1) }
        p0.itemView.setOnLongClickListener { mOnItemClickLitener!!.onItemLongClick( p0.itemView,p1)
        false
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_user_view, p0, false))
    }


    class MyViewHolder(item: View) : ViewHolder(item) {
        var textName: TextView? = null
        var textName2: TextView? = null

        init {
            textName = item.findViewById(R.id.textView4) as TextView
            textName2 = item.findViewById(R.id.textView5) as TextView
        }

        fun setData(bean: UserBean) {
            textName!!.text = bean.id.toString()
            textName2!!.text = bean.seuName

        }

    }

    fun clear() {
        mData.clear()
        notifyDataSetChanged()
    }
    private var mOnItemClickLitener : OnItemClickLitener? = null


    fun setmOnItemClickLitener(mOnItemClickLitener: OnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener
    }
    interface OnItemClickLitener {

        fun onItemClick(view: View, position: Int)
        fun onItemLongClick(view: View, position: Int)
    }

}