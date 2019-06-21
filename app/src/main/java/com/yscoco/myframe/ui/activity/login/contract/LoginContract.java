package com.yscoco.myframe.ui.activity.login.contract;

import com.yscoco.myframe.base.BaseContract;
import com.yscoco.myframe.dto.BaseDTO;
import com.yscoco.myframe.dto.BaseDataDTO;

import java.util.List;

/**
 * @author：ZhongM on 2019/6/14 10:09
 */
public interface LoginContract {

    /**
     * 获取到网络数据后需要进行的UI操作
     */
    interface View extends BaseContract.BaseView {
        void changeUI(BaseDTO<BaseDataDTO> result);
    }

    /**
     * 获取网络数据的操作
     *
     * @param <T>
     */
    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void login(String phone, String password);
    }
}
