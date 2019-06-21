package com.yscoco.myframe.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yscoco.myframe.R;

public class TitleBar extends RelativeLayout {
    private Activity activity;
    private LinearLayout ll_title_left;
    private RelativeLayout title_bg_rl;

    private TextView mBackBtn;
    private TextView mRightBtn;
    private ImageView iv_title_left;
    private ImageView mRightImage;

    private TextView mTitle;

    private ImageView mTitleImg;

    private Callback mCallback;
    private RightCallback mRightCallback;

    private int type;

    public interface Callback {
        void buttonClick(View v);
    }


    public interface RightCallback {
        void rightImgClick(View v);
    }

    public TitleBar(Context context) {
        this(context, null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//		type = ShardPreUtils.readDeviceAdress(context);
        activity = (Activity) context;
        init();
    }

    private void init() {
        View view = View.inflate(getContext(), R.layout.title_bar, this);
        ll_title_left = (LinearLayout) view.findViewById(R.id.ll_title_left);
        title_bg_rl = (RelativeLayout) view.findViewById(R.id.title_bg_rl);
        mBackBtn = (TextView) view.findViewById(R.id.back_button);
        mRightBtn = (TextView) view.findViewById(R.id.right_btn);
        iv_title_left = (ImageView) view.findViewById(R.id.iv_title_left);
        mRightImage = (ImageView) view.findViewById(R.id.right_image);
        mTitle = (TextView) view.findViewById(R.id.title_name);
        mTitleImg = (ImageView) view.findViewById(R.id.title_img);
        ll_title_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(v);
            }
        });
        mRightBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                rightImgClick(v);
            }
        });
        mRightImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                rightImgClick(v);
            }
        });


    }

    public void setTitleColor(int backImgID, String strID, int colorID, int titleBgId) {
        if (backImgID != 0) {
            setLeftImage(backImgID);
        }
        if (!strID.equals("")) {
            setTitle(strID);
        }
        if (colorID != 0) {
            mTitle.setTextColor(getResources().getColor(colorID));
        }
        if (titleBgId == 0) {
            title_bg_rl.setBackgroundResource(android.R.color.transparent);
        } else {
            title_bg_rl.setBackgroundResource(titleBgId);
        }
    }

    /**
     * 设置标题
     *
     * @param rsid
     */
    public void setTitle(int rsid) {
        mTitle.setVisibility(View.VISIBLE);
        mTitle.setText(rsid);
    }

    public void setTitle(String text) {
        mTitle.setVisibility(View.VISIBLE);
        mTitle.setText(text);
    }

    /**
     * 设置按钮文字(返回或取消)
     * 默认不显示返回文字
     *
     * @param rsid
     */
    public void setLeftBtnText(int rsid) {
        setLeftBtnText(rsid, false);
    }

    /**
     * @param rsid
     * @param isView 是否显示文字
     */
    public void setLeftBtnText(int rsid, boolean isView) {
        mBackBtn.setVisibility(View.VISIBLE);

        if (!isView) {
            mBackBtn.setText("");
        }
    }

    /**
     * 设置右边按钮(只显示文字)
     *
     * @param rsid
     */
    public void setRightBtnText(int rsid) {
        mRightBtn.setVisibility(View.VISIBLE);
        mRightBtn.setText(rsid);
    }

    public void setRightBtnText(String str) {
        mRightBtn.setVisibility(View.VISIBLE);
        mRightBtn.setText(str);
    }

    public String getRightText() {
        return mRightBtn.getText().toString();
    }

    /**
     * 设置右边按钮(只显示文字)
     *
     * @param colorId
     */
    public void setRightBtnTextColor(int colorId) {
        mRightBtn.setTextColor(colorId);
    }

    /**
     * 设置左边(只显示图片)
     *
     * @param rsid
     */
    public void setLeftImage(int rsid) {
        iv_title_left.setImageResource(rsid);
    }

    /**
     * 设置右边按钮(只显示图片)
     *
     * @param rsid
     */
    public void setRightImage(int rsid) {
        mRightImage.setVisibility(View.VISIBLE);
        mRightImage.setImageResource(rsid);
    }

    public void buttonClick(View v) {
        if (mCallback != null) {
            mCallback.buttonClick(v);
        } else {
            activity.finish();
        }
    }

    public void rightImgClick(View v) {
        if (mRightCallback != null) {
            mRightCallback.rightImgClick(v);
        }
    }

    /**
     * 设置回调(点击返回)
     *
     * @param callback
     */
    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    /**
     * 设置回调(右-确定)
     *
     * @param callback
     */
    public void setRightCallback(RightCallback callback) {
        this.mRightCallback = callback;
    }

    public void setTitleBackground(int rsid) {
        mTitleImg.setVisibility(View.VISIBLE);
        mTitleImg.setImageResource(rsid);
    }
}