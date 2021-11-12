// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.NonNull;
import android.content.Context;
import java.lang.ref.WeakReference;

public final class es extends en
{
    private WeakReference<l> a;
    
    public es(@NonNull final Context context) {
        super(context);
    }
    
    public final void setNativeStrandAd(@NonNull final l referent) {
        this.a = new WeakReference<l>(referent);
    }
    
    public final l getNativeStrandAd() {
        return this.a.get();
    }
}
