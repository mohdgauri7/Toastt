// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import android.text.TextUtils;
import android.graphics.Color;
import org.json.JSONObject;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import java.util.HashMap;
import com.inmobi.commons.utils.json.Constructor;
import java.util.Map;

@hw
public final class fe extends ff
{
    private static final String TAG;
    private static final int DEFAULT_MAX_POOL_SIZE = 10;
    private static final String DEFAULT_AD_SERVER_URL = "https://ads.inmobi.com/sdk";
    private static final int DEFAULT_MINIMUM_REFRESH_INTERVAL = 20;
    private static final int DEFAULT_REFRESH_INTERVAL = 60;
    private static final int DEFAULT_FETCH_TIMEOUT = 60;
    private static final boolean DEFAULT_CCT_ENABLED = true;
    private static final String ALLOWED_CONTENT_TYPE = "allowedContentType";
    private static final String GESTURE_LIST = "gestures";
    public int maxPoolSize;
    public String url;
    public int minimumRefreshInterval;
    public int defaultRefreshInterval;
    public int fetchTimeout;
    public boolean cctEnabled;
    private Map<String, d> cache;
    public e imai;
    public i rendering;
    public g mraid;
    public m viewability;
    public k vastVideo;
    public a assetCache;
    public it timeouts;
    
    @NonNull
    public static hv<fe> a() {
        return new hv<fe>().a(new ia("cache", fe.class), new hy(new Constructor<Map<String, d>>() {}, d.class)).a(new ia("allowedContentType", j.class), new hx(new Constructor<List<String>>() {}, String.class)).a(new ia("allowedContentType", k.class), new hx(new Constructor<List<String>>() {}, String.class)).a(new ia("gestures", i.class), new hx(new Constructor<List<Integer>>() {}, Integer.class));
    }
    
    fe(@Nullable final String s) {
        super(s);
        this.maxPoolSize = 10;
        this.url = "https://ads.inmobi.com/sdk";
        this.minimumRefreshInterval = 20;
        this.defaultRefreshInterval = 60;
        this.fetchTimeout = 60;
        this.cctEnabled = true;
        this.timeouts = it.a();
        this.imai = new e();
        this.rendering = new i();
        this.mraid = new g();
        this.viewability = new m();
        this.vastVideo = new k();
        this.assetCache = new a();
        (this.cache = new HashMap<String, d>()).put("base", new d());
        this.cache.put("banner", new d());
        this.cache.put("int", new d());
        this.cache.put("native", new d());
    }
    
    @Override
    public final String b() {
        return "ads";
    }
    
    @Nullable
    @Override
    public final JSONObject c() {
        return a().a(this);
    }
    
