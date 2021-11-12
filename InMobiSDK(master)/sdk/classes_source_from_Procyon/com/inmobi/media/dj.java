// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import java.util.Map;
import androidx.annotation.Nullable;
import android.content.Context;
import android.view.ViewGroup;
import android.view.View;
import androidx.annotation.NonNull;

public final class dj extends dg
{
    @NonNull
    private final m d;
    private boolean e;
    
    public dj(@NonNull final m d) {
        super(d);
        this.e = false;
        this.d = d;
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
        a = this.b.a(a, viewGroup, false, null);
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
        super.e();
    }
}
