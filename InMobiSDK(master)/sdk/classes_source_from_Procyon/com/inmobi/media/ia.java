// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

public final class ia
{
    private String a;
    private Class<?> b;
    
    public ia(@NonNull final String a, @NonNull final Class<?> b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final int hashCode() {
        return this.a.hashCode() + this.b.getName().hashCode();
    }
    
    @Override
    public final boolean equals(@Nullable final Object o) {
        if (o instanceof ia) {
            final ia ia = (ia)o;
            return this.a.equals(ia.a) && this.b == ia.b;
        }
        return false;
    }
}
