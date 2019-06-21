package com.yscoco.myframe.ui.fragment.home.presenter;

import com.yscoco.myframe.base.BasePresenter;
import com.yscoco.myframe.ui.fragment.home.contract.FocusContract;
import com.yscoco.myframe.ui.fragment.home.contract.MainContract;

/**
 * @author：ZhongM on 2019/6/19 10:06
 */
public class FocusPresenter extends BasePresenter<FocusContract.View> implements FocusContract.Presenter<FocusContract.View> {
    public FocusPresenter(FocusContract.View baseView) {
        super(baseView);
    }
}
