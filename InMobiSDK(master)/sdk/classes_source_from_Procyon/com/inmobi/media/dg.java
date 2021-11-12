// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.content.Context;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import java.util.Map;
import android.view.ViewGroup;
import android.view.View;
import java.lang.ref.WeakReference;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

public abstract class dg
{
    @NonNull
    protected h a;
    @Nullable
    a b;
    @Nullable
    private WeakReference<View> d;
    @NonNull
    protected fe c;
    
    public dg(@NonNull final h a) {
        this.a = a;
        this.c = a.getAdConfig();
    }
    
    @Nullable
    public a a() {
        return this.b;
    }
    
    protected final void a(final View referent) {
        this.d = new WeakReference<View>(referent);
    }
    
    @Nullable
    public View b() {
        if (this.d == null) {
            return null;
        }
        return this.d.get();
    }
    
    @Nullable
    public View c() {
        return null;
    }
    
    @Nullable
    public abstract View a(final View p0, final ViewGroup p1, final boolean p2);
    
    public abstract void a(@Nullable final Map<View, FriendlyObstructionPurpose> p0);
    
    public abstract void d();
    
    public abstract void a(final byte p0);
    
    public abstract void a(final Context p0, final byte p1);
    
    public void e() {
        if (this.d != null) {
            this.d.clear();
        }
    }
    
    public abstract static class a
    {
        public boolean a;
        
        public abstract View a(final View p0, final ViewGroup p1, final boolean p2, final o p3);
        
        public void a() {
            if (this.a) {
                return;
            }
            this.a = true;
        }
    }
}
