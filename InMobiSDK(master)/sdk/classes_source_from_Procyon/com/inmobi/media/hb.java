// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.LinkedList;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.ExecutorService;
import java.util.Queue;
import android.util.SparseArray;

public class hb
{
    private static final String b;
    public SparseArray<Queue<v>> a;
    private final ExecutorService c;
    @VisibleForTesting
    private byte d;
    
    private hb() {
        this.d = -1;
        this.a = (SparseArray<Queue<v>>)new SparseArray();
        final fe fe = (fe)fg.a("ads", gz.f(), null);
        final ThreadPoolExecutor c;
        (c = new ThreadPoolExecutor(fe.maxPoolSize, fe.maxPoolSize, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new he(hb.b + "-AD"))).allowCoreThreadTimeOut(true);
        this.c = c;
    }
    
    @UiThread
    public static hb a() {
        return a.a;
    }
    
    @UiThread
    public final void a(final int n, @NonNull final v v) {
        Queue<v> queue;
        if ((queue = (Queue<v>)this.a.get(n)) == null) {
            queue = new LinkedList<v>();
            this.a.put(n, (Object)queue);
        }
        queue.add(v);
        final v v2 = queue.peek();
        if (queue.size() == 1 && v2 != null) {
            this.a(v2);
        }
    }
    
    @UiThread
    public final void a(@NonNull final v v) {
        try {
            this.c.execute(v);
        }
        catch (OutOfMemoryError outOfMemoryError) {
            v.b();
        }
    }
    
    @UiThread
    public final void a(final int n) {
        this.a.remove(n);
        this.a.size();
    }
    
    static {
        b = hb.class.getSimpleName();
    }
    
    static final class a
    {
        static final hb a;
        
        static {
            a = new hb((byte)0);
        }
    }
}
