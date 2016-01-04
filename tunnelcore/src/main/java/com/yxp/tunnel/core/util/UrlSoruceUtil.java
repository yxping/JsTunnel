package com.yxp.tunnel.core.util;

import android.content.ContentResolver;
import android.net.Uri;

import java.io.InputStream;

/**
 * Created by yanxing on 15/12/29.
 */
public class UrlSoruceUtil {
    public final static int URI_TYPE_UNKOWN = -1;
    public final static int URI_TYPE_ASSETS = 0;
    public final static int URI_TYPE_CONTENT = 1;
    public final static int URI_TYPE_ANDORID_RESOURCE = 2;
    public final static int URI_TYPE_FILE = 3;
    public final static int URI_TYPE_HTTP = 4;
    public final static int URI_TYPE_HTTPS = 5;
    public final static int URI_TYPE_DATA = 6;

    public Source getSourceFromUrl(String url) {
        Uri uri = Uri.parse(url);
        switch (getUriType(uri)) {
            case URI_TYPE_ANDORID_RESOURCE:
                break;
            case URI_TYPE_ASSETS:
                break;
            case URI_TYPE_CONTENT:
                break;
            case URI_TYPE_HTTP:
                break;
            case URI_TYPE_DATA:
                break;
            case URI_TYPE_HTTPS:
                break;
            case URI_TYPE_FILE:
                break;
            case URI_TYPE_UNKOWN:
            default:
                break;
        }
        return null;
    }

    public int getUriType(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme.equalsIgnoreCase(ContentResolver.SCHEME_FILE)) {
            if (uri.getPath().startsWith("/android_asset/")) {
                return URI_TYPE_ASSETS;
            }
            return URI_TYPE_FILE;
        } else if (scheme.equalsIgnoreCase(ContentResolver.SCHEME_ANDROID_RESOURCE)) {
            return URI_TYPE_ANDORID_RESOURCE;
        } else if (scheme.equalsIgnoreCase(ContentResolver.SCHEME_CONTENT)) {
            return URI_TYPE_CONTENT;
        } else if (scheme.equalsIgnoreCase("http")) {
            return URI_TYPE_HTTP;
        } else if (scheme.equalsIgnoreCase("https")) {
            return URI_TYPE_HTTPS;
        } else if (scheme.equalsIgnoreCase("data")) {
            return URI_TYPE_DATA;
        }
        return URI_TYPE_UNKOWN;
    }

    public final class Source {
        public final InputStream inputStream;
        public final Uri uri;
        public final String mimeType;

        public Source(Uri uri, InputStream inputStream, String mimeType) {
            this.inputStream = inputStream;
            this.uri = uri;
            this.mimeType = mimeType;
        }
    }
}
