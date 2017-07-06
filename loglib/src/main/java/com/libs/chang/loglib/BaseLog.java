package com.libs.chang.loglib;

import android.util.Log;

/**
 * 日志输出基本功能
 * Created by chang on 2016/4/11.
 */
public class BaseLog {

    /**
     * Android的日志条目的最大限制是4076字节。这个你可以用$ adb logcat -g命令行查看。
     * 所以这里取4000作为跨度
     */
    private static final int SPAN_SIZE = 4000;

    /**
     * 这里会判断日志的长度以确定用哪种方式输出
     *
     * @param logLevel 日志等级
     * @param tag      日志tag
     * @param msg      日志内容
     */
    public static void printLogDependingOnSpan(int logLevel, String tag, String msg) {

        int index = 0;
        int length = msg.length();
        int count = length / SPAN_SIZE;

        if (count > 0) {
            for (int i = 0; i < count; i++) {
                String sub =  msg.substring(index, index + SPAN_SIZE);
                printLog(logLevel, tag, sub);
                index += SPAN_SIZE;
            }
            Log.d("chang", msg.substring(2999,4000));
            printLog(logLevel, tag, msg.substring(index, length));
        } else {
            printLog(logLevel, tag, msg);
        }

    }

    /**
     * 调用系统函数打印日志
     *
     * @param logLevel 日志等级
     * @param tag      日志tag
     * @param msg      日志内容
     */
    private static void printLog(int logLevel, String tag, String msg) {
        switch (logLevel) {
            case Loglg.V:
                Log.v(tag, msg);
                break;
            case Loglg.D:
                Log.d(tag, msg);
                break;
            case Loglg.I:
                Log.i(tag, msg);
                break;
            case Loglg.W:
                Log.w(tag, msg);
                break;
            case Loglg.E:
                Log.e(tag, msg);
                break;
            case Loglg.A:
                Log.wtf(tag, msg);
                break;
        }
    }

}
