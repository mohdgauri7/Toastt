// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Iterator;
import org.json.JSONException;
import java.util.Map;
import org.json.JSONObject;
import java.util.HashMap;
import android.content.ContentValues;

public class az
{
    private static final String b;
    static final String[] a;
    
    az() {
        final gt a;
        (a = gt.a()).a("click", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, pending_attempts INTEGER NOT NULL, url TEXT NOT NULL, ping_in_webview TEXT NOT NULL, follow_redirect TEXT NOT NULL, ts TEXT NOT NULL, track_extras TEXT, created_ts TEXT NOT NULL )");
        a.b();
    }
    
    public static boolean a() {
        return 0 == gt.a().a("click");
    }
    
    public final synchronized void a(final ay ay, final int n) {
        final ContentValues b = b(ay);
        final gt a;
        if ((a = gt.a()).a("click") >= n) {
            a(a(a.a("click", az.a, "ts= (SELECT MIN(ts) FROM click LIMIT 1)", null, null, null, null, null).get(0)));
        }
        a.a("click", b);
        a.b();
    }
    
    public static void a(final ay ay) {
        final gt a = gt.a();
        a.a("click", "id = ?", new String[] { String.valueOf(ay.a) });
        a.b();
    }
    
    static ay a(final ContentValues contentValues) {
        final int intValue = contentValues.getAsInteger("id");
        final int intValue2 = contentValues.getAsInteger("pending_attempts");
        final String asString = contentValues.getAsString("url");
        final long longValue = Long.valueOf(contentValues.getAsString("ts"));
        final long longValue2 = Long.valueOf(contentValues.getAsString("created_ts"));
        final boolean booleanValue = Boolean.valueOf(contentValues.getAsString("follow_redirect"));
        final boolean booleanValue2 = Boolean.valueOf(contentValues.getAsString("ping_in_webview"));
        final String asString2 = contentValues.getAsString("track_extras");
        final HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        if (asString2 != null) {
            try {
                hashMap.putAll(a(new JSONObject(asString2)));
            }
            catch (JSONException ex) {}
            catch (Exception ex2) {}
        }
        return new ay(intValue, asString, (Map<String, String>)hashMap, booleanValue, booleanValue2, intValue2, longValue, longValue2);
    }
    
    static ContentValues b(final ay ay) {
        final ContentValues contentValues;
        (contentValues = new ContentValues()).put("id", Integer.valueOf(ay.a));
        contentValues.put("url", ay.b);
        contentValues.put("pending_attempts", Integer.valueOf(ay.f));
        contentValues.put("ts", Long.toString(ay.d));
        contentValues.put("created_ts", Long.toString(ay.e));
        contentValues.put("follow_redirect", Boolean.toString(ay.i));
        contentValues.put("ping_in_webview", Boolean.toString(ay.h));
        if (ay.c != null && ay.c.size() > 0) {
            contentValues.put("track_extras", new JSONObject((Map)ay.c).toString());
        }
        return contentValues;
    }
    
    private static Map<String, String> a(final JSONObject jsonObject) throws JSONException {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        final Iterator keys = jsonObject.keys();
        while (keys.hasNext()) {
            final String s = keys.next();
            hashMap.put(s, (String)jsonObject.get(s));
        }
        return hashMap;
    }
    
    static {
        b = az.class.getSimpleName();
        a = new String[] { "id", "pending_attempts", "url", "ping_in_webview", "follow_redirect", "ts", "created_ts", "track_extras" };
    }
}
