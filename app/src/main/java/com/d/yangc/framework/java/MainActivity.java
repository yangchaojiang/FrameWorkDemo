package com.d.yangc.framework.java;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.d.yangc.framework.R;
import com.d.yangc.framework.java.steam.JavaFileActivity;
import com.d.yangc.framework.java.viewmodle.MyViewModel;

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
    private MyViewModel viewModel;
    TextView textView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        findViewById(R.id.button2).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TestLifecycleActivity.class);
            startActivity(intent);
        });
        findViewById(R.id.button).setOnClickListener(v -> {
            viewModel.setUserName("dasda");
            viewModel.saveUser().subscribe(aBoolean -> {
                Log.d(TAG, "" + aBoolean);
            });

        });
        viewModel.getData().observe(this, s ->
                textView.setText(s)
        );
        findViewById(R.id.btnFile).setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, JavaFileActivity.class);
            startActivity(intent);
        });
    }

}
