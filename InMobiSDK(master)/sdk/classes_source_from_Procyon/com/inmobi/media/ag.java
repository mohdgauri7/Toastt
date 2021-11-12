// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.view.View;
import org.json.JSONObject;
import android.app.Activity;
import androidx.annotation.UiThread;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.AdMetaInfo;
import android.text.TextUtils;
import android.content.Context;
import androidx.annotation.NonNull;
import com.inmobi.ads.controllers.PublisherCallbacks;
import androidx.annotation.Nullable;

public class ag extends aj
{
    private static final String k;
    private static final String l = "InMobi";
    @Nullable
    private ae m;
    
    public ag(@NonNull final PublisherCallbacks h) {
        this.h = h;
    }
    
    public void a(@NonNull final bc bc, @NonNull final Context context) {
        if (this.m == null) {
            this.m = new ae(context, new aq.a("native", "InMobi").a(bc.a).b(com.inmobi.media.d.a(context)).c(bc.b).a(bc.c).a(bc.d).d(bc.e).e(bc.f).a(), this);
        }
        else {
            this.m.a(context);
            this.m.b(com.inmobi.media.d.a(context));
        }
        if (TextUtils.isEmpty((CharSequence)bc.e)) {
            this.m.J();
        }
        this.m.a(bc.c);
    }
    
    public boolean l() {
        return this.m != null && this.m.Z();
    }
    
    @Nullable
    @Override
    public t m() {
        return this.m;
    }
    
    @Override
    public void a(@NonNull final AdMetaInfo j) {
        this.j = j;
        final InMobiAdRequestStatus inMobiAdRequestStatus = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR);
        if (this.m == null) {
            this.a(null, inMobiAdRequestStatus);
            return;
        }
        if (this.m.u() == null) {
            this.a(null, inMobiAdRequestStatus);
            return;
        }
        super.a(j);
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                if (ag.this.h != null) {
                    ag.this.h.onAdFetchSuccessful(j);
                }
            }
        });
        if (!this.l() && this.m.e((byte)1)) {
            this.m.S();
        }
    }
    
    @UiThread
    public void n() {
        if (this.g != null && !this.g) {
            hf.a((byte)1, "InMobi", "Cannot call load() API after calling load(byte[])");
            return;
        }
        this.g = Boolean.TRUE;
        if (this.m != null && this.a("InMobi", this.m.i().toString(), this.h)) {
            this.f = 1;
            this.m.y();
        }
    }
    
    @Override
    public void b(@NonNull final AdMetaInfo adMetaInfo) {
        super.b(adMetaInfo);
        this.f = 2;
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                if (ag.this.h != null) {
                    ag.this.h.onAdLoadSucceeded(adMetaInfo);
                }
            }
        });
    }
    
    @Override
    public void a() {
    }
    
    public void o() {
        if (this.m != null) {
            this.m.Y();
        }
        this.m = null;
    }
    
    public void p() {
        if (this.m != null) {
            final ae m;
            if ((m = this.m).g != null) {
                m.g.u();
            }
            return;
        }
        hf.a((byte)1, ag.k, "InMobiNative is not initialized. Ignoring takeAction");
    }
    
    public void q() {
        final ae m;
        final h s;
        if (this.m != null && (m = this.m).j() == 4 && !(m.h() instanceof Activity) && (s = m.s()) != null) {
            ((l)s).t();
        }
    }
    
    public void r() {
        final ae m;
        final h s;
        if (this.m != null && (m = this.m).j() == 4 && !(m.h() instanceof Activity) && (s = m.s()) != null) {
            ((l)s).s();
        }
    }
    
    public JSONObject s() {
        if (this.m == null) {
            return new JSONObject();
        }
        final h s;
        final bn bn;
        if ((s = this.m.s()) != null && (bn = (bn)s.getDataModel()) != null) {
            return bn.i.a;
        }
        return null;
    }
    
    public String t() {
        final h s;
        final bn bn;
        if (this.m != null && (s = this.m.s()) != null && (bn = (bn)s.getDataModel()) != null) {
            return bn.i.b.a;
        }
        return null;
    }
    
    public String u() {
        final h s;
        final bn bn;
        if (this.m != null && (s = this.m.s()) != null && (bn = (bn)s.getDataModel()) != null) {
            return bn.i.b.b;
        }
        return null;
    }
    
    public String v() {
        final h s;
        final bn bn;
        if (this.m != null && (s = this.m.s()) != null && (bn = (bn)s.getDataModel()) != null) {
            return bn.i.b.c;
        }
        return null;
    }
    
    public String w() {
        final h s;
        final bn bn;
        if (this.m != null && (s = this.m.s()) != null && (bn = (bn)s.getDataModel()) != null) {
            return bn.i.b.f;
        }
        return null;
    }
    
    public String x() {
        final h s;
        final bn bn;
        if (this.m != null && (s = this.m.s()) != null && (bn = (bn)s.getDataModel()) != null) {
            return bn.i.b.d;
        }
        return null;
    }
    
    public float y() {
        if (this.m == null) {
            return 0.0f;
        }
        final h s;
        final bn bn;
        if ((s = this.m.s()) != null && (bn = (bn)s.getDataModel()) != null) {
            return bn.i.b.e;
        }
        return 0.0f;
    }
    
    public boolean z() {
        final h s;
        final bn bn;
        return this.m != null && ((s = this.m.s()) != null && (bn = (bn)s.getDataModel()) != null && bn.i.b.g);
    }
    
    @Nullable
    public Boolean A() {
        final h s;
        if (this.m != null && (s = this.m.s()) != null) {
            return s instanceof m;
        }
        return null;
    }
    
    public void B() {
        final h s;
        final l l;
        final bn k;
        if (this.m != null && (s = this.m.s()) != null && (k = (l = (l)s).k()) != null) {
            l.a((View)null, k.i.c);
            l.a(k.i.c, true);
        }
    }
    
    public void b(@NonNull final bc bc, @NonNull final Context context) {
        if (this.m == null) {
            this.a(bc, context);
        }
        if (this.m != null) {
            this.m.z = true;
        }
    }
    
    @Override
    public void e() {
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                if (ag.this.h != null) {
                    ag.this.h.onAdImpressed();
                }
            }
        });
    }
    
    @Override
    public void h() {
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                if (ag.this.h != null) {
                    ag.this.h.onVideoSkipped();
                }
            }
        });
    }
    
    @Override
    public void f() {
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                if (ag.this.h != null) {
                    ag.this.h.onVideoCompleted();
                }
            }
        });
    }
    
    @Override
    public void a(final boolean b) {
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                if (ag.this.h != null) {
                    ag.this.h.onAudioStateChanged(b);
                }
            }
        });
    }
    
    static {
        k = ag.class.getSimpleName();
    }
}
