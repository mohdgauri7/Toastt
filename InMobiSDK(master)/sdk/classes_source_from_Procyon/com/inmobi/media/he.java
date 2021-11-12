// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;

public final class he implements ThreadFactory
{
    private String a;
    
    public he(final String obj) {
        this.a = "TIM-".concat(String.valueOf(obj));
    }
    
    @Override
    public final Thread newThread(@NonNull final Runnable target) {
        return new Thread(target, this.a);
    }
}
