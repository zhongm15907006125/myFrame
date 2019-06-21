package com.yscoco.myframe.ui.fragment.home.view;

import android.os.Bundle;

import com.yscoco.myframe.R;
import com.yscoco.myframe.base.BaseFragment;
import com.yscoco.myframe.dto.BaseDTO;
import com.yscoco.myframe.dto.BaseDataDTO;
import com.yscoco.myframe.ui.fragment.home.contract.FoundContract;
import com.yscoco.myframe.ui.fragment.home.presenter.FoundPresenter;

/**
 * @author：ZhongM on 2019/6/19 10:03
 */
public class FoundFragment extends BaseFragment<FoundPresenter> implements FoundContract.View {
    @Override
    protected FoundPresenter createPresenter() {
        return new FoundPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_found;
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
