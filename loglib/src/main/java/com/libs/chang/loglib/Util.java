package com.libs.chang.loglib;

import android.text.TextUtils;
import android.util.Log;

/**
 * 工具类，判断空，打印上下边框
 * Created by chang on 2016/4/11.
 */
public class Util {

    public static boolean isEmpty(String msg){
        return TextUtils.isEmpty(msg) || msg.equals("\n") || msg.equals("\t") || TextUtils.isEmpty(msg.trim());
    }

    public static void printLine(String tag ,boolean isTop){
        if (isTop)
            Log.d(tag, "╔═══════════════════════════════════════════════════════════════════════════════════════");
        else
            Log.d(tag, "╚═══════════════════════════════════════════════════════════════════════════════════════");
    }

}
