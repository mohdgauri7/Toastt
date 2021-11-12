// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Iterator;
import android.content.ContentValues;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import android.os.SystemClock;
import java.util.HashMap;
import android.os.Build;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.Map;
import android.os.Message;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.List;
import android.os.HandlerThread;
import java.util.concurrent.ExecutorService;

public class ba implements fg.c
{
    private static final String a;
    private static ExecutorService b;
    private static b c;
    private static HandlerThread d;
    private static List<ay> e;
    private static az f;
    private static AtomicBoolean g;
    private static fe.e h;
    private static final Object i;
    private long j;
    private final e k;
    
    public static ba a() {
        return ba.a.a;
    }
    
    @Override
    public void a(final ff ff) {
        ba.h = ((fe)ff).imai;
    }
    
    public void b() {
        try {
            if (!hg.a()) {
                return;
            }
            synchronized (ba.i) {
                if (ba.g.compareAndSet(false, true)) {
                    if (ba.d == null) {
                        (ba.d = new HandlerThread("pingHandlerThread")).start();
                    }
                    if (ba.c == null) {
                        ba.c = new b(ba.d.getLooper());
                    }
                    if (az.a()) {
                        ba.g.set(false);
                        i();
                    }
                    else {
                        final Message obtain;
                        (obtain = Message.obtain()).what = 1;
                        ba.c.sendMessage(obtain);
                    }
                }
            }
        }
        catch (Exception ex) {}
    }
    
    public void a(final String s, final boolean b) {
        new Thread() {
            @Override
            public final void run() {
                try {
                    if (!((fs)fg.a("root", gz.f(), null)).i()) {
                        final ay ay = new ay(s, b, false, ba.h.maxRetries + 1);
                        ba.a;
                        ba.a(ba.this, ay);
                    }
                }
                catch (Exception ex) {
                    ba.a;
                }
            }
        }.start();
    }
    
    public void a(final String s, final Map<String, String> map, final boolean b) {
        new Thread() {
            @Override
            public final void run() {
                try {
                    if (!((fs)fg.a("root", gz.f(), null)).i()) {
                        final ay ay = new ay(s, map, b, ba.h.maxRetries + 1);
                        ba.a;
                        ba.a(ba.this, ay);
                    }
                }
                catch (Exception ex) {
                    ba.a;
                    fv.a().a(new gv(ex));
                }
            }
        }.start();
    }
    
    public void b(final String s, final boolean b) {
        new Thread() {
            @Override
            public final void run() {
                try {
                    if (!((fs)fg.a("root", gz.f(), null)).i()) {
                        final ay ay = new ay(s, b, true, ba.h.maxRetries + 1);
                        ba.a;
                        ba.a(ba.this, ay);
                    }
                }
                catch (Exception ex) {
                    ba.a;
                }
            }
        }.start();
    }
    
    private static void i() {
        try {
            ba.g.set(false);
            synchronized (ba.i) {
                if (!ba.g.get() && ba.d != null) {
                    ba.d.getLooper().quit();
                    ((Thread)ba.d).interrupt();
                    ba.d = null;
                    ba.c = null;
                }
            }
        }
        catch (Exception ex) {}
    }
    
    public ba() {
        this.j = 0L;
        this.k = new e() {
            @Override
            public final void a(final ay ay) {
                if (ay != null) {
                    ba.a;
                    ba.f;
                    az.a(ay);
                }
            }
            
            @Override
            public final void b(final ay ay) {
                if (ay != null) {
                    ba.a;
                    ba.a(ay);
                    ba.this.b();
                }
            }
        };
        try {
            final ThreadPoolExecutor b;
            (b = new ThreadPoolExecutor(5, 5, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new he(ba.a))).allowCoreThreadTimeOut(true);
            ba.b = b;
            (ba.d = new HandlerThread("pingHandlerThread")).start();
            ba.c = new b(ba.d.getLooper());
            ba.h = ((fe)fg.a("ads", gz.f(), this)).imai;
            ba.f = new az();
            hk.a().a(new hk.c() {
                @Override
                public final void a(final boolean b) {
                    if (b) {
                        ba.this.b();
                    }
                }
            });
            if (Build.VERSION.SDK_INT >= 23) {
                hk.a().a("android.os.action.DEVICE_IDLE_MODE_CHANGED", new hk.c() {
                    @Override
                    public final void a(final boolean b) {
                        if (!b) {
                            ba.this.b();
                        }
                    }
                });
            }
        }
        catch (Exception ex) {}
    }
    
