package com.czj.androiddesignpatterns;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.czj.androiddesignpatterns.imageloader.DoubleCache;
import com.czj.androiddesignpatterns.imageloader.ImageLoader;
import com.czj.androiddesignpatterns.network.BaseObserver;
import com.czj.androiddesignpatterns.network.RequestManager;
import com.czj.androiddesignpatterns.network.RxSchedulers;
import com.czj.androiddesignpatterns.network.api.ApiException;
import com.czj.androiddesignpatterns.responseBean.AddressListBean;
import com.czj.androiddesignpatterns.utils.LogUtil;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

public class MainActivity extends RxAppCompatActivity {

    private ImageView ivTest;
    private ImageLoader imageLoader;
    private String imageUrl = "https://www.baidu.com/img/bd_logo1.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ivTest = findViewById(R.id.iv_test);
        ivTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testNetWork();
            }
        });
    }

    private void testNetWork() {
        RequestManager.getInstance().getRequestService().getAddressList()
                .compose(this.<AddressListBean>bindToLifecycle())
                .compose(RxSchedulers.<AddressListBean>io_main())
                .subscribe(new BaseObserver<AddressListBean>(this) {
                    @Override
                    public void onSuccess(AddressListBean dataBean) {
                        LogUtil.e(dataBean.getData().get(0).getName());
                    }

                    @Override
                    public void onFail(ApiException apiException) {

                    }
                });

    }

    private void init() {
        ivTest = findViewById(R.id.iv_test);
        imageLoader = new ImageLoader();
        imageLoader.setImageCache(new DoubleCache());
        imageLoader.displayImage(imageUrl,ivTest);
    }
}
