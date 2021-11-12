// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Map;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.AdMetaInfo;
import androidx.annotation.NonNull;

public abstract class bi<T>
{
    protected bi() {
    }
    
    public void onAdFetchSuccessful(@NonNull final T t, @NonNull final AdMetaInfo adMetaInfo) {
    }
    
    @Deprecated
    public void onAdLoadSucceeded(@NonNull final T t) {
    }
    
    public void onAdLoadSucceeded(@NonNull final T t, @NonNull final AdMetaInfo adMetaInfo) {
    }
    
    public void onAdLoadFailed(@NonNull final T t, @NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
    }
    
    public void onAdClicked(@NonNull final T t, final Map<Object, Object> map) {
    }
    
    public void onRequestPayloadCreated(final byte[] array) {
    }
    
    public void onRequestPayloadCreationFailed(@NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
    }
}
