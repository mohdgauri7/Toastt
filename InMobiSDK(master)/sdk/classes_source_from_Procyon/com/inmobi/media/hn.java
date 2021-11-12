// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.media.AudioManager;
import java.util.Locale;
import java.util.HashMap;
import java.util.Map;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import android.annotation.SuppressLint;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.content.Context;
import android.os.Build;
import android.net.ConnectivityManager;

public class hn
{
    @SuppressLint({ "MissingPermission", "NewApi" })
    private static String c() {
        final Context c;
        if ((c = gz.c()) == null) {
            return "";
        }
        String s = "";
        final ConnectivityManager connectivityManager;
        final NetworkInfo activeNetworkInfo;
        if (hh.a(c, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager)c.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            if (Build.VERSION.SDK_INT < 28) {
                final int type = activeNetworkInfo.getType();
                final int subtype = activeNetworkInfo.getSubtype();
                if (type == 0) {
                    s = type + "|" + subtype;
                }
                else if (type == 1) {
                    s = "1";
                }
                else {
                    s = Integer.toString(type);
                }
            }
            else {
                NetworkCapabilities networkCapabilities = null;
                try {
                    final ConnectivityManager connectivityManager2 = connectivityManager;
                    networkCapabilities = connectivityManager2.getNetworkCapabilities(connectivityManager2.getActiveNetwork());
                }
                catch (SecurityException ex) {
                    fv.a().a(new gv(ex));
                }
                if (networkCapabilities != null) {
                    if (networkCapabilities.hasTransport(0)) {
                        s = "0|" + activeNetworkInfo.getSubtype();
                    }
                    else if (networkCapabilities.hasTransport(1)) {
                        s = "1";
                    }
                    else if (networkCapabilities.hasTransport(2)) {
                        s = "7";
                    }
                    else if (networkCapabilities.hasTransport(3)) {
                        s = "9";
                    }
                    else if (networkCapabilities.hasTransport(4)) {
                        s = "17";
                    }
                    else if (networkCapabilities.hasTransport(5)) {
                        s = "10";
                    }
                    else if (networkCapabilities.hasTransport(6)) {
                        s = "11";
                    }
                    else {
                        s = "8";
                    }
                }
            }
        }
        return s;
    }
    
    @NonNull
    public static String a(@NonNull final Context context) {
        final TelephonyManager telephonyManager;
        if ((telephonyManager = (TelephonyManager)context.getSystemService("phone")) != null) {
            return telephonyManager.getNetworkOperatorName();
        }
        return "";
    }
    
    public static Map<String, String> a(final boolean b) {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        try {
            hashMap.put("d-brand-name", Build.BRAND);
            hashMap.put("d-manufacturer-name", Build.MANUFACTURER);
            hashMap.put("d-model-name", Build.MODEL);
            hashMap.put("d-nettype-raw", c());
            hashMap.put("d-localization", Locale.getDefault().toString());
            hashMap.put("d-language", Locale.getDefault().getLanguage());
            hashMap.put("d-media-volume", String.valueOf(a(gz.c(), b)));
        }
        catch (Exception ex) {
            hn.class.getSimpleName();
        }
        return hashMap;
    }
    
    public static int a() {
        final String c;
        if ((c = c()).startsWith("0")) {
            return 0;
        }
        if (c.startsWith("1")) {
            return 1;
        }
        return 2;
    }
    
    public static String b() {
        switch (a()) {
            case 0: {
                return "carrier";
            }
            case 1: {
                return "wifi";
            }
            default: {
                return "NIL";
            }
        }
    }
    
    public static int b(@NonNull final Context context) {
        return ((AudioManager)context.getSystemService("audio")).getStreamVolume(3);
    }
    
    public static int a(final Context context, final boolean b) {
        if (context == null || b) {
            return 0;
        }
        final AudioManager audioManager;
        final int streamVolume = (audioManager = (AudioManager)context.getSystemService("audio")).getStreamVolume(3);
        final int streamMaxVolume;
        if ((streamMaxVolume = audioManager.getStreamMaxVolume(3)) == 0) {
            hn.class.getSimpleName();
            return 0;
        }
        return streamVolume * 100 / streamMaxVolume;
    }
}
