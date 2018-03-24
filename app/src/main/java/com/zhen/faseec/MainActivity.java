package com.zhen.faseec;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zhen.faseec.activtes.ProxyActivity;
import com.zhen.faseec.delegate.EcBottomDelegate;
import com.zhen.faseec.delegate.LatteDelegate;
import com.zhen.faseec.delegate.index.IndexDelegate;

public class MainActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new EcBottomDelegate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }
}
