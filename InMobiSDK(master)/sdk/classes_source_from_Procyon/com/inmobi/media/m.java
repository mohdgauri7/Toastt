// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.os.SystemClock;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.TimeUnit;
import java.util.Locale;
import androidx.annotation.VisibleForTesting;
import java.security.SecureRandom;
import java.util.HashMap;
import android.view.ViewGroup;
import android.annotation.SuppressLint;
import com.iab.omid.library.inmobi.adsession.media.VastProperties;
import com.iab.omid.library.inmobi.adsession.media.Position;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import androidx.annotation.Nullable;
import java.util.Set;
import androidx.annotation.NonNull;
import android.content.Context;
import android.view.View;
import java.lang.ref.WeakReference;

public class m extends l
{
    private static final String x;
    private WeakReference<View> y;
    private final h.a z;
    public final dq.a w;
    
    private void b(final ex ex) {
        final int videoVolume = ex.getVideoVolume();
        final int lastVolume = ex.getLastVolume();
        if (videoVolume != lastVolume && lastVolume > 0) {
            this.b(true);
            ex.setLastVolume(videoVolume);
        }
    }
    
    private void b(final boolean b) {
        final c h;
        if (this.getPlacementType() == 0 && !this.l() && (h = this.h()) != null) {
            h.a(b);
        }
    }
    
    m(@NonNull final Context context, final byte b, @NonNull final bn a, @NonNull final String s, @Nullable final Set<de> set, @NonNull final fe fe, final long n, final boolean b2, final String s2) {
        super(context, b, a, s, set, fe, n, b2, s2);
        this.z = new h.a() {
            @Override
            public final void a() {
                m.x;
                final c h;
                if ((h = m.this.h()) != null) {
                    h.a();
                }
            }
            
            @Override
            public final void a(@NonNull final Object o) {
                if (null == m.this.o()) {
                    return;
                }
                final bw bw = (bw)o;
                m.x;
                bw.v.put("didRequestFullScreen", Boolean.TRUE);
                bw.v.put("isFullScreen", Boolean.TRUE);
                bw.v.put("shouldAutoPlay", Boolean.TRUE);
                if (bw.y != null) {
                    bw.y.v.put("didRequestFullScreen", Boolean.TRUE);
                    bw.y.v.put("isFullScreen", Boolean.TRUE);
                    bw.y.v.put("shouldAutoPlay", Boolean.TRUE);
                }
                if (0 == m.this.getPlacementType()) {
                    m.this.getViewableAd().a((byte)1);
                    bw.a("fullscreen", m.this.h(bw));
                }
                final c h;
                if ((h = m.this.h()) != null) {
                    h.b();
                }
            }
            
            @Override
            public final void b(@NonNull final Object o) {
                m.x;
                final bw bw;
                (bw = (bw)o).v.put("didRequestFullScreen", Boolean.FALSE);
                bw.v.put("isFullScreen", Boolean.FALSE);
                if (bw.y != null) {
                    bw.y.v.put("didRequestFullScreen", Boolean.FALSE);
                    bw.y.v.put("isFullScreen", Boolean.FALSE);
                    bw.y.y = null;
                }
                bw.y = null;
                if (m.this.getPlacementType() == 0) {
                    m.this.getViewableAd().a((byte)2);
                    if (m.this.l != null) {
                        m.this.l.getViewableAd().a((byte)16);
                    }
                    bw.a("exitFullscreen", m.this.h(bw));
                }
                else {
                    m.this.getViewableAd().a((byte)3);
                }
                final c h;
                if ((h = m.this.h()) != null) {
                    h.f();
                }
            }
        };
        this.w = new dq.a() {
            @Override
            public final void a(final View view, final boolean b) {
                m.this.a(b);
                m.a(m.this, view, b);
            }
        };
        this.a = a;
    }
    
    @Override
    public void destroy() {
        if (super.j) {
            return;
        }
        final ey ey;
        if (this.getVideoContainerView() != null && (ey = (ey)this.getVideoContainerView()) != null) {
            ey.getVideoView().g();
        }
        super.destroy();
    }
    
