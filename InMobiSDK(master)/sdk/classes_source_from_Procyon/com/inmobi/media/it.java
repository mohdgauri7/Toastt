// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.NonNull;
import java.io.Serializable;

@hw
public final class it implements Serializable
{
    public static final int DEFAULT_BITMAP_TIMEOUT = 5000;
    public static final int DEFAULT_TIMEOUT = 15000;
    public static final int DEFAULT_REQUEST_TIMEOUT = 6300;
    public static final int DEFAULT_RENDER_VIEW_TIMEOUT = 15000;
    private int bitmap;
    private int step1a;
    private int step1b;
    private int step2u;
    private int step3r;
    private int step4s;
    private int request;
    private int renderTimeout;
    
    @NonNull
    public static it a() {
        final it it;
        (it = new it()).j();
        return it;
    }
    
    public it() {
        this.bitmap = 5000;
        this.step1a = 15000;
        this.step1b = 15000;
        this.step2u = 15000;
        this.step3r = 15000;
        this.step4s = 15000;
        this.request = 6300;
        this.renderTimeout = 15000;
    }
    
    public final void a(final int bitmap) {
        this.bitmap = bitmap;
    }
    
    public final int b() {
        return this.bitmap;
    }
    
    public final int c() {
        return this.step1a;
    }
    
    public final int d() {
        return this.step1b;
    }
    
    public final int e() {
        return this.step2u;
    }
    
    public final int f() {
        return this.step3r;
    }
    
    public final int g() {
        return this.step4s;
    }
    
    public final void b(final int request) {
        this.request = request;
    }
    
    public final int h() {
        return this.request;
    }
    
    public final int i() {
        return this.renderTimeout;
    }
    
    public final void j() {
        this.bitmap = ((this.bitmap > 0) ? this.bitmap : 5000);
        this.step1a = ((this.step1a > 0) ? this.step1a : 15000);
        this.step1b = ((this.step1b > 0) ? this.step1b : 15000);
        this.step2u = ((this.step2u > 0) ? this.step2u : 15000);
        this.step3r = ((this.step3r > 0) ? this.step3r : 15000);
        this.step4s = ((this.step4s > 0) ? this.step4s : 15000);
        this.request = ((this.request > 0) ? this.request : 6300);
        this.renderTimeout = ((this.renderTimeout > 0) ? this.renderTimeout : 15000);
    }
}
