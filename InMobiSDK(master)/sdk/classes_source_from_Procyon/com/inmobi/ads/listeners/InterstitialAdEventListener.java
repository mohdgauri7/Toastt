// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.ads.listeners;

import java.util.Map;
import com.inmobi.ads.AdMetaInfo;
import com.inmobi.ads.InMobiAdRequestStatus;
import androidx.annotation.NonNull;
import com.inmobi.ads.InMobiInterstitial;
import com.inmobi.media.bi;

public abstract class InterstitialAdEventListener extends bi<InMobiInterstitial>
{
    @Deprecated
    public void onAdReceived(@NonNull final InMobiInterstitial inMobiInterstitial) {
    }
    
    public void onAdFetchFailed(@NonNull final InMobiInterstitial inMobiInterstitial, @NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
    }
    
    public void onAdWillDisplay(@NonNull final InMobiInterstitial inMobiInterstitial) {
    }
    
    @Deprecated
    public void onAdDisplayed(@NonNull final InMobiInterstitial inMobiInterstitial) {
    }
    
    public void onAdDisplayed(@NonNull final InMobiInterstitial inMobiInterstitial, @NonNull final AdMetaInfo adMetaInfo) {
    }
    
    public void onAdDisplayFailed(@NonNull final InMobiInterstitial inMobiInterstitial) {
    }
    
    public void onAdDismissed(@NonNull final InMobiInterstitial inMobiInterstitial) {
    }
    
    public void onUserLeftApplication(@NonNull final InMobiInterstitial inMobiInterstitial) {
    }
    
    public void onRewardsUnlocked(@NonNull final InMobiInterstitial inMobiInterstitial, final Map<Object, Object> map) {
    }
}
