// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.os.Message;
import android.os.Looper;
import java.lang.ref.WeakReference;
import android.os.Handler;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;
import com.squareup.picasso.Callback;
import java.util.concurrent.CountDownLatch;
import android.annotation.TargetApi;
import android.os.Build;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.MalformedURLException;
import java.io.FileNotFoundException;
import java.net.SocketTimeoutException;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.Closeable;
import java.util.Locale;
import java.net.URL;
import java.net.HttpURLConnection;
import android.os.SystemClock;
import android.webkit.URLUtil;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.Executors;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import android.os.HandlerThread;
import java.util.concurrent.ExecutorService;

public final class aw implements fg.c
{
    private static final String b;
    private au c;
    private fe.a d;
    private fe.k e;
    public ExecutorService a;
    private ExecutorService f;
    private a g;
    private HandlerThread h;
    private AtomicBoolean i;
    private AtomicBoolean j;
    private ConcurrentHashMap<String, al> k;
    private hk.c l;
    private static final Object m;
    private List<am> n;
    private final av o;
    
    private aw() {
        this.i = new AtomicBoolean(false);
        this.j = new AtomicBoolean(false);
        this.n = new ArrayList<am>();
        this.o = new av() {
            @Override
            public final void a(@NonNull final gn gn, @NonNull final String s, @NonNull final al al) {
                aw.b;
                final al a = new al.a().a(al.d, s, gn, aw.this.d.maxRetries, aw.this.d.timeToLive).a();
                aw.this.c;
                au.b(a);
                a.k = al.k;
                a.a = al.a;
                aw.this.a(a, (byte)0);
                try {
                    aw.c(aw.this);
                }
                catch (Exception ex) {
                    aw.b;
                    fv.a().a(new gv(ex));
                }
            }
            
            @Override
            public final void a(@NonNull final al al) {
                aw.b;
                aw.this.c(al.d);
                if (al.c <= 0) {
                    aw.b;
                    aw.this.a(al, al.l);
                    aw.this.c;
                    au.c(al);
                }
                else {
                    aw.b;
                    al.f = System.currentTimeMillis();
                    aw.this.c;
                    au.b(al);
                    if (!hg.a()) {
                        aw.this.a(al, al.l);
                    }
                }
                try {
                    aw.c(aw.this);
                }
                catch (Exception ex) {
                    aw.b;
                    fv.a().a(new gv(ex));
                }
            }
        };
        final fe fe = (fe)fg.a("ads", gz.f(), this);
        this.d = fe.assetCache;
        this.e = fe.vastVideo;
        this.c = au.a();
        this.a = Executors.newCachedThreadPool(new he(aw.b + "-AP"));
        this.f = Executors.newFixedThreadPool(1, new he(aw.b + "-AD"));
        (this.h = new HandlerThread("assetFetcher")).start();
        this.g = new a(this.h.getLooper(), this);
        this.l = new hk.c() {
            @Override
            public final void a(final boolean b) {
                if (b) {
                    aw.c(aw.this);
                    return;
                }
                aw.this.i();
            }
        };
        this.k = new ConcurrentHashMap<String, al>(2, 0.9f, 2);
    }
    
    public static aw a() {
        return aw.b.a;
    }
    
    @Override
    public final void a(final ff ff) {
        this.d = ((fe)ff).assetCache;
        this.e = ((fe)ff).vastVideo;
    }
    
