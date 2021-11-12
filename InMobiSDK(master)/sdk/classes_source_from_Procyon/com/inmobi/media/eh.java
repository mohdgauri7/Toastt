// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Animatable2;
import java.io.IOException;
import android.annotation.SuppressLint;
import android.graphics.ImageDecoder;
import java.io.File;
import android.graphics.drawable.AnimatedImageDrawable;

public final class eh implements ej
{
    AnimatedImageDrawable a;
    private a b;
    
    @SuppressLint({ "NewApi" })
    public eh(final String pathname) throws IOException {
        this.a = (AnimatedImageDrawable)ImageDecoder.decodeDrawable(ImageDecoder.createSource(new File(pathname)));
    }
    
    @SuppressLint({ "NewApi" })
    @Override
    public final void a() {
        this.a.registerAnimationCallback((Animatable2.AnimationCallback)new Animatable2.AnimationCallback() {
            public final void onAnimationStart(final Drawable drawable) {
                super.onAnimationStart(drawable);
            }
            
            public final void onAnimationEnd(final Drawable drawable) {
                super.onAnimationEnd(drawable);
                eh.this.a.start();
            }
        });
        this.a.start();
    }
    
    @Override
    public final void a(final boolean b) {
    }
    
    @Override
    public final int b() {
        return this.a.getIntrinsicWidth();
    }
    
    @Override
    public final int c() {
        return this.a.getIntrinsicHeight();
    }
    
    @Override
    public final void a(final Canvas canvas, final float n, final float n2) {
        canvas.translate(n, n2);
        this.a.draw(canvas);
    }
    
    @Override
    public final boolean d() {
        return this.a.isRunning();
    }
    
    @Override
    public final void e() {
    }
    
    @Override
    public final void a(final a b) {
        this.b = b;
    }
}
