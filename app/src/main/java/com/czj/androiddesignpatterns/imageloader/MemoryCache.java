package com.czj.androiddesignpatterns.imageloader;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.czj.androiddesignpatterns.imageloader.ImageCache;

public class MemoryCache implements ImageCache {

    private LruCache<String,Bitmap> bitmapLruCache;

    public MemoryCache(){
        initMemoryCache();
    }

    private void initMemoryCache() {
        //获取可以使用的最大内存
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        //取4分之1做为图片缓存
        final int cacheSize = maxMemory/4;
        bitmapLruCache = new LruCache<String, Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }

    @Override
    public Bitmap get(String imgUrl) {
        return bitmapLruCache.get(imgUrl);
    }

    @Override
    public void put(String imgUrl, Bitmap bitmap) {
        bitmapLruCache.put(imgUrl,bitmap);
    }
}
