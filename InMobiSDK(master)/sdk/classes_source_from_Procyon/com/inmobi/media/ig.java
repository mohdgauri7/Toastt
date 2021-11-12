// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.List;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.provider.Settings;
import android.os.Build;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import android.location.Location;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import android.os.Bundle;
import android.location.Criteria;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.FusedLocationProviderClient;
import android.content.Context;
import com.google.android.gms.common.api.GoogleApiClient;
import android.os.HandlerThread;
import androidx.annotation.Nullable;
import android.location.LocationManager;
import android.location.LocationListener;

public class ig implements LocationListener
{
    private static final String c;
    @Nullable
    LocationManager a;
    private HandlerThread d;
    private static boolean e;
    GoogleApiClient b;
    
    public static ig a() {
        return a.a;
    }
    
    private ig() {
        (this.d = new HandlerThread("LThread")).start();
        final Context c;
        if ((c = gz.c()) != null) {
            this.a = (LocationManager)c.getSystemService("location");
        }
    }
    
    private static boolean g() {
        try {
            GoogleApiClient.class.getName();
            FusedLocationProviderClient.class.getName();
            LocationServices.class.getName();
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            return true;
        }
        return false;
    }
    
    final synchronized void b() {
        try {
            if (c() && this.e()) {
                if (this.a != null) {
                    final Criteria criteria;
                    (criteria = new Criteria()).setBearingAccuracy(2);
                    criteria.setPowerRequirement(2);
                    criteria.setCostAllowed(false);
                    final String bestProvider;
                    if ((bestProvider = this.a.getBestProvider(criteria, true)) != null) {
                        this.a.requestSingleUpdate(bestProvider, (LocationListener)this, this.d.getLooper());
                    }
                }
                if (!g()) {
                    final Context c = gz.c();
                    try {
                        if (this.b == null) {
                            (this.b = new GoogleApiClient.Builder(c).addConnectionCallbacks((GoogleApiClient.ConnectionCallbacks)new GoogleApiClient.ConnectionCallbacks() {
                                public final void onConnected(@Nullable final Bundle bundle) {
                                    ig.c;
                                    ig.e = true;
                                }
                                
                                public final void onConnectionSuspended(final int n) {
                                    ig.e = false;
                                    ig.c;
                                }
                            }).addOnConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener)new GoogleApiClient.OnConnectionFailedListener() {
                                public final void onConnectionFailed(@NonNull final ConnectionResult connectionResult) {
                                    ig.e = false;
                                }
                            }).addApi(LocationServices.API).build()).connect();
                            return;
                        }
                        this.b.connect();
                    }
                    catch (Exception ex) {}
                }
            }
        }
        catch (Exception ex2) {}
    }
    
    public static boolean c() {
        try {
            return hh.a(gz.c(), "android.permission.ACCESS_FINE_LOCATION") || hh.a(gz.c(), "android.permission.ACCESS_COARSE_LOCATION");
        }
        catch (Exception ex) {
            return false;
        }
    }
    
    public void onLocationChanged(final Location location) {
        try {
            if (location != null) {
                location.getTime();
                location.getLatitude();
                location.getLongitude();
                location.getAccuracy();
            }
            if (c() && this.a != null) {
                this.a.removeUpdates((LocationListener)this);
            }
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
        }
    }
    
    public void onStatusChanged(final String s, final int n, final Bundle bundle) {
    }
    
    public void onProviderEnabled(final String s) {
    }
    
    public void onProviderDisabled(final String s) {
    }
    
    public final synchronized HashMap<String, String> d() {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        Location h = null;
        ii.a();
        if (ii.g()) {
            h = this.h();
        }
        HashMap<String, Object> hashMap2;
        if (h != null) {
            hashMap2 = this.a(h, true, hh.a(gz.c(), "android.permission.ACCESS_FINE_LOCATION") ? this.a(1, 3) : null);
        }
        else {
            hashMap2 = this.a(hs.b(), false, null);
        }
        for (final Map.Entry<String, V> entry : hashMap2.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().toString());
        }
        return hashMap;
    }
    
    @TargetApi(19)
    @SuppressLint({ "newApi" })
    public final boolean e() {
        final Context c;
        if ((c = gz.c()) == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return this.a != null && this.a.isLocationEnabled();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            int int1 = 0;
            try {
                int1 = Settings.Secure.getInt(c.getContentResolver(), "location_mode");
            }
            catch (Settings.SettingNotFoundException ex) {}
            return int1 != 0;
        }
        if (this.a != null) {
            boolean providerEnabled = false;
            boolean providerEnabled2 = false;
            try {
                if (hh.a(c, "android.permission.ACCESS_FINE_LOCATION")) {
                    providerEnabled2 = this.a.isProviderEnabled("gps");
                }
                else if (hh.a(c, "android.permission.ACCESS_COARSE_LOCATION")) {
                    providerEnabled = this.a.isProviderEnabled("network");
                }
            }
            catch (Exception ex2) {}
            return providerEnabled || providerEnabled2;
        }
        return false;
    }
    
    private Location h() {
        Location i = null;
        Location location = null;
        try {
            if (this.e() && c()) {
                if (ig.e) {
                    i = i();
                }
                if (this.a != null) {
                    location = (hh.a(gz.c(), "android.permission.ACCESS_COARSE_LOCATION") ? this.a(2, 2) : null);
                }
            }
        }
        catch (Exception ex) {}
        if (i == null && location == null) {
            return null;
        }
        if (i == null) {
            location.getTime();
            return location;
        }
        if (location == null) {
            i.getTime();
            return i;
        }
        final long n;
        final boolean b = (n = i.getTime() - location.getTime()) > 120000L;
        final boolean b2 = n < -120000L;
        final boolean b3 = n > 0L;
        if (b) {
            i.getTime();
            return i;
        }
        if (b2) {
            location.getTime();
            return location;
        }
        final int n2;
        final boolean b4 = (n2 = (int)(i.getAccuracy() - location.getAccuracy())) > 0;
        final boolean b5 = n2 < 0;
        final boolean b6 = n2 > 200;
        if (b5 || (b3 && (!b4 || !b6))) {
            i.getTime();
            return i;
        }
        location.getTime();
        return location;
    }
    
    private Location a(final int accuracy, final int powerRequirement) {
        Location location = null;
        final Criteria criteria;
        (criteria = new Criteria()).setAccuracy(accuracy);
        criteria.setPowerRequirement(powerRequirement);
        criteria.setCostAllowed(false);
        final String bestProvider;
        if (this.a != null && (bestProvider = this.a.getBestProvider(criteria, true)) != null) {
            try {
                location = this.a.getLastKnownLocation(bestProvider);
            }
            catch (Exception ex) {}
            if (location == null && accuracy != 1) {
                location = this.j();
            }
        }
        return location;
    }
    
    private static Location i() {
        try {
            return (Location)LocationServices.getFusedLocationProviderClient(gz.c()).getLastLocation().getResult();
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    private Location j() {
        Location lastKnownLocation = null;
        if (this.a != null) {
            List providers;
            for (int i = (providers = this.a.getProviders(true)).size() - 1; i >= 0; --i) {
                final String s = providers.get(i);
                try {
                    if (this.a.isProviderEnabled(s)) {
                        try {
                            lastKnownLocation = this.a.getLastKnownLocation(s);
                        }
                        catch (SecurityException ex) {}
                        if (lastKnownLocation != null) {
                            break;
                        }
                    }
                }
                catch (Exception ex2) {}
            }
        }
        return lastKnownLocation;
    }
    
    private HashMap<String, Object> a(@Nullable final Location location, final boolean i, @Nullable final Location location2) {
        final HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        final Context c;
        if ((c = gz.c()) == null) {
            return (HashMap<String, Object>)hashMap;
        }
        if (location != null) {
            if (location.getTime() > 0L) {
                hashMap.put("u-ll-ts", (Integer)(Object)Long.valueOf(location.getTime()));
            }
            hashMap.put("u-latlong-accu", (Integer)a(location));
            hashMap.put("sdk-collected", i ? 1 : 0);
        }
        ii.a();
        if (ii.g()) {
            hashMap.put("loc-allowed", this.e() ? 1 : 0);
        }
        if (location2 != null) {
            hashMap.put("u-latlong-accu-fine", (Integer)a(location2));
            hashMap.put("u-ll-ts-fine", (Integer)(Object)Long.valueOf(location2.getTime()));
        }
        if (this.e() && c()) {
            if (hh.a(c, "android.permission.ACCESS_COARSE_LOCATION")) {
                hashMap.put("loc-granularity", (Integer)"coarse");
            }
        }
        else {
            hashMap.put("loc-granularity", (Integer)"none");
        }
        return (HashMap<String, Object>)hashMap;
    }
    
    private static String a(final Location location) {
        return location.getLatitude() + "," + location.getLongitude() + "," + (int)location.getAccuracy();
    }
    
    static {
        c = ig.class.getSimpleName();
        ig.e = false;
    }
    
    static final class a
    {
        static final ig a;
        
        static {
            a = new ig((byte)0);
        }
    }
}
