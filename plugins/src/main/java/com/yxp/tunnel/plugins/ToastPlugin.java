package com.yxp.tunnel.plugins;

import android.widget.Toast;

import com.yxp.tunnel.core.TunnelPlugin;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by yanxing on 15/12/29.
 */
public class ToastPlugin extends TunnelPlugin {
    public final static String TAG = "ToastPlugin";

    @Override
    public boolean exec(String action, JSONArray arguments) {
        try {
            Toast.makeText(context, arguments.getString(0), Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }
}
