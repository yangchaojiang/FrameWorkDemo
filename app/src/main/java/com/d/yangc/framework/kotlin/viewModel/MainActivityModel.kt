package com.d.yangc.framework.kotlin.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
/**
 * Created by yangc on 2017/5/25.
 * E-Mail:yangchaojiang@outlook.com
 * Deprecated:   数据模型层
 */
class MainActivityModel : ViewModel() {


    var data = MutableLiveData<String>()

    fun setUserName(text: String) {
        data.value = text
    }

    fun getUser(): LiveData<String>{
        return data
    }


    fun rxTest(): Observable<String> {
        val text="asdasdasdddddd2weqweqwebvfbcvbvd"
        return  Observable.just(text).map { s->
            println(s)
            s
        }
    }
}