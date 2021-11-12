// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.HashMap;
import android.app.Application;
import android.view.MotionEvent;
import org.json.JSONObject;
import org.json.JSONArray;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import android.view.View;
import java.util.Map;
import com.moat.analytics.mobile.inm.NativeDisplayTracker;
import androidx.annotation.NonNull;
import android.content.Context;
import java.lang.ref.WeakReference;

public class dv extends df
{
    private final String d;
    @NonNull
    private final WeakReference<Context> e;
    private NativeDisplayTracker f;
    @NonNull
    private Map<String, Object> g;
    @NonNull
    private dg h;
    
    public dv(@NonNull final Context referent, @NonNull final dg h, @NonNull final l l, @NonNull final Map<String, Object> g) {
        super(l);
        this.d = dv.class.getSimpleName();
        this.e = new WeakReference<Context>(referent);
        this.h = h;
        this.g = g;
    }
    
    @Nullable
    @Override
    public final View c() {
        return this.h.c();
    }
    
    @Nullable
    @Override
    public final View a(final View view, final ViewGroup viewGroup, final boolean b) {
        return this.h.a(view, viewGroup, b);
    }
    
    @Nullable
    @Override
    public final View b() {
        return this.h.b();
    }
    
    @Override
    public final a a() {
        return this.h.a();
    }
    
    @Override
    public final void a(@Nullable final Map<View, FriendlyObstructionPurpose> map) {
        try {
            final View b;
            if ((b = this.h.b()) == null) {
                return;
            }
            final Application d = gz.d();
            if (super.c.viewability.moatEnabled && d != null && this.g.get("enabled")) {
                if (this.f == null) {
                    final Application application = d;
                    final String s = this.g.get("partnerCode");
                    final View view = b;
                    final HashMap<String, String> a;
                    (a = t.b.a("moatClientLevel", "moatClientSlicer", this.g.get("clientLevels"), this.g.get("clientSlicers"), this.g.get("zMoatExtras"))).put("zMoatIID", this.g.get("zMoatIID"));
                    this.f = dt.a(application, s, view, a);
                }
                b.setOnTouchListener((View.OnTouchListener)new View.OnTouchListener() {
                    public final boolean onTouch(final View view, final MotionEvent motionEvent) {
                        dv.this.f.reportUserInteractionEvent(NativeDisplayTracker.MoatUserInteractionType.TOUCH);
                        dv.this.d;
                        dv.this.f.hashCode();
                        return true;
                    }
                });
                this.f.startTracking();
                this.g.get("zMoatIID");
            }
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
        }
        finally {
            this.h.a(map);
        }
    }
    
    @Override
    public final void d() {
        try {
            if (this.f != null) {
                this.f.stopTracking();
                this.g.get("zMoatIID");
            }
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
        }
        finally {
            this.h.d();
        }
    }
    
    @Override
    public final void a(final byte b) {
        try {
            if (4 == b) {
                this.f.reportUserInteractionEvent(NativeDisplayTracker.MoatUserInteractionType.CLICK);
                this.f.hashCode();
            }
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
        }
        finally {
            this.h.a(b);
        }
    }
    
    @Override
    public final void a(final Context context, final byte b) {
        this.h.a(context, b);
    }
    
    @Override
    public final void e() {
        this.f = null;
        this.e.clear();
        super.e();
        this.h.e();
    }
}
