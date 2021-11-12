// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import android.view.View;
import android.graphics.Paint;
import android.content.Context;
import androidx.annotation.Nullable;
import android.graphics.Point;
import androidx.viewpager.widget.ViewPager;

class fc extends et implements ViewPager.OnPageChangeListener
{
    private static final String b;
    private ViewPager c;
    private Point d;
    private Point e;
    private boolean f;
    private boolean g;
    @Nullable
    a a;
    
    public fc(final Context context) {
        super(context, (byte)0);
        this.d = new Point();
        this.e = new Point();
        this.setClipChildren(this.g = false);
        this.setLayerType(1, (Paint)null);
        (this.c = new ViewPager(this.getContext())).addOnPageChangeListener((ViewPager.OnPageChangeListener)this);
        this.addView((View)this.c);
    }
    
    public final void a(@NonNull final bl bl, @NonNull final eu eu, final int currentItem, final int gravity, @NonNull final a a) {
        final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)ez.a(bl.a(0), (ViewGroup)this);
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(20);
            layoutParams.setMarginEnd(20);
        }
        else {
            layoutParams.setMargins(20, 0, 20, 0);
        }
        layoutParams.gravity = gravity;
        this.c.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.c.setAdapter((PagerAdapter)eu);
        this.c.setOffscreenPageLimit(2);
        this.c.setPageMargin(16);
        this.c.setCurrentItem(currentItem);
        this.a = a;
    }
    
    protected void onSizeChanged(final int n, final int n2, final int n3, final int n4) {
        this.d.x = n / 2;
        this.d.y = n2 / 2;
    }
    
    public boolean onTouchEvent(@NonNull final MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1: {
                final float n = (float)this.e.x;
                final float x = motionEvent.getX();
                final float n2 = n;
                final int currentItem = this.c.getCurrentItem();
                final int count = this.c.getAdapter().getCount();
                final int width = this.c.getWidth();
                final int width2 = this.getWidth();
                int n5;
                int n4;
                if (currentItem == 0 || count - 1 == currentItem) {
                    final int n3 = width2 - width;
                    n4 = ((currentItem == 0) ? ((n2 > n3 && x > n3) ? (n5 = (int)Math.ceil((x - n3) / width)) : (n5 = 0)) : ((n2 < n3 && x < n3) ? (n5 = -(int)Math.ceil((n3 - x) / width)) : (n5 = 0)));
                }
                else {
                    final int n6 = (width2 - width) / 2;
                    if (n2 < n6 && x < n6) {
                        n4 = (n5 = -(int)Math.ceil((n6 - x) / width));
                    }
                    else {
                        final int n7 = (width2 + width) / 2;
                        n4 = (n5 = ((n2 > n7 && x > n7) ? ((int)Math.ceil((x - n7) / width)) : 0));
                    }
                }
                final int n8 = n5;
                if (n4 != 0) {
                    motionEvent.setAction(3);
                    this.c.setCurrentItem(this.c.getCurrentItem() + n8);
                }
                motionEvent.offsetLocation((float)(this.d.x - this.e.x), (float)(this.d.y - this.e.y));
                return this.c.dispatchTouchEvent(motionEvent);
            }
            case 0: {
                this.e.x = (int)motionEvent.getX();
                this.e.y = (int)motionEvent.getY();
                break;
            }
        }
        motionEvent.offsetLocation((float)(this.d.x - this.e.x), (float)(this.d.y - this.e.y));
        return this.c.dispatchTouchEvent(motionEvent);
    }
    
    public void onPageScrolled(final int n, final float n2, final int n3) {
        if (this.f) {
            this.invalidate();
        }
    }
    
    public void onPageSelected(final int n) {
        final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.c.getLayoutParams();
        if (this.a != null) {
            layoutParams.gravity = this.a.a(n);
            this.c.requestLayout();
        }
    }
    
    public void onPageScrollStateChanged(final int n) {
        this.f = (n != 0);
    }
    
    static {
        b = fc.class.getSimpleName();
    }
}
