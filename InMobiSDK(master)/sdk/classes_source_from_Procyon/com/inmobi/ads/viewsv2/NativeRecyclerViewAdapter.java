// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.ads.viewsv2;

import com.inmobi.media.bj;
import com.inmobi.media.ez;
import com.inmobi.media.bl;
import android.widget.FrameLayout;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import android.view.View;
import java.lang.ref.WeakReference;
import android.util.SparseArray;
import com.inmobi.media.eq;
import androidx.annotation.Nullable;
import com.inmobi.media.bn;
import com.inmobi.media.eu;
import androidx.recyclerview.widget.RecyclerView;

public class NativeRecyclerViewAdapter extends RecyclerView.Adapter<a> implements eu
{
    private static final String a;
    @Nullable
    private bn b;
    private eq c;
    private SparseArray<WeakReference<View>> d;
    
    public NativeRecyclerViewAdapter(@NonNull final bn b, @NonNull final eq c) {
        this.b = b;
        this.c = c;
        this.d = (SparseArray<WeakReference<View>>)new SparseArray();
    }
    
    @NonNull
    public a onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int n) {
        return new a((View)new FrameLayout(viewGroup.getContext()));
    }
    
    public void onBindViewHolder(@NonNull final a a, final int n) {
        final bl bl = (this.b == null) ? null : this.b.a(n);
        final WeakReference weakReference = (WeakReference)this.d.get(n);
        if (bl != null) {
            Object buildScrollableView;
            if (weakReference == null || (buildScrollableView = weakReference.get()) == null) {
                buildScrollableView = this.buildScrollableView(n, a.b, bl);
            }
            if (buildScrollableView != null) {
                if (n != this.getItemCount() - 1) {
                    a.b.setPadding(0, 0, 16, 0);
                }
                a.b.addView((View)buildScrollableView);
                this.d.put(n, (Object)new WeakReference(buildScrollableView));
            }
        }
    }
    
    public void onViewRecycled(@NonNull final a a) {
        a.b.removeAllViews();
        super.onViewRecycled((RecyclerView.ViewHolder)a);
    }
    
    public ViewGroup buildScrollableView(final int n, @NonNull final ViewGroup viewGroup, @NonNull final bl bl) {
        final ViewGroup a = this.c.a(viewGroup, bl);
        this.c.b(a, bl);
        a.setLayoutParams(ez.a(bl, viewGroup));
        return a;
    }
    
    public int getItemCount() {
        if (this.b == null) {
            return 0;
        }
        return this.b.c();
    }
    
    public void destroy() {
        if (this.b != null) {
            final bn b;
            (b = this.b).h = null;
            b.f = null;
            this.b = null;
        }
        this.c = null;
    }
    
    static {
        a = NativeRecyclerViewAdapter.class.getSimpleName();
    }
    
    final class a extends RecyclerView.ViewHolder
    {
        private ViewGroup b;
        
        a(final View view) {
            super(view);
            this.b = (ViewGroup)view;
        }
    }
}
