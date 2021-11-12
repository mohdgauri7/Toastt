// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.ads.rendering;

import android.graphics.Point;
import com.inmobi.media.bn;
import android.widget.FrameLayout;
import android.content.res.Configuration;
import com.inmobi.media.ey;
import android.annotation.TargetApi;
import com.inmobi.media.hc;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.inmobi.media.de;
import java.util.Set;
import com.inmobi.media.ff;
import android.content.Context;
import com.inmobi.media.ho;
import android.os.Build;
import com.inmobi.media.hf;
import com.inmobi.media.gz;
import android.os.Bundle;
import com.inmobi.media.fe;
import com.inmobi.media.dg;
import android.view.View;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import java.util.HashMap;
import com.inmobi.media.l;
import com.inmobi.media.gv;
import com.inmobi.media.fv;
import android.os.Handler;
import android.os.Looper;
import com.inmobi.media.bw;
import com.inmobi.media.m;
import androidx.annotation.NonNull;
import android.content.Intent;
import java.util.Map;
import com.inmobi.media.ex;
import com.inmobi.media.cf;
import androidx.annotation.Nullable;
import com.inmobi.media.q;
import com.inmobi.media.o;
import com.inmobi.media.h;
import android.util.SparseArray;
import android.annotation.SuppressLint;
import android.app.Activity;

@SuppressLint({ "ClickableViewAccessibility" })
public class InMobiAdActivity extends Activity
{
    private static final String g;
    private static SparseArray<h> h;
    private static o i;
    private static q j;
    private h k;
    @Nullable
    private o l;
    private cf m;
    private cf n;
    private ex o;
    private int p;
    private int q;
    public boolean a;
    private boolean r;
    private boolean s;
    @SuppressLint({ "UseSparseArrays" })
    public static Map<Integer, a> b;
    @SuppressLint({ "UseSparseArrays" })
    public static Map<Integer, Intent> c;
    public static Integer d;
    @SuppressLint({ "UseSparseArrays" })
    public static Map<Integer, Object> e;
    public static Integer f;
    
    public InMobiAdActivity() {
        this.a = false;
        this.r = false;
        this.s = false;
    }
    
    public static int a(final h h) {
        final int hashCode = h.hashCode();
        InMobiAdActivity.h.put(hashCode, (Object)h);
        return hashCode;
    }
    
    public static void a(@NonNull final Object o) {
        InMobiAdActivity.h.remove(o.hashCode());
    }
    
    public static void a(final o i) {
        InMobiAdActivity.i = i;
    }
    
    public static void a(final q j) {
        InMobiAdActivity.j = j;
    }
    
    protected void onResume() {
        super.onResume();
        if (!this.a) {
            if (100 == this.p) {
                if (this.l != null && this.l.getFullScreenEventsListener() != null) {
                    try {
                        if (!this.r) {
                            this.r = true;
                            this.l.getFullScreenEventsListener().a(this.l);
                        }
                    }
                    catch (Exception ex3) {}
                }
            }
            else if (this.q == 200 && 102 == this.p) {
                if (this.k != null && this.k.getFullScreenEventsListener() != null) {
                    try {
                        if (!this.r) {
                            this.r = true;
                            this.k.getFullScreenEventsListener().a(null);
                        }
                    }
                    catch (Exception ex4) {}
                }
            }
            else if (201 == this.q) {
                if (this.k instanceof m && this.o != null) {
                    final bw bw;
                    if ((bw = (bw)this.o.getTag()) != null && this.s) {
                        new Handler(Looper.getMainLooper()).postDelayed((Runnable)new Runnable() {
                            @Override
                            public final void run() {
                                if (InMobiAdActivity.this.k != null && (InMobiAdActivity.this.k.getPlacementType() != 1 || !bw.v.get("didCompleteQ4"))) {
                                    InMobiAdActivity.this.o.start();
                                }
                            }
                        }, 50L);
                    }
                    if (this.k.getFullScreenEventsListener() != null) {
                        try {
                            if (!this.r) {
                                this.r = true;
                                this.k.getFullScreenEventsListener().a(bw);
                            }
                        }
                        catch (Exception ex) {
                            fv.a().a(new gv(ex));
                        }
                    }
                }
                else if (this.k instanceof l) {
                    try {
                        if (!this.r) {
                            this.r = true;
                            this.k.getFullScreenEventsListener().a(null);
                        }
                    }
                    catch (Exception ex2) {
                        fv.a().a(new gv(ex2));
                    }
                }
            }
            this.s = false;
        }
    }
    
