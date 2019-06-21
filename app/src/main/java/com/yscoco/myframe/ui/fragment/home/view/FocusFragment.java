package com.yscoco.myframe.ui.fragment.home.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yscoco.myframe.R;
import com.yscoco.myframe.base.BaseFragment;
import com.yscoco.myframe.dto.BaseDTO;
import com.yscoco.myframe.dto.BaseDataDTO;
import com.yscoco.myframe.ui.fragment.home.contract.FocusContract;
import com.yscoco.myframe.ui.fragment.home.presenter.FocusPresenter;
import com.yscoco.myframe.view.TitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author：ZhongM on 2019/6/19 10:03
 */
public class FocusFragment extends BaseFragment<FocusPresenter> implements FocusContract.View {


    @BindView(R.id.tb_title)
    TitleBar tbTitle;

    @Override
    protected FocusPresenter createPresenter() {
        return new FocusPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_focus;
    }

    @Override
    protected void initToolbar(Bundle savedInstanceState) {
        tbTitle.setTitle("关注");
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onErrorCode(BaseDTO<BaseDataDTO> model) {

    }
}
