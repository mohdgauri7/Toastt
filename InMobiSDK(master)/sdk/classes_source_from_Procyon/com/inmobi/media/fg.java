// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.Executors;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.List;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashMap;
import androidx.annotation.NonNull;
import java.util.Iterator;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import androidx.annotation.VisibleForTesting;

public class fg
{
    private static final String d;
    @VisibleForTesting
    public static boolean a;
    private static Map<ff, ArrayList<WeakReference<c>>> e;
    private static a f;
    @VisibleForTesting
    public static AtomicBoolean b;
    @VisibleForTesting
    public static CopyOnWriteArrayList<ff> c;
    
    @WorkerThread
    public static void a() {
        if (!fg.b.getAndSet(true)) {
            new fh();
            fg.c.addAll(fh.a());
            a("root", gz.f(), null);
        }
    }
    
    @WorkerThread
    public static void b() {
        if (fg.b.getAndSet(false)) {
            fg.c.clear();
            fg.f.sendEmptyMessage(5);
        }
    }
    
    public static ff a(final String s, @Nullable final String s2, @Nullable final c c) {
        final ff a = ff.a(s, s2);
        if (s2 == null) {
            return a;
        }
        final Message obtainMessage;
        (obtainMessage = fg.f.obtainMessage()).what = 0;
        obtainMessage.obj = new fj(a, c);
        fg.f.sendMessage(obtainMessage);
        if (!fg.c.isEmpty()) {
            final Iterator<ff> iterator = fg.c.iterator();
            while (iterator.hasNext()) {
                final ff ff;
                if ((ff = iterator.next()).equals(a)) {
                    return ff;
                }
            }
        }
        return a;
    }
    
    public static void a(@NonNull String url) {
        new fh();
        final fs fs;
        final String version = (fs = (fs)fh.a("root", url)).latestSdkInfo.version;
        url = fs.latestSdkInfo.url;
        if (version.trim().length() != 0 && b(ha.b(), version.trim())) {
            hf.a((byte)2, fg.d, "A newer version (version " + version + ") of the InMobi SDK is available! You are currently on an older version (Version " + ha.b() + "). Please download the latest InMobi SDK from " + url);
        }
    }
    
    private static boolean a(final long n, final long n2) {
        return System.currentTimeMillis() - n > n2 * 1000L;
    }
    
    private static void b(final ff obj) {
        final Message obtainMessage;
        (obtainMessage = fg.f.obtainMessage()).what = 1;
        obtainMessage.obj = obj;
        fg.f.sendMessage(obtainMessage);
    }
    
    private static boolean b(final String s, final String s2) {
        final String[] split = s.split("\\.");
        final String[] split2 = s2.split("\\.");
        try {
            String[] array;
            for (int length = (array = split).length, i = 0; i < length; ++i) {
                if (Integer.valueOf(array[i]) < 0) {
                    return false;
                }
            }
            String[] array2;
            for (int length2 = (array2 = split2).length, j = 0; j < length2; ++j) {
                if (Integer.valueOf(array2[j]) < 0) {
                    return false;
                }
            }
        }
        catch (NumberFormatException ex) {
            return false;
        }
        for (int n = (split.length < split2.length) ? split.length : split2.length, k = 0; k < n; ++k) {
            if (!split[k].equals(split2[k])) {
                return Integer.valueOf(split[k]) < Integer.valueOf(split2[k]);
            }
        }
        return split.length < split2.length;
    }
    
    static /* synthetic */ void a(final ff ff, final c referent) {
        ArrayList<WeakReference<c>> list;
        if ((list = fg.e.get(ff)) == null) {
            list = new ArrayList<WeakReference<c>>();
        }
        list.add((referent == null) ? null : new WeakReference<c>(referent));
        fg.e.put(ff, list);
    }
    
