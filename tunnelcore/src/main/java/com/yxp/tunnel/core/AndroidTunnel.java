package com.yxp.tunnel.core;

/**
 * Created by yanxing on 15/12/21.
 */
public class AndroidTunnel {
    public final static String TAG = "AndroidTunnel";
    private PluginManager mPluginManager;

    public AndroidTunnel(PluginManager pluginManager) {
        this.mPluginManager = pluginManager;
    }

    public void jsExec(String name, String action, String arguments) {
        mPluginManager.exec(name, action, arguments);
    }
}