    private static HashMap<String, String> c(final ay ay) {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        try {
            final int i;
            if ((i = ba.h.maxRetries - ay.f + 1) > 0) {
                hashMap.put("X-im-retry-count", String.valueOf(i));
            }
        }
        catch (Exception ex) {}
        return hashMap;
    }
    
    static /* synthetic */ void a(final ba ba, final ay ay) {
        ba.f.a(ay, ba.h.maxDbEvents);
        if (!hg.a()) {
            ba.g.set(false);
            i();
            return;
        }
        ba.b.submit(new Runnable() {
            @Override
            public final void run() {
                ba.this.j = SystemClock.elapsedRealtime();
                if (ay.h) {
                    new c(ba.this.k).a(ay);
                    return;
                }
                new d(ba.this.k).a(ay);
            }
        });
    }
    
    static /* synthetic */ void a(ay ay) {
        final ay ay2;
        if ((ay2 = ay).f > 0) {
            final ay ay3 = ay2;
            --ay3.f;
            ay2.d = System.currentTimeMillis();
            ay = ay2;
            final gt a = gt.a();
            a.b("click", az.b(ay), "id = ?", new String[] { String.valueOf(ay.a) });
            a.b();
        }
    }
    
    static {
        a = ba.class.getSimpleName();
        ba.e = new ArrayList<ay>();
        ba.g = new AtomicBoolean(false);
        i = new Object();
    }
    
    static final class a
    {
        static final ba a;
        
        static {
            a = new ba();
        }
    }
    
    static final class d
    {
        private e a;
        
        public d(final e a) {
            this.a = a;
        }
        
        public final void a(final ay ay) {
            try {
                final gm gm = new gm("GET", ay.b);
                final HashMap b;
                if (!(b = c(ay)).isEmpty()) {
                    gm.a(b);
                }
                gm.w = false;
                gm.q = false;
                gm.b(ay.c);
                gm.o = ay.i;
                gm.m = ba.h.pingTimeout * 1000;
                gm.n = ba.h.pingTimeout * 1000;
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                final gn a = new gp(gm).a();
                try {
                    ih.a().a(gm.h());
                    ih.a().b(a.d());
                    ih.a().c(SystemClock.elapsedRealtime() - elapsedRealtime);
                }
                catch (Exception ex) {
                    ba.a;
                }
                if (!a.a()) {
                    this.a.a(ay);
                    return;
                }
                final int a2 = a.a.a;
                if (-9 == a2) {
                    this.a.a(ay);
                    return;
                }
                if (!ay.i && (303 == a2 || 302 == a2)) {
                    this.a.a(ay);
                    return;
                }
                this.a.b(ay);
            }
            catch (Exception ex2) {
                ba.a;
                final e a3 = this.a;
                new gl(-1, "Unknown error");
                a3.b(ay);
            }
        }
    }
    
    static final class c
    {
        e a;
        
        public c(final e a) {
            this.a = a;
        }
        
