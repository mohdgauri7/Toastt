// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.os.Looper;
import android.annotation.TargetApi;
import android.view.ViewGroup;
import android.view.View;
import android.util.SparseArray;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

final class eo extends PagerAdapter implements eu
{
    private static final String a;
    private boolean b;
    @NonNull
    private final bn c;
    private eq d;
    private static Handler e;
    @NonNull
    private SparseArray<Runnable> f;
    
    eo(@NonNull final bn c, @NonNull final eq d) {
        this.f = (SparseArray<Runnable>)new SparseArray();
        this.c = c;
        this.d = d;
    }
    
    public final int getItemPosition(Object o) {
        if ((o = ((o == null) ? null : ((View)o).getTag())) instanceof Integer) {
            return (int)o;
        }
        return -2;
    }
    
    public final int getCount() {
        return this.c.c();
    }
    
    public final boolean isViewFromObject(@NonNull final View view, @NonNull final Object obj) {
        return view.equals(obj);
    }
    
    @TargetApi(21)
    public final Object instantiateItem(@NonNull final ViewGroup viewGroup, final int i) {
        final bl a;
        if ((a = this.c.a(i)) == null) {
            return null;
        }
        final bl bl = a;
        final ViewGroup a2 = this.d.a(viewGroup, bl);
        final int abs = Math.abs(this.d.a - i);
        final Runnable runnable = new Runnable() {
            @Override
            public final void run() {
                if (eo.this.b) {
                    return;
                }
                eo.this.f.remove(i);
                eo.this.d.b(a2, bl);
            }
        };
        this.f.put(i, (Object)runnable);
        eo.e.postDelayed((Runnable)runnable, (long)(abs * 50));
        final ViewGroup viewGroup2;
        (viewGroup2 = a2).setLayoutParams(ez.a(a, viewGroup));
        viewGroup2.setTag((Object)i);
        viewGroup.addView((View)viewGroup2);
        return viewGroup2;
    }
    
    public final void destroyItem(@NonNull final ViewGroup viewGroup, final int n, @NonNull final Object o) {
        viewGroup.removeView((View)o);
        final Runnable runnable;
        if ((runnable = (Runnable)this.f.get(n)) != null) {
            eo.e.removeCallbacks(runnable);
            ez.class.getSimpleName();
        }
        eo.e.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                eo.this.d.c.a((View)o);
            }
        });
    }
    
    public final void destroy() {
        this.b = true;
        for (int size = this.f.size(), i = 0; i < size; ++i) {
            eo.e.removeCallbacks((Runnable)this.f.get(this.f.keyAt(i)));
        }
        this.f.clear();
    }
    
    static {
        a = eo.class.getSimpleName();
        eo.e = new Handler(Looper.getMainLooper());
    }
}
