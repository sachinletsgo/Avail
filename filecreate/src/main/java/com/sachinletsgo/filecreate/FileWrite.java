package com.sachinletsgo.filecreate;

import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by SachinTyagi on 5/26/17.
 */

public class FileWrite {


    //All final attributes
    private final String filePath; // required
    private final String appVersion; // required
    private final int maxFileSize; // optional
    private final String deviceName; // optional
    private final String dateFormat; // optional
    private final boolean isFileRecycled; // optional
    private final boolean isMailRequired; // optional

    private FileWrite(FileBuilder builder) {
        this.filePath = builder.filePath;
        this.appVersion = builder.appVersion;
        this.maxFileSize = builder.maxFileSize;
        this.deviceName = builder.deviceName;
        this.dateFormat = builder.dateFormat;
        this.isFileRecycled = builder.isFileRecycled;
        this.isMailRequired = builder.isMailRequired;

    }

//    //All getter, and NO setter to provde immutability
//
    public boolean isFileRecycled() {
        return isFileRecycled;
    }

    public boolean isMailRequired() {
        return isMailRequired;
    }

    public String getFilePath() {
        return filePath;
    }
    public String getAppVersion() {
        return appVersion;
    }
    public int getMaxFileSize() {
        return maxFileSize;
    }
    public String getDeviceName() {
        return deviceName;
    }
    public String getDateFormat() {
        return dateFormat;
    }

    @Override
    public String toString() {
        return "User: "+this.filePath +", "+this.appVersion +", "+this.maxFileSize +", "+this.deviceName +", "+this.dateFormat +
                this.isFileRecycled+ " ,"+ this.isMailRequired;
    }


    public static class FileBuilder
    {
        private final String filePath;
        private final String appVersion;
        private int maxFileSize;
        private String deviceName;
        private String dateFormat;
        private boolean isFileRecycled;
        private boolean isMailRequired;

        public FileBuilder(String filePath, String appVersion) {
            this.filePath = filePath;
            this.appVersion = appVersion;
        }
        public FileBuilder fileSize(int maxFileSize) {
            this.maxFileSize = maxFileSize;
            return this;
        }
        public FileBuilder deviceName(String deviceName) {
            this.deviceName = deviceName;
            return this;
        }
        public FileBuilder dateFormat(String dateFormat) {
            this.dateFormat = dateFormat;
            return this;
        }
        public FileBuilder fileRecycled(boolean isFileRecycled) {
            this.isFileRecycled = isFileRecycled;
            return this;
        }
        public FileBuilder mailRequired(boolean isMailRequired) {
            this.isMailRequired = isMailRequired;
            return this;
        }
        //Return the finally consrcuted User object
        public FileWrite build() {
            FileWrite user =  new FileWrite(this);
            validateUserObject(user);
            return user;
        }
        private void validateUserObject(FileWrite user) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }




}
