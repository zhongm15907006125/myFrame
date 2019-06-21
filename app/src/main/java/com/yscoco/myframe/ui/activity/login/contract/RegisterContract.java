package com.yscoco.myframe.ui.activity.login.contract;

import com.yscoco.myframe.base.BaseContract;

/**
 * @author：ZhongM on 2019/6/18 10:55
 */
public interface RegisterContract {

    interface View extends BaseContract.BaseView{

    }
    interface Presenter<T> extends BaseContract.BasePresenter<T>{


        public void register(String phone,String password,String repassword);
    }
}
