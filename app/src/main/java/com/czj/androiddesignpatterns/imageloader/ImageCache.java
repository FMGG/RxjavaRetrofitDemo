package com.czj.androiddesignpatterns.imageloader;

import android.graphics.Bitmap;

public interface ImageCache {

      Bitmap get(String imgUrl);

      void put(String imgUrl,Bitmap bitmap);

}
