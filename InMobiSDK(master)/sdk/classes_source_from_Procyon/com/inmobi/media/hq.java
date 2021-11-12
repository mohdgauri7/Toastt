// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Iterator;
import org.json.JSONException;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import android.content.SharedPreferences;
import android.content.Context;
import androidx.annotation.VisibleForTesting;
import org.json.JSONObject;

public final class hq
{
    private static final String a;
    private static JSONObject b;
    private static JSONObject c;
    private static JSONObject d;
    private static fs e;
    
    private hq() {
    }
    
    @VisibleForTesting
    public static void a() {
        hq.e = (fs)ff.a("root", gz.f());
    }
    
    @WorkerThread
    @Nullable
    public static JSONObject b() {
        final Context c;
        final SharedPreferences sharedPreferences;
        if ((c = gz.c()) != null && (sharedPreferences = c.getSharedPreferences(c.getPackageName() + "_preferences", 0)) != null) {
            final JSONObject b;
            if ((b = b(sharedPreferences)) != null) {
                return b;
            }
            final JSONObject a;
            if ((a = a(sharedPreferences)) != null) {
                return a;
            }
        }
        return i();
    }
    
    @Nullable
    private static JSONObject a(final SharedPreferences sharedPreferences) {
        Object string = null;
        Object string2 = null;
        try {
            string = sharedPreferences.getString("IABConsent_ConsentString", (String)null);
            string2 = sharedPreferences.getString("IABConsent_SubjectToGDPR", (String)null);
        }
        catch (Exception ex) {}
        if (string != null) {
            try {
                final JSONObject jsonObject;
                (jsonObject = new JSONObject()).put("gdpr_consent", string);
                if (string2 != null) {
                    jsonObject.put("gdpr", string2);
                }
                return jsonObject;
            }
            catch (JSONException ex2) {}
        }
        return null;
    }
    
    @Nullable
    private static JSONObject b(final SharedPreferences sharedPreferences) {
        Object string = null;
        int int1 = -1;
        try {
            string = sharedPreferences.getString("IABTCF_TCString", (String)null);
            int1 = sharedPreferences.getInt("IABTCF_gdprApplies", -1);
        }
        catch (Exception ex) {}
        if (string != null) {
            try {
                final JSONObject jsonObject;
                (jsonObject = new JSONObject()).put("gdpr_consent", string);
                if (-1 != int1) {
                    jsonObject.put("gdpr", (Object)String.valueOf(int1));
                }
                return jsonObject;
            }
            catch (JSONException ex2) {}
        }
        return null;
    }
    
    @Nullable
    public static JSONObject c() {
        return hq.b;
    }
    
    public static void a(@Nullable final JSONObject b) {
        if (b == null) {
            return;
        }
        hq.b = b;
    }
    
    public static void b(@Nullable final JSONObject c) {
        if (c == null) {
            return;
        }
        hq.c = c;
    }
    
    @Nullable
    private static JSONObject i() {
        if (hq.c == null) {
            return hq.b;
        }
        if (hq.b == null) {
            return hq.c;
        }
        final JSONObject jsonObject = new JSONObject();
        final Iterator keys = hq.c.keys();
        while (keys.hasNext()) {
            final String s = keys.next();
            try {
                jsonObject.put(s, hq.c.opt(s));
            }
            catch (JSONException ex) {}
        }
        final Iterator keys2 = hq.b.keys();
        while (keys2.hasNext()) {
            final String s2 = keys2.next();
            try {
                jsonObject.put(s2, hq.b.opt(s2));
            }
            catch (JSONException ex2) {}
        }
        return jsonObject;
    }
    
    @VisibleForTesting
    @WorkerThread
    public static byte d() {
        final JSONObject b;
        if ((b = b()) == null) {
            return -1;
        }
        if (!b.has("gdpr_consent")) {
            if (!b.has("gdpr_consent_available")) {
                return -1;
            }
            try {
                if (b.getBoolean("gdpr_consent_available")) {
                    return 1;
                }
                return 0;
            }
            catch (JSONException ex) {
                return -1;
            }
        }
        return 1;
    }
    
    public static void c(@Nullable final JSONObject d) {
        hq.d = d;
    }
    
    @Nullable
    public static JSONObject e() {
        return hq.d;
    }
    
    public static boolean f() {
        return a(false);
    }
    
    public static void g() {
        hq.e = (fs)fg.a("root", gz.f(), null);
    }
    
    public static boolean a(final boolean b) {
        if (hq.e == null) {
            g();
        }
        boolean b2 = false;
        final boolean j = hq.e.j();
        if (d() == 1 || j || b) {
            b2 = true;
        }
        else if (!j) {
            b2 = false;
        }
        return b2;
    }
    
    public static boolean h() {
        return f();
    }
    
    static {
        a = hq.class.getSimpleName();
    }
}
