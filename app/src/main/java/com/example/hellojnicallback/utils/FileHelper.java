package com.example.hellojnicallback.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Log;

import java.io.InputStream;

/**
 * Created by Android Studio.
 * User: liheng
 * Date: 2021/8/28
 * Time: 9:56
 */
public class FileHelper {
    public static final String TAG = "--FileUtils--";
    public static byte[] readFileFromAssets(Context context, String groupPath, String filename) {
        byte[] buffer = null;
        AssetManager am = context.getAssets();
        try {
            InputStream inputStream = null;
            if (!TextUtils.isEmpty(groupPath)) {
                inputStream = am.open(groupPath + "/" + filename);
            } else {
                inputStream = am.open(filename);
            }

            int length = inputStream.available();
            Log.d(TAG, "readFileFromAssets length:" + length);
            buffer = new byte[length];
            inputStream.read(buffer);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return buffer;
    }

}
