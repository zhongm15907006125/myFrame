package com.yscoco.myframe.ui.fragment.home.view;

import android.os.Bundle;

import com.yscoco.myframe.R;
import com.yscoco.myframe.base.BaseFragment;
import com.yscoco.myframe.dto.BaseDTO;
import com.yscoco.myframe.dto.BaseDataDTO;
import com.yscoco.myframe.ui.fragment.home.contract.MyContract;
import com.yscoco.myframe.ui.fragment.home.presenter.MyPresenter;

/**
 * @author：ZhongM on 2019/6/19 10:03
 */
public class MyFragment extends BaseFragment<MyPresenter> implements MyContract.View {
    @Override
    protected MyPresenter createPresenter() {
        return new MyPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_my;
    }

    @Override
    protected void initToolbar(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onErrorCode(BaseDTO<BaseDataDTO> model) {

    }

}
