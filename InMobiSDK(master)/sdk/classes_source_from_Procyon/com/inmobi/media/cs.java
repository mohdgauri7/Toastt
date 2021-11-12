// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.os.Bundle;
import android.app.Activity;
import java.util.ArrayList;
import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;
import android.app.Application;
import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.List;
import android.annotation.SuppressLint;
import com.squareup.picasso.Picasso;

public class cs
{
    private static final String a;
    @SuppressLint({ "StaticFieldLeak" })
    private static volatile Picasso b;
    private static final Object c;
    private static List<WeakReference<Context>> d;
    private static Application.ActivityLifecycleCallbacks e;
    
    public static Picasso a(final Context referent) {
        synchronized (cs.c) {
            if (!c(referent)) {
                cs.d.add(new WeakReference<Context>(referent));
            }
            if (cs.b == null) {
                cs.b = new Picasso.Builder(referent).build();
                gz.a(referent, cs.e);
            }
        }
        return cs.b;
    }
    
    private static boolean c(final Context obj) {
        for (int i = 0; i < cs.d.size(); ++i) {
            final Context context;
            if ((context = cs.d.get(i).get()) != null && context.equals(obj)) {
                return true;
            }
        }
        return false;
    }
    
    public static Object a(final InvocationHandler h) {
        Object proxyInstance = null;
        try {
            final Class forName;
            proxyInstance = Proxy.newProxyInstance((forName = Class.forName("com.squareup.picasso.Callback")).getClassLoader(), new Class[] { forName }, h);
        }
        catch (Exception ex) {}
        return proxyInstance;
    }
    
    static {
        a = cs.class.getSimpleName();
        c = new Object();
        cs.d = new ArrayList<WeakReference<Context>>();
        cs.e = (Application.ActivityLifecycleCallbacks)new Application.ActivityLifecycleCallbacks() {
            public final void onActivityCreated(final Activity activity, final Bundle bundle) {
            }
            
            public final void onActivityStarted(final Activity activity) {
            }
            
            public final void onActivityResumed(final Activity activity) {
            }
            
            public final void onActivityPaused(final Activity activity) {
            }
            
            public final void onActivityStopped(final Activity activity) {
            }
            
            public final void onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
            }
            
            public final void onActivityDestroyed(final Activity activity) {
                synchronized (cs.c) {
                    if (cs.b != null && c((Context)activity)) {
                        activity.getApplication().unregisterActivityLifecycleCallbacks(cs.e);
                        cs.d.remove(activity);
                        if (cs.d.isEmpty()) {
                            cs.a;
                            cs.b;
                            cs.b.shutdown();
                            cs.b = null;
                        }
                    }
                }
            }
        };
    }
}
