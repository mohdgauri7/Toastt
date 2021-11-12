// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.UiThread;
import androidx.annotation.NonNull;

abstract class ai<T> extends v<t>
{
    ai(@NonNull final t t, final byte b) {
        super(t, b);
    }
    
    @UiThread
    abstract void a(final T p0);
    
    final void b(final T t) {
        new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
            @Override
            public final void run() {
                ai.this.a(t);
            }
        });
    }
}
