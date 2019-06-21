package com.yscoco.myframe.ui.fragment.home.presenter;

import com.yscoco.myframe.base.BasePresenter;
import com.yscoco.myframe.ui.fragment.home.contract.MainContract;

/**
 * @author：ZhongM on 2019/6/19 10:06
 */
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter<MainContract.View> {
    public MainPresenter(MainContract.View baseView) {
        super(baseView);
    }
}
