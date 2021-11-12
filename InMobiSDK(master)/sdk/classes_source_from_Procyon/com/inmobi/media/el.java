// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.NonNull;
import android.view.View;
import android.annotation.SuppressLint;
import android.os.Build;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.graphics.drawable.Drawable;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.ImageView;

public class el extends ImageView implements ej.a
{
    private ej a;
    private float b;
    private boolean c;
    private String d;
    
    public el(final Context context) {
        this(context, (byte)0);
    }
    
    private el(final Context context, final byte b) {
        super(context, (AttributeSet)null);
        this.b = 1.0f;
        this.c = true;
        this.d = "unspecified";
        this.setLayerType(1, (Paint)null);
    }
    
    public void setPaused(final boolean b) {
        this.a.a(b);
    }
    
    public void setGifImpl(final ej a) {
        this.a = a;
        if (this.a != null) {
            this.a.a(this);
            this.a.a();
        }
        this.requestLayout();
    }
    
    public void setContentMode(final String d) {
        this.d = d;
    }
    
    private float[] a(final Canvas canvas) {
        final float n = (float)this.getWidth();
        final float n2 = (float)this.getHeight();
        final float n3 = this.a.b() * this.b;
        final float n4 = this.a.c() * this.b;
        final String d = this.d;
        int n5 = -1;
        switch (d.hashCode()) {
            case 727618043: {
                if (d.equals("aspectFill")) {
                    n5 = 0;
                    break;
                }
                break;
            }
            case -1362001767: {
                if (d.equals("aspectFit")) {
                    n5 = 1;
                    break;
                }
                break;
            }
        }
        float n6 = 0.0f;
        float n7 = 0.0f;
        float n8 = 0.0f;
        switch (n5) {
            case 0: {
                n6 = Math.max(n2 / n4, n / n3);
                n7 = (n - n3 * n6) / 2.0f / (n6 * this.b);
                n8 = (n2 - n4 * n6) / 2.0f / (n6 * this.b);
                final float n9 = n6;
                canvas.scale(n9, n9);
                break;
            }
            case 1: {
                n6 = Math.min(n2 / n4, n / n3);
                n7 = (n - n3 * n6) / 2.0f / (n6 * this.b);
                n8 = (n2 - n4 * n6) / 2.0f / (n6 * this.b);
                final float n10 = n6;
                canvas.scale(n10, n10);
                break;
            }
            default: {
                final float n11 = n / n3;
                n6 = n2 / n4;
                n7 = 0.0f;
                n8 = 0.0f;
                canvas.scale(n11, n6);
                break;
            }
        }
        return new float[] { n7, n8, n6 };
    }
    
    protected void onMeasure(int resolveSize, int resolveSize2) {
        this.b = this.getScale();
        final Drawable drawable;
        int n;
        int n2;
        if ((drawable = this.getDrawable()) != null) {
            n = drawable.getIntrinsicWidth();
            n2 = drawable.getIntrinsicHeight();
            if (n <= 0) {
                n = 1;
            }
            if (n2 <= 0) {
                n2 = 1;
            }
        }
        else if (this.a != null) {
            n = this.a.b();
            n2 = this.a.c();
            if (n <= 0) {
                n = 1;
            }
            if (n2 <= 0) {
                n2 = 1;
            }
        }
        else {
            n = 0;
            n2 = 0;
        }
        final int paddingLeft = this.getPaddingLeft();
        final int paddingRight = this.getPaddingRight();
        final int paddingTop = this.getPaddingTop();
        final int paddingBottom = this.getPaddingBottom();
        final int a = n + (paddingLeft + paddingRight);
        final int a2 = n2 + (paddingTop + paddingBottom);
        final int max = Math.max(a, this.getSuggestedMinimumWidth());
        final int max2 = Math.max(a2, this.getSuggestedMinimumHeight());
        resolveSize = resolveSize(max, resolveSize);
        resolveSize2 = resolveSize(max2, resolveSize2);
        this.setMeasuredDimension(resolveSize, resolveSize2);
    }
    
    private int getDensity() {
        int densityDpi = 240;
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        if (this.getContext() instanceof Activity) {
            ((Activity)this.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            densityDpi = displayMetrics.densityDpi;
        }
        return densityDpi;
    }
    
    private float getScale() {
        this.b = this.getContext().getResources().getDisplayMetrics().densityDpi / (float)this.getDensity();
        if (this.b < 0.1f) {
            this.b = 0.1f;
        }
        if (this.b > 5.0f) {
            this.b = 5.0f;
        }
        return this.b;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        super.onLayout(b, n, n2, n3, n4);
        this.c = (this.getVisibility() == 0);
    }
    
    protected void onDraw(final Canvas canvas) {
        if (this.a != null) {
            if (this.a.d()) {
                this.a.e();
                this.b(canvas);
                this.b();
                return;
            }
            this.b(canvas);
        }
    }
    
    private void b(final Canvas canvas) {
        canvas.save();
        canvas.scale(this.b, this.b);
        final float[] a = this.a(canvas);
        this.a.a(canvas, a[0], a[1]);
        canvas.restore();
    }
    
    private void b() {
        if (this.c) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.postInvalidateOnAnimation();
                return;
            }
            this.invalidate();
        }
    }
    
    @SuppressLint({ "NewApi" })
    public void onScreenStateChanged(final int n) {
        super.onScreenStateChanged(n);
        this.c = (n == 1);
        this.b();
    }
    
    protected void onVisibilityChanged(@NonNull final View view, final int n) {
        super.onVisibilityChanged(view, n);
        this.c = (n == 0);
        this.b();
    }
    
    protected void onWindowVisibilityChanged(final int n) {
        super.onWindowVisibilityChanged(n);
        this.c = (n == 0);
        this.b();
    }
    
    public final void a() {
        this.invalidate();
    }
}
