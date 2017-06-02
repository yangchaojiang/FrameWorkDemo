package com.d.yangc.framework.kotlin.steram

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.d.yangc.framework.R
import kotlinx.android.synthetic.main.activity_file_steam.*
import java.lang.StringBuilder

class FIleSteamActivity : AppCompatActivity() {

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, FIleSteamActivity::class.java)
            context.startActivity(intent)
        }
    }
    var nameString: String = "myFIle"
    var bodyString: String = "hello word!"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_steam)
        btnWrite.setOnClickListener { fileWrite() }
        btnRead.setOnClickListener { fileRead() }
    }


    /***
     * 写入text文件
     * **/
    @Synchronized
    fun fileWrite() {
        val mFileOutputStream = openFileOutput(nameString, Context.MODE_APPEND)
        mFileOutputStream.write(bodyString.toByteArray())
        mFileOutputStream.close()
        Toast.makeText(this,"完成",Toast.LENGTH_LONG).show()

    }

    /***
     * 读取text文件信息
     * **/
    fun fileRead() {
        val mFileInputStream = openFileInput(nameString)
        val bytes = ByteArray(1024)
        val stringBuilder = StringBuilder()
        while (mFileInputStream.read(bytes, 0, bytes.size) != -1) {
            stringBuilder.append(String(bytes))//kotlin 默认编码是utf-8
        }
        mFileInputStream.close()
        textView6.text = stringBuilder
    }
}
