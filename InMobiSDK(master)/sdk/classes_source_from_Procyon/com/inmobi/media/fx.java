// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.content.ContentValues;
import java.util.UUID;
import org.json.JSONException;
import android.util.Log;
import org.json.JSONObject;

public class fx
{
    private static final String g;
    int a;
    String b;
    String c;
    String d;
    long e;
    protected String f;
    
    public fx(final Thread thread, final Throwable t) {
        this("crashReporting", "CrashEvent");
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name", (Object)t.getClass().getSimpleName());
            jsonObject.put("message", (Object)t.getMessage());
            jsonObject.put("stack", (Object)Log.getStackTraceString(t));
            jsonObject.put("thread", (Object)thread.getName());
            this.f = jsonObject.toString();
        }
        catch (JSONException ex) {}
    }
    
    public fx(final String d, final String c) {
        this.b = UUID.randomUUID().toString();
        this.d = d;
        this.c = c;
        this.f = null;
        this.e = System.currentTimeMillis();
    }
    
    private fx(final String b, final String d, final String c, final String f) {
        this.b = b;
        this.d = d;
        this.c = c;
        this.f = f;
        this.e = System.currentTimeMillis();
    }
    
    public final String a() {
        if (this.f == null) {
            return "";
        }
        return this.f;
    }
    
    @Override
    public String toString() {
        return this.c + "@" + this.d + " ";
    }
    
    public static fx a(final ContentValues contentValues) {
        final fx fx;
        (fx = new fx(contentValues.getAsString("eventId"), contentValues.getAsString("componentType"), contentValues.getAsString("eventType"), contentValues.getAsString("payload"))).e = Long.valueOf(contentValues.getAsString("ts"));
        fx.a = contentValues.getAsInteger("id");
        return fx;
    }
    
    static {
        g = fx.class.getSimpleName();
    }
}
