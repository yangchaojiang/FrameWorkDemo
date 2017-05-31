package com.d.yangc.framework.kotlin

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.d.yangc.framework.R
import com.d.yangc.framework.kotlin.data.Main7Activity
import com.d.yangc.framework.kotlin.recyclerView.Main6Activity
import com.d.yangc.framework.kotlin.viewModel.MainActivityModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : LifecycleActivity() {

    private var model: MainActivityModel? = null

    companion object{
   val TAG="MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        model = ViewModelProviders.of(this).get(MainActivityModel::class.java)
        button5.setOnClickListener {
            Main7Activity.startActivity(this)
        }
        button.setOnClickListener({
            model!!.setUserName("asdasdasd")
            var int: Intent = Intent(this, Main6Activity::class.java)
            startActivity(int)
        })
        model!!.getUser().observe(this,Observer<String>{
            s->
            println(s)
            textView.text=s
        })
        model!!.rxTest().subscribe {
            s->
            Log.d(TAG,s)
        }

    }


}




