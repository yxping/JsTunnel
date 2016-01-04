package com.yxp.tunnel.plugins;

import android.content.Intent;
import android.provider.MediaStore;

import com.yxp.tunnel.core.TunnelPlugin;

import org.json.JSONArray;

/**
 * Created by yanxing on 16/1/4.
 */
public class CameraPlugin extends TunnelPlugin {
    public final static String TAG = "CameraPlugin";

    @Override
    public boolean exec(String action, JSONArray arguments) {
        if (action.equals("openCamera")) {
            openCamera();
            return true;
        }
        return false;
    }

    public void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        context.startActivity(intent);
    }
}
