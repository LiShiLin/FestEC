package com.daibin.latte.app;

import android.content.Context;

import java.util.HashMap;

public final class Latte {
    public static Confugurator init(Context context){
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Confugurator.getInstance();
    }

    public static HashMap<String,Object> getConfigurations(){
        return Confugurator.getInstance().getLatteConfigs();
    }

    public static Context getApplistion(){
        return (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXT.name());
    }

}
