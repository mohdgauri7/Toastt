// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import com.inmobi.ads.controllers.PublisherCallbacks;
import android.os.Message;
import com.inmobi.ads.InMobiBanner;
import android.os.Handler;

public final class c extends Handler
{
    private static final String a;
    private InMobiBanner b;
    
    public c(final InMobiBanner b) {
        this.b = b;
    }
    
    public final void handleMessage(final Message message) {
        switch (message.what) {
            case 1: {
                this.b.a(this.b.e, true);
            }
            default: {
                final int what = message.what;
            }
        }
    }
    
    static {
        a = c.class.getSimpleName();
    }
}
