// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import android.graphics.Canvas;
import android.os.SystemClock;
import java.io.IOException;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.File;
import android.graphics.Movie;

public final class ek implements ej
{
    private Movie b;
    int a;
    private long c;
    private volatile boolean d;
    private a e;
    
    public ek(String pathname) throws IOException {
        this.a = 0;
        this.d = false;
        final File file;
        final byte[] b = new byte[(int)(file = new File(pathname)).length()];
        pathname = (String)new FileInputStream(file);
        int read;
        try {
            read = ((FileInputStream)pathname).read(b);
        }
        finally {
            hg.a((Closeable)pathname);
        }
        final byte[] array;
        this.b = Movie.decodeByteArray(array, 0, read);
        if (this.b == null) {
            throw new IllegalStateException("Cannot decode gif byte array");
        }
    }
    
    @Override
    public final void a() {
    }
    
    @Override
    public final void a(final boolean d) {
        if (!(this.d = d)) {
            this.c = SystemClock.uptimeMillis() - this.a;
        }
        if (this.e != null) {
            this.e.a();
        }
    }
    
    @Override
    public final int b() {
        return this.b.width();
    }
    
    @Override
    public final int c() {
        return this.b.height();
    }
    
    @Override
    public final void a(final Canvas canvas, final float n, final float n2) {
        this.b.draw(canvas, n, n2);
        if (this.a + 20 >= this.b.duration()) {
            new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
                @Override
                public final void run() {
                    ek.this.a = 0;
                    ek.this.a(false);
                }
            });
        }
    }
    
    @Override
    public final boolean d() {
        return !this.d;
    }
    
    @Override
    public final void e() {
        final long uptimeMillis = SystemClock.uptimeMillis();
        if (this.c == 0L) {
            this.c = uptimeMillis;
        }
        int duration;
        if ((duration = this.b.duration()) == 0) {
            duration = 1000;
        }
        this.a = (int)((uptimeMillis - this.c) % duration);
        this.b.setTime(this.a);
    }
    
    @Override
    public final void a(final a e) {
        this.e = e;
    }
}
