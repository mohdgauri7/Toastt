// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.os.Looper;
import android.os.Handler;

public final class iu
{
    private static final Object a;
    private final Handler b;
    
    private iu() {
        this.b = new Handler(Looper.getMainLooper());
    }
    
    public static iu a() {
        return iu.a.a;
    }
    
    public final void a(final Runnable runnable) {
        this.b.post(runnable);
    }
    
    static {
        a = new Object();
    }
    
    static final class a
    {
        static final iu a;
        
        static {
            a = new iu((byte)0);
        }
    }
}
