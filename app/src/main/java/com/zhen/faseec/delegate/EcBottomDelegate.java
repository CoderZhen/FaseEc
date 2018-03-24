package com.zhen.faseec.delegate;

import com.zhen.faseec.delegate.index.IndexDelegate;
import com.zhen.faseec.delegate.sort.SortDelegate;
import com.zhen.faseec.entity.BaseTabBean;

import java.util.LinkedHashMap;

/**
 * Created by ZHEN on 2018/3/23.
 */

public class EcBottomDelegate extends BaseBottomDelegate {

    @Override
    public LinkedHashMap<BaseTabBean, BottomItemDelegate> setItems() {
        LinkedHashMap<BaseTabBean,BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BaseTabBean("{fa-home}","主页"),new IndexDelegate());
        items.put(new BaseTabBean("{fa-sort}","分类"),new SortDelegate());
        items.put(new BaseTabBean("{fa-home}","主页"),new IndexDelegate());
        items.put(new BaseTabBean("{fa-home}","主页"),new IndexDelegate());
        items.put(new BaseTabBean("{fa-home}","主页"),new IndexDelegate());
        return items;
    }

    @Override
    public int setClickColor() {
        return 0;
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }
}
