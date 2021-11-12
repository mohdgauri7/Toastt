// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.os.Looper;
import android.annotation.SuppressLint;
import java.util.Iterator;
import java.util.Collection;
import java.util.List;
import android.view.ViewParent;
import android.view.View;
import android.view.ViewGroup;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import android.content.Context;
import java.lang.ref.WeakReference;

public final class eq implements et.a
{
    private static final String d;
    @NonNull
    private final WeakReference<Context> e;
    @NonNull
    private final bn f;
    @NonNull
    private final l g;
    @NonNull
    private final fe h;
    @NonNull
    private c i;
    @NonNull
    private a j;
    @Nullable
    private b k;
    private eu l;
    int a;
    public final ei b;
    ez c;
    private static Handler m;
    private boolean n;
    private o o;
    
    public eq(@NonNull final Context referent, @NonNull final fe h, @NonNull final l g, @NonNull final bn f, @NonNull final c i, @NonNull final a j, @NonNull final b k) {
        this.a = 0;
        this.n = false;
        this.e = new WeakReference<Context>(referent);
        this.g = g;
        this.f = f;
        this.i = i;
        this.j = j;
        this.k = k;
        this.b = new ei();
        this.h = h;
        this.c = ez.a(referent);
    }
    
    private Context c() {
        return this.e.get();
    }
    
    public final es a(@Nullable es a, @NonNull final ViewGroup viewGroup, final o o) {
        this.o = o;
        a = this.a(a, viewGroup);
        if (!this.n) {
            this.b(a, this.f.d);
        }
        return a;
    }
    
