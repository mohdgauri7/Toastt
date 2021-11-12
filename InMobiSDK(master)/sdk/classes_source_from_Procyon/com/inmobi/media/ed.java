// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.content.Context;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import java.util.Map;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import android.view.View;
import com.iab.omid.library.inmobi.adsession.ImpressionType;
import com.iab.omid.library.inmobi.adsession.VerificationScriptResource;
import java.util.List;
import androidx.annotation.NonNull;

public class ed extends df
{
    private static final String d;
    @NonNull
    private final dg e;
    @NonNull
    private dy f;
    
    @NonNull
    public static dy a(@NonNull final List<VerificationScriptResource> list, final String s, final String s2) {
        return new dz("native_display_ad", ImpressionType.VIEWABLE, ef.a.a.a(list, s, s2));
    }
    
    public ed(@NonNull final h h, @NonNull final dg e, @NonNull final dy f) {
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
                final View i;
                if (super.a instanceof l && (i = ((l)super.a).i()) != null) {
                    this.f.a(i, map, this.e.b());
                }
                this.a((byte)19);
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
        try {
            this.f.a(b);
        }
        catch (Exception ex) {}
        finally {
            this.e.a(b);
        }
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
        d = ed.class.getSimpleName();
    }
}
