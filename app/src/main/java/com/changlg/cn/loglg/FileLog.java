package com.changlg.cn.loglg;

import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;

/**
 * 文件log
 * Created by JustChang on 2016/4/10.
 */
public class FileLog {

    public static void printFile(String tag, File targetDirectory, String fileName
            , String headString, String msg) {
        fileName = fileName == null ? getFileName() : fileName;
        if (save(targetDirectory, fileName, msg))
            Log.d(tag, headString + " save log success ! location is -->" + targetDirectory + File.separator + fileName);
        else
            Log.e(tag, headString + " save log fail !");
    }

    private static boolean save(File dic, String fileName, String msg) {
        File file = new File(dic, fileName);

        try {
            OutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "utf-8");
            outputStreamWriter.write(msg);
            outputStreamWriter.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static String getFileName() {
        Random random = new Random();
        return "Loglg_" + Long.toString(System.currentTimeMillis() + random.nextInt(10000))
                .substring(4) + ".txt";
    }
}
