// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.annotation.SuppressLint;
import org.json.JSONObject;
import java.util.Map;
import androidx.annotation.CallSuper;
import com.inmobi.ads.InMobiAdRequestStatus;
import android.os.Looper;
import com.inmobi.ads.AdMetaInfo;
import androidx.annotation.NonNull;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.inmobi.ads.controllers.PublisherCallbacks;
import androidx.annotation.VisibleForTesting;

public abstract class aj extends t.a
{
    private static final String k;
    @VisibleForTesting(otherwise = 3)
    public static final String a = "An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad for placement id: ";
    @VisibleForTesting(otherwise = 3)
    public static final String b = "Ad show is already called. Please wait for the the ad to be shown.";
    @VisibleForTesting
    public static final String c = "preload() and load() cannot be called on the same instance, please use a different instance.";
    @VisibleForTesting(otherwise = 3)
    public static final String d = "Please make an ad request first in order to start loading the ad.";
    @VisibleForTesting
    public static final String e = "An ad load is already in progress. Please wait for the load to complete before requesting for another ad for placement id: ";
    byte f;
    Boolean g;
    @Nullable
    PublisherCallbacks h;
    @NonNull
    final Handler i;
    @Nullable
    AdMetaInfo j;
    
    aj() {
        this.f = 0;
        this.g = null;
        this.i = new Handler(Looper.getMainLooper());
    }
    
    @Nullable
    public abstract t m();
    
