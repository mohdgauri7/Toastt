// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.Executors;
import java.util.LinkedList;
import androidx.annotation.NonNull;
import java.util.concurrent.ScheduledExecutorService;
import java.util.List;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class gc implements ge
{
    private static final String f;
    public AtomicBoolean a;
    public AtomicBoolean b;
    private ga g;
    private gf h;
    public HashMap<String, fz> c;
    public List<String> d;
    public ScheduledExecutorService e;
    
    public gc(@NonNull final ga g, @NonNull final gf h, @NonNull final fz fz) {
        this.g = g;
        this.h = h;
        this.a = new AtomicBoolean(false);
        this.b = new AtomicBoolean(false);
        this.d = new LinkedList<String>();
        this.c = new HashMap<String, fz>(1);
        this.a(fz);
    }
    
    public final void a(@NonNull final fz value) {
        String b;
        if ((b = value.b) == null) {
            b = "default";
        }
        this.c.put(b, value);
    }
    
    public final void a(@NonNull final String s, final boolean b) {
        if (this.b.get()) {
            return;
        }
        this.a(s, this.b(s).f, b);
    }
    
    private void a(@NonNull final String s, final long n, final boolean b) {
        if (!this.d.contains(s)) {
            this.d.add(s);
            if (this.e == null) {
                this.e = Executors.newSingleThreadScheduledExecutor(new he(gc.f));
            }
            this.e.scheduleAtFixedRate(new Runnable() {
                final /* synthetic */ id b;
                
                @Override
                public final void run() {
                    gc.a(gc.this, s, this.b, b);
                }
            }, this.a(s), n, TimeUnit.SECONDS);
        }
    }
    
    private long a(@NonNull final String s) {
        final fz b = this.b(s);
        final long c;
        if ((c = this.g.c()) == -1L) {
            this.g.c(System.currentTimeMillis());
        }
        final long n;
        if ((n = TimeUnit.MILLISECONDS.toSeconds(c) + b.f) - TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) > 0L) {
            return n - TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        }
        return 0L;
    }
    
    @NonNull
    private fz b(@NonNull final String key) {
        return this.c.get(key);
    }
    
    @Override
    public final void a(final gb gb) {
        gb.a.get(0);
        this.g.a(gb.a);
        this.g.c(System.currentTimeMillis());
        this.a.set(false);
    }
    
    @Override
    public final void a(final gb gb, final boolean b) {
        gb.a.get(0);
        if (gb.c && b) {
            this.g.a(gb.a);
        }
        this.g.c(System.currentTimeMillis());
        this.a.set(false);
    }
    
    static /* synthetic */ void a(final gc gc, final String s, final id id, final boolean b) {
        if (gc.b.get() || gc.a.get()) {
            return;
        }
        gc.g.b(gc.b(s).a);
        final int a = gc.g.a();
        final int a2 = hn.a();
        int n = 0;
        switch (a2) {
            case 1: {
                n = gc.b(s).g;
                break;
            }
            default: {
                n = gc.b(s).i;
                break;
            }
        }
        final int n2 = n;
        long n3 = 0L;
        switch (a2) {
            case 1: {
                n3 = gc.b(s).h;
                break;
            }
            default: {
                n3 = gc.b(s).j;
                break;
            }
        }
        final long n4 = n3;
        final gb c;
        if ((n2 <= a || gc.g.a(gc.b(s).c) || gc.g.a(gc.b(s).f, gc.b(s).c)) && (c = gc.h.c()) != null) {
            gc.a.set(true);
            final fz b2 = gc.b(s);
            final gd a3 = gd.a();
            final gb gb = c;
            final String e = b2.e;
            final int n5 = b2.d + 1;
            a3.a(gb, e, n5, n5, n4, id, gc, b);
        }
    }
    
    static {
        f = gc.class.getSimpleName();
    }
}
