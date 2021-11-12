// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

@hw
public final class fq
{
    public a wifi;
    public a others;
    
    public final boolean a(final int n) {
        return this.wifi.a(n) && this.others.a(n);
    }
    
    @hw
    public static final class a
    {
        public long retryInterval;
        public int minBatchSize;
        public int maxBatchSize;
        
        public final boolean a(final int n) {
            return this.maxBatchSize <= n && this.retryInterval > 0L && this.maxBatchSize > 0 && this.minBatchSize > 0 && this.minBatchSize <= this.maxBatchSize;
        }
    }
}
