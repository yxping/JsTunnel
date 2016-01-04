package com.yxp.tunnel.core.webview;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.yxp.tunnel.core.util.UrlSoruceUtil;

/**
 * Created by yanxing on 15/12/28.
 */
public class SystemWebViewClient extends WebViewClient {
    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return super.shouldOverrideUrlLoading(view, url);
    }

    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        UrlSoruceUtil soruceUtil = new UrlSoruceUtil();
        UrlSoruceUtil.Source source = soruceUtil.getSourceFromUrl(url);
        if (source != null) {
            return new WebResourceResponse(source.mimeType, "UTF-8", source.inputStream);
        }
        return super.shouldInterceptRequest(view, url);
    }
}
