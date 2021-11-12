// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.media.MediaPlayer;

public final class er extends MediaPlayer
{
    public int a;
    public int b;
    private er c;
    private static final Object d;
    private static er e;
    private static int f;
    
    public er() {
        this.a = 0;
        this.b = 0;
    }
    
    public static er a() {
        synchronized (er.d) {
            if (er.e != null) {
                final er e;
                er.e = (e = er.e).c;
                e.c = null;
                --er.f;
                return e;
            }
        }
        return new er();
    }
    
    public final void b() {
        if (3 == this.a) {
            return;
        }
        synchronized (er.d) {
            if (er.f < 5) {
                this.c = er.e;
                er.e = this;
                ++er.f;
            }
        }
    }
    
    static {
        d = new Object();
        er.f = 0;
    }
}
