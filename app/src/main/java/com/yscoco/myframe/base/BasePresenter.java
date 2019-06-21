package com.yscoco.myframe.base;

import com.yscoco.myframe.net.ApiRetrofit;
import com.yscoco.myframe.server.ApiServer;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author：ZhongM on 2019/6/14 10:24
 */
public class BasePresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {
    protected T mView;
    private CompositeDisposable compositeDisposable;
    protected ApiServer apiServer = ApiRetrofit.getInstance().getApiService();



    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    public BasePresenter(T baseView) {
        this.mView = baseView;
    }


    @Override
    public void detachView() {
        this.mView = null;
    }

    public void addDisposable(Observable<?> observable, BaseObserver observer) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer));
    }

    public void removeDisposable() {
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }
}
