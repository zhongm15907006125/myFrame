package com.yscoco.myframe.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * @author：ZhongM on 2019/6/13 17:10
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseContract.BaseView {
    public View view;

    public Context mContext;
    protected P mPresenter;

    protected abstract P createPresenter();
    //错误提示框  警告框  成功提示框

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this,view);
        mContext = getActivity();
        mPresenter = createPresenter();
        this.initToolbar(savedInstanceState);
        this.initData();

        return view;
    }

    /**
     * 获取布局ID
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 处理顶部title
     *
     * @param savedInstanceState
     */
    protected abstract void initToolbar(Bundle savedInstanceState);


    /**
     * 数据初始化操作
     */
    protected abstract void initData();

    public void showToast(String str) {
    }

    public void showLongToast(String str) {
    }

    @Override
    public void showError(String msg) {
        showToast(msg);
    }

    @Override
    public void showLoading() {
//        showLoadingDialog();
    }

    @Override
    public void hideLoading() {
    }


    /**
     * 加载中...
     */
    public void showLoadingDialog() {
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        this.view = null;
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}