    public final es b(@Nullable es a, @NonNull final ViewGroup viewGroup, final o o) {
        this.o = o;
        a = this.a(a, viewGroup);
        eq.m.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                if (!eq.this.n) {
                    eq.this.b(a, eq.this.f.d);
                }
            }
        });
        return a;
    }
    
    private es a(@Nullable final es es, @NonNull final ViewGroup viewGroup) {
        es es3;
        es es2;
        if (es == null) {
            es2 = (es3 = (es)this.c.a(this.c(), this.f.d, this.h));
        }
        else {
            es2 = es;
            es3 = es;
        }
        final es es4 = es3;
        if (es2 != null && es != null) {
            a(es4);
            this.c.a(es4);
            ez.a((View)es4, this.f.d.c);
        }
        ez.b(this.f.d.c.a.x);
        es4.setLayoutParams(ez.a(this.f.d, viewGroup));
        return es4;
    }
    
    private static void a(@NonNull final es es) {
        final ViewParent parent;
        if ((parent = es.getParent()) instanceof ViewGroup) {
            ((ViewGroup)parent).removeView((View)es);
        }
    }
    
    public final ViewGroup a(@NonNull final ViewGroup viewGroup, @NonNull final bl bl) {
        final ViewGroup viewGroup2;
        if ((viewGroup2 = (ViewGroup)this.c.a(this.c(), bl, this.h)) != null) {
            viewGroup2.setLayoutParams(ez.a(bl, viewGroup));
        }
        return viewGroup2;
    }
    
    @Override
    public final int a(final int a) {
        this.a = a;
        this.i.a(a, this.f.a(a));
        return this.d();
    }
    
    private void a(final bt bt, final bu bu) {
        bu.setTimerEventsListener(new bu.b() {
            @Override
            public final void a() {
                if (eq.this.k != null) {
                    eq.this.k.a(bt);
                }
            }
        });
    }
    
    private void a(final View view, final bj bj) {
        final List<ei.a> a;
        Label_0075: {
            if ((a = this.b.a(view, bj)) == null) {
                final String s = "creativeView";
                final Iterator<bv> iterator = bj.u.iterator();
                while (true) {
                    while (iterator.hasNext()) {
                        if (s.equals(iterator.next().d)) {
                            final boolean b = true;
                            if (b) {
                                break Label_0075;
                            }
                            return;
                        }
                    }
                    final boolean b = false;
                    continue;
                }
            }
        }
        view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)new View.OnAttachStateChangeListener() {
            public final void onViewAttachedToWindow(final View view) {
                eq.this.b.a(a);
                eq.this.g;
                final bj a = com.inmobi.media.l.a(eq.this.g.k(), bj);
                bj.a("creativeView", eq.this.g.a((a != null) ? a : bj));
            }
            
            public final void onViewDetachedFromWindow(final View view) {
                view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
                final ei d = eq.this.b;
                final List a = a;
                final ei ei = d;
                if (a == null) {
                    return;
                }
                final Iterator<ei.a> iterator = a.iterator();
                while (iterator.hasNext()) {
                    iterator.next().a.cancel();
                }
                ei.a.removeAll(a);
            }
        });
    }
    
    public final ViewGroup b(@NonNull final ViewGroup viewGroup, @NonNull final bl bl) {
        this.a(bl, (View)viewGroup);
        for (final bj bj : bl) {
            if ("CONTAINER".equals(bj.b)) {
                if (bj.d.equalsIgnoreCase("card_scrollable")) {
                    final et et;
                    if ((et = (et)this.c.a(this.c(), bj, this.h)) == null) {
                        continue;
                    }
                    this.l = ev.a(et.getType(), this.f, this);
                    if (this.l == null) {
                        continue;
                    }
                    et.a((bl)bj, this.l, this.a, this.d(), this);
                    et.setLayoutParams(ez.a(bj, viewGroup));
                    this.a((View)et, bj);
                    viewGroup.addView((View)et);
                }
                else {
                    final ViewGroup viewGroup2;
                    if ((viewGroup2 = (ViewGroup)this.c.a(this.c(), bj, this.h)) == null) {
                        continue;
                    }
                    final ViewGroup b;
                    (b = this.b(viewGroup2, (bl)bj)).setLayoutParams(ez.a(bj, viewGroup));
                    this.a((View)b, bj);
                    viewGroup.addView((View)b);
                }
            }
            else {
                Object referent = null;
                if ("WEBVIEW".equals(bj.b)) {
                    if (((bx)bj).A && this.o != null) {
                        if (((View)(referent = this.o)).getParent() != null) {
                            ((ViewGroup)((View)referent).getParent()).removeView((View)referent);
                        }
                        this.o = null;
                    }
                    else if ("UNKNOWN".equals(((bx)bj).z)) {
                        continue;
                    }
                }
                else if ("IMAGE".equals(bj.b) && bj.e == null) {
                    continue;
                }
                if (referent == null) {
                    referent = this.c.a(this.c(), bj, this.h);
                }
                if (referent == null) {
                    continue;
                }
                final WeakReference weakReference = new WeakReference(referent);
                if (bj.o != -1) {
                    ((View)referent).setVisibility(4);
                    eq.m.postDelayed((Runnable)new Runnable() {
                        @Override
                        public final void run() {
                            final View view;
                            if ((view = (View)weakReference.get()) != null) {
                                view.setVisibility(0);
                            }
                        }
                    }, (long)(bj.o * 1000));
                }
                else if (bj.p != -1) {
                    eq.m.postDelayed((Runnable)new Runnable() {
                        @Override
                        public final void run() {
                            final View view;
                            if ((view = (View)weakReference.get()) != null) {
                                view.setVisibility(4);
                            }
                        }
                    }, (long)(bj.p * 1000));
                }
                ((View)referent).setLayoutParams(ez.a(bj, viewGroup));
                this.a((View)referent, bj);
                viewGroup.addView((View)referent);
                if ("VIDEO".equals(bj.b)) {
                    this.a((bw)bj, ((ey)referent).getVideoView());
                }
                this.a(bj, (View)referent);
                if ("TIMER".equals(bj.b)) {
                    ((View)referent).setTag((Object)"timerView");
                    this.a((bt)bj, (bu)referent);
                }
                if ("VIDEO".equals(bj.b)) {
                    ((ey)referent).a();
                }
                if (!"WEBVIEW".equals(bj.b) || !(referent instanceof o)) {
                    continue;
                }
                ((o)referent).setScrollable(((bx)bj).B);
                ((o)referent).setReferenceContainer(this.g.l);
                ((o)referent).setRenderViewEventListener(this.g.x());
                ((o)referent).setPlacementId(this.g.d);
                ((o)referent).setAllowAutoRedirection(this.g.f);
                ((o)referent).setCreativeId(this.g.e);
                ((o)referent).setImpressionId(this.g.c);
                if (((bx)bj).A) {
                    continue;
                }
                this.g.a((o)referent);
            }
        }
        return viewGroup;
    }
    
    private void a(final bj bj, final View view) {
        if (bj.h) {
            view.setOnClickListener((View.OnClickListener)new View.OnClickListener() {
                public final void onClick(final View view) {
                    eq.this.j.a(view, bj);
                }
            });
        }
    }
    
    @SuppressLint({ "SwitchIntDef" })
    private void a(@NonNull final bw bw, @NonNull final ex ex) {
        final bl bl = (bl)bw.t;
        long z = System.currentTimeMillis();
        if (bl != null && 0L != bl.z) {
            z = bl.z;
        }
        if (bl != null) {
            bl.z = z;
        }
        ex.setClickable(false);
        ex.setId(Integer.MAX_VALUE);
        ex.a(bw);
        if (bw.y != null) {
            bw.a((bw)bw.y);
        }
        ex.setQuartileCompletedListener(new ex.c() {
            @Override
            public final void a(final byte b) {
                if (!eq.this.g.j && eq.this.g instanceof m) {
                    ((m)eq.this.g).a(bw, b);
                    if (3 == b) {
                        try {
                            final m m = (m)eq.this.g;
                            final bw a = bw;
                            final m i = m;
                            if (!(boolean)a.v.get("didSignalVideoCompleted")) {
                                i.r();
                                final l.c h;
                                if ((h = i.h()) != null) {
                                    h.h();
                                }
                            }
                            if (1 == i.getPlacementType()) {
                                i.c(a);
                            }
                        }
                        catch (Exception ex) {
                            eq.d;
                        }
                    }
                }
            }
        });
        ex.setPlaybackEventListener(new ex.b() {
            @SuppressLint({ "SwitchIntDef" })
            @Override
            public final void a(final byte b) {
                if (!eq.this.g.j && eq.this.g instanceof m) {
                    try {
                        switch (b) {
                            default: {}
                            case 0: {
                                ((m)eq.this.g).z();
                            }
                            case 1: {
                                ((m)eq.this.g).b(bw);
                            }
                            case 2: {
                                ((m)eq.this.g).c(bw);
                            }
                            case 3: {
                                ((m)eq.this.g).d(bw);
                            }
                            case 5: {
                                ((m)eq.this.g).g(bw);
                            }
                        }
                    }
                    catch (Exception ex) {
                        eq.d;
                        fv.a().a(new gv(ex));
                    }
                }
            }
        });
        ex.setMediaErrorListener(new ex.a() {
            @Override
            public final void a() {
                if (!eq.this.g.j && eq.this.g instanceof m) {
                    try {
                        ((m)eq.this.g).a(bw);
                    }
                    catch (Exception ex) {
                        eq.d;
                    }
                }
            }
        });
        if (!this.g.j && this.g instanceof m) {
            try {
                ((m)this.g).a(ex);
            }
            catch (Exception ex2) {}
        }
    }
    
    private int d() {
        if (this.a == 0) {
            return 8388611;
        }
        if (this.f.c() - 1 == this.a) {
            return 8388613;
        }
        return 1;
    }
    
    public final void a() {
        this.n = true;
        this.e.clear();
        this.k = null;
        if (this.l != null) {
            this.l.destroy();
            this.l = null;
        }
    }
    
    static {
        d = eq.class.getSimpleName();
        eq.m = new Handler(Looper.getMainLooper());
    }
    
    interface b
    {
        void a(final bt p0);
    }
    
    interface c
    {
        void a(final int p0, final bj p1);
    }
    
    interface a
    {
        void a(final View p0, final bj p1);
    }
}
