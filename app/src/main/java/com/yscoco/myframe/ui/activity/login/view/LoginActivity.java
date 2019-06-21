package com.yscoco.myframe.ui.activity.login.view;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.yscoco.myframe.MainActivity;
import com.yscoco.myframe.R;
import com.yscoco.myframe.base.BaseActivity;
import com.yscoco.myframe.dto.BaseDTO;
import com.yscoco.myframe.dto.BaseDataDTO;
import com.yscoco.myframe.ui.activity.login.contract.LoginContract;
import com.yscoco.myframe.ui.activity.login.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.forget_pwd)
    TextView forgetPwd;

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }


    @Override
    protected void init() {
        phone.setText("123456");
        pwd.setText("123456");
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_login;
    }


    @Override
    public void changeUI(BaseDTO<BaseDataDTO> result) {
//        Toast.makeText(this, "请求成功", Toast.LENGTH_SHORT).show();
        showActivity(MainActivity.class);
    }


    @OnClick({R.id.register, R.id.forget_pwd, R.id.login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register:
                showActivity(RegisterActivity.class);
                break;
            case R.id.forget_pwd:
                showActivity(ResetPwdActivity.class);
                break;
            case R.id.login:
//                showActivity(MainActivity.class);
                Logger.e("login");
                mPresenter.login(phone.getText().toString(), pwd.getText().toString());
                break;
        }
    }

    @Override
    public void showError(String msg) {
        showToast(msg);
        Logger.e(msg);
    }
}
