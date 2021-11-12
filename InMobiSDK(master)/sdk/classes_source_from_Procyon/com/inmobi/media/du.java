// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.app.Application;
import android.webkit.WebView;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import android.view.View;
import com.moat.analytics.mobile.inm.WebAdTracker;
import java.util.Map;
import androidx.annotation.NonNull;
import android.content.Context;
import java.lang.ref.WeakReference;

public class du extends df
{
    private static final String d;
    @NonNull
    private final WeakReference<Context> e;
    @NonNull
    private final dg f;
    @NonNull
    private final Map<String, Object> g;
    private WebAdTracker h;
    
    public du(@NonNull final h h, @NonNull final Context referent, @NonNull final dg f, @NonNull final Map<String, Object> g) {
        super(h);
        this.e = new WeakReference<Context>(referent);
        this.f = f;
        this.g = g;
    }
    
    @Nullable
    @Override
    public final View c() {
        return this.f.c();
    }
    
    @Nullable
    @Override
    public final View a(final View view, final ViewGroup viewGroup, final boolean b) {
        return this.f.a(view, viewGroup, b);
    }
    
    @Nullable
    @Override
    public final View b() {
        return this.f.b();
    }
    
    @Override
    public final void a(@Nullable final Map<View, FriendlyObstructionPurpose> map) {
        this.f();
        this.f.a(map);
    }
    
    private void f() {
        try {
            final Application d = gz.d();
            if (super.c.viewability.moatEnabled && d != null && this.g.get("enabled")) {
                if (this.h == null) {
                    if (super.a instanceof l) {
                        final l l;
                        if ((l = (l)super.a).v() != null) {
                            this.h = dt.a(d, l.v());
                        }
                    }
                    else {
                        final View b;
                        if ((b = this.f.b()) != null) {
                            this.h = dt.a(d, (WebView)b);
                        }
                    }
                }
                if (this.h != null) {
                    this.h.startTracking();
                }
            }
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
        }
    }
    
    @Override
    public final void d() {
        try {
            this.g();
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
        }
        finally {
            this.f.d();
        }
    }
    
    private void g() {
        if (this.h != null) {
            this.h.stopTracking();
        }
    }
    
    @Override
    public final void a(final byte b) {
        this.f.a(b);
    }
    
    @Override
    public final void a(final Context context, final byte b) {
        switch (b) {
            case 0: {
                this.f();
                break;
            }
            case 1: {
                this.g();
                break;
            }
        }
        this.f.a(context, b);
    }
    
    @Override
    public final void e() {
        this.h = null;
        this.e.clear();
        super.e();
        this.f.e();
    }
    
    static {
        d = du.class.getSimpleName();
    }
}
