// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.concurrent.TimeUnit;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class gd
{
    private static final String a;
    private static ScheduledExecutorService b;
    
    public static gd a() {
        return gd.a.a;
    }
    
    private gd() {
        gd.b = Executors.newSingleThreadScheduledExecutor();
    }
    
    final void a(final gb gb, final String s, final int n, final int n2, final long n3, final id id, final ge ge, final boolean b) {
        if (!hg.a() || !gz.j()) {
            ge.a(gb, false);
            return;
        }
        final gm gm = new gm("POST", s, id);
        final HashMap<String, String> hashMap;
        (hashMap = new HashMap<String, String>()).put("payload", gb.b);
        gm.c(hashMap);
        if (n - n2 > 0) {
            final HashMap<String, String> hashMap2;
            (hashMap2 = new HashMap<String, String>()).put("X-im-retry-count", String.valueOf(n - n2));
            gm.a(hashMap2);
        }
        gm.w = false;
        gm.q = false;
        long n4;
        if (b) {
            n4 = ((n2 != n) ? ((long)Math.pow(2.0, n - n2) * n3) : 0L);
        }
        else {
            n4 = ((n2 != n) ? n3 : 0L);
        }
        gd.b.schedule(new Runnable() {
            @Override
            public final void run() {
                final gn a;
                if (!(a = new gp(gm).a()).a()) {
                    ge.a(gb);
                    return;
                }
                if (n2 > 1) {
                    gd.a;
                    a.b();
                    gd.this.a(gb, s, n, n2 - 1, n3, id, ge, b);
                    return;
                }
                ge.a(gb, true);
            }
        }, n4, TimeUnit.SECONDS);
    }
    
    static {
        a = gd.class.getSimpleName();
    }
    
    static final class a
    {
        static final gd a;
        
        static {
            a = new gd((byte)0);
        }
    }
}
