// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.view.ViewGroup;
import android.view.View;
import android.content.Context;
import androidx.annotation.NonNull;

public class ep extends dg.a implements eq.b
{
    private static final String c;
    @NonNull
    public final eq b;
    @NonNull
    private final l d;
    
    public ep(@NonNull final Context context, @NonNull final fe fe, @NonNull final l d, @NonNull final bn bn) {
        this.d = d;
        this.b = new eq(context, fe, this.d, bn, new eq.c() {
            @Override
            public final void a(final int n, final bj bj) {
                if (((dg.a)ep.this).a) {
                    return;
                }
                ep.this.d.a(n, bj);
            }
        }, new eq.a() {
            @Override
            public final void a(final View view, final bj bj) {
                if (((dg.a)ep.this).a) {
                    return;
                }
                ep.this.d.a(view, bj);
                ep.this.d.a(bj, false);
            }
        }, this);
        ez.a(d.q);
    }
    
    @Override
    public final View a(View viewWithTag, final ViewGroup viewGroup, final boolean b, final o o) {
        es es;
        if (viewWithTag == null) {
            es = (b ? this.b.b(null, viewGroup, o) : this.b.a(null, viewGroup, o));
        }
        else if ((viewWithTag = viewWithTag.findViewWithTag((Object)"InMobiAdView")) != null) {
            final es es2 = (es)viewWithTag;
            es = (b ? this.b.b(es2, viewGroup, o) : this.b.a(es2, viewGroup, o));
        }
        else {
            es = (b ? this.b.b(null, viewGroup, o) : this.b.a(null, viewGroup, o));
        }
        es.setNativeStrandAd(this.d);
        es.setTag((Object)"InMobiAdView");
        return (View)es;
    }
    
    @Override
    public final void a() {
        this.b.a();
        super.a();
    }
    
    @Override
    public final void a(final bt bt) {
        if (bt.k == 1) {
            this.d.b();
        }
    }
    
    static {
        c = ep.class.getSimpleName();
    }
}
