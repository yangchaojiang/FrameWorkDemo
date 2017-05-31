package com.d.yangc.framework.java;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.d.yangc.framework.R;
import com.d.yangc.framework.java.Lifecycle.MyLifecycle;
import com.d.yangc.framework.java.Lifecycle.MyLifecycle2;

/*****
 *
 *
 * 自定义 实现 LifecycleOwner demo
 * ****/
public class Main3Activity extends AppCompatActivity implements LifecycleRegistryOwner {
    LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
    MyLifecycle2 myLifecycle;
    TextView textView;

    public Main3Activity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myLifecycle = new MyLifecycle2(this);
        setContentView(R.layout.activity_main3);
        getLifecycle().addObserver(myLifecycle);
        textView = (TextView) findViewById(R.id.textView2);

    }

    public void get() {
        myLifecycle.getData().observe(this, s -> textView.setText(s));
    }

    @Override
    protected void onStart() {
        super.onStart();
        get();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
