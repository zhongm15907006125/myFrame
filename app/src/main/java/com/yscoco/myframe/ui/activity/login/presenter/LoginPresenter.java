package com.yscoco.myframe.ui.activity.login.presenter;

import android.widget.Toast;

import com.yscoco.myframe.base.BaseContract;
import com.yscoco.myframe.base.BaseObserver;
import com.yscoco.myframe.base.BasePresenter;
import com.yscoco.myframe.dto.BaseDTO;
import com.yscoco.myframe.dto.BaseDataDTO;
import com.yscoco.myframe.ui.activity.login.contract.LoginContract;
import com.yscoco.myframe.util.Md5AES;

import java.util.List;

/**
 * @author：ZhongM on 2019/6/14 10:12
 */
public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter<LoginContract.View> {

    public LoginPresenter(LoginContract.View baseView) {
        super(baseView);
    }


    @Override
    public void login(String phone, String password) {

        addDisposable(apiServer.login( phone, Md5AES.encryption(password)), new BaseObserver(mView) {
            @Override
            public void onSuccess(Object o) {
                mView.changeUI((BaseDTO) o);
            }
        });
    }
}
