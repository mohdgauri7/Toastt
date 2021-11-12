// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import org.json.JSONObject;
import android.widget.RelativeLayout;
import androidx.annotation.UiThread;
import android.os.Bundle;
import java.net.URISyntaxException;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.Locale;
import android.annotation.SuppressLint;
import java.util.Iterator;
import java.util.UUID;
import com.inmobi.ads.rendering.InMobiAdActivity;
import java.util.Map;
import android.os.Handler;
import android.os.Looper;
import java.util.Collection;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import android.content.Intent;
import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.List;
import androidx.annotation.Nullable;
import java.util.Set;
import androidx.annotation.NonNull;
import android.app.Application;

public class l implements Application.ActivityLifecycleCallbacks, h
{
    private static final String w;
    protected bn a;
    private byte x;
    @NonNull
    fe b;
    @NonNull
    public final String c;
    public final long d;
    public final String e;
    public final boolean f;
    @Nullable
    @NonNull
    private Set<Integer> y;
    @NonNull
    private List<bj> z;
    @Nullable
    protected Set<de> g;
    protected dg h;
    private eq A;
    protected boolean i;
    public boolean j;
    protected boolean k;
    @NonNull
    public l l;
    @Nullable
    protected c m;
    @NonNull
    protected WeakReference<Context> n;
    private int B;
    @Nullable
    WeakReference<Activity> o;
    boolean p;
    public int q;
    private l C;
    public boolean r;
    private bj D;
    private String E;
    Intent s;
    public o t;
    private o F;
    private l G;
    public byte u;
    private q H;
    private final h.a I;
    private hb J;
    private v<l> K;
    public final dq.a v;
    
