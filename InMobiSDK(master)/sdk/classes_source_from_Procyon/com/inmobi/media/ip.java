// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.Nullable;
import java.io.Serializable;

public final class ip implements Serializable
{
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private String e;
    private it f;
    private String g;
    
    public ip(final boolean a, final boolean b, final boolean c, final boolean d, @Nullable final it f, @Nullable final String e, @Nullable final String g) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    public final boolean a() {
        return this.a;
    }
    
    public final boolean b() {
        return this.b;
    }
    
    public final boolean c() {
        return this.c;
    }
    
    public final boolean d() {
        return this.d;
    }
    
    public final String e() {
        return this.e;
    }
    
    public final it f() {
        return this.f;
    }
    
    public final String g() {
        return this.g;
    }
}
