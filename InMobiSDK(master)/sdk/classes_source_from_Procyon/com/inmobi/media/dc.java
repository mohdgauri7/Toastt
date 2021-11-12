// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.WorkerThread;
import android.os.SystemClock;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.CountDownLatch;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import java.util.List;

public final class dc implements dd
{
    List<cx> a;
    private String g;
    public String b;
    public String c;
    @NonNull
    public List<bv> d;
    @NonNull
    public List<cw> e;
    private cw h;
    private fe.k i;
    public int f;
    private cx j;
    
    dc(final fe.k i) {
        this.j = null;
        this.a = new ArrayList<cx>();
        this.d = new ArrayList<bv>();
        this.e = new ArrayList<cw>();
        this.i = i;
        this.f = 0;
    }
    
    private dc(final List<bv> c, final fe.k k) {
        this(k);
        if (c.size() != 0) {
            this.d = new ArrayList<bv>(c);
        }
    }
    
    public dc(final String g, final String b, final String c, final List<bv> list, final List<cw> c2, final fe.k k) {
        this(list, k);
        if (c2.size() != 0) {
            this.e = new ArrayList<cw>(c2);
        }
        this.g = g;
        this.a.add(new cx(g));
        this.b = b;
        this.c = c;
    }
    
    @Nullable
    @Override
    public final String a() {
        return this.c;
    }
    
    @Override
    public final String b() {
        if (this.g != null) {
            return this.g;
        }
        au.a();
        cx cx3 = null;
        cx cx2 = null;
        Label_0081: {
            final List<String> f;
            if (!(f = au.f()).isEmpty()) {
                for (final cx cx : this.a) {
                    if (f.contains(cx.a)) {
                        cx2 = (cx3 = cx);
                        break Label_0081;
                    }
                }
            }
            cx2 = (cx3 = null);
        }
        cx j = cx3;
        if (cx2 != null) {
            this.j = j;
            return this.g = j.a;
        }
        cx cx4 = null;
        final Iterator<cx> iterator2 = this.a.iterator();
        final double n = 2.0 * this.i.optimalVastVideoSize / 1048576.0;
        final double n2 = 1.0 * this.i.vastMaxAssetSize / 1048576.0;
        while (iterator2.hasNext()) {
            final cx cx5 = iterator2.next();
            final String[] split = this.b.split(":");
            int n3;
            try {
                n3 = Integer.parseInt(split[1]) * 60 + Integer.parseInt(split[2]);
            }
            catch (ArrayIndexOutOfBoundsException ex) {
                n3 = 0;
                fv.a().a(new gv(ex));
            }
            final double c = 1.0 * cx5.b * n3 / 8192.0;
            cx5.c = c;
            if (a(0.0, n, c)) {
                j = a(j, cx5, c);
            }
            else {
                if (!a(n, n2, c)) {
                    continue;
                }
                cx4 = b(cx4, cx5, c);
            }
        }
        this.a(j, cx4);
        if (TextUtils.isEmpty((CharSequence)this.g)) {
            final fe.c bitRate;
            if ((bitRate = this.i.bitRate).bitrate_mandatory || this.a.size() == 0) {
                return this.g;
            }
            final CountDownLatch countDownLatch = new CountDownLatch(this.a.size());
            try {
                this.a(bitRate, countDownLatch);
                countDownLatch.await(bitRate.headerTimeout, TimeUnit.MILLISECONDS);
            }
            catch (Exception ex2) {
                fv.a().a(new gv(ex2));
            }
            finally {
                final Iterator<cx> iterator3 = this.a.iterator();
                while (iterator3.hasNext()) {
                    final cx cx6;
                    final double c2 = (cx6 = iterator3.next()).c;
                    if (a(0.0, n, c2)) {
                        j = a(j, cx6, c2);
                    }
                    else {
                        if (!a(n, n2, c2)) {
                            continue;
                        }
                        cx4 = b(cx4, cx6, c2);
                    }
                }
                this.a(j, cx4);
            }
        }
        return this.g;
    }
    
    private void a(final fe.c c, final CountDownLatch countDownLatch) {
        final Iterator<cx> iterator = this.a.iterator();
        while (iterator.hasNext()) {
            final cy cy;
            (cy = new cy(iterator.next(), c.headerTimeout, countDownLatch)).c = SystemClock.elapsedRealtime();
            com.inmobi.media.cy.d.execute(new Runnable() {
                @WorkerThread
                @Override
                public final void run() {
                    try {
                        final gn a;
                        if ((a = new gq(cy.a(cy.this)).a()) != null) {
                            if (a.a()) {
                                cy.this.a(a);
                                return;
                            }
                            final cy a2 = cy.this;
                            final gn gn = a;
                            final cy cy = a2;
                            try {
                                ih.a().a(cy.a.h());
                                ih.a().b(gn.d());
                                ih.a().c(SystemClock.elapsedRealtime() - cy.c);
                                if (null != cy.b.get()) {
                                    ((cx)cy.b.get()).c = 1.0 * gn.b / 1048576.0;
                                }
                            }
                            catch (Exception ex) {
                                fv.a().a(new gv(ex));
                            }
                            finally {
                                cy.a();
                            }
                        }
                    }
                    catch (Exception ex2) {
                        cy.b();
                        final gn gn2;
                        (gn2 = new gn()).a = new gl(-1, "Network request failed with unknown error");
                        cy.this.a(gn2);
                    }
                }
            });
        }
    }
    
    private static boolean a(final double n, final double n2, final double n3) {
        return n3 > n && n3 <= n2;
    }
    
    private static cx a(cx cx, final cx cx2, final double n) {
        if (cx == null) {
            cx = cx2;
        }
        else if (n > cx.c) {
            cx = cx2;
        }
        return cx;
    }
    
    private static cx b(cx cx, final cx cx2, final double n) {
        if (cx == null) {
            cx = cx2;
        }
        else if (n < cx.c) {
            cx = cx2;
        }
        return cx;
    }
    
    private void a(final cx j, final cx i) {
        if (j != null) {
            this.j = j;
            this.g = j.a;
            return;
        }
        if (i != null) {
            this.j = i;
            this.g = i.a;
        }
    }
    
    @Override
    public final List<cx> c() {
        return this.a;
    }
    
    @NonNull
    @Override
    public final List<bv> d() {
        return this.d;
    }
    
    @NonNull
    @Override
    public final List<cw> e() {
        return this.e;
    }
    
    @Override
    public final void a(final cw h) {
        this.h = h;
    }
    
    @Override
    public final cw f() {
        return this.h;
    }
    
    final void a(final bv bv) {
        this.d.add(bv);
    }
}
