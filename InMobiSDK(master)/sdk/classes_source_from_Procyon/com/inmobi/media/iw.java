// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import android.content.Context;
import org.json.JSONException;
import androidx.annotation.Nullable;
import org.json.JSONObject;

public final class iw
{
    private static final Object a;
    private static final Object b;
    private static boolean c;
    private static boolean d;
    @Nullable
    private static JSONObject e;
    @Nullable
    private static JSONObject f;
    
    @Nullable
    public static JSONObject a() {
        synchronized (iw.a) {
            if (iw.c) {
                return iw.e;
            }
            iw.c = true;
            final String b;
            if ((b = gu.a(gz.c(), "unified_id_info_store").b("ufids")) == null) {
                return null;
            }
            try {
                iw.e = new JSONObject(b);
            }
            catch (JSONException ex) {}
            return iw.e;
        }
    }
    
    @WorkerThread
    public static void a(@Nullable final JSONObject e) {
        synchronized (iw.a) {
            iw.e = e;
            iw.c = true;
            final Context c;
            if ((c = gz.c()) != null) {
                if (iw.e == null) {
                    gu.a(c, "unified_id_info_store").e("ufids");
                }
                else {
                    gu.a(c, "unified_id_info_store").a("ufids", iw.e.toString());
                }
            }
        }
    }
    
    @WorkerThread
    public static synchronized void b(@Nullable final JSONObject f) {
        synchronized (iw.b) {
            iw.f = f;
            iw.d = true;
            final Context c;
            if ((c = gz.c()) != null) {
                if (iw.f == null) {
                    gu.a(c, "unified_id_info_store").e("publisher_provided_unified_id");
                }
                else {
                    gu.a(c, "unified_id_info_store").a("publisher_provided_unified_id", iw.f.toString());
                }
            }
        }
    }
    
    @Nullable
    public static JSONObject b() {
        synchronized (iw.b) {
            if (iw.d) {
                return iw.f;
            }
            iw.d = true;
            final String b;
            if ((b = gu.a(gz.c(), "unified_id_info_store").b("publisher_provided_unified_id")) == null) {
                return null;
            }
            try {
                iw.f = new JSONObject(b);
            }
            catch (JSONException ex) {}
            return iw.f;
        }
    }
    
    public static void c() {
        a();
        b();
    }
    
    @VisibleForTesting(otherwise = 4)
    public static void d() {
        iw.d = false;
        iw.c = false;
        a(null);
        b(null);
    }
    
    static {
        a = new Object();
        b = new Object();
        iw.c = false;
        iw.d = false;
        iw.e = null;
        iw.f = null;
    }
}
