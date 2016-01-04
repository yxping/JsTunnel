package com.yxp.tunnel.core.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.webkit.WebSettings;

import com.yxp.tunnel.core.TLOG;
import com.yxp.tunnel.core.WebViewProxy;

/**
 * Created by yanxing on 15/12/28.
 */
public class SystemWebViewProxy implements WebViewProxy{
    public final static String TAG = "SystemWebViewProxy";
    private SystemWebView mWebView;

    public SystemWebViewProxy(Context context) {
        mWebView = new SystemWebView(context);
        initWebSettings();
    }

    @SuppressLint("JavascriptInterface")
    @Override
    public void addJavascriptInterface(Object object, String name) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            TLOG.e(TAG, "SDK is lower than JELLY_BEAN_MR1, can't invoke addJavascriptInterface");
            return;
        }
        mWebView.addJavascriptInterface(object, name);
    }

    @Override
    public void loadUrl(String url) {
        mWebView.loadUrl(url);
    }

    @Override
    public void initWebSettings() {
        // 设置webview的竖直滑块隐藏
        mWebView.setVerticalScrollBarEnabled(false);
        // 设置webview初始化放大倍数
        mWebView.setInitialScale(0);
        // 初始化web view的相关settings
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);

    }

    @Override
    public View getWebView() {
        return mWebView;
    }
}
