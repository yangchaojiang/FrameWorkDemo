package com.d.yangc.framework.java;

import android.arch.lifecycle.LifecycleActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.d.yangc.framework.R;
import com.d.yangc.framework.java.Lifecycle.MyLifecycle;

/***
 * 集成默认LifecycleActivity
 * *****/
public class TestLifecycleActivity extends LifecycleActivity {
    MyLifecycle  myLifecycle;
    TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myLifecycle=new MyLifecycle(this);
        setContentView(R.layout.activity_main4);
        textView3= (TextView) findViewById(R.id.textView3);
        getLifecycle().addObserver(myLifecycle);


    }

    @Override
    protected void onStart() {
        super.onStart();
        myLifecycle.getData().observe(this,text->{textView3.setText(text);});
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
      getLifecycle().removeObserver(myLifecycle);
    }
}