        public final void a(final ay ay) {
            ay.g.set(false);
            final Handler handler = new Handler(Looper.getMainLooper());
            handler.post((Runnable)new Runnable() {
                @Override
                public final void run() {
                    final gm gm;
                    (gm = new gm("GET", ay.b)).w = false;
                    gm.q = false;
                    final HashMap b;
                    if (!(b = c(ay)).isEmpty()) {
                        gm.a(b);
                    }
                    final gr gr = new gr(gm, new WebViewClient() {
                        AtomicBoolean a = new AtomicBoolean(false);
                        boolean b;
                        boolean c;
                        
                        public final void onPageStarted(final WebView webView, final String s, final Bitmap bitmap) {
                            this.c = true;
                            this.b = false;
                            new Thread(new Runnable() {
                                @Override
                                public final void run() {
                                    try {
                                        Thread.sleep(ba.h.pingTimeout * 1000);
                                    }
                                    catch (InterruptedException ex) {}
                                    if (!WebViewClient.this.a.get()) {
                                        ba.a;
                                        ay.g.set(true);
                                        handler.post((Runnable)new Runnable() {
                                            @Override
                                            public final void run() {
                                                try {
                                                    final gr.a a;
                                                    if ((a = (gr.a)webView) != null && !a.a) {
                                                        webView.stopLoading();
                                                    }
                                                }
                                                catch (Throwable t) {
                                                    fv.a().a(new gv(t));
                                                }
                                            }
                                        });
                                        ba.c.this.a.b(ay);
                                    }
                                }
                            }).start();
                        }
                        
                        public final void onPageFinished(final WebView webView, final String s) {
                            this.a.set(true);
                            if (!this.b && !ay.g.get()) {
                                ba.c.this.a.a(ay);
                            }
                        }
                        
                        @TargetApi(22)
                        public final void onReceivedError(final WebView webView, final int n, final String s, final String s2) {
                            this.b = true;
                            ba.c.this.a.b(ay);
                        }
                        
                        @TargetApi(23)
                        public final void onReceivedError(final WebView webView, final WebResourceRequest webResourceRequest, final WebResourceError webResourceError) {
                            this.b = true;
                            ba.c.this.a.b(ay);
                        }
                        
                        @TargetApi(23)
                        public final void onReceivedHttpError(final WebView webView, final WebResourceRequest webResourceRequest, final WebResourceResponse webResourceResponse) {
                            this.b = true;
                            ba.c.this.a.b(ay);
                        }
                        
                        public final boolean shouldOverrideUrlLoading(final WebView webView, final WebResourceRequest webResourceRequest) {
                            return Build.VERSION.SDK_INT >= 21 && !ay.i && !webResourceRequest.getUrl().toString().equals(ay.b);
                        }
                        
                        public final boolean shouldOverrideUrlLoading(final WebView webView, final String s) {
                            return !ay.i && !s.equals(ay.b);
                        }
                        
                        public final boolean onRenderProcessGone(final WebView webView, final RenderProcessGoneDetail renderProcessGoneDetail) {
                            if (Build.VERSION.SDK_INT < 26) {
                                return false;
                            }
                            webView.destroy();
                            return true;
                        }
                    });
                    try {
                        final gr gr3;
                        final gr gr2 = gr3 = gr;
                        gr2.c = gr3.new a(gz.c());
                        gr3.c.setWebViewClient(gr3.b);
                        gr3.c.getSettings().setJavaScriptEnabled(true);
                        gr3.c.getSettings().setCacheMode(2);
                        gr.c.loadUrl(gr.a.f(), (Map)gr.a.e());
                    }
                    catch (Exception ex) {}
                }
            });
        }
    }
    
    final class b extends Handler
    {
        public b(final Looper looper) {
            super(looper);
        }
        
