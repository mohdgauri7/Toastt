// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.List;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import android.os.Looper;
import java.util.WeakHashMap;
import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.Map;
import androidx.annotation.NonNull;
import android.view.View;
import java.util.ArrayList;

public abstract class ds
{
    private static final String a;
    @NonNull
    private final ArrayList<View> d;
    private long e;
    boolean b;
    private final byte f;
    @NonNull
    private final Map<View, d> g;
    @NonNull
    private final a h;
    @Nullable
    c c;
    @NonNull
    private final b i;
    @NonNull
    private final Handler j;
    private boolean k;
    
    ds(final a a, final byte b) {
        this(new WeakHashMap<View, d>(10), a, new Handler(Looper.getMainLooper()), b);
    }
    
    private ds(@NonNull final Map<View, d> g, @NonNull final a h, @NonNull final Handler j, final byte f) {
        this.e = 0L;
        this.b = true;
        this.g = g;
        this.h = h;
        this.j = j;
        this.i = new b(this);
        this.d = new ArrayList<View>(50);
        this.f = f;
    }
    
    public void c() {
        this.i.run();
        this.j.removeCallbacksAndMessages((Object)null);
        this.k = false;
        this.b = true;
    }
    
    public void d() {
        this.b = false;
        this.h();
    }
    
    protected final void a(@NonNull final View view, @Nullable final Object o, final int n) {
        this.a(view, view, o, n);
    }
    
    private void a(@NonNull final View c, @NonNull final View view, @Nullable final Object d, final int a) {
        d d2;
        if ((d2 = this.g.get(view)) == null) {
            d2 = new d();
            this.g.put(view, d2);
            ++this.e;
        }
        d2.a = a;
        d2.b = this.e;
        d2.c = c;
        d2.d = d;
        if (this.e % 50L == 0L) {
            this.a(this.e - 50L);
        }
        if (1 == this.g.size()) {
            this.d();
        }
    }
    
    private void a(final long n) {
        final Iterator<Map.Entry<View, d>> iterator = this.g.entrySet().iterator();
        while (iterator.hasNext()) {
            final Map.Entry<View, d> entry;
            if ((entry = iterator.next()).getValue().b < n) {
                this.d.add(entry.getKey());
            }
        }
        final Iterator<View> iterator2 = this.d.iterator();
        while (iterator2.hasNext()) {
            this.a(iterator2.next());
        }
        this.d.clear();
    }
    
    public final void a(@NonNull final View view) {
        if (this.g.remove(view) != null) {
            --this.e;
            if (0 == this.g.size()) {
                this.c();
            }
        }
    }
    
    public final void f() {
        this.g.clear();
        this.j.removeMessages(0);
        this.k = false;
    }
    
    final void a(@Nullable final Object obj) {
        if (obj == null) {
            return;
        }
        View view = null;
        final Iterator<Map.Entry<View, d>> iterator = this.g.entrySet().iterator();
        while (iterator.hasNext()) {
            final Map.Entry<View, d> entry;
            if ((entry = iterator.next()).getValue().d.equals(obj)) {
                view = entry.getKey();
                break;
            }
        }
        if (view != null) {
            this.a(view);
        }
    }
    
    final boolean g() {
        return !this.g.isEmpty();
    }
    
    protected void e() {
        this.f();
        this.c = null;
        this.b = true;
    }
    
    final void h() {
        if (this.k || this.b) {
            return;
        }
        this.k = true;
        this.j.postDelayed((Runnable)this.i, (long)this.a());
    }
    
    protected abstract int a();
    
    protected abstract void b();
    
    static {
        a = ds.class.getSimpleName();
    }
    
    static final class d
    {
        int a;
        long b;
        View c;
        Object d;
    }
    
    static final class b implements Runnable
    {
        @NonNull
        private final ArrayList<View> a;
        @NonNull
        private final ArrayList<View> b;
        private WeakReference<ds> c;
        
        b(final ds referent) {
            this.c = new WeakReference<ds>(referent);
            this.b = new ArrayList<View>();
            this.a = new ArrayList<View>();
        }
        
        @Override
        public final void run() {
            final ds ds;
            if ((ds = this.c.get()) != null) {
                ds.k = false;
                final Iterator<Map.Entry<View, V>> iterator = ds.g.entrySet().iterator();
                while (iterator.hasNext()) {
                    final Object o;
                    final View view = ((Map.Entry<View, d>)(o = iterator.next())).getKey();
                    final int a = ((Map.Entry<K, d>)o).getValue().a;
                    final View c = ((Map.Entry<K, d>)o).getValue().c;
                    final Object d = ((Map.Entry<K, d>)o).getValue().d;
                    switch (ds.f) {
                        default: {
                            final a d2;
                            if ((d2 = ds.h).a(c, view, a, d)) {
                                final a a2 = d2;
                                final View view2 = view;
                                if (a2.a(view2, view2, a)) {
                                    this.a.add(view);
                                    continue;
                                }
                            }
                            this.b.add(view);
                            continue;
                        }
                        case 2: {
                            final dl.a a3;
                            if ((a3 = (dl.a)ds.h).a(c, view, a, d)) {
                                final dl.a a4 = a3;
                                final View view3 = view;
                                if (a4.a(view3, view3, a) && a3.a(view)) {
                                    this.a.add(view);
                                    continue;
                                }
                            }
                            this.b.add(view);
                            continue;
                        }
                    }
                }
            }
            final c e;
            if (ds != null && (e = ds.c) != null) {
                e.a(this.a, this.b);
            }
            this.a.clear();
            this.b.clear();
            if (ds != null) {
                ds.b();
            }
        }
    }
    
    public interface a
    {
        boolean a(@Nullable final View p0, @Nullable final View p1, final int p2, final Object p3);
        
        boolean a(@NonNull final View p0, @NonNull final View p1, final int p2);
    }
    
    public interface c
    {
        void a(final List<View> p0, final List<View> p1);
    }
}