    private synchronized void a(final String anObject) {
        for (int i = 0; i < this.n.size(); ++i) {
            final am am;
            final Set<bd> b = (am = this.n.get(i)).b;
            final Set<String> c = am.c;
            boolean b2 = false;
            final Iterator<bd> iterator = b.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().b.equals(anObject)) {
                    b2 = true;
                    break;
                }
            }
            if (b2 && !c.contains(anObject)) {
                am.c.add(anObject);
                final am am2 = am;
                ++am2.d;
            }
        }
    }
    
    private synchronized void b(final String anObject) {
        for (int i = 0; i < this.n.size(); ++i) {
            final am am;
            final Set<bd> b = (am = this.n.get(i)).b;
            boolean b2 = false;
            final Iterator<bd> iterator = b.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().b.equals(anObject)) {
                    b2 = true;
                    break;
                }
            }
            if (b2) {
                final am am2 = am;
                ++am2.e;
            }
        }
    }
    
    private synchronized void a(final al al) {
        for (int i = 0; i < this.n.size(); ++i) {
            final am am;
            final Set<bd> b = (am = this.n.get(i)).b;
            boolean b2 = false;
            final Iterator<bd> iterator = b.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().b.equals(al.d)) {
                    b2 = true;
                    break;
                }
            }
            if (b2 && !am.a.contains(al)) {
                am.a.add(al);
            }
        }
    }
    
    private synchronized void a(final am am) {
        if (!this.n.contains(am)) {
            this.n.add(am);
        }
    }
    
    private synchronized void a(final List<am> list) {
        for (int size = list.size(), i = 0; i < size; ++i) {
            this.n.remove(list.get(i));
        }
    }
    
    private boolean a(al value, av av) {
        if (this.k.putIfAbsent(value.d, value) == null) {
            final Object o = new an(av);
            final Object o2 = value;
            final long vastMaxAssetSize = this.e.vastMaxAssetSize;
            final List<String> allowedContentType = this.e.allowedContentType;
            final long n = vastMaxAssetSize;
            av = (av)o2;
            value = (al)o;
            if (!hg.a()) {
                ((al)av).l = 5;
                ((an)value).a.a((al)av);
            }
            else if (((al)av).d.equals("") || !URLUtil.isValidUrl(((al)av).d)) {
                ((al)av).l = 1;
                ((an)value).a.a((al)av);
            }
            else {
                final List<String> list = allowedContentType;
                final String[] array = list.toArray(new String[list.size()]);
                BufferedOutputStream bufferedOutputStream = null;
                InputStream inputStream = null;
                try {
                    final long elapsedRealtime = SystemClock.elapsedRealtime();
                    final HttpURLConnection httpURLConnection;
                    (httpURLConnection = (HttpURLConnection)new URL(((al)av).d).openConnection()).setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(60000);
                    httpURLConnection.setReadTimeout(60000);
                    if (httpURLConnection.getResponseCode() < 400) {
                        final String contentType = httpURLConnection.getContentType();
                        boolean b = false;
                        for (final String s : array) {
                            if (contentType != null && s.toLowerCase(Locale.ENGLISH).equals(contentType.toLowerCase(Locale.ENGLISH))) {
                                b = true;
                                break;
                            }
                        }
                        if (!b) {
                            ((al)av).l = 3;
                            ((al)av).c = 0;
                            ((an)value).a.a((al)av);
                            hg.a((Closeable)null);
                            hg.a((Closeable)null);
                            return true;
                        }
                    }
                    final long n2;
                    if ((n2 = httpURLConnection.getContentLength()) >= 0L && n2 > n) {
                        ((al)av).l = 4;
                        ((al)av).c = 0;
                        ((an)value).a.a((al)av);
                        hg.a((Closeable)null);
                        hg.a((Closeable)null);
                        return true;
                    }
                    httpURLConnection.connect();
                    final File a;
                    if ((a = gz.a(((al)av).d)).exists()) {
                        a.delete();
                    }
                    inputStream = httpURLConnection.getInputStream();
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(a));
                    final byte[] array2 = new byte[1024];
                    long n3 = 0L;
                    int read;
                    while ((read = inputStream.read(array2)) > 0) {
                        if ((n3 += read) > n) {
                            ((al)av).l = 4;
                            ((al)av).c = 0;
                            final File file = a;
                            final HttpURLConnection httpURLConnection2 = httpURLConnection;
                            final BufferedOutputStream bufferedOutputStream2 = bufferedOutputStream;
                            final HttpURLConnection httpURLConnection3 = httpURLConnection2;
                            final File file2 = file;
                            try {
                                if (file2.exists()) {
                                    file2.delete();
                                }
                                httpURLConnection3.disconnect();
                                hg.a(bufferedOutputStream2);
                            }
                            catch (Exception ex) {
                                fv.a().a(new gv(ex));
                            }
                            an.a(elapsedRealtime, n3, SystemClock.elapsedRealtime());
                            ((an)value).a.a((al)av);
                            return true;
                        }
                        bufferedOutputStream.write(array2, 0, read);
                    }
                    bufferedOutputStream.flush();
                    httpURLConnection.disconnect();
                    final long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    an.a(elapsedRealtime, n3, elapsedRealtime2);
                    final gn gn;
                    (gn = new gn()).c = httpURLConnection.getHeaderFields();
                    final av av2 = av;
                    ((al)av2).k = an.a((al)av2, a, elapsedRealtime, elapsedRealtime2);
                    ((al)av).a = elapsedRealtime2 - elapsedRealtime;
                    ((an)value).a.a(gn, a.getAbsolutePath(), (al)av);
                    return true;
                }
                catch (SocketTimeoutException ex2) {
                    ((al)av).l = 2;
                    ((an)value).a.a((al)av);
                }
                catch (FileNotFoundException ex3) {
                    ((al)av).l = 2;
                    ((an)value).a.a((al)av);
                }
                catch (MalformedURLException ex4) {
                    ((al)av).l = 1;
                    ((an)value).a.a((al)av);
                }
                catch (ProtocolException ex5) {
                    ((al)av).l = 5;
                    ((an)value).a.a((al)av);
                }
                catch (IOException ex6) {
                    ((al)av).l = 5;
                    ((an)value).a.a((al)av);
                }
                catch (Exception ex7) {
                    ((al)av).l = 0;
                    ((an)value).a.a((al)av);
                }
                finally {
                    hg.a(bufferedOutputStream);
                    hg.a((Closeable)inputStream);
                }
            }
            return true;
        }
        return false;
    }
    
    private void c(final String key) {
        this.k.remove(key);
    }
    
    private synchronized void a(@NonNull final al al, final byte b) {
        this.a(al);
        this.c(al.d);
        if (b == 0) {
            this.a(al.d);
            this.f();
            return;
        }
        this.b(al.d);
        this.a(b);
    }
    
    private synchronized void f() {
        final ArrayList<am> list = new ArrayList<am>();
        for (int i = 0; i < this.n.size(); ++i) {
            final am am;
            if ((am = this.n.get(i)).d == am.b.size()) {
                try {
                    final ax a;
                    if ((a = am.a()) != null) {
                        a.a(am);
                    }
                    list.add(am);
                }
                catch (Exception ex) {
                    fv.a().a(new gv(ex));
                }
            }
        }
        this.a(list);
    }
    
    private synchronized void a(final byte b) {
        final ArrayList<am> list = new ArrayList<am>();
        for (int i = 0; i < this.n.size(); ++i) {
            final am am;
            if ((am = this.n.get(i)).e > 0) {
                try {
                    final ax a;
                    if ((a = am.a()) != null) {
                        a.a(am, b);
                    }
                    list.add(am);
                }
                catch (Exception ex) {
                    fv.a().a(new gv(ex));
                }
            }
        }
        this.a(list);
    }
    
    public final void b() {
        this.j.set(false);
        if (!hg.a()) {
            this.g();
            this.h();
            return;
        }
        synchronized (aw.m) {
            if (this.i.compareAndSet(false, true)) {
                if (this.h == null) {
                    (this.h = new HandlerThread("assetFetcher")).start();
                }
                if (this.g == null) {
                    this.g = new a(this.h.getLooper(), this);
                }
                if (au.c().isEmpty()) {
                    this.i();
                }
                else {
                    this.g();
                    this.h();
                    this.g.sendEmptyMessage(1);
                }
            }
        }
    }
    
    public final void c() {
        this.j.set(true);
        this.i();
    }
    
    public final void d() {
        synchronized (aw.m) {
            final List<al> d;
            if ((d = au.d()).isEmpty()) {
                return;
            }
            final Iterator<al> iterator = d.iterator();
            while (iterator.hasNext()) {
                final al al;
                if (System.currentTimeMillis() > (al = iterator.next()).h) {
                    b(al);
                }
            }
            while (true) {
                final List<al> d2 = au.d();
                long n = 0L;
                final Iterator<al> iterator2 = d2.iterator();
                while (iterator2.hasNext()) {
                    n += new File(iterator2.next().e).length();
                }
                final al b;
                if (n <= this.d.maxCacheSize || (b = au.b()) == null) {
                    break;
                }
                b(b);
            }
            final List<al> list = d;
            final File b2;
            final File[] listFiles;
            if ((b2 = gz.b(gz.c())).exists() && (listFiles = b2.listFiles()) != null) {
                for (final File file : listFiles) {
                    boolean b3 = false;
                    final Iterator<al> iterator3 = list.iterator();
                    while (iterator3.hasNext()) {
                        if (file.getAbsolutePath().equals(iterator3.next().e)) {
                            b3 = true;
                            break;
                        }
                    }
                    if (!b3) {
                        file.getAbsolutePath();
                        file.delete();
                    }
                }
            }
        }
    }
    
    private static void b(final al al) {
        au.c(al);
        final File file;
        if ((file = new File(al.e)).exists()) {
            file.delete();
        }
    }
    
    private void c(final al al) {
        final File file = new File(al.e);
        final long min = Math.min(System.currentTimeMillis() + (al.h - al.f), System.currentTimeMillis() + 1000L * this.d.timeToLive);
        final al.a a = new al.a();
        final String d = al.d;
        final String e = al.e;
        final int maxRetries = this.d.maxRetries;
        final long n = min;
        final long i = al.i;
        final long g = n;
        final int b = maxRetries;
        final String d2 = e;
        final String c = d;
        final al.a a2 = a;
        a.c = c;
        a2.d = d2;
        a2.b = b;
        a2.g = g;
        a2.h = i;
        final al a3;
        (a3 = a2.a()).f = System.currentTimeMillis();
        au.b(a3);
        a3.k = an.a(al, file, al.f, al.f);
        a3.j = true;
        this.a(a3, (byte)0);
    }
    
    @TargetApi(23)
    private void g() {
        hk.a();
        hk.a(this.l, "android.net.conn.CONNECTIVITY_CHANGE");
        if (Build.VERSION.SDK_INT >= 23) {
            hk.a();
            hk.b(this.l);
        }
    }
    
    @TargetApi(23)
    private void h() {
        hk.a().a("android.net.conn.CONNECTIVITY_CHANGE", this.l);
        if (Build.VERSION.SDK_INT >= 23) {
            hk.a().a(this.l);
        }
    }
    
    private void i() {
        synchronized (aw.m) {
            this.i.set(false);
            this.k.clear();
            if (this.h != null) {
                this.h.getLooper().quit();
                ((Thread)this.h).interrupt();
                this.h = null;
                this.g = null;
            }
        }
    }
    
    static /* synthetic */ void c(final aw aw) {
        if (!aw.j.get()) {
            aw.b();
        }
    }
    
    static /* synthetic */ boolean b(final aw aw, final al al) {
        return aw.k.containsKey(al.d);
    }
    
    static {
        b = aw.class.getSimpleName();
        m = new Object();
    }
    
    static final class b
    {
        static final aw a;
        
        static {
            a = new aw((byte)0);
        }
    }
    
    final class c implements InvocationHandler
    {
        private CountDownLatch b;
        private String c;
        private long d;
        private String e;
        
        c(final CountDownLatch b, final String c, final long d, final String e) {
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }
        
        @Override
        public final Object invoke(final Object o, final Method method, final Object[] array) {
            aw.b;
            if (method != null) {
                if ("onSuccess".equalsIgnoreCase(method.getName())) {
                    final HashMap<String, Integer> hashMap;
                    (hashMap = new HashMap<String, Integer>()).put("latency", (Integer)(Object)Long.valueOf(SystemClock.elapsedRealtime() - this.d));
                    hashMap.put("size", 0);
                    hashMap.put("assetType", (Integer)"image");
                    hashMap.put("networkType", (Integer)hn.b());
                    hashMap.put("adType", (Integer)this.e);
                    gw.a().a("AssetDownloaded", (Map<String, Object>)hashMap);
                    aw.this.a(this.c);
                    this.b.countDown();
                }
                else if ("onError".equalsIgnoreCase(method.getName())) {
                    aw.this.b(this.c);
                    this.b.countDown();
                }
            }
            return null;
        }
    }
    
    static final class a extends Handler
    {
        private WeakReference<aw> a;
        private final av b;
        
        a(@NonNull final Looper looper, @NonNull final aw referent) {
            super(looper);
            this.a = new WeakReference<aw>(referent);
            this.b = new av() {
                @Override
                public final void a(final gn gn, final String s, final al al) {
                    final aw aw;
                    if ((aw = (aw)com.inmobi.media.aw.a.this.a.get()) != null) {
                        com.inmobi.media.aw.b;
                        final al a = new al.a().a(al.d, s, gn, aw.d.maxRetries, aw.d.timeToLive).a();
                        aw.c;
                        au.b(a);
                        a.k = al.k;
                        a.a = al.a;
                        aw.a(a, (byte)0);
                        com.inmobi.media.aw.a.this.a();
                        return;
                    }
                    com.inmobi.media.aw.b;
                }
                
                @Override
                public final void a(final al al) {
                    final aw aw;
                    if ((aw = (aw)com.inmobi.media.aw.a.this.a.get()) == null) {
                        com.inmobi.media.aw.b;
                        return;
                    }
                    com.inmobi.media.aw.b;
                    aw.c(al.d);
                    if (al.c > 0) {
                        --al.c;
                        al.f = System.currentTimeMillis();
                        aw.c;
                        au.b(al);
                        com.inmobi.media.aw.a.this.b();
                        return;
                    }
                    aw.a(al, al.l);
                    com.inmobi.media.aw.a.this.a(al);
                }
            };
        }
        
        public final void handleMessage(Message obtain) {
            try {
                final aw aw = this.a.get();
                switch (obtain.what) {
                    default: {}
                    case 1: {
                        if (aw == null) {
                            break;
                        }
                        fe.a a;
                        if ((a = aw.d) == null) {
                            a = ((fe)fg.a("ads", gz.f(), null)).assetCache;
                        }
                        aw.c;
                        final List<al> c;
                        if ((c = au.c()).size() <= 0) {
                            com.inmobi.media.aw.b;
                            aw.i();
                            return;
                        }
                        com.inmobi.media.aw.b;
                        al al = c.get(0);
                        for (final al al2 : c) {
                            if (!com.inmobi.media.aw.b(aw, al)) {
                                al = al2;
                                break;
                            }
                        }
                        final Message obtain2;
                        (obtain2 = Message.obtain()).what = 1;
                        final long n = System.currentTimeMillis() - al.f;
                        try {
                            if (n < a.retryInterval * 1000) {
                                this.sendMessageDelayed(obtain2, a.retryInterval * 1000 - n);
                                return;
                            }
                            if (com.inmobi.media.aw.b(aw, al)) {
                                this.sendMessageDelayed(obtain2, (long)(a.retryInterval * 1000));
                                return;
                            }
                            com.inmobi.media.aw.b;
                            (obtain = Message.obtain()).what = 2;
                            obtain.obj = al.d;
                            this.sendMessage(obtain);
                            return;
                        }
                        catch (Exception ex2) {
                            com.inmobi.media.aw.b;
                            return;
                        }
                    }
                    case 2: {
                        if (aw == null) {
                            break;
                        }
                        final String s = (String)obtain.obj;
                        aw.c;
                        final al b;
                        if ((b = au.b(s)) == null) {
                            this.b();
                            return;
                        }
                        if (b.a()) {
                            com.inmobi.media.aw.b;
                            this.a();
                            aw.a(b, (byte)0);
                            return;
                        }
                        aw.d;
                        if (b.c == 0) {
                            b.l = 6;
                            final aw aw2 = aw;
                            final al al3 = b;
                            aw2.a(al3, al3.l);
                            this.a(b);
                            return;
                        }
                        if (!hg.a()) {
                            final aw aw3 = aw;
                            final al al4 = b;
                            aw3.a(al4, al4.l);
                            aw.i();
                            return;
                        }
                        if (aw.a(b, this.b)) {
                            com.inmobi.media.aw.b;
                            com.inmobi.media.aw.b;
                            return;
                        }
                        com.inmobi.media.aw.b;
                        this.b();
                    }
                    case 4: {
                        if (aw != null) {
                            final al al5 = (al)obtain.obj;
                            aw.c;
                            au.c(al5);
                        }
                        this.b();
                    }
                    case 3: {
                        this.b();
                        break;
                    }
                }
            }
            catch (Exception ex) {
                aw.b;
                fv.a().a(new gv(ex));
            }
        }
        
        private void a(final al obj) {
            try {
                final Message obtain;
                (obtain = Message.obtain()).what = 4;
                obtain.obj = obj;
                this.sendMessage(obtain);
            }
            catch (Exception ex) {
                aw.b;
            }
        }
        
        private void a() {
            try {
                this.sendEmptyMessage(3);
            }
            catch (Exception ex) {
                aw.b;
            }
        }
        
        private void b() {
            try {
                this.sendEmptyMessage(1);
            }
            catch (Exception ex) {
                aw.b;
            }
        }
    }
}
