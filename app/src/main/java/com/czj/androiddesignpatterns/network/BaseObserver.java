package com.czj.androiddesignpatterns.network;

import android.content.Context;

import com.czj.androiddesignpatterns.network.api.ApiErrorHelper;
import com.czj.androiddesignpatterns.network.api.ApiException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<T> {

    private Context mContext;

    public BaseObserver(Context context){
        mContext = context;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        ApiException apiException = ApiErrorHelper.handleCommonError(mContext,e);
        onFail(apiException);
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(T t);

    public abstract void onFail(ApiException apiException);

}
