// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.ads;

import android.view.View;
import androidx.annotation.IntRange;
import android.os.Build;
import com.inmobi.media.ho;
import android.view.ViewTreeObserver;
import com.inmobi.media.ha;
import java.util.Map;
import android.os.SystemClock;
import org.json.JSONObject;
import android.os.Handler;
import androidx.annotation.UiThread;
import com.inmobi.ads.exceptions.InvalidPlacementIdException;
import com.inmobi.ads.exceptions.SdkNotInitializedException;
import com.inmobi.media.gz;
import com.inmobi.media.hf;
import com.inmobi.ads.controllers.PublisherCallbacks;
import com.inmobi.media.b;
import android.util.AttributeSet;
import android.content.Context;
import androidx.annotation.NonNull;
import com.inmobi.media.bc;
import android.app.Activity;
import java.lang.ref.WeakReference;
import com.inmobi.media.c;
import com.inmobi.media.x;
import androidx.annotation.Nullable;
import com.inmobi.ads.listeners.BannerAdEventListener;
import android.widget.RelativeLayout;

public final class InMobiBanner extends RelativeLayout
{
    public static final String a;
    @Nullable
    public BannerAdEventListener b;
    public x c;
    private int f;
    private boolean g;
    @Nullable
    private c h;
    private int i;
    private int j;
    public AnimationType d;
    private long k;
    @Nullable
    private WeakReference<Activity> l;
    @NonNull
    private bc m;
    public a e;
    @NonNull
    private PreloadManager n;
    
