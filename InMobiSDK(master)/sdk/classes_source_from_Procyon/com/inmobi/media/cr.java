// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.Nullable;
import android.util.Base64;
import androidx.annotation.VisibleForTesting;

public final class cr
{
    private static final String c;
    @VisibleForTesting
    public byte[] a;
    @VisibleForTesting
    public final byte[] b;
    private final byte[] d;
    
    public cr() {
        this.b = hl.a();
        this.a = hl.a(16);
        this.d = hl.a(8);
    }
    
    @Nullable
    public final String a(final String s, final String s2) {
        try {
            return new String(Base64.encode(hl.a(hl.a(hl.a(hl.a(this.b), hl.a(this.d)), hl.a(this.a)), s2, s), 8));
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    static {
        c = cr.class.getSimpleName();
    }
}
