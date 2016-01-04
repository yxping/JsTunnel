package com.yxp.tunnel.core.webview;

import android.content.Context;
import android.view.View;
import android.webkit.JavascriptInterface;

import com.yxp.tunnel.core.PluginEntry;
import com.yxp.tunnel.core.WebViewProxy;

import java.util.List;

/**
 * Created by yanxing on 15/12/21.
 */
public interface TunnelWebView {

    void init(Context context, List<PluginEntry> pluginEntryList);

    /**
     * 注入javascript object
     *
     * @param object
     * @param name
     */
    void addJavascriptInterface(Object object, String name);


    /**
     * 向webview中发送javascript的消息
     * send javascript to the webview
     */
    void sendJavaScript();

    /**
     * webview返回前一网页
     * go back to the pre web page
     */
    void goBack();

    /**
     * 获取当前的webview是否有历史记录
     * Get whether the webview has hitory item
     * @return boolean
     */
    boolean canGoBack();

    /**
     * 获取网页url
     * get url for the current page
     * @return String
     */
    String getUrl();

    /**
     * 获取网页的标题
     * get title for the current page
     * @return String
     */
    String getTitle();

    /**
     * 清除当前webview的缓存
     * clear the history in webview
     */
    void clearHistory();

    View getRealWebView();

    void loadUrl(String url);
}
