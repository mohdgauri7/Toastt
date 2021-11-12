// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.os.Handler;
import android.content.Intent;
import android.database.ContentObserver;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.media.AudioManager;
import android.annotation.SuppressLint;

@SuppressLint({ "ClickableViewAccessibility" })
public final class cl
{
    private static final String f;
    public o a;
    public ci b;
    public b c;
    public c d;
    public a e;
    
    public cl(final o a) {
        this.a = a;
    }
    
    public static boolean a() {
        final Context c;
        final AudioManager audioManager;
        return (c = gz.c()) != null && (audioManager = (AudioManager)c.getSystemService("audio")) != null && 2 != audioManager.getRingerMode();
    }
    
    public final void b() {
        final Context c;
        if ((c = gz.c()) == null) {
            return;
        }
        if (this.c != null) {
            c.unregisterReceiver((BroadcastReceiver)this.c);
            this.c = null;
        }
    }
    
    public final void c() {
        final Context c;
        if ((c = gz.c()) == null) {
            return;
        }
        if (this.d != null) {
            c.getContentResolver().unregisterContentObserver((ContentObserver)this.d);
            this.d = null;
        }
    }
    
    public static boolean d() {
        final Context c;
        final AudioManager audioManager;
        return (c = gz.c()) != null && (audioManager = (AudioManager)c.getSystemService("audio")) != null && audioManager.isWiredHeadsetOn();
    }
    
    public final void e() {
        final Context c;
        if ((c = gz.c()) == null) {
            return;
        }
        if (this.e != null) {
            c.unregisterReceiver((BroadcastReceiver)this.e);
            this.e = null;
        }
    }
    
    static /* synthetic */ void a(final cl cl, final String s, final boolean b) {
        if (cl.a != null) {
            cl.a.a(s, "fireDeviceMuteChangeEvent(" + b + ");");
        }
    }
    
    static /* synthetic */ void b(final cl cl, final String s, final boolean b) {
        if (cl.a != null) {
            cl.a.a(s, "fireHeadphonePluggedEvent(" + b + ");");
        }
    }
    
    static /* synthetic */ void a(final cl cl, final String s, final int i) {
        if (cl.a != null) {
            cl.a.a(s, "fireDeviceVolumeChangeEvent(" + i + ");");
        }
    }
    
    static {
        f = cl.class.getSimpleName();
    }
    
    public final class b extends BroadcastReceiver
    {
        private String b;
        
        public b(final String b) {
            this.b = b;
        }
        
        public final void onReceive(final Context context, final Intent intent) {
            if (intent != null && "android.media.RINGER_MODE_CHANGED".equals(intent.getAction())) {
                final int intExtra = intent.getIntExtra("android.media.EXTRA_RINGER_MODE", 2);
                cl.f;
                cl.a(cl.this, this.b, 2 != intExtra);
            }
        }
    }
    
    public final class a extends BroadcastReceiver
    {
        private String b;
        
        public a(final String b) {
            this.b = b;
        }
        
        public final void onReceive(final Context context, final Intent intent) {
            if (intent != null && "android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                final int intExtra = intent.getIntExtra("state", 0);
                cl.f;
                cl.b(cl.this, this.b, intExtra);
            }
        }
    }
    
    public final class c extends ContentObserver
    {
        private Context b;
        private int c;
        private String d;
        
        public c(final String d, final Context b, final Handler handler) {
            super(handler);
            this.d = d;
            this.b = b;
            this.c = -1;
        }
        
        public final void onChange(final boolean b) {
            super.onChange(b);
            final AudioManager audioManager;
            if (this.b != null && (audioManager = (AudioManager)this.b.getSystemService("audio")) != null) {
                try {
                    final int streamVolume;
                    if ((streamVolume = audioManager.getStreamVolume(3)) != this.c) {
                        this.c = streamVolume;
                        cl.a(cl.this, this.d, streamVolume);
                    }
                }
                catch (Exception ex) {
                    cl.f;
                }
            }
        }
    }
}
