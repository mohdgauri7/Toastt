// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.annotation.TargetApi;
import androidx.annotation.NonNull;
import android.media.AudioManager;
import android.database.ContentObserver;
import android.provider.Settings$System;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import java.util.UUID;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import androidx.annotation.WorkerThread;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import android.view.ViewTreeObserver;
import org.json.JSONException;
import java.util.Locale;
import android.widget.MediaController;
import android.os.Build$VERSION;
import android.media.MediaPlayer$OnErrorListener;
import android.media.MediaPlayer$OnPreparedListener;
import android.media.MediaPlayer$OnCompletionListener;
import android.view.View$OnKeyListener;
import android.view.KeyEvent;
import android.view.View$OnTouchListener;
import android.view.MotionEvent;
import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout$LayoutParams;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.app.Activity;
import android.os.Looper;
import android.content.Intent;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout;
import com.inmobi.ads.rendering.InMobiAdActivity;
import java.util.Set;
import android.view.View;
import android.view.ViewGroup;
import org.json.JSONObject;
import android.os.Build;
import android.webkit.URLUtil;
import android.os.Handler;
import android.webkit.JavascriptInterface;

public class cg
{
    private static final String a;
    private final o b;
    private final int c;
    private cn d;
    
    public cg(final o b, final int c) {
        this.b = b;
        this.c = c;
    }
    
    @JavascriptInterface
    public void open(final String s, final String s2) {
        if (this.b == null) {
            return;
        }
        if (!this.b.k()) {
            this.b.d("open");
            return;
        }
        this.b.n();
        iu.a().a(new Runnable() {
            @Override
            public final void run() {
                cg.this.b.getLandingPageHandler().a("open", s, s2);
            }
        });
    }
    
    @JavascriptInterface
    public void openWithoutTracker(final String s, final String s2) {
        if (this.b == null) {
            return;
        }
        if (!this.b.k()) {
            this.b.d("openWithoutTracker");
            return;
        }
        iu.a().a(new Runnable() {
            @Override
            public final void run() {
                cg.this.b.getLandingPageHandler().a("openWithoutTracker", s, s2);
            }
        });
    }
    
    @JavascriptInterface
    public void openEmbedded(final String s, final String s2) {
        if (this.b == null) {
            return;
        }
        if (!this.b.k()) {
            this.b.d("openEmbedded");
            return;
        }
        this.b.n();
        new Handler(this.b.getContainerContext().getMainLooper()).post((Runnable)new Runnable() {
            @Override
            public final void run() {
                try {
                    cg.this.b.getLandingPageHandler().b("openEmbedded", s, s2);
                }
                catch (Exception ex) {
                    cg.this.b.b(s, "Unexpected error", "openEmbedded");
                    hf.a((byte)1, "InMobi", "Failed to open URL; SDK encountered unexpected error");
                    cg.a;
                }
            }
        });
    }
    
    @JavascriptInterface
    public void ping(final String s, final String obj, final boolean b) {
        if (this.b == null) {
            return;
        }
        if (obj == null || obj.trim().length() == 0 || !URLUtil.isValidUrl(obj)) {
            this.b.b(s, "Invalid URL:".concat(String.valueOf(obj)), "ping");
            return;
        }
        try {
            ba.a().a(obj, b);
        }
        catch (Exception ex) {
            this.b.b(s, "Unexpected error", "ping");
            hf.a((byte)1, "InMobi", "Failed to fire ping; SDK encountered unexpected error");
        }
    }
    
    @JavascriptInterface
    public void pingInWebView(final String s, final String obj, final boolean b) {
        if (this.b == null) {
            return;
        }
        if (obj == null || obj.trim().length() == 0 || !URLUtil.isValidUrl(obj)) {
            this.b.b(s, "Invalid URL:".concat(String.valueOf(obj)), "pingInWebView");
            return;
        }
        try {
            ba.a().b(obj, b);
        }
        catch (Exception ex) {
            this.b.b(s, "Unexpected error", "pingInWebView");
            hf.a((byte)1, "InMobi", "Failed to fire ping; SDK encountered unexpected error");
        }
    }
    
    @JavascriptInterface
    public void log(final String s, final String s2) {
    }
    
    @JavascriptInterface
    public String getPlatformVersion(final String s) {
        return Integer.toString(Build.VERSION.SDK_INT);
    }
    
    @JavascriptInterface
    public String getPlatform(final String s) {
        ha.d();
        return ha.d();
    }
    
    @JavascriptInterface
    public void fireAdReady(final String s) {
        try {
            final o b;
            (b = this.b).y = true;
            if (b.getImpressionType() == 0) {
                b.j();
            }
            b.getListener().c(b);
        }
        catch (Exception ex) {
            this.b.b(s, "Unexpected error", "fireAdReady");
        }
    }
    
