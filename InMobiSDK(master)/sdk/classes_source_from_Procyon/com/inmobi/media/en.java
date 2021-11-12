// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.view.View;
import android.content.Context;
import android.view.ViewGroup;

public class en extends ViewGroup
{
    private static final String a;
    
    public en(final Context context) {
        super(context);
    }
    
    protected void onMeasure(final int n, final int n2) {
        this.measureChildren(n, n2);
        int max = 0;
        int max2 = 0;
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child;
            if ((child = this.getChildAt(i)).getVisibility() != 8) {
                final a a;
                final int b = (a = (a)child.getLayoutParams()).a + child.getMeasuredWidth();
                final int b2 = a.b + child.getMeasuredHeight();
                max = Math.max(max, b);
                max2 = Math.max(max2, b2);
            }
        }
        this.setMeasuredDimension(resolveSize(Math.max(max, this.getSuggestedMinimumWidth()), n), resolveSize(Math.max(max2, this.getSuggestedMinimumHeight()), n2));
    }
    
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a(-2, -2);
    }
    
    protected void onLayout(final boolean b, int i, final int n, final int n2, final int n3) {
        int childCount;
        View child;
        a a;
        for (childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            if ((child = this.getChildAt(i)).getVisibility() != 8) {
                a = (a)child.getLayoutParams();
                child.layout(a.a, a.b, a.a + child.getMeasuredWidth(), a.b + child.getMeasuredHeight());
            }
        }
    }
    
    protected boolean checkLayoutParams(final ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }
    
    protected ViewGroup.LayoutParams generateLayoutParams(final ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }
    
    static {
        a = en.class.getSimpleName();
    }
    
    public static final class a extends ViewGroup.LayoutParams
    {
        public int a;
        public int b;
        
        public a(final int n, final int n2) {
            super(n, n2);
        }
        
        public a(final ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
