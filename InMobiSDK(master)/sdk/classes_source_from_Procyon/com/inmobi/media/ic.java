// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.annotation.SuppressLint;
import android.provider.Settings;
import java.security.MessageDigest;
import androidx.annotation.WorkerThread;
import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import androidx.annotation.Nullable;

public class ic
{
    private static final String a;
    @Nullable
    private static ib b;
    
    public static ic a() {
        return ic.a.a;
    }
    
    private ic() {
    }
    
    @WorkerThread
    public void b() {
        try {
            try {
                final Context c;
                if ((c = gz.c()) != null) {
                    final ib b = new ib();
                    if (g()) {
                        try {
                            final AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(c);
                            b.a = advertisingIdInfo.getId();
                            b.a(advertisingIdInfo.isLimitAdTrackingEnabled());
                            ic.b = b;
                        }
                        catch (Exception ex) {}
                    }
                }
            }
            catch (Exception ex2) {}
            this.c();
        }
        catch (Exception ex3) {}
    }
    
    public void c() {
        try {
            final ib e;
            if ((e = this.e()) != null) {
                final String b;
                if ((b = e.b()) != null) {
                    hf.a((byte)2, ic.a, "Publisher device Id is ".concat(String.valueOf(b)));
                }
            }
            else {
                hf.a((byte)2, ic.a, "Publisher device Id is " + a(d(), "SHA-1"));
            }
        }
        catch (Exception ex) {}
    }
    
    static String a(final String s, final String algorithm) {
        try {
            if (s == null || "".equals(s.trim())) {
                return "TEST_EMULATOR";
            }
            final MessageDigest instance;
            (instance = MessageDigest.getInstance(algorithm)).update(s.getBytes());
            final byte[] digest = instance.digest();
            final StringBuilder sb = new StringBuilder();
            for (int length = digest.length, i = 0; i < length; ++i) {
                sb.append(Integer.toString((digest[i] & 0xFF) + 256, 16).substring(1));
            }
            return sb.toString();
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    @SuppressLint({ "HardwareIds" })
    static String d() {
        String s = "";
        final Context c;
        if ((c = gz.c()) != null) {
            try {
                if ((s = Settings.Secure.getString(c.getContentResolver(), "android_id")) == null) {
                    s = Settings.System.getString(c.getContentResolver(), "android_id");
                }
            }
            catch (Exception ex) {
                s = "";
            }
        }
        return s;
    }
    
    @Nullable
    public ib e() {
        return ic.b;
    }
    
    private static boolean g() {
        try {
            AdvertisingIdClient.class.getName();
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            return false;
        }
        return true;
    }
    
    @Nullable
    public Boolean f() {
        final ib e;
        if ((e = a().e()) == null) {
            return null;
        }
        return e.a();
    }
    
    static {
        a = ic.class.getSimpleName();
    }
    
    static final class a
    {
        static final ic a;
        
        static {
            a = new ic((byte)0);
        }
    }
}