        public final void handleMessage(Message obtain) {
            try {
                switch (obtain.what) {
                    case 1: {
                        if (((fs)fg.a("root", gz.f(), null)).i()) {
                            break;
                        }
                        ba.f;
                        final int maxEventBatch = ba.h.maxEventBatch;
                        final int pingInterval = ba.h.pingInterval;
                        final int i = maxEventBatch;
                        final ArrayList<ay> list = new ArrayList<ay>();
                        final gt a;
                        if ((a = gt.a()).a("click") != 0) {
                            final List<ContentValues> a2 = a.a("click", az.a, null, null, "ts", "ts < " + (System.currentTimeMillis() - pingInterval), "ts ASC ", (-1 == i) ? null : Integer.toString(i));
                            a.b();
                            final Iterator<ContentValues> iterator = a2.iterator();
                            while (iterator.hasNext()) {
                                list.add(az.a(iterator.next()));
                            }
                        }
                        ba.e = list;
                        if (ba.e.isEmpty()) {
                            ba.f;
                            if (az.a()) {
                                ba.g.set(false);
                                return;
                            }
                            final Message obtain2;
                            (obtain2 = Message.obtain()).what = 1;
                            this.sendMessageDelayed(obtain2, (long)(ba.h.pingInterval * 1000));
                            return;
                        }
                        else {
                            ba.a;
                            final Iterator iterator2 = ba.e.iterator();
                            while (iterator2.hasNext()) {
                                iterator2.next();
                                ba.a;
                            }
                            final ay obj = ba.e.get(0);
                            (obtain = Message.obtain()).what = (obj.h ? 3 : 2);
                            obtain.obj = obj;
                            final long n;
                            if ((n = System.currentTimeMillis() - obj.d) < ba.h.pingInterval * 1000) {
                                this.sendMessageDelayed(obtain, ba.h.pingInterval * 1000 - n);
                                return;
                            }
                            this.sendMessage(obtain);
                            return;
                        }
                        break;
                    }
                    case 2: {
                        if (!hg.a()) {
                            ba.g.set(false);
                            i();
                            return;
                        }
                        final ay ay;
                        if ((ay = (ay)obtain.obj).f == 0 || ay.a(ba.h.pingCacheExpiry)) {
                            this.a(ay);
                            return;
                        }
                        if (ba.h.maxRetries - ay.f + 1 == 0) {
                            ba.a;
                        }
                        else {
                            ba.a;
                        }
                        new d(new e() {
                            @Override
                            public final void a(final ay ay) {
                                ba.b.a(ba.b.this, ay);
                            }
                            
                            @Override
                            public final void b(final ay ay) {
                                ba.a;
                                ba.a(ay);
                                ba.b.this.b(ay);
                            }
                        }).a(ay);
                    }
                    case 3: {
                        if (!hg.a()) {
                            ba.g.set(false);
                            i();
                            return;
                        }
                        final ay ay2;
                        if ((ay2 = (ay)obtain.obj).f == 0 || ay2.a(ba.h.pingCacheExpiry)) {
                            this.a(ay2);
                            return;
                        }
                        if (ba.h.maxRetries - ay2.f + 1 == 0) {
                            ba.a;
                        }
                        else {
                            ba.a;
                        }
                        new c(new e() {
                            @Override
                            public final void a(final ay ay) {
                                ba.b.a(ba.b.this, ay);
                            }
                            
                            @Override
                            public final void b(final ay ay) {
                                ba.a;
                                ba.a(ay);
                                ba.b.this.b(ay);
                            }
                        }).a(ay2);
                    }
                    case 4: {
                        final ay ay3 = (ay)obtain.obj;
                        ba.a;
                        ba.f;
                        az.a(ay3);
                        ba.e.remove(ay3);
                        if (!ba.e.isEmpty()) {
                            final ay obj2 = ba.e.get(0);
                            final Message obtain3;
                            (obtain3 = Message.obtain()).what = (obj2.h ? 3 : 2);
                            obtain3.obj = obj2;
                            this.sendMessage(obtain3);
                            return;
                        }
                        ba.f;
                        if (az.a()) {
                            ba.a;
                            ba.g.set(false);
                            return;
                        }
                        final Message obtain4;
                        (obtain4 = Message.obtain()).what = 1;
                        this.sendMessage(obtain4);
                    }
                    default: {
                        ba.a;
                        final int what = obtain.what;
                        break;
                    }
                }
            }
            catch (Exception ex) {
                ba.a;
            }
        }
        
        private void a(final ay ay) {
            ba.a;
            this.b(ay);
            ba.f;
            az.a(ay);
            ba.e.remove(ay);
        }
        
        private void b(ay obj) {
            final int index = ba.e.indexOf(obj);
            if (-1 != index) {
                obj = (ay)ba.e.get((index == ba.e.size() - 1) ? 0 : (index + 1));
                final Message obtain;
                (obtain = Message.obtain()).what = (obj.h ? 3 : 2);
                obtain.obj = obj;
                if (System.currentTimeMillis() - obj.d < ba.h.pingInterval * 1000) {
                    this.sendMessageDelayed(obtain, (long)(ba.h.pingInterval * 1000));
                    return;
                }
                this.sendMessage(obtain);
            }
        }
        
        static /* synthetic */ void a(final b b, final ay obj) {
            final Message obtain;
            (obtain = Message.obtain()).what = 4;
            obtain.obj = obj;
            b.sendMessage(obtain);
        }
    }
    
    interface e
    {
        void a(final ay p0);
        
        void b(final ay p0);
    }
}
