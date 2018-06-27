package com.daibin.festec.example;

import android.app.Application;

import com.daibin.latte.app.Latte;
import com.daibin.latte.ec.icon.FontEcModule;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())//使用默认图标
                .withIcon(new FontEcModule())//自定义图标
                .withApihost("http://127.0.0.1")
                .configure();
    }
}
