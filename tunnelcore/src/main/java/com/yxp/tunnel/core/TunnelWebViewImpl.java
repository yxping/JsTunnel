package com.yxp.tunnel.core;

import android.content.Context;
import android.view.View;

import com.yxp.tunnel.core.webview.SystemExposeApiToJs;
import com.yxp.tunnel.core.webview.TunnelWebView;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by yanxing on 15/12/22.
 */
public class TunnelWebViewImpl implements TunnelWebView {
    public final static String TAG = "TunnelWebView";
    private PluginManager mPluginManager;
    private Context mContext;
    private WebViewProxy mWebViewProxy;
    private TunnelPreferences mPrefs;
    private AndroidTunnel mTunnel;

    /**
     * 创建一个WebViewProxy来管理相应webView的事件
     * @param context
     * @param prefs
     * @return
     */
    public static WebViewProxy createWebViewProxy(Context context, TunnelPreferences prefs) {
        String className = prefs.getStringByName("webview", "com.yxp.tunnel.core.webview.SystemWebViewProxy");
        try {
            Class<?> webViewProxyClass = Class.forName(className);
            Constructor<?> constructor = webViewProxyClass.getConstructor(Context.class);
            return (WebViewProxy) constructor.newInstance(context);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            TLOG.e(TAG, e.getMessage());
        }
        return null;
    }

    public TunnelWebViewImpl(WebViewProxy webViewProxy) {
        mWebViewProxy = webViewProxy;
    }

    @Override
    public void init(Context context, List<PluginEntry> pluginEntryList) {
        this.mContext = context;
        mPluginManager = new PluginManager(context, pluginEntryList);
        mTunnel = new AndroidTunnel(mPluginManager);
        addJavascriptInterface(new SystemExposeApiToJs(mTunnel), "_jsTunnel");
    }

    @Override
    public void addJavascriptInterface(Object object, String name) {
        mWebViewProxy.addJavascriptInterface(object, name);
    }

    @Override
    public void sendJavaScript() {

    }

    @Override
    public void goBack() {

    }

    @Override
    public boolean canGoBack() {
        return false;
    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public void clearHistory() {

    }

    @Override
    public View getRealWebView() {
        return mWebViewProxy.getWebView();
    }

    @Override
    public void loadUrl(String url) {
        mWebViewProxy.loadUrl(url);
    }

}
