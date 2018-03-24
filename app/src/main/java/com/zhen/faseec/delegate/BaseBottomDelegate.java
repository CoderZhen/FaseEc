package com.zhen.faseec.delegate;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.joanzapata.iconify.widget.IconTextView;
import com.zhen.faseec.R;
import com.zhen.faseec.entity.BaseTabBean;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import me.yokeyword.fragmentation.ISupportFragment;

/**
 * Created by ZHEN on 2018/3/23.
 */

public abstract class BaseBottomDelegate extends LatteDelegate implements View.OnClickListener {

    private int mClickeColor = Color.RED;
    private int mIndexDelegate = 0;
    private int mCurrentDelegate = 0;

    private final ArrayList<BaseTabBean> ITEM_BEAN = new ArrayList<>();
    private final ArrayList<BottomItemDelegate> ITEM_DELEGATES = new ArrayList<>();
    private final LinkedHashMap<BaseTabBean, BottomItemDelegate> ITEMS = new LinkedHashMap<>();
    private LinearLayoutCompat mBottomBar;

    public abstract LinkedHashMap<BaseTabBean, BottomItemDelegate> setItems();

    public abstract int setClickColor();

    public abstract int setIndexDelegate();


    @Override
    public Object setLayout() {
        return R.layout.delegate_bottom;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIndexDelegate = setIndexDelegate();
        if (setClickColor() != 0) {
            mClickeColor = setClickColor();
        }
        LinkedHashMap<BaseTabBean, BottomItemDelegate> items = setItems();
        ITEMS.putAll(items);

        for (Map.Entry<BaseTabBean, BottomItemDelegate> item : ITEMS.entrySet()) {
            final BaseTabBean key = item.getKey();
            final BottomItemDelegate value = item.getValue();
            ITEM_BEAN.add(key);
            ITEM_DELEGATES.add(value);
        }
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mBottomBar = rootView.findViewById(R.id.bottom_bar);
        int size = ITEMS.size();
        for (int i = 0; i < size; i++) {
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_item_icon_text_layout, mBottomBar);
            RelativeLayout item = (RelativeLayout) mBottomBar.getChildAt(i);
            item.setTag(i);
            item.setOnClickListener(this);
            final BaseTabBean bean = ITEM_BEAN.get(i);
            final IconTextView icon = (IconTextView) item.getChildAt(0);
            final AppCompatTextView title = (AppCompatTextView) item.getChildAt(1);
            icon.setText(bean.getIcon());
            title.setText(bean.getTitle());
            if (i == mIndexDelegate) {
                icon.setTextColor(mClickeColor);
                title.setTextColor(mClickeColor);
            }
        }
        final ISupportFragment[] delegateArray = ITEM_DELEGATES.toArray(new ISupportFragment[size]);
        getSupportDelegate().loadMultipleRootFragment(R.id.bottom_container, mIndexDelegate, delegateArray);
    }

    private void reset() {
        int count = mBottomBar.getChildCount();
        for (int i = 0; i < count; i++) {
            RelativeLayout item = (RelativeLayout) mBottomBar.getChildAt(i);
            final IconTextView icon = (IconTextView) item.getChildAt(0);
            final AppCompatTextView title = (AppCompatTextView) item.getChildAt(1);
            icon.setTextColor(Color.GRAY);
            title.setTextColor(Color.GRAY);
        }
    }

    @Override
    public void onClick(View v) {
        final int tag = (int) v.getTag();
        reset();
        RelativeLayout mBottomBar = (RelativeLayout) v;
        final IconTextView icon = (IconTextView) mBottomBar.getChildAt(0);
        final AppCompatTextView title = (AppCompatTextView) mBottomBar.getChildAt(1);
        icon.setTextColor(mClickeColor);
        title.setTextColor(mClickeColor);
        getSupportDelegate().showHideFragment(ITEM_DELEGATES.get(tag), ITEM_DELEGATES.get(mCurrentDelegate));
        mCurrentDelegate = tag;
    }
}
