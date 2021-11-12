// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Locale;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import android.graphics.Point;

public class bk
{
    public Point a;
    public Point b;
    public Point c;
    public Point d;
    protected String e;
    protected String f;
    protected String g;
    protected float h;
    protected String i;
    protected String j;
    protected bs k;
    
    public bk() {
        this.a = new Point(0, 0);
        this.c = new Point(0, 0);
        this.b = new Point(0, 0);
        this.d = new Point(0, 0);
        this.e = "none";
        this.f = "straight";
        this.h = 10.0f;
        this.i = "#ff000000";
        this.j = "#00000000";
        this.g = "fill";
        this.k = null;
    }
    
    public bk(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final String s, final String s2, @NonNull final String s3, @NonNull final String s4, @Nullable final bs bs) {
        this(n, n2, n3, n4, n5, n6, n7, n8, "fill", s, s2, s3, s4, bs);
    }
    
    public bk(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final String g, final String e, final String f, @NonNull final String s, @NonNull final String s2, @Nullable final bs k) {
        this.a = new Point(n3, n4);
        this.b = new Point(n7, n8);
        this.c = new Point(n, n2);
        this.d = new Point(n5, n6);
        this.e = e;
        this.f = f;
        this.h = 10.0f;
        this.g = g;
        this.i = ((0 == s.length()) ? "#ff000000" : s);
        this.j = ((0 == s2.length()) ? "#00000000" : s2);
        this.k = k;
    }
    
    public final String a() {
        return this.e;
    }
    
    public final String b() {
        return this.f;
    }
    
    public final float c() {
        return this.h;
    }
    
    public final String d() {
        return this.i.toLowerCase(Locale.US);
    }
    
    public String e() {
        return this.j.toLowerCase(Locale.US);
    }
    
    public final String f() {
        return this.g;
    }
    
    public final bs g() {
        return this.k;
    }
}
