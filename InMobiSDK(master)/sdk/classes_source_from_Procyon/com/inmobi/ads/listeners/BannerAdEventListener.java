// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.ads.listeners;

import java.util.Map;
import com.inmobi.ads.InMobiAdRequestStatus;
import androidx.annotation.NonNull;
import com.inmobi.ads.InMobiBanner;
import com.inmobi.media.bi;

public abstract class BannerAdEventListener extends bi<InMobiBanner>
{
    public void onAdFetchFailed(@NonNull final InMobiBanner inMobiBanner, @NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
    }
    
    public void onAdDisplayed(@NonNull final InMobiBanner inMobiBanner) {
    }
    
    public void onAdDismissed(@NonNull final InMobiBanner inMobiBanner) {
    }
    
    public void onUserLeftApplication(@NonNull final InMobiBanner inMobiBanner) {
    }
    
    public void onRewardsUnlocked(@NonNull final InMobiBanner inMobiBanner, final Map<Object, Object> map) {
    }
}
