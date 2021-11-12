// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.content.Context;
import androidx.annotation.Nullable;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import java.util.Map;
import android.view.ViewGroup;
import android.view.View;
import androidx.annotation.NonNull;

public final class dh extends dg
{
    @NonNull
    private final o d;
    
    public dh(@NonNull final o d) {
        super(d);
        this.d = d;
    }
    
    @Override
    public final View c() {
        this.a((View)this.d);
        return (View)this.d;
    }
    
    @Override
    public final View a(final View view, final ViewGroup viewGroup, final boolean b) {
        return this.c();
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
}
