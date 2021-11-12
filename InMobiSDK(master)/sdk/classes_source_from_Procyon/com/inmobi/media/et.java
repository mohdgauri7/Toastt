// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.content.Context;
import android.widget.FrameLayout;

public abstract class et extends FrameLayout
{
    private final byte a;
    
    public et(final Context context, final byte a) {
        super(context);
        this.a = a;
    }
    
    public final byte getType() {
        return this.a;
    }
    
    abstract void a(final bl p0, final eu p1, final int p2, final int p3, final a p4);
    
    interface a
    {
        int a(final int p0);
    }
}
