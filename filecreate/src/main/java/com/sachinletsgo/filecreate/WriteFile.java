package com.sachinletsgo.filecreate;

import android.content.Context;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by SachinTyagi on 5/25/17.
 */

public  class WriteFile {

    static String filePath;
    static String appVersion;
    static String deviceName;
    static Context context;

    private static WriteFile instance = null;
    private WriteFile() {
        // Exists only to defeat instantiation.
    }

    public static WriteFile getInstance() {
        if(instance == null) {
            instance = new WriteFile();
        }
        return instance;
    }

    public static void init(String path, Context contextRecived, String appVersionR, String deviceNameR) {
        filePath = path;
        context = contextRecived;
        appVersion = appVersionR;
        deviceName = deviceNameR;

    }


    public static void appendLog(String text, Boolean isTimeFlag) {

        String time = android.text.format.DateFormat.format("yyyy-MM-dd hh:mm:ss", new java.util.Date()).toString();
        int r = (new Random()).nextInt(10) + 1;
        String versionName = "";
        try {
            versionName = appVersion;
        } catch (Exception e) {

        }
        if (r % 3 == 0 && isTimeFlag)
            text = "\n" + deviceName + " " +
                    versionName + " " + time + "\n" + text;
        else if (!isTimeFlag)
            text = android.text.format.DateFormat.format("yyyy-MM-dd hh:mm:ss", new java.util.Date()).toString() + " " + text;
        else
            text = "\n" + android.text.format.DateFormat.format("yyyy-MM-dd hh:mm:ss", new java.util.Date()).toString() + "\n" + text;
        File logFile;
        int maxFileSize = 5242880;//5242880= 1024 * 1024 * 5;


        File newDir = new File(filePath);
        //////////// check if directory is avilable or not
        if (!newDir.exists()) {
            try {
                newDir.mkdirs();
            } catch (Exception e) {
                Log.e("Log File ", " " + e.getMessage());

                return;
            }
        } else {
            if (!newDir.canWrite()) {
                Log.e("Log File ", "No permission");

                return;
            }
        }

        String[] dlist = newDir.list();

        if (dlist != null && dlist.length > 0) {
            ///////// create multiple file start
            logFile = getLatestFilefromDir(filePath);
            if (logFile != null && logFile.length() > maxFileSize) {
                int newChange = 0;
                String newFile = logFile.getName();
                newFile = newFile.substring(newFile.lastIndexOf("/") + 1, newFile.lastIndexOf("."));
                if (!newFile.equals("log"))
                    newChange = Integer.parseInt(newFile);
                if (newChange >= 5) {
                    File tempLogFile = new File(filePath+"/1.file");
                    if (tempLogFile.exists())
                        tempLogFile.delete();
                    logFile = new File(filePath+"/1.file");
                } else {
                    newChange++;
                    logFile = new File(filePath + newChange + ".file");
                }
            }
            //////// create multiple file end

        } else {
            logFile = new File(filePath+"/1.file");
            if (!logFile.exists()) {
                try {
                    logFile.createNewFile();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    Log.e("Log File ", e.getMessage());
                    e.printStackTrace();
                }
            }

        }

        try {
            //BufferedWriter for performance, true to set append to file flag
            assert logFile != null;
            BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true));
            buf.append(text);
            buf.newLine();
            buf.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static File getLatestFilefromDir(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }





    /////////


    //////////



}
