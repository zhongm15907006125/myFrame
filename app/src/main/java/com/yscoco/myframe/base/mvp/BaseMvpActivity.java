package com.yscoco.myframe.base.mvp;

import android.content.Context;
import android.support.annotation.CallSuper;

import com.yscoco.myframe.base.BaseActivity;

/**
 * Created by XQ Yang on 2017/9/8  11:10.
 * Description : mvp的基础 Activity
 */

public abstract class BaseMvpActivity<V extends IView,P extends IPresenter<V>> extends BaseActivity {

    protected P mPresenter;
    protected V mView;

//
//    /**
//     * 注意如果在这里获取intent的数据在构造中传给Presenter的话,获取代码需要在super调用之前
//     */
//    @CallSuper
//    protected void initPresenter() {
//        mView = createView();
//        if (getPresenter() == null) {
//            mPresenter = createPresenter();
//            if (mPresenter != null) {
//                getLifecycle().addObserver(mPresenter);
//            }
//        }
//    }
//
//    @Override
//    protected void init() {
//
//    }
//
//    @Override
//    protected int setLayoutId() {
//        return 0;
//    }
//
//
//
//    @Override
//    public P getPresenter() {
//        return mPresenter;
//    }
//
//    @Override
//    public void setPresenter(P presenter) {
//        this.mPresenter = presenter;
//    }
//
//    @Override
//    public V getMvpView() {
//        return this.mView;
//    }
//
//    @Override
//    public void setMvpView(V view) {
//        this.mView = view;
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        if (isFinishing()) {
//            setMvpView(null);
//            setPresenter(null);
//        }
//    }
//
//    public Context getContext() {
//        return this;
//    }
//
//    @CallSuper
//
//    @Override
//    public void inited() {
//        mPresenter.attachView(getMvpView());
//    }
//
//    public void setResultAndFinish(int result) {
//        setResult(result);
//        finish();
//    }
}
