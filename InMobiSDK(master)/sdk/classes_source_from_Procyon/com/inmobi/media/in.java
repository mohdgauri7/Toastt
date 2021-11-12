// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.net.wifi.WifiInfo;
import android.content.Context;
import android.net.wifi.WifiManager;

public final class in
{
    public static boolean a(final int n) {
        return !a(n, 2);
    }
    
    public static im a(final boolean b, final boolean b2) {
        final Context c;
        if ((c = gz.c()) == null) {
            return null;
        }
        im im = null;
        try {
            final WifiInfo connectionInfo;
            if ((connectionInfo = ((WifiManager)c.getSystemService("wifi")).getConnectionInfo()) != null) {
                final String bssid = connectionInfo.getBSSID();
                String s = connectionInfo.getSSID();
                if (bssid != null && !a(b, s)) {
                    (im = new im()).a = a(bssid);
                    if (s != null && s.startsWith("\"") && s.endsWith("\"")) {
                        s = s.substring(1, s.length() - 1);
                    }
                    im.b = (b2 ? null : s);
                    im.c = connectionInfo.getRssi();
                    im.d = connectionInfo.getIpAddress();
                }
            }
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
        }
        return im;
    }
    
    static boolean a(final boolean b, final String s) {
        return b && s != null && s.endsWith("_nomap");
    }
    
    static long a(final String s) {
        final String[] split = s.split("\\:");
        final byte[] array = new byte[6];
        for (int i = 0; i < 6; ++i) {
            try {
                array[i] = (byte)Integer.parseInt(split[i], 16);
            }
            catch (NumberFormatException ex) {
                return 0L;
            }
        }
        final byte[] array2;
        return ((long)(array2 = array)[5] & 0xFFL) | ((long)array2[4] & 0xFFL) << 8 | ((long)array2[3] & 0xFFL) << 16 | ((long)array2[2] & 0xFFL) << 24 | ((long)array2[1] & 0xFFL) << 32 | ((long)array2[0] & 0xFFL) << 40;
    }
    
    public static boolean a(final int n, final int n2) {
        return (n & n2) == n2;
    }
}
