package com.changlg.cn.loglg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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


    }
}