    public InMobiBanner(@NonNull final Context context, final AttributeSet set) throws SdkNotInitializedException {
        super(context, set);
        this.g = true;
        this.i = 0;
        this.j = 0;
        this.d = AnimationType.ROTATE_HORIZONTAL_AXIS;
        this.k = 0L;
        this.m = new bc();
        this.e = new a(this);
        this.n = new PreloadManager() {
            private b b;
            
            {
                this.b = new b(InMobiBanner.this);
            }
            
            @Override
            public final void preload() {
                InMobiBanner.this.setEnableAutoRefresh(false);
                InMobiBanner.this.m.e = "NonAB";
                InMobiBanner.this.a(this.b, false);
            }
            
            @Override
            public final void load() {
                try {
                    InMobiBanner.this.c.n();
                }
                catch (IllegalStateException ex) {
                    hf.a((byte)1, InMobiBanner.a, ex.getMessage());
                    if (InMobiBanner.this.b != null) {
                        InMobiBanner.this.b.onAdLoadFailed(InMobiBanner.this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
                    }
                }
            }
        };
        if (!gz.b()) {
            throw new SdkNotInitializedException(InMobiBanner.a);
        }
        if (context instanceof Activity) {
            this.l = new WeakReference<Activity>((Activity)context);
        }
        this.c = new x();
        final String attributeValue = set.getAttributeValue("http://schemas.android.com/apk/lib/com.inmobi.ads", "placementId");
        final String attributeValue2 = set.getAttributeValue("http://schemas.android.com/apk/lib/com.inmobi.ads", "refreshInterval");
        if (attributeValue != null) {
            final long a;
            if ((a = a(attributeValue)) == Long.MIN_VALUE) {
                throw new InvalidPlacementIdException();
            }
            this.m.a = a;
        }
        this.a(this.getContext());
        this.f = this.c.s();
        this.h = new c(this);
        if (attributeValue2 != null) {
            try {
                this.setRefreshInterval(Integer.parseInt(attributeValue2.trim()));
            }
            catch (NumberFormatException ex) {
                hf.a((byte)1, InMobiBanner.a, "Refresh interval value supplied in XML layout is not valid. Falling back to default value.");
            }
        }
    }
    
    private static long a(@NonNull final String obj) {
        long long1 = Long.MIN_VALUE;
        try {
            final StringBuilder sb;
            if ("plid-".equalsIgnoreCase((sb = new StringBuilder(obj.trim())).substring(0, 5))) {
                long1 = Long.parseLong(sb.substring(5, sb.length()).trim());
            }
            else {
                hf.a((byte)1, InMobiBanner.a, "Placement id value supplied in XML layout is not valid. Please make sure placement id is in plid-0123456789 format.");
                hf.a((byte)1, InMobiBanner.a, "Invalid Placement id: ".concat(String.valueOf(obj)));
            }
        }
        catch (NumberFormatException ex) {
            hf.a((byte)1, InMobiBanner.a, "Placement id value supplied in XML layout is not valid. Banner creation failed.");
            hf.a((byte)1, InMobiBanner.a, "Invalid Placement id: ".concat(String.valueOf(obj)));
        }
        catch (StringIndexOutOfBoundsException ex2) {
            hf.a((byte)1, InMobiBanner.a, "Placement id value supplied in XML layout is not valid. Please make sure placement id is in plid-0123456789 format.");
            hf.a((byte)1, InMobiBanner.a, "Invalid Placement id: ".concat(String.valueOf(obj)));
        }
        return long1;
    }
    
    public InMobiBanner(@NonNull final Context context, final long a) throws SdkNotInitializedException {
        super(context);
        this.g = true;
        this.i = 0;
        this.j = 0;
        this.d = AnimationType.ROTATE_HORIZONTAL_AXIS;
        this.k = 0L;
        this.m = new bc();
        this.e = new a(this);
        this.n = new PreloadManager() {
            private b b = new b(InMobiBanner.this);
            
            @Override
            public final void preload() {
                InMobiBanner.this.setEnableAutoRefresh(false);
                InMobiBanner.this.m.e = "NonAB";
                InMobiBanner.this.a(this.b, false);
            }
            
            @Override
            public final void load() {
                try {
                    InMobiBanner.this.c.n();
                }
                catch (IllegalStateException ex) {
                    hf.a((byte)1, InMobiBanner.a, ex.getMessage());
                    if (InMobiBanner.this.b != null) {
                        InMobiBanner.this.b.onAdLoadFailed(InMobiBanner.this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
                    }
                }
            }
        };
        if (gz.b()) {
            if (context instanceof Activity) {
                this.l = new WeakReference<Activity>((Activity)context);
            }
            this.c = new x();
            this.m.a = a;
            this.a(context);
            this.f = this.c.s();
            this.h = new c(this);
            return;
        }
        throw new SdkNotInitializedException(InMobiBanner.a);
    }
    
    private boolean a(final boolean b) {
        if (b && this.b == null) {
            hf.a((byte)1, InMobiBanner.a, "Listener supplied is null, Ignoring your call.");
            return false;
        }
        return true;
    }
    
    public final void getSignals() {
        if (this.a(true)) {
            if (this.b("getSignals()")) {
                this.a(this.getContext());
                this.setEnableAutoRefresh(false);
                this.c.b(this.e);
                return;
            }
            this.e.onRequestPayloadCreationFailed(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.CONFIGURATION_ERROR));
        }
    }
    
    @NonNull
    public final PreloadManager getPreloadManager() {
        return this.n;
    }
    
    public final void load(final byte[] array) {
        if (this.a(false)) {
            if (this.b("load(byte[])")) {
                this.m.e = "AB";
                this.a(this.getContext());
                this.c.a(array, this.e);
                return;
            }
            this.c.a((byte)86);
            this.e.onAdLoadFailed(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.CONFIGURATION_ERROR));
        }
    }
    
    @UiThread
    public final void load() {
        if (this.a(false)) {
            this.m.e = "NonAB";
            this.a(this.e, false);
        }
    }
    
