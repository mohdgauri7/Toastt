// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import java.util.Map;
import java.util.HashMap;
import android.os.SystemClock;
import com.inmobi.ads.InMobiAdRequestStatus;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

final class s extends ai<ar>
{
    @NonNull
    private final WeakReference<t> a;
    @Nullable
    private bf b;
    
    s(@NonNull final t referent) {
        super(referent, (byte)0);
        this.a = new WeakReference<t>(referent);
    }
    
    @Override
    public final void b() {
        super.b();
        final t t;
        if ((t = this.a.get()) == null) {
            return;
        }
        final t t2 = t;
        t2.a(t2.i(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY), (byte)56);
    }
    
    @WorkerThread
    @Override
    public final void a() {
        final t t;
        if ((t = this.a.get()) == null) {
            this.b = new bf(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (byte)0);
            this.b(null);
            return;
        }
        if (!((fs)fg.a("root", gz.f(), null)).i()) {
            t.e = System.currentTimeMillis();
            try {
                final as r = t.r();
                final cc c = t.C();
                final Integer w = t.w();
                final cc cc = c;
                final as as = r;
                if (w != null && SystemClock.elapsedRealtime() - as.c < w * 1000) {
                    throw new bf(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.EARLY_REFRESH_REQUEST), (byte)16);
                }
                final as as2 = as;
                final cc cc2 = cc;
                final as as3 = as2;
                com.inmobi.media.as.a(cc2);
                as3.c = SystemClock.elapsedRealtime();
                final cd a;
                if ((a = new cb(cc2).a()) == null) {
                    final HashMap<String, Object> hashMap;
                    (hashMap = new HashMap<String, Object>()).put("errorCode", 7);
                    as3.a(hashMap);
                    throw new bf(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (byte)0);
                }
                if (null == a.a.a) {
                    this.b(as3.a(a, cc2.e));
                    return;
                }
                final HashMap<String, Object> hashMap2;
                (hashMap2 = new HashMap<String, Object>()).put("errorCode", String.valueOf(a.a.a.a));
                as3.a(hashMap2);
                throw new bf(a.b, (byte)0);
            }
            catch (bf b) {
                final String a2 = com.inmobi.media.t.a;
                this.b = b;
                this.b(null);
                return;
            }
        }
        hf.a((byte)1, com.inmobi.media.t.a, "SDK will not perform this load operation as monetization has been disabled. Please contact InMobi for further info.");
        this.b = new bf(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.MONETIZATION_DISABLED), (byte)9);
        this.b(null);
    }
}
