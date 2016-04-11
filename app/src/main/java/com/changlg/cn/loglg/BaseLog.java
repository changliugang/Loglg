package com.changlg.cn.loglg;

import android.util.Log;

/**
 * 基本log
 * Created by chang on 2016/4/11.
 */
public class BaseLog {

    public static void printDefault(int type, String tag, String msg) {
        int index = 0;
        int maxLength = 4000;
        int countOfSub = msg.length() / maxLength;

        if (countOfSub > 0) {
            for (int i = 0; i < countOfSub; i++) {
                String sub = msg.substring(index, maxLength);
                printSub(type, tag, sub);
                index += maxLength;
            }
            printSub(type,tag,msg.substring(index,msg.length()));
        }else {
            printSub(type, tag, msg);
        }
    }

    private static void printSub(int type, String tag, String sub) {
        switch (type) {
            case Loglg.V:
                Log.v(tag, sub);
                break;
            case Loglg.D:
                Log.d(tag, sub);
                break;
            case Loglg.I:
                Log.i(tag, sub);
                break;
            case Loglg.W:
                Log.w(tag, sub);
                break;
            case Loglg.E:
                Log.e(tag, sub);
                break;
            case Loglg.A:
                Log.wtf(tag, sub);
                break;
        }
    }

}
