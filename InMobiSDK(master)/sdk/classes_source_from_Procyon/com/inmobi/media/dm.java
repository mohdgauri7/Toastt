// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import android.os.SystemClock;
import java.util.List;
import java.util.WeakHashMap;
import androidx.annotation.Nullable;
import android.os.Handler;
import android.view.View;
import java.util.Map;
import androidx.annotation.NonNull;

public class dm
{
    private static final String a;
    @NonNull
    private final ds b;
    @NonNull
    private final Map<View, b> c;
    @NonNull
    private final Map<View, b> d;
    @NonNull
    private final Handler e;
    @NonNull
    private final c f;
    private final long g;
    @Nullable
    private ds.c h;
    @NonNull
    private a i;
    
    public dm(final fe.m m, @NonNull final ds ds, @NonNull final a a) {
        this(new WeakHashMap<View, b>(), new WeakHashMap<View, b>(), ds, new Handler(), m, a);
    }
    
    private dm(@NonNull final Map<View, b> c, @NonNull final Map<View, b> d, @NonNull final ds b, @NonNull final Handler e, @NonNull final fe.m m, @NonNull final a i) {
        this.c = c;
        this.d = d;
        this.b = b;
        this.g = m.impressionPollIntervalMillis;
        this.h = new ds.c() {
            @Override
            public final void a(@NonNull final List<View> list, @NonNull final List<View> list2) {
                for (final View view : list) {
                    final dm.b b;
                    if ((b = dm.this.c.get(view)) == null) {
                        dm.this.a(view);
                    }
                    else {
                        final dm.b b2;
                        if ((b2 = dm.this.d.get(view)) != null && b.a.equals(b2.a)) {
                            continue;
                        }
                        b.d = SystemClock.uptimeMillis();
                        dm.this.d.put(view, b);
                    }
                }
                final Iterator<View> iterator2 = list2.iterator();
                while (iterator2.hasNext()) {
                    dm.this.d.remove(iterator2.next());
                }
                dm.this.e();
            }
        };
        this.b.c = this.h;
        this.e = e;
        this.f = new c(this);
        this.i = i;
    }
    
    public final void a(final View view, @NonNull final Object obj, final int n, final int n2) {
        final b b;
        if ((b = this.c.get(view)) != null && b.a.equals(obj)) {
            return;
        }
        this.a(view);
        final b b2 = new b(obj, n, n2);
        this.c.put(view, b2);
        this.b.a(view, obj, b2.b);
    }
    
    public final void a(final View view) {
        this.c.remove(view);
        this.d.remove(view);
        this.b.a(view);
    }
    
    final void a(@NonNull final Object obj) {
        View view = null;
        final Iterator<Map.Entry<View, b>> iterator = this.c.entrySet().iterator();
        while (iterator.hasNext()) {
            final Map.Entry<View, b> entry;
            if ((entry = iterator.next()).getValue().a.equals(obj)) {
                view = entry.getKey();
                break;
            }
        }
        if (view != null) {
            this.a(view);
        }
    }
    
    final void a() {
        this.b.f();
        this.e.removeCallbacksAndMessages((Object)null);
        this.d.clear();
    }
    
    public final void b() {
        for (final Map.Entry<View, b> entry : this.c.entrySet()) {
            this.b.a(entry.getKey(), entry.getValue().a, entry.getValue().b);
        }
        this.e();
        this.b.d();
    }
    
    final boolean c() {
        return !this.c.isEmpty();
    }
    
    final void d() {
        this.c.clear();
        this.d.clear();
        this.b.f();
        this.e.removeMessages(0);
        this.b.e();
        this.h = null;
    }
    
    private void e() {
        if (this.e.hasMessages(0)) {
            return;
        }
        this.e.postDelayed((Runnable)this.f, this.g);
    }
    
    static /* synthetic */ boolean a(final long n, final int n2) {
        return SystemClock.uptimeMillis() - n >= n2;
    }
    
    static {
        a = dm.class.getSimpleName();
    }
    
    static final class b
    {
        Object a;
        int b;
        int c;
        long d;
        
        b(final Object a, final int b, final int c) {
            this.d = Long.MAX_VALUE;
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    
    static final class c implements Runnable
    {
        @NonNull
        private final ArrayList<View> a;
        private WeakReference<dm> b;
        
        c(final dm referent) {
            this.a = new ArrayList<View>();
            this.b = new WeakReference<dm>(referent);
        }
        
        @Override
        public final void run() {
            final dm dm;
            if ((dm = this.b.get()) != null) {
                final Iterator<Map.Entry<View, V>> iterator = dm.d.entrySet().iterator();
                while (iterator.hasNext()) {
                    final Object o;
                    final View e = ((Map.Entry<View, b>)(o = iterator.next())).getKey();
                    final b b;
                    if (com.inmobi.media.dm.a((b = ((Map.Entry<K, b>)o).getValue()).d, b.c) && this.b.get() != null) {
                        dm.i.a(e, b.a);
                        this.a.add(e);
                    }
                }
                final Iterator<View> iterator2 = this.a.iterator();
                while (iterator2.hasNext()) {
                    dm.a(iterator2.next());
                }
                this.a.clear();
                if (!dm.d.isEmpty()) {
                    dm.e();
                }
            }
        }
    }
    
    public interface a
    {
        void a(final View p0, final Object p1);
    }
}
