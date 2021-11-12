// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.HashMap;
import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONObject;
import java.util.Map;
import java.util.List;

public final class bw extends bj
{
    List<bj> z;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int E;
    public int F;
    private boolean H;
    public Map<String, Object> G;
    
    public bw(final String s, final String s2, final bk bk, final dd e, final boolean a, final boolean b, final boolean c, final boolean d, final boolean b2, final List<bv> list, final JSONObject f, final boolean h) {
        super(s, s2, "VIDEO", bk);
        this.e = e;
        this.i = 2;
        this.A = a;
        this.B = b;
        this.C = c;
        this.D = d;
        this.z = new ArrayList<bj>();
        this.H = h;
        if (e != null) {
            this.r = e.a();
            final List<bv> d2 = e.d();
            Map<String, String> e2 = null;
            if (list != null) {
                for (final bv bv : list) {
                    if ("OMID_VIEWABILITY".equals(bv.d)) {
                        e2 = bv.e;
                        if (TextUtils.isEmpty((CharSequence)bv.b)) {
                            continue;
                        }
                        d2.add(bv);
                    }
                    else {
                        d2.add(bv);
                    }
                }
            }
            for (final bv bv2 : d2) {
                if ("OMID_VIEWABILITY".equals(bv2.d)) {
                    bv2.e = e2;
                }
            }
            if (!d2.isEmpty()) {
                this.a(d2);
            }
        }
        if (f != null) {
            this.f = f;
        }
        this.v.put("placementType", 0);
        this.v.put("lastVisibleTimestamp", Integer.MIN_VALUE);
        this.v.put("visible", Boolean.FALSE);
        this.v.put("seekPosition", 0);
        this.v.put("didStartPlaying", Boolean.FALSE);
        this.v.put("didPause", Boolean.FALSE);
        this.v.put("didCompleteQ1", Boolean.FALSE);
        this.v.put("didCompleteQ2", Boolean.FALSE);
        this.v.put("didCompleteQ3", Boolean.FALSE);
        this.v.put("didCompleteQ4", Boolean.FALSE);
        this.v.put("didRequestFullScreen", Boolean.FALSE);
        this.v.put("isFullScreen", Boolean.FALSE);
        this.v.put("didImpressionFire", Boolean.FALSE);
        this.v.put("mapViewabilityParams", new HashMap());
        this.v.put("didSignalVideoCompleted", Boolean.FALSE);
        this.v.put("shouldAutoPlay", b2);
        this.v.put("lastMediaVolume", 0);
        this.v.put("currentMediaVolume", 0);
        this.v.put("didQ4Fire", Boolean.FALSE);
    }
    
    public final boolean a() {
        if (this.H) {
            return this.A && !gz.e();
        }
        return this.A;
    }
    
    public final dd b() {
        if (super.e == null) {
            return null;
        }
        return (dd)super.e;
    }
    
    public final void a(final bw bw) {
        this.v.putAll(bw.v);
        this.G.putAll(bw.G);
        this.u = bw.u;
    }
    
    static final class a extends bk
    {
        public a(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, @Nullable final bs bs) {
            super(n, n2, n3, n4, n5, n6, n7, n8, "none", "straight", "#ff000000", "#00000000", bs);
        }
    }
}
