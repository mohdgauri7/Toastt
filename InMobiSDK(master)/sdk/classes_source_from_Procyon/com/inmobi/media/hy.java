// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.NonNull;
import com.inmobi.commons.utils.json.Constructor;
import java.util.Map;

public final class hy<K, V> extends hz<Map<K, V>>
{
    public Class<V> a;
    
    public hy(@NonNull final Constructor<Map<K, V>> constructor, @NonNull final Class<V> a) {
        super(constructor);
        this.a = a;
    }
}
