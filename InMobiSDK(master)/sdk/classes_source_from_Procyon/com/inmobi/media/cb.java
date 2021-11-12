// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.Nullable;
import android.os.SystemClock;

public final class cb
{
    private static final String a;
    private cc b;
    
    public cb(final cc b) {
        this.b = b;
    }
    
    @Nullable
    public final cd a() {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        cd cd = null;
        try {
            final gn a = new gp(this.b).a();
            cd = new cd(this.b, a);
            ih.a().a(this.b.h());
            ih.a().b(a.d());
            if (!a.a()) {
                ih.a().c(SystemClock.elapsedRealtime() - elapsedRealtime);
            }
        }
        catch (Exception ex) {}
        return cd;
    }
    
    static {
        a = cb.class.getSimpleName();
    }
}
