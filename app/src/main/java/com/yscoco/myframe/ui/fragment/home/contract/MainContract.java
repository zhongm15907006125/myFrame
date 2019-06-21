package com.yscoco.myframe.ui.fragment.home.contract;

import com.yscoco.myframe.base.BaseContract;

/**
 * @author：ZhongM on 2019/6/19 10:05
 */
public interface MainContract {
    interface View extends BaseContract.BaseView{}

    interface  Presenter<T> extends BaseContract.BasePresenter<T>{

    }
}
