// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import org.json.JSONObject;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import java.util.LinkedList;
import com.inmobi.commons.utils.json.Constructor;
import java.util.List;

@hw
public class fu extends ff
{
    private static final boolean DEFAULT_IS_ENABLED = true;
    private static final String DEFAULT_URL = "https://telemetry.sdk.inmobi.com/metrics";
    private static final long DEFAULT_PROCESSING_INTERVAL_SEC = 30L;
    private static final int DEFAULT_MIN_BATCH_SIZE = 5;
    private static final int DEFAULT_MAX_BATCH_SIZE = 20;
    private static final int DEFAULT_MAX_RETRIES = 1;
    private static final int DEFAULT_MAX_EVENTS_TO_PERSIST = 1000;
    private static final long DEFAULT_RETRY_INTERVAL_SEC = 60L;
    private static final long DEFAULT_EVENT_TTL_SEC = 604800L;
    private static final boolean DEFAULT_DISABLE_GENERAL_EVENTS = false;
    private static final long DEFAULT_INGESTION_LATENCY_SEC = 86400L;
    private static final double DEFAULT_SAMPLING_FACTOR = 0.0;
    public String telemetryUrl;
    private long processingInterval;
    private int maxRetryCount;
    public int maxEventsToPersist;
    private long eventTTL;
    public boolean disableAllGeneralEvents;
    private long txLatency;
    public double samplingFactor;
    public List<String> priorityEvents;
    public b base;
    public fq networkType;
    public a assetReporting;
    
    @NonNull
    public static hv<fu> a() {
        return new hv<fu>().a(new ia("priorityEvents", fu.class), new hx(new Constructor<List<String>>() {}, String.class));
    }
    
    fu(@Nullable final String s) {
        super(s);
        this.telemetryUrl = "https://telemetry.sdk.inmobi.com/metrics";
        this.processingInterval = 30L;
        this.maxRetryCount = 1;
        this.maxEventsToPersist = 1000;
        this.eventTTL = 604800L;
        this.disableAllGeneralEvents = false;
        this.txLatency = 86400L;
        this.samplingFactor = 0.0;
        final LinkedList<String> priorityEvents;
        (priorityEvents = new LinkedList<String>()).add("SessionStarted");
        priorityEvents.add("ServerFill");
        priorityEvents.add("ServerNoFill");
        priorityEvents.add("ServerError");
        priorityEvents.add("AdLoadFailed");
        priorityEvents.add("AdLoadSuccessful");
        priorityEvents.add("BlockAutoRedirection");
        priorityEvents.add("AssetDownloaded");
        priorityEvents.add("CrashEventOccurred");
        priorityEvents.add("InvalidConfig");
        priorityEvents.add("ConfigFetched");
        priorityEvents.add("SdkInitialized");
        priorityEvents.add("AdGetSignalsFailed");
        priorityEvents.add("AdGetSignalsSucceeded");
        priorityEvents.add("AdShowFailed");
        priorityEvents.add("AdLoadCalled");
        priorityEvents.add("AdLoadDroppedAtSDK");
        priorityEvents.add("AdShowCalled");
        priorityEvents.add("AdShowSuccessful");
        this.priorityEvents = priorityEvents;
        this.base = new b();
        this.networkType = new fq();
        this.networkType.wifi = new fq.a();
        this.networkType.wifi.retryInterval = 60L;
        this.networkType.wifi.minBatchSize = 5;
        this.networkType.wifi.maxBatchSize = 20;
        this.networkType.others = new fq.a();
        this.networkType.others.retryInterval = 60L;
        this.networkType.others.minBatchSize = 5;
        this.networkType.others.maxBatchSize = 20;
        final a assetReporting;
        (assetReporting = new a()).video = true;
        assetReporting.image = false;
        assetReporting.gif = false;
        this.assetReporting = assetReporting;
    }
    
    @Override
    public String b() {
        return "telemetry";
    }
    
    @Override
    public boolean d() {
        return this.telemetryUrl.trim().length() != 0 && (this.telemetryUrl.startsWith("http://") || this.telemetryUrl.startsWith("https://")) && this.txLatency >= this.processingInterval && this.txLatency <= this.eventTTL && this.networkType.a(this.maxEventsToPersist) && (this.processingInterval > 0L && this.maxRetryCount >= 0 && this.txLatency > 0L && this.eventTTL > 0L && this.maxEventsToPersist > 0 && this.samplingFactor >= 0.0);
    }
    
    @Nullable
    @Override
    public JSONObject c() {
        return a().a(this);
    }
    
    public final fz e() {
        return new fz(this.maxRetryCount, this.eventTTL, this.processingInterval, this.txLatency, this.networkType.wifi.minBatchSize, this.networkType.wifi.maxBatchSize, this.networkType.others.minBatchSize, this.networkType.others.maxBatchSize, this.networkType.wifi.retryInterval, this.networkType.others.retryInterval);
    }
    
    @hw
    public static final class a
    {
        public boolean video;
        public boolean image;
        public boolean gif;
    }
    
    @hw
    public static final class b
    {
        public boolean enabled;
        
        private b() {
            this.enabled = true;
        }
    }
}
