package com.zhen.faseec.entity;

/**
 * Created by ZHEN on 2018/3/23.
 */

public class BaseTabBean {
    private CharSequence icon;
    private CharSequence title;

    public BaseTabBean(CharSequence icon, CharSequence title) {
        this.icon = icon;
        this.title = title;
    }

    public CharSequence getIcon() {
        return icon;
    }

    public CharSequence getTitle() {
        return title;
    }
}
