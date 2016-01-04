package com.yxp.tunnel.core;

import android.util.Log;

/**
 * 自定义Log日志
 * Created by yanxing on 15/12/21.
 */
public class TLOG {

    public static final int VERBOSE = Log.VERBOSE;
    public static final int DEBUG = Log.DEBUG;
    public static final int INFO = Log.INFO;
    public static final int WARN = Log.WARN;
    public static final int ERROR = Log.ERROR;
    public static final int ASSERT = Log.ASSERT;

    public static int LOG_LEVEL = ERROR;

    public static void setLogLevel(int logLevel) {
        LOG_LEVEL = logLevel;
    }

    public static int getLogLevel() {
        return LOG_LEVEL;
    }

    public static boolean isLoggable(int logLevel) {
        if (LOG_LEVEL > logLevel) {
            return false;
        }
        return true;
    }

    public static void v(String tag, String msg) {
        if (LOG_LEVEL > VERBOSE) Log.v(tag, msg);
    }

    public static void d(String tag, String msg) {
        if(LOG_LEVEL > DEBUG) Log.d(tag, msg);
    }

    public static void i(String tag, String msg) {
        if(LOG_LEVEL > INFO) Log.i(tag, msg);
    }

    public static void w(String tag, String msg) {
        if (LOG_LEVEL > WARN) Log.w(tag, msg);
    }

    public static void e(String tag, String msg) {
        if(LOG_LEVEL > ERROR) Log.e(tag, msg);
    }

    public static void v(String tag, String msg, Object... args) {
        if (LOG_LEVEL > VERBOSE) Log.v(tag, String.format(msg, args));
    }

    public static void d(String tag, String msg, Object... args) {
        if(LOG_LEVEL > DEBUG) Log.d(tag, String.format(msg, args));
    }

    public static void i(String tag, String msg, Object... args) {
        if(LOG_LEVEL > INFO) Log.i(tag, String.format(msg, args));
    }

    public static void w(String tag, String msg, Object... args) {
        if (LOG_LEVEL > WARN) Log.w(tag, String.format(msg, args));
    }

    public static void e(String tag, String msg, Object... args) {
        if(LOG_LEVEL > ERROR) Log.e(tag, String.format(msg, args));
    }

    public static void v(String tag, String msg, Throwable t) {
        if (LOG_LEVEL > VERBOSE) Log.v(tag, msg, t);
    }

    public static void d(String tag, String msg, Throwable t) {
        if(LOG_LEVEL > DEBUG) Log.d(tag, msg, t);
    }

    public static void i(String tag, String msg, Throwable t) {
        if(LOG_LEVEL > INFO) Log.i(tag, msg, t);
    }

    public static void w(String tag, String msg, Throwable t) {
        if (LOG_LEVEL > WARN) Log.w(tag, msg, t);
    }

    public static void e(String tag, String msg, Throwable t) {
        if(LOG_LEVEL > ERROR) Log.e(tag, msg, t);
    }
}
