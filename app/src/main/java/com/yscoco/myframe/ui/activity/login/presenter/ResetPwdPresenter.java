package com.yscoco.myframe.ui.activity.login.presenter;

import com.yscoco.myframe.base.BasePresenter;
import com.yscoco.myframe.ui.activity.login.contract.RegisterContract;
import com.yscoco.myframe.ui.activity.login.contract.ResetPwdContract;

/**
 * @author：ZhongM on 2019/6/18 17:47
 */
public class ResetPwdPresenter extends BasePresenter<ResetPwdContract.View> implements ResetPwdContract.Presenter<ResetPwdContract.View> {
    public ResetPwdPresenter(ResetPwdContract.View baseView) {
        super(baseView);
    }

    @Override
    public void sendSms(String phone) {

    }

    @Override
    public void resetPwd(String phone, String sms) {

    }
}
