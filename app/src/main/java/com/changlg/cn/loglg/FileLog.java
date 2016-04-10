package com.changlg.cn.loglg;

import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Random;

/**
 * Created by JustChang on 2016/4/10.
 */
public class FileLog {


    private static boolean save(File dic,String fileName ,String msg){
        File file = new File(dic,fileName);

        try {
            OutputStream outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    private static String getFileName(){
        Random random = new Random();
        return "Loglg_"+ Long.toString(System.currentTimeMillis()+random.nextInt(10000))
                .substring(4)+".txt";
    }
}
