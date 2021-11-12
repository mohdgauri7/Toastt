// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.WorkerThread;
import java.util.Iterator;
import androidx.annotation.NonNull;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class go extends gm
{
    private static final String d;
    public AtomicBoolean a;
    int b;
    int c;
    private Map<String, String> e;
    
    protected go(final String s, final String s2, final id id, @NonNull final String v, final int b, final int c, final String s3) {
        super(s, s2, false, id, hq.f(), s3);
        this.a = new AtomicBoolean(false);
        this.b = 1;
        this.c = 30;
        this.b = b;
        this.c = c;
        this.v = v;
        this.e = null;
    }
    
    @WorkerThread
    @Override
    public void a() {
        super.a();
        if (this.e != null) {
            for (final Map.Entry<String, String> entry : this.e.entrySet()) {
                if (!this.g.containsKey(entry.getKey())) {
                    this.g.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }
    
    public final void b() {
        this.a.compareAndSet(false, true);
    }
    
    static {
        d = fl.class.getSimpleName();
    }
}
