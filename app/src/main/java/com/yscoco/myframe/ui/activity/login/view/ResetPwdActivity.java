package com.yscoco.myframe.ui.activity.login.view;

import com.yscoco.myframe.R;
import com.yscoco.myframe.base.BaseActivity;
import com.yscoco.myframe.ui.activity.login.contract.ResetPwdContract;
import com.yscoco.myframe.ui.activity.login.presenter.ResetPwdPresenter;

public class ResetPwdActivity extends BaseActivity<ResetPwdPresenter> implements ResetPwdContract.View {

    @Override
    protected ResetPwdPresenter createPresenter() {
        return new ResetPwdPresenter(this);
    }

    @Override
    protected void init() {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_reset_pwd;
    }

}
