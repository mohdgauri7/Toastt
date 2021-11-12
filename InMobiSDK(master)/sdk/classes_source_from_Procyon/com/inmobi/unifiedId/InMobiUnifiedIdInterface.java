// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.unifiedId;

import androidx.annotation.UiThread;
import androidx.annotation.Nullable;
import org.json.JSONObject;

public interface InMobiUnifiedIdInterface
{
    public static final String NETWORK_FAILURE_AND_NO_LOCAL_DATA_PRESENT = "Fetching the unifiedIds from ID Service has failed and there are no unified ids present in cache";
    public static final String UNIFIED_SERVICE_IS_NOT_ENABLED = "UnifiedId Service not enabled, please connect with your respective partner manager";
    public static final String USER_HAS_OPTED_OUT = "User has opted out for tracking";
    public static final String PUSH_NEEDS_TO_BE_CALLED_FIRST = "Push api needs to called prior to fetch";
    public static final String NO_LOCAL_DATA_PRESENT = "No local data present";
    
    @UiThread
    void onFetchCompleted(@Nullable final JSONObject p0, @Nullable final Error p1);
}