    @JavascriptInterface
    public void fireAdFailed(final String s) {
        try {
            this.b.getListener().d(this.b);
        }
        catch (Exception ex) {
            this.b.b(s, "Unexpected error", "fireAdFailed");
        }
    }
    
    @JavascriptInterface
    public String getDefaultPosition(final String s) {
        if (this.b == null) {
            return new JSONObject().toString();
        }
        synchronized (this.b.getDefaultPositionMonitor()) {
            this.b.j = true;
            new Handler(this.b.getContainerContext().getMainLooper()).post((Runnable)new Runnable() {
                @Override
                public final void run() {
                    try {
                        cg.this.b.g();
                    }
                    catch (Exception ex) {
                        cg.a;
                    }
                }
            });
            while (this.b.j) {
                try {
                    this.b.getDefaultPositionMonitor().wait();
                }
                catch (InterruptedException ex) {}
            }
        }
        return this.b.getDefaultPosition();
    }
    
    @JavascriptInterface
    public String getCurrentPosition(final String s) {
        if (this.b == null) {
            return "";
        }
        synchronized (this.b.getCurrentPositionMonitor()) {
            this.b.k = true;
            new Handler(this.b.getContainerContext().getMainLooper()).post((Runnable)new Runnable() {
                @Override
                public final void run() {
                    try {
                        cg.this.b.h();
                    }
                    catch (Exception ex) {
                        cg.a;
                    }
                }
            });
            while (this.b.k) {
                try {
                    this.b.getCurrentPositionMonitor().wait();
                }
                catch (InterruptedException ex) {}
            }
        }
        return this.b.getCurrentPosition();
    }
    
    @JavascriptInterface
    public void setExpandProperties(final String s, final String s2) {
        if (this.b == null) {
            return;
        }
        if ("Expanded".equals(this.b.getState())) {
            return;
        }
        try {
            this.b.setExpandProperties(ch.a(s2));
        }
        catch (Exception ex) {
            this.b.b(s, "Unexpected error", "setExpandProperties");
        }
    }
    
    @JavascriptInterface
    public String getExpandProperties(final String s) {
        if (this.b == null) {
            return "";
        }
        return this.b.getExpandProperties().c;
    }
    
