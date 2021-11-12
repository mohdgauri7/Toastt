// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import org.json.JSONObject;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

@hw
public class fo extends ff
{
    private static final String DEFAULT_URL = "https://crash-metrics.sdk.inmobi.com/trace";
    private static final long DEFAULT_PROCESSING_INTERVAL_SEC = 60L;
    private static final int DEFAULT_MIN_BATCH_SIZE = 1;
    private static final int DEFAULT_MAX_BATCH_SIZE = 2;
    private static final int DEFAULT_MAX_RETRIES = 3;
    private static final int DEFAULT_MAX_EVENTS_TO_PERSIST = 50;
    private static final long DEFAULT_RETRY_INTERVAL_SEC = 10L;
    private static final long DEFAULT_EVENT_TTL_SEC = 259200L;
    private static final long DEFAULT_INGESTION_LATENCY_SEC = 86400L;
    private static final boolean DEFAULT_CRASH_ENABLED = true;
    private static final boolean DEFAULT_CATCH_ENABLED = false;
    public String url;
    public long processingInterval;
    public int maxRetryCount;
    public int maxEventsToPersist;
    public long eventTTL;
    public long txLatency;
    public boolean crashEnabled;
    public boolean catchEnabled;
    public fq networkType;
    
    @NonNull
    public static hv<fo> a() {
        return new hv<fo>();
    }
    
    fo(@Nullable final String s) {
        super(s);
        this.url = "https://crash-metrics.sdk.inmobi.com/trace";
        this.processingInterval = 60L;
        this.maxRetryCount = 3;
        this.maxEventsToPersist = 50;
        this.eventTTL = 259200L;
        this.txLatency = 86400L;
        this.crashEnabled = true;
        this.catchEnabled = false;
        this.networkType = new fq();
        this.networkType.wifi = new fq.a();
        this.networkType.wifi.retryInterval = 10L;
        this.networkType.wifi.minBatchSize = 1;
        this.networkType.wifi.maxBatchSize = 2;
        this.networkType.others = new fq.a();
        this.networkType.others.retryInterval = 10L;
        this.networkType.others.minBatchSize = 1;
        this.networkType.others.maxBatchSize = 2;
    }
    
    @Override
    public String b() {
        return "crashReporting";
    }
    
    @Override
    public boolean d() {
        return this.url.trim().length() != 0 && (this.url.startsWith("http://") || this.url.startsWith("https://")) && this.txLatency >= this.processingInterval && this.txLatency <= this.eventTTL && this.networkType.a(this.maxEventsToPersist) && (this.processingInterval > 0L && this.maxRetryCount >= 0 && this.txLatency > 0L && this.eventTTL > 0L && this.maxEventsToPersist > 0);
    }
    
    @Nullable
    @Override
    public JSONObject c() {
        return new hv<fo>().a(this);
    }
}
