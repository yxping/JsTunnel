package com.yxp.tunnel.core;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by yanxing on 15/12/29.
 */
public class TunnelPlugin {
    public final static String TAG = "TunnelPlugin";
    protected Context context;

    public final void init(Context context) {
        this.context = context;
    }

    public void pluginInit() {

    }

    public boolean exec(String action, String arguments) {
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(arguments);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jsonArray != null) {
            return exec(action, jsonArray);
        } else {
            return false;
        }
    }

    public boolean exec(String action, JSONArray arguments) {
        return  true;
    }
}
