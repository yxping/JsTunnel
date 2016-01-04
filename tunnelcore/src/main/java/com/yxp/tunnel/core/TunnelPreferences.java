package com.yxp.tunnel.core;

import java.util.HashMap;
import java.util.Locale;

/**
 * 存储config.xml中的preference的参数
 * Created by yanxing on 15/12/21.
 */
public class TunnelPreferences {
    private HashMap<String, String> preferences = new HashMap<String, String>(20);

    public void put(String name, String value) {
        this.preferences.put(name.toLowerCase(Locale.ENGLISH), value);
    }

    public HashMap<String, String> getAll() {
        return preferences;
    }

    public String getStringByName(String name, String defaultValue) {
        String result = preferences.get(name.toLowerCase(Locale.ENGLISH));
        if (result != null) {
            return result;
        }
        return defaultValue;
    }
}