    public final void a(@NonNull final PublisherCallbacks publisherCallbacks, final boolean b) {
        try {
            this.c.x();
            if (b) {
                this.m.e = "NonAB";
            }
            this.a(this.getContext());
            if (this.c.t()) {
                this.c.b((byte)15);
                if (this.b != null) {
                    this.b.onAdLoadFailed(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_ACTIVE));
                }
                hf.a((byte)1, InMobiBanner.a, "An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad.");
                return;
            }
            if (!this.b("load")) {
                this.c.a((byte)86);
                this.c.a(this.c.m(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REQUEST_INVALID));
                return;
            }
            if (!this.a()) {
                new Handler().postDelayed((Runnable)new Runnable() {
                    @Override
                    public final void run() {
                        try {
                            if (InMobiBanner.this.a()) {
                                InMobiBanner.this.f();
                                if (InMobiBanner.this.d()) {
                                    InMobiBanner.this.c.a(publisherCallbacks, InMobiBanner.this.getFrameSizeString(), b);
                                }
                            }
                            else {
                                hf.a((byte)1, InMobiBanner.a, "The height or width of the banner can not be determined");
                                InMobiBanner.this.c.a((byte)86);
                                InMobiBanner.this.c.a(InMobiBanner.this.c.m(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
                            }
                        }
                        catch (Exception ex) {
                            InMobiBanner.this.c.a((byte)87);
                            hf.a((byte)1, InMobiBanner.a, "SDK encountered unexpected error while loading an ad");
                            InMobiBanner.a;
                        }
                    }
                }, 200L);
                return;
            }
            this.f();
            if (this.d()) {
                this.c.a(publisherCallbacks, this.getFrameSizeString(), b);
            }
        }
        catch (Exception ex) {
            this.c.a((byte)87);
            hf.a((byte)1, InMobiBanner.a, "Unable to load ad; SDK encountered an unexpected error");
        }
    }
    
    private boolean b(@NonNull final String obj) {
        if (!this.a()) {
            if (this.getLayoutParams() == null) {
                hf.a((byte)1, InMobiBanner.a, "The layout params of the banner must be set before calling " + obj + " or call setBannerSize(int widthInDp, int heightInDp) before " + obj);
                return false;
            }
            if (this.getLayoutParams().width == -2 || this.getLayoutParams().height == -2) {
                hf.a((byte)1, InMobiBanner.a, "The height or width of a Banner ad can't be WRAP_CONTENT or call setBannerSize(int widthInDp, int heightInDp) before ".concat(String.valueOf(obj)));
                return false;
            }
            this.e();
        }
        return true;
    }
    
    @UiThread
    public final void load(@NonNull final Context context) {
        if (this.a(false)) {
            if (context instanceof Activity) {
                this.l = new WeakReference<Activity>((Activity)context);
            }
            else {
                this.l = null;
            }
            this.m.e = "NonAB";
            this.a(this.e, false);
        }
    }
    
    @Deprecated
    public final JSONObject getAdMetaInfo() {
        return this.c.D();
    }
    
    private boolean d() {
        if (this.k != 0L && !this.c.a(this.k)) {
            return false;
        }
        this.k = SystemClock.elapsedRealtime();
        return true;
    }
    
    public final void setExtras(final Map<String, String> c) {
        if (c != null) {
            ha.a(c.get("tp"));
            ha.b(c.get("tp-ver"));
        }
        this.m.c = c;
    }
    
    public final void setKeywords(final String b) {
        this.m.b = b;
    }
    
    public final void setContentUrl(@NonNull final String f) {
        this.m.f = f;
    }
    
    public final void setListener(@NonNull final BannerAdEventListener b) {
        this.b = b;
    }
    
    public final void setEnableAutoRefresh(final boolean g) {
        try {
            if (this.g == g) {
                return;
            }
            this.g = g;
            if (this.g) {
                this.b();
                return;
            }
            this.f();
        }
        catch (Exception ex) {
            hf.a((byte)1, InMobiBanner.a, "Unable to setup auto-refresh on the ad; SDK encountered an unexpected error");
        }
    }
    
    public final void setRefreshInterval(final int n) {
        try {
            this.m.e = "NonAB";
            this.a(this.getContext());
            this.f = this.c.a(n, this.f);
        }
        catch (Exception ex) {
            hf.a((byte)1, InMobiBanner.a, "Unable to set refresh interval for the ad; SDK encountered an unexpected error");
        }
    }
    
    public final void setAnimationType(final AnimationType d) {
        this.d = d;
    }
    
    public final void disableHardwareAcceleration() {
        this.m.d = true;
    }
    
    protected final void onAttachedToWindow() {
        try {
            super.onAttachedToWindow();
            this.c.v();
            this.e();
            if (!this.a()) {
                this.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new ViewTreeObserver.OnGlobalLayoutListener() {
                    public final void onGlobalLayout() {
                        try {
                            InMobiBanner.this.i = ho.b(InMobiBanner.this.getMeasuredWidth());
                            InMobiBanner.this.j = ho.b(InMobiBanner.this.getMeasuredHeight());
                            if (InMobiBanner.this.a()) {
                                if (Build.VERSION.SDK_INT >= 16) {
                                    InMobiBanner.this.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
                                    return;
                                }
                                InMobiBanner.this.getViewTreeObserver().removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
                            }
                        }
                        catch (Exception ex) {
                            hf.a((byte)1, InMobiBanner.a, "InMobiBanner$1.onGlobalLayout() handler threw unexpected error");
                            InMobiBanner.a;
                        }
                    }
                });
            }
            this.b();
            if (Build.VERSION.SDK_INT >= 29) {
                ho.a(this.getContext(), this.getRootWindowInsets());
            }
        }
        catch (Exception ex) {
            hf.a((byte)1, InMobiBanner.a, "InMobiBanner#onAttachedToWindow() handler threw unexpected error");
        }
    }
    
