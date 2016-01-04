package com.yxp.tunnel.core;

import android.view.View;

/**
 * Created by yanxing on 15/12/28.
 */
public interface WebViewProxy {

    void addJavascriptInterface(Object object, String name);

    void loadUrl(String url);

    void initWebSettings();

    View getWebView();
}
