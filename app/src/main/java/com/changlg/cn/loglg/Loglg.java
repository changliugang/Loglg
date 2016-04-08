package com.changlg.cn.loglg;

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

    private static void printLog(){

    }

    /**
     * 封装log内容
     * @param tagString log标签
     * @param objects
     * @return
     */
    private static String[] wrapContent(String tagString,Object... objects){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[STACK_TRACE_INDEX];
        String className = stackTraceElement.getFileName();
        // 强哥这么写麻烦了吧
//        String className = stackTraceElement.getClassName();
//        String[] classNameInfo = className.split("\\.");
//        if (classNameInfo.length > 0) {
//            className = classNameInfo[classNameInfo.length - 1] + SUFFIX;
//        }

        return null;
    }

}
