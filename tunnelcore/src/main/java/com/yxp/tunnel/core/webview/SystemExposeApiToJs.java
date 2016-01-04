package com.yxp.tunnel.core.webview;

import android.webkit.JavascriptInterface;

import com.yxp.tunnel.core.AndroidTunnel;
import com.yxp.tunnel.core.ExposeApiToJs;

/**
 * Created by yanxing on 15/12/21.
 */
public class SystemExposeApiToJs implements ExposeApiToJs {
    private final AndroidTunnel tunnel;

    public SystemExposeApiToJs(AndroidTunnel tunnel) {
        this.tunnel = tunnel;
    }

    @JavascriptInterface
    public void exec(String plugin, String action, String arguments) {
        tunnel.jsExec(plugin, action, arguments);
    }
}