    @Override
    public final void a(final View view) {
        if (this.n() || super.j || !(view instanceof ex)) {
            return;
        }
        final ex ex = (ex)view;
        this.i = true;
        final bw bw = (bw)ex.getTag();
        if (!(boolean)bw.v.get("didImpressionFire")) {
            final List<bv> u = bw.u;
            final Map<String, String> h = this.h(bw);
            List<String> list = new ArrayList<String>();
            for (final bv bv : u) {
                if ("VideoImpression".equals(bv.d)) {
                    if (bv.b.startsWith("http")) {
                        bj.a(bv, h);
                    }
                    if ((list = (List<String>)bv.f.get("referencedEvents")) == null) {
                        continue;
                    }
                    final Iterator<String> iterator2 = list.iterator();
                    while (iterator2.hasNext()) {
                        bw.a(iterator2.next(), h);
                    }
                }
            }
            if (list.isEmpty()) {
                bw.a("start", h);
                bw.a("Impression", h);
            }
            this.a.d.a("Impression", this.h(bw));
            bw.v.put("didImpressionFire", Boolean.TRUE);
            this.h.a((byte)0);
            if (null != this.h()) {
                this.h().d();
            }
        }
    }
    
    public final boolean l() {
        return 0 == this.getPlacementType() && this.o() != null;
    }
    
