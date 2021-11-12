// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.os.Message;
import android.os.Looper;
import android.os.Handler;
import android.os.Build$VERSION;
import android.os.HandlerThread;

class if
{
    private static final String b;
    a a;
    
    if() {
        final HandlerThread handlerThread;
        (handlerThread = new HandlerThread("DataCollectionHandler")).start();
        this.a = new a(handlerThread.getLooper());
    }
    
    public final synchronized void a() {
        boolean b2 = false;
        Label_0092: {
            if (gz.a()) {
                final String[] array = { "android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE", "android.permission.ACCESS_COARSE_LOCATION" };
                final boolean a = hh.a(gz.c(), "android.permission.ACCESS_FINE_LOCATION");
                boolean b = true;
                for (int i = 0; i < 3; ++i) {
                    if (!hh.a(gz.c(), array[i])) {
                        b = false;
                    }
                }
                if (b && (Build$VERSION.SDK_INT < 29 || a)) {
                    b2 = true;
                    break Label_0092;
                }
            }
            b2 = false;
        }
        if (!b2) {
            return;
        }
        this.a.a = false;
        if (!this.a.hasMessages(3)) {
            this.a.removeMessages(2);
            this.a.sendEmptyMessage(1);
        }
    }
    
    static {
        b = if.class.getSimpleName();
    }
    
    static final class a extends Handler
    {
        private boolean a;
        
        a(final Looper looper) {
            super(looper);
        }
        
        public final void handleMessage(final Message message) {
            switch (message.what) {
                case 1: {
                    if.b;
                    this.sendEmptyMessage(3);
                }
                case 2: {
                    if.b;
                    this.removeMessages(3);
                }
                case 3: {
                    if.b;
                    if (this.a) {
                        this.sendEmptyMessage(2);
                        return;
                    }
                    io.a();
                    final int n = 3;
                    ii.a();
                    this.sendEmptyMessageDelayed(n, (long)(ii.e().sampleInterval * 1000));
                }
                default: {
                    if.b;
                    final int what = message.what;
                }
            }
        }
    }
}
