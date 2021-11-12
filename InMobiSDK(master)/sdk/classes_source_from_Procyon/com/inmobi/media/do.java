// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import java.util.Map;
import androidx.annotation.Nullable;
import android.view.ViewGroup;
import android.view.View;
import androidx.annotation.NonNull;
import android.content.Context;
import java.lang.ref.WeakReference;

public class do extends df
{
    private static final String d;
    @NonNull
    private final WeakReference<Context> e;
    @NonNull
    private final dg f;
    @NonNull
    private final dq g;
    @NonNull
    private final l h;
    
    public do(@NonNull final Context referent, @NonNull final l h, @NonNull final dg f) {
        super(h);
        this.e = new WeakReference<Context>(referent);
        this.f = f;
        this.h = h;
        this.g = new dq((byte)1);
    }
    
    @Nullable
    @Override
    public final View a(final View view, final ViewGroup viewGroup, final boolean b) {
        final View b2;
        if ((b2 = this.f.b()) != null) {
            this.g.a(this.h.g(), b2, this.h);
        }
        return this.f.a(view, viewGroup, b);
    }
    
    @Nullable
    @Override
    public final View b() {
        return this.f.b();
    }
    
    @Override
    public final a a() {
        return this.f.a();
    }
    
    @Override
    public final void a(@Nullable final Map<View, FriendlyObstructionPurpose> map) {
        try {
            final Context context = this.e.get();
            final View b = this.f.b();
            final fe.m viewability = super.c.viewability;
            final l l = (l)super.a;
            if (context != null && b != null && !l.j) {
                this.g.a(context, b, l, viewability);
                this.g.a(context, b, this.h, this.h.v, viewability);
            }
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
        }
        finally {
            this.f.a(map);
        }
    }
    
    @Override
    public final void d() {
        try {
            final l l;
            if (!(l = (l)super.a).j) {
                this.g.a(this.e.get(), l);
            }
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
        }
        finally {
            this.f.d();
        }
    }
    
    @Override
    public final void a(final byte b) {
        this.f.a(b);
    }
    
    @Override
    public final void a(final Context context, final byte b) {
        try {
            switch (b) {
                case 0: {
                    dq.b(context);
                    break;
                }
                case 1: {
                    dq.c(context);
                    break;
                }
                case 2: {
                    this.g.a(context);
                    break;
                }
            }
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
        }
        finally {
            this.f.a(context, b);
        }
    }
    
    @Override
    public final void e() {
        this.g.a(this.h.g(), this.f.b(), this.h);
        super.e();
        this.e.clear();
        this.f.e();
    }
    
    static {
        d = do.class.getSimpleName();
    }
}
