// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.WorkerThread;
import android.os.Bundle;
import android.app.Activity;
import androidx.annotation.UiThread;
import java.util.Map;
import com.inmobi.ads.InMobiAdRequestStatus;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import android.content.Context;
import android.app.Application;

public class w extends t implements Application.ActivityLifecycleCallbacks
{
    private static final String x;
    private boolean y;
    private int z;
    
    public w(@NonNull final Context context, @NonNull final aq aq, @Nullable final a a) {
        super(context, aq, a);
        this.y = false;
        this.z = 0;
        aq.e();
        this.a(context, aq, a);
    }
    
    @Override
    final boolean x() {
        return false;
    }
    
    @Override
    public void y() {
        boolean b;
        if (this.x()) {
            this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.MISSING_REQUIRED_DEPENDENCIES), true, (byte)39);
            b = false;
        }
        else if (1 == this.j() || 2 == this.j()) {
            hf.a((byte)1, w.x, "An ad load is already in progress. Please wait for the load to complete before requesting for another ad");
            this.b((byte)53);
            b = false;
        }
        else if (7 == this.j()) {
            this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_ACTIVE), false, (byte)15);
            hf.a((byte)1, "InMobi", "An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad for placement id: " + this.i().e());
            b = false;
        }
        else {
            hf.a((byte)2, "InMobi", "Fetching a Banner ad for placement id: " + this.i().toString());
            super.l = false;
            b = true;
        }
        if (b) {
            super.y();
        }
    }
    
    public void b(final boolean y) {
        if (y) {
            hf.a((byte)2, "InMobi", "Initiating Banner refresh for placement id: " + this.i().toString());
        }
        this.y = y;
        this.y();
    }
    
    public boolean Y() {
        return this.j() == 7;
    }
    
    @Nullable
    @Override
    public o t() {
        final o t = super.t();
        if (this.i().f() && t != null) {
            t.a();
        }
        return t;
    }
    
    @Override
    public String k() {
        return "banner";
    }
    
    public void c(final String s) {
        this.i().a(s);
    }
    
    @Override
    protected final byte l() {
        return 0;
    }
    
    @NonNull
    @Override
    protected final Map<String, String> m() {
        final Map<String, String> m;
        (m = super.m()).put("u-rt", this.y ? "1" : "0");
        m.put("mk-ad-slot", this.i().m());
        return m;
    }
    
    @UiThread
    @Override
    final void a(final boolean b, @NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
        super.a(b, inMobiAdRequestStatus);
        hf.a((byte)2, "InMobi", "Banner ad fetch successful for placement id: " + this.i().toString());
        final a p2;
        if (this.j() == 2 && (p2 = this.p()) != null) {
            this.b(p2);
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
            this.i.post((Runnable)new Runnable() {
                @Override
                public final void run() {
                    if (w.this.v) {
                        w.this.t = System.currentTimeMillis();
                        for (int i = 0; i < w.this.p.b().size(); ++i) {
                            w.this.u.add(i);
                        }
                    }
                    w.this.a(true);
                }
            });
        }
        catch (IllegalStateException ex) {
            this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (byte)48);
        }
    }
    
    @Override
    protected void j(final o o) {
        super.j(o);
        if (super.v && this.d.indexOf(o) > 0 && this.j() == 6) {
            this.f((byte)2);
            this.d.get(this.s).a(true);
            return;
        }
        if (this.j() == 2) {
            this.f((byte)2);
            super.b = 4;
            this.I();
            hf.a((byte)2, "InMobi", "Successfully loaded Banner ad markup in the WebView for placement id: " + this.i().toString());
            final a p;
            if ((p = this.p()) != null) {
                this.c(p);
            }
            this.B();
            if (!this.U()) {
                this.f();
            }
        }
    }
    
    @Override
    protected void k(final o o) {
        super.k(o);
        if (super.v) {
            final int index = this.d.indexOf(o);
            this.d(index);
            if (index > 0 && this.j() == 6) {
                this.f((byte)2);
                this.d.get(this.s).a(false);
            }
        }
        if (this.j() == 2) {
            this.f((byte)2);
            super.b = 3;
            hf.a((byte)2, "InMobi", "Failed to load the Banner markup in the WebView for placement id: " + this.i().toString());
            this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), false, (byte)43);
        }
    }
    
    @Override
    public void f(final o o) {
        super.f(o);
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                try {
                    if (w.this.j() == 4) {
                        w.this.b = 6;
                    }
                }
                catch (Exception ex) {
                    hf.a((byte)1, "InMobi", "Unable to load ad; SDK encountered an internal error");
                    w.x;
                }
            }
        });
    }
    
    public synchronized void a_(final o o) {
        super.a_(o);
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                try {
                    if (w.this.j() == 6) {
                        w.this.z++;
                        w.this.b = 7;
                        hf.a((byte)2, "InMobi", "Successfully displayed banner ad for placement Id : " + w.this.i().toString());
                        final a p;
                        if ((p = w.this.p()) != null) {
                            w.this.d(p);
                        }
                        return;
                    }
                    if (w.this.j() == 7) {
                        w.this.z++;
                    }
                }
                catch (Exception ex) {
                    hf.a((byte)1, "InMobi", "Unable to display ad; SDK encountered an internal error");
                    w.x;
                }
            }
        });
    }
    
    public synchronized void b_(final o o) {
        super.b_(o);
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                try {
                    if (w.this.j() == 7 && --w.this.z == 0) {
                        w.this.b = 6;
                        if (w.this.p() != null) {
                            w.this.p().c();
                        }
                    }
                }
                catch (Exception ex) {
                    hf.a((byte)1, "InMobi", "Unable to dismiss ad; SDK encountered an internal error");
                    w.x;
                }
            }
        });
    }
    
    public void Z() {
        final byte j;
        final h s;
        final dg viewableAd;
        if (((j = this.j()) == 4 || j == 6 || j == 7) && (s = this.s()) != null && (viewableAd = s.getViewableAd()) != null) {
            viewableAd.a(this.h(), (byte)1);
        }
    }
    
    public void aa() {
        final byte j;
        final h s;
        final dg viewableAd;
        if (((j = this.j()) == 4 || j == 6 || j == 7) && (s = this.s()) != null && (viewableAd = s.getViewableAd()) != null) {
            viewableAd.a(this.h(), (byte)0);
        }
    }
    
    public void ab() {
        if (this.h() instanceof Activity) {
            ((Activity)this.h()).getApplication().unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
        }
    }
    
    public void onActivityCreated(final Activity activity, final Bundle bundle) {
    }
    
    public void onActivityStarted(final Activity obj) {
        final Context h;
        if ((h = this.h()) != null && h.equals(obj)) {
            this.aa();
        }
    }
    
    public void onActivityResumed(final Activity activity) {
    }
    
    public void onActivityPaused(final Activity activity) {
    }
    
    public void onActivityStopped(final Activity obj) {
        final Context h;
        if ((h = this.h()) != null && h.equals(obj)) {
            this.Z();
        }
    }
    
    public void onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
    }
    
    public void onActivityDestroyed(final Activity obj) {
        final Context h;
        if ((h = this.h()) != null && h.equals(obj)) {
            ((Activity)h).getApplication().unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
            this.D();
        }
    }
    
    @Override
    public void g() {
        super.g();
        this.q = true;
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                final h s;
                if ((s = w.this.s()) != null) {
                    s.destroy();
                }
            }
        });
    }
    
    public void ac() {
        final Context h;
        if ((h = this.h()) != null) {
            gz.a(h, (Application.ActivityLifecycleCallbacks)this);
        }
    }
    
    @WorkerThread
    public void a(final int n, final o o) {
        if (!this.u.contains(n) || n <= this.d.indexOf(o)) {
            this.d.get(this.d.indexOf(o)).a(false);
            return;
        }
        this.r = n;
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                w.this.a(true);
            }
        });
    }
    
    @WorkerThread
    @Override
    public void b(final int index, final o o) {
        if (!super.v) {
            this.d.get(this.d.indexOf(o)).d(false);
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
                try {
                    final a p;
                    if ((p = w.this.p()) != null) {
                        p.a(index, w.this.d.indexOf(o), o);
                    }
                }
                catch (Exception ex) {
                    w.this.a(index, false, w.this.d.indexOf(o));
                }
            }
        });
    }
    
    public void b() {
    }
    
    public void b(final o o) {
    }
    
    @UiThread
    @Override
    final void a(@NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
        super.a(inMobiAdRequestStatus);
        if (super.v && this.r > 0) {
            this.d.get(this.s).a(false);
            this.i.post((Runnable)new Runnable() {
                @Override
                public final void run() {
                    w.this.d(w.this.r);
                }
            });
        }
    }
    
    static {
        x = w.class.getSimpleName();
    }
}
