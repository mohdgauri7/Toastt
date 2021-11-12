// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.NonNull;

public final class bd
{
    final byte a;
    @NonNull
    final String b;
    
    public bd(final byte a, @NonNull final String b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof bd)) {
            return false;
        }
        final bd bd = (bd)o;
        return this.a == bd.a && this.b.equals(bd.b);
    }
    
    @Override
    public final int hashCode() {
        return 31 * this.a + this.b.hashCode();
    }
}
