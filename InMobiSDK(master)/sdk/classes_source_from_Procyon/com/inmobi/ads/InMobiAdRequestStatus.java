// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.ads;

public final class InMobiAdRequestStatus
{
    private static final String a;
    private StatusCode b;
    private String c;
    
    public InMobiAdRequestStatus(final StatusCode b) {
        this.b = b;
        switch (InMobiAdRequestStatus$1.a[this.b.ordinal()]) {
            case 1: {
                this.c = "The InMobi SDK encountered an internal error.";
            }
            case 2: {
                this.c = "The Internet is unreachable. Please check your Internet connection.";
            }
            case 3: {
                this.c = "An invalid ad request was sent and was rejected by the Ad Network. Please validate the ad request and try again";
            }
            case 4: {
                this.c = "The SDK is pending response to a previous ad request. Please wait for the previous ad request to complete before requesting for another ad.";
            }
            case 5: {
                this.c = "The Ad Request timed out waiting for a response from the network. This can be caused due to a bad network connection. Please try again after a few minutes.";
            }
            case 6: {
                this.c = "The Ad Server encountered an error when processing the ad request. This may be a transient issue. Please try again in a few minutes";
            }
            case 7: {
                this.c = "Ad request successful but no ad served.";
            }
            case 8: {
                this.c = "The Ad Request could not be submitted as the user is viewing another Ad.";
            }
            case 9: {
                this.c = "The Ad Request cannot be done so frequently. Please wait for some time before loading another ad.";
            }
            case 10: {
                this.c = "An ad is no longer available. Please call load() to fetch a fresh ad.";
            }
            case 11: {
                this.c = "The SDK rejected the ad request as one or more required dependencies could not be found. Please ensure you have included the required dependencies.";
            }
            case 12: {
                this.c = "The SDK rejected the ad load request. Multiple load() call on the same object is not allowed if the previous ad request was successful.";
            }
            case 13: {
                this.c = "Network Request dropped as current request is not GDPR compliant.";
            }
            case 14: {
                this.c = "An ad load is already in progress, getSignals() call in this state is not allowed.";
            }
            case 15: {
                this.c = "An ad load is already in progress, load(response) call in this state is not allowed.";
            }
            case 16: {
                this.c = "Null or empty response as parameter is not allowed in load(response).";
            }
            case 17: {
                this.c = "The Ad Request is terminated because monetization is disabled.";
            }
            case 18: {
                this.c = "An API call is made from non-ui thread.";
            }
            case 19: {
                this.c = "InMobi Ad Object is not configured properly Please check if setBannerSize(int widthInDp, int heightInDp) or setLayoutParams(<Layout_Params>) have been configured correctly";
            }
            case 20: {
                this.c = "The app is running low on memory, hence resulting in failure";
                break;
            }
        }
    }
    
    public final InMobiAdRequestStatus setCustomMessage(final String c) {
        if (c != null) {
            this.c = c;
        }
        return this;
    }
    
    public final StatusCode getStatusCode() {
        return this.b;
    }
    
    public final String getMessage() {
        return this.c;
    }
    
    static {
        a = InMobiAdRequestStatus.class.getSimpleName();
    }
    
    public enum StatusCode
    {
        NO_ERROR, 
        NETWORK_UNREACHABLE, 
        NO_FILL, 
        REQUEST_INVALID, 
        REQUEST_PENDING, 
        REQUEST_TIMED_OUT, 
        INTERNAL_ERROR, 
        SERVER_ERROR, 
        AD_ACTIVE, 
        EARLY_REFRESH_REQUEST, 
        AD_NO_LONGER_AVAILABLE, 
        MISSING_REQUIRED_DEPENDENCIES, 
        REPETITIVE_LOAD, 
        GDPR_COMPLIANCE_ENFORCED, 
        GET_SIGNALS_CALLED_WHILE_LOADING, 
        LOAD_WITH_RESPONSE_CALLED_WHILE_LOADING, 
        INVALID_RESPONSE_IN_LOAD, 
        MONETIZATION_DISABLED, 
        CALLED_FROM_WRONG_THREAD, 
        CONFIGURATION_ERROR, 
        LOW_MEMORY;
    }
}
