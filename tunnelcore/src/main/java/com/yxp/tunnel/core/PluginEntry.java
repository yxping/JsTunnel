package com.yxp.tunnel.core;

/**
 * 插件的描述
 * Created by yanxing on 15/12/21.
 */
public final class PluginEntry {

    // 插件的名称
    public final String pluginName;

    // 插件的类的路径
    public final String path;

    public PluginEntry(String name, String path) {
        this.pluginName = name;
        this.path = path;
    }
}