    @Override
    public final boolean d() {
        if (this.maxPoolSize <= 0) {
            return false;
        }
        this.timeouts.j();
        if ((!this.url.startsWith("http://") && !this.url.startsWith("https://")) || this.minimumRefreshInterval < 0 || this.defaultRefreshInterval < 0 || this.minimumRefreshInterval > this.defaultRefreshInterval || this.fetchTimeout <= 0) {
            return false;
        }
        final Iterator<Map.Entry<String, d>> iterator = this.cache.entrySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue().timeToLive < 0L) {
                return false;
            }
        }
        if (this.imai.maxDbEvents < 0 || this.imai.maxEventBatch < 0 || this.imai.maxRetries < 0 || this.imai.pingInterval < 0 || this.imai.pingTimeout <= 0 || this.imai.pingCacheExpiry <= 0L) {
            return false;
        }
        if (this.mraid.expiry < 0L || this.mraid.retryInterval < 0 || this.mraid.maxRetries < 0 || (!this.mraid.url.startsWith("http://") && !this.mraid.url.startsWith("https://"))) {
            return false;
        }
        if (this.timeouts.h() < 0 || this.timeouts.b() < 0 || this.timeouts.c() < 0 || this.timeouts.d() < 0 || this.timeouts.e() < 0 || this.timeouts.f() < 0 || this.timeouts.g() < 0 || this.timeouts.i() < 0) {
            return false;
        }
        if (this.rendering.picHeight < 0 || this.rendering.picWidth < 0 || this.rendering.picQuality < 0 || this.rendering.maxVibrationDuration < 0 || this.rendering.maxVibrationPatternLength < 0 || this.rendering.savecontent.maxSaveSize < 0L || this.rendering.webviewBackground == null || this.rendering.webviewBackground.trim().length() == 0 || this.rendering.delayedRedirection <= 0L || this.rendering.userTouchResetTime < 0L || this.rendering.gestures.isEmpty()) {
            return false;
        }
        try {
            Color.parseColor(this.rendering.webviewBackground);
        }
        catch (IllegalArgumentException ex) {
            return false;
        }
        final h omidConfig;
        return this.mraid.maxRetries >= 0 && this.mraid.retryInterval >= 0 && this.mraid.url != null && this.mraid.url.trim().length() != 0 && (this.viewability.impressionMinPercentageViewed > 0 && this.viewability.impressionMinPercentageViewed <= 100 && this.viewability.impressionMinTimeViewed >= 0 && this.viewability.displayMinPercentageAnimate > 0 && this.viewability.displayMinPercentageAnimate <= 100 && this.viewability.video.impressionMinPercentageViewed > 0 && this.viewability.video.impressionMinPercentageViewed <= 100 && this.viewability.web.impressionMinPercentageViewed > 0 && this.viewability.web.impressionMinPercentageViewed <= 100 && this.viewability.web.impressionPollIntervalMillis > 0 && this.viewability.web.impressionMinTimeViewed >= 0 && this.viewability.video.impressionMinTimeViewed >= 0 && this.viewability.video.videoMinPercentagePlay > 0 && this.viewability.video.videoMinPercentagePlay <= 100 && this.viewability.visibilityThrottleMillis >= 50 && this.viewability.visibilityThrottleMillis * 5 <= this.viewability.impressionMinTimeViewed && this.viewability.impressionPollIntervalMillis >= 50 && this.viewability.impressionPollIntervalMillis * 4 <= this.viewability.impressionMinTimeViewed && ((omidConfig = this.viewability.omidConfig) != null && omidConfig.maxRetries >= 0 && omidConfig.retryInterval >= 0 && omidConfig.url != null && omidConfig.url.trim().length() != 0 && !TextUtils.isEmpty((CharSequence)omidConfig.partnerKey))) && this.vastVideo.optimalVastVideoSize <= 31457280L && this.vastVideo.optimalVastVideoSize > 0L && this.vastVideo.maxWrapperLimit >= 0 && this.vastVideo.vastMaxAssetSize > 0L && this.vastVideo.vastMaxAssetSize <= 31457280L && (this.assetCache.retryInterval >= 0 && this.assetCache.maxCachedAssets <= 20 && this.assetCache.maxCachedAssets >= 0 && this.assetCache.timeToLive >= 0L && this.assetCache.maxCacheSize >= 0L && this.assetCache.maxRetries >= 0);
    }
    
    public final d a(final String s) {
        d d;
        if ((d = this.cache.get(s)) == null && (d = this.cache.get("base")) == null) {
            d = new d();
        }
        return d;
    }
    
    static {
        TAG = fe.class.getSimpleName();
    }
    
    @hw
    public static final class d
    {
        public long timeToLive;
        
        d() {
            this.timeToLive = 3300L;
        }
    }
    
    @hw
    public static final class c
    {
        public boolean bitrate_mandatory;
        public int headerTimeout;
        
        public c() {
            this.bitrate_mandatory = false;
            this.headerTimeout = 2000;
        }
    }
    
    @hw
    public static final class e
    {
        public int maxRetries;
        public int pingInterval;
        public int pingTimeout;
        public int maxDbEvents;
        public int maxEventBatch;
        public long pingCacheExpiry;
        
        public e() {
            this.maxRetries = 3;
            this.pingInterval = 60;
            this.pingTimeout = 120;
            this.maxDbEvents = 500;
            this.maxEventBatch = 10;
            this.pingCacheExpiry = 10800L;
        }
    }
    
    @hw
    public static final class j
    {
        long maxSaveSize;
        List<String> allowedContentType;
        
        public j() {
            this.maxSaveSize = 5242880L;
            this.allowedContentType = new ArrayList<String>(Collections.singletonList("video/mp4"));
        }
    }
    
    @hw
    public static final class i
    {
        public static final int DEFAULT_TOUCH_RESET_TIME = 4;
        static final short DEFAULT_NETWORK_LOAD_LIMIT = 50;
        public static final byte NETWORK_LOAD_LIMIT_DISABLED = -1;
        int picWidth;
        int picHeight;
        int picQuality;
        String webviewBackground;
        public boolean autoRedirectionEnforcement;
        public long userTouchResetTime;
        int maxVibrationDuration;
        int maxVibrationPatternLength;
        private long delayedRedirection;
        j savecontent;
        public boolean shouldRenderPopup;
        public boolean enablePubMuteControl;
        public int bannerNetworkLoadsLimit;
        public int otherNetworkLoadsLimit;
        public List<Integer> gestures;
        
        public i() {
            this.picWidth = 320;
            this.picHeight = 480;
            this.picQuality = 100;
            this.webviewBackground = "#00000000";
            this.autoRedirectionEnforcement = true;
            this.userTouchResetTime = 4L;
            this.maxVibrationDuration = 5;
            this.maxVibrationPatternLength = 20;
            this.delayedRedirection = 5L;
            this.savecontent = new j();
            this.shouldRenderPopup = false;
            this.enablePubMuteControl = false;
            this.bannerNetworkLoadsLimit = 50;
            this.otherNetworkLoadsLimit = -1;
            this.gestures = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5));
        }
        
        public final int a() {
            try {
                return Color.parseColor(this.webviewBackground);
            }
            catch (IllegalArgumentException ex) {
                fe.TAG;
                return Color.parseColor("#00000000");
            }
        }
    }
    
    @hw
    public static final class g
    {
        public long expiry;
        public int maxRetries;
        public int retryInterval;
        public String url;
        
        public g() {
            this.expiry = 432000L;
            this.maxRetries = 3;
            this.retryInterval = 60;
            this.url = "https://i.l.inmobicdn.net/sdk/sdk/500/android/mraid.js";
        }
    }
    
    @hw
    public static final class h
    {
        public long expiry;
        public int maxRetries;
        public int retryInterval;
        public String partnerKey;
        public String url;
        public boolean omidEnabled;
        public long webViewRetainTime;
        
        public h() {
            this.expiry = 432000L;
            this.maxRetries = 3;
            this.retryInterval = 60;
            this.partnerKey = "Inmobi";
            this.url = "https://i.l.inmobicdn.net/sdk/sdk/OMID/omsdk-v1.3.17.js";
            this.omidEnabled = true;
            this.webViewRetainTime = 1000L;
        }
    }
    
    @hw
    public static final class l
    {
        public int impressionMinPercentageViewed;
        public int impressionMinTimeViewed;
        public int videoMinPercentagePlay;
        
        public l() {
            this.impressionMinPercentageViewed = 50;
            this.impressionMinTimeViewed = 2000;
            this.videoMinPercentagePlay = 50;
        }
    }
    
    @hw
    public static final class n
    {
        public int impressionMinPercentageViewed;
        public int impressionMinTimeViewed;
        public int impressionPollIntervalMillis;
        
        public n() {
            this.impressionMinPercentageViewed = 50;
            this.impressionMinTimeViewed = 1000;
            this.impressionPollIntervalMillis = 1000;
        }
    }
    
    @hw
    public static final class b
    {
        public byte impressionType;
        
        public b() {
            this.impressionType = 0;
        }
    }
    
    @hw
    public static final class f
    {
        public byte impressionType;
        
        public f() {
            this.impressionType = 1;
        }
    }
    
    @hw
    public static final class m
    {
        static final int MIN_VISIBILITY_THROTTLE_INTERVAL_MILLIS = 50;
        static final int MIN_IMPRESSION_POLL_INTERVAL_MILLIS = 50;
        public int impressionMinPercentageViewed;
        public int impressionMinTimeViewed;
        public int visibilityThrottleMillis;
        public int impressionPollIntervalMillis;
        public int displayMinPercentageAnimate;
        public l video;
        public n web;
        public h omidConfig;
        public b banner;
        public f interstitial;
        public boolean moatEnabled;
        
        public m() {
            this.impressionMinPercentageViewed = 50;
            this.impressionMinTimeViewed = 1000;
            this.visibilityThrottleMillis = 100;
            this.impressionPollIntervalMillis = 250;
            this.displayMinPercentageAnimate = 67;
            this.video = new l();
            this.web = new n();
            this.omidConfig = new h();
            this.banner = new b();
            this.interstitial = new f();
            this.moatEnabled = true;
        }
    }
    
    @hw
    public static final class k
    {
        public int maxWrapperLimit;
        public long optimalVastVideoSize;
        public long vastMaxAssetSize;
        public c bitRate;
        public List<String> allowedContentType;
        
        public k() {
            this.maxWrapperLimit = 3;
            this.optimalVastVideoSize = 3145728L;
            this.vastMaxAssetSize = 31457280L;
            this.bitRate = new c();
            this.allowedContentType = new ArrayList<String>(Arrays.asList("video/mp4", "image/jpeg", "image/jpg", "image/gif", "image/png"));
        }
    }
    
    @hw
    public static final class a
    {
        public int maxRetries;
        public int retryInterval;
        int maxCachedAssets;
        public long maxCacheSize;
        public long timeToLive;
        
        public a() {
            this.maxRetries = 3;
            this.retryInterval = 1;
            this.maxCachedAssets = 10;
            this.maxCacheSize = 104857600L;
            this.timeToLive = 259200L;
        }
    }
}
