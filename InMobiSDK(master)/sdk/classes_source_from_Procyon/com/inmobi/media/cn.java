// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import org.json.JSONException;
import org.json.JSONObject;

public class cn
{
    public boolean a;
    public String b;
    public String c;
    public String d;
    private static String e;
    
    public cn() {
        this.b = "none";
        this.c = "right";
        this.a = true;
        this.d = null;
    }
    
    public static cn a(final String d, final cn cn) {
        cn cn2;
        (cn2 = new cn()).d = d;
        try {
            final JSONObject jsonObject = new JSONObject(d);
            cn2.b = jsonObject.optString("forceOrientation", cn.b);
            cn2.a = jsonObject.optBoolean("allowOrientationChange", cn.a);
            cn2.c = jsonObject.optString("direction", cn.c);
            if (!cn2.b.equals("portrait") && !cn2.b.equals("landscape")) {
                cn2.b = "none";
            }
            if (!cn2.c.equals("left") && !cn2.c.equals("right")) {
                cn2.c = "right";
            }
        }
        catch (JSONException ex) {
            cn2 = null;
        }
        return cn2;
    }
    
    static {
        cn.e = cn.class.getSimpleName();
    }
}
