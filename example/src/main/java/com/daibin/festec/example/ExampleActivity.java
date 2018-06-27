package com.daibin.festec.example;

import com.daibin.latte.activitys.ProxyActivity;
import com.daibin.latte.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {


    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }


}
