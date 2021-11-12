// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

@hw
public class ft extends ff
{
    public b ice;
    @Nullable
    public JSONObject ext;
    public c unifiedIdServiceConfig;
    
    @NonNull
    public static hv<ft> a() {
        return new hv<ft>();
    }
    
    ft(@Nullable final String s) {
        super(s);
        this.ice = new b();
        this.ext = null;
        this.unifiedIdServiceConfig = new c();
    }
    
    @Override
    public String b() {
        return "signals";
    }
    
    @Nullable
    @Override
    public JSONObject c() {
        return new hv<ft>().a(this);
    }
    
    @Override
    public boolean d() {
        return this.ice.sampleInterval >= 0 && this.ice.stopRequestTimeout >= 0 && this.ice.w.wf >= 0 && this.ice.c.cof >= 0 && URLUtil.isValidUrl(this.unifiedIdServiceConfig.url) && this.unifiedIdServiceConfig.maxRetries >= 0 && this.unifiedIdServiceConfig.timeout >= 0 && this.unifiedIdServiceConfig.retryInterval >= 0;
    }
    
    @hw
    public static final class b
    {
        public int sampleInterval;
        public int stopRequestTimeout;
        public boolean locationEnabled;
        public boolean sessionEnabled;
        public d w;
        public a c;
        
        public b() {
            this.sampleInterval = 300;
            this.stopRequestTimeout = 3;
            this.locationEnabled = false;
            this.sessionEnabled = false;
            this.w = new d();
            this.c = new a();
        }
    }
    
    @hw
    public static final class d
    {
        public int wf;
        public boolean vwe;
        public boolean cwe;
        
        private d() {
            this.wf = 0;
            this.vwe = false;
            this.cwe = false;
        }
    }
    
    @hw
    public static final class a
    {
        public int cof;
        public boolean oe;
        public boolean vce;
        public boolean cce;
        
        private a() {
            this.cof = 0;
            this.oe = false;
            this.vce = false;
            this.cce = false;
        }
    }
    
    @hw
    public static final class c
    {
        public boolean enabled;
        public String url;
        public int maxRetries;
        public int retryInterval;
        public int timeout;
        
        public c() {
            this.enabled = false;
            this.url = "https://unif-id.ssp.inmobi.com/fetch";
            this.maxRetries = 0;
            this.retryInterval = 0;
            this.timeout = 10;
        }
    }
}
