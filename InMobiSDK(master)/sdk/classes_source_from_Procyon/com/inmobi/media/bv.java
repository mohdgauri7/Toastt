// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class bv
{
    private static final String g;
    protected String a;
    public String b;
    protected int c;
    public String d;
    public Map<String, String> e;
    public Map<String, Object> f;
    
    public bv(final String s, final int n, final String s2, final Map<String, String> map) {
        this("url_ping", s, n, s2, map);
    }
    
    private bv(final String a, final String s, final int c, final String d, final Map<String, String> e) {
        this.e = new HashMap<String, String>();
        this.a = a;
        this.b = s.trim();
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public static String a(final String s) {
        if (s == null || 0 == s.length()) {
            return "unknown";
        }
        switch (s) {
            default: {
                return "unknown";
            }
            case "load": {
                return "load";
            }
            case "client_fill": {
                return "client_fill";
            }
            case "Impression": {
                return "Impression";
            }
            case "VideoImpression": {
                return "VideoImpression";
            }
            case "page_view": {
                return "page_view";
            }
            case "click": {
                return "click";
            }
            case "start": {
                return "start";
            }
            case "firstQuartile": {
                return "firstQuartile";
            }
            case "midpoint": {
                return "midpoint";
            }
            case "thirdQuartile": {
                return "thirdQuartile";
            }
            case "complete": {
                return "complete";
            }
            case "creativeView": {
                return "creativeView";
            }
            case "fullscreen": {
                return "fullscreen";
            }
            case "exitFullscreen": {
                return "exitFullscreen";
            }
            case "mute": {
                return "mute";
            }
            case "unmute": {
                return "unmute";
            }
            case "pause": {
                return "pause";
            }
            case "resume": {
                return "resume";
            }
            case "error": {
                return "error";
            }
            case "OMID_VIEWABILITY": {
                return "OMID_VIEWABILITY";
            }
            case "zMoatVASTIDs": {
                return "zMoatVASTIDs";
            }
            case "closeEndCard": {
                return "closeEndCard";
            }
        }
    }
    
    @Override
    public String toString() {
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("type", (Object)this.a);
            jsonObject.put("url", (Object)this.b);
            jsonObject.put("eventType", (Object)this.d);
            jsonObject.put("eventId", this.c);
            jsonObject.put("extras", (Object)hg.a((this.e == null) ? new HashMap<String, String>() : this.e, ","));
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
            return "";
        }
        return jsonObject.toString();
    }
    
    static {
        g = bv.class.getSimpleName();
    }
}
