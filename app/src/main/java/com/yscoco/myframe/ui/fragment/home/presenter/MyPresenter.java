package com.yscoco.myframe.ui.fragment.home.presenter;

import com.yscoco.myframe.base.BasePresenter;
import com.yscoco.myframe.ui.fragment.home.contract.MainContract;
import com.yscoco.myframe.ui.fragment.home.contract.MyContract;

/**
 * @author：ZhongM on 2019/6/19 10:06
 */
public class MyPresenter extends BasePresenter<MyContract.View> implements MyContract.Presenter<MyContract.View> {
    public MyPresenter(MyContract.View baseView) {
        super(baseView);
    }
}
