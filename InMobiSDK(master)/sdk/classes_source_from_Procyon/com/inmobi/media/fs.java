// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Iterator;
import org.json.JSONObject;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import com.inmobi.commons.utils.json.Constructor;
import java.util.List;
import androidx.annotation.Nullable;

@hw
public class fs extends ff
{
    private static final long DEFAULT_EXPIRY = 86400L;
    private static final int DEFAULT_MAX_RETRIES = 3;
    private static final int DEFAULT_RETRY_INTERVAL = 60;
    private static final int DEFAULT_WAIT_TIME = 3;
    private static final String DEFAULT_URL = "";
    private static final String DEFAULT_FALLBACK_URL = "https://config.inmobi.com/config-server/v1/config/secure.cfg";
    private int maxRetries;
    private int retryInterval;
    int waitTime;
    @Nullable
    private b gdpr;
    private List<a> components;
    c latestSdkInfo;
    private boolean monetizationDisabled;
    private static final Object sAcquisitionLock;
    
    @NonNull
    public static hv<fs> a() {
        return new hv<fs>().a(new ia("components", fs.class), new hx(new Constructor<List<a>>() {}, a.class));
    }
    
    fs(@Nullable final String s) {
        super(s);
        this.maxRetries = 3;
        this.retryInterval = 60;
        this.waitTime = 3;
        this.monetizationDisabled = false;
        this.components = new ArrayList<a>();
        this.latestSdkInfo = new c();
        this.gdpr = new b();
    }
    
    @VisibleForTesting
    public boolean a(@NonNull final fs fs) {
        return ((null == this.g() && null == fs.g()) || (this.g() != null && this.g().equals(fs.g()))) && fs.maxRetries == this.maxRetries && fs.retryInterval == this.retryInterval && fs.waitTime == this.waitTime && fs.monetizationDisabled == this.monetizationDisabled;
    }
    
    @Override
    public String b() {
        return "root";
    }
    
    @Nullable
    @Override
    public JSONObject c() {
        return a().a(this);
    }
    
    @Override
    public boolean d() {
        if (this.components == null) {
            return false;
        }
        if (this.maxRetries < 0 || this.retryInterval < 0 || this.waitTime < 0) {
            return false;
        }
        if (this.latestSdkInfo.version.trim().length() == 0 || (!this.latestSdkInfo.url.startsWith("http://") && !this.latestSdkInfo.url.startsWith("https://"))) {
            return false;
        }
        synchronized (fs.sAcquisitionLock) {
            for (int i = 0; i < this.components.size(); ++i) {
                final a a;
                if ((a = this.components.get(i)).type == null || Long.valueOf(a.expiry) == null) {
                    return false;
                }
                if (a.type.trim().length() == 0) {
                    return false;
                }
                if (a.expiry < 0L || a.expiry > 864000L) {
                    return false;
                }
                if (c(a.url)) {
                    return false;
                }
                if ("root".equals(a.type) && c(a.fallbackUrl)) {
                    return false;
                }
            }
        }
        return this.gdpr != null;
    }
    
    private static boolean c(final String s) {
        return s == null || s.trim().length() == 0 || (!s.startsWith("http://") && !s.startsWith("https://"));
    }
    
    public long a(final String s) {
        synchronized (fs.sAcquisitionLock) {
            for (int i = 0; i < this.components.size(); ++i) {
                final a a = this.components.get(i);
                if (s.equals(a.type)) {
                    return a.expiry;
                }
            }
            return 86400L;
        }
    }
    
    public int e() {
        return this.maxRetries;
    }
    
    public int h() {
        return this.retryInterval;
    }
    
    public boolean i() {
        return this.monetizationDisabled;
    }
    
    public boolean j() {
        return this.gdpr == null || this.gdpr.transmitRequest;
    }
    
    public String b(final String s) {
        synchronized (fs.sAcquisitionLock) {
            for (int i = 0; i < this.components.size(); ++i) {
                final a a = this.components.get(i);
                if (s.equals(a.type)) {
                    return a.url;
                }
            }
            return "";
        }
    }
    
    final String k() {
        synchronized (fs.sAcquisitionLock) {
            for (final a a : this.components) {
                if ("root".equals(a.type)) {
                    return a.fallbackUrl;
                }
            }
            return "https://config.inmobi.com/config-server/v1/config/secure.cfg";
        }
    }
    
    static {
        sAcquisitionLock = new Object();
    }
    
    @hw
    public static final class a
    {
        String type;
        long expiry;
        String url;
        String fallbackUrl;
        
        public a() {
            this.fallbackUrl = "https://config.inmobi.com/config-server/v1/config/secure.cfg";
        }
    }
    
    @hw
    public static final class c
    {
        String version;
        String url;
        
        public c() {
            this.version = ha.b();
            this.url = ha.e();
        }
    }
    
    @hw
    public static final class b
    {
        boolean transmitRequest;
        
        public b() {
            this.transmitRequest = true;
        }
    }
}
