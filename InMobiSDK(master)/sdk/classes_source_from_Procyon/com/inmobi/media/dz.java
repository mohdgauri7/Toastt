// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Iterator;
import android.view.ViewGroup;
import com.iab.omid.library.inmobi.adsession.AdSessionConfiguration;
import com.iab.omid.library.inmobi.adsession.CreativeType;
import com.iab.omid.library.inmobi.adsession.Owner;
import java.util.Map;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import android.view.View;
import com.iab.omid.library.inmobi.adsession.media.InteractionType;
import com.iab.omid.library.inmobi.adsession.media.PlayerState;
import com.iab.omid.library.inmobi.adsession.ErrorType;
import com.iab.omid.library.inmobi.adsession.media.VastProperties;
import androidx.annotation.Nullable;
import com.iab.omid.library.inmobi.adsession.AdSession;
import androidx.annotation.NonNull;
import com.iab.omid.library.inmobi.adsession.ImpressionType;
import com.iab.omid.library.inmobi.adsession.AdSessionContext;

public final class dz implements dy
{
    private AdSessionContext a;
    private final boolean b;
    private String c;
    @NonNull
    private ImpressionType d;
    private byte e;
    private AdSession f;
    private dx g;
    
    public dz(final String s, final ImpressionType impressionType, @Nullable final AdSessionContext adSessionContext) {
        this(s, impressionType, adSessionContext, false);
    }
    
    public dz(final String c, final ImpressionType d, @Nullable final AdSessionContext a, final boolean b) {
        this.e = 0;
        this.c = c;
        this.d = d;
        this.a = a;
        this.b = b;
    }
    
    private static boolean a(final byte i, final byte j) {
        if (i == j) {
            return true;
        }
        fv.a().a(new gv(new Exception("Omid AdSession State Error currentState :: " + i + ", expectedState :: " + j)));
        return false;
    }
    
    @Override
    public final void a(final int n, final int n2, final float n3, final VastProperties vastProperties) {
        if (a(this.e, (byte)2)) {
            switch (n) {
                case 17: {
                    final ErrorType video = ErrorType.VIDEO;
                    final String s = "Unknown Player error";
                    final ErrorType errorType = video;
                    if (a(this.e, (byte)2)) {
                        this.f.error(errorType, s);
                    }
                    break;
                }
                case 0: {
                    this.g.a();
                    break;
                }
            }
            final dx g;
            if ((g = this.g).b != null) {
                switch (n) {
                    case 7: {
                        g.b.pause();
                    }
                    case 5: {
                        g.a.loaded(vastProperties);
                    }
                    case 6: {
                        g.b.start((float)n2, n3);
                    }
                    case 8:
                    case 16: {
                        g.b.resume();
                    }
                    case 15: {
                        g.b.skipped();
                    }
                    case 9: {
                        g.b.firstQuartile();
                    }
                    case 10: {
                        g.b.midpoint();
                    }
                    case 11: {
                        g.b.thirdQuartile();
                    }
                    case 12: {
                        g.b.complete();
                    }
                    case 13:
                    case 14: {
                        g.b.volumeChange((13 == n) ? 0.0f : n3);
                    }
                    case 1: {
                        g.b.playerStateChange(PlayerState.FULLSCREEN);
                    }
                    case 2: {
                        g.b.playerStateChange(PlayerState.NORMAL);
                    }
                    case 4: {
                        g.b.adUserInteraction(InteractionType.CLICK);
                    }
                    case 18: {
                        g.b.adUserInteraction(InteractionType.INVITATION_ACCEPTED);
                        break;
                    }
                }
            }
        }
    }
    
    @Override
    public final void a(final int n) {
        if (a(this.e, (byte)2)) {
            switch (n) {
                case 0: {
                    this.g.a();
                }
                case 19: {
                    final dx g;
                    if ((g = this.g).a == null) {
                        return;
                    }
                    g.a.loaded();
                    break;
                }
            }
        }
    }
    
    private void a(final View view, final FriendlyObstructionPurpose friendlyObstructionPurpose) {
        if (a(this.e, (byte)1)) {
            this.f.addFriendlyObstruction(view, friendlyObstructionPurpose, (String)null);
        }
    }
    
    @Override
    public final void a() {
        this.f.getAdSessionId();
        if (a(this.e, (byte)2)) {
            this.f.finish();
            this.f = null;
            this.e = 3;
        }
    }
    
    @Override
    public final void a(final View view, @Nullable final Map<View, FriendlyObstructionPurpose> map, @Nullable final View view2) {
        if (this.f == null) {
            final boolean b = this.b;
            Owner owner = Owner.JAVASCRIPT;
            Owner owner2 = null;
            CreativeType creativeType = CreativeType.DEFINED_BY_JAVASCRIPT;
            final String c = this.c;
            switch (c) {
                case "native_video_ad": {
                    owner = Owner.NATIVE;
                    owner2 = Owner.NATIVE;
                    creativeType = CreativeType.VIDEO;
                    break;
                }
                case "native_display_ad": {
                    owner = Owner.NATIVE;
                    owner2 = Owner.NONE;
                    creativeType = CreativeType.NATIVE_DISPLAY;
                    break;
                }
                case "html_video_ad": {
                    owner = Owner.JAVASCRIPT;
                    owner2 = Owner.JAVASCRIPT;
                    creativeType = CreativeType.VIDEO;
                    break;
                }
                case "html_display_ad": {
                    owner = Owner.JAVASCRIPT;
                    owner2 = Owner.NONE;
                    creativeType = CreativeType.HTML_DISPLAY;
                    break;
                }
            }
            this.f = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(creativeType, this.d, owner, owner2, b), this.a);
            this.g = new dx(this.f, this.c);
            this.e = 1;
        }
        if (a(this.e, (byte)1)) {
            this.f.registerAdView(view);
        }
        if (map != null) {
            for (final Map.Entry<View, FriendlyObstructionPurpose> entry : map.entrySet()) {
                this.a(entry.getKey(), entry.getValue());
            }
        }
        if (view2 != null && view != null && view2 instanceof ViewGroup) {
            this.a(view, map, (ViewGroup)view2);
        }
        if (a(this.e, (byte)1)) {
            this.f.start();
            this.e = 2;
        }
        this.f.getAdSessionId();
    }
    
    @Override
    public final void a(@Nullable final AdSessionContext a) {
        if (a == null) {
            return;
        }
        this.a = a;
    }
    
    private void a(final View obj, final Map<View, FriendlyObstructionPurpose> map, final ViewGroup viewGroup) {
        for (int childCount = viewGroup.getChildCount(), i = 0; i < childCount; ++i) {
            final View child;
            if (!(child = viewGroup.getChildAt(i)).equals(obj)) {
                if (map == null || !map.containsKey(child)) {
                    this.a(child, FriendlyObstructionPurpose.OTHER);
                }
                if (child instanceof ViewGroup && ((ViewGroup)child).getChildCount() > 0) {
                    this.a(obj, map, (ViewGroup)child);
                }
            }
        }
    }
}
