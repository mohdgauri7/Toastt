// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.UiThread;
import org.json.JSONObject;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import com.inmobi.ads.InMobiAdRequestStatus;

final class u extends ai<InMobiAdRequestStatus>
{
    @NonNull
    private final WeakReference<t> a;
    @NonNull
    private final JSONObject b;
    
    u(@NonNull final t referent, @NonNull final JSONObject b) {
        super(referent, (byte)4);
        this.a = new WeakReference<t>(referent);
        this.b = b;
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
            p.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY));
        }
    }
    
    @Override
    public final void a() {
        final t t = this.a.get();
        final InMobiAdRequestStatus inMobiAdRequestStatus = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR);
        if (t == null || t.p == null) {
            this.b(inMobiAdRequestStatus);
            return;
        }
        try {
            t.p.a(this.b, t.c);
            this.b(null);
        }
        catch (Exception ex) {
            final String a = com.inmobi.media.t.a;
            this.b(inMobiAdRequestStatus);
        }
    }
}
