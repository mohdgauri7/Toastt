// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.content.Context;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import java.util.Map;
import android.view.ViewGroup;
import android.view.View;
import android.webkit.WebView;
import com.iab.omid.library.inmobi.adsession.AdSessionContext;
import com.iab.omid.library.inmobi.adsession.ImpressionType;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

public class ec extends df
{
    private static final String d;
    @NonNull
    private final dg e;
    @NonNull
    private dy f;
    
    @Nullable
    public static dy a(@NonNull final String s, @Nullable final o o, final boolean b, @Nullable final String s2, final byte b2, @Nullable final String s3) {
        dy dy = null;
        final AdSessionContext a = a(o, s2, s3);
        ImpressionType impressionType = null;
        switch (b2) {
            case 1: {
                impressionType = ImpressionType.DEFINED_BY_JAVASCRIPT;
                break;
            }
            case 2: {
                impressionType = ImpressionType.UNSPECIFIED;
                break;
            }
            case 3: {
                impressionType = ImpressionType.LOADED;
                break;
            }
            case 4: {
                impressionType = ImpressionType.BEGIN_TO_RENDER;
                break;
            }
            case 5: {
                impressionType = ImpressionType.ONE_PIXEL;
                break;
            }
            case 6: {
                impressionType = ImpressionType.VIEWABLE;
                break;
            }
            case 7: {
                impressionType = ImpressionType.AUDIBLE;
                break;
            }
            default: {
                impressionType = ImpressionType.OTHER;
                break;
            }
        }
        final ImpressionType impressionType2 = impressionType;
        switch (s) {
            case "nonvideo": {
                dy = new dz("html_display_ad", impressionType2, a);
                break;
            }
            case "video": {
                dy = new dz("html_video_ad", impressionType2, a, b);
                break;
            }
        }
        return dy;
    }
    
    @Nullable
    public static AdSessionContext a(@Nullable final o o, @Nullable final String s, @Nullable final String s2) {
        AdSessionContext a = null;
        if (o != null) {
            a = ef.a.a.a(o, s, s2);
        }
        return a;
    }
    
    public ec(@NonNull final h h, @NonNull final dg e, @NonNull final dy f) {
        super(h);
        this.e = e;
        this.f = f;
    }
    
    @Nullable
    @Override
    public final View c() {
        return this.e.c();
    }
    
    @Nullable
    @Override
    public final View a(final View view, final ViewGroup viewGroup, final boolean b) {
        return this.e.a(view, viewGroup, b);
    }
    
    @Nullable
    @Override
    public final View b() {
        return this.e.b();
    }
    
    @Override
    public final void a(@Nullable final Map<View, FriendlyObstructionPurpose> map) {
        try {
            if (super.c.viewability.omidConfig.omidEnabled && ef.a.a.a()) {
                Object v = null;
                if (super.a instanceof l) {
                    v = ((l)super.a).v();
                }
                else if (this.e.b() instanceof WebView) {
                    v = this.e.b();
                }
                if (v != null) {
                    this.f.a((View)v, map, null);
                }
            }
        }
        catch (Exception ex) {}
        finally {
            this.e.a(map);
        }
    }
    
    @Override
    public final void d() {
        try {
            this.f.a();
        }
        catch (Exception ex) {}
        finally {
            this.e.d();
        }
    }
    
    @Override
    public final void a(final byte b) {
        this.e.a(b);
    }
    
    @Override
    public final void a(final Context context, final byte b) {
        this.e.a(context, b);
    }
    
    @Override
    public final void e() {
        super.e();
        try {
            this.f = null;
        }
        catch (Exception ex) {}
        finally {
            this.e.e();
        }
    }
    
    static {
        d = ec.class.getSimpleName();
    }
}
