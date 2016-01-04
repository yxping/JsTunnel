package com.yxp.tunnel.core.util;

import android.content.Context;

import com.yxp.tunnel.core.PluginEntry;
import com.yxp.tunnel.core.TLOG;
import com.yxp.tunnel.core.TunnelPreferences;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 解析config.xml
 * Created by yanxing on 15/12/21.
 */
public class ConfigXmlParser {
    public final static String TAG = "ConfigXmlParser";

    // 存储confing的配置信息
    private TunnelPreferences mPreferences = new TunnelPreferences();

    // 存储插件的入口信息
    private ArrayList<PluginEntry> mPluginEntries = new ArrayList<PluginEntry>();

    public void parse(Context context) {
        // 检查当前的类的工程包下是否含有config.xml
        int id = context.getResources().getIdentifier("config", "xml", context.getClass().getPackage().getName());
        if (id == 0) {
            // 检查当前工程下是否含有config.xml
            id = context.getResources().getIdentifier("config", "xml", context.getPackageName());
            if (id == 0) {
                TLOG.e(TAG, "res/xml/config.xml is missed");
                return;
            }
        }
        parse(context.getResources().getXml(id));
    }

    /**
     * 解析config.xml
     *
     * @param parser
     */
    public void parse(XmlPullParser parser) {
        try {
            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String str = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        handleStartTag(parser);
                        break;
                    case XmlPullParser.END_TAG:
                        handleEndTag(parser);
                        break;
                    default:
                        break;
                }
                eventType = parser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 遇到xml中的开始标签进行处理
     *
     * @param xml
     */
    public void handleStartTag(XmlPullParser xml) {
        String str = xml.getName();
        // 存储config.xml中preference的设置
        if (str.equals("preference")) {
            String name = xml.getAttributeValue(null, "name");
            String value = xml.getAttributeValue(null, "value");
            mPreferences.put(name, value);
        } else if (str.equals("plugin")) {
            String name = xml.getAttributeValue(null, "name");
            String path = xml.getAttributeValue(null, "value");
            mPluginEntries.add(new PluginEntry(name, path));
        }
    }

    /**
     * 遇到xml中的结束标签进行处理
     *
     * @param xml
     */
    public void handleEndTag(XmlPullParser xml) {

    }

    public TunnelPreferences getPreferences() {
        return mPreferences;
    }

    public ArrayList<PluginEntry> getPluginEntries() {
        return mPluginEntries;
    }

}
