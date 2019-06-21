package com.yscoco.myframe.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.yscoco.myframe.base.mvp.superinterfance.ITopView;
import com.yscoco.myframe.dto.BaseDTO;
import com.yscoco.myframe.dto.BaseDataDTO;
import com.yscoco.myframe.util.ActivityStack;

import butterknife.ButterKnife;

/**
 * @author：ZhongM on 2019/6/11 16:58
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseContract.BaseView {
    protected final String TAG = this.getClass().getSimpleName();
    public Context mContext;
    protected P mPresenter;

    protected abstract P createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStack.getInstance().pushActivity(this);
        setContentView(setLayoutId());
        ButterKnife.bind(this);
        mPresenter = createPresenter();
        init();
        initPresenter();
    }

    protected void initPresenter() {
    }

    protected abstract void init();

    protected abstract int setLayoutId();

    @Override
    protected void onStop() {
        super.onStop();
        if (isFinishing()) {
            ActivityStack.getInstance().removeActivity(this);
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(String msg) {
        showToast(msg);
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onErrorCode(BaseDTO model) {
        showToast(model.getMsg());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    //页面跳转，携带数据
    public void showActivity(Class<?> cls) {
        showActivity(cls, null);
    }

    public void showActivity(Class<?> cls, int in) {
        Intent i = new Intent(this, cls);
        i.putExtra("value", in);
        startActivity(i);
    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void showActivity(Class<?> cls, String str) {
        Intent i = new Intent(this, cls);
        if (str != null) {
            i.putExtra("value", str);
        }
        startActivity(i);
    }
}