    static /* synthetic */ void a(final String anObject, final String s) {
        new fh();
        final ff a = ff.a(anObject, s);
        if (fh.b("root", s)) {
            b(ff.a("root", s));
            return;
        }
        final fs fs;
        final long c = fh.c((fs = (fs)fh.a("root", s)).b(), s);
        final fs fs2 = fs;
        if (a(c, fs2.a(fs2.b()))) {
            b(ff.a("root", s));
        }
        if (!"root".equals(anObject)) {
            if (fh.b(anObject, s)) {
                b(a);
                return;
            }
            if (a(fh.c(anObject, s), fs.a(anObject))) {
                b(a);
            }
        }
    }
    
    static /* synthetic */ void a(final ff ff) {
        final ArrayList<WeakReference<c>> list;
        if ((list = fg.e.get(ff)) != null) {
            for (int i = 0; i < list.size(); ++i) {
                final c c;
                if (list.get(i) != null && (c = list.get(i).get()) != null) {
                    c.a(ff);
                }
            }
        }
    }
    
    static /* synthetic */ Map a(final Map map) {
        final HashMap hashMap;
        (hashMap = new HashMap(1)).put("root", map.get("root"));
        return hashMap;
    }
    
    static {
        d = fg.class.getSimpleName();
        fg.a = false;
        fg.e = new HashMap<ff, ArrayList<WeakReference<c>>>();
        final HandlerThread handlerThread;
        (handlerThread = new HandlerThread("ConfigBootstrapHandler")).start();
        fg.f = new a(handlerThread.getLooper());
        fg.b = new AtomicBoolean(false);
        fg.c = new CopyOnWriteArrayList<ff>();
    }
    
    static final class b
    {
        @NonNull
        final String a;
        @NonNull
        final String b;
        
        b(@NonNull final String a, @NonNull final String b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public final boolean equals(final Object o) {
            if (!(o instanceof b)) {
                return false;
            }
            final b b = (b)o;
            return this.a.equals(b.a) && this.b.equals(b.b);
        }
        
        @Override
        public final int hashCode() {
            return this.a.hashCode() + this.b.hashCode();
        }
    }
    
    static final class a extends Handler implements fk.a
    {
        private List<ff> a;
        private Map<b, Map<String, ff>> b;
        private Map<String, ff> c;
        private ExecutorService d;
        
        a(final Looper looper) {
            super(looper);
            this.a = new ArrayList<ff>();
            this.b = new HashMap<b, Map<String, ff>>();
            this.c = new HashMap<String, ff>();
        }
        
