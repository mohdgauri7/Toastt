// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.widget.RelativeLayout;
import android.widget.FrameLayout;
import android.view.View;
import androidx.annotation.Nullable;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

public final class cm
{
    @NonNull
    public o a;
    @Nullable
    public ViewGroup b;
    public int c;
    
    public cm(@NonNull final o a) {
        this.a = a;
    }
    
    public final void a() {
        if (this.b == null) {
            this.b = (ViewGroup)this.a.getParent();
            this.c = this.b.indexOfChild((View)this.a);
        }
        final co resizeProperties = this.a.getResizeProperties();
        this.b();
        this.a(resizeProperties);
    }
    
    private void b() {
        if (this.b != null) {
            final FrameLayout frameLayout = new FrameLayout(this.a.getContainerContext());
            final ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.a.getWidth(), this.a.getHeight());
            frameLayout.setId(65535);
            this.b.addView((View)frameLayout, this.c, layoutParams);
            this.b.removeView((View)this.a);
        }
    }
    
    private void a(final co co) {
        final float c = ho.a().c;
        final int n = (int)(co.width * c + 0.5f);
        final int n2 = (int)(co.height * c + 0.5f);
        final View view;
        if ((view = ((this.b == null) ? null : this.b.getRootView())) != null) {
            final FrameLayout frameLayout = (FrameLayout)view.findViewById(16908290);
            final FrameLayout frameLayout2 = new FrameLayout(this.a.getContainerContext());
            final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            final RelativeLayout relativeLayout = new RelativeLayout(this.a.getContainerContext());
            final FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(n, n2);
            final RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(n, n2);
            frameLayout2.setId(65534);
            final ViewGroup viewGroup;
            if ((viewGroup = ((this.a.getParent() instanceof ViewGroup) ? this.a.getParent() : null)) != null) {
                viewGroup.removeAllViews();
            }
            relativeLayout.addView((View)this.a, (ViewGroup.LayoutParams)layoutParams3);
            this.a((ViewGroup)relativeLayout, co.customClosePosition);
            frameLayout2.addView((View)relativeLayout, (ViewGroup.LayoutParams)layoutParams2);
            frameLayout.addView((View)frameLayout2, (ViewGroup.LayoutParams)layoutParams);
            a(frameLayout, frameLayout2, co, this.b);
            frameLayout2.setBackgroundColor(0);
            return;
        }
        hf.a((byte)1, cm.class.getSimpleName(), "Couldn't process resize request as root view was found null.");
    }
    
    private void a(final ViewGroup viewGroup, final String s) {
        final float c = ho.a().c;
        final cf cf;
        (cf = new cf(this.a.getContainerContext(), c, (byte)1)).setId(65531);
        cf.setOnClickListener((View.OnClickListener)new View.OnClickListener() {
            public final void onClick(final View view) {
                cm.this.a.b();
            }
        });
        viewGroup.addView((View)cf, (ViewGroup.LayoutParams)a(s, c));
    }
    
    private static RelativeLayout.LayoutParams a(String a, final float n) {
        a = a(a);
        final RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int)(50.0f * n), (int)(50.0f * n));
        if ("top-right".equals(a) || "bottom-right".equals(a)) {
            layoutParams.addRule(11);
        }
        if ("bottom-right".equals(a) || "bottom-left".equals(a) || "bottom-center".equals(a)) {
            layoutParams.addRule(12);
            layoutParams.addRule(4);
        }
        if ("bottom-center".equals(a) || "top-center".equals(a) || "center".equals(a)) {
            layoutParams.addRule(13);
        }
        if ("top-center".equals(a)) {
            layoutParams.addRule(10);
        }
        return layoutParams;
    }
    
    private static String a(final String anObject) {
        if (anObject == null || 0 == anObject.length()) {
            return "top-right";
        }
        if (!"top-left".equals(anObject) && !"top-right".equals(anObject) && !"bottom-left".equals(anObject) && !"bottom-right".equals(anObject) && !"top-center".equals(anObject) && !"bottom-center".equals(anObject) && !"center".equals(anObject)) {
            return "top-right";
        }
        return anObject;
    }
    
    private static void a(final FrameLayout frameLayout, final FrameLayout frameLayout2, final co co, @NonNull final ViewGroup viewGroup) {
        final float c = ho.a().c;
        final int n = (int)(co.width * c + 0.5f);
        final int n2 = (int)(co.height * c + 0.5f);
        final int n3 = (int)(co.offsetX * c + 0.5f);
        final int n4 = (int)(co.offsetY * c + 0.5f);
        final int[] array = new int[2];
        final int[] array2 = new int[2];
        viewGroup.getLocationOnScreen(array);
        frameLayout.getLocationOnScreen(array2);
        final int[] array3 = array;
        final int n5 = 1;
        array3[n5] -= array2[1];
        final int[] array4 = array;
        final int n6 = 0;
        array4[n6] -= array2[0];
        final int[] array5 = array;
        final int n7 = 0;
        array5[n7] += n3;
        final int[] array6 = array;
        final int n8 = 1;
        array6[n8] += n4;
        if (!co.allowOffscreen) {
            if (n > frameLayout.getWidth() - array[0]) {
                array[0] = frameLayout.getWidth() - n;
            }
            if (n2 > frameLayout.getHeight() - array[1]) {
                array[1] = frameLayout.getHeight() - n2;
            }
            if (array[0] < 0) {
                array[0] = 0;
            }
            if (array[1] < 0) {
                array[1] = 0;
            }
        }
        final FrameLayout.LayoutParams layoutParams;
        (layoutParams = new FrameLayout.LayoutParams(n, n2)).leftMargin = array[0];
        layoutParams.topMargin = array[1];
        layoutParams.gravity = 8388611;
        frameLayout2.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }
}
