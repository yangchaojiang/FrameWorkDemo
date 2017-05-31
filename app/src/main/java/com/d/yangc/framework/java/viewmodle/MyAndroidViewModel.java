package com.d.yangc.framework.java.viewmodle;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.widget.Toast;

import com.d.yangc.framework.java.app.MyDatabase;
import com.d.yangc.framework.java.bean.UserBean;

import java.util.Date;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yangc on 2017/5/25.
 * E-Mail:yangchaojiang@outlook.com
 * Deprecated: view 模型
 */
public class MyAndroidViewModel extends AndroidViewModel {
    private final MutableLiveData<String> data = new MutableLiveData<>();

    public MyAndroidViewModel(Application application) {
        super(application);
        Toast.makeText(application, "asdasd", Toast.LENGTH_LONG).show();
    }

    public void setUserName(String userName) {
        data.setValue(userName);
    }

    public LiveData<String> getData() {
        return data;
    }


    public Observable<Boolean> saveUser() {
        UserBean userBean = new UserBean();
        userBean.setData(new Date());
        userBean.setUserId(123123);
        userBean.setSeuName("test");
        return Observable.just(userBean).map(userBean1 -> {
            MyDatabase.getDatabase().getUserDao().insertAll(userBean1);
            return true;
        }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());

    }


}
