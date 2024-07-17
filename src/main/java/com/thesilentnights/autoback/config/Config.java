package com.thesilentnights.autoback.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Config {
    private static Configuration configuration;

    public static void load(FMLPreInitializationEvent event) {
        configuration = new Configuration(event.getSuggestedConfigurationFile());
    }

    public static int getInt(String key) {
        return configuration.getInt(key, Configuration.CATEGORY_GENERAL, 500, 0, 10000, "maxTickTime");
    }

    public static void saveInt(String key, int value) {
        configuration.get(Configuration.CATEGORY_GENERAL, key, value);
    }

    public static boolean getBoolean(String key) {
        return configuration.getBoolean(key, Configuration.CATEGORY_GENERAL, true, "ifEnable");
    }

    public static void saveBoolean(String key, boolean value) {
        configuration.get(Configuration.CATEGORY_GENERAL, key, value);
    }

    public static void save() {
        configuration.save();
    }


}
