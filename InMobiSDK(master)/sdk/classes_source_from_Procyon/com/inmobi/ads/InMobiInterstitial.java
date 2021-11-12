// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.ads;

import com.inmobi.media.ha;
import java.util.Map;
import org.json.JSONObject;
import androidx.annotation.UiThread;
import com.inmobi.media.gv;
import com.inmobi.media.fv;
import com.inmobi.media.ho;
import android.os.Build;
import com.inmobi.ads.exceptions.SdkNotInitializedException;
import com.inmobi.media.gz;
import com.inmobi.media.hf;
import com.inmobi.ads.controllers.PublisherCallbacks;
import com.inmobi.media.e;
import com.inmobi.media.bc;
import java.lang.ref.WeakReference;
import android.content.Context;
import androidx.annotation.NonNull;
import com.inmobi.ads.listeners.InterstitialAdEventListener;
import com.inmobi.media.ac;

public final class InMobiInterstitial
{
    private static final String b;
    private ac c;
    @NonNull
    public InterstitialAdEventListener a;
    private Context d;
    private boolean e;
    private WeakReference<Context> f;
    @NonNull
    private bc g;
    private a h;
    @NonNull
    private PreloadManager i;
    
    public InMobiInterstitial(@NonNull final Context referent, final long a, @NonNull final InterstitialAdEventListener a2) throws SdkNotInitializedException {
        this.e = false;
        this.g = new bc();
        this.h = new a(this);
        this.i = new PreloadManager() {
            private e b = new e(InMobiInterstitial.this);
            
            @Override
            public final void preload() {
                InMobiInterstitial.this.e = true;
                InMobiInterstitial.this.g.e = "NonAB";
                InMobiInterstitial.this.c.a(InMobiInterstitial.this.g, InMobiInterstitial.this.d);
                InMobiInterstitial.this.c.a(this.b);
            }
            
            @Override
            public final void load() {
                try {
                    InMobiInterstitial.this.c.l();
                }
                catch (IllegalStateException ex) {
                    hf.a((byte)1, InMobiInterstitial.b, ex.getMessage());
                    InMobiInterstitial.this.a.onAdLoadFailed(InMobiInterstitial.this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
                }
            }
        };
        if (gz.b()) {
            this.d = referent.getApplicationContext();
            this.g.a = a;
            this.f = new WeakReference<Context>(referent);
            this.a = a2;
            this.c = new ac();
            return;
        }
        throw new SdkNotInitializedException(InMobiInterstitial.b);
    }
    
    public final void setListener(@NonNull final InterstitialAdEventListener a) {
        this.a = a;
    }
    
    public final void setKeywords(final String b) {
        this.g.b = b;
    }
    
    public final void getSignals() {
        this.c.a(this.g, this.d);
        this.c.b(this.h);
    }
    
    @NonNull
    public final PreloadManager getPreloadManager() {
        return this.i;
    }
    
    public final void load(final byte[] array) {
        this.e = true;
        this.g.e = "AB";
        this.c.a(this.g, this.d);
        if (Build.VERSION.SDK_INT >= 29) {
            ho.a((this.f == null) ? null : this.f.get());
        }
        this.c.a(array, this.h);
    }
    
    @UiThread
    public final void load() {
        try {
            this.e = true;
            this.g.e = "NonAB";
            this.c.a(this.g, this.d);
            if (Build.VERSION.SDK_INT >= 29) {
                ho.a((this.f == null) ? null : this.f.get());
            }
            this.c.a(this.h);
        }
        catch (Exception ex) {
            hf.a((byte)1, InMobiInterstitial.b, "Unable to load ad; SDK encountered an unexpected error");
            fv.a().a(new gv(ex));
        }
    }
    
    @UiThread
    public final void show() {
        try {
            if (!this.e) {
                hf.a((byte)1, InMobiInterstitial.b, "load() must be called before trying to show the ad");
                return;
            }
            this.c.o();
        }
        catch (Exception ex) {
            hf.a((byte)1, InMobiInterstitial.b, "Unable to show ad; SDK encountered an unexpected error");
            fv.a().a(new gv(ex));
        }
    }
    
    @Deprecated
    public final void show(final int n, final int n2) {
        hf.a((byte)1, InMobiInterstitial.b, String.format("The %s API has been deprecated and API will be removed in the subsequent versions", "show(int, int)"));
        this.show();
    }
    
    public final boolean isReady() {
        return this.c.n();
    }
    
    @Deprecated
    public final JSONObject getAdMetaInfo() {
        return this.c.D();
    }
    
    @Deprecated
    public final String getCreativeId() {
        return this.c.C();
    }
    
    public final void setExtras(final Map<String, String> c) {
        if (c != null) {
            ha.a(c.get("tp"));
            ha.b(c.get("tp-ver"));
        }
        this.g.c = c;
    }
    
    public final void setContentUrl(@NonNull final String f) {
        this.g.f = f;
    }
    
    public final void disableHardwareAcceleration() {
        this.g.d = true;
    }
    
    static {
        b = InMobiInterstitial.class.getSimpleName();
    }
    
    public static final class a extends e
    {
        a(@NonNull final InMobiInterstitial inMobiInterstitial) {
            super(inMobiInterstitial);
        }
        
        @Override
        public final byte getType() {
            return 0;
        }
        
        @Override
        public final void onAdFetchSuccessful(@NonNull AdMetaInfo adMetaInfo) {
            super.onAdFetchSuccessful(adMetaInfo);
            if ((adMetaInfo = (AdMetaInfo)this.a.get()) != null) {
                try {
                    ((InMobiInterstitial)adMetaInfo).c.l();
                }
                catch (IllegalStateException ex) {
                    hf.a((byte)1, InMobiInterstitial.b, ex.getMessage());
                    ((InMobiInterstitial)adMetaInfo).a.onAdLoadFailed((InMobiInterstitial)adMetaInfo, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
                }
            }
        }
        
        @Override
        public final void onAdFetchFailed(@NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
            final InMobiInterstitial inMobiInterstitial;
            if ((inMobiInterstitial = this.a.get()) != null && inMobiInterstitial.a != null) {
                inMobiInterstitial.a.onAdLoadFailed(inMobiInterstitial, inMobiAdRequestStatus);
            }
        }
    }
}
