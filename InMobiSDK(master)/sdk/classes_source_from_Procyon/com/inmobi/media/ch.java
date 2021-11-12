// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import org.json.JSONException;
import org.json.JSONObject;

public class ch
{
    private static final String d;
    public boolean a;
    public boolean b;
    private boolean e;
    public String c;
    
    public ch() {
        this.a = false;
        this.e = true;
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("width", ho.a().a);
            jsonObject.put("height", ho.a().b);
            jsonObject.put("useCustomClose", this.a);
            jsonObject.put("isModal", this.e);
        }
        catch (JSONException ex) {}
        this.c = jsonObject.toString();
    }
    
    public static ch a(final String c) {
        final ch ch;
        (ch = new ch()).c = c;
        try {
            final JSONObject jsonObject = new JSONObject(c);
            ch.e = true;
            if (jsonObject.has("useCustomClose")) {
                ch.b = true;
            }
            ch.a = jsonObject.optBoolean("useCustomClose", false);
        }
        catch (JSONException ex) {}
        return ch;
    }
    
    static {
        d = ch.class.getSimpleName();
    }
}
