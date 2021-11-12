// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Iterator;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.content.Intent;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.Network;
import android.os.Build;
import android.net.ConnectivityManager;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.HashMap;

public class hk
{
    private static final String a;
    private static HashMap<String, CopyOnWriteArrayList<c>> b;
    private static HashMap<String, b> c;
    private static HashMap<String, ConnectivityManager.NetworkCallback> d;
    
    public static hk a() {
        return hk.a.a;
    }
    
    public final void a(final String s, final c c) {
        CopyOnWriteArrayList<c> value;
        if ((value = hk.b.get(s)) != null) {
            value.add(c);
        }
        else {
            (value = new CopyOnWriteArrayList<c>()).add(c);
        }
        hk.b.put(s, value);
        if (value.size() == 1) {
            this.a(s);
        }
    }
    
    public final void a(final c c) {
        if (Build.VERSION.SDK_INT < 28) {
            this.a("android.net.conn.CONNECTIVITY_CHANGE", c);
            return;
        }
        this.a("SYSTEM_CONNECTIVITY_CHANGE", c);
    }
    
    @SuppressLint({ "NewApi" })
    private void a(final String key) {
        final Context c;
        if ((c = gz.c()) != null) {
            if ("SYSTEM_CONNECTIVITY_CHANGE".equals(key)) {
                final ConnectivityManager connectivityManager;
                if ((connectivityManager = (ConnectivityManager)c.getSystemService("connectivity")) != null) {
                    final ConnectivityManager.NetworkCallback value = new ConnectivityManager.NetworkCallback() {
                        public final void onAvailable(final Network network) {
                            super.onAvailable(network);
                            hk.a(true);
                        }
                        
                        public final void onLost(final Network network) {
                            super.onLost(network);
                            hk.a(false);
                        }
                    };
                    hk.d.put(key, value);
                    connectivityManager.registerDefaultNetworkCallback((ConnectivityManager.NetworkCallback)value);
                }
                return;
            }
            final b value2 = new b();
            hk.c.put(key, value2);
            c.registerReceiver((BroadcastReceiver)value2, new IntentFilter(key));
        }
    }
    
    private static void b(final boolean b, String iterator) {
        final CopyOnWriteArrayList<c> list;
        if ((list = hk.b.get(iterator)) != null) {
            iterator = (String)list.iterator();
            while (((Iterator)iterator).hasNext()) {
                final c c = ((Iterator<c>)iterator).next();
                try {
                    c.a(b);
                }
                catch (Exception ex) {}
            }
        }
    }
    
    @SuppressLint({ "NewApi" })
    public static void a(final c o, final String s) {
        final CopyOnWriteArrayList<c> list;
        if ((list = hk.b.get(s)) != null) {
            list.remove(o);
            final Context c;
            if (list.size() == 0 && (c = gz.c()) != null) {
                if ("SYSTEM_CONNECTIVITY_CHANGE".equals(s) && hk.d.get(s) != null) {
                    final ConnectivityManager connectivityManager;
                    if ((connectivityManager = (ConnectivityManager)c.getSystemService("connectivity")) != null) {
                        connectivityManager.unregisterNetworkCallback((ConnectivityManager.NetworkCallback)hk.d.get(s));
                        hk.d.remove(s);
                    }
                    return;
                }
                if (hk.c.get(s) != null) {
                    c.unregisterReceiver((BroadcastReceiver)hk.c.get(s));
                    hk.c.remove(s);
                }
            }
        }
    }
    
    public static void b(final c c) {
        if (Build.VERSION.SDK_INT < 28) {
            a(c, "android.net.conn.CONNECTIVITY_CHANGE");
            return;
        }
        a(c, "SYSTEM_CONNECTIVITY_CHANGE");
    }
    
    static /* synthetic */ void a(final boolean b) {
        b(b, "SYSTEM_CONNECTIVITY_CHANGE");
    }
    
    static {
        a = hk.class.getSimpleName();
        hk.b = new HashMap<String, CopyOnWriteArrayList<c>>();
        hk.c = new HashMap<String, b>();
        hk.d = new HashMap<String, ConnectivityManager.NetworkCallback>();
    }
    
    static final class a
    {
        static final hk a;
        
        static {
            a = new hk();
        }
    }
    
    static final class b extends BroadcastReceiver
    {
        private static final String a;
        
        @SuppressLint({ "MissingPermission" })
        public final void onReceive(final Context context, final Intent intent) {
            try {
                boolean b = false;
                if (intent != null && intent.getAction() != null) {
                    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                        final ConnectivityManager connectivityManager;
                        final NetworkInfo activeNetworkInfo;
                        if ((connectivityManager = (ConnectivityManager)context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                            b = true;
                        }
                    }
                    else if ("android.os.action.DEVICE_IDLE_MODE_CHANGED".equalsIgnoreCase(intent.getAction())) {
                        final PowerManager powerManager;
                        b = ((powerManager = (PowerManager)context.getSystemService("power")) != null && Build.VERSION.SDK_INT >= 23 && powerManager.isDeviceIdleMode());
                    }
                    else if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                        b = true;
                    }
                    b(b, intent.getAction());
                    intent.getAction();
                }
            }
            catch (Exception ex) {}
        }
        
        static {
            a = b.class.getSimpleName();
        }
    }
    
    public interface c
    {
        void a(final boolean p0);
    }
}
