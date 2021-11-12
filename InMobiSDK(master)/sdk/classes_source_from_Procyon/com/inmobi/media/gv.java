// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import org.json.JSONException;
import android.util.Log;
import org.json.JSONObject;

public final class gv extends fx
{
    private static final String g;
    
    public gv(final Throwable t) {
        super("crashReporting", "catchEvent");
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name", (Object)t.getClass().getSimpleName());
            jsonObject.put("message", (Object)t.getMessage());
            jsonObject.put("stack", (Object)Log.getStackTraceString(t));
            jsonObject.put("thread", (Object)Thread.currentThread().getName());
            super.f = jsonObject.toString();
        }
        catch (JSONException ex) {}
    }
    
    static {
        g = gy.class.getSimpleName();
    }
}
