package com.yscoco.myframe.ui.fragment.home.view;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yscoco.myframe.MainActivity;
import com.yscoco.myframe.R;
import com.yscoco.myframe.adapter.mainAdapter;
import com.yscoco.myframe.base.BaseFragment;
import com.yscoco.myframe.dto.BaseDTO;
import com.yscoco.myframe.dto.BaseDataDTO;
import com.yscoco.myframe.ui.fragment.home.contract.MainContract;
import com.yscoco.myframe.ui.fragment.home.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * @author：ZhongM on 2019/6/19 10:03
 */
public class MainFragment extends BaseFragment<MainPresenter> implements MainContract.View {
    //    @BindView(R.id.toolbar)
//    Toolbar toolbar;
    @BindView(R.id.collapsing)
    CollapsingToolbarLayout collapsing;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    List list;
    mainAdapter adapter;
    @BindView(R.id.open_left)
    ImageView openLeft;

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_main;
    }

    @Override
    protected void initToolbar(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {
        list = new ArrayList();
        for (int i = 0; i < 14; i++) {
            list.add("");
        }
        adapter = new mainAdapter(mContext, list);
        recycler.setLayoutManager(new LinearLayoutManager(mContext));
        recycler.setAdapter(adapter);
    }

    @Override
    public void onErrorCode(BaseDTO<BaseDataDTO> model) {

    }

    @OnClick(R.id.open_left)
    public void onViewClicked() {
        ((MainActivity)mContext).openLeft();
    }
}
