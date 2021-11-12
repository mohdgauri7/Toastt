// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.os.SystemClock;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import android.view.View;
import java.util.Map;
import android.view.ViewGroup;
import com.inmobi.ads.controllers.PublisherCallbacks;
import androidx.annotation.UiThread;
import android.widget.RelativeLayout;
import com.inmobi.ads.InMobiBanner;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.AdMetaInfo;
import androidx.annotation.NonNull;
import android.content.Context;
import androidx.annotation.Nullable;

public class x extends aj
{
    private static final String k;
    private static final String l = "InMobi";
    @Nullable
    private w m;
    @Nullable
    private w n;
    @Nullable
    private w o;
    @Nullable
    private w p;
    
    public void a(@NonNull final Context context, @NonNull final bc bc, @NonNull final String s) {
        final aq a = new aq.a("banner", "InMobi").b(com.inmobi.media.d.a(context)).a(bc.a).c(bc.b).a(bc.c).a(s).a(bc.d).d(bc.e).e(bc.f).a();
        if (this.m == null || this.n == null) {
            this.m = new w(context, a, this);
            this.n = new w(context, a, this);
            this.p = this.m;
            return;
        }
        this.m.a(context, a, this);
        this.n.a(context, a, this);
    }
    
    @Override
    public final void a(@NonNull final AdMetaInfo j) {
        this.j = j;
        final InMobiAdRequestStatus inMobiAdRequestStatus = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR);
        if (this.p == null) {
            this.a(null, inMobiAdRequestStatus);
            return;
        }
        if (this.p.u() == null) {
            this.a(null, inMobiAdRequestStatus);
            return;
        }
        super.a(j);
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                if (x.this.h != null) {
                    x.this.h.onAdFetchSuccessful(j);
                }
            }
        });
    }
    
    @Override
    public void b(@NonNull final AdMetaInfo adMetaInfo) {
        super.b(adMetaInfo);
        this.f = 0;
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                if (x.this.h != null) {
                    x.this.h.onAdLoadSucceeded(adMetaInfo);
                }
            }
        });
    }
    
    @Override
    public void c() {
        this.f = 0;
        super.c();
    }
    
    @Override
    public void j() {
        final t m;
        if ((m = this.m()) != null) {
            m.b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
        }
    }
    
    @UiThread
    @Override
    public void a(final int n, final int n2, final o o) {
        super.a(n, n2, o);
        try {
            final InMobiBanner inMobiBanner;
            if ((inMobiBanner = (InMobiBanner)o.getParent()) != null && this.o != null) {
                this.o.a(n, true, n2);
                this.c(inMobiBanner);
                this.i.post((Runnable)new Runnable() {
                    @Override
                    public final void run() {
                        if (x.this.o != null) {
                            x.this.o.d(n2);
                        }
                    }
                });
                return;
            }
            this.o.a(n, false, n2);
        }
        catch (Exception ex) {
            this.o.a(n, false, n2);
        }
    }
    
    public boolean l() {
        return this.p != null && this.p.j() != 4 && this.p.j() != 1 && this.p.j() != 2 && (this.o == null || this.o.j() != 7);
    }
    
    @Nullable
    @Override
    public t m() {
        if (this.y()) {
            return this.o;
        }
        return this.p;
    }
    
    private boolean y() {
        return this.o != null && (this.o.j() == 4 || this.o.j() == 7 || this.o.j() == 6);
    }
    
    @UiThread
    public void a(@NonNull final PublisherCallbacks h, @NonNull final String s, final boolean b) {
        if (this.g != null && !this.g) {
            if (this.p != null) {
                this.p.b((byte)52);
            }
            hf.a((byte)1, "InMobi", "Cannot call load() API after calling load(byte[])");
            return;
        }
        this.g = Boolean.TRUE;
        if (this.p != null && this.a("InMobi", this.p.i().toString(), h)) {
            this.f = 1;
            this.j = null;
            this.h = h;
            this.p.c(s);
            this.p.b(b);
        }
    }
    
    public void n() throws IllegalStateException {
        if (this.p == null) {
            throw new IllegalStateException("Please make an ad request first in order to start loading the ad.");
        }
        if (this.a("InMobi", this.p.i().toString())) {
            this.f = 8;
            if (this.p.e((byte)1)) {
                this.p.S();
            }
        }
    }
    
    public void o() {
        if (this.p != null) {
            this.p.z();
        }
    }
    
    @Override
    public void a(final byte[] array, @NonNull final PublisherCallbacks h) {
        if (this.g != null && this.g) {
            hf.a((byte)1, "InMobi", "Cannot call load(byte[]) API after load() API is called");
            return;
        }
        this.g = Boolean.FALSE;
        this.f = 1;
        if (this.p != null && (this.o == null || !this.o.A())) {
            this.h = h;
            this.p.l = false;
            this.p.a(array);
        }
    }
    
    public void p() {
        if (this.o == null) {
            this.o = this.m;
            this.p = this.n;
            return;
        }
        if (this.o.equals(this.m)) {
            this.o = this.n;
            this.p = this.m;
            return;
        }
        if (this.o.equals(this.n)) {
            this.o = this.m;
            this.p = this.n;
        }
    }
    
    public void a(@NonNull final RelativeLayout relativeLayout) {
        if (this.o == null) {
            return;
        }
        final o o;
        if ((o = (o)this.o.s()) == null) {
            return;
        }
        final dg viewableAd = o.getViewableAd();
        if (this.o.i().f()) {
            o.a();
        }
        final ViewGroup viewGroup = (ViewGroup)o.getParent();
        final RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        final View c = viewableAd.c();
        viewableAd.a((Map<View, FriendlyObstructionPurpose>)null);
        if (this.p != null) {
            this.p.Z();
        }
        if (viewGroup == null) {
            relativeLayout.addView(c, (ViewGroup.LayoutParams)layoutParams);
        }
        else {
            viewGroup.removeAllViews();
            viewGroup.addView(c, (ViewGroup.LayoutParams)layoutParams);
        }
        this.p.D();
    }
    
    public void q() {
        if (this.o != null) {
            this.o.aa();
        }
    }
    
    public void r() {
        if (this.o != null) {
            this.o.Z();
        }
    }
    
    public int a(int minimumRefreshInterval, final int n) {
        if (this.p != null) {
            if (minimumRefreshInterval < this.p.o().minimumRefreshInterval) {
                minimumRefreshInterval = this.p.o().minimumRefreshInterval;
            }
            return minimumRefreshInterval;
        }
        return n;
    }
    
    public int s() {
        final t m;
        if ((m = this.m()) != null) {
            return m.o().defaultRefreshInterval;
        }
        return -1;
    }
    
    public boolean a(final long n) {
        if (this.p == null) {
            return false;
        }
        final int minimumRefreshInterval = this.p.o().minimumRefreshInterval;
        if (SystemClock.elapsedRealtime() - n < minimumRefreshInterval * 1000) {
            this.a((byte)16);
            this.c(this.p, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.EARLY_REFRESH_REQUEST).setCustomMessage("Ad cannot be refreshed before " + minimumRefreshInterval + " seconds"));
            hf.a((byte)1, x.k, "Ad cannot be refreshed before " + minimumRefreshInterval + " seconds (AdPlacement Id = " + this.p.i().toString() + ")");
            return false;
        }
        return true;
    }
    
    public boolean t() {
        return this.o != null && this.o.Y();
    }
    
    public void u() {
        if (this.m != null) {
            this.m.ab();
        }
        if (this.n != null) {
            this.n.ab();
        }
    }
    
    public boolean b(@NonNull final RelativeLayout relativeLayout) {
        if (this.o == null) {
            return true;
        }
        if (this.p != null && this.p.j() == 4) {
            return true;
        }
        if (this.o.V()) {
            this.c(relativeLayout);
            this.o.W();
            return false;
        }
        return true;
    }
    
    protected void c(@NonNull final RelativeLayout relativeLayout) {
        if (this.o == null) {
            return;
        }
        final o o;
        if ((o = (o)this.o.s()) == null) {
            return;
        }
        final dg viewableAd = o.getViewableAd();
        if (this.o.i().f()) {
            o.a();
        }
        final View c = viewableAd.c();
        viewableAd.a((Map<View, FriendlyObstructionPurpose>)null);
        final ViewGroup viewGroup = (ViewGroup)o.getParent();
        final RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (viewGroup == null) {
            relativeLayout.addView(c, (ViewGroup.LayoutParams)layoutParams);
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(c, (ViewGroup.LayoutParams)layoutParams);
    }
    
    @Override
    public final void a(final t obj, final InMobiAdRequestStatus inMobiAdRequestStatus) {
        if (this.c(inMobiAdRequestStatus) && this.a(obj)) {
            if (this.o != null && this.o.equals(obj)) {
                this.o.q = true;
            }
            obj.b(inMobiAdRequestStatus);
            return;
        }
        this.c(obj, inMobiAdRequestStatus);
    }
    
    public void b(@NonNull final t t, final boolean b, final InMobiAdRequestStatus inMobiAdRequestStatus) {
        if (2 == this.f) {
            if (!b) {
                return;
            }
        }
        else if (!b) {
            t.W();
            this.c(t, inMobiAdRequestStatus);
        }
    }
    
    public void v() {
        if (this.m != null) {
            this.m.ac();
        }
        if (this.n != null) {
            this.n.ac();
        }
    }
    
    public void w() {
        this.u();
        if (this.m != null) {
            this.m.D();
            this.m = null;
        }
        if (this.n != null) {
            this.n.D();
            this.n = null;
        }
        this.o = null;
        this.p = null;
        this.g = null;
    }
    
    public void x() {
        final t m;
        if ((m = this.m()) != null) {
            m.J();
        }
    }
    
    public void a(final byte b) {
        final t m;
        if ((m = this.m()) != null) {
            m.b(b);
        }
    }
    
    public void b(final byte b) {
        final t m;
        if ((m = this.m()) != null) {
            m.a(b);
        }
    }
    
    static {
        k = x.class.getSimpleName();
    }
}