    @SuppressLint({ "SwitchIntDef" })
    @Override
    public dg getViewableAd() {
        final Context m = this.m();
        if (this.h == null && m != null) {
            this.j();
            this.h = new dp(this, new dj(this));
            if (this.g != null) {
                for (final de de : this.g) {
                    try {
                        switch (de.a) {
                            case 3: {
                                final dy dy = de.b.get("omidAdSession");
                                final boolean booleanValue = de.b.get("videoAutoPlay");
                                final boolean booleanValue2 = de.b.get("videoSkippable");
                                final int intValue = de.b.get("videoSkipOffset");
                                VastProperties vastProperties;
                                if (booleanValue2) {
                                    vastProperties = VastProperties.createVastPropertiesForSkippableMedia((float)intValue, booleanValue, Position.STANDALONE);
                                }
                                else {
                                    vastProperties = VastProperties.createVastPropertiesForNonSkippableMedia(booleanValue, Position.STANDALONE);
                                }
                                if (dy != null) {
                                    this.h = new ee(m, this.h, this, dy, vastProperties);
                                    continue;
                                }
                                continue;
                            }
                            case 1: {
                                final Context context = m;
                                final dg h = this.h;
                                final Map<String, Object> b = de.b;
                                final dg dg = h;
                                final Context context2 = context;
                                final bw bw = this.a.c("VIDEO").get(0);
                                final StringBuilder sb = new StringBuilder();
                                for (final bv bv : bw.u) {
                                    if ("zMoatVASTIDs".equals(bv.d)) {
                                        sb.append(bv.b);
                                    }
                                }
                                if (sb.length() > 0) {
                                    b.put("zMoatVASTIDs", sb.toString());
                                }
                                this.h = new dw(context2, dg, this, b);
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
    
    @NonNull
    @Override
    public h.a getFullScreenEventsListener() {
        return this.z;
    }
    
    @Nullable
    @Override
    public View getVideoContainerView() {
        if (this.y == null) {
            return null;
        }
        return this.y.get();
    }
    
    @Override
    final boolean q() {
        return !this.p;
    }
    
    @Override
    protected final void b(@NonNull final bj bj) {
        switch (bj.l) {
            case 0: {}
            default: {
                try {
                    if (1 != this.getPlacementType()) {
                        final c h;
                        if ((h = this.h()) != null) {
                            h.i();
                        }
                        this.B();
                        return;
                    }
                    super.b(bj);
                    if (!"VIDEO".equals(bj.b)) {
                        return;
                    }
                    final ey ey;
                    if ((ey = (ey)this.getVideoContainerView()) != null) {
                        ey.getVideoView().h();
                        final ex videoView;
                        if ((videoView = ey.getVideoView()).f() && videoView.a.isPlaying()) {
                            videoView.a.pause();
                            videoView.a.seekTo(0);
                            videoView.b.a();
                            if (videoView.getTag() != null) {
                                final bw bw;
                                (bw = (bw)videoView.getTag()).v.put("didPause", Boolean.TRUE);
                                bw.v.put("seekPosition", 0);
                                bw.v.put("didCompleteQ4", Boolean.TRUE);
                            }
                            videoView.a.a = 4;
                            videoView.getPlaybackEventListener().a((byte)4);
                        }
                        if (videoView.a != null) {
                            videoView.a.b = 4;
                        }
                    }
                    this.B();
                }
                catch (Exception ex) {
                    fv.a().a(new gv(ex));
                }
            }
            case 3: {
                try {
                    if (!"VIDEO".equals(bj.b)) {
                        return;
                    }
                    if (super.t != null) {
                        super.t.e("window.imraid.broadcastEvent('replay');");
                    }
                    if (this.i() != null) {
                        final View i;
                        final bu b;
                        if ((b = com.inmobi.media.l.b(i = this.i())) != null) {
                            b.a();
                        }
                        final ViewGroup viewGroup;
                        if ((viewGroup = (ViewGroup)i.getParent()) != null) {
                            viewGroup.removeView(i);
                        }
                    }
                    final ey ey2;
                    if ((ey2 = (ey)this.getVideoContainerView()) != null) {
                        ey2.getVideoView().i();
                        ey2.getVideoView().start();
                    }
                }
                catch (Exception ex2) {
                    hf.a((byte)2, "InMobi", "SDK encountered unexpected error in replaying video");
                    fv.a().a(new gv(ex2));
                }
            }
            case 1: {
                super.b(bj);
            }
            case 4: {
                try {
                    final ey ey3;
                    if (0 == this.getPlacementType() && (ey3 = (ey)this.getVideoContainerView()) != null) {
                        final ex videoView2;
                        final bw bw2 = (bw)(videoView2 = ey3.getVideoView()).getTag();
                        if (videoView2.getState() != 1) {
                            try {
                                final bw bw3 = bw2;
                                final ex ex3 = videoView2;
                                final bw bw4 = bw3;
                                if (super.j || null == this.n.get()) {
                                    return;
                                }
                                if (!(boolean)bw4.v.get("didRequestFullScreen")) {
                                    bw4.v.put("didRequestFullScreen", Boolean.TRUE);
                                    bw4.v.put("seekPosition", ex3.getCurrentPosition());
                                    bw4.v.put("lastMediaVolume", ex3.getVolume());
                                    if (ex3.getMediaPlayer().isPlaying()) {
                                        ex3.getMediaPlayer().pause();
                                        ex3.getAudioFocusManager().a();
                                    }
                                    ex3.getMediaPlayer().a = 4;
                                    bw4.v.put("isFullScreen", Boolean.TRUE);
                                    bw4.v.put("seekPosition", ex3.getMediaPlayer().getCurrentPosition());
                                    this.p();
                                }
                            }
                            catch (Exception ex4) {
                                fv.a().a(new gv(ex4));
                            }
                        }
                    }
                }
                catch (Exception ex5) {
                    hf.a((byte)2, "InMobi", "SDK encountered unexpected error in expanding video to fullscreen");
                    fv.a().a(new gv(ex5));
                }
            }
            case 5: {
                try {
                    final ey ey4;
                    if ((ey4 = (ey)this.getVideoContainerView()) != null) {
                        final bw bw5;
                        (bw5 = (bw)ey4.getVideoView().getTag()).v.put("shouldAutoPlay", Boolean.TRUE);
                        if (bw5.y != null) {
                            bw5.y.v.put("shouldAutoPlay", Boolean.TRUE);
                        }
                        ey4.getVideoView().start();
                    }
                    return;
                }
                catch (Exception ex6) {
                    hf.a((byte)2, "InMobi", "SDK encountered unexpected error in playing video");
                    fv.a().a(new gv(ex6));
                    return;
                }
                break;
            }
        }
    }
    
    public final void a(@NonNull final ex ex) {
        ex.setIsLockScreen(super.r);
        final ey referent = (ey)ex.getParent();
        this.y = new WeakReference<View>((View)referent);
        final ew mediaController;
        if ((mediaController = referent.getVideoView().getMediaController()) != null) {
            mediaController.setVideoAd(this);
        }
    }
    
    public final void a(final bw bw) {
        if (super.j) {
            return;
        }
        bw.a("error", this.h(bw));
        this.h.a((byte)17);
    }
    
    public final void z() {
        this.h.a((byte)5);
    }
    
    public final void b(final bw bw) {
        if (super.j) {
            return;
        }
        if (0 == this.getPlacementType()) {
            if (bw.v.get("currentMediaVolume") > 0 && 0 == bw.v.get("lastMediaVolume")) {
                this.f(bw);
            }
            if (bw.v.get("currentMediaVolume") == 0 && bw.v.get("lastMediaVolume") > 0) {
                this.e(bw);
            }
        }
        if (!bw.v.get("didStartPlaying")) {
            bw.v.put("didStartPlaying", Boolean.TRUE);
            this.getViewableAd().a((byte)6);
        }
    }
    
    public final void c(final bw bw) {
        if (super.j) {
            return;
        }
        com.inmobi.media.l.c(this.i());
        bw.a("pause", this.h(bw));
        this.h.a((byte)7);
    }
    
    public final void d(final bw bw) {
        if (super.j) {
            return;
        }
        com.inmobi.media.l.d(this.i());
        bw.a("resume", this.h(bw));
        this.h.a((byte)8);
    }
    
    public final void e(final bw bw) {
        if (super.j) {
            return;
        }
        bw.v.put("lastMediaVolume", 0);
        bw.a("mute", this.h(bw));
        this.h.a((byte)13);
    }
    
    public final void f(final bw bw) {
        if (super.j) {
            return;
        }
        bw.v.put("lastMediaVolume", 15);
        bw.a("unmute", this.h(bw));
        this.h.a((byte)14);
    }
    
    private void B() {
        this.h.a((byte)15);
    }
    
    public final void a(final bw bw, final byte b) {
        if (super.j) {
            return;
        }
        switch (b) {
            case 0: {
                bw.a("firstQuartile", this.h(bw));
                this.h.a((byte)9);
            }
            case 1: {
                bw.a("midpoint", this.h(bw));
                this.h.a((byte)10);
            }
            case 2: {
                bw.a("thirdQuartile", this.h(bw));
                this.h.a((byte)11);
            }
            case 3: {
                if (!bw.v.get("didQ4Fire")) {
                    this.g(bw);
                    break;
                }
                break;
            }
        }
    }
    
    public final void g(final bw bw) {
        bw.v.put("didQ4Fire", Boolean.TRUE);
        bw.a("complete", this.h(bw));
        this.h.a((byte)12);
    }
    
    @Override
    public final void t() {
        super.t();
        final ey ey;
        if ((ey = (ey)this.getVideoContainerView()) != null) {
            final ex videoView;
            final ex ex = videoView = ey.getVideoView();
            if (this.getPlacementType() == 0 && !this.l() && videoView.getVideoVolume() > 0) {
                videoView.setLastVolume(-2);
                this.b(true);
            }
            ex.pause();
        }
    }
    
    private Map<String, String> h(@NonNull final bw bw) {
        final bl bl = (bl)bw.t;
        final HashMap<String, String> hashMap = new HashMap<String, String>(4);
        final ey ey;
        if ((ey = this.y.get()) != null) {
            hashMap.put("$MD", String.valueOf((int)Math.round(ey.getVideoView().getDuration() * 1.0 / 1000.0)));
        }
        hashMap.put("[ERRORCODE]", "405");
        hashMap.put("[CONTENTPLAYHEAD]", a(bw.v.get("seekPosition")));
        hashMap.put("[CACHEBUSTING]", C());
        hashMap.put("[ASSETURI]", bw.b().b());
        hashMap.put("$TS", String.valueOf(System.currentTimeMillis()));
        hashMap.put("$LTS", String.valueOf(this.a.d.z));
        if (bl != null) {
            hashMap.put("$STS", String.valueOf(bl.z));
        }
        if (this.a != null) {
            hashMap.putAll((Map<?, ?>)this.a.a());
        }
        return hashMap;
    }
    
    @VisibleForTesting
    private static String C() {
        final SecureRandom secureRandom = new SecureRandom();
        final StringBuilder sb = new StringBuilder();
        int i;
        for (i = 0; i == 0; i = (secureRandom.nextInt() & Integer.MAX_VALUE) % 10) {}
        sb.append(i);
        for (int j = 1; j < 8; ++j) {
            sb.append((secureRandom.nextInt() & Integer.MAX_VALUE) % 10);
        }
        return sb.toString();
    }
    
    @VisibleForTesting
    private static String a(final int n) {
        return String.format(Locale.US, "%02d:%02d:%02d.%03d", TimeUnit.MILLISECONDS.toHours(n), TimeUnit.MILLISECONDS.toMinutes(n) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(n)), TimeUnit.MILLISECONDS.toSeconds(n) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(n)), n - TimeUnit.MILLISECONDS.toSeconds(n) * 1000L);
    }
    
    static /* synthetic */ void a(final m m, final View view, final boolean b) {
        final ex ex;
        final bw bw;
        if ((ex = (ex)view.findViewById(Integer.MAX_VALUE)) != null && (bw = (bw)ex.getTag()) != null) {
            new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
                @Override
                public final void run() {
                    bw.v.put("visible", b);
                    if (b && !m.this.k) {
                        bw.v.put("lastVisibleTimestamp", SystemClock.uptimeMillis());
                        if (ex.d && ex.getMediaPlayer() != null) {
                            if (bw.a()) {
                                ex.i();
                            }
                            else {
                                ex.h();
                            }
                        }
                        final ex c;
                        if ((c = ex).c != null) {
                            c.c.removeMessages(0);
                        }
                        c.d = false;
                        m.a(m.this, ex);
                        m.a(m.this, ex, bw);
                        if (1 == ex.getState()) {
                            ex.getMediaPlayer().b = 3;
                            return;
                        }
                        if (2 == ex.getState() || 4 == ex.getState() || (5 == ex.getState() && bw.C)) {
                            ex.start();
                        }
                    }
                    else {
                        m.b(m.this, ex);
                        final ex c2 = ex;
                        final int f = bw.F;
                        final ex ex = c2;
                        if (c2.d || 4 == ex.getState()) {
                            return;
                        }
                        if (ex.c == null) {
                            ex.c = new Handler(Looper.getMainLooper());
                        }
                        if (f > 0) {
                            ex.d = true;
                            ex.h();
                            ex.c.postDelayed((Runnable)new Runnable() {
                                @Override
                                public final void run() {
                                    ex.pause();
                                }
                            }, (long)(f * 1000));
                            return;
                        }
                        ex.pause();
                    }
                }
            });
        }
    }
    
    static /* synthetic */ void a(final m m, final ex ex) {
        if (m.getPlacementType() == 0 && !m.l()) {
            final int videoVolume = ex.getVideoVolume();
            if (videoVolume != ex.getLastVolume() && ex.isPlaying()) {
                m.b(videoVolume <= 0);
                ex.setLastVolume(videoVolume);
            }
        }
    }
    
    static /* synthetic */ void a(final m m, final ex ex, final bw bw) {
        if (m.getPlacementType() == 0 && !m.l() && !bw.C && !ex.isPlaying() && ex.getState() == 5) {
            m.b(ex);
        }
    }
    
    static /* synthetic */ void b(final m m, final ex ex) {
        if (m.getPlacementType() == 0 && !m.l() && !m.k) {
            m.b(ex);
        }
    }
    
    static {
        x = m.class.getSimpleName();
    }
}
