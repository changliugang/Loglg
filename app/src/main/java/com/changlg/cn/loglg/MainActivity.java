package com.changlg.cn.loglg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        for (int i = 0; i < stackTrace.length; i++) {
            // 堆栈中的信息
            System.out.println(stackTrace[i].getClassName() + ";" + stackTrace[i].getMethodName() + ";" + stackTrace[i].getFileName());
        }
        String methodName = stackTrace[5].getMethodName();
        // 将函数名首字母大写，并将其后内容拼接为完整函数名
        String methodNameShort = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
        Log.d("tag",methodName+"\n"+methodNameShort);
    }
}
