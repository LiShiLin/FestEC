package com.daibin.latte.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

public class Confugurator {

    private static final HashMap<String,Object> LATTE_CONFIGS = new HashMap<>();

    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

    private Confugurator(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),false);
    }

    public static Confugurator getInstance(){
        return Holder.INSTANCE;
    }

    final HashMap<String,Object> getLatteConfigs(){
        return LATTE_CONFIGS;
    }

    private static class Holder{
        private static final Confugurator INSTANCE = new Confugurator();
    }

    public final void configure(){
        intitIcons();
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),true);
    }

    public final Confugurator withApihost(String host){
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(),host);
        return this;
    }

    private void intitIcons(){
        if (ICONS.size()>0){
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i=1;i<ICONS.size();i++){
                 initializer.with(ICONS.get(i));
            }
        }
    }

    public final Confugurator withIcon(IconFontDescriptor descriptor){
        ICONS.add(descriptor);
        return this;
    }



    public void checkConfiguration(){
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady){
            throw new RuntimeException("configuration is not ready,call configure");
        }
    }


    final <T> T getConfiguration(Enum<ConfigType> key){
         checkConfiguration();
         return (T) LATTE_CONFIGS.get(key.name());
    }
}
