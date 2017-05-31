package com.d.yangc.framework.java;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.d.yangc.framework.R;
import com.d.yangc.framework.java.viewmodle.MyViewModel;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

/**
 * Created by yangc on 2017/5/25.
 * E-Mail:yangchaojiang@outlook.com
 * Deprecated:
 */
public class MainActivity extends LifecycleActivity {
    public static void sta(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
    }

    private String TAG = "MainActivity";
    private MyViewModel viewModle;
    TextView textView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModle = ViewModelProviders.of(this).get(MyViewModel.class);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        findViewById(R.id.button2).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Main4Activity.class);
            startActivity(intent);
        });
        findViewById(R.id.button).setOnClickListener(v -> {
            viewModle.setUserName("dasda");
            viewModle.saveUser().subscribe(aBoolean -> {
                Log.d(TAG, "" + aBoolean);
            });

        });
        viewModle.getData().observe(this, s ->
                textView.setText(s)
        );
    }

}
