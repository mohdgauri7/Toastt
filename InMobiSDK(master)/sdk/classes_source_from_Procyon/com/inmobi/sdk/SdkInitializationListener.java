// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.sdk;

import androidx.annotation.UiThread;
import androidx.annotation.Nullable;
import androidx.annotation.Keep;

@Keep
public interface SdkInitializationListener
{
    public static final String INVALID_ACCOUNT_ID = "Account id cannot be empty. Please provide a valid account id.";
    public static final String INVALID_SITE_ID = "SiteId cannot be empty. Please provide a valid SiteId.";
    public static final String MISSING_REQUIRED_DEPENDENCIES = "SDK could not be initialized; Required dependency could not be found. Please check out documentation and include the required dependency.";
    public static final String UNKNOWN_ERROR = "SDK could not be initialized; an unexpected error was encountered.";
    
    @UiThread
    void onInitializationComplete(@Nullable final Error p0);
}
