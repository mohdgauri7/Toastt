// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import java.util.Queue;
import android.os.Looper;
import androidx.annotation.NonNull;
import android.os.Handler;
import java.lang.ref.WeakReference;

public abstract class v<T> implements Runnable
{
    private static final String a;
    WeakReference<T> f;
    private Handler b;
    private byte c;
    
    protected v(@NonNull final T referent, final byte c) {
        this.c = -1;
        this.c = c;
        this.f = new WeakReference<T>(referent);
        this.b = new Handler(Looper.getMainLooper());
    }
    
    @WorkerThread
    @Override
    public final void run() {
        this.a();
        this.b.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                final Object value;
                if ((value = v.this.f.get()) != null) {
                    final hb a = hb.a();
                    final int hashCode = value.hashCode();
                    final hb hb = a;
                    final Queue queue;
                    if ((queue = (Queue)a.a.get(hashCode)) != null) {
                        queue.poll();
                        final v v = queue.peek();
                        if (queue.size() > 0 && v != null) {
                            hb.a(v);
                        }
                        if (queue.size() == 0) {
                            hb.a.remove(hashCode);
                        }
                    }
                }
            }
        });
    }
    
    public abstract void a();
    
    @UiThread
    @CallSuper
    public void b() {
        hf.a((byte)1, v.a, "Could not execute runnable due to OutOfMemory.");
        final Object value;
        if ((value = this.f.get()) != null) {
            hb.a().a(value.hashCode());
        }
    }
    
    static {
        a = v.class.getSimpleName();
    }
}
