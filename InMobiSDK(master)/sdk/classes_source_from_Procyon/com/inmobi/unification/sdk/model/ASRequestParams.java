// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.unification.sdk.model;

public final class ASRequestParams
{
    public String a;
    public String b;
    public String c;
    public boolean d;
    
    public static class Builder
    {
        private String pubKeys;
        private String a9Params;
        private String vcUserId;
        private boolean hasDynamicMediation;
        
        public Builder setPubKeys(final String pubKeys) {
            this.pubKeys = pubKeys;
            return this;
        }
        
        public Builder setA9Params(final String a9Params) {
            this.a9Params = a9Params;
            return this;
        }
        
        public Builder setVcUserId(final String vcUserId) {
            this.vcUserId = vcUserId;
            return this;
        }
        
        public Builder setHasDynamicMediation(final boolean hasDynamicMediation) {
            this.hasDynamicMediation = hasDynamicMediation;
            return this;
        }
        
        public ASRequestParams build() {
            final ASRequestParams asRequestParams;
            (asRequestParams = new ASRequestParams()).a = this.pubKeys;
            asRequestParams.b = this.a9Params;
            asRequestParams.c = this.vcUserId;
            asRequestParams.d = this.hasDynamicMediation;
            return asRequestParams;
        }
    }
}
