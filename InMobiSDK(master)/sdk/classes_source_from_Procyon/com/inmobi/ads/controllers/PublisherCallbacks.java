// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.ads.controllers;

import java.util.Map;
import com.inmobi.ads.InMobiAdRequestStatus;
import androidx.annotation.NonNull;
import com.inmobi.ads.AdMetaInfo;
import androidx.annotation.Keep;
import androidx.annotation.UiThread;

@UiThread
@Keep
public abstract class PublisherCallbacks
{
    public static final byte NORMAL_FLOW = 0;
    public static final byte PRELOAD_FLOW = 1;
    
    public abstract byte getType();
    
    public void onAdFetchSuccessful(@NonNull final AdMetaInfo adMetaInfo) {
    }
    
    public abstract void onAdFetchFailed(@NonNull final InMobiAdRequestStatus p0);
    
    public abstract void onAdLoadSucceeded(@NonNull final AdMetaInfo p0);
    
    public abstract void onAdLoadFailed(@NonNull final InMobiAdRequestStatus p0);
    
    public void onAdWillDisplay() {
    }
    
    public abstract void onAdDisplayed(@NonNull final AdMetaInfo p0);
    
    public void onAdDisplayFailed() {
    }
    
    public abstract void onAdDismissed();
    
    public abstract void onAdClicked(@NonNull final Map<Object, Object> p0);
    
    public void onAdImpressed() {
    }
    
    public abstract void onUserLeftApplication();
    
    public void onRewardsUnlocked(@NonNull final Map<Object, Object> map) {
    }
    
    public void onVideoCompleted() {
    }
    
    public void onVideoSkipped() {
    }
    
    public void onAudioStateChanged(final boolean b) {
    }
    
    public abstract void onRequestPayloadCreated(final byte[] p0);
    
    public abstract void onRequestPayloadCreationFailed(final InMobiAdRequestStatus p0);
}
