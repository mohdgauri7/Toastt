// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.WorkerThread;
import android.app.Activity;
import android.content.Intent;
import com.inmobi.ads.rendering.InMobiAdActivity;
import android.os.Looper;
import androidx.annotation.UiThread;
import com.inmobi.ads.InMobiAdRequestStatus;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import android.content.Context;

public class ab extends t
{
    private static final String x;
    private int y;
    private boolean z;
    
    public ab(@NonNull final Context context, @NonNull final aq aq, @Nullable final a a) {
        super(context, aq, a);
        this.y = 0;
        this.z = false;
        aq.e();
        this.a(context, aq, a);
        this.b("activity");
    }
    
    @Nullable
    @Override
    public o t() {
        final o t = super.t();
        if (this.z && t != null) {
            t.a();
        }
        return t;
    }
    
    @UiThread
    private boolean aa() {
        if (this.x()) {
            this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.MISSING_REQUIRED_DEPENDENCIES), true, (byte)39);
            return false;
        }
        final a p;
        if ((p = this.p()) == null) {
            return false;
        }
        final a a = p;
        boolean b = false;
        switch (this.j()) {
            case 1: {
                hf.a((byte)1, "InMobiInterstitial", "An ad load is already in progress. Please wait for the load to complete before requesting for another ad for placement id: " + this.i().toString());
                this.b((byte)53);
                b = true;
                break;
            }
            case 6:
            case 7: {
                hf.a((byte)1, "InMobiInterstitial", "An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad for placement id: " + this.i().toString());
                final InMobiAdRequestStatus inMobiAdRequestStatus = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_ACTIVE);
                this.a((byte)15);
                if (a != null) {
                    a.a(this, inMobiAdRequestStatus);
                }
                b = true;
                break;
            }
            case 2: {
                if ("html".equals(this.n())) {
                    hf.a((byte)1, "InMobiInterstitial", "An ad load is already in progress. Please wait for the load to complete before requesting for another ad for placement id: " + this.i().toString());
                    this.b((byte)53);
                }
                else if (a != null) {
                    this.b(a);
                }
                b = true;
                break;
            }
            default: {
                b = false;
                break;
            }
        }
        if (b) {
            return false;
        }
        if (4 == this.j()) {
            if (!this.q()) {
                final a p2;
                if ((p2 = this.p()) == null) {
                    hf.a((byte)2, "InMobiInterstitial", "Listener was garbage collected. Unable to give callback");
                }
                else {
                    this.b(p2);
                    this.c(p2);
                }
                return false;
            }
            this.D();
        }
        super.l = false;
        return true;
    }
    
    @UiThread
    @Override
    public void y() {
        if (this.aa()) {
            super.y();
        }
    }
    
    @Override
    public void a(@Nullable final byte[] array) {
        if (this.aa()) {
            super.a(array);
        }
    }
    
    @UiThread
    public void h(final a a) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.CALLED_FROM_WRONG_THREAD), false, (byte)44);
            hf.a((byte)1, "InMobiInterstitial", "Please ensure that you call show() on the UI thread");
            return;
        }
        if (a == null) {
            hf.a((byte)2, "InMobiInterstitial", "Listener was garbage collected. Unable to give callback");
            return;
        }
        if (!this.Y()) {
            hf.a((byte)1, ab.x, "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling show.");
            this.a(a, (byte)50);
            return;
        }
        this.a(a);
        super.b = 6;
        if (!"html".equals(this.n())) {
            this.w.a(this.hashCode(), new aa(this, a));
            return;
        }
        if (this.q()) {
            this.b(a, (byte)36);
            final h s;
            if ((s = this.s()) != null) {
                s.destroy();
            }
            return;
        }
        this.i(a);
    }
    
    final void i(final a a) {
        final boolean ab = this.ab();
        if (a == null) {
            hf.a((byte)2, "InMobiInterstitial", "Listener was garbage collected. Unable to give callback");
            return;
        }
        if (!ab) {
            super.b = 3;
            this.a(a, (byte)51);
            return;
        }
        a.b();
    }
    
    private boolean ab() {
        try {
            InMobiAdActivity.class.getSimpleName();
            final h s;
            if ((s = this.s()) == null || "unknown".equals(s.getMarkupType())) {
                return false;
            }
            final Intent intent;
            (intent = new Intent(this.h(), (Class)InMobiAdActivity.class)).putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_INDEX", InMobiAdActivity.a(s));
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 102);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_TYPE", "html".equals(this.n()) ? 200 : 201);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_IS_FULL_SCREEN", true);
            if (super.v) {
                if (this.s > 0) {
                    intent.setFlags(603979776);
                }
                else {
                    this.t = System.currentTimeMillis();
                }
            }
            gz.a(this.h(), intent);
            return true;
        }
        catch (Exception ex) {
            hf.a((byte)1, "InMobiInterstitial", "Cannot show ad; SDK encountered an unexpected error");
            fv.a().a(new gv(ex));
            return false;
        }
    }
    
    public boolean Y() {
        return this.j() == 4;
    }
    
    public void Z() {
        final h s;
        if ((s = this.s()) == null) {
            return;
        }
        this.z = true;
        s.a();
    }
    
    @Override
    public String k() {
        return "int";
    }
    
    @Nullable
    @Override
    final Integer w() {
        return this.c.minimumRefreshInterval;
    }
    
    @Override
    protected final byte l() {
        return 1;
    }
    
    @Override
    final void a(final boolean b, @NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
        super.a(b, inMobiAdRequestStatus);
        if (this.j() == 2) {
            hf.a((byte)2, "InMobiInterstitial", "Interstitial ad successfully fetched for placement id: " + this.i().toString());
            this.Q();
        }
    }
    
    @UiThread
    @Override
    public void S() {
        this.F();
        try {
            if (this.R()) {
                return;
            }
            this.T();
            final String n = this.n();
            switch (n) {
                case "html": {
                    this.i.post((Runnable)new Runnable() {
                        @Override
                        public final void run() {
                            ab.this.a(true);
                            if (ab.this.v) {
                                for (int i = 1; i < ab.this.p.b().size(); ++i) {
                                    final ab a = ab.this;
                                    ++a.r;
                                    ab.this.a(false);
                                }
                            }
                        }
                    });
                }
                case "inmobiJson": {}
                default: {
                    this.n();
                }
            }
        }
        catch (IllegalStateException ex) {
            this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (byte)48);
        }
    }
    
    @UiThread
    @Override
    public void a(ak u, final boolean b, final byte b2) {
        if (!b) {
            this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, b2);
            return;
        }
        try {
            super.a(u, b, b2);
        }
        catch (IllegalStateException ex) {}
        if ((u = this.u()) == null) {
            this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (byte)55);
            return;
        }
        if (u.d()) {
            this.j = true;
            this.N();
            return;
        }
        this.a(u);
    }
    
    @UiThread
    public void a(@NonNull final aq aq, final boolean b) {
        super.a(aq, b);
        if (!b) {
            if (this.i().equals(aq) && (2 == this.j() || 4 == this.j())) {
                super.b = 0;
                this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_NO_LONGER_AVAILABLE), false, (byte)0);
            }
        }
        else if (this.i().equals(aq) && 2 == this.j()) {
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
    final void P() {
        this.I();
        super.b = 4;
        final a p;
        if ((p = this.p()) != null && p.g()) {
            this.c(p);
        }
    }
    
    @UiThread
    public void j(final o o) {
        super.j(o);
        if (!super.v) {
            if (this.j() == 2) {
                this.f((byte)2);
                this.ad();
            }
            return;
        }
        final int index;
        if ((index = this.d.indexOf(o)) < this.s) {
            return;
        }
        this.u.add(index);
        boolean b = true;
        for (int i = 0; i < index; ++i) {
            if (this.d.get(i) != null) {
                b = false;
                break;
            }
        }
        if (b && this.j() == 2) {
            this.f((byte)2);
            this.s = index;
            this.ad();
        }
    }
    
    @UiThread
    public void k(final o o) {
        super.k(o);
        if (super.v) {
            final int index = this.d.indexOf(o);
            this.d(index);
            int s = -1;
            boolean b = true;
            boolean b2 = true;
            for (int i = 0; i < this.d.size(); ++i) {
                if (i != index && this.d.get(i) != null) {
                    b = false;
                    if (this.u.contains(i)) {
                        s = i;
                        break;
                    }
                    b2 = false;
                }
            }
            if (s != -1) {
                if (b2 && this.j() == 2) {
                    this.f((byte)2);
                    this.s = s;
                    this.ad();
                }
            }
            else if (b) {
                this.ac();
            }
            return;
        }
        this.ac();
    }
    
    private void ac() {
        if (this.j() == 2) {
            this.f((byte)2);
            super.b = 3;
            hf.a((byte)2, "InMobiInterstitial", "Failed to load the Interstitial markup in the WebView for placement id: " + this.i().toString());
            this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), false, (byte)43);
        }
    }
    
    private void ad() {
        hf.a((byte)2, "InMobiInterstitial", "Successfully loaded Interstitial ad markup in the WebView for placement id: " + this.i().toString());
        this.B();
        this.P();
    }
    
    @UiThread
    @Override
    final void a(@NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
        if (super.v) {
            if (this.j() != 2) {
                this.X();
                return;
            }
            if (!this.u.isEmpty()) {
                this.f((byte)2);
                this.u.first();
                this.s = this.u.first();
                this.ad();
                for (int i = 0; i < this.d.size(); ++i) {
                    if (!this.u.contains(i)) {
                        this.d(i);
                    }
                }
                return;
            }
            this.X();
        }
        super.a(inMobiAdRequestStatus);
    }
    
    @UiThread
    @Override
    protected final void G() {
        if (2 == this.j()) {
            this.f((byte)2);
            super.b = 3;
            hf.a((byte)2, "InMobiInterstitial", "Failed to load the Interstitial markup in the WebView for placement id: " + this.i().toString());
            this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), false, (byte)42);
        }
    }
    
    @Override
    public synchronized void a_(final o o) {
        super.a_(o);
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                ab.this.f(ab.this.p());
            }
        });
    }
    
    @UiThread
    @Override
    final void f(final a a) {
        if (this.j() == 6) {
            ++this.y;
            if (this.y != 1) {
                super.b = 7;
                return;
            }
            hf.a((byte)2, "InMobiInterstitial", "Successfully displayed Interstitial for placement id: " + this.i().toString());
            if (a != null) {
                if (this.n().equals("html") && !this.U()) {
                    this.f();
                }
                this.d(a);
            }
        }
        else if (this.j() == 7) {
            ++this.y;
        }
    }
    
    @Override
    public synchronized void b_(final o o) {
        super.b_(o);
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                ab.this.g(ab.this.p());
            }
        });
    }
    
    @UiThread
    @Override
    final void g(final a a) {
        if (this.j() == 7) {
            --this.y;
            if (this.y == 1) {
                super.b = 6;
            }
        }
        else if (this.j() == 6) {
            --this.y;
            hf.a((byte)2, "InMobiInterstitial", "Interstitial ad dismissed for placement id: " + this.i().toString());
            if (a != null) {
                a.c();
                return;
            }
            hf.a((byte)2, "InMobiInterstitial", "Listener was garbage collected. Unable to give callback");
        }
    }
    
    public boolean H() {
        return 2 == this.j();
    }
    
    @Override
    final void Q() {
        final a p;
        if ((p = this.p()) != null) {
            this.b(p);
        }
    }
    
    final void b(final a a, final byte b) {
        super.b = 0;
        if (a != null) {
            this.a(a, b);
            return;
        }
        hf.a((byte)2, "InMobiInterstitial", "Listener was garbage collected. Unable to give callback");
    }
    
    @Override
    public void b(final String s) {
        super.b("activity");
    }
    
    @Override
    final void F() {
        super.F();
        this.y = 0;
    }
    
    @Override
    public void g() {
        super.g();
        final h s;
        final Activity fullScreenActivity;
        if ((s = this.s()) instanceof o && (fullScreenActivity = ((o)s).getFullScreenActivity()) != null) {
            this.q = true;
            fullScreenActivity.finish();
        }
    }
    
    @Override
    public void a(final int n, final o o) {
    }
    
    @WorkerThread
    @Override
    public void b(final int index, final o o) {
        if (!super.v) {
            return;
        }
        if (!this.u.contains(index) || index <= this.d.indexOf(o) || this.d.get(index) == null || !this.d.get(index).y) {
            this.d.get(this.d.indexOf(o)).d(false);
            return;
        }
        super.b(index, o);
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                final int index = ab.this.d.indexOf(o);
                ab.this.a(index, ab.this.ab(), index);
                ab.this.i.post((Runnable)new Runnable() {
                    @Override
                    public final void run() {
                        ab.this.d(index);
                    }
                });
            }
        });
    }
    
    @WorkerThread
    @Override
    public void b(@NonNull final o o) {
        if (super.v) {
            final Integer n;
            if ((n = this.u.higher(this.d.indexOf(o))) != null) {
                this.b(n, o);
                return;
            }
            this.b();
        }
    }
    
    @WorkerThread
    @Override
    public void b() {
        if (super.v) {
            this.i.post((Runnable)new Runnable() {
                @Override
                public final void run() {
                    ab.this.E();
                    hf.a((byte)2, "InMobiInterstitial", "Interstitial ad dismissed for placement id: " + ab.this.i().toString());
                    if (ab.this.p() != null) {
                        ab.this.p().c();
                        return;
                    }
                    hf.a((byte)2, "InMobiInterstitial", "Listener was garbage collected. Unable to give callback");
                }
            });
        }
    }
    
    @Override
    public void D() {
        super.D();
    }
    
    static {
        x = ab.class.getSimpleName();
    }
}
