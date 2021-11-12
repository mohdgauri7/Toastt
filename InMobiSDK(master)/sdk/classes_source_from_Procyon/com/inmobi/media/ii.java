// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.NonNull;
import android.location.LocationListener;
import android.os.SystemClock;
import java.util.UUID;

public class ii
{
    private static final String a;
    private if b;
    private boolean c;
    
    private ii() {
    }
    
    public static ii a() {
        return ii.a.a;
    }
    
    public final synchronized void b() {
        fg.a("signals", gz.f(), null);
        final ht a = ht.a();
        final boolean sessionEnabled = e().sessionEnabled;
        final ht ht = a;
        a.d = sessionEnabled;
        if (!ht.d) {
            final ht ht2;
            (ht2 = ht).a = null;
            ht2.b = 0L;
            ht2.c = 0L;
        }
        final ih a2 = ih.a();
        final ii a3 = ii.a.a;
        if (e().sessionEnabled) {
            com.inmobi.media.ht.a().a = UUID.randomUUID().toString();
            com.inmobi.media.ht.a().b = System.currentTimeMillis();
            com.inmobi.media.ht.a().c = 0L;
            a2.f = SystemClock.elapsedRealtime();
            a2.a = 0L;
            a2.b = 0L;
            a2.c = 0L;
            a2.d = 0L;
            a2.e = 0L;
            a2.f = 0L;
        }
        if (h()) {
            this.i();
        }
        if (g()) {
            ig.a().b();
        }
    }
    
    public final synchronized void c() {
        ih.a();
        ih.b();
        if (this.c) {
            this.c = false;
            if (this.b != null) {
                final if b;
                (b = this.b).a.a = true;
                final if.a a = b.a;
                final int n = 2;
                final ii a2 = ii.a.a;
                a.sendEmptyMessageDelayed(n, (long)(e().stopRequestTimeout * 1000));
            }
        }
        final ig a3 = ig.a();
        if (ig.c()) {
            if (a3.a != null) {
                a3.a.removeUpdates((LocationListener)a3);
            }
            if (a3.b != null) {
                a3.b.disconnect();
            }
        }
        a3.b = null;
    }
    
    public static id d() {
        return new id(((ft)fg.a("signals", gz.f(), null)).f());
    }
    
    public static ft.b a(final String s) {
        return ((ft)fg.a("signals", s, null)).ice;
    }
    
    public static ft.b e() {
        return ((ft)fg.a("signals", gz.f(), null)).ice;
    }
    
    @NonNull
    public static ft.c f() {
        return ((ft)fg.a("signals", gz.f(), null)).unifiedIdServiceConfig;
    }
    
    private synchronized void i() {
        if (this.c) {
            return;
        }
        this.c = true;
        if (this.b == null) {
            this.b = new if();
        }
        this.b.a();
    }
    
    static boolean g() {
        final String m = gz.m();
        final ip c;
        final String s = ((c = ir.c()) != null) ? c.e() : null;
        final boolean b = c != null && c.d();
        final boolean b2 = m == null || a(m).locationEnabled;
        final boolean b3 = s == null || c.a();
        final boolean b4 = !b || a(s).locationEnabled;
        return b2 && b3 && b4;
    }
    
    public static boolean h() {
        final String m = gz.m();
        final ip c;
        final String s = ((c = ir.c()) != null) ? c.e() : null;
        final boolean b = c != null && c.d();
        final boolean b2 = m == null || a(m).w.vwe;
        final boolean b3 = s == null || c.b();
        final boolean b4 = !b || a(s).w.vwe;
        return b2 && b3 && b4;
    }
    
    static {
        a = ii.class.getSimpleName();
    }
    
    static final class a
    {
        static final ii a;
        
        static {
            a = new ii((byte)0);
        }
    }
}
