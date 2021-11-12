// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

public final class dl extends dr
{
    public dl(@NonNull final ds.a a, @Nullable final fe.m m, final byte b) {
        super(a, m, b);
    }
    
    @Override
    protected final int a() {
        if (this.a == null) {
            return 1000;
        }
        return this.a.web.impressionPollIntervalMillis;
    }
    
    public interface a extends ds.a
    {
        boolean a(@NonNull final View p0);
    }
}
