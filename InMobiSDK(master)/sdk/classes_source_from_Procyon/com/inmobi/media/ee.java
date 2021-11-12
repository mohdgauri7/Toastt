// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.annotation.SuppressLint;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import java.util.Map;
import android.view.ViewGroup;
import com.iab.omid.library.inmobi.adsession.ImpressionType;
import com.iab.omid.library.inmobi.adsession.VerificationScriptResource;
import java.util.List;
import androidx.annotation.Nullable;
import android.view.View;
import androidx.annotation.NonNull;
import android.content.Context;
import java.lang.ref.WeakReference;
import com.iab.omid.library.inmobi.adsession.media.VastProperties;

public class ee extends df
{
    private static final String d;
    private final VastProperties e;
    @NonNull
    private final WeakReference<Context> f;
    @NonNull
    private final dg g;
    @NonNull
    private dy h;
    @Nullable
    private WeakReference<View> i;
    
    @NonNull
    public static dy a(@NonNull final List<VerificationScriptResource> list, final String s, final String s2) {
        return new dz("native_video_ad", ImpressionType.VIEWABLE, ef.a.a.a(list, s2, s));
    }
    
    public ee(@NonNull final Context referent, @NonNull final dg g, @NonNull final m m, @NonNull final dy h, final VastProperties e) {
        super(m);
        this.f = new WeakReference<Context>(referent);
        this.g = g;
        this.h = h;
        this.e = e;
    }
    
    @Nullable
    @Override
    public final View c() {
        return this.g.c();
    }
    
    @Nullable
    @Override
    public final View a(final View view, final ViewGroup viewGroup, final boolean b) {
        return this.g.a(view, viewGroup, b);
    }
    
    @Nullable
    @Override
    public final View b() {
        return this.g.b();
    }
    
    @Override
    public final a a() {
        return this.g.a();
    }
    
    @Override
    public final void a(@Nullable final Map<View, FriendlyObstructionPurpose> map) {
        try {
            final ey referent;
            if (super.c.viewability.omidConfig.omidEnabled && ef.a.a.a() && super.a instanceof m && (referent = (ey)super.a.getVideoContainerView()) != null) {
                final ew mediaController = referent.getVideoView().getMediaController();
                this.i = new WeakReference<View>((View)referent);
                this.h.a(this.i.get(), (mediaController != null) ? mediaController.getFriendlyViews() : null, this.g.b());
                this.h.hashCode();
            }
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
        }
        finally {
            this.g.a(map);
        }
    }
    
    @Override
    public final void d() {
        try {
            if (!((m)super.a).l()) {
                this.h.a();
                this.h.hashCode();
            }
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
        }
        finally {
            this.g.d();
        }
    }
    
    @SuppressLint({ "SwitchIntDef" })
    @Override
    public final void a(final byte b) {
        try {
            int duration = 0;
            float n = 1.0f;
            switch (b) {
                case 13: {
                    n = 0.0f;
                    break;
                }
                case 14: {
                    n = 1.0f;
                    break;
                }
                case 6: {
                    if (super.a instanceof m) {
                        final ey ey;
                        if ((ey = (ey)super.a.getVideoContainerView()) != null) {
                            duration = ey.getVideoView().getDuration();
                            final bw bw;
                            if ((int)(bw = (bw)ey.getVideoView().getTag()).v.get("currentMediaVolume") > 0 && 0 == (int)bw.v.get("lastMediaVolume")) {
                                n = 1.0f;
                            }
                            else {
                                n = 0.0f;
                            }
                        }
                        break;
                    }
                    break;
                }
                case 5: {
                    if (super.a instanceof m && ((m)super.a).l()) {
                        return;
                    }
                    break;
                }
            }
            this.h.a(b, duration, n, this.e);
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
        }
        finally {
            this.g.a(b);
        }
    }
    
    @Override
    public final void a(final Context context, final byte b) {
        this.g.a(context, b);
    }
    
    @Override
    public final void e() {
        super.e();
        try {
            this.f.clear();
            if (this.i != null) {
                this.i.clear();
            }
            this.h = null;
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
        }
        finally {
            this.g.e();
        }
    }
    
    static {
        d = ee.class.getSimpleName();
    }
}
