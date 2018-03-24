package com.zhen.faseec.delegate.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zhen.faseec.R;
import com.zhen.faseec.delegate.BottomItemDelegate;

/**
 * Created by ZHEN on 2018/3/23.
 */

public class IndexDelegate extends BottomItemDelegate {

    private RecyclerView mRecyclerView;

    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mRecyclerView = rootView.findViewById(R.id.rv_index);
    }
}
