// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

public class ih
{
    private static final String g;
    long a;
    long b;
    long c;
    long d;
    long e;
    long f;
    
    public static ih a() {
        return a.a;
    }
    
    private ih() {
        this.a = 0L;
        this.b = 0L;
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
    }
    
    static void b() {
        ii.a();
        if (ii.e().sessionEnabled) {
            ht.a().c = System.currentTimeMillis();
        }
    }
    
    public final void a(final long n) {
        switch (hn.a()) {
            case 0: {
                this.f(n);
            }
            case 1: {
                this.d(n);
                break;
            }
        }
    }
    
    public final void b(final long n) {
        switch (hn.a()) {
            case 0: {
                this.g(n);
            }
            case 1: {
                this.e(n);
                break;
            }
        }
    }
    
    private void d(final long n) {
        this.a += n;
    }
    
    private void e(final long n) {
        this.b += n;
    }
    
    private void f(final long n) {
        this.c += n;
    }
    
    private void g(final long n) {
        this.d += n;
    }
    
    public final void c(final long n) {
        this.e += n;
    }
    
    static {
        g = ih.class.getSimpleName();
    }
    
    static final class a
    {
        static final ih a;
        
        static {
            a = new ih((byte)0);
        }
    }
}