        public final void handleMessage(final Message message) {
            switch (message.what) {
                case 0: {
                    final fj fj;
                    final ff a = (fj = (fj)message.obj).a;
                    if (!fg.b.get()) {
                        fg.d;
                        a.b();
                        return;
                    }
                    fg.a(a, fj.b);
                    if (null == a.g()) {
                        fg.d;
                        a.b();
                        return;
                    }
                    fg.a(a.b(), a.g());
                }
                case 1: {
                    final ff ff = (ff)message.obj;
                    if (null == ff.g()) {
                        fg.d;
                        ff.b();
                        return;
                    }
                    final String b = ff.b();
                    final String g = ff.g();
                    final String s = b;
                    new fh();
                    final fs fs = (fs)fh.a("root", g);
                    boolean b2 = false;
                    final b b3 = new b(fs.b(s), g);
                    if (this.b.get(b3) != null && this.b.get(b3).containsKey(s)) {
                        b2 = true;
                    }
                    if (this.c != null && this.c.containsKey(s)) {
                        b2 = true;
                    }
                    final boolean b4 = b2;
                    fg.d;
                    ff.b();
                    if (b4) {
                        fg.d;
                        ff.b();
                        return;
                    }
                    this.a.add(ff);
                    if (!this.hasMessages(2)) {
                        final Message obtain;
                        (obtain = Message.obtain()).what = 2;
                        obtain.obj = ff.g();
                        this.sendMessage(obtain);
                        return;
                    }
                    break;
                }
                case 2: {
                    new fh();
                    this.sendEmptyMessageDelayed(3, (long)(((fs)fh.a("root", (String)message.obj)).waitTime * 1000));
                }
                case 3: {
                    final List<ff> a2 = this.a;
                    for (int i = 0; i < a2.size(); ++i) {
                        final ff value = a2.get(i);
                        if (null != value.g()) {
                            new fh();
                            final b b5 = new b(((fs)fh.a("root", value.g())).b(value.b()), value.g());
                            HashMap<String, ff> hashMap;
                            if ((hashMap = this.b.get(b5)) == null) {
                                hashMap = new HashMap<String, ff>();
                                this.b.put(b5, hashMap);
                            }
                            hashMap.put(value.b(), value);
                        }
                    }
                    this.a.clear();
                    if (this.d == null || this.d.isShutdown()) {
                        this.d = Executors.newFixedThreadPool(1, new he(fg.d));
                        this.sendEmptyMessage(4);
                        return;
                    }
                    break;
                }
                case 4: {
                    if (!this.b.isEmpty()) {
                        final Map.Entry<b, Map<String, ff>> entry = this.b.entrySet().iterator().next();
                        this.c = entry.getValue();
                        this.b.remove(entry.getKey());
                        final b b6 = entry.getKey();
                        final Map<String, ff> c = this.c;
                        final String b7 = entry.getKey().b;
                        Map<String, ff> a3 = c;
                        final b b8 = b6;
                        new fh();
                        final fs fs2;
                        final int h = (fs2 = (fs)fh.a("root", b7)).h();
                        final int e = fs2.e();
                        final id id = new id(fs2.f());
                        boolean f;
                        if (!(f = hq.f()) && a3.containsKey("root")) {
                            a3 = (Map<String, ff>)fg.a(a3);
                            f = true;
                        }
                        final fl fl = new fl(a3, id, b8.a, e, h, f, b7);
                        fl fl2 = null;
                        if (a3.containsKey("root")) {
                            fl2 = new fl(fg.a(a3), id, fs2.k(), e, h, true, f, b7);
                        }
                        final fk fk = new fk(this, fl, fl2);
                        try {
                            this.d.execute(fk);
                            return;
                        }
                        catch (OutOfMemoryError outOfMemoryError) {
                            fg.d;
                            return;
                        }
                    }
                    fg.d;
                    this.sendEmptyMessage(5);
                }
                case 6: {
                    final fm.a a4 = (fm.a)message.obj;
                    new fh();
                    if (a4.a()) {
                        fg.d;
                        a4.b.b();
                        return;
                    }
                    if (a4.a == 304) {
                        fg.d;
                        a4.b.b();
                        if (a4.b.g() != null) {
                            fh.a(a4.b.b(), a4.b.g(), System.currentTimeMillis());
                        }
                        return;
                    }
                    fh.a(a4.b);
                    fg.d;
                    a4.b.b();
                    fg.d;
                    a4.b.c();
                    fg.d;
                    a4.b.g();
                    fg.c.remove(a4.b);
                    fg.c.add(a4.b);
                    fg.a(a4.b);
                }
                case 5: {
                    if (this.d != null && !this.d.isShutdown()) {
                        this.c = null;
                        this.b.clear();
                        this.removeMessages(3);
                        this.d.shutdownNow();
                    }
                }
                default: {
                    fg.d;
                    final int what = message.what;
                    break;
                }
            }
        }
        
        @WorkerThread
        public final void a(final fm.a obj) {
            final Message obtain;
            (obtain = Message.obtain()).what = 6;
            obtain.obj = obj;
            this.sendMessage(obtain);
        }
        
        public final void a(final String obj) {
            final Message obtain;
            (obtain = Message.obtain()).what = 4;
            obtain.obj = obj;
            this.sendMessage(obtain);
        }
    }
    
    public interface c
    {
        void a(final ff p0);
    }
}
