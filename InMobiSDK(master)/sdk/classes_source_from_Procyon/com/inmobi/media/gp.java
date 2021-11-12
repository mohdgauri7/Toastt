// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.WorkerThread;

public final class gp
{
    private gm a;
    
    public gp(final gm a) {
        this.a = a;
    }
    
    @WorkerThread
    public final gn a() {
        return new gk(this.a).a();
    }
}
