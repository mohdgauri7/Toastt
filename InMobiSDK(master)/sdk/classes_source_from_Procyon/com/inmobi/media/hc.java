// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.os.Message;
import java.util.Iterator;
import androidx.annotation.UiThread;
import android.os.Bundle;
import android.os.Looper;
import android.app.Activity;
import java.lang.ref.WeakReference;
import android.os.Handler;
import android.app.Application;
import java.util.LinkedHashSet;
import androidx.annotation.NonNull;
import android.content.Context;
import java.util.HashSet;

public class hc
{
    private static final String a;
    private static HashSet<c> b;
    private static boolean c;
    
    public static hc a() {
        return hc.b.a;
    }
    
    private hc() {
    }
    
    @UiThread
    public void a(@NonNull final Context context, @NonNull final c e) {
        if (hc.b == null) {
            hc.b = new LinkedHashSet<c>();
            final Application application;
            if ((application = (Application)context.getApplicationContext()) != null) {
                try {
                    application.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new Application.ActivityLifecycleCallbacks() {
                        private final Handler b = new a(Looper.getMainLooper());
                        private WeakReference<Activity> c;
                        
                        private void a(final Activity referent) {
                            if (this.c == null || this.c.get() != referent) {
                                this.c = new WeakReference<Activity>(referent);
                            }
                            this.b.removeMessages(1001);
                            this.b.sendEmptyMessage(1002);
                        }
                        
                        public final void onActivityCreated(final Activity activity, final Bundle bundle) {
                        }
                        
                        public final void onActivityStarted(final Activity activity) {
                            this.a(activity);
                        }
                        
                        public final void onActivityResumed(final Activity activity) {
                            this.a(activity);
                        }
                        
                        public final void onActivityPaused(final Activity activity) {
                        }
                        
                        public final void onActivityStopped(final Activity activity) {
                            if (this.c == null || this.c.get() == activity) {
                                this.b.sendEmptyMessageDelayed(1001, 3000L);
                            }
                        }
                        
                        public final void onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
                        }
                        
                        public final void onActivityDestroyed(final Activity activity) {
                        }
                    });
                }
                catch (Throwable t) {}
            }
        }
        hc.b.add(e);
    }
    
    public static void b() {
        hc.c = true;
    }
    
    public static void c() {
        hc.c = false;
    }
    
    static /* synthetic */ void a(final boolean b) {
        if (gz.c() == null) {
            return;
        }
        for (final c c : hc.b) {
            try {
                c.a(b);
            }
            catch (Exception ex) {}
        }
    }
    
    static {
        a = hc.class.getSimpleName();
        hc.c = false;
    }
    
    static final class b
    {
        static final hc a;
        
        static {
            a = new hc((byte)0);
        }
    }
    
    static final class a extends Handler
    {
        boolean a;
        
        a(final Looper looper) {
            super(looper);
            this.a = true;
        }
        
        public final void handleMessage(final Message message) {
            if (hc.c) {
                return;
            }
            if (message.what == 1001 && this.a) {
                hc.a(this.a = false);
                hc.a;
                return;
            }
            if (message.what == 1002 && !this.a) {
                hc.a(this.a = true);
                hc.a;
            }
        }
    }
    
    public interface c
    {
        @UiThread
        void a(final boolean p0);
    }
}
