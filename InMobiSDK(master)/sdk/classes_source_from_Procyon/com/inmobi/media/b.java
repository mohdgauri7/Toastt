// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Map;
import android.view.animation.Animation;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import com.inmobi.ads.InMobiAdRequestStatus;
import androidx.annotation.CallSuper;
import com.inmobi.ads.AdMetaInfo;
import androidx.annotation.NonNull;
import com.inmobi.ads.InMobiBanner;
import java.lang.ref.WeakReference;
import com.inmobi.ads.controllers.PublisherCallbacks;

public class b extends PublisherCallbacks
{
    protected WeakReference<InMobiBanner> a;
    
    public b(@NonNull final InMobiBanner referent) {
        this.a = new WeakReference<InMobiBanner>(referent);
    }
    
    @Override
    public byte getType() {
        return 1;
    }
    
    @CallSuper
    @Override
    public void onAdFetchSuccessful(@NonNull final AdMetaInfo adMetaInfo) {
        final InMobiBanner inMobiBanner;
        if ((inMobiBanner = this.a.get()) != null && inMobiBanner.b != null) {
            inMobiBanner.b.onAdFetchSuccessful(inMobiBanner, adMetaInfo);
        }
    }
    
    @Override
    public void onAdFetchFailed(@NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
        final InMobiBanner inMobiBanner;
        if ((inMobiBanner = this.a.get()) != null && inMobiBanner.b != null) {
            inMobiBanner.b.onAdFetchFailed(inMobiBanner, inMobiAdRequestStatus);
        }
    }
    
    @Override
    public void onAdLoadSucceeded(@NonNull final AdMetaInfo adMetaInfo) {
        final InMobiBanner inMobiBanner;
        if ((inMobiBanner = this.a.get()) != null && !inMobiBanner.c.t() && inMobiBanner.c.b(inMobiBanner)) {
            final InMobiBanner inMobiBanner2;
            (inMobiBanner2 = inMobiBanner).c.p();
            try {
                final InMobiBanner.AnimationType d = inMobiBanner2.d;
                final float n = (float)inMobiBanner2.getWidth();
                final float n2 = (float)inMobiBanner2.getHeight();
                final float n3 = n;
                final InMobiBanner.AnimationType animationType = d;
                Object o = null;
                if (animationType == InMobiBanner.AnimationType.ANIMATION_ALPHA) {
                    final AlphaAnimation alphaAnimation;
                    (alphaAnimation = new AlphaAnimation(0.0f, 0.5f)).setDuration(1000L);
                    alphaAnimation.setFillAfter(false);
                    alphaAnimation.setInterpolator((Interpolator)new DecelerateInterpolator());
                    o = alphaAnimation;
                }
                else if (animationType == InMobiBanner.AnimationType.ROTATE_HORIZONTAL_AXIS) {
                    final a.a a;
                    (a = new a.a(n3 / 2.0f, n2 / 2.0f)).setDuration(500L);
                    a.setFillAfter(false);
                    a.setInterpolator((Interpolator)new AccelerateInterpolator());
                    o = a;
                }
                else if (animationType == InMobiBanner.AnimationType.ROTATE_VERTICAL_AXIS) {
                    final a.b b;
                    (b = new a.b(n3 / 2.0f, n2 / 2.0f)).setDuration(500L);
                    b.setFillAfter(false);
                    b.setInterpolator((Interpolator)new AccelerateInterpolator());
                    o = b;
                }
                final Object o2 = o;
                inMobiBanner2.c.a(inMobiBanner2);
                if (o2 != null) {
                    inMobiBanner2.startAnimation((Animation)o2);
                }
            }
            catch (Exception ex) {
                hf.a((byte)1, InMobiBanner.a, "Unexpected error while displaying Banner Ad.");
            }
            if (inMobiBanner.b != null) {
                inMobiBanner.b.onAdLoadSucceeded(inMobiBanner);
            }
            if (inMobiBanner.b != null) {
                inMobiBanner.b.onAdLoadSucceeded(inMobiBanner, adMetaInfo);
            }
            inMobiBanner.b();
        }
    }
    
    @Override
    public void onAdLoadFailed(@NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
        final InMobiBanner inMobiBanner;
        if ((inMobiBanner = this.a.get()) == null) {
            return;
        }
        if (inMobiBanner.b != null) {
            inMobiBanner.b.onAdLoadFailed(inMobiBanner, inMobiAdRequestStatus);
        }
        inMobiBanner.b();
    }
    
    @Override
    public void onAdDisplayed(@NonNull final AdMetaInfo adMetaInfo) {
        final InMobiBanner inMobiBanner;
        if ((inMobiBanner = this.a.get()) != null && inMobiBanner.b != null) {
            inMobiBanner.b.onAdDisplayed(inMobiBanner);
        }
    }
    
    @Override
    public void onAdDismissed() {
        final InMobiBanner inMobiBanner;
        if ((inMobiBanner = this.a.get()) == null) {
            return;
        }
        if (inMobiBanner.b != null) {
            inMobiBanner.b.onAdDismissed(inMobiBanner);
        }
        inMobiBanner.b();
    }
    
    @Override
    public void onAdClicked(@NonNull final Map<Object, Object> map) {
        final InMobiBanner inMobiBanner;
        if ((inMobiBanner = this.a.get()) != null && inMobiBanner.b != null) {
            inMobiBanner.b.onAdClicked(inMobiBanner, map);
        }
    }
    
    @Override
    public void onUserLeftApplication() {
        final InMobiBanner inMobiBanner;
        if ((inMobiBanner = this.a.get()) != null && inMobiBanner.b != null) {
            inMobiBanner.b.onUserLeftApplication(inMobiBanner);
        }
    }
    
    @Override
    public void onRewardsUnlocked(@NonNull final Map<Object, Object> map) {
        final InMobiBanner inMobiBanner;
        if ((inMobiBanner = this.a.get()) != null && inMobiBanner.b != null) {
            inMobiBanner.b.onRewardsUnlocked(inMobiBanner, map);
        }
    }
    
    @Override
    public void onRequestPayloadCreated(final byte[] array) {
        final InMobiBanner inMobiBanner;
        if ((inMobiBanner = this.a.get()) != null && inMobiBanner.b != null) {
            inMobiBanner.b.onRequestPayloadCreated(array);
        }
    }
    
    @Override
    public void onRequestPayloadCreationFailed(final InMobiAdRequestStatus inMobiAdRequestStatus) {
        final InMobiBanner inMobiBanner;
        if ((inMobiBanner = this.a.get()) != null && inMobiBanner.b != null) {
            inMobiBanner.b.onRequestPayloadCreationFailed(inMobiAdRequestStatus);
        }
    }
}