    @JavascriptInterface
    public void expand(final String s, final String s2) {
        if (this.c != 1) {
            if (this.b == null) {
                return;
            }
            if (!this.b.k()) {
                this.b.d("expand");
                return;
            }
            if (this.b.n) {
                if (s2 != null && 0 != s2.length() && !s2.startsWith("http")) {
                    this.b.b(s, "Invalid URL", "expand");
                    return;
                }
                if (URLUtil.isValidUrl(s2)) {
                    this.b.n();
                }
                new Handler(this.b.getContainerContext().getMainLooper()).post((Runnable)new Runnable() {
                    @Override
                    public final void run() {
                        try {
                            final o a = cg.this.b;
                            final String b = s2;
                            final o o = a;
                            if ("Default".equals(o.d) || "Resized".equals(o.d)) {
                                o.s = true;
                                final cj f = o.f;
                                final String s = b;
                                final cj cj = f;
                                if (f.c == null) {
                                    final cj cj2 = cj;
                                    cj2.c = (ViewGroup)cj2.a.getParent();
                                    final cj cj3 = cj;
                                    cj3.d = cj3.c.indexOfChild((View)cj.a);
                                }
                                final ch expandProperties = cj.a.getExpandProperties();
                                cj.b = URLUtil.isValidUrl(s);
                                final o a2 = cj.a;
                                Label_0434: {
                                    int n = 0;
                                    Label_0361: {
                                        if (cj.b) {
                                            try {
                                                final o o2;
                                                (o2 = new o(cj.a.getContainerContext(), (byte)0, null, cj.a.getImpressionId())).a(cj.a.getListener(), cj.a.getAdConfig(), false, false);
                                                o2.setOriginalRenderView(cj.a);
                                                o2.loadUrl(s);
                                                o2.setPlacementId(cj.a.getPlacementId());
                                                o2.setAllowAutoRedirection(cj.a.getAllowAutoRedirection());
                                                o2.setCreativeId(cj.a.getCreativeId());
                                                n = InMobiAdActivity.a((h)o2);
                                                if (expandProperties != null) {
                                                    o2.setUseCustomClose(cj.a.l);
                                                }
                                                break Label_0361;
                                            }
                                            catch (Exception ex) {
                                                fv.a().a(new gv(ex));
                                                cj.a.getListener().g(cj.a);
                                                break Label_0434;
                                            }
                                        }
                                        a2.setShouldFireRenderBeacon(false);
                                        final cj cj4 = cj;
                                        final ViewGroup c = cj4.c;
                                        final cj cj5 = cj4;
                                        final FrameLayout frameLayout = new FrameLayout(cj5.a.getContainerContext());
                                        final ViewGroup$LayoutParams viewGroup$LayoutParams = new ViewGroup$LayoutParams(cj5.a.getWidth(), cj5.a.getHeight());
                                        frameLayout.setId(65535);
                                        c.addView((View)frameLayout, cj5.d, viewGroup$LayoutParams);
                                        c.removeView((View)cj5.a);
                                        n = InMobiAdActivity.a((h)cj.a);
                                    }
                                    cj.a.getListener().d_();
                                    final Intent intent;
                                    (intent = new Intent(cj.a.getContainerContext(), (Class)InMobiAdActivity.class)).putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 102);
                                    intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_INDEX", n);
                                    intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_TYPE", 200);
                                    gz.a(cj.a.getContainerContext(), intent);
                                }
                                o.requestLayout();
                                o.invalidate();
                                o.setFocusable(o.m = true);
                                o.setFocusableInTouchMode(true);
                                o.requestFocus();
                            }
                        }
                        catch (Exception ex2) {
                            cg.this.b.b(s, "Unexpected error", "expand");
                            hf.a((byte)1, "InMobi", "Failed to expand ad; SDK encountered an unexpected error");
                            cg.a;
                        }
                    }
                });
            }
            else {
                this.b.b(s, "Creative is not visible. Ignoring request.", "expand");
            }
        }
    }
    
    @JavascriptInterface
    public String getVersion(final String s) {
        ha.c();
        return ha.c();
    }
    
    @JavascriptInterface
    public void setResizeProperties(final String s, final String s2) {
        if (this.b == null) {
            return;
        }
        final co a;
        if ((a = co.a(s2, this.b.getResizeProperties())) == null) {
            this.b.b(s, "setResizeProperties", "All mandatory fields are not present");
        }
        this.b.setResizeProperties(a);
    }
    
    @JavascriptInterface
    public String getResizeProperties(final String s) {
        if (this.b == null) {
            return "";
        }
        final co resizeProperties;
        if ((resizeProperties = this.b.getResizeProperties()) == null) {
            return "";
        }
        final JSONObject a;
        if ((a = new hv<co>().a(resizeProperties)) == null) {
            return "";
        }
        return a.toString();
    }
    
    @JavascriptInterface
    public void resize(final String s) {
        if (this.c != 1) {
            if (this.b == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
                @Override
                public final void run() {
                    try {
                        final o a = cg.this.b;
                        if (("Default".equals(a.d) || "Resized".equals(a.d)) && a.getResizeProperties() != null) {
                            a.s = true;
                            a.g.a();
                            a.requestLayout();
                            a.invalidate();
                            a.setFocusable(a.m = true);
                            a.setFocusableInTouchMode(true);
                            a.requestFocus();
                            a.setAndUpdateViewState("Resized");
                            a.getListener().a_(a);
                            a.s = false;
                        }
                    }
                    catch (Exception ex) {
                        cg.this.b.b(s, "Unexpected error", "resize");
                        hf.a((byte)1, cg.a, "Could not resize ad; SDK encountered an unexpected error");
                        cg.a;
                    }
                }
            });
        }
    }
    
    @JavascriptInterface
    public void setOrientationProperties(final String s, final String s2) {
        this.d = cn.a(s2, this.b.getOrientationProperties());
        this.b.setOrientationProperties(this.d);
    }
    
    @JavascriptInterface
    public String getOrientationProperties(final String s) {
        return this.d.d;
    }
    
    @JavascriptInterface
    public void onOrientationChange(final String s) {
    }
    
    @JavascriptInterface
    public boolean isViewable(final String s) {
        return this.b != null && this.b.n;
    }
    
    @JavascriptInterface
    public void useCustomClose(final String s, final boolean b) {
        new Handler(this.b.getContainerContext().getMainLooper()).post((Runnable)new Runnable() {
            @Override
            public final void run() {
                try {
                    cg.this.b.c(b);
                }
                catch (Exception ex) {
                    cg.this.b.b(s, "Unexpected error", "useCustomClose");
                    cg.a;
                }
            }
        });
    }
    
    @JavascriptInterface
    public void playVideo(final String s, final String s2) {
        if (this.b == null) {
            return;
        }
        if (s2 == null || 0 == s2.trim().length() || !s2.startsWith("http") || (!s2.endsWith("mp4") && !s2.endsWith("avi") && !s2.endsWith("m4v"))) {
            this.b.b(s, "Null or empty or invalid media playback URL supplied", "playVideo");
            return;
        }
        new Handler(this.b.getContainerContext().getMainLooper()).post((Runnable)new Runnable() {
            @Override
            public final void run() {
                try {
                    final o a = cg.this.b;
                    final String a2 = s;
                    final String trim = s2.trim();
                    final String s = a2;
                    final o o = a;
                    if (1 == o.e || "Expanded".equals(o.getViewState())) {
                        if (o.b == null || o.b.get() == null) {
                            o.b(s, "Media playback is  not allowed before it is visible! Ignoring request ...", "playVideo");
                            return;
                        }
                        o.setAdActiveFlag(true);
                        final cl h = o.h;
                        final String s2 = trim;
                        final Activity activity = o.b.get();
                        final String s3 = s2;
                        final cl cl = h;
                        h.b = new ci(activity);
                        final ci b = cl.b;
                        final String s4 = s3;
                        final ci ci = b;
                        b.h = com.inmobi.media.ci.a(s4);
                        ci.g = "anonymous";
                        if (ci.b == null) {
                            ci.b = Bitmap.createBitmap(24, 24, Bitmap$Config.ARGB_8888);
                            final ci ci2 = ci;
                            ci2.b = com.inmobi.media.ci.b(ci2.h);
                        }
                        final ViewGroup viewGroup = (ViewGroup)activity.findViewById(16908290);
                        final RelativeLayout$LayoutParams layoutParams;
                        (layoutParams = new RelativeLayout$LayoutParams(-1, -1)).addRule(13);
                        cl.b.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                        final RelativeLayout c;
                        (c = new RelativeLayout((Context)activity)).setOnTouchListener((View$OnTouchListener)new View.OnTouchListener() {
                            public final boolean onTouch(final View view, final MotionEvent motionEvent) {
                                return true;
                            }
                        });
                        c.setBackgroundColor(-16777216);
                        c.addView((View)cl.b);
                        viewGroup.addView((View)c, new ViewGroup$LayoutParams(-1, -1));
                        cl.b.c = (ViewGroup)c;
                        cl.b.requestFocus();
                        cl.b.setOnKeyListener((View$OnKeyListener)new View.OnKeyListener() {
                            public final boolean onKey(final View view, final int n, final KeyEvent keyEvent) {
                                if (4 == n && 0 == keyEvent.getAction()) {
                                    cl.a(cl).a();
                                    return true;
                                }
                                return false;
                            }
                        });
                        cl.b.d = new ci.b() {
                            @Override
                            public final void a(final ci ci) {
                                cl.f();
                                cl.b(cl).setAdActiveFlag(false);
                                final ViewGroup c;
                                if ((c = ci.c) != null) {
                                    ((ViewGroup)c.getParent()).removeView((View)c);
                                }
                                ci.c = null;
                            }
                            
                            @Override
                            public final void a() {
                                cl.f();
                            }
                        };
                        final ci b2;
                        final ci ci3 = b2 = cl.b;
                        ci3.setVideoPath(ci3.h);
                        final ci onCompletionListener = b2;
                        onCompletionListener.setOnCompletionListener((MediaPlayer$OnCompletionListener)onCompletionListener);
                        final ci onPreparedListener = b2;
                        onPreparedListener.setOnPreparedListener((MediaPlayer$OnPreparedListener)onPreparedListener);
                        final ci onErrorListener = b2;
                        onErrorListener.setOnErrorListener((MediaPlayer$OnErrorListener)onErrorListener);
                        if (b2.a == null && Build$VERSION.SDK_INT >= 19) {
                            (b2.a = new ci.a(b2.getContext())).setAnchorView((View)b2);
                            final ci ci4 = b2;
                            ci4.setMediaController((MediaController)ci4.a);
                        }
                    }
                }
                catch (Exception ex) {
                    cg.this.b.b(s, "Unexpected error", "playVideo");
                    hf.a((byte)1, "InMobi", "Error playing video; SDK encountered an unexpected error");
                    cg.a;
                }
            }
        });
    }
    
    @JavascriptInterface
    public String getState(final String s) {
        return this.b.getState().toLowerCase(Locale.ENGLISH);
    }
    
    @JavascriptInterface
    public String getScreenSize(final String s) {
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("width", ho.a().a);
            jsonObject.put("height", ho.a().b);
        }
        catch (JSONException ex) {}
        catch (Exception ex2) {
            this.b.b(s, "Unexpected error", "getScreenSize");
        }
        return jsonObject.toString();
    }
    
    @JavascriptInterface
    public String getMaxSize(final String s) {
        final JSONObject jsonObject = new JSONObject();
        try {
            Activity fullScreenActivity;
            if ((fullScreenActivity = this.b.getFullScreenActivity()) == null) {
                if (!(this.b.getContainerContext() instanceof Activity)) {
                    return this.getScreenSize(s);
                }
                fullScreenActivity = (Activity)this.b.getContainerContext();
            }
            final FrameLayout frameLayout;
            final int b = ho.b((frameLayout = (FrameLayout)fullScreenActivity.findViewById(16908290)).getWidth());
            int n = ho.b(frameLayout.getHeight());
            if (this.b.getFullScreenActivity() != null && (b == 0 || n == 0)) {
                final a a = new a((View)frameLayout);
                frameLayout.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)a);
                synchronized (a.d) {
                    try {
                        a.d.wait();
                    }
                    catch (InterruptedException ex) {}
                    a.a;
                    n = a.b;
                }
            }
            try {
                jsonObject.put("width", b);
                jsonObject.put("height", n);
            }
            catch (JSONException ex2) {}
        }
        catch (Exception ex3) {
            this.b.b(s, "Unexpected error", "getMaxSize");
        }
        return jsonObject.toString();
    }
    
    @JavascriptInterface
    public void close(final String s) {
        new Handler(this.b.getContainerContext().getMainLooper()).post((Runnable)new Runnable() {
            @Override
            public final void run() {
                try {
                    cg.this.b.getReferenceContainer().b();
                }
                catch (Exception ex) {
                    cg.this.b.b(s, "Unexpected error", "close");
                    hf.a((byte)1, "InMobi", "Failed to close ad; SDK encountered an unexpected error");
                    cg.a;
                }
            }
        });
    }
    
    @JavascriptInterface
    public String getPlacementType(final String s) {
        if (1 == this.c) {
            return "interstitial";
        }
        return "inline";
    }
    
    @JavascriptInterface
    public void storePicture(final String s, final String s2) {
    }
    
    @JavascriptInterface
    public String getSdkVersion(final String s) {
        ha.b();
        return ha.b();
    }
    
    @JavascriptInterface
    public String supports(final String s, final String s2) {
        return String.valueOf(this.b.f(s2));
    }
    
    @JavascriptInterface
    public void openExternal(final String s, String s2, @Nullable String s3) {
        if (this.b == null) {
            return;
        }
        if (!this.b.k()) {
            this.b.d("openExternal");
            return;
        }
        this.b.n();
        final k landingPageHandler = this.b.getLandingPageHandler();
        final String s4 = "openExternal";
        final String s5 = s2;
        final String s6 = s3;
        final String s7 = s5;
        s3 = s;
        s2 = s4;
        final k k = landingPageHandler;
        if (s7 != null) {
            k.a(s2, s3, s7, s6);
            return;
        }
        if (s6 != null) {
            k.a(s2, s3, s6, null);
            return;
        }
        k.a.b(s3, "Empty url and fallback url", "openExternal");
    }
    
    @JavascriptInterface
    public void asyncPing(final String s, final String s2) {
        if (!URLUtil.isValidUrl(s2)) {
            this.b.b(s, "Invalid url", "asyncPing");
            return;
        }
        try {
            final gm gm;
            (gm = new gm("GET", s2)).w = false;
            gm.q = false;
            new Thread(new Runnable() {
                final /* synthetic */ gg a = new gg(gm, new gg.a(this, gm, SystemClock.elapsedRealtime()) {
                    final /* synthetic */ gm a;
                    final /* synthetic */ long b;
                    
                    @Override
                    public final void a(final gn gn) {
                        cg.a;
                        try {
                            ih.a().a(this.a.h());
                            ih.a().b(gn.d());
                            ih.a().c(SystemClock.elapsedRealtime() - this.b);
                        }
                        catch (Exception ex) {
                            cg.a;
                        }
                    }
                    
                    @Override
                    public final void a() {
                        cg.a;
                    }
                });
                
                @WorkerThread
                @Override
                public final void run() {
                    try {
                        final gn a;
                        if ((a = new gk(gg.a(this.a)).a()).a()) {
                            gg.b(this.a).a();
                            return;
                        }
                        gg.b(this.a).a(a);
                    }
                    catch (Exception ex) {
                        gg.a();
                        new gn().a = new gl(-1, "Network request failed with unknown error");
                        gg.b(this.a).a();
                    }
                }
            }).start();
        }
        catch (Exception ex) {
            this.b.b(s, "Unexpected error", "asyncPing");
        }
    }
    
    @JavascriptInterface
    public void showAlert(final String s, final String s2) {
    }
    
    @JavascriptInterface
    public void disableCloseRegion(final String s, final boolean b) {
        if (this.b == null) {
            return;
        }
        new Handler(this.b.getContainerContext().getMainLooper()).post((Runnable)new Runnable() {
            @Override
            public final void run() {
                try {
                    cg.this.b.b(b);
                }
                catch (Exception ex) {
                    cg.this.b.b(s, "Unexpected error", "disableCloseRegion");
                    cg.a;
                }
            }
        });
    }
    
    @JavascriptInterface
    public void onUserInteraction(final String s, final String s2) {
        if (this.b != null && !this.b.k()) {
            this.b.d("onUserInteraction");
            return;
        }
        if (s2 == null) {
            try {
                this.b.getListener().a(new HashMap<Object, Object>());
                return;
            }
            catch (Exception ex) {
                this.b.b(s, "Unexpected error", "onUserInteraction");
                return;
            }
        }
        try {
            final JSONObject jsonObject = new JSONObject(s2);
            final HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            final Iterator keys = jsonObject.keys();
            while (keys.hasNext()) {
                final String key = keys.next();
                hashMap.put(key, jsonObject.get(key));
            }
            try {
                this.b.getListener().a(hashMap);
            }
            catch (Exception ex2) {
                this.b.b(s, "Unexpected error", "onUserInteraction");
            }
        }
        catch (JSONException ex3) {
            try {
                this.b.getListener().a(new HashMap<Object, Object>());
            }
            catch (Exception ex4) {
                this.b.b(s, "Unexpected error", "onUserInteraction");
            }
        }
    }
    
    @JavascriptInterface
    public void incentCompleted(final String s, final String s2) {
        if (s2 == null) {
            try {
                this.b.getListener().b(new HashMap<Object, Object>());
                return;
            }
            catch (Exception ex) {
                this.b.b(s, "Unexpected error", "incentCompleted");
                return;
            }
        }
        try {
            final JSONObject jsonObject = new JSONObject(s2);
            final HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            final Iterator keys = jsonObject.keys();
            while (keys.hasNext()) {
                final String key = keys.next();
                hashMap.put(key, jsonObject.get(key));
            }
            try {
                this.b.getListener().b(hashMap);
            }
            catch (Exception ex2) {
                this.b.b(s, "Unexpected error", "incentCompleted");
            }
        }
        catch (JSONException ex3) {
            try {
                this.b.getListener().b(new HashMap<Object, Object>());
            }
            catch (Exception ex4) {
                this.b.b(s, "Unexpected error", "incentCompleted");
            }
        }
    }
    
    @JavascriptInterface
    public String getOrientation(final String s) {
        final byte b;
        if ((b = ho.b()) == 1) {
            return "0";
        }
        if (b == 3) {
            return "90";
        }
        if (b == 2) {
            return "180";
        }
        if (b == 4) {
            return "270";
        }
        return "-1";
    }
    
    @JavascriptInterface
    public void saveContent(final String s, String string, String replace) {
        if (string == null || 0 == ((String)string).length() || replace == null || 0 == replace.length()) {
            final JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("url", (Object)((replace == null) ? "" : replace));
                jsonObject.put("reason", 8);
            }
            catch (JSONException ex) {}
            replace = jsonObject.toString().replace("\"", "\\\"");
            string = "sendSaveContentResult(\"saveContent_" + (String)((string == null) ? "" : string) + "\", 'failed', \"" + replace + "\");";
            this.b.a(s, (String)string);
            return;
        }
        try {
            final o b = this.b;
            final Object o = string;
            final String s2 = replace;
            final String str = (String)o;
            replace = s;
            string = b;
            if (!b.f("saveContent")) {
                final JSONObject jsonObject2 = new JSONObject();
                try {
                    jsonObject2.put("url", (Object)s2);
                    jsonObject2.put("reason", 7);
                }
                catch (JSONException ex2) {}
                ((o)string).a(replace, "sendSaveContentResult(\"saveContent_" + str + "\", 'failed', \"" + jsonObject2.toString().replace("\"", "\\\"") + "\");");
                return;
            }
            final HashSet<bd> set = new HashSet<bd>();
            set.add(new bd((byte)(-1), s2));
            final am am;
            (am = new am(UUID.randomUUID().toString(), set, ((o)string).A, str)).f = replace;
            final aw a = aw.a();
            a.a.execute(new Runnable() {
                @Override
                public final void run() {
                    aw.a(a, am);
                    aw.e();
                    am.b.size();
                    final Iterator<bd> iterator = am.b.iterator();
                    while (iterator.hasNext()) {
                        aw.b(a, iterator.next().b);
                    }
                }
            });
        }
        catch (Exception ex3) {
            this.b.b(s, "Unexpected error", "saveContent");
        }
    }
    
    @JavascriptInterface
    public void cancelSaveContent(final String s, final String s2) {
    }
    
    @JavascriptInterface
    public String isDeviceMuted(String a) {
        if (this.b == null) {
            return "false";
        }
        a = (String)0;
        try {
            this.b.getMediaProcessor();
            a = (String)cl.a();
        }
        catch (Exception ex) {}
        return String.valueOf((boolean)a);
    }
    
    @JavascriptInterface
    public String isHeadphonePlugged(String d) {
        if (this.b == null) {
            return "false";
        }
        d = (String)0;
        try {
            this.b.getMediaProcessor();
            d = (String)cl.d();
        }
        catch (Exception ex) {}
        return String.valueOf((boolean)d);
    }
    
    @JavascriptInterface
    public void registerDeviceMuteEventListener(final String s) {
        if (this.b == null) {
            return;
        }
        try {
            final cl mediaProcessor = this.b.getMediaProcessor();
            final Context c;
            if ((c = gz.c()) != null) {
                if (mediaProcessor.c == null) {
                    c.registerReceiver((BroadcastReceiver)(mediaProcessor.c = mediaProcessor.new b(s)), new IntentFilter("android.media.RINGER_MODE_CHANGED"));
                }
            }
        }
        catch (Exception ex) {
            this.b.b(s, "Unexpected error", "registerDeviceMuteEventListener");
        }
    }
    
    @JavascriptInterface
    public void unregisterDeviceMuteEventListener(final String s) {
        if (this.b == null) {
            return;
        }
        try {
            this.b.getMediaProcessor().b();
        }
        catch (Exception ex) {
            this.b.b(s, "Unexpected error", "unRegisterDeviceMuteEventListener");
        }
    }
    
    @JavascriptInterface
    public void registerDeviceVolumeChangeEventListener(final String s) {
        if (this.b == null) {
            return;
        }
        try {
            final cl mediaProcessor = this.b.getMediaProcessor();
            final Context c;
            if ((c = gz.c()) != null) {
                if (mediaProcessor.d == null) {
                    mediaProcessor.d = mediaProcessor.new c(s, c, new Handler());
                    c.getContentResolver().registerContentObserver(Settings$System.CONTENT_URI, true, (ContentObserver)mediaProcessor.d);
                }
            }
        }
        catch (Exception ex) {
            this.b.b(s, "Unexpected error", "registerDeviceVolumeChangeEventListener");
        }
    }
    
    @JavascriptInterface
    public void unregisterDeviceVolumeChangeEventListener(final String s) {
        if (this.b == null) {
            return;
        }
        try {
            this.b.getMediaProcessor().c();
        }
        catch (Exception ex) {
            this.b.b(s, "Unexpected error", "unregisterDeviceVolumeChangeEventListener");
        }
    }
    
    @JavascriptInterface
    public int getDeviceVolume(final String s) {
        if (this.b == null) {
            return -1;
        }
        try {
            final cl mediaProcessor = this.b.getMediaProcessor();
            final Context c;
            if ((c = gz.c()) == null) {
                return -1;
            }
            if (mediaProcessor.a.getRenderingConfig().enablePubMuteControl && gz.e()) {
                return 0;
            }
            final AudioManager audioManager;
            if ((audioManager = (AudioManager)c.getSystemService("audio")) == null) {
                return -1;
            }
            return audioManager.getStreamVolume(3);
        }
        catch (Exception ex) {
            this.b.b(s, "Unexpected error", "getDeviceVolume");
            return -1;
        }
    }
    
    @JavascriptInterface
    public void registerHeadphonePluggedEventListener(final String s) {
        if (this.b == null) {
            return;
        }
        try {
            final cl mediaProcessor = this.b.getMediaProcessor();
            final Context c;
            if ((c = gz.c()) != null) {
                if (mediaProcessor.e == null) {
                    c.registerReceiver((BroadcastReceiver)(mediaProcessor.e = mediaProcessor.new a(s)), new IntentFilter("android.intent.action.HEADSET_PLUG"));
                }
            }
        }
        catch (Exception ex) {
            this.b.b(s, "Unexpected error", "registerHeadphonePluggedEventListener");
        }
    }
    
    @JavascriptInterface
    public void unregisterHeadphonePluggedEventListener(final String s) {
        if (this.b == null) {
            return;
        }
        try {
            this.b.getMediaProcessor().e();
        }
        catch (Exception ex) {
            this.b.b(s, "Unexpected error", "unregisterHeadphonePluggedEventListener");
        }
    }
    
    @JavascriptInterface
    public void disableBackButton(final String s, final boolean disableBackButton) {
        if (this.b == null) {
            return;
        }
        this.b.setDisableBackButton(disableBackButton);
    }
    
    @JavascriptInterface
    public boolean isBackButtonDisabled(final String s) {
        return this.b != null && this.b.p;
    }
    
    @JavascriptInterface
    public void registerBackButtonPressedEventListener(final String q) {
        if (this.b == null) {
            return;
        }
        try {
            this.b.q = q;
        }
        catch (Exception ex) {
            this.b.b(q, "Unexpected error", "registerBackButtonPressedEventListener");
        }
    }
    
    @JavascriptInterface
    public void unregisterBackButtonPressedEventListener(final String s) {
        if (this.b == null) {
            return;
        }
        try {
            this.b.q = null;
        }
        catch (Exception ex) {
            this.b.b(s, "Unexpected error", "unregisterBackButtonPressedEventListener");
        }
    }
    
    @JavascriptInterface
    public void setCloseEndCardTracker(final String s, final String closeEndCardTracker) {
        if (this.b == null) {
            return;
        }
        try {
            this.b.setCloseEndCardTracker(closeEndCardTracker);
        }
        catch (Exception ex) {
            this.b.b(s, "Unexpected error", "getDownloadStatus");
        }
    }
    
    @JavascriptInterface
    public void fireSkip(final String s) {
    }
    
    @JavascriptInterface
    public void fireComplete(final String s) {
        if (this.b == null) {
            return;
        }
    }
    
    @JavascriptInterface
    public void showEndCard(final String s) {
        if (this.b == null) {
            return;
        }
        final h referenceContainer;
        if ((referenceContainer = this.b.getReferenceContainer()) instanceof l) {
            new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
                final /* synthetic */ l a = (l)referenceContainer;
                
                @Override
                public final void run() {
                    this.a.p = true;
                    this.a.c((bj)null);
                }
            });
        }
    }
    
    @JavascriptInterface
    public void saveBlob(final String s, final String s2) {
        if (this.b == null) {
            return;
        }
        final o b;
        if ((b = this.b).v != null) {
            b.v.a(s2, b.u);
        }
    }
    
    @JavascriptInterface
    public void getBlob(final String s, String s2) {
        if (this.b == null) {
            return;
        }
        final o b = this.b;
        final String s3 = s2;
        s2 = s;
        final o o = b;
        if (b.v != null) {
            final y v = o.v;
            final String s4 = s2;
            final String s5 = s3;
            final o o2 = o;
            v.a(s4, s5, o2, o2.u);
        }
    }
    
    @JavascriptInterface
    @NonNull
    public String getRenderableAdIndexes(final String s) {
        return this.b.getRenderableAdIndexes().toString();
    }
    
    @JavascriptInterface
    public int getCurrentRenderingIndex(final String s) {
        return this.b.getCurrentRenderingPodAdIndex();
    }
    
    @JavascriptInterface
    public void showAd(final String s, final int n) {
        final o b;
        if ((b = this.b).n && b.x != null) {
            b.x.b(n, b);
            return;
        }
        b.d(false);
    }
    
    @JavascriptInterface
    public long timeSinceShow(final String s) {
        final o b;
        if ((b = this.b).x != null) {
            return b.x.b_();
        }
        return 0L;
    }
    
    @JavascriptInterface
    public void closeAll(final String s) {
        final o b;
        if ((b = this.b).x != null) {
            b.x.b();
        }
    }
    
    @JavascriptInterface
    public void loadAd(final String s, final int n) {
        final o b;
        if ((b = this.b).n && b.x != null) {
            b.x.a(n, b);
            return;
        }
        b.a(false);
    }
    
    @JavascriptInterface
    public void setAdContext(final String s, final String s2) {
        final i adPodHandler;
        if ((adPodHandler = this.b.getAdPodHandler()) != null) {
            adPodHandler.a(s2);
        }
    }
    
    @JavascriptInterface
    @Nullable
    public String getAdContext(final String s) {
        final i adPodHandler;
        if ((adPodHandler = this.b.getAdPodHandler()) != null) {
            return adPodHandler.e();
        }
        return null;
    }
    
    @JavascriptInterface
    public long getShowTimeStamp(final String s) {
        return this.b.getShowTimeStamp();
    }
    
    static {
        a = cg.class.getSimpleName();
    }
    
    @TargetApi(16)
    static final class a implements ViewTreeObserver.OnGlobalLayoutListener
    {
        private int a;
        private int b;
        private View c;
        private final Boolean d;
        
        a(final View c) {
            this.d = Boolean.FALSE;
            this.c = c;
        }
        
        public final void onGlobalLayout() {
            try {
                this.a = ho.b(this.c.getWidth());
                this.b = ho.b(this.c.getHeight());
                if (Build.VERSION.SDK_INT >= 16) {
                    this.c.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
                }
                else {
                    this.c.getViewTreeObserver().removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
                }
                synchronized (this.d) {
                    this.d.notify();
                }
            }
            catch (Exception ex) {
                cg.a;
            }
        }
    }
}
