// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.content.Context;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import java.util.Map;
import android.view.ViewGroup;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

public class dn extends dg
{
    private static final String d;
    @NonNull
    private final dg e;
    @NonNull
    private final dm f;
    private final int g;
    private final int h;
    
    public dn(@NonNull final h h, @NonNull final dm f, @NonNull final dg e, final int g, final int h2) {
        super(h);
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h2;
    }
    
    @Nullable
    @Override
    public final a a() {
        return this.e.a();
    }
    
    @Nullable
    @Override
    public final View b() {
        return this.e.b();
    }
    
    @Nullable
    @Override
    public final View c() {
        return this.e.c();
    }
    
    @Nullable
    @Override
    public final View a(final View view, final ViewGroup viewGroup, final boolean b) {
        final View b2;
        if ((b2 = this.e.b()) != null) {
            this.f.a(b2);
        }
        return this.e.a(view, viewGroup, b);
    }
    
    @Override
    public final void a(@Nullable final Map<View, FriendlyObstructionPurpose> map) {
        final View b;
        if ((b = this.e.b()) != null) {
            final dm f = this.f;
            final View view = b;
            f.a(view, view, this.g, this.h);
            this.e.a(map);
        }
    }
    
    @Override
    public final void d() {
        final View b;
        if ((b = this.e.b()) != null) {
            this.f.a(b);
            this.e.d();
        }
    }
    
    @Override
    public final void a(final byte b) {
    }
    
    @Override
    public final void a(final Context context, final byte b) {
        try {
            switch (b) {
                case 0: {
                    this.f.b();
                    break;
                }
                case 1: {
                    this.f.a();
                    break;
                }
                case 2: {
                    this.f.d();
                    break;
                }
            }
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
        }
        finally {
            this.e.a(context, b);
        }
    }
    
    @Override
    public final void e() {
        this.f.d();
        super.e();
    }
    
    static {
        d = dn.class.getSimpleName();
    }
}
