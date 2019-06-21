package com.yscoco.myframe.base.mvp.superinterfance;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;

/**
 * @author：ZhongM on 2019/6/13 16:59
 */
public interface ITopView extends LifecycleOwner {

    public Context getConetext();

}
