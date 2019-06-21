package com.yscoco.myframe.ui.activity.login.presenter;

import com.yscoco.myframe.base.BaseObserver;
import com.yscoco.myframe.base.BasePresenter;
import com.yscoco.myframe.ui.activity.login.contract.RegisterContract;

/**
 * @author：ZhongM on 2019/6/18 11:01
 */
public class RegisterPresenter extends BasePresenter<RegisterContract.View> implements RegisterContract.Presenter<RegisterContract.View> {

    public RegisterPresenter(RegisterContract.View baseView) {
        super(baseView);
    }


    @Override
    public void register(String phone, String password, String repassword) {
        addDisposable(apiServer.register(phone, password, repassword), new BaseObserver(mView) {
            @Override
            public void onSuccess(Object o) {

            }
        });
    }
}
