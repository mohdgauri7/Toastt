// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.HashMap;
import java.util.Map;

public final class de
{
    public byte a;
    public Map<String, Object> b;
    
    public de(final byte a) {
        this.a = a;
        this.b = new HashMap<String, Object>();
    }
    
    public final <T> T a(final String s, final Class<T> clazz) {
        final Object value = this.b.get(s);
        if (clazz.isInstance(value)) {
            return clazz.cast(value);
        }
        return null;
    }
}
