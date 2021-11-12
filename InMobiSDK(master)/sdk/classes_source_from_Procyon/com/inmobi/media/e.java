// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Map;
import com.inmobi.ads.InMobiAdRequestStatus;
import androidx.annotation.CallSuper;
import com.inmobi.ads.AdMetaInfo;
import androidx.annotation.NonNull;
import com.inmobi.ads.InMobiInterstitial;
import java.lang.ref.WeakReference;
import com.inmobi.ads.controllers.PublisherCallbacks;

public class e extends PublisherCallbacks
{
    protected WeakReference<InMobiInterstitial> a;
    
    public e(@NonNull final InMobiInterstitial referent) {
        this.a = new WeakReference<InMobiInterstitial>(referent);
    }
    
    @Override
    public byte getType() {
        return 1;
    }
    
    @CallSuper
    @Override
    public void onAdFetchSuccessful(@NonNull final AdMetaInfo adMetaInfo) {
        final InMobiInterstitial inMobiInterstitial;
        if ((inMobiInterstitial = this.a.get()) != null && inMobiInterstitial.a != null) {
            inMobiInterstitial.a.onAdReceived(inMobiInterstitial);
        }
        if (inMobiInterstitial != null && inMobiInterstitial.a != null) {
            inMobiInterstitial.a.onAdFetchSuccessful(inMobiInterstitial, adMetaInfo);
        }
    }
    
    @Override
    public void onAdFetchFailed(@NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
        final InMobiInterstitial inMobiInterstitial;
        if ((inMobiInterstitial = this.a.get()) != null && inMobiInterstitial.a != null) {
            inMobiInterstitial.a.onAdFetchFailed(inMobiInterstitial, inMobiAdRequestStatus);
        }
    }
    
    @Override
    public void onAdLoadSucceeded(@NonNull final AdMetaInfo adMetaInfo) {
        final InMobiInterstitial inMobiInterstitial;
        if ((inMobiInterstitial = this.a.get()) != null && inMobiInterstitial.a != null) {
            inMobiInterstitial.a.onAdLoadSucceeded(inMobiInterstitial);
        }
        if (inMobiInterstitial != null && inMobiInterstitial.a != null) {
            inMobiInterstitial.a.onAdLoadSucceeded(inMobiInterstitial, adMetaInfo);
        }
    }
    
    @Override
    public void onAdLoadFailed(@NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
        final InMobiInterstitial inMobiInterstitial;
        if ((inMobiInterstitial = this.a.get()) != null && inMobiInterstitial.a != null) {
            inMobiInterstitial.a.onAdLoadFailed(inMobiInterstitial, inMobiAdRequestStatus);
        }
    }
    
    @Override
    public void onAdWillDisplay() {
        final InMobiInterstitial inMobiInterstitial;
        if ((inMobiInterstitial = this.a.get()) != null && inMobiInterstitial.a != null) {
            inMobiInterstitial.a.onAdWillDisplay(inMobiInterstitial);
        }
    }
    
    @Override
    public void onAdDisplayFailed() {
        final InMobiInterstitial inMobiInterstitial;
        if ((inMobiInterstitial = this.a.get()) != null && inMobiInterstitial.a != null) {
            inMobiInterstitial.a.onAdDisplayFailed(inMobiInterstitial);
        }
    }
    
    @Override
    public void onAdDisplayed(@NonNull final AdMetaInfo adMetaInfo) {
        final InMobiInterstitial inMobiInterstitial;
        if ((inMobiInterstitial = this.a.get()) != null && inMobiInterstitial.a != null) {
            inMobiInterstitial.a.onAdDisplayed(inMobiInterstitial);
        }
        if (inMobiInterstitial != null && inMobiInterstitial.a != null) {
            inMobiInterstitial.a.onAdDisplayed(inMobiInterstitial, adMetaInfo);
        }
    }
    
    @Override
    public void onAdDismissed() {
        final InMobiInterstitial inMobiInterstitial;
        if ((inMobiInterstitial = this.a.get()) != null && inMobiInterstitial.a != null) {
            inMobiInterstitial.a.onAdDismissed(inMobiInterstitial);
        }
    }
    
    @Override
    public void onAdClicked(@NonNull final Map<Object, Object> map) {
        final InMobiInterstitial inMobiInterstitial;
        if ((inMobiInterstitial = this.a.get()) != null && inMobiInterstitial.a != null) {
            inMobiInterstitial.a.onAdClicked(inMobiInterstitial, map);
        }
    }
    
    @Override
    public void onRewardsUnlocked(@NonNull final Map<Object, Object> map) {
        final InMobiInterstitial inMobiInterstitial;
        if ((inMobiInterstitial = this.a.get()) != null && inMobiInterstitial.a != null) {
            inMobiInterstitial.a.onRewardsUnlocked(inMobiInterstitial, map);
        }
    }
    
    @Override
    public void onUserLeftApplication() {
        final InMobiInterstitial inMobiInterstitial;
        if ((inMobiInterstitial = this.a.get()) != null && inMobiInterstitial.a != null) {
            inMobiInterstitial.a.onUserLeftApplication(inMobiInterstitial);
        }
    }
    
    @Override
    public void onRequestPayloadCreated(final byte[] array) {
        final InMobiInterstitial inMobiInterstitial;
        if ((inMobiInterstitial = this.a.get()) != null && inMobiInterstitial.a != null) {
            inMobiInterstitial.a.onRequestPayloadCreated(array);
        }
    }
    
    @Override
    public void onRequestPayloadCreationFailed(final InMobiAdRequestStatus inMobiAdRequestStatus) {
        final InMobiInterstitial inMobiInterstitial;
        if ((inMobiInterstitial = this.a.get()) != null && inMobiInterstitial.a != null) {
            inMobiInterstitial.a.onRequestPayloadCreationFailed(inMobiAdRequestStatus);
        }
    }
}
