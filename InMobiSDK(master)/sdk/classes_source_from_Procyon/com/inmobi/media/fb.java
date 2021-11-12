// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import com.inmobi.ads.viewsv2.NativeRecyclerViewAdapter;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;

@SuppressLint({ "ViewConstructor" })
class fb extends et
{
    private RecyclerView a;
    private boolean b;
    
    public fb(final Context context) {
        super(context, (byte)1);
        this.b = false;
    }
    
    public final void a(@NonNull final bl bl, final eu eu, final int n, final int gravity, final a a) {
        final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)ez.a(bl.a(0), (ViewGroup)this);
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(20);
            layoutParams.setMarginEnd(20);
        }
        else {
            layoutParams.setMargins(20, 0, 20, 0);
        }
        layoutParams.gravity = gravity;
        (this.a = new RecyclerView(this.getContext())).setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        this.a.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(this.getContext(), 0, false));
        this.addView((View)this.a);
        this.a.setAdapter((RecyclerView.Adapter)eu);
    }
}
