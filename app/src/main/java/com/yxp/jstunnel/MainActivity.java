package com.yxp.jstunnel;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import com.yxp.tunnel.core.AndroidTunnel;
import com.yxp.tunnel.core.TunnelView;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new TunnelView(this));
    }
}
