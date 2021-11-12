// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.ads;

import com.inmobi.media.ha;
import org.json.JSONObject;
import com.inmobi.media.l;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import java.util.Map;
import com.inmobi.media.dg;
import com.inmobi.media.hq;
import android.os.Looper;
import com.inmobi.media.ae;
import android.view.ViewGroup;
import com.inmobi.media.gv;
import com.inmobi.media.fv;
import com.inmobi.media.ho;
import android.os.Build;
import com.inmobi.media.hf;
import com.inmobi.ads.exceptions.SdkNotInitializedException;
import com.inmobi.ads.controllers.PublisherCallbacks;
import com.inmobi.media.gz;
import android.content.Context;
import androidx.annotation.NonNull;
import com.inmobi.media.bc;
import android.view.View;
import java.lang.ref.WeakReference;
import androidx.annotation.Nullable;
import com.inmobi.ads.listeners.VideoEventListener;
import com.inmobi.ads.listeners.NativeAdEventListener;
import com.inmobi.media.ag;

public final class InMobiNative
{
    private static final String a;
    private ag b;
    private NativeCallbacks c;
    private NativeAdEventListener d;
    @Nullable
    private VideoEventListener e;
    private WeakReference<View> f;
    private boolean g;
    @NonNull
    private bc h;
    private WeakReference<Context> i;
    private LockScreenListener j;
    
    public InMobiNative(@NonNull final Context referent, final long a, @NonNull final NativeAdEventListener d) throws SdkNotInitializedException {
        this.h = new bc();
        if (gz.b()) {
            this.h.a = a;
            this.i = new WeakReference<Context>(referent);
            this.d = d;
            this.c = new NativeCallbacks(this);
            this.b = new ag(this.c);
            return;
        }
        throw new SdkNotInitializedException(InMobiNative.a);
    }
    
    public final void setListener(@NonNull final NativeAdEventListener d) {
        this.d = d;
    }
    
    public final void setVideoEventListener(@NonNull final VideoEventListener e) {
        this.e = e;
    }
    
    private boolean a(final boolean b) {
        Label_0040: {
            if (b) {
                if (this.b != null || this.d != null) {
                    break Label_0040;
                }
            }
            else if (this.d != null) {
                break Label_0040;
            }
            hf.a((byte)1, InMobiNative.a, "Listener supplied is null, your call is ignored.");
            return false;
        }
        if (this.i != null && null != this.i.get()) {
            return true;
        }
        hf.a((byte)1, InMobiNative.a, "Context supplied is null, your call is ignored.");
        return false;
    }
    
    public final void getSignals() {
        if (this.a(false)) {
            this.c.a();
            this.b();
            this.b.b(this.c);
        }
    }
    
    public final void load(final byte[] array) {
        if (this.a(false)) {
            if (Build.VERSION.SDK_INT >= 29) {
                ho.a((this.i == null) ? null : this.i.get());
            }
            this.h.e = "AB";
            this.b();
            this.c.a();
            this.b.a(array, this.c);
        }
    }
    
    private void b() {
        final Context context;
        if ((context = ((this.i == null) ? null : this.i.get())) == null) {
            return;
        }
        this.b.a(this.h, context);
    }
    
    public final void load() {
        try {
            if (!this.a(true)) {
                return;
            }
            this.c.a();
            if (this.g) {
                this.b.a(this.b.m(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REPETITIVE_LOAD));
                hf.a((byte)1, InMobiNative.a, "You can call load() on an instance of InMobiNative only once if the ad request has been successful. Ignoring InMobiNative.load()");
                return;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                ho.a((this.i == null) ? null : this.i.get());
            }
            this.h.e = "NonAB";
            this.b();
            this.b.n();
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
            hf.a((byte)1, "InMobi", "Could not load ad; SDK encountered an unexpected error");
        }
    }
    
    public final void load(@NonNull final Context referent) {
        if (this.a(true)) {
            this.i = new WeakReference<Context>(referent);
            this.load();
        }
    }
    
    public final void showOnLockScreen(@NonNull final LockScreenListener j) {
        if (this.i == null || this.i.get() == null) {
            hf.a((byte)1, InMobiNative.a, "InMobiNative is not initialized. Provided context is null. Ignoring showOnLockScreen");
            return;
        }
        try {
            this.b.b(this.h, this.i.get());
            this.j = j;
        }
        catch (Exception ex) {
            hf.a((byte)1, InMobiNative.a, "SDK encountered unexpected error in showOnLockScreen");
        }
    }
    
    public final void takeAction() {
        try {
            this.b.p();
        }
        catch (Exception ex) {
            hf.a((byte)1, InMobiNative.a, "SDK encountered unexpected error in takeAction");
        }
    }
    
