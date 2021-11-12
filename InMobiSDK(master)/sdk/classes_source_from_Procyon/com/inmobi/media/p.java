// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.webkit.RenderProcessGoneDetail;
import androidx.annotation.Nullable;
import android.webkit.WebResourceResponse;
import java.util.Map;
import java.util.HashMap;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebResourceError;
import android.annotation.TargetApi;
import android.content.Intent;
import android.view.View;
import android.graphics.Bitmap;
import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.List;
import android.webkit.WebViewClient;

final class p extends WebViewClient
{
    private static final String b;
    private List<String> c;
    private boolean d;
    short a;
    private boolean e;
    
    p() {
        this.c = new ArrayList<String>();
        this.d = false;
        this.a = -1;
    }
    
    final void a() {
        this.c.clear();
    }
    
    public final boolean shouldOverrideUrlLoading(final WebView webView, final WebResourceRequest webResourceRequest) {
        return Build.VERSION.SDK_INT >= 21 && a(webView, webResourceRequest.getUrl().toString());
    }
    
    public final boolean shouldOverrideUrlLoading(final WebView webView, final String s) {
        return a(webView, s);
    }
    
    private static boolean a(final WebView webView, final String anObject) {
        if (!(webView instanceof o)) {
            return false;
        }
        final o o;
        if ((o = (o)webView).i) {
            webView.loadUrl(anObject);
            return true;
        }
        if (!o.k() && !o.c && !"about:blank".equals(anObject)) {
            o.d("redirect");
            return true;
        }
        o.getPlacementType();
        if (1 == o.getPlacementType()) {
            return (!o.c || !hd.a(anObject)) && a(o, anObject);
        }
        return a(o, anObject);
    }
    
    private static boolean a(final o o, final String s) {
        if (!o.c) {
            o.n();
        }
        o.getLandingPageHandler().a(null, null, s);
        return true;
    }
    
    public final void onPageStarted(final WebView webView, final String s, final Bitmap bitmap) {
        if (webView instanceof o) {
            final o o = (o)webView;
            this.d = false;
            o.setAndUpdateViewState("Loading");
        }
    }
    
    public final void onPageFinished(final WebView webView, final String s) {
        if (webView instanceof o) {
            final o o = (o)webView;
            if (this.c.contains(s) && !this.d) {
                this.d = true;
                final o o2 = o;
                o2.e(o2.getMraidJsString());
            }
            if ("Loading".equals(o.getViewState())) {
                o.getListener().e(o);
                o.e("window.imaiview.broadcastEvent('ready');");
                o.e("window.mraidview.broadcastEvent('ready');");
                if (o.getImpressionType() == 2) {
                    o.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    o.layout(0, 0, o.getMeasuredWidth(), o.getMeasuredHeight());
                    o.setDrawingCacheEnabled(true);
                    o.buildDrawingCache();
                }
                o.setAndUpdateViewState((null == o.getOriginalRenderView()) ? "Default" : "Expanded");
            }
        }
    }
    
    public final void onLoadResource(final WebView webView, final String s) {
        if (s.matches("(.*)phpserver/db(.*)")) {
            final Intent intent;
            (intent = new Intent(gh.a.a.toString())).putExtra("url", s);
            gh.a(intent);
        }
        if (webView instanceof o) {
            final o o;
            final String url = (o = (o)webView).getUrl();
            if (s != null && url != null && s.contains("/mraid.js") && !"about:blank".equals(url) && !url.startsWith("file:")) {
                if (!this.c.contains(url)) {
                    this.c.add(url);
                }
                if (!this.d) {
                    this.d = true;
                    final o o2 = o;
                    o2.e(o2.getMraidJsString());
                }
            }
        }
    }
    
    @TargetApi(22)
    public final void onReceivedError(final WebView webView, final int n, final String s, final String s2) {
    }
    
    @TargetApi(23)
    public final void onReceivedError(final WebView webView, final WebResourceRequest webResourceRequest, final WebResourceError webResourceError) {
        new StringBuilder("Loading error. Error code:").append(webResourceError.getErrorCode()).append(" Error msg:").append((Object)webResourceError.getDescription()).append(" Failing url:").append(webResourceRequest.getUrl());
    }
    
    private void a(final WebView webView) {
        if (-1 != this.a) {
            if (this.a > 0) {
                --this.a;
                return;
            }
            if (!this.e) {
                new Handler(Looper.getMainLooper()).post((Runnable)new n(webView));
                this.e = true;
                if (webView instanceof o) {
                    final o o = (o)webView;
                    final HashMap<String, Object> hashMap;
                    (hashMap = new HashMap<String, Object>()).put("creativeId", o.t);
                    hashMap.put("impressionId", o.getImpressionId());
                    o.a("NetworkLoadLimitExceeded", hashMap);
                }
            }
        }
    }
    
    @Nullable
    public final WebResourceResponse shouldInterceptRequest(final WebView webView, final String s) {
        if (Build.VERSION.SDK_INT < 21) {
            this.a(webView);
        }
        return super.shouldInterceptRequest(webView, s);
    }
    
    @Nullable
    public final WebResourceResponse shouldInterceptRequest(final WebView webView, final WebResourceRequest webResourceRequest) {
        this.a(webView);
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }
    
    public final boolean onRenderProcessGone(final WebView webView, final RenderProcessGoneDetail renderProcessGoneDetail) {
        if (Build.VERSION.SDK_INT < 26 || !(webView instanceof o)) {
            return false;
        }
        hf.a((byte)1, p.b, "WebView crash detected, destroying ad");
        webView.destroy();
        return true;
    }
    
    static {
        b = p.class.getSimpleName();
    }
}
