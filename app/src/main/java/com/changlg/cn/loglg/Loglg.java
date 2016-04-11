package com.changlg.cn.loglg;

import android.text.TextUtils;

import java.io.File;

/**
 * 多功能Log
 * Created by chang on 2016/4/7.
 */
public class Loglg {

    public static final String DEFAULT_MESSAGE = "execute";
    // 系统行分隔符（windows下“\n”，UNIX下“/n”）
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
    public static final String NULL_TIPS = "Log with null object";// 空提示
    public static final String PARAM = "Param";
    public static final String NULL = "null";
    public static final String TAG_DEFAULT = "Loglg";// 默认Tag
    public static final String SUFFIX = ".java";// 后缀

    public static final int JSON_INDENT = 4;// Json格式缩进

    // log level
    public static final int V = 0x1;// Verbose 详细信息
    public static final int D = 0x2;// Debug 调试
    public static final int I = 0x3;// Info  通告
    public static final int W = 0x4;// Warn  警告
    public static final int E = 0x5;// Error 错误
    public static final int A = 0x6;// Assert 断言信息（新东西，开发和调试时候用的，一般会用在关键语句判断上，一旦断言不通过，会警告或退出）
    public static final int JSON = 0x7;
    public static final int XML = 0x8;

    private static boolean IS_SHOW_LOG = true;
    private static final int STACK_TRACE_INDEX = 5;// 堆栈跟踪指数

    public static void init(boolean isShowLog) {
        IS_SHOW_LOG = isShowLog;
    }

    private static void printLog(int type, String tagString, Object... objects) {
        if (!IS_SHOW_LOG)
            return;
        String[] contents = wrapContent(tagString, objects);
        String tag = contents[0];
        String msg = contents[1];
        String headString = contents[2];

        switch (type) {
            case V:
            case D:
            case I:
            case W:
            case E:
            case A:
                BaseLog.printDefault(type, tag, headString + msg);
                break;
            case JSON:

                break;
            case XML:

                break;
        }

    }

    private static void printLog(String tagString, File targetDirectory, String fileName, Object objectMsg) {
        if (!IS_SHOW_LOG)
            return;
        String[] contents = wrapContent(tagString, objectMsg);
        String tag = contents[0];
        String msg = contents[1];
        String headString = contents[2];
        FileLog.printFile(tag, targetDirectory, fileName, headString, msg);
    }

    /**
     * 封装log内容
     *
     * @param tagString log标签
     * @param objects   log内容
     * @return 包含log完整内容的字符串数组
     */
    private static String[] wrapContent(String tagString, Object... objects) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[STACK_TRACE_INDEX];

        // 强哥这么写麻烦了吧
//        String className = stackTraceElement.getClassName();
//        String[] classNameInfo = className.split("\\.");
//        if (classNameInfo.length > 0) {
//            className = classNameInfo[classNameInfo.length - 1] + SUFFIX;
//        }

        String className = stackTraceElement.getFileName();
        int lineNumber = stackTraceElement.getLineNumber();
        if (lineNumber < 0)
            lineNumber = 0;
        String methodName = stackTraceElement.getMethodName();
        // 将函数名首字母大写，并将其后内容拼接为完整函数名
        String methodNameNovel = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
        // tag没有指定的话就给个函数名作为tag
        String tag = tagString == null ? methodName : tagString;
        if (TextUtils.isEmpty(tag))
            tag = TAG_DEFAULT;

        String msg = objects == null ? NULL_TIPS : getObjectsString(objects);
        String headString = "[(" + className + ":" + lineNumber + ")#" + methodNameNovel + "]";

        return new String[]{tag, msg, headString};
    }

    /**
     * 获取log内容字符串
     *
     * @param objects log内容对象组
     * @return log内容字符串
     */
    private static String getObjectsString(Object... objects) {
        if (objects.length > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(LINE_SEPARATOR);
            for (int i = 0; i < objects.length; i++) {
                Object object = objects[i];
                if (object == null)
                    sb.append(PARAM).append("[").append(i).append("]").append(NULL)
                            .append(LINE_SEPARATOR);
                else
                    sb.append(PARAM).append("[").append(i).append("]").append(object.toString())
                            .append(LINE_SEPARATOR);
            }
            return sb.toString();
        } else {
            Object object = objects[0];
            return object == null ? NULL : object.toString();
        }
    }

}