    public final void pause() {
        try {
            this.b.q();
        }
        catch (Exception ex) {
            hf.a((byte)1, InMobiNative.a, "Could not pause ad; SDK encountered an unexpected error");
        }
    }
    
    public final void resume() {
        try {
            this.b.r();
        }
        catch (Exception ex) {
            hf.a((byte)1, InMobiNative.a, "Could not resume ad; SDK encountered an unexpected error");
        }
    }
    
    public final View getPrimaryViewOfWidth(final Context referent, final View view, final ViewGroup viewGroup, final int q) {
        try {
            if (referent == null) {
                hf.a((byte)1, InMobiNative.a, "View can not be rendered using null context");
                return null;
            }
            final ae ae;
            if ((ae = ((this.b.m() == null) ? null : ((ae)this.b.m()))) == null) {
                hf.a((byte)1, InMobiNative.a, "InMobiNative is not initialized. Ignoring InMobiNative.getPrimaryView()");
                return null;
            }
            this.i = new WeakReference<Context>(referent);
            ae.a(referent);
            final ae ae2 = ae;
            View referent2;
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                if (!hq.h()) {
                    ae2.Y();
                    referent2 = null;
                }
                else if (ae2.q()) {
                    hf.a((byte)1, "InMobi", "Ad has expired, please create a new instance.");
                    ae2.Y();
                    referent2 = null;
                }
                else if (!ae2.Z() && ae2.j() != 6) {
                    hf.a((byte)1, com.inmobi.media.ae.x, "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling getPrimaryView().");
                    if (ae2.y != null) {
                        final View view2;
                        if ((view2 = ae2.y.get()) != null) {
                            final View view3;
                            (view3 = new View(gz.c())).setLayoutParams(view2.getLayoutParams());
                            referent2 = view3;
                        }
                        else {
                            referent2 = null;
                        }
                    }
                    else {
                        referent2 = null;
                    }
                }
                else {
                    View a = null;
                    final l g;
                    if ((g = ae2.g) != null) {
                        g.r = ae2.z;
                        g.q = q;
                        final dg viewableAd;
                        a = (viewableAd = g.getViewableAd()).a(view, viewGroup, true);
                        ae2.y = new WeakReference<View>(a);
                        ae2.i.post((Runnable)new Runnable() {
                            @Override
                            public final void run() {
                                viewableAd.a((Map<View, FriendlyObstructionPurpose>)null);
                            }
                        });
                    }
                    referent2 = a;
                }
            }
            else {
                hf.a((byte)1, "InMobi", "Please ensure that you call getPrimaryView() on the UI thread");
                ae2.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.CALLED_FROM_WRONG_THREAD), false, (byte)44);
                referent2 = null;
            }
            this.f = new WeakReference<View>(referent2);
            final View view4;
            if ((view4 = this.f.get()) == null) {
                return null;
            }
            this.g = true;
            return view4;
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
            hf.a((byte)1, "InMobi", "Could not pause ad; SDK encountered an unexpected error");
            return null;
        }
    }
    
    @Deprecated
    public final View getPrimaryViewOfWidth(final View view, final ViewGroup viewGroup, final int n) {
        hf.a((byte)1, InMobiNative.a, String.format("The %s API has been deprecated and API will be removed in the subsequent versions", "getPrimaryViewOfWidth(View, ViewGroup, int)"));
        if (this.i == null || this.i.get() == null) {
            hf.a((byte)1, InMobiNative.a, "InMobiNative is not initialized or provided context is null.");
            return null;
        }
        return this.getPrimaryViewOfWidth(this.i.get(), view, viewGroup, n);
    }
    
    public final JSONObject getCustomAdContent() {
        try {
            return this.b.s();
        }
        catch (Exception ex) {
            hf.a((byte)1, InMobiNative.a, "Could not get the ad customJson ; SDK encountered unexpected error");
            fv.a().a(new gv(ex));
            return null;
        }
    }
    
    public final String getAdTitle() {
        try {
            return this.b.t();
        }
        catch (Exception ex) {
            hf.a((byte)1, InMobiNative.a, "Could not get the ad title; SDK encountered unexpected error");
            fv.a().a(new gv(ex));
            return null;
        }
    }
    
    public final String getAdDescription() {
        try {
            return this.b.u();
        }
        catch (Exception ex) {
            hf.a((byte)1, InMobiNative.a, "Could not get the description; SDK encountered unexpected error");
            fv.a().a(new gv(ex));
            return null;
        }
    }
    
    public final String getAdIconUrl() {
        try {
            return this.b.v();
        }
        catch (Exception ex) {
            hf.a((byte)1, InMobiNative.a, "Could not get the iconUrl; SDK encountered unexpected error");
            fv.a().a(new gv(ex));
            return null;
        }
    }
    
    public final String getAdLandingPageUrl() {
        try {
            return this.b.w();
        }
        catch (Exception ex) {
            hf.a((byte)1, InMobiNative.a, "Could not get the adLandingPageUrl; SDK encountered unexpected error");
            fv.a().a(new gv(ex));
            return null;
        }
    }
    
    public final String getAdCtaText() {
        try {
            return this.b.x();
        }
        catch (Exception ex) {
            hf.a((byte)1, InMobiNative.a, "Could not get the ctaText; SDK encountered unexpected error");
            fv.a().a(new gv(ex));
            return null;
        }
    }
    
    public final float getAdRating() {
        try {
            return this.b.y();
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
            hf.a((byte)1, "InMobi", "Could not get rating; SDK encountered an unexpected error");
            return 0.0f;
        }
    }
    
    public final boolean isAppDownload() {
        try {
            return this.b.z();
        }
        catch (Exception ex) {
            hf.a((byte)1, InMobiNative.a, "Could not get isAppDownload; SDK encountered unexpected error");
            fv.a().a(new gv(ex));
            return false;
        }
    }
    
    @Nullable
    public final Boolean isVideo() {
        try {
            return this.b.A();
        }
        catch (Exception ex) {
            hf.a((byte)1, InMobiNative.a, "Could not get isVideo; SDK encountered unexpected error");
            fv.a().a(new gv(ex));
            return null;
        }
    }
    
    public final void reportAdClickAndOpenLandingPage() {
        try {
            this.b.B();
        }
        catch (Exception ex) {
            hf.a((byte)1, InMobiNative.a, "reportAdClickAndOpenLandingPage failed; SDK encountered unexpected error");
            fv.a().a(new gv(ex));
        }
    }
    
    public final boolean isReady() {
        return this.b.l();
    }
    
    @Deprecated
    public final JSONObject getAdMetaInfo() {
        return this.b.D();
    }
    
    public final void setExtras(final Map<String, String> c) {
        if (c != null) {
            ha.a(c.get("tp"));
            ha.b(c.get("tp-ver"));
        }
        this.h.c = c;
    }
    
    public final void setKeywords(final String b) {
        this.h.b = b;
    }
    
    public final void setContentUrl(final String f) {
        this.h.f = f;
    }
    
    public final void destroy() {
        try {
            final View view;
            if ((view = ((this.f == null) ? null : this.f.get())) != null) {
                ((ViewGroup)view).removeAllViews();
            }
            this.b.o();
            this.d = null;
            this.e = null;
            this.g = false;
        }
        catch (Exception ex) {
            hf.a((byte)1, InMobiNative.a, "Failed to destroy ad; SDK encountered an unexpected error");
            fv.a().a(new gv(ex));
        }
    }
    
    @Deprecated
    public final String getCreativeId() {
        return this.b.C();
    }
    
    static {
        a = InMobiNative.class.getSimpleName();
    }
    
    public static final class NativeCallbacks extends PublisherCallbacks
    {
        private WeakReference<InMobiNative> a;
        private boolean b;
        
        NativeCallbacks(@NonNull final InMobiNative referent) {
            this.b = true;
            this.a = new WeakReference<InMobiNative>(referent);
        }
        
        @Override
        public final byte getType() {
            return 0;
        }
        
        final void a() {
            this.b = false;
        }
        
        @Override
        public final void onAdFetchSuccessful(@NonNull final AdMetaInfo adMetaInfo) {
            final InMobiNative inMobiNative;
            if ((inMobiNative = this.a.get()) == null) {
                hf.a((byte)1, InMobiNative.a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (inMobiNative.d != null) {
                inMobiNative.d.onAdReceived(inMobiNative);
            }
            if (inMobiNative.d != null) {
                inMobiNative.d.onAdFetchSuccessful(inMobiNative, adMetaInfo);
            }
        }
        
        @Override
        public final void onAdFetchFailed(@NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
            this.onAdLoadFailed(inMobiAdRequestStatus);
        }
        
        @Override
        public final void onAdLoadSucceeded(@NonNull final AdMetaInfo adMetaInfo) {
            final InMobiNative inMobiNative;
            if ((inMobiNative = this.a.get()) == null) {
                hf.a((byte)1, InMobiNative.a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (!this.b) {
                this.b = true;
                if (inMobiNative.d != null) {
                    inMobiNative.d.onAdLoadSucceeded(inMobiNative);
                }
                if (inMobiNative.d != null) {
                    inMobiNative.d.onAdLoadSucceeded(inMobiNative, adMetaInfo);
                }
            }
        }
        
        @Override
        public final void onAdLoadFailed(@NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
            final InMobiNative inMobiNative;
            if ((inMobiNative = this.a.get()) == null) {
                hf.a((byte)1, InMobiNative.a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (!this.b) {
                this.b = true;
                if (inMobiNative.d != null) {
                    inMobiNative.d.onAdLoadFailed(inMobiNative, inMobiAdRequestStatus);
                }
            }
        }
        
        @Override
        public final void onAdWillDisplay() {
            final InMobiNative inMobiNative;
            if ((inMobiNative = this.a.get()) == null) {
                hf.a((byte)1, InMobiNative.a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (inMobiNative.j != null) {
                inMobiNative.j.onActionRequired(inMobiNative);
            }
            if (inMobiNative.d != null) {
                inMobiNative.d.onAdFullScreenWillDisplay(inMobiNative);
            }
        }
        
        @Override
        public final void onAdDisplayed(@NonNull final AdMetaInfo adMetaInfo) {
            final InMobiNative inMobiNative;
            if ((inMobiNative = this.a.get()) == null) {
                hf.a((byte)1, InMobiNative.a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (inMobiNative.d != null) {
                inMobiNative.d.onAdFullScreenDisplayed(inMobiNative);
            }
        }
        
        @Override
        public final void onAdDismissed() {
            final InMobiNative inMobiNative;
            if ((inMobiNative = this.a.get()) == null) {
                hf.a((byte)1, InMobiNative.a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (inMobiNative.d != null) {
                inMobiNative.d.onAdFullScreenDismissed(inMobiNative);
            }
        }
        
        @Override
        public final void onAdClicked(@NonNull final Map<Object, Object> map) {
            final InMobiNative inMobiNative;
            if ((inMobiNative = this.a.get()) == null) {
                hf.a((byte)1, InMobiNative.a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (inMobiNative.d != null) {
                inMobiNative.d.onAdClicked(inMobiNative);
            }
        }
        
        @Override
        public final void onUserLeftApplication() {
            final InMobiNative inMobiNative;
            if ((inMobiNative = this.a.get()) == null) {
                hf.a((byte)1, InMobiNative.a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (inMobiNative.j != null) {
                inMobiNative.j.onActionRequired(inMobiNative);
            }
            if (inMobiNative.d != null) {
                inMobiNative.d.onUserWillLeaveApplication(inMobiNative);
            }
        }
        
        @Override
        public final void onAdImpressed() {
            final InMobiNative inMobiNative;
            if ((inMobiNative = this.a.get()) == null) {
                hf.a((byte)1, InMobiNative.a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (inMobiNative.d != null) {
                inMobiNative.d.onAdImpressed(inMobiNative);
            }
        }
        
        @Override
        public final void onVideoCompleted() {
            final InMobiNative inMobiNative;
            if ((inMobiNative = this.a.get()) == null) {
                hf.a((byte)1, InMobiNative.a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (inMobiNative.e != null) {
                inMobiNative.e.onVideoCompleted(inMobiNative);
            }
        }
        
        @Override
        public final void onVideoSkipped() {
            final InMobiNative inMobiNative;
            if ((inMobiNative = this.a.get()) == null) {
                hf.a((byte)1, InMobiNative.a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (inMobiNative.e != null) {
                inMobiNative.e.onVideoSkipped(inMobiNative);
            }
        }
        
        @Override
        public final void onAudioStateChanged(final boolean b) {
            final InMobiNative inMobiNative;
            if ((inMobiNative = this.a.get()) == null) {
                hf.a((byte)1, InMobiNative.a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (inMobiNative.e != null) {
                inMobiNative.e.onAudioStateChanged(inMobiNative, b);
            }
        }
        
        @Override
        public final void onRequestPayloadCreated(final byte[] array) {
            final InMobiNative inMobiNative;
            if ((inMobiNative = this.a.get()) == null) {
                hf.a((byte)1, InMobiNative.a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (inMobiNative.d != null) {
                inMobiNative.d.onRequestPayloadCreated(array);
            }
        }
        
        @Override
        public final void onRequestPayloadCreationFailed(final InMobiAdRequestStatus inMobiAdRequestStatus) {
            final InMobiNative inMobiNative;
            if ((inMobiNative = this.a.get()) == null) {
                hf.a((byte)1, InMobiNative.a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            if (inMobiNative.d != null) {
                inMobiNative.d.onRequestPayloadCreationFailed(inMobiAdRequestStatus);
            }
        }
    }
    
    public interface LockScreenListener
    {
        void onActionRequired(final InMobiNative p0);
    }
}
