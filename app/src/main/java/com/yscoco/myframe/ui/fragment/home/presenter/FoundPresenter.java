package com.yscoco.myframe.ui.fragment.home.presenter;

import com.yscoco.myframe.base.BasePresenter;
import com.yscoco.myframe.ui.fragment.home.contract.FoundContract;
import com.yscoco.myframe.ui.fragment.home.contract.MainContract;

/**
 * @author：ZhongM on 2019/6/19 10:06
 */
public class FoundPresenter extends BasePresenter<FoundContract.View> implements FoundContract.Presenter<FoundContract.View> {
    public FoundPresenter(FoundContract.View baseView) {
        super(baseView);
    }
}
