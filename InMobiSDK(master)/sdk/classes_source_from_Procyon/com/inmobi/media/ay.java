// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Map;

public final class ay
{
    int a;
    public String b;
    public Map<String, String> c;
    long d;
    long e;
    int f;
    AtomicBoolean g;
    boolean h;
    boolean i;
    
    ay(final String s, final boolean b, final boolean b2, final int n) {
        this(new Random().nextInt() & Integer.MAX_VALUE, s, new HashMap<String, String>(), b, b2, n, System.currentTimeMillis(), System.currentTimeMillis());
    }
    
    ay(final String s, final Map<String, String> map, final boolean b, final int n) {
        this(new Random().nextInt() & Integer.MAX_VALUE, s, map, b, false, n, System.currentTimeMillis(), System.currentTimeMillis());
    }
    
    ay(final int a, final String b, final Map<String, String> c, final boolean i, final boolean h, final int f, final long d, final long e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = new AtomicBoolean(false);
        this.i = i;
        this.h = h;
    }
    
    public final boolean a(final long n) {
        return System.currentTimeMillis() - this.e > n * 1000L;
    }
}
