package com.yxp.tunnel.core;

import android.content.Context;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by yanxing on 15/12/21.
 */
public class PluginManager {
    private LinkedHashMap<String, TunnelPlugin> mPlugins = new LinkedHashMap<>();
    private Context mContext;

    public PluginManager(Context context, List<PluginEntry> pluginEntries) {
        this.mContext = context;
        setupPlugin(pluginEntries);
    }

    private void setupPlugin(List<PluginEntry> pluginEntries) {
        for (PluginEntry entry : pluginEntries) {
            TunnelPlugin plugin = initialPlugin(entry.path);
            if (plugin != null) {
                plugin.init(mContext);
                mPlugins.put(entry.pluginName, plugin);
            }
        }
    }

    private TunnelPlugin initialPlugin(String className) {
        if (className == null || className.equals("")) {
            return null;
        }
        TunnelPlugin plugin = null;
        try {
            Class<?> pluginClass = Class.forName(className);
            if (pluginClass != null) {
                plugin = (TunnelPlugin)pluginClass.newInstance();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return plugin;
    }

    public void exec(String name, String action, String arguments) {
        TunnelPlugin plugin = mPlugins.get(name);
        if (plugin.exec(action, arguments)) {
            return;
        }
    }

    public TunnelPlugin getPluginByName(String name) {
        return mPlugins.get(name);
    }

}
