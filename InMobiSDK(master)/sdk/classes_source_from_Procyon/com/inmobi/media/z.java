// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.WorkerThread;
import java.util.Map;
import java.util.HashMap;
import com.inmobi.ads.InMobiAdRequestStatus;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

final class z extends ai<byte[]>
{
    @NonNull
    private final WeakReference<t> a;
    @Nullable
    private bf b;
    private final long c;
    
    z(@NonNull final t referent, final long c) {
        super(referent, (byte)2);
        this.a = new WeakReference<t>(referent);
        this.c = c;
    }
    
    @Override
    public final void b() {
        super.b();
        final t t;
        if ((t = this.a.get()) == null) {
            return;
        }
        final t.a p;
        if ((p = t.p()) != null) {
            p.b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY));
        }
    }
    
    @WorkerThread
    @Override
    public final void a() {
        final t t;
        if ((t = this.a.get()) == null || t.n == null) {
            this.b(null);
            return;
        }
        if (t.p() == null) {
            this.b(null);
            return;
        }
        try {
            final bz n;
            final bz bz = n = t.n;
            bz.b = new ca(n.a);
            final cc c = n.b.a.C();
            final HashMap<String, String> hashMap;
            (hashMap = new HashMap<String, String>()).put("h-user-agent", gz.i());
            c.c(hashMap);
            c.a();
            if (((fs)fg.a("root", gz.f(), null)).i()) {
                throw new bf(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.MONETIZATION_DISABLED), (byte)9);
            }
            if (!c.t) {
                throw new bf(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.GDPR_COMPLIANCE_ENFORCED), (byte)21);
            }
            this.b(c.g().getBytes());
        }
        catch (bf b) {
            this.b = b;
            this.b(null);
        }
    }
}
