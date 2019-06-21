package com.yscoco.myframe.ui.activity.login.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.yscoco.myframe.R;
import com.yscoco.myframe.base.BaseActivity;
import com.yscoco.myframe.ui.activity.login.contract.RegisterContract;
import com.yscoco.myframe.ui.activity.login.presenter.RegisterPresenter;
import com.yscoco.myframe.util.Md5AES;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterContract.View {

    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.pwd_sure)
    EditText pwdSure;
    @BindView(R.id.register)
    Button register;

    @Override
    protected RegisterPresenter createPresenter() {
        return new RegisterPresenter(this);
    }

    @Override
    protected void init() {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_register;
    }


    @OnClick({R.id.register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register:
                mPresenter.register(username.getText().toString(), Md5AES.encryption(pwd.getText().toString()),Md5AES.encryption(pwdSure.getText().toString()));
                break;
        }
    }
}
