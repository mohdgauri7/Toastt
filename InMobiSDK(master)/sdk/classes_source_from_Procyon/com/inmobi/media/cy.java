// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.LinkedBlockingQueue;
import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.Executor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;

final class cy
{
    private static final String e;
    private final CountDownLatch f;
    gm a;
    WeakReference<cx> b;
    long c;
    private static final int g;
    private static final int h;
    private static final int i;
    private static final ThreadFactory j;
    private static final BlockingQueue<Runnable> k;
    public static final Executor d;
    
    public cy(final cx referent, final int m, final CountDownLatch f) {
        this.c = 0L;
        this.a = new gm("GET", referent.a);
        this.a.q = false;
        this.a.w = false;
        this.a.m = m;
        this.b = new WeakReference<cx>(referent);
        this.f = f;
    }
    
    final void a() {
        if (this.f != null) {
            this.f.countDown();
        }
    }
    
    public final void a(final gn gn) {
        try {
            ih.a().a(this.a.h());
            ih.a().b(gn.d());
        }
        catch (Exception ex) {}
        finally {
            this.a();
        }
    }
    
    static {
        e = cy.class.getSimpleName();
        g = Runtime.getRuntime().availableProcessors();
        h = Math.max(2, Math.min(cy.g - 1, 4));
        i = cy.g * 2 + 1;
        j = new ThreadFactory() {
            private final AtomicInteger a = new AtomicInteger(1);
            
            @Override
            public final Thread newThread(@NonNull final Runnable target) {
                return new Thread(target, "VastNetworkTask #" + this.a.getAndIncrement());
            }
        };
        k = new LinkedBlockingQueue<Runnable>(128);
        final ThreadPoolExecutor d2;
        (d2 = new ThreadPoolExecutor(cy.h, cy.i, 30L, TimeUnit.SECONDS, cy.k, cy.j)).allowCoreThreadTimeOut(true);
        d = d2;
    }
}
