package com.czj.androiddesignpatterns.imageloader;


import android.graphics.Bitmap;

/**
 * 双缓存
 * 获取图片缓存先从内存中读取，内存中没有就从磁盘中读取
 */
public class DoubleCache implements ImageCache {

    private MemoryCache memoryCache = new MemoryCache();
    private DiskCache diskCache = new DiskCache();


    @Override
    public Bitmap get(String url){
        Bitmap bitmap = memoryCache.get(url);
        if (bitmap == null){
            bitmap = diskCache.get(url);
        }
        return bitmap;
    }

    //图片缓存到内存和磁盘中去
    @Override
    public void put(String url,Bitmap bitmap){
        memoryCache.put(url,bitmap);
        diskCache.put(url,bitmap);
    }

}