    void c(final t t, final InMobiAdRequestStatus inMobiAdRequestStatus) {
        this.f = 3;
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                if (t != null) {
                    t.f((byte)1);
                }
                if (aj.this.h != null) {
                    aj.this.h.onAdLoadFailed(inMobiAdRequestStatus);
                }
            }
        });
    }
    
    @Override
    public void a(@NonNull final AdMetaInfo adMetaInfo) {
        this.f = 7;
    }
    
    @Override
    public void a(@NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
        this.f = 3;
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                if (aj.this.h != null) {
                    aj.this.h.onAdFetchFailed(inMobiAdRequestStatus);
                }
            }
        });
    }
    
    @Override
    public final void b() {
        if (this.f != 4 && this.f != 5) {
            this.i.post((Runnable)new Runnable() {
                @Override
                public final void run() {
                    if (aj.this.h != null) {
                        aj.this.h.onAdWillDisplay();
                    }
                }
            });
            this.f = 4;
        }
    }
    
    @CallSuper
    @Override
    public void c(@NonNull final AdMetaInfo j) {
        if (this.f != 5) {
            this.j = j;
            this.i.post((Runnable)new Runnable() {
                @Override
                public final void run() {
                    if (aj.this.h != null) {
                        aj.this.h.onAdDisplayed(j);
                    }
                }
            });
            this.f = 5;
        }
    }
    
    @Override
    public void a(@Nullable final t t, final InMobiAdRequestStatus inMobiAdRequestStatus) {
        if (this.c(inMobiAdRequestStatus) && this.a(t)) {
            t.b(inMobiAdRequestStatus);
            return;
        }
        this.c(t, inMobiAdRequestStatus);
    }
    
    protected boolean c(@Nullable final InMobiAdRequestStatus inMobiAdRequestStatus) {
        return inMobiAdRequestStatus == null || InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR == inMobiAdRequestStatus.getStatusCode() || InMobiAdRequestStatus.StatusCode.AD_NO_LONGER_AVAILABLE == inMobiAdRequestStatus.getStatusCode();
    }
    
    protected boolean a(@Nullable final t t) {
        return t != null && !t.v;
    }
    
    @Override
    public void a(@NonNull final Map<Object, Object> map) {
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                if (aj.this.h != null) {
                    aj.this.h.onAdClicked(map);
                }
            }
        });
    }
    
    public void b(@NonNull final PublisherCallbacks h) {
        final t m;
        if ((m = this.m()) != null) {
            this.h = h;
            m.z();
        }
    }
    
    @Override
    public final void a(@NonNull final t t, final boolean b, @NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
        if (b) {
            t.S();
        }
        else {
            t.D();
        }
        this.b(t, b, inMobiAdRequestStatus);
    }
    
    void b(@NonNull final t t, final boolean b, final InMobiAdRequestStatus inMobiAdRequestStatus) {
        if (!b) {
            this.c(t, inMobiAdRequestStatus);
        }
    }
    
    @NonNull
    public String C() {
        if (this.j == null) {
            return "";
        }
        return this.j.getCreativeID();
    }
    
    public void a(final byte[] array, @NonNull final PublisherCallbacks h) {
        if (this.g != null && this.g) {
            hf.a((byte)1, "InMobi", "Cannot call load(byte[]) API after load() API is called");
            return;
        }
        this.g = Boolean.FALSE;
        this.f = 1;
        final t m;
        if ((m = this.m()) != null) {
            this.h = h;
            m.a(array);
        }
    }
    
    public JSONObject D() {
        if (this.j == null) {
            return new JSONObject();
        }
        return this.j.getBidInfo();
    }
    
    @Override
    public void b(@NonNull final AdMetaInfo j) {
        this.j = j;
        final t m;
        if ((m = this.m()) != null) {
            m.f((byte)1);
        }
    }
    
    @Override
    public void b(final t t, final InMobiAdRequestStatus inMobiAdRequestStatus) {
        this.c(t, inMobiAdRequestStatus);
    }
    
    @Override
    public void d() {
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                if (aj.this.h != null) {
                    aj.this.h.onUserLeftApplication();
                }
            }
        });
    }
    
    @Override
    public void b(@NonNull final Map<Object, Object> map) {
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                if (aj.this.h != null) {
                    aj.this.h.onRewardsUnlocked(map);
                }
            }
        });
    }
    
    @Override
    public void a(final byte[] array) {
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                if (aj.this.h != null) {
                    aj.this.h.onRequestPayloadCreated(array);
                }
            }
        });
    }
    
    @Override
    public void b(final InMobiAdRequestStatus inMobiAdRequestStatus) {
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                if (aj.this.h != null) {
                    aj.this.h.onRequestPayloadCreationFailed(inMobiAdRequestStatus);
                }
            }
        });
    }
    
    @SuppressLint({ "SwitchIntDef" })
    boolean a(@NonNull final String s, @NonNull final String s2, @Nullable final PublisherCallbacks publisherCallbacks) {
        final t m = this.m();
        if (this.h != null && publisherCallbacks != null && this.h.getType() != publisherCallbacks.getType()) {
            hf.a((byte)1, aj.k, "preload() and load() cannot be called on the same instance, please use a different instance.");
            if (m != null) {
                m.b((byte)54);
            }
            return false;
        }
        switch (this.f) {
            case 1:
            case 8: {
                hf.a((byte)1, s, "An ad load is already in progress. Please wait for the load to complete before requesting for another ad for placement id: ".concat(String.valueOf(s2)));
                if (m != null) {
                    m.b((byte)53);
                }
                return false;
            }
            case 5: {
                hf.a((byte)1, s, "An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad for placement id: ".concat(String.valueOf(s2)));
                this.c(this.m(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_ACTIVE));
                if (m != null) {
                    m.a((byte)15);
                }
                return false;
            }
            default: {
                return true;
            }
        }
    }
    
    boolean a(@NonNull final String s, @NonNull final String s2) throws IllegalStateException {
        final t m = this.m();
        switch (this.f) {
            case 1:
            case 8: {
                hf.a((byte)1, s, "An ad load is already in progress. Please wait for the load to complete before requesting for another ad for placement id: ".concat(String.valueOf(s2)));
                return false;
            }
            case 5: {
                hf.a((byte)1, s, "An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad for placement id: ".concat(String.valueOf(s2)));
                if (m != null) {
                    m.a((byte)15);
                }
                this.c(m, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_ACTIVE));
                return false;
            }
            default: {
                throw new IllegalStateException("Please make an ad request first in order to start loading the ad.");
            }
            case 7: {
                return true;
            }
        }
    }
    
    @Override
    public void c() {
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                if (aj.this.h != null) {
                    aj.this.h.onAdDismissed();
                }
            }
        });
    }
    
    static {
        k = aj.class.getSimpleName();
    }
}
