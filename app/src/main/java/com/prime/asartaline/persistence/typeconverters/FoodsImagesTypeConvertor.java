package com.prime.asartaline.persistence.typeconverters;

import android.arch.persistence.room.TypeConverter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yepyaesonetun on 7/7/18.
 **/

public class FoodsImagesTypeConvertor {
    @TypeConverter
    public static List<String> toStringList(String imagesCommaSeparated) {
        String[] imagesArray = imagesCommaSeparated.split(",");
        return Arrays.asList(imagesArray);
    }

    @TypeConverter
    public static String toString(List<String> imageList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String image : imageList) {
            stringBuilder.append(image).append(",");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}
