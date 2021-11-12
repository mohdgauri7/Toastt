// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.NonNull;
import com.inmobi.commons.utils.json.Constructor;
import java.util.List;

public final class hx<E> extends hz<List<E>>
{
    private Class<E> a;
    
    public hx(@NonNull final Constructor<List<E>> constructor, @NonNull final Class<E> a) {
        super(constructor);
        this.a = a;
    }
    
    public final List<E> a() {
        return (List<E>)this.b.construct();
    }
    
    public final Class<E> b() {
        return this.a;
    }
}
