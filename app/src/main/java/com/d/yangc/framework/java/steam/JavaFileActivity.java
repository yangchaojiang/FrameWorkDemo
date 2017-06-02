package com.d.yangc.framework.java.steam;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.d.yangc.framework.R;

import org.w3c.dom.Text;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class JavaFileActivity extends AppCompatActivity {

    String fileName = "myfile";
    String bodyString = "hello word !";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_steam);
        textView = (TextView) findViewById(R.id.textView6);
        findViewById(R.id.btnWrite).setOnClickListener(v -> {
            fileWrite();
        });
        findViewById(R.id.btnRead).setOnClickListener(v -> {
            fileRead();
        });

    }


    /****
     * 写入text文件
     * ***/
    void fileWrite() {
        try {
            FileOutputStream fileOutputStream = openFileOutput(fileName, Context.MODE_APPEND);
            fileOutputStream.write(bodyString.getBytes());
            fileOutputStream.close();
            fileOutputStream.flush();
            Toast.makeText(this, "完成", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /****
     * 写入text文件
     * ***/
    void fileDataWrite() {
        try {
            FileInputStream fileInputStream = new FileInputStream("asd");
            FileOutputStream fileOutputStream = openFileOutput(fileName, Context.MODE_APPEND);
            byte[] bytes = new byte[1024];
            fileOutputStream.write(bodyString.getBytes());
            int byteread = 0;
            while ((byteread = fileInputStream.read(bytes, 0, bytes.length)) != -1) {
                fileOutputStream.write(bytes, byteread, bytes.length);
            }
            fileOutputStream.close();
            fileOutputStream.flush();
            fileInputStream.close();
            Toast.makeText(this, "完成", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取text文件
     **/
    void fileRead() {
        try {
            FileInputStream fileOutputStream = openFileInput(fileName);
            byte[] bytes = new byte[1024];
            StringBuilder stringBuilder = new StringBuilder();
            while (fileOutputStream.read(bytes) != -1) {
                stringBuilder.append(new String(bytes, "utf-8"));
            }
            fileOutputStream.close();
            textView.setText(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
