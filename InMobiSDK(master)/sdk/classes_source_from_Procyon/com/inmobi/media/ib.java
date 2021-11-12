// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.VisibleForTesting;
import androidx.annotation.Nullable;

public final class ib
{
    String a;
    private Boolean b;
    
    @Nullable
    public final Boolean a() {
        return this.b;
    }
    
    @VisibleForTesting(otherwise = 4)
    public final void a(final Boolean b) {
        this.b = b;
    }
    
    public final String b() {
        return this.a;
    }
}
