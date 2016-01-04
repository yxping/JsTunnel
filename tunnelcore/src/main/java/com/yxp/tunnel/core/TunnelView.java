package com.yxp.tunnel.core;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by yanxing on 15/12/21.
 */
public class TunnelView extends FrameLayout {
    private TunnelContainer tunnelContainer;

    public TunnelView(Context context) {
        super(context);
        init(context);
    }

    public TunnelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TunnelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TunnelView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public void init(Context context) {
        tunnelContainer = new TunnelContainer(context, this);
        this.addView(tunnelContainer.getRealWebView(), new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));
    }

    public TunnelContainer getTunnelContainer() {
        return tunnelContainer;
    }
}
