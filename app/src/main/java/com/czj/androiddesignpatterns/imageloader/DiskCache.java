package com.czj.androiddesignpatterns.imageloader;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import com.czj.androiddesignpatterns.utils.Md5Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 磁盘缓存
 */
public class DiskCache implements ImageCache {
    private static final String LOCAL_CACHE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/cache/";

    public DiskCache() {
    }

    /**
     * 从缓存中获取图片
     *
     * @param url 图片地址
     * @return
     */
    @Override
    public Bitmap get(String url) {
        return BitmapFactory.decodeFile(LOCAL_CACHE_PATH + Md5Utils.getMD5Code(url)+".png");
    }

    /**
     * 将图片缓存到磁盘中去
     *
     * @param url
     * @param bitmap
     */
    @Override
    public void put(String url, Bitmap bitmap) {
        File dir = new File(LOCAL_CACHE_PATH);
        if (!dir.exists() || !dir.isDirectory()) {
            dir.mkdirs();  // 创建文件夹
        }
        File file = new File(LOCAL_CACHE_PATH + Md5Utils.getMD5Code(url)+".png");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
