package com.example.imageeditingexpress.model;

import lombok.Data;

import java.io.File;
import java.text.DecimalFormat;
@Data
public class FileSize {

    private double fileSizeBytes;

    public static double getFileSizeMB(File file){
        long fileSizeBytes = file.length();

        double fileSizeMB =  (double) fileSizeBytes / (1024.0 * 1024.0);
        return getRoundedValue(fileSizeMB, 2);
    }
    public int getFileSizeMB(){
        return (int) (fileSizeBytes / (1024 * 1024));
    }

    private static double getRoundedValue(double number, int charAfter0){
        String pattern = "#.";
        for (int i = 0; i < charAfter0; i++) {
            pattern += "#";
        }
        DecimalFormat df = new DecimalFormat(pattern);
        return Double.parseDouble(df.format(number));
    }
}
