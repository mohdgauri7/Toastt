// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.UiThread;
import java.util.TimerTask;
import android.annotation.SuppressLint;
import java.util.Timer;
import java.util.HashMap;

public class cu
{
    private static final String a;
    private ct b;
    private HashMap<Byte, Timer> c;
    private static byte d;
    
    @SuppressLint({ "UseSparseArrays" })
    public cu(final ct b) {
        this.c = new HashMap<Byte, Timer>();
        this.b = b;
    }
    
    @UiThread
    public final boolean a(final byte b, final long delay) {
        if (this.c.containsKey(b)) {
            this.a(b);
        }
        try {
            final Timer value = new Timer(cu.a);
            this.c.put(b, value);
            value.schedule(new TimerTask() {
                @Override
                public final void run() {
                    cu.a(cu.this, b);
                }
            }, delay);
            return true;
        }
        catch (OutOfMemoryError outOfMemoryError) {
            hf.a((byte)1, cu.a, "Could not execute timer due to OutOfMemory.");
            this.b.d(b);
            return false;
        }
    }
    
    @UiThread
    public final void a(final byte b) {
        final Timer timer;
        if ((timer = this.c.get(b)) != null) {
            timer.cancel();
            this.c.remove(b);
        }
    }
    
    static /* synthetic */ void a(final cu cu, final byte b) {
        new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
            @Override
            public final void run() {
                cu.this.b.c(b);
            }
        });
    }
    
    static {
        a = cu.class.getSimpleName();
        cu.d = -1;
    }
}
