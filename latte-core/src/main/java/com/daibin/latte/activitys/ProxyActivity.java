package com.daibin.latte.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;

import com.daibin.latte.R;
import com.daibin.latte.delegates.LatteDelegate;

import me.yokeyword.fragmentation.SupportActivity;

public abstract class ProxyActivity extends SupportActivity {

    public abstract LatteDelegate setRootDelegate();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

    private void initContainer(@Nullable Bundle savedInstanceState){
        final ContentFrameLayout container  = new ContentFrameLayout(this);
        container.setId(R.id.delegate_conteainer);
        setContentView(container);
        if (savedInstanceState == null){
            loadRootFragment(R.id.delegate_conteainer,setRootDelegate());
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.gc();
        System.runFinalization();
    }
}
