// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import java.util.Map;
import android.content.Context;
import android.view.ViewGroup;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

public final class di extends dg
{
    @NonNull
    private final l d;
    private boolean e;
    @Nullable
    private o f;
    
    public di(@NonNull final l d, @Nullable final o f) {
        super(d);
        this.e = false;
        this.d = d;
        this.f = f;
    }
    
    @Nullable
    @Override
    public final View a(View a, final ViewGroup viewGroup, final boolean b) {
        if (this.e) {
            return null;
        }
        final Context m;
        if ((m = this.d.m()) == null) {
            return null;
        }
        this.b = new ep(m, super.c, this.d, this.d.k());
        hf.a((byte)2, "InMobi", "Ad markup loaded into the container will be inflated into a View.");
        a = this.b.a(a, viewGroup, b, this.f);
        this.a(a);
        this.d.w();
        return a;
    }
    
    @Override
    public final void a(@Nullable final Map<View, FriendlyObstructionPurpose> map) {
    }
    
    @Override
    public final void d() {
    }
    
    @Override
    public final void a(final byte b) {
    }
    
    @Override
    public final void a(final Context context, final byte b) {
    }
    
    @Override
    public final void e() {
        if (this.e) {
            return;
        }
        this.e = true;
        if (this.b != null) {
            this.b.a();
            this.b = null;
        }
        if (this.f != null) {
            this.f.destroy();
            this.f = null;
        }
        super.e();
    }
}