    l(@NonNull final Context context, final byte x, @NonNull final bn a, @NonNull final String c, @Nullable final Set<de> c2, @NonNull final fe b, final long d, final boolean f, final String e) {
        this.y = new HashSet<Integer>();
        this.z = new ArrayList<bj>();
        this.n = new WeakReference<Context>(null);
        this.B = -1;
        this.p = false;
        this.q = 0;
        this.r = false;
        this.D = null;
        this.E = null;
        this.s = null;
        this.I = new h.a() {
            @Override
            public final void a() {
                com.inmobi.media.l.w;
                final c h;
                if ((h = com.inmobi.media.l.this.h()) != null) {
                    h.a();
                }
            }
            
            @Override
            public final void a(final Object o) {
                if (null == com.inmobi.media.l.this.o()) {
                    return;
                }
                final c h;
                if ((h = com.inmobi.media.l.this.h()) != null) {
                    h.b();
                }
            }
            
            @Override
            public final void b(final Object o) {
                final c h;
                if ((h = com.inmobi.media.l.this.h()) != null) {
                    h.f();
                }
            }
        };
        this.K = new v<l>(this) {
            @Override
            public final void a() {
                if (!com.inmobi.media.l.this.j && 0 == com.inmobi.media.l.this.getPlacementType() && com.inmobi.media.l.this.a.c) {
                    com.inmobi.media.l.w;
                    com.inmobi.media.l.a(com.inmobi.media.l.this);
                }
            }
        };
        this.v = new dq.a() {
            @Override
            public final void a(final View view, final boolean b) {
                com.inmobi.media.l.this.a(b);
            }
        };
        this.x = x;
        this.a = a;
        this.c = c;
        this.d = d;
        this.f = f;
        this.e = e;
        this.a((h)this);
        this.i = false;
        this.j = false;
        this.b = b;
        if (c2 != null) {
            this.g = new HashSet<de>(c2);
        }
        this.a.d.z = System.currentTimeMillis();
        this.a(context);
        this.u = -1;
        this.J = hb.a();
        new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
            @Override
            public final void run() {
                com.inmobi.media.l.this.J.a(com.inmobi.media.l.this.hashCode(), com.inmobi.media.l.this.K);
            }
        });
    }
    
    public final void a(final byte b, final Map<String, String> map) {
        if (this.j) {
            return;
        }
        switch (b) {
            default: {}
            case 3: {}
            case 1: {
                this.a.d.a("load", map);
            }
            case 2: {
                this.a.d.a("client_fill", map);
            }
        }
    }
    
    public final void d() {
        final Activity o;
        if ((o = this.o()) != null && !this.j) {
            switch (this.a.a) {
                case 1: {
                    o.setRequestedOrientation(1);
                }
                case 2: {
                    o.setRequestedOrientation(0);
                }
                default: {
                    final Activity activity = o;
                    activity.setRequestedOrientation(activity.getRequestedOrientation());
                    break;
                }
            }
        }
    }
    
    @Nullable
    public h.a getFullScreenEventsListener() {
        return this.I;
    }
    
    public final void a() {
    }
    
    public String getMarkupType() {
        return "inmobiJson";
    }
    
    public byte getPlacementType() {
        return this.x;
    }
    
    public final void a(final Context referent) {
        this.n = new WeakReference<Context>(referent);
        gz.a(referent, (Application.ActivityLifecycleCallbacks)this);
    }
    
    @Nullable
    public final Context g() {
        return this.n.get();
    }
    
    public final void a(final String s) {
        final Context context;
        if ((context = this.n.get()) == null) {
            return;
        }
        if (hd.a(s)) {
            InMobiAdActivity.a((o)null);
            InMobiAdActivity.a(this.x());
            final Intent intent;
            (intent = new Intent(context, (Class)InMobiAdActivity.class)).putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 100);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.IN_APP_BROWSER_URL", s);
            intent.putExtra("placementId", this.d);
            intent.putExtra("creativeId", this.e);
            intent.putExtra("impressionId", this.c);
            intent.putExtra("allowAutoRedirection", this.f);
            gz.a(context, intent);
        }
    }
    
    public final void e() {
        final c m;
        if ((m = this.m) != null) {
            m.b();
        }
    }
    
    public final void f() {
        final c m;
        if ((m = this.m) != null) {
            m.f();
        }
    }
    
    public final void a(@NonNull final h h) {
        if (h instanceof l) {
            this.l = (l)h;
        }
    }
    
    @Nullable
    public final c h() {
        return this.m;
    }
    
    public final void a(@NonNull final c m) {
        this.m = m;
    }
    
    @Nullable
    public final View i() {
        if (this.h == null) {
            return null;
        }
        return this.h.b();
    }
    
    private void a(final int i, @NonNull final bl bl) {
        if (this.j) {
            return;
        }
        this.y.add(i);
        bl.z = System.currentTimeMillis();
        if (this.i) {
            b(bl, this.a(bl));
            return;
        }
        this.z.add(bl);
    }
    
    @NonNull
    public fe getAdConfig() {
        return this.b;
    }
    
    final void j() {
        final Map<String, String> a = this.a(this.a.d);
        this.a((byte)1, a);
        this.a((byte)2, a);
    }
    
    @SuppressLint({ "SwitchIntDef" })
    public dg getViewableAd() {
        final Context m = this.m();
        if (this.h == null && m != null) {
            this.j();
            this.h = new do(m, this, new di(this, this.t));
            if (this.g != null) {
                for (final de de : this.g) {
                    try {
                        switch (de.a) {
                            case 3: {
                                final dy dy = de.b.get("omidAdSession");
                                if (de.b.containsKey("deferred")) {
                                    (boolean)de.b.get("deferred");
                                }
                                if (dy == null) {
                                    continue;
                                }
                                if (this.u == 0) {
                                    this.h = new ec(this, this.h, dy);
                                    continue;
                                }
                                this.h = new ed(this, this.h, dy);
                                continue;
                            }
                            case 1: {
                                if (this.u == 0) {
                                    this.h = new du(this, m, this.h, de.b);
                                    continue;
                                }
                                de.b.put("zMoatIID", UUID.randomUUID().toString());
                                this.h = new dv(m, this.h, this, de.b);
                                continue;
                            }
                        }
                    }
                    catch (Exception ex) {
                        fv.a().a(new gv(ex));
                    }
                }
            }
        }
        return this.h;
    }
    
    @Nullable
    public View getVideoContainerView() {
        return null;
    }
    
    @NonNull
    public final bn k() {
        return this.a;
    }
    
    public final boolean c() {
        return this.j;
    }
    
    public void destroy() {
        if (this.j) {
            return;
        }
        this.j = true;
        this.B = -1;
        if (this.C != null) {
            this.C.b();
        }
        this.j = true;
        this.m = null;
        final eq c;
        if ((c = this.C()) != null) {
            final ei b;
            final Iterator<ei.a> iterator = (b = c.b).a.iterator();
            while (iterator.hasNext()) {
                ((ei.a)iterator.next()).a.cancel();
            }
            b.a.clear();
            c.a();
        }
        this.A = null;
        this.z.clear();
        if (this.h != null) {
            this.h.d();
            this.h.e();
        }
        this.D();
        this.n.clear();
        if (this.o != null) {
            this.o.clear();
        }
        this.a = null;
        this.t = null;
        if (this.G != null) {
            this.G.destroy();
            this.G = null;
        }
        this.J.a(this.hashCode());
    }
    
    boolean l() {
        return 0 == this.getPlacementType() && this.o() != null;
    }
    
    @Nullable
    public final Context m() {
        if (1 == this.getPlacementType() || this.l()) {
            return (Context)this.o();
        }
        return this.n.get();
    }
    
    protected final boolean n() {
        return this.i;
    }
    
    @Nullable
    private bj b(@Nullable final bn bn, @NonNull final bj bj) {
        if (bn == null) {
            return null;
        }
        final String r = bj.r;
        final String s = bj.s;
        bj bj2 = null;
        if (r != null) {
            bj2 = this.a(bj, bn, r);
        }
        if (bj2 == null && s != null) {
            bj2 = this.a(bj, bn, s);
        }
        return bj2;
    }
    
    private bj a(@NonNull final bj obj, @NonNull final bn bn, @NonNull final String s) {
        if (hd.a(this.n.get(), s)) {
            return obj;
        }
        final String[] split = s.split("\\|");
        final bj b;
        if ((b = bn.b(split[0])) == null) {
            return this.b(bn.f, obj);
        }
        if (b.equals(obj)) {
            return null;
        }
        if (1 == split.length || 2 == split.length) {
            b.m = 1;
            return b;
        }
        b.m = bn.a(split[2]);
        return b;
    }
    
    @Nullable
    public static bj a(@Nullable bn f, @NonNull final bj obj) {
        while (f != null) {
            final String j;
            if ((j = obj.j) == null || 0 == j.length()) {
                obj.l = 0;
                return obj;
            }
            final String[] split = j.split("\\|");
            if (1 == split.length) {
                obj.l = b(split[0]);
                return obj;
            }
            final bj b;
            if ((b = f.b(split[0])) == null) {
                f = f.f;
            }
            else {
                if (b.equals(obj)) {
                    return null;
                }
                b.l = b(split[1]);
                return b;
            }
        }
        return null;
    }
    
    private static byte b(String trim) {
        trim = trim.toLowerCase(Locale.US).trim();
        switch (trim) {
            default: {
                return 0;
            }
            case "skip": {
                return 2;
            }
            case "reload":
            case "replay": {
                return 3;
            }
            case "exit": {
                return 1;
            }
            case "fullscreen": {
                return 4;
            }
            case "play": {
                return 5;
            }
        }
    }
    
    public final void a(@Nullable final View view, @NonNull final bj obj) {
        if (this.j) {
            return;
        }
        this.z();
        final bj b;
        if ((b = this.b(this.a, obj)) != null) {
            final Map<String, String> a = this.a(b);
            a(b, a);
            if (!b.equals(obj)) {
                a(obj, a);
            }
        }
        else {
            a(obj, this.a(obj));
        }
        final l h;
        if ((h = h(this)) == null) {
            return;
        }
        final c m;
        if (!obj.r.trim().isEmpty() && (m = h.m) != null) {
            m.e();
        }
        final bj a2;
        if ((a2 = a(this.a, obj)) != null) {
            if (view != null && "VIDEO".equals(a2.b) && 5 == a2.l) {
                view.setVisibility(4);
                obj.x = 4;
            }
            this.b(a2);
        }
    }
    
    public final void a(@NonNull final bj bj, final boolean b) {
        if (this.a.j) {
            if (this.j) {
                return;
            }
            final bj b2;
            if ((b2 = this.b(this.a, bj)) != null) {
                final Map<String, String> a = this.a(b2);
                b2.i = bj.i;
                final bw bw = (bw)b2;
                final Map<String, String> map = a;
                final bw d = bw;
                if ("VIDEO".equals(d.b) || d.h) {
                    final byte i = d.i;
                    if (this.h != null) {
                        this.h.a((byte)4);
                    }
                    if (i == 0) {
                        return;
                    }
                    String s = d.r;
                    final cw f;
                    if (2 == d.m && (f = d.b().f()) != null && f.e != null && !f.e.trim().isEmpty()) {
                        s = f.e;
                    }
                    if (!hd.a(this.E(), s)) {
                        s = d.s;
                        if (!hd.a(this.E(), s)) {
                            return;
                        }
                    }
                    final String a2 = hg.a(s, map);
                    if (this.r && !b) {
                        final l h;
                        if ((h = h(this)) == null) {
                            return;
                        }
                        final c m;
                        if ((m = h.m) != null) {
                            if (i && hd.a(a2)) {
                                m.c();
                            }
                            else {
                                m.g();
                            }
                        }
                        this.D = d;
                        this.E = a2;
                    }
                    else {
                        this.a(d, i, a2);
                    }
                }
            }
        }
    }
    
    public final void a(final int i, final bj bj) {
        if (this.y.contains(i) || this.j) {
            return;
        }
        this.z();
        this.a(i, (bl)bj);
    }
    
    public void setFullScreenActivityContext(final Activity referent) {
        this.o = new WeakReference<Activity>(referent);
    }
    
    @Nullable
    public final Activity o() {
        if (this.o == null) {
            return null;
        }
        return this.o.get();
    }
    
    private void z() {
        final bl a = this.a.a(0);
        if (!this.y.contains(0) && a != null) {
            this.a(0, a);
        }
    }
    
    public void a(final View view) {
        if (this.i || this.j) {
            return;
        }
        this.i = true;
        this.a.d.a("Impression", this.a(this.a.d));
        this.z();
        for (final bj bj : this.z) {
            b(bj, this.a(bj));
        }
        this.z.clear();
        this.h.a((byte)0);
        final l h;
        if ((h = h(this)) == null) {
            return;
        }
        final c m;
        if ((m = h.m) != null) {
            m.d();
        }
    }
    
    private static void a(@NonNull final bj bj, @Nullable final Map<String, String> map) {
        if (2 == bj.m) {
            final cw f;
            if ((f = ((bw)bj).b().f()) != null && (f.e != null || bj.r == null)) {
                if (f.d.size() > 0) {
                    final Iterator<bv> iterator = f.a("click").iterator();
                    while (iterator.hasNext()) {
                        bj.a(iterator.next(), map);
                    }
                }
            }
            else {
                bj.a("click", map);
            }
            return;
        }
        bj.a("click", map);
    }
    
    public final Map<String, String> a(@NonNull final bj bj) {
        final HashMap<String, String> hashMap = new HashMap<String, String>(3);
        if (this.j || this.a == null) {
            return hashMap;
        }
        hashMap.put("$LTS", String.valueOf(this.a.d.z));
        final bl a = bn.a(bj);
        long l = System.currentTimeMillis();
        if (a != null && 0L != a.z) {
            l = a.z;
        }
        hashMap.put("$STS", String.valueOf(l));
        hashMap.put("$TS", String.valueOf(System.currentTimeMillis()));
        hashMap.putAll((Map<?, ?>)this.a.a());
        return hashMap;
    }
    
    private static void b(@Nullable final bj bj, @Nullable final Map<String, String> map) {
        if (bj == null) {
            return;
        }
        bj.a("page_view", map);
    }
    
    final void a(final boolean b) {
        if (b) {
            this.A();
            return;
        }
        this.B();
    }
    
    protected void b(@NonNull final bj bj) {
        switch (bj.l) {
            case 0: {}
            case 5: {}
            default: {
                this.p = true;
                if (this.t != null && this.t != null) {
                    this.t.e("window.imraid.broadcastEvent('skip');");
                }
                c(this.i());
                this.c(bj);
            }
            case 3: {
                try {
                    if (this.t != null) {
                        this.t.e("window.imraid.broadcastEvent('replay');");
                    }
                    final View i;
                    final ViewGroup viewGroup;
                    if (this.i() != null && (viewGroup = (ViewGroup)(i = this.i()).getParent()) != null) {
                        viewGroup.removeView(i);
                    }
                    final l l;
                    final bu b;
                    if ((b = b((l = this.l).i())) != null && b.c != null && b.c.isRunning()) {
                        b.c.setCurrentPlayTime(b.a * 1000L);
                        b.a(1.0f);
                    }
                    if (!"VIDEO".equals(bj.b)) {
                        return;
                    }
                    final ey ey;
                    if (l instanceof m && (ey = (ey)l.getVideoContainerView()) != null) {
                        final ex videoView;
                        final bw bw;
                        if ((bw = (bw)(videoView = ey.getVideoView()).getTag()) != null) {
                            if (bw.a()) {
                                videoView.i();
                            }
                            else {
                                videoView.h();
                            }
                        }
                        else if (1 == this.getPlacementType()) {
                            videoView.i();
                        }
                        else {
                            videoView.h();
                        }
                        this.a(bw);
                        videoView.start();
                    }
                }
                catch (Exception ex) {
                    hf.a((byte)2, "InMobi", "SDK encountered unexpected error in replaying video");
                    fv.a().a(new gv(ex));
                }
            }
            case 1: {
                try {
                    if (this.t != null) {
                        this.t.e("window.imraid.broadcastEvent('close');");
                    }
                    this.b();
                }
                catch (Exception ex2) {
                    hf.a((byte)2, "InMobi", "SDK encountered unexpected error in exiting video");
                    fv.a().a(new gv(ex2));
                }
            }
            case 4: {
                try {
                    if (0 == this.getPlacementType()) {
                        this.p();
                    }
                    return;
                }
                catch (Exception ex3) {
                    hf.a((byte)2, "InMobi", "SDK encountered unexpected error in launching fullscreen ad");
                    fv.a().a(new gv(ex3));
                    return;
                }
                break;
            }
        }
    }
    
    static bu b(final View view) {
        if (view != null) {
            return (bu)view.findViewWithTag((Object)"timerView");
        }
        return null;
    }
    
    protected static void c(final View view) {
        final bu b;
        if ((b = b(view)) != null) {
            b.b();
        }
    }
    
    protected static void d(final View view) {
        final bu b;
        if ((b = b(view)) != null && b.c != null && !b.c.isRunning()) {
            b.c.setCurrentPlayTime(b.b);
            b.c.start();
        }
    }
    
    private void A() {
        final eq c;
        if ((c = this.C()) != null) {
            c.b.a();
        }
    }
    
    private void B() {
        final eq c;
        if ((c = this.C()) != null) {
            c.b.b();
        }
    }
    
    final void p() {
        final l h;
        if ((h = h(this)) == null) {
            return;
        }
        final c m;
        if ((m = h.m) != null) {
            m.c();
        }
        this.J.a(this.hashCode(), new v<l>(this) {
            @Override
            public final void a() {
                if (null == com.inmobi.media.l.this.C) {
                    com.inmobi.media.l.a(com.inmobi.media.l.this);
                }
                final Intent s;
                (s = new Intent((Context)com.inmobi.media.l.this.n.get(), (Class)InMobiAdActivity.class)).putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_INDEX", InMobiAdActivity.a(com.inmobi.media.l.this.C));
                s.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 102);
                s.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_IS_FULL_SCREEN", true);
                s.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_TYPE", 201);
                if (com.inmobi.media.l.this.r) {
                    com.inmobi.media.l.this.s = s;
                    return;
                }
                gz.a(com.inmobi.media.l.this.n.get(), s);
            }
            
            @Override
            public final void b() {
                super.b();
                final c h;
                if ((h = h.h()) != null) {
                    h.a();
                }
            }
        });
    }
    
    boolean q() {
        return false;
    }
    
    public final void r() {
        if (this.q()) {
            this.p = true;
            final c m;
            if ((m = this.m) != null && this.a.g != null) {
                m.a(this.a.g);
            }
        }
    }
    
    private void a(final bw bw) {
        final cw f;
        if ((f = bw.b().f()) != null && f.g) {
            final Iterator<bv> iterator = f.a("closeEndCard").iterator();
            while (iterator.hasNext()) {
                bj.a(iterator.next(), this.a((bj)bw));
            }
            f.g = false;
        }
    }
    
    public final void b() {
        try {
            if (this.j) {
                return;
            }
            final l h;
            if ((h = h(this)) == null) {
                return;
            }
            h.r();
            InMobiAdActivity.a((Object)h);
            final ey ey;
            if (h instanceof m && (ey = (ey)((m)h).getVideoContainerView()) != null) {
                final ex videoView;
                final bw bw;
                (bw = (bw)(videoView = ey.getVideoView()).getTag()).v.put("seekPosition", videoView.getCurrentPosition());
                bw.v.put("lastMediaVolume", videoView.getVolume());
                if (bw.y != null) {
                    ((bw)bw.y).a(bw);
                }
                this.a(bw);
            }
            final Activity activity;
            if ((activity = ((h.o == null) ? null : h.o.get())) instanceof InMobiAdActivity) {
                ((InMobiAdActivity)activity).a = true;
                activity.finish();
                if (this.B != -1) {
                    activity.overridePendingTransition(0, this.B);
                }
            }
            this.l.C = null;
            new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
                @Override
                public final void run() {
                    com.inmobi.media.l.this.l.J.a(com.inmobi.media.l.this.l.hashCode(), com.inmobi.media.l.this.l.K);
                }
            });
        }
        catch (Exception ex) {
            hf.a((byte)2, "InMobi", "SDK encountered unexpected error in exiting video");
            fv.a().a(new gv(ex));
        }
    }
    
    private static l h(@Nullable l l) {
        while (l != null) {
            if (l.o() == null) {
                final l i = l;
                if (i != i.l) {
                    l = l.l;
                    continue;
                }
            }
            return l;
        }
        return null;
    }
    
    @Nullable
    private eq C() {
        final ep ep;
        if ((ep = ((this.h == null) ? null : ((ep)this.h.a()))) != null) {
            this.A = ep.b;
        }
        return this.A;
    }
    
    private void a(@NonNull final bj bj, final byte b, final String s) {
        if (1 == b) {
            this.c(s);
            return;
        }
        this.a(s, bj.s, bj);
    }
    
    private void a(@NonNull String a, @Nullable final String anObject, @NonNull final bj bj) {
        if (null == this.n.get()) {
            return;
        }
        if ((a = hd.a(this.n.get(), a, anObject)) != null) {
            final l h;
            if ((h = h(this)) == null) {
                return;
            }
            final c m;
            if ((m = h.m) != null && !this.r) {
                m.g();
            }
            if (a.equals(anObject)) {
                bj.a("TRACKER_EVENT_TYPE_FALLBACK_URL", this.a(bj));
            }
        }
    }
    
    private void c(final String s) {
        final Context context;
        if ((context = this.n.get()) == null) {
            return;
        }
        final c m;
        if (this.o() == null && (m = this.m) != null) {
            m.c();
        }
        final String a = com.inmobi.media.g.a(context);
        try {
            final boolean cctEnabled = this.getAdConfig().cctEnabled;
            if (a == null || !cctEnabled) {
                this.a(s);
                return;
            }
            new ce(s, context, this).b();
        }
        catch (Exception ex) {
            try {
                hd.b(context, s);
            }
            catch (URISyntaxException ex2) {}
        }
    }
    
    private void D() {
        final Context context;
        if ((context = this.n.get()) instanceof Activity) {
            ((Activity)context).getApplication().unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
        }
    }
    
    public void onActivityCreated(final Activity activity, final Bundle bundle) {
    }
    
    public void onActivityStarted(final Activity obj) {
        final Context e;
        if ((e = this.E()) != null && e.equals(obj)) {
            this.s();
        }
    }
    
    public final void s() {
        this.k = false;
        d(this.i());
        this.A();
        if (this.h != null) {
            this.h.a(this.E(), (byte)0);
        }
    }
    
    public void onActivityResumed(final Activity activity) {
    }
    
    public void onActivityPaused(final Activity activity) {
    }
    
    public void onActivityStopped(final Activity obj) {
        final Context e;
        if ((e = this.E()) != null && e.equals(obj)) {
            this.t();
        }
    }
    
    private Context E() {
        Object o;
        if ((o = this.o()) == null) {
            o = this.n.get();
        }
        return (Context)o;
    }
    
    public void t() {
        this.k = true;
        c(this.i());
        this.B();
        if (this.h != null) {
            this.h.a(this.E(), (byte)1);
        }
    }
    
    public void onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
    }
    
    public void onActivityDestroyed(final Activity activity) {
        if (this.h != null) {
            this.h.a((Context)activity, (byte)2);
        }
        this.D();
    }
    
    public final void u() {
        if (this.D != null && this.E != null) {
            this.a(this.D, this.D.i, this.E);
            return;
        }
        if (this.s != null && this.n.get() != null) {
            gz.a(this.n.get(), this.s);
        }
    }
    
    @Nullable
    public final o v() {
        if (this.t == null) {
            return this.F;
        }
        return this.t;
    }
    
    public final void a(final o f) {
        if (this.u == 0 && this.F == null && this.t == null) {
            this.F = f;
        }
    }
    
    public final void w() {
        new a(this).start();
    }
    
    @UiThread
    public final void c(@Nullable final bj bj) {
        final l g;
        if ((g = this.G) != null && this.i() != null) {
            try {
                final ViewGroup viewGroup = (ViewGroup)this.i();
                final View a;
                if ((a = g.getViewableAd().a(null, viewGroup, false)) == null) {
                    this.b();
                    return;
                }
                viewGroup.addView(a);
                a.setClickable(true);
                g.A();
            }
            catch (Exception ex) {
                this.b();
                fv.a().a(new gv(ex));
                return;
            }
            if (bj instanceof bw) {
                final cw f;
                if ((f = ((bw)bj).b().f()) != null) {
                    f.g = true;
                }
            }
        }
        else {
            hf.a((byte)2, "InMobi", "Failed to show end card");
            this.b();
        }
    }
    
    @NonNull
    public final q x() {
        if (this.H == null) {
            this.H = new q() {
                @Override
                public final void a() {
                    final c h;
                    if ((h = com.inmobi.media.l.this.h()) != null) {
                        h.a();
                    }
                }
                
                @Override
                public final void a_(final o o) {
                    final c h;
                    if ((h = com.inmobi.media.l.this.h()) != null) {
                        h.b();
                    }
                }
                
                @Override
                public final void b_(final o o) {
                    final c h;
                    if ((h = com.inmobi.media.l.this.h()) != null) {
                        h.f();
                    }
                }
                
                @Override
                public final void a(@NonNull final HashMap<Object, Object> hashMap) {
                    final c h;
                    if ((h = com.inmobi.media.l.this.h()) != null) {
                        h.e();
                    }
                }
                
                @Override
                public final void a_() {
                    final c h;
                    if ((h = com.inmobi.media.l.this.h()) != null) {
                        h.g();
                    }
                }
                
                @Override
                public final void d_() {
                    final c h;
                    if ((h = com.inmobi.media.l.this.h()) != null && 0 == com.inmobi.media.l.this.getPlacementType()) {
                        h.c();
                    }
                }
                
                @Override
                public final it c_() {
                    return it.a();
                }
            };
        }
        return this.H;
    }
    
    static /* synthetic */ void a(final l l) {
        final bn a = l.a;
        if (0 != a.e.length()) {
            final JSONObject b;
            if ((b = a.b()) == null) {
                return;
            }
            final bn bn;
            (bn = new bn(l.getPlacementType(), b, a, l.getPlacementType() == 0, l.getAdConfig())).c = a.c;
            bn.j = a.j;
            final Context context = l.n.get();
            if (bn.d() && context != null) {
                (l.C = com.inmobi.media.l.b.a(context, (byte)0, bn, l.c, l.g, l.b, l.d, l.f, l.e)).a((h)l);
                if (l.m != null) {
                    l.C.m = l.m;
                }
                if (a.c) {
                    new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
                        @Override
                        public final void run() {
                            com.inmobi.media.l.this.C.getViewableAd().a(null, (ViewGroup)new RelativeLayout(com.inmobi.media.l.this.m()), false);
                        }
                    });
                }
            }
        }
    }
    
    static /* synthetic */ void a(final l l, final l g) {
        l.G = g;
    }
    
    static {
        w = l.class.getSimpleName();
    }
    
    public static final class b
    {
        public static l a(@NonNull final Context context, final byte b, @NonNull final bn bn, @NonNull final String s, @Nullable final Set<de> set, @NonNull final fe fe, final long n, final boolean b2, final String s2) {
            if (bn.e().contains("VIDEO")) {
                return new m(context, b, bn, s, set, fe, n, b2, s2);
            }
            return new l(context, b, bn, s, set, fe, n, b2, s2);
        }
    }
    
    final class a extends Thread
    {
        private WeakReference<l> b;
        
        a(@NonNull final l referent) {
            this.b = new WeakReference<l>(referent);
        }
        
        @Override
        public final void run() {
            if (null == com.inmobi.media.l.this.o()) {
                com.inmobi.media.l.w;
                return;
            }
            final l l;
            if ((l = this.b.get()) == null || l.j) {
                return;
            }
            try {
                final bn k = l.k();
                if (null == com.inmobi.media.l.this.o() || 0 == k.e.length()) {
                    com.inmobi.media.l.w;
                    return;
                }
                com.inmobi.media.l.w;
                final JSONObject b;
                if ((b = k.b()) == null) {
                    return;
                }
                final bn bn;
                if ((bn = new bn(com.inmobi.media.l.this.getPlacementType(), b, k, com.inmobi.media.l.this.getPlacementType() == 0, com.inmobi.media.l.this.getAdConfig())).d()) {
                    final l a = com.inmobi.media.l.b.a((Context)com.inmobi.media.l.this.o(), (byte)0, bn, com.inmobi.media.l.this.c, null, com.inmobi.media.l.this.b, com.inmobi.media.l.this.d, com.inmobi.media.l.this.f, com.inmobi.media.l.this.e);
                    com.inmobi.media.l.w;
                    a.a((h)l);
                    a.t = l.t;
                    com.inmobi.media.l.a(l, a);
                    return;
                }
                com.inmobi.media.l.w;
            }
            catch (Exception ex) {
                com.inmobi.media.l.w;
                fv.a().a(new gv(ex));
            }
        }
    }
    
    public interface c
    {
        void a();
        
        void b();
        
        void c();
        
        void d();
        
        void e();
        
        void f();
        
        void a(final Map<String, String> p0);
        
        void g();
        
        void h();
        
        void i();
        
        void a(final boolean p0);
    }
}
