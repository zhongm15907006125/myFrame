package com.yscoco.myframe.adapter;

import android.content.Context;

import com.yscoco.myframe.R;
import com.yscoco.myframe.base.adapter.CommonRecyclerAdapter;
import com.yscoco.myframe.base.adapter.RecyclerHolder;

import java.util.List;

/**
 * @author：ZhongM on 2019/6/11 16:54
 */
public class mainAdapter extends CommonRecyclerAdapter<String> {
    public mainAdapter(Context context, List<String> list) {
        super(context, R.layout.item_main, list);
    }

    @Override
    public void convert(RecyclerHolder holder, String item, int position) {

    }
}
