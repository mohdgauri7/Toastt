// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Map;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.UiThread;
import com.inmobi.ads.InMobiAdRequestStatus;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import android.content.Context;
import android.view.View;
import java.lang.ref.WeakReference;

public final class ae extends t
{
    public static final String x;
    public WeakReference<View> y;
    public boolean z;
    private int A;
    
    ae(@NonNull final Context context, @NonNull final aq aq, @Nullable final a a) {
        super(context, aq, a);
        this.z = false;
        this.A = 0;
        aq.e();
        this.a(context, aq, a);
    }
    
    @Override
    public final void a(final Context context) {
        super.a(context);
        this.b(context);
    }
    
    private boolean aa() {
        final a p = this.p();
        if (this.x()) {
            if (p != null) {
                p.a(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.MISSING_REQUIRED_DEPENDENCIES));
            }
            return false;
        }
        if (1 == this.j() || 2 == this.j()) {
            hf.a((byte)1, ae.x, "An ad load is already in progress. Please wait for the load to complete before requesting for another ad");
            return false;
        }
        hf.a((byte)2, ae.x, "Fetching a Native ad for placement id: " + this.i().toString());
        if (4 == this.j()) {
            if (!this.q()) {
                if (p != null) {
                    this.b(this.h());
                    this.b(p);
                    this.c(p);
                }
                return false;
            }
            this.Y();
        }
        super.l = false;
        return true;
    }
    
    @UiThread
    @Override
    public final void y() {
        if (super.l) {
            return;
        }
        if (this.aa()) {
            super.y();
        }
    }
    
    @VisibleForTesting
    private void b(final Context context) {
        final h s;
        if ((s = this.s()) instanceof l) {
            ((l)s).a(context);
        }
    }
    
    @UiThread
    @Override
    protected final void a(@NonNull final aq aq, final boolean b) {
        super.a(aq, b);
        if (!b) {
            if (this.i().equals(aq) && (2 == this.j() || 4 == this.j())) {
                super.b = 0;
                if (this.p() != null) {
                    this.p().a(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_NO_LONGER_AVAILABLE));
                }
            }
        }
        else if (this.i().equals(aq) && 2 == this.j() && this.p() != null && this.h() != null) {
            if (super.j) {
                super.k = true;
                this.O();
                return;
            }
            this.P();
        }
    }
    
    @UiThread
    @Override
    protected final void b(@NonNull final ar ar) {
        if ("html".equals(this.n())) {
            this.a(this.i(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (byte)57);
            return;
        }
        super.b(ar);
    }
    
    @Override
    final void a(final boolean b, @NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
        super.a(b, inMobiAdRequestStatus);
        final a p2;
        if (this.j() == 2 && (p2 = this.p()) != null) {
            this.b(p2);
        }
    }
    
    @UiThread
    @Override
    public final void S() {
        this.F();
        try {
            if (this.R()) {
                return;
            }
            this.T();
        }
        catch (IllegalStateException ex) {
            this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (byte)48);
        }
    }
    
    @UiThread
    @Override
    public final void a(ak u, final boolean b, final byte b2) {
        if (!b) {
            this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, b2);
            return;
        }
        try {
            try {
                super.a(u, b, b2);
            }
            catch (IllegalStateException ex) {}
            if ((u = this.u()) == null) {
                this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (byte)55);
                return;
            }
            if (super.h == 0) {
                if (!u.d()) {
                    this.l(null);
                }
            }
            else {
                this.a(u);
            }
            if (u.d()) {
                this.j = true;
                this.N();
            }
        }
        catch (Exception ex2) {
            this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (byte)13);
        }
    }
    
    @Override
    final void P() {
        this.w.a(this.hashCode(), new af(this));
    }
    
    public final void Y() {
        try {
            super.D();
        }
        catch (Exception ex) {
            hf.a((byte)1, "InMobi", "Could not destroy native ad; SDK encountered unexpected error");
            fv.a().a(new gv(ex));
        }
    }
    
    public final boolean Z() {
        return this.j() == 4;
    }
    
    @Override
    public final String k() {
        return "native";
    }
    
    @Override
    protected final byte l() {
        return 0;
    }
    
    @NonNull
    @Override
    protected final Map<String, String> m() {
        final Map<String, String> m;
        (m = super.m()).put("a-parentViewWidth", String.valueOf(ho.a().a));
        m.put("a-productVersion", "NS-1.0.0-20160411");
        m.put("trackerType", "url_ping");
        return m;
    }
    
    @Override
    final void f(final a a) {
        if (this.j() == 4) {
            super.b = 6;
        }
        else if (this.j() == 6) {
            ++this.A;
        }
        hf.a((byte)2, "InMobi", "Successfully displayed fullscreen for placement id: " + this.i().toString());
        if (this.A == 0) {
            if (a != null) {
                this.d(a);
                return;
            }
            hf.a((byte)2, "InMobi", "Listener was garbage collected. Unable to give callback");
        }
    }
    
    @Override
    final void g(final a a) {
        if (this.j() == 6) {
            if (this.A > 0) {
                --this.A;
            }
            else {
                super.b = 4;
            }
        }
        hf.a((byte)2, "InMobi", "Successfully dismissed fullscreen for placement id: " + this.i().toString());
        if (this.A == 0 && this.j() == 4) {
            if (a != null) {
                a.c();
                return;
            }
            hf.a((byte)2, "InMobi", "Listener was garbage collected. Unable to give callback");
        }
    }
    
    @Override
    public final void a(final int n, final o o) {
    }
    
    @Override
    public final void b() {
    }
    
    @Override
    public final void b(final o o) {
    }
    
    static {
        x = ae.class.getSimpleName();
    }
}
