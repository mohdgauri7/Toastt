// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Iterator;
import android.net.wifi.ScanResult;
import java.util.ArrayList;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Looper;
import android.content.BroadcastReceiver;
import java.util.List;
import android.content.IntentFilter;
import android.os.Handler;
import android.annotation.SuppressLint;
import android.content.Context;

public class io
{
    private static final String a;
    @SuppressLint({ "StaticFieldLeak" })
    private static Context b;
    private static Handler c;
    private static boolean d;
    private static final IntentFilter e;
    private static List<im> f;
    private static Runnable g;
    @SuppressLint({ "WifiManagerPotentialLeak", "MissingPermission" })
    private static final BroadcastReceiver h;
    
    public static void a() {
        io.b = gz.c();
        a(Looper.myLooper());
    }
    
    public static List<im> b() {
        return io.f;
    }
    
    @SuppressLint({ "MissingPermission" })
    private static synchronized void a(final Looper looper) {
        if (io.c != null) {
            return;
        }
        final Context c;
        if ((c = gz.c()) == null) {
            return;
        }
        final WifiManager wifiManager;
        if ((wifiManager = (WifiManager)c.getSystemService("wifi")) == null || !wifiManager.isWifiEnabled()) {
            return;
        }
        (io.c = new Handler(looper)).postDelayed(io.g, 10000L);
        if (!io.d) {
            io.d = true;
            io.b.registerReceiver(io.h, io.e, (String)null, io.c);
        }
        wifiManager.startScan();
    }
    
    private static synchronized void e() {
        if (io.c == null) {
            return;
        }
        io.c.removeCallbacks(io.g);
        if (io.d) {
            io.d = false;
            try {
                io.b.unregisterReceiver(io.h);
            }
            catch (IllegalArgumentException ex) {}
        }
        io.c = null;
        io.b = null;
    }
    
    static {
        a = io.class.getSimpleName();
        io.b = null;
        io.c = null;
        io.d = false;
        e = new IntentFilter("android.net.wifi.SCAN_RESULTS");
        io.g = new Runnable() {
            @Override
            public final void run() {
                e();
            }
        };
        h = new BroadcastReceiver() {
            public final void onReceive(final Context context, final Intent intent) {
                final WifiManager wifiManager = (WifiManager)io.b.getSystemService("wifi");
                e();
                final List scanResults = wifiManager.getScanResults();
                ii.a();
                final int wf;
                final boolean a = in.a(wf = ii.e().w.wf);
                final boolean a2 = in.a(wf, 1);
                final ArrayList<im> list = new ArrayList<im>();
                if (scanResults != null) {
                    for (final ScanResult scanResult : scanResults) {
                        if (!in.a(a, scanResult.SSID)) {
                            final ArrayList<im> list2 = list;
                            final ScanResult scanResult2 = scanResult;
                            final boolean b = a2;
                            final ScanResult scanResult3 = scanResult2;
                            im e = null;
                            if (scanResult3 != null) {
                                (e = new im()).a = in.a(scanResult3.BSSID);
                                e.b = (b ? null : scanResult3.SSID);
                                e.c = scanResult3.level;
                            }
                            list2.add(e);
                        }
                    }
                }
                io.f = list;
            }
        };
    }
}
