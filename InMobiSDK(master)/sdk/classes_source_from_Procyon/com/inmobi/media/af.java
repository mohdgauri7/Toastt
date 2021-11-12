// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

final class af extends ai<Byte>
{
    @NonNull
    private final WeakReference<ae> a;
    
    af(@NonNull final ae referent) {
        super(referent, (byte)6);
        this.a = new WeakReference<ae>(referent);
    }
    
    @Override
    public final void b() {
        super.b();
        final ae ae;
        if ((ae = this.a.get()) == null) {
            return;
        }
        final t.a p;
        if ((p = ae.p()) != null) {
            p.a(ae, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY));
        }
    }
    
    @Override
    public final void a() {
        final ae ae;
        if ((ae = this.a.get()) == null) {
            this.b((Byte)13);
            return;
        }
        final ae ae2 = ae;
        this.b(ae2.e(ae2.p()));
    }
}
