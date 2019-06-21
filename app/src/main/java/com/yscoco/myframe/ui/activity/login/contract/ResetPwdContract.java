package com.yscoco.myframe.ui.activity.login.contract;

import com.yscoco.myframe.base.BaseContract;

/**
 * @author：ZhongM on 2019/6/18 17:46
 */
public interface ResetPwdContract {
    interface View extends BaseContract.BaseView{

    }
    interface Presenter<T> extends BaseContract.BasePresenter<T>{
        public void sendSms(String phone);

        public void resetPwd(String phone,String sms);
    }
}