    protected final void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            this.f();
            this.c.u();
        }
        catch (Exception ex) {
            hf.a((byte)1, InMobiBanner.a, "InMobiBanner.onDetachedFromWindow() handler threw unexpected error");
        }
    }
    
    private void e() {
        if (this.getLayoutParams() != null) {
            this.i = ho.b(this.getLayoutParams().width);
            this.j = ho.b(this.getLayoutParams().height);
        }
    }
    
    public final void setBannerSize(@IntRange(from = 1L) final int i, @IntRange(from = 1L) final int j) {
        this.i = i;
        this.j = j;
    }
    
    final boolean a() {
        return this.i > 0 && this.j > 0;
    }
    
    @NonNull
    private String getFrameSizeString() {
        return this.i + "x" + this.j;
    }
    
    protected final void onVisibilityChanged(@NonNull final View view, final int n) {
        try {
            super.onVisibilityChanged(view, n);
            if (n == 0) {
                this.b();
                return;
            }
            this.f();
        }
        catch (Exception ex) {
            hf.a((byte)1, InMobiBanner.a, "InMobiBanner$1.onVisibilityChanged() handler threw unexpected error");
        }
    }
    
    public final void onWindowFocusChanged(final boolean b) {
        try {
            super.onWindowFocusChanged(b);
            if (b) {
                this.b();
                return;
            }
            this.f();
        }
        catch (Exception ex) {
            hf.a((byte)1, InMobiBanner.a, "InMobiBanner$1.onWindowFocusChanged() handler threw unexpected error");
        }
    }
    
    private void a(@NonNull final Context context) {
        this.c.a(context, this.m, this.getFrameSizeString());
        this.f = this.c.a(this.f, this.f);
    }
    
    public final void b() {
        if (!this.isShown() || !this.hasWindowFocus()) {
            return;
        }
        if (this.h != null) {
            this.h.removeMessages(1);
        }
        if (this.c.l() && this.g && this.h != null) {
            this.h.sendEmptyMessageDelayed(1, (long)(this.f * 1000));
        }
    }
    
    private void f() {
        if (this.h != null) {
            this.h.removeMessages(1);
        }
    }
    
    public final void resume() {
        try {
            if (this.l == null) {
                this.c.q();
            }
        }
        catch (Exception ex) {
            hf.a((byte)1, "InMobi", "Could not resume ad; SDK encountered an unexpected error");
        }
    }
    
    public final void pause() {
        try {
            if (this.l == null) {
                this.c.r();
            }
        }
        catch (Exception ex) {
            hf.a((byte)1, "InMobi", "Could not pause ad; SDK encountered an unexpected error");
        }
    }
    
    @Deprecated
    public final String getCreativeId() {
        return this.c.C();
    }
    
    @UiThread
    public final void destroy() {
        this.f();
        this.removeAllViews();
        this.c.w();
        this.b = null;
    }
    
    static {
        a = InMobiBanner.class.getSimpleName();
    }
    
    public enum AnimationType
    {
        ANIMATION_OFF, 
        ROTATE_HORIZONTAL_AXIS, 
        ANIMATION_ALPHA, 
        ROTATE_VERTICAL_AXIS;
    }
    
    public static final class a extends b
    {
        a(@NonNull final InMobiBanner inMobiBanner) {
            super(inMobiBanner);
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
                    ((InMobiBanner)adMetaInfo).c.n();
                }
                catch (IllegalStateException ex) {
                    hf.a((byte)1, InMobiBanner.a, ex.getMessage());
                    if (((InMobiBanner)adMetaInfo).b != null) {
                        ((InMobiBanner)adMetaInfo).b.onAdLoadFailed((InMobiBanner)adMetaInfo, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
                    }
                }
            }
        }
        
        @Override
        public final void onAdFetchFailed(@NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
            final InMobiBanner inMobiBanner;
            if ((inMobiBanner = this.a.get()) == null) {
                return;
            }
            if (inMobiBanner.b != null) {
                inMobiBanner.b.onAdLoadFailed(inMobiBanner, inMobiAdRequestStatus);
            }
            inMobiBanner.b();
        }
    }
}
