package com.yxp.tunnel.core;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.yxp.tunnel.core.util.ConfigXmlParser;
import com.yxp.tunnel.core.webview.TunnelWebView;

import java.util.ArrayList;

/**
 * Created by yanxing on 15/12/21.
 */
public class TunnelContainer {
    private Context mContext;
    private ViewGroup mRootView;
    private TunnelPreferences mPreferences;
    private ConfigXmlParser configXmlParser;
    private ArrayList<PluginEntry> mPluginEntries;
    private TunnelWebView mWebView;
    private AndroidTunnel mTunnel;
    private String mLaunchUrl;

    public TunnelContainer(Context context, ViewGroup rootView) {
        this.mContext = context;
        this.mRootView = rootView;
        init();
    }

    public void init(){
        String url = ((Activity)mContext).getIntent().getStringExtra("url");
        if (url == null) {
            url = "file:///android_asset/www/index.html";
        }
        this.mLaunchUrl = url;

        loadConfig();

        // 初始化webview
        mWebView = makeWebView(mContext, mPreferences);
        mWebView.init(mContext, mPluginEntries);
        mWebView.loadUrl(url);
    }

    public TunnelWebView makeWebView(Context context, TunnelPreferences prefs) {
        return new TunnelWebViewImpl(makeWebViewProxy(context, prefs));
    }

    public WebViewProxy makeWebViewProxy(Context context, TunnelPreferences prefs) {
        return TunnelWebViewImpl.createWebViewProxy(context, prefs);
    }

    /**
     * 解析xml文件,读取配置
     */
    public void loadConfig() {
        configXmlParser = new ConfigXmlParser();
        configXmlParser.parse(mContext);
        mPreferences = configXmlParser.getPreferences();
        mPluginEntries = configXmlParser.getPluginEntries();
    }

    public View getRealWebView() {
        return mWebView.getRealWebView();
    }
}