    protected void onStart() {
        super.onStart();
        if (!this.a && 102 == this.p && this.k != null) {
            final dg viewableAd = this.k.getViewableAd();
            if (200 == this.q) {
                if (1 != this.k.getPlacementType()) {
                    return;
                }
                try {
                    final HashMap<cf, FriendlyObstructionPurpose> hashMap;
                    (hashMap = new HashMap<cf, FriendlyObstructionPurpose>()).put(this.m, FriendlyObstructionPurpose.CLOSE_AD);
                    hashMap.put(this.n, FriendlyObstructionPurpose.CLOSE_AD);
                    viewableAd.a((Map<View, FriendlyObstructionPurpose>)hashMap);
                    return;
                }
                catch (Exception ex2) {
                    if (this.k.getFullScreenEventsListener() != null) {
                        this.k.getFullScreenEventsListener().a();
                    }
                    return;
                }
            }
            if (201 == this.q) {
                try {
                    final fe adConfig = this.k.getAdConfig();
                    if (viewableAd.b() != null) {
                        if (this.k instanceof m) {
                            final bw bw;
                            if ((bw = (bw)this.o.getTag()) != null) {
                                final fe.m viewability = adConfig.viewability;
                                final bw bw2 = bw;
                                int impressionMinTimeViewed = viewability.video.impressionMinTimeViewed;
                                final bw bw3 = bw2;
                                if (bw2.G.containsKey("time")) {
                                    impressionMinTimeViewed = (int)bw3.G.get("time");
                                }
                                viewability.video.impressionMinTimeViewed = impressionMinTimeViewed;
                                viewableAd.a((Map<View, FriendlyObstructionPurpose>)null);
                            }
                            return;
                        }
                        if (this.k instanceof l) {
                            try {
                                viewableAd.a((Map<View, FriendlyObstructionPurpose>)null);
                            }
                            catch (Exception ex3) {
                                if (this.k.getFullScreenEventsListener() != null) {
                                    this.k.getFullScreenEventsListener().a();
                                }
                            }
                        }
                    }
                }
                catch (Exception ex) {
                    if (this.k.getFullScreenEventsListener() != null) {
                        this.k.getFullScreenEventsListener().a();
                    }
                    fv.a().a(new gv(ex));
                }
            }
        }
    }
    
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        this.setIntent(intent);
        this.b();
    }
    
    @TargetApi(23)
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        if (!gz.a()) {
            this.finish();
            hf.a((byte)2, "InMobi", "Session not found, AdActivity will be closed");
            return;
        }
        this.r = false;
        if (Build.VERSION.SDK_INT >= 29) {
            ho.a((Context)this);
        }
        this.p = this.getIntent().getIntExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 102);
        if (this.p == 100) {
            final String stringExtra = this.getIntent().getStringExtra("com.inmobi.ads.rendering.InMobiAdActivity.IN_APP_BROWSER_URL");
            final long longExtra = this.getIntent().getLongExtra("placementId", Long.MIN_VALUE);
            final boolean booleanExtra = this.getIntent().getBooleanExtra("allowAutoRedirection", false);
            final String stringExtra2 = this.getIntent().getStringExtra("impressionId");
            final String stringExtra3 = this.getIntent().getStringExtra("creativeId");
            q q = com.inmobi.media.o.a;
            fe adConfig;
            if (InMobiAdActivity.i != null) {
                q = InMobiAdActivity.i.getListener();
                adConfig = InMobiAdActivity.i.getAdConfig();
            }
            else {
                adConfig = (fe)ff.a("ads", gz.f());
                if (InMobiAdActivity.j != null) {
                    q = InMobiAdActivity.j;
                }
            }
            try {
                (this.l = new o((Context)this, (byte)1, null, stringExtra2)).setPlacementId(longExtra);
                this.l.setCreativeId(stringExtra3);
                this.l.setAllowAutoRedirection(booleanExtra);
                this.l.setShouldFireRenderBeacon(false);
                this.l.setIsInAppBrowser(true);
                this.l.a(q, adConfig, false, false);
                final RelativeLayout contentView = new RelativeLayout((Context)this);
                final RelativeLayout.LayoutParams layoutParams;
                (layoutParams = new RelativeLayout.LayoutParams(-1, -1)).addRule(10);
                layoutParams.addRule(2, 65533);
                contentView.setBackgroundColor(-1);
                contentView.addView((View)this.l, (ViewGroup.LayoutParams)layoutParams);
                final ViewGroup viewGroup = (ViewGroup)contentView;
                final float c = ho.a().c;
                final LinearLayout linearLayout = new LinearLayout((Context)this);
                final RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, (int)(48.0f * c));
                linearLayout.setOrientation(0);
                linearLayout.setId(65533);
                linearLayout.setWeightSum(100.0f);
                linearLayout.setBackgroundResource(17301658);
                linearLayout.setBackgroundColor(-7829368);
                layoutParams2.addRule(12);
                viewGroup.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams2);
                final LinearLayout.LayoutParams layoutParams3;
                (layoutParams3 = new LinearLayout.LayoutParams(-1, -1)).weight = 25.0f;
                final cf cf;
                (cf = new cf((Context)this, c, (byte)2)).setOnTouchListener((View.OnTouchListener)new View.OnTouchListener() {
                    public final boolean onTouch(final View view, final MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 1) {
                            view.setBackgroundColor(-7829368);
                            InMobiAdActivity.this.a = true;
                            InMobiAdActivity.this.finish();
                            return true;
                        }
                        if (motionEvent.getAction() == 0) {
                            view.setBackgroundColor(-16711681);
                            return true;
                        }
                        return true;
                    }
                });
                linearLayout.addView((View)cf, (ViewGroup.LayoutParams)layoutParams3);
                final cf cf2;
                (cf2 = new cf((Context)this, c, (byte)3)).setOnTouchListener((View.OnTouchListener)new View.OnTouchListener() {
                    public final boolean onTouch(final View view, final MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 1) {
                            view.setBackgroundColor(-7829368);
                            InMobiAdActivity.this.l.reload();
                            return true;
                        }
                        if (motionEvent.getAction() == 0) {
                            view.setBackgroundColor(-16711681);
                            return true;
                        }
                        return true;
                    }
                });
                linearLayout.addView((View)cf2, (ViewGroup.LayoutParams)layoutParams3);
                final cf cf3;
                (cf3 = new cf((Context)this, c, (byte)4)).setOnTouchListener((View.OnTouchListener)new View.OnTouchListener() {
                    public final boolean onTouch(final View view, final MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 1) {
                            view.setBackgroundColor(-7829368);
                            if (InMobiAdActivity.this.l.canGoBack()) {
                                InMobiAdActivity.this.l.goBack();
                            }
                            else {
                                InMobiAdActivity.this.a = true;
                                InMobiAdActivity.this.finish();
                            }
                            return true;
                        }
                        if (motionEvent.getAction() == 0) {
                            view.setBackgroundColor(-16711681);
                            return true;
                        }
                        return true;
                    }
                });
                linearLayout.addView((View)cf3, (ViewGroup.LayoutParams)layoutParams3);
                final cf cf4;
                (cf4 = new cf((Context)this, c, (byte)6)).setOnTouchListener((View.OnTouchListener)new View.OnTouchListener() {
                    public final boolean onTouch(final View view, final MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 1) {
                            view.setBackgroundColor(-7829368);
                            if (InMobiAdActivity.this.l.canGoForward()) {
                                InMobiAdActivity.this.l.goForward();
                            }
                            return true;
                        }
                        if (motionEvent.getAction() == 0) {
                            view.setBackgroundColor(-16711681);
                            return true;
                        }
                        return true;
                    }
                });
                linearLayout.addView((View)cf4, (ViewGroup.LayoutParams)layoutParams3);
                this.setContentView((View)contentView);
                this.l.loadUrl(stringExtra);
                this.l.setFullScreenActivityContext(this);
                return;
            }
            catch (Exception ex) {
                fv.a().a(new gv(ex));
                q.a();
                this.finish();
                return;
            }
        }
        if (this.p == 102) {
            this.b();
            return;
        }
        if (this.p == 103) {
            final int intExtra;
            if ((intExtra = this.getIntent().getIntExtra("id", -1)) != -1) {
                this.startActivityForResult((Intent)InMobiAdActivity.c.get(intExtra), intExtra);
            }
            return;
        }
        final int intExtra2;
        final String[] stringArrayExtra;
        if (this.p == 104 && (intExtra2 = this.getIntent().getIntExtra("id", -1)) != -1 && (stringArrayExtra = this.getIntent().getStringArrayExtra("permissions")) != null && stringArrayExtra.length > 0 && Build.VERSION.SDK_INT >= 23) {
            hc.b();
            this.requestPermissions(stringArrayExtra, intExtra2);
        }
    }
    
    private void b() {
        if (this.getIntent().hasExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_INDEX")) {
            this.k = (h)InMobiAdActivity.h.get(this.getIntent().getIntExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_INDEX", -1));
            if (this.k == null) {
                this.finish();
                return;
            }
            this.q = this.getIntent().getIntExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_TYPE", 0);
            if (this.q == 0) {
                if (this.k.getFullScreenEventsListener() != null) {
                    this.k.getFullScreenEventsListener().a();
                }
                this.finish();
                return;
            }
            if (this.getIntent().getBooleanExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_IS_FULL_SCREEN", false)) {
                this.requestWindowFeature(1);
                this.getWindow().setFlags(1024, 1024);
            }
            if ((200 == this.q && !"html".equals(this.k.getMarkupType())) || (201 == this.q && !"inmobiJson".equals(this.k.getMarkupType()))) {
                if (this.k.getFullScreenEventsListener() != null) {
                    this.k.getFullScreenEventsListener().a();
                }
                this.finish();
                return;
            }
            try {
                this.k.setFullScreenActivityContext(this);
                this.c();
            }
            catch (Exception ex) {
                this.k.setFullScreenActivityContext(null);
                if (this.k.getFullScreenEventsListener() != null) {
                    this.k.getFullScreenEventsListener().a();
                }
                this.finish();
                fv.a().a(new gv(ex));
            }
        }
    }
    
    public void onStop() {
        super.onStop();
        if (!this.a) {
            this.s = true;
            if (this.o != null) {
                this.o.pause();
            }
        }
    }
    
    protected void onDestroy() {
        if (this.a) {
            if (100 == this.p) {
                if (this.l != null && this.l.getFullScreenEventsListener() != null) {
                    try {
                        this.l.getFullScreenEventsListener().b(this.l);
                        this.l.destroy();
                        this.l = null;
                    }
                    catch (Exception ex5) {}
                }
            }
            else if (102 == this.p && this.k != null && this.k.getFullScreenEventsListener() != null) {
                if (200 == this.q) {
                    try {
                        this.k.getFullScreenEventsListener().b(null);
                    }
                    catch (Exception ex6) {
                        hf.a((byte)2, "InMobi", "SDK encountered unexpected error while finishing fullscreen view");
                    }
                }
                else if (201 == this.q) {
                    if (this.k instanceof m) {
                        final ey ey;
                        if ((ey = (ey)((m)this.k).getVideoContainerView()) != null) {
                            final bw bw = (bw)ey.getVideoView().getTag();
                            try {
                                this.k.getFullScreenEventsListener().b(bw);
                            }
                            catch (Exception ex) {
                                hf.a((byte)2, "InMobi", "SDK encountered unexpected error while finishing fullscreen view");
                                fv.a().a(new gv(ex));
                            }
                        }
                    }
                    else if (this.k instanceof l) {
                        try {
                            this.k.getFullScreenEventsListener().b(null);
                        }
                        catch (Exception ex2) {
                            hf.a((byte)2, "InMobi", "SDK encountered unexpected error while finishing fullscreen view");
                            fv.a().a(new gv(ex2));
                        }
                    }
                }
            }
            if (this.k != null) {
                this.k.destroy();
                this.k = null;
            }
        }
        else if (100 != this.p && 102 == this.p && this.k != null) {
            if (200 == this.q) {
                final o o;
                (o = (o)this.k).setFullScreenActivityContext(null);
                try {
                    o.b();
                }
                catch (Exception ex7) {
                    hf.a((byte)2, "InMobi", "SDK encountered unexpected error in processing close request");
                }
            }
            else if (201 == this.q) {
                if (this.k instanceof m) {
                    final m m = (m)this.k;
                    final bw bw2;
                    if (this.o != null && (bw2 = (bw)this.o.getTag()) != null) {
                        if (1 == m.getPlacementType()) {
                            this.o.e();
                        }
                        if (this.k.getFullScreenEventsListener() != null) {
                            try {
                                this.k.getFullScreenEventsListener().b(bw2);
                            }
                            catch (Exception ex3) {
                                hf.a((byte)2, "InMobi", "SDK encountered unexpected error while finishing fullscreen view");
                                fv.a().a(new gv(ex3));
                            }
                        }
                    }
                }
                else if (this.k instanceof l && this.k.getFullScreenEventsListener() != null) {
                    try {
                        this.k.getFullScreenEventsListener().b(null);
                    }
                    catch (Exception ex4) {
                        hf.a((byte)2, "InMobi", "SDK encountered unexpected error while finishing fullscreen view");
                        fv.a().a(new gv(ex4));
                    }
                }
            }
            a((Object)this.k);
            this.k.destroy();
            this.k = null;
        }
        super.onDestroy();
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.l != null) {
            final o l = this.l;
            if ("Resized".equals(l.d) && l.getResizeProperties() != null) {
                l.g.a();
            }
        }
    }
    
    private void c() {
        final FrameLayout frameLayout = (FrameLayout)this.findViewById(16908290);
        final RelativeLayout relativeLayout;
        (relativeLayout = new RelativeLayout(this.getApplicationContext())).setId(65534);
        final float c = ho.a().c;
        if ("html".equals(this.k.getMarkupType())) {
            relativeLayout.setBackgroundColor(0);
            final RelativeLayout.LayoutParams layoutParams;
            (layoutParams = new RelativeLayout.LayoutParams(-1, -1)).addRule(10);
            final RelativeLayout.LayoutParams layoutParams2;
            (layoutParams2 = new RelativeLayout.LayoutParams((int)(50.0f * c), (int)(50.0f * c))).addRule(11);
            (this.m = new cf((Context)this, c, (byte)0)).setId(65532);
            this.m.setOnClickListener((View.OnClickListener)new View.OnClickListener() {
                public final void onClick(final View view) {
                    InMobiAdActivity.this.a = true;
                    try {
                        InMobiAdActivity.this.k.b();
                    }
                    catch (Exception ex) {
                        InMobiAdActivity.g;
                        hf.a((byte)2, "InMobi", "SDK encountered unexpected error in processing close request");
                    }
                }
            });
            (this.n = new cf((Context)this, c, (byte)1)).setId(65531);
            this.n.setOnClickListener((View.OnClickListener)new View.OnClickListener() {
                public final void onClick(final View view) {
                    InMobiAdActivity.this.a = true;
                    try {
                        InMobiAdActivity.this.k.b();
                    }
                    catch (Exception ex) {
                        InMobiAdActivity.g;
                        hf.a((byte)2, "InMobi", "SDK encountered unexpected error in processing close request");
                    }
                }
            });
            final View c2;
            if ((c2 = this.k.getViewableAd().c()) != null) {
                final ViewGroup viewGroup;
                if ((viewGroup = (ViewGroup)c2.getParent()) != null) {
                    viewGroup.removeView(c2);
                }
                relativeLayout.addView(c2, (ViewGroup.LayoutParams)layoutParams);
                relativeLayout.addView((View)this.m, (ViewGroup.LayoutParams)layoutParams2);
                relativeLayout.addView((View)this.n, (ViewGroup.LayoutParams)layoutParams2);
                ((o)this.k).b(((o)this.k).o);
                ((o)this.k).c(((o)this.k).l);
            }
        }
        else {
            if (!"inmobiJson".equals(this.k.getMarkupType())) {
                if (this.k.getFullScreenEventsListener() != null) {
                    this.k.getFullScreenEventsListener().a();
                }
                this.finish();
                return;
            }
            final byte placementType = this.k.getPlacementType();
            relativeLayout.setBackgroundColor(-16777216);
            final bn bn;
            final Point a = (bn = (bn)this.k.getDataModel()).d.c.a;
            final dg viewableAd = this.k.getViewableAd();
            View view = null;
            if (bn.c) {
                view = viewableAd.b();
            }
            if (view == null) {
                view = viewableAd.a(null, (ViewGroup)relativeLayout, false);
            }
            final ey ey;
            if (this.k instanceof m && (ey = (ey)this.k.getVideoContainerView()) != null) {
                (this.o = ey.getVideoView()).requestFocus();
                final bw bw;
                if ((bw = (bw)this.o.getTag()).y != null) {
                    final bw bw2 = bw;
                    bw2.a((bw)bw2.y);
                }
                if (placementType == 0) {
                    bw.v.put("placementType", 0);
                }
                else {
                    bw.v.put("placementType", 1);
                }
            }
            if (view != null) {
                relativeLayout.addView(view, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(a.x, a.y));
            }
            this.k.d();
        }
        frameLayout.removeAllViews();
        frameLayout.addView((View)relativeLayout, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    }
    
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (InMobiAdActivity.b.remove(n) != null) {
            InMobiAdActivity.c.remove(n);
            this.a = true;
            this.finish();
        }
    }
    
    public void onMultiWindowModeChanged(final boolean b) {
        super.onMultiWindowModeChanged(b);
        if (!b) {
            if (this.l != null) {
                this.l.setOrientationProperties(this.l.getOrientationProperties());
            }
            if (this.k != null) {
                this.k.d();
            }
        }
    }
    
    public void onMultiWindowModeChanged(final boolean b, final Configuration configuration) {
        super.onMultiWindowModeChanged(b, configuration);
        this.onMultiWindowModeChanged(b);
    }
    
    public void onRequestPermissionsResult(final int i, @NonNull final String[] array, @NonNull final int[] array2) {
        super.onRequestPermissionsResult(i, array, array2);
        hc.c();
        InMobiAdActivity.e.remove(i);
        this.finish();
    }
    
    public void onBackPressed() {
        if (this.p == 102) {
            if (this.k == null || this.k.c()) {
                return;
            }
            if (200 == this.q) {
                final o o;
                if ((o = (o)this.k) != null) {
                    final o o2;
                    if ((o2 = o).q != null) {
                        final o o3 = o2;
                        o3.a(o3.q, "broadcastEvent('backButtonPressed')");
                    }
                    if (o.p) {
                        return;
                    }
                    this.a = true;
                    try {
                        o.b();
                    }
                    catch (Exception ex2) {
                        hf.a((byte)2, "InMobi", "SDK encountered unexpected error in processing close request");
                    }
                }
                return;
            }
            if (this.k instanceof m) {
                final m m;
                if ((m = (m)this.k) != null) {
                    if (m.k().b) {
                        return;
                    }
                    this.a = true;
                    if (this.o != null) {
                        final bw bw;
                        if ((bw = (bw)this.o.getTag()) != null) {
                            if (1 == m.getPlacementType()) {
                                this.o.e();
                            }
                            try {
                                if (bw.v.get("isFullScreen")) {
                                    bw.v.put("seekPosition", this.o.getCurrentPosition());
                                    final m i = m;
                                    final bw bw2 = bw;
                                    final m j = i;
                                    if (!i.j && (boolean)bw2.v.get("didRequestFullScreen")) {
                                        bw2.v.put("didRequestFullScreen", Boolean.FALSE);
                                        if (bw2.y != null) {
                                            bw2.y.v.put("didRequestFullScreen", Boolean.FALSE);
                                        }
                                        j.b();
                                        bw2.v.put("isFullScreen", Boolean.FALSE);
                                    }
                                }
                            }
                            catch (Exception ex) {
                                hf.a((byte)2, "InMobi", "SDK encountered unexpected error in closing video");
                                fv.a().a(new gv(ex));
                            }
                        }
                        return;
                    }
                    this.finish();
                }
                return;
            }
            if (this.k instanceof l) {
                final l l;
                if ((l = (l)this.k) == null) {
                    this.finish();
                    return;
                }
                if (l.k().b) {
                    return;
                }
                l.b();
            }
        }
        else if (this.p == 100) {
            this.a = true;
            this.finish();
        }
    }
    
    static {
        g = InMobiAdActivity.class.getSimpleName();
        InMobiAdActivity.h = (SparseArray<h>)new SparseArray();
        InMobiAdActivity.b = new HashMap<Integer, a>();
        InMobiAdActivity.c = new HashMap<Integer, Intent>();
        InMobiAdActivity.d = 0;
        InMobiAdActivity.e = new HashMap<Integer, Object>();
        InMobiAdActivity.f = 0;
    }
    
    public interface a
    {
    }
}
