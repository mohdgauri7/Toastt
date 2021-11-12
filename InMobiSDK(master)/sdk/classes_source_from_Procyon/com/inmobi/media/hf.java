// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.util.Log;

public final class hf
{
    private static byte a;
    
    public static void a(final byte b, String substring, final String s) {
        switch (b) {
            case 1: {
                if (2 == hf.a || 1 == hf.a || 3 == hf.a) {
                    Log.e("[InMobi]", s);
                    return;
                }
                break;
            }
            case 2: {
                if (2 == hf.a || 3 == hf.a) {
                    Log.d("[InMobi]", s);
                    return;
                }
                break;
            }
            case 3: {
                if (s.length() > 4000) {
                    final String s2 = substring;
                    substring = s;
                    String s3 = s2;
                    while (substring.length() > 4000) {
                        Log.d(s3, substring.substring(0, 4000));
                        final String s4 = s3;
                        substring = substring.substring(4000);
                        s3 = s4;
                    }
                    Log.d(s3, substring);
                    return;
                }
                Log.d(substring, s);
                break;
            }
        }
    }
    
    public static void a(final String s, final String s2) {
        a((byte)3, s, s2);
    }
    
    public static void a(final String s, final String s2, final Throwable t) {
        a((byte)3, s, s2, t);
    }
    
    public static void a(final byte b, final String s, final String s2, final Throwable t) {
        switch (b) {
            case 1: {
                if (2 == hf.a || 1 == hf.a || 3 == hf.a) {
                    Log.e("[InMobi]", s2, t);
                    return;
                }
                break;
            }
            case 2: {
                if (2 == hf.a || 3 == hf.a) {
                    Log.d("[InMobi]", s2, t);
                    return;
                }
                break;
            }
            case 3: {
                Log.d(s, s2, t);
                break;
            }
        }
    }
    
    public static void a(final byte a) {
        hf.a = a;
    }
    
    static {
        hf.a = 0;
    }
}
