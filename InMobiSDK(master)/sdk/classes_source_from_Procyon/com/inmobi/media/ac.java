// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.annotation.SuppressLint;
import com.inmobi.ads.controllers.PublisherCallbacks;
import com.inmobi.ads.InMobiAdRequestStatus;
import android.text.TextUtils;
import android.content.Context;
import androidx.annotation.NonNull;
import com.inmobi.ads.AdMetaInfo;
import androidx.annotation.Nullable;

public class ac extends aj
{
    private static final String k;
    private static final String l = "InMobi";
    @Nullable
    private ab m;
    private boolean n;
    
    private void d(@NonNull final AdMetaInfo adMetaInfo) {
        super.b(adMetaInfo);
        this.f = 2;
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                if (ac.this.h != null) {
                    ac.this.h.onAdLoadSucceeded(adMetaInfo);
                }
            }
        });
    }
    
    private void a(final boolean b, final byte b2) {
        if (this.m != null && b2 != 0) {
            this.m.c((int)b2);
        }
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                if (ac.this.h != null) {
                    ac.this.h.onAdDisplayFailed();
                }
                ac.this.q();
            }
        });
        if (b) {
            this.f = 6;
            if (this.m != null) {
                this.m.D();
            }
        }
    }
    
    public void a(@NonNull final bc bc, @NonNull final Context context) {
        if (this.m == null) {
            this.m = new ab(context, new aq.a("int", "InMobi").a(bc.a).c(bc.b).a(bc.c).d(bc.e).e(bc.f).a(), this);
        }
        if (!TextUtils.isEmpty((CharSequence)bc.e)) {
            this.m.J();
        }
        this.m.a(context);
        this.m.a(bc.c);
        this.m.b("activity");
        if (bc.d) {
            this.m.Z();
        }
    }
    
    @Override
    public void a(@NonNull final AdMetaInfo j) {
        this.j = j;
        final InMobiAdRequestStatus inMobiAdRequestStatus = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR);
        if (this.m == null) {
            this.a(null, inMobiAdRequestStatus);
            return;
        }
        super.a(j);
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                if (ac.this.h != null) {
                    ac.this.h.onAdFetchSuccessful(j);
                }
            }
        });
    }
    
    public void l() throws IllegalStateException {
        if (this.m == null) {
            throw new IllegalStateException("Please make an ad request first in order to start loading the ad.");
        }
        if (!this.m.Y() || this.j == null) {
            if (this.n) {
                this.m.a((byte)89);
                hf.a((byte)1, "InMobi", "Ad show is already called. Please wait for the the ad to be shown.");
                return;
            }
            final ak u = this.m.u();
            final boolean a = this.a("InMobi", this.m.i().toString());
            if (u == null || this.j == null || !a) {
                return;
            }
            if (u.l()) {
                this.f = 8;
                if (this.m.e((byte)1)) {
                    this.m.S();
                }
                return;
            }
        }
        this.d(this.j);
    }
    
    @Override
    public final void b(@NonNull final AdMetaInfo adMetaInfo) {
        if (this.m == null) {
            this.d(null, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            return;
        }
        try {
            if (this.a(this.m, true) && !this.n) {
                this.d(adMetaInfo);
                return;
            }
            this.m.K();
            this.m.h(this);
        }
        catch (IllegalStateException ex) {}
    }
    
    @Override
    public final void a() {
        if (this.m != null) {
            this.m.b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
        }
    }
    
    @Override
    public final void c() {
        if (this.m != null && !this.m.V()) {
            this.i.post((Runnable)new Runnable() {
                @Override
                public final void run() {
                    if (ac.this.h != null) {
                        ac.this.h.onAdDismissed();
                    }
                }
            });
            this.m.D();
            this.f = 0;
            this.g = null;
            this.m.W();
        }
    }
    
    @Nullable
    @Override
    public t m() {
        return this.m;
    }
    
    public void a(@NonNull final PublisherCallbacks h) {
        if (this.g != null && !this.g) {
            this.m.b((byte)52);
            hf.a((byte)1, "InMobi", "Cannot call load() API after calling load(byte[])");
            return;
        }
        if (this.n) {
            this.m.b((byte)89);
            hf.a((byte)1, "InMobi", "Ad show is already called. Please wait for the the ad to be shown.");
            return;
        }
        this.g = Boolean.TRUE;
        if (this.m != null && this.a("InMobi", this.m.i().toString(), h)) {
            this.f = 1;
            this.h = h;
            hf.a((byte)2, ac.k, "Fetching an Interstitial ad for placement id: " + this.m.i().toString());
            this.m.a(this);
            this.m.y();
        }
    }
    
    public boolean n() {
        if (this.m == null) {
            return false;
        }
        if (2 != this.f) {
            return false;
        }
        try {
            return !this.a(this.m, false) || this.m.Y();
        }
        catch (IllegalStateException ex) {
            return false;
        }
    }
    
    public void o() {
        this.m.K();
        if (this.p()) {
            if (!hq.h()) {
                if (this.m != null) {
                    this.m.c(21);
                    this.d(this.m, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.GDPR_COMPLIANCE_ENFORCED));
                    this.m.D();
                }
                return;
            }
            if (this.m != null && this.m.e((byte)4)) {
                this.n = true;
                try {
                    if (this.a(this.m, true)) {
                        this.m.h(this);
                        return;
                    }
                    this.m.S();
                }
                catch (IllegalStateException ex) {}
            }
        }
    }
    
    @Override
    public void i() {
        final t m;
        if ((m = this.m()) != null) {
            if (m.j() == 6 || m.j() == 7) {
                if (this.m != null) {
                    this.m.W();
                }
                m.g(this);
                return;
            }
            this.a(true, (byte)45);
        }
    }
    
    @Override
    public void j() {
        if (this.m != null) {
            this.m.b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
        }
    }
    
    @SuppressLint({ "SwitchIntDef" })
    @Override
    void b(@NonNull final t t, final boolean b, final InMobiAdRequestStatus inMobiAdRequestStatus) {
        if (!b) {
            this.d(t, inMobiAdRequestStatus);
        }
    }
    
    @Override
    public final void a(final t t, final InMobiAdRequestStatus inMobiAdRequestStatus) {
        if (inMobiAdRequestStatus != null && InMobiAdRequestStatus.StatusCode.AD_ACTIVE.equals(inMobiAdRequestStatus.getStatusCode())) {
            this.c(t, inMobiAdRequestStatus);
            return;
        }
        super.a(t, inMobiAdRequestStatus);
    }
    
    @Override
    public void c(@NonNull final AdMetaInfo adMetaInfo) {
        super.c(adMetaInfo);
        final t m;
        if ((m = this.m()) != null) {
            m.L();
        }
        this.n = false;
    }
    
    private boolean a(@NonNull final ab ab, final boolean b) throws IllegalStateException {
        final ar p2;
        if ((((p2 = ab.p) == null) ? null : p2.l()) == null) {
            if (b) {
                this.d(ab, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            }
            throw new IllegalStateException("AdUnit doesn't have a current ad");
        }
        return p2.j();
    }
    
    @SuppressLint({ "SwitchIntDef" })
    private void d(@Nullable final t t, final InMobiAdRequestStatus inMobiAdRequestStatus) {
        switch (this.f) {
            default: {}
            case 1:
            case 8: {
                this.c(t, inMobiAdRequestStatus);
            }
            case 2: {
                hf.a((byte)1, "InMobi", "Unable to Show Ad, canShowAd Failed");
                this.a(true, (byte)0);
            }
            case 5: {
                hf.a((byte)1, "InMobi", "Ad will be dismissed, Internal error");
                if (this.m != null) {
                    this.m.W();
                }
                this.q();
                this.c();
            }
        }
    }
    
    @SuppressLint({ "SwitchIntDef" })
    private boolean p() {
        switch (this.f) {
            case 1:
            case 7: {
                hf.a((byte)1, "InMobi", "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling show.");
                return false;
            }
            case 5: {
                if (this.m != null) {
                    hf.a((byte)1, "InMobi", "An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad for placement id: " + this.m.i().toString());
                    this.a(false, (byte)15);
                }
                return false;
            }
            default: {
                if (this.n) {
                    if (this.m != null) {
                        this.m.c(89);
                    }
                    hf.a((byte)1, "InMobi", "Ad show is already called. Please wait for the the ad to be shown.");
                    return false;
                }
                return true;
            }
        }
    }
    
    private void q() {
        if (this.m != null) {
            this.m.f((byte)4);
        }
    }
    
    static {
        k = ac.class.getSimpleName();
    }
}
