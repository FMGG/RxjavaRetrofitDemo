package com.czj.androiddesignpatterns.imageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 加载图片类
 */

public class ImageLoader {

    private ImageCache mImageCache = new MemoryCache();
    //线程池，线程数量为CPU的数量
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.
            getRuntime().availableProcessors());

    public void setImageCache(ImageCache imageCache) {
        mImageCache = imageCache;
    }

    /**
     * 加载图片
     *
     * @param imageUrl
     * @param imageView
     */
    public void displayImage(final String imageUrl, final ImageView imageView) {
        Bitmap bitmap;
        bitmap = mImageCache.get(imageUrl);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }
        imageView.setTag(imageUrl);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downLoadImage(imageUrl);
                if (bitmap == null)
                    return;
                if (imageView.getTag().equals(imageUrl))
                    imageView.setImageBitmap(bitmap);
                mImageCache.put(imageUrl, bitmap);
            }
        });
    }

    /**
     * 下载图片
     *
     * @param imageUrl
     * @return
     */
    private Bitmap downLoadImage(String imageUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }


}
