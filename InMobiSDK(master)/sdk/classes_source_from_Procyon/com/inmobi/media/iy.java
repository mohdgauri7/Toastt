// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.HashMap;
import org.json.JSONObject;
import androidx.annotation.WorkerThread;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import com.inmobi.unifiedId.InMobiUnifiedIdInterface;
import java.util.Set;

public final class iy
{
    private static final Object c;
    @NonNull
    static Set<InMobiUnifiedIdInterface> a;
    @Nullable
    static ja b;
    
    private iy() {
    }
    
    @WorkerThread
    public static void a() {
        synchronized (iy.c) {
            if (c()) {
                iy.b.b();
            }
        }
        e();
    }
    
    @WorkerThread
    private static void e() {
        ii.a();
        final ft.c f = ii.f();
        synchronized (iy.c) {
            final String s = "POST";
            final String url = f.url;
            ii.a();
            iy.b = new ja(s, url, ii.d(), gz.f(), f.maxRetries, f.retryInterval, f.timeout);
            final gi gi = new gi((gj<T>)new iz(iy.b, iy.a), iy.b, (Class<T>)JSONObject.class);
            gw.a().a("UnifiedIdNetworkCallRequested", new HashMap<String, Object>());
            gi.a();
        }
    }
    
    @WorkerThread
    public static void a(@Nullable final InMobiUnifiedIdInterface inMobiUnifiedIdInterface) {
        if (inMobiUnifiedIdInterface != null) {
            iy.a.add(inMobiUnifiedIdInterface);
        }
        if (c()) {
            return;
        }
        e();
    }
    
    @WorkerThread
    public static void b() {
        synchronized (iy.c) {
            if (iy.b != null) {
                iy.b.b();
                iy.b = null;
            }
            iy.a.clear();
        }
    }
    
    public static boolean c() {
        synchronized (iy.c) {
            return iy.b != null && !iy.b.a.get();
        }
    }
    
    protected static void d() {
        synchronized (iy.c) {
            iy.b = null;
        }
    }
    
    static {
        c = new Object();
        iy.a = new LinkedHashSet<InMobiUnifiedIdInterface>();
    }
}
