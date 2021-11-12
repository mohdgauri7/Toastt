// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.lang.ref.WeakReference;
import android.animation.TimeInterpolator;
import android.view.animation.LinearInterpolator;
import java.util.concurrent.TimeUnit;
import android.graphics.Xfermode;
import android.graphics.PorterDuffXfermode;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.content.Context;
import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.view.View;

public class bu extends View
{
    private Bitmap d;
    private Canvas e;
    private RectF f;
    private RectF g;
    private Rect h;
    public long a;
    private Paint i;
    private Paint j;
    private Paint k;
    private Paint l;
    private Paint m;
    private float n;
    public long b;
    public ValueAnimator c;
    private b o;
    
    public bu(final Context context) {
        this(context, (byte)0);
    }
    
    private bu(final Context context, final byte b) {
        this(context, '\0');
    }
    
    private bu(final Context context, final char c) {
        super(context, (AttributeSet)null, 0);
        this.a = 0L;
        (this.i = new Paint()).setAntiAlias(true);
        this.i.setColor(-723724);
        (this.m = new Paint()).setAntiAlias(true);
        this.m.setColor(-16777216);
        this.m.setTextAlign(Paint.Align.CENTER);
        this.m.setAntiAlias(true);
        this.h = new Rect();
        (this.j = new Paint()).setAntiAlias(true);
        this.j.setColor(-16777216);
        (this.k = new Paint()).setAntiAlias(true);
        this.k.setColor(0);
        this.k.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        (this.l = new Paint()).setStyle(Paint.Style.STROKE);
        this.l.setAntiAlias(true);
        this.l.setColor(-16777216);
    }
    
    public void setTimerEventsListener(final b o) {
        this.o = o;
    }
    
    protected void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n);
    }
    
    protected void onSizeChanged(final int n, final int n2, final int n3, final int n4) {
        if (n != n3 || n2 != n4) {
            (this.d = Bitmap.createBitmap(n, n2, Bitmap.Config.ARGB_8888)).eraseColor(0);
            this.e = new Canvas(this.d);
        }
        super.onSizeChanged(n, n2, n3, n4);
        final float n5 = (float)ho.a((int)(4.0f * this.getWidth() * 0.007f));
        final float textSize = (float)ho.a((int)(14.0f * this.getWidth() * 0.007f));
        final float n6 = (float)ho.a((int)(5.0f * this.getWidth() * 0.007f));
        final float strokeWidth = (float)ho.a((int)(1.5f * this.getWidth() * 0.007f));
        final float n7 = n6;
        this.f = new RectF(n7, n7, this.getWidth() - n6, this.getHeight() - n6);
        this.g = new RectF(this.f.left + n5, this.f.top + n5, this.f.right - n5, this.f.bottom - n5);
        this.l.setStrokeWidth(strokeWidth);
        this.m.setTextSize(textSize);
        this.invalidate();
    }
    
    protected void onDraw(final Canvas canvas) {
        this.e.drawColor(0, PorterDuff.Mode.CLEAR);
        final int a = this.getWidth() / 2;
        final int b = this.getHeight() / 2;
        final int min = Math.min(a, b);
        final int a2 = ho.a((int)(7.0f * this.getWidth() * 0.007f));
        canvas.drawCircle((float)a, (float)b, (float)min, this.i);
        canvas.drawCircle((float)a, (float)b, (float)(min - a2), this.l);
        if (this.c != null) {
            int i = (int)(this.a - this.c.getCurrentPlayTime() / 1000L);
            if ((float)this.c.getAnimatedValue() >= 1.0) {
                i = 0;
            }
            final Paint m = this.m;
            final Rect h = this.h;
            final String value = String.valueOf(i);
            final Rect rect = h;
            final Paint paint = m;
            paint.getTextBounds(value, 0, value.length(), rect);
            canvas.drawText(value, (float)(this.getWidth() / 2), this.getHeight() / 2 + ((paint.descent() - paint.ascent()) / 2.0f - paint.descent()), paint);
            if ((float)this.c.getAnimatedValue() >= 1.0) {
                this.c();
            }
        }
        if (this.n > 0.0f) {
            this.e.drawArc(this.f, 270.0f, this.n, true, this.j);
            this.e.drawOval(this.g, this.k);
        }
        canvas.drawBitmap(this.d, 0.0f, 0.0f, (Paint)null);
    }
    
    public void setTimerValue(final long a) {
        this.a = a;
    }
    
    public final void a() {
        (this.c = ValueAnimator.ofFloat(new float[] { 0.0f, 1.0f })).setDuration(TimeUnit.SECONDS.toMillis(this.a));
        this.c.setInterpolator((TimeInterpolator)new LinearInterpolator());
        this.c.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(this));
        this.c.start();
    }
    
    public final void b() {
        if (this.c != null && this.c.isRunning()) {
            this.b = this.c.getCurrentPlayTime();
            this.c.cancel();
        }
    }
    
    public final void a(final float n) {
        this.n = 360.0f * n;
        this.invalidate();
    }
    
    private void c() {
        if (this.o != null) {
            this.o.a();
            this.c.cancel();
            this.c = null;
        }
    }
    
    public static final class a implements ValueAnimator.AnimatorUpdateListener
    {
        public WeakReference<bu> a;
        
        public a(final bu referent) {
            this.a = new WeakReference<bu>(referent);
        }
        
        public final void onAnimationUpdate(final ValueAnimator valueAnimator) {
            final bu bu;
            if ((bu = this.a.get()) == null) {
                return;
            }
            final int visibility;
            if ((visibility = bu.getVisibility()) == 4 || visibility == 8) {
                if ((float)valueAnimator.getAnimatedValue() >= 1.0) {
                    bu.c();
                }
            }
            else {
                bu.a((float)valueAnimator.getAnimatedValue());
            }
        }
    }
    
    public interface b
    {
        void a();
    }
}
