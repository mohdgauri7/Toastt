// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public class gn
{
    private static final String d;
    private String e;
    private byte[] f;
    public gl a;
    public int b;
    public Map<String, List<String>> c;
    
    public final boolean a() {
        return this.a != null;
    }
    
    public final String b() {
        if (this.e == null) {
            this.e = a(this.f);
        }
        return this.e;
    }
    
    public static String a(final byte[] bytes) {
        if (bytes == null || 0 == bytes.length) {
            return "";
        }
        try {
            return new String(bytes, "UTF-8");
        }
        catch (UnsupportedEncodingException ex) {
            return "";
        }
    }
    
    public final byte[] c() {
        if (this.f == null || 0 == this.f.length) {
            return new byte[0];
        }
        final byte[] array = new byte[this.f.length];
        System.arraycopy(this.f, 0, array, 0, this.f.length);
        return array;
    }
    
    public final void b(final byte[] array) {
        if (array == null || 0 == array.length) {
            this.f = new byte[0];
            return;
        }
        System.arraycopy(array, 0, this.f = new byte[array.length], 0, array.length);
    }
    
    public final long d() {
        long n = 0L;
        try {
            if (this.e != null) {
                n = 0L + this.e.length();
            }
        }
        catch (Exception ex) {}
        return n;
    }
    
    static {
        d = gn.class.getSimpleName();
    }
}
