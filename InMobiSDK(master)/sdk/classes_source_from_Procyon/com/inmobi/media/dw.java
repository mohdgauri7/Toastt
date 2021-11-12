// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.annotation.SuppressLint;
import java.util.HashMap;
import com.moat.analytics.mobile.inm.MoatAdEvent;
import com.moat.analytics.mobile.inm.MoatAdEventType;
import org.json.JSONObject;
import org.json.JSONArray;
import android.app.Application;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import androidx.annotation.Nullable;
import android.view.ViewGroup;
import android.view.View;
import java.util.Map;
import com.moat.analytics.mobile.inm.ReactiveVideoTracker;
import androidx.annotation.NonNull;
import android.content.Context;
import java.lang.ref.WeakReference;

public class dw extends df
{
    private static final String d;
    @NonNull
    private final WeakReference<Context> e;
    private ReactiveVideoTracker f;
    @NonNull
    private Map<String, Object> g;
    @NonNull
    private dg h;
    private boolean i;
    
    public dw(@NonNull final Context referent, @NonNull final dg h, @NonNull final m m, @NonNull final Map<String, Object> g) {
        super(m);
        this.i = false;
        this.e = new WeakReference<Context>(referent);
        this.h = h;
        this.g = g;
        this.f = g.get("moatTracker");
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
    public final void a(@Nullable final Map<View, FriendlyObstructionPurpose> map) {
        try {
            final Application d = gz.d();
            final fe.m viewability = super.c.viewability;
            if (d != null && super.a instanceof m && viewability.moatEnabled && this.g.get("enabled") && this.f == null) {
                this.f = dt.a(d, this.g.get("partnerCode"));
                this.g.put("moatTracker", this.f);
                this.i = true;
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
            if (!((m)super.a).l() && this.f != null) {
                this.f.stopTracking();
            }
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
        }
        finally {
            this.h.d();
        }
    }
    
    @SuppressLint({ "SwitchIntDef" })
    @Override
    public final void a(final byte b) {
        try {
            if (this.f != null) {
                this.f.hashCode();
                switch (b) {
                    case 5:
                    case 16: {
                        final ey ey;
                        if ((ey = (ey)super.a.getVideoContainerView()) != null && this.f != null) {
                            final ex videoView = ey.getVideoView();
                            if (this.i) {
                                final ReactiveVideoTracker f = this.f;
                                final HashMap<String, String> a;
                                (a = t.b.a("level", "slicer", this.g.get("clientLevels"), this.g.get("clientSlicers"), this.g.get("zMoatExtras"))).put("zMoatVASTIDs", this.g.get("zMoatVASTIDs"));
                                f.trackVideoAd((Map)a, Integer.valueOf(videoView.getDuration()), (View)ey);
                                this.i = false;
                            }
                            else {
                                this.f.changeTargetView((View)ey);
                            }
                        }
                        break;
                    }
                    case 7: {
                        this.f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_PAUSED));
                        break;
                    }
                    case 6: {
                        final ey ey2;
                        if ((ey2 = (ey)super.a.getVideoContainerView()) != null) {
                            this.f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_START, Integer.valueOf(ey2.getVideoView().getMediaPlayer().getCurrentPosition())));
                            break;
                        }
                        break;
                    }
                    case 8: {
                        this.f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_PLAYING));
                        break;
                    }
                    case 15: {
                        this.f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_SKIPPED));
                        break;
                    }
                    case 9: {
                        this.f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_FIRST_QUARTILE));
                        break;
                    }
                    case 10: {
                        this.f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_MID_POINT));
                        break;
                    }
                    case 11: {
                        this.f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_THIRD_QUARTILE));
                        break;
                    }
                    case 12: {
                        this.f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_COMPLETE));
                        break;
                    }
                    case 3: {
                        this.f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_STOPPED));
                        break;
                    }
                    case 13: {
                        this.f.setPlayerVolume(MoatAdEvent.VOLUME_MUTED);
                        break;
                    }
                    case 14: {
                        this.f.setPlayerVolume(MoatAdEvent.VOLUME_UNMUTED);
                        break;
                    }
                    case 1: {
                        this.f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_ENTER_FULLSCREEN));
                        break;
                    }
                    case 2: {
                        this.f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_EXIT_FULLSCREEN));
                        break;
                    }
                }
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
    
    static {
        d = dw.class.getSimpleName();
    }
}
