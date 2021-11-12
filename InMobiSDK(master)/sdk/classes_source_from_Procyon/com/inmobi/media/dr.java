// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class dr extends ds
{
    @Nullable
    fe.m a;
    
    dr(@NonNull final a a, @Nullable final fe.m a2, final byte b) {
        super(a, b);
        this.a = a2;
    }
    
    @Override
    protected int a() {
        if (this.a == null) {
            return 100;
        }
        return this.a.visibilityThrottleMillis;
    }
    
    @Override
    protected final void b() {
        this.h();
    }
}
