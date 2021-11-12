// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.ads.listeners;

import com.inmobi.ads.InMobiAdRequestStatus;
import androidx.annotation.NonNull;
import com.inmobi.ads.InMobiNative;
import com.inmobi.media.bi;

public abstract class NativeAdEventListener extends bi<InMobiNative>
{
    @Deprecated
    public void onAdReceived(@NonNull final InMobiNative inMobiNative) {
    }
    
    public void onAdFullScreenDismissed(@NonNull final InMobiNative inMobiNative) {
    }
    
    public void onAdFullScreenWillDisplay(@NonNull final InMobiNative inMobiNative) {
    }
    
    public void onAdFullScreenDisplayed(@NonNull final InMobiNative inMobiNative) {
    }
    
    public void onUserWillLeaveApplication(@NonNull final InMobiNative inMobiNative) {
    }
    
    public void onAdImpressed(@NonNull final InMobiNative inMobiNative) {
    }
    
    public void onAdClicked(@NonNull final InMobiNative inMobiNative) {
    }
    
    public void onAdStatusChanged(@NonNull final InMobiNative inMobiNative) {
    }
}
