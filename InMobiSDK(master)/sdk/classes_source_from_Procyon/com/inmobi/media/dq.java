// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.Nullable;
import android.graphics.Rect;
import java.util.HashMap;
import java.util.WeakHashMap;
import java.util.Iterator;
import java.util.List;
import android.app.Activity;
import androidx.annotation.NonNull;
import android.view.View;
import android.content.Context;
import java.util.Map;

public class dq
{
    private static final String b;
    static final Map<Context, dm> a;
    private static final Map<Context, ds> c;
    private static final Map<View, a> d;
    private static final dm.a e;
    private static final ds.a f;
    private boolean g;
    private byte h;
    
    dq(final byte h) {
        this.h = h;
    }
    
    final void a(@NonNull final Context context, @NonNull final View view, @NonNull final l l, @NonNull final fe.m m) {
        final dm a = this.a(context, m);
        switch (this.h) {
            case 0: {
                a.a(view, l, m.video.impressionMinPercentageViewed, m.video.impressionMinTimeViewed);
            }
            default: {
                a.a(view, l, m.impressionMinPercentageViewed, m.impressionMinTimeViewed);
            }
        }
    }
    
    private dm a(@NonNull final Context context, @NonNull final fe.m m) {
        dm dm;
        if ((dm = dq.a.get(context)) == null) {
            if (context instanceof Activity) {
                dm = new dm(m, new dk(dq.f, (Activity)context), dq.e);
                if (!this.g) {
                    this.g = true;
                }
            }
            else {
                dm = new dm(m, new dr(dq.f, m, (byte)1), dq.e);
            }
            dq.a.put(context, dm);
        }
        return dm;
    }
    
    final void a(@NonNull final Context context, @NonNull final l l) {
        final dm dm;
        if ((dm = dq.a.get(context)) != null) {
            dm.a(l);
            if (!dm.c()) {
                this.a(context);
            }
        }
    }
    
    final void a(@NonNull final Context context) {
        final dm dm;
        if ((dm = dq.a.remove(context)) != null) {
            dm.d();
        }
        if (context instanceof Activity && dq.a.isEmpty() && this.g) {
            this.g = false;
        }
    }
    
    final void a(@NonNull final Context context, @NonNull final View view, @NonNull final l l, @NonNull final a a, @NonNull final fe.m m) {
        ds ds;
        if ((ds = dq.c.get(context)) == null) {
            if (context instanceof Activity) {
                ds = new dk(dq.f, (Activity)context);
            }
            else {
                ds = new dr(dq.f, m, (byte)1);
            }
            ds.c = new ds.c() {
                @Override
                public final void a(final List<View> list, final List<View> list2) {
                    for (final View view : list) {
                        final dq.a a;
                        if ((a = dq.d.get(view)) != null) {
                            a.a(view, true);
                        }
                    }
                    for (final View view2 : list2) {
                        final dq.a a2;
                        if ((a2 = dq.d.get(view2)) != null) {
                            a2.a(view2, false);
                        }
                    }
                }
            };
            dq.c.put(context, ds);
            if (context instanceof Activity && !this.g) {
                this.g = true;
            }
        }
        final ds ds2 = ds;
        dq.d.put(view, a);
        switch (this.h) {
            case 0: {
                ds2.a(view, l, m.video.videoMinPercentagePlay);
            }
            default: {
                ds2.a(view, l, m.displayMinPercentageAnimate);
            }
        }
    }
    
    public final void a(@NonNull final Context context, final View view, @NonNull final l l) {
        final ds ds;
        if ((ds = dq.c.get(context)) != null) {
            ds.a(l);
            if (!ds.g()) {
                this.d(context);
            }
        }
        dq.d.remove(view);
    }
    
    private void d(@NonNull final Context context) {
        final ds ds;
        if ((ds = dq.c.remove(context)) != null) {
            ds.e();
        }
        if (context instanceof Activity && dq.c.isEmpty() && this.g) {
            this.g = false;
        }
    }
    
    static void b(final Context context) {
        final dm dm;
        if ((dm = dq.a.get(context)) != null) {
            dm.b();
        }
    }
    
    static void c(final Context context) {
        final dm dm;
        if ((dm = dq.a.get(context)) != null) {
            dm.a();
        }
    }
    
    static {
        b = dq.class.getSimpleName();
        a = new WeakHashMap<Context, dm>();
        c = new WeakHashMap<Context, ds>();
        d = new HashMap<View, a>();
        e = new dm.a() {
            @Override
            public final void a(final View view, final Object o) {
                ((l)o).a(view);
            }
        };
        f = new ds.a() {
            private final Rect a = new Rect();
            
            @Override
            public final boolean a(@Nullable final View view, @Nullable final View view2, final int n, @NonNull final Object o) {
                if (!(o instanceof l)) {
                    return false;
                }
                if (((l)o).j) {
                    return false;
                }
                final er mediaPlayer;
                if (view2 instanceof ex && (mediaPlayer = ((ex)view2).getMediaPlayer()) != null && 3 != mediaPlayer.a) {
                    return false;
                }
                if (view2 == null || view == null || !view2.isShown() || view.getParent() == null) {
                    return false;
                }
                if (!view2.getGlobalVisibleRect(this.a)) {
                    return false;
                }
                final long n2 = this.a.height() * (long)this.a.width();
                final long n3;
                return (n3 = view.getWidth() * (long)view.getHeight()) > 0L && 100L * n2 >= n * n3;
            }
            
            @Override
            public final boolean a(@NonNull final View view, @NonNull final View view2, final int n) {
                return true;
            }
        };
    }
    
    public interface a
    {
        void a(final View p0, final boolean p1);
    }
}
