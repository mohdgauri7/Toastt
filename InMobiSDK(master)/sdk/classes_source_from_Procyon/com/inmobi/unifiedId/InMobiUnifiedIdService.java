// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.unifiedId;

import com.inmobi.media.iv;
import androidx.annotation.WorkerThread;
import com.inmobi.media.iw;
import com.inmobi.media.iy;
import org.json.JSONObject;
import com.inmobi.media.ix;
import java.util.Map;
import java.util.HashMap;
import com.inmobi.media.gw;
import com.inmobi.ads.exceptions.SdkNotInitializedException;
import com.inmobi.media.gz;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicBoolean;

public final class InMobiUnifiedIdService
{
    private static final String a;
    private static final AtomicBoolean b;
    
    private InMobiUnifiedIdService() {
    }
    
    @NonNull
    @VisibleForTesting(otherwise = 5)
    public static AtomicBoolean getIsPushCalled() {
        return InMobiUnifiedIdService.b;
    }
    
    public static void push(@Nullable final InMobiUserDataModel inMobiUserDataModel) {
        if (!gz.a()) {
            throw new SdkNotInitializedException(InMobiUnifiedIdService.a);
        }
        gz.a(new Runnable() {
            @Override
            public final void run() {
                InMobiUnifiedIdService.a(inMobiUserDataModel);
            }
        });
    }
    
    public static void fetchUnifiedIds(@Nullable final InMobiUnifiedIdInterface inMobiUnifiedIdInterface) {
        if (!gz.a()) {
            throw new SdkNotInitializedException(InMobiUnifiedIdService.a);
        }
        gz.a(new Runnable() {
            @Override
            public final void run() {
                InMobiUnifiedIdService.a(inMobiUnifiedIdInterface);
            }
        });
    }
    
    @WorkerThread
    public static void a(final InMobiUnifiedIdInterface inMobiUnifiedIdInterface) {
        gw.a().a("FetchApiInvoked", new HashMap<String, Object>());
        if (ix.c()) {
            ix.a(inMobiUnifiedIdInterface, null, new Error("UnifiedId Service not enabled, please connect with your respective partner manager"));
            return;
        }
        if (ix.b()) {
            ix.a(inMobiUnifiedIdInterface, null, new Error("User has opted out for tracking"));
            return;
        }
        synchronized (iy.class) {
            if (iy.c()) {
                iy.a(inMobiUnifiedIdInterface);
            }
            else {
                final JSONObject a;
                if (!ix.b(a = iw.a()) && ix.a(a)) {
                    iy.a(inMobiUnifiedIdInterface);
                }
                else if (inMobiUnifiedIdInterface != null) {
                    if (ix.b(a)) {
                        if (InMobiUnifiedIdService.b.get()) {
                            iy.a(inMobiUnifiedIdInterface);
                        }
                        else {
                            ix.a(inMobiUnifiedIdInterface, null, new Error("Push api needs to called prior to fetch"));
                        }
                    }
                    else {
                        ix.a(inMobiUnifiedIdInterface, a, null);
                    }
                }
            }
        }
    }
    
    public static void reset() {
        if (!gz.a()) {
            throw new SdkNotInitializedException(InMobiUnifiedIdService.a);
        }
        gz.a(new Runnable() {
            @Override
            public final void run() {
                InMobiUnifiedIdService.a();
            }
        });
    }
    
    static /* synthetic */ void a(final InMobiUserDataModel inMobiUserDataModel) {
        if (!ix.c() && !ix.b() && (!iv.b(inMobiUserDataModel) || !InMobiUnifiedIdService.b.get())) {
            iv.a(inMobiUserDataModel);
            InMobiUnifiedIdService.b.set(true);
            iy.a();
        }
    }
    
    static /* synthetic */ void a() {
        InMobiUnifiedIdService.b.set(false);
        iv.a((InMobiUserDataModel)null);
        iy.b();
        iw.d();
    }
    
    static {
        a = InMobiUnifiedIdService.class.getSimpleName();
        b = new AtomicBoolean();
    }
}
