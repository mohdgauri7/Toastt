// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.NonNull;
import com.inmobi.commons.utils.json.Constructor;

public abstract class hz<T>
{
    public Constructor<T> b;
    
    hz(@NonNull final Constructor<T> b) {
        this.b = b;
    }
}
