// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import org.json.JSONException;
import java.util.HashMap;
import android.text.TextUtils;
import org.json.JSONObject;
import java.util.Map;

public final class ea extends bv
{
    private static final String i;
    public final String g;
    public final String h;
    
    public ea(final String h, final String g, final String s, final String s2, final Map<String, String> map) {
        super(s, 0, s2, map);
        this.h = h;
        this.g = g;
    }
    
    @Override
    public final String toString() {
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("type", (Object)super.a);
            jsonObject.put("url", (Object)super.b);
            jsonObject.put("eventType", (Object)super.d);
            jsonObject.put("eventId", super.c);
            if (!TextUtils.isEmpty((CharSequence)this.h)) {
                jsonObject.put("vendorKey", (Object)this.h);
            }
            if (!TextUtils.isEmpty((CharSequence)this.g)) {
                jsonObject.put("verificationParams", (Object)this.g);
            }
            final Map<String, String> e = (Map<String, String>)super.e;
            jsonObject.put("extras", (Object)hg.a((e == null) ? new HashMap<String, String>() : e, ","));
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
            return "";
        }
        return jsonObject.toString();
    }
    
    static {
        i = ea.class.getSimpleName();
    }
}
