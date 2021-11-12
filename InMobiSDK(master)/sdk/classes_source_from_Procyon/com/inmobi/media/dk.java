// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.app.Activity;
import android.view.View;
import java.lang.ref.WeakReference;
import androidx.annotation.NonNull;
import android.view.ViewTreeObserver;

final class dk extends ds
{
    private static final String a;
    @NonNull
    private ViewTreeObserver.OnPreDrawListener d;
    @NonNull
    private final WeakReference<View> e;
    
    dk(@NonNull final a a, @NonNull final Activity activity) {
        super(a, (byte)1);
        final View decorView = activity.getWindow().getDecorView();
        this.e = new WeakReference<View>(decorView);
        final ViewTreeObserver viewTreeObserver;
        if ((viewTreeObserver = decorView.getViewTreeObserver()).isAlive()) {
            viewTreeObserver.addOnPreDrawListener(this.d = (ViewTreeObserver.OnPreDrawListener)new ViewTreeObserver.OnPreDrawListener() {
                public final boolean onPreDraw() {
                    dk.this.h();
                    return true;
                }
            });
        }
    }
    
    @Override
    protected final int a() {
        return 100;
    }
    
    @Override
    protected final void b() {
    }
    
    @Override
    public final void c() {
        if (!super.b) {
            this.i();
            super.c();
        }
    }
    
    @Override
    public final void d() {
        if (super.b) {
            final View view;
            final ViewTreeObserver viewTreeObserver;
            if ((view = this.e.get()) != null && (viewTreeObserver = view.getViewTreeObserver()).isAlive()) {
                viewTreeObserver.addOnPreDrawListener(this.d);
            }
            super.d();
        }
    }
    
    private void i() {
        final View view;
        final ViewTreeObserver viewTreeObserver;
        if ((view = this.e.get()) != null && (viewTreeObserver = view.getViewTreeObserver()).isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.d);
        }
    }
    
    @Override
    protected final void e() {
        this.i();
        super.e();
    }
    
    static {
        a = dk.class.getSimpleName();
    }
}
