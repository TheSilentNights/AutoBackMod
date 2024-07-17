package com.thesilentnights.autoback.repo;

import com.thesilentnights.autoback.config.Config;

public class State {
    public static boolean isEnabled = Config.getBoolean("ifEnable");
}
