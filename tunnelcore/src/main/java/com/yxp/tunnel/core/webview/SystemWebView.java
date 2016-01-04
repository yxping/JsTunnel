package com.yxp.tunnel.core.webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * Created by yanxing on 15/12/21.
 */
public class SystemWebView extends WebView{
    public final static String TAG = "SystemWebView";

    public SystemWebView(Context context) {
        super(context);
        init(context);
    }

    public SystemWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SystemWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SystemWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public void init(Context context) {
        this.setWebChromeClient(new SystemWebChromeClient());
        this.setWebViewClient(new SystemWebViewClient());
    }
}